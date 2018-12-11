package com.example.tolaotesanya.fetcheddatasample;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tolaotesanya on 11/12/2018.
 */

public class FetchJsonData extends AsyncTask<Void, Void, Void> {

    String data = "";
    String dataParsed = "";
    String dataSingleParsed = "";

    //Background thread
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            //create url - online json file created using myjson : https://api.myjson.com/bins/113yy4
            URL url = new URL("https://api.myjson.com/bins/113yy4");
            //create a connection / open connection to the url link above.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //create an inputStream
            InputStream inputStream = httpURLConnection.getInputStream();
            //create a bufferReader to read data from inputStream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while(line != null)
            {
                //will read each line from the json file
                line = bufferedReader.readLine();
                data = data + line;
            }

            //for Json file
            JSONArray JA = new JSONArray(data);
            for(int i = 0; i < JA.length(); i++)
            {
                //use listview instead of the beloe shortcut
                JSONObject jsonObject = (JSONObject) JA.get(i);
                dataSingleParsed = "Name: " + jsonObject.get("name") + "\n" +
                                    "Hobbies: " + jsonObject.get("hobbits") + "\n" +
                                    "Age: " + jsonObject.get("age") + "\n" +
                                    "Country: " + jsonObject.get("country") + "\n";

                dataParsed = dataParsed + dataSingleParsed + "\n";
            }




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Can change the UI in onPost but not in doInBBackground // onPost is the UI thread
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.fetchedData.setText(this.dataParsed);
    }
}
