package com.example.tolaotesanya.fetcheddatasample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button clickMe;
    public static TextView fetchedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMe = findViewById(R.id.button);
        fetchedData = findViewById(R.id.ftext);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //new object
                FetchJsonData fetchJsonData = new FetchJsonData();
                fetchJsonData.execute();

            }
        });
    }
}
