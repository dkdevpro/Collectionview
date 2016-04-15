package com.din.collectionview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dineshkumar.m on 19/02/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Customized Listview");
    }
}
