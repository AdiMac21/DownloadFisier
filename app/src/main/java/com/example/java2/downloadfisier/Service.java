package com.example.java2.downloadfisier;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by java2 on 12/5/2016.
 */

public class Service extends IntentService {
    int result;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Service() {
        super("bla");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String url = intent.getStringExtra("url");
        String filename = intent.getStringExtra("name");
        File file = new File(Environment.getExternalStorageDirectory(), filename);
        FileOutputStream fos = null;
        InputStream stream = null;
        try {
            URL url1 = new URL(url);
            stream = url1.openConnection().getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            fos = new FileOutputStream(file.getPath());
            int next = -1;
            while ((next = reader.read()) != -1) {
                fos.write(next);
            }
            result = Activity.RESULT_OK;
            fos.close();
            stream.close();
            publishResult(file.getPath(),result);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void publishResult(String path,int result) {
        Intent intent=new Intent("notif");
        intent.putExtra("filepath",path);
        intent.putExtra("result",result);
        sendBroadcast(intent);

    }
}
