package com.example.java.singlescreenapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the map button is clicked.
     */
    public void submitMap(View view) {
        // FIND BUSINESS IN GOOGLE MAPS:
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=YUMMY+WAKAME");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    /**
     * This method is called when the URL button is clicked.
     */
    public void submitURL(View view) {
        // GO TO WEBSITE IN BROWSER:
        String url = "http://www.yummy-wakame.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    /**
     * This method is called when the phone button is clicked.
     */
    public void submitPhone(View view) {
        // SEND TO PHONE:
        String phone = "+18559999866";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }

    /**
     * This method is called when the email button is clicked.
     */
    public void submitEmail(View view) {
        // SEND EMAIL:
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:olivia@yummy-wakame.com")); // only email apps should handle this
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}