package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyService extends Service {
    public MyService() {
    }

    private MyHandler myHandler;
    private Looper looper;

    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread thread = new HandlerThread("myThread", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();
        looper = thread.getLooper();
        myHandler = new MyHandler(looper, this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("hello 3395");
        Message msg = myHandler.obtainMessage();
        msg.arg1 = startId;
        myHandler.sendMessage(msg);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}