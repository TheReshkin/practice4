package ru.mirea.tereshkin.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Текущий поток: " + mainThread.getName());
        // Меняем имя и выводим в текстовом поле
        mainThread.setName("MireaThread");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
    }
    public void onClick(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int numThread = counter++;
                Log.i("ThreadProject", "Запущен поток №"+ numThread);
                long endTime = System.currentTimeMillis() + 20*1000;
                while(System.currentTimeMillis() < endTime){
                    synchronized (this){
                        try{
                            wait(endTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Log.i("ThreadProject", "Выполнен поток №" + numThread);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

}