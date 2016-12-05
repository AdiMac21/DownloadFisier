package com.example.java2.downloadfisier;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Broadcast broadcast;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, Service.class);
        intent.putExtra("url", "http://online.enered.org/course/index.php");
        intent.putExtra("name", "fisier");
        startService(intent);
        broadcast = new Broadcast();
        intentFilter = new IntentFilter("notif");

    }

    @Override
    protected void onResume() {

        super.onResume();
        registerReceiver(broadcast, intentFilter);
    }
}
