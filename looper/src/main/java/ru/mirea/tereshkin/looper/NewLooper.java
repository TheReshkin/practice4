package ru.mirea.tereshkin.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class NewLooper extends Thread {
    private int number = 0;
    Handler handler;

    @SuppressLint("HandlerLeak")
    @Override
    public void run() {
        Log.d("NewLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                int age = msg.getData().getInt("AGE");
                String work = msg.getData().getString("WORK");
                try {
                    Thread.sleep(age);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("NewLooper", "age" + ": " + age+"\n"+ "Work" + ": "+work);
                number++;
            }
        };
        Looper.loop();
    }
}
