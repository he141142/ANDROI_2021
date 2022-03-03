package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyHandler extends Handler {
    private Service service;

    public MyHandler(@NonNull Looper looper, Service service) {
        super(looper);
        this.service = service;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        try {
            FileOutputStream fos = service.openFileOutput("data.txt", Context.MODE_PRIVATE);
            BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fos));
            for (int i = 0; i <= 10; i++) {

                bf.write(String.valueOf(i));
                bf.newLine();
                Thread.sleep(2000);
            }
            bf.close();
            fos.close();
//            stopSelf();
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
