package com.example.java2.downloadfisier;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by java2 on 12/5/2016.
 */

public class Broadcast extends BroadcastReceiver {
    String filepath;
    int result;

    @Override
    public void onReceive(Context context, Intent intent) {
        filepath = intent.getStringExtra("filepath");
        result = intent.getIntExtra("result", -1);
        if(result== Activity.RESULT_OK){
            Toast.makeText(context, "Download completed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "ERRROOORRR", Toast.LENGTH_SHORT).show();
        }

    }
}
