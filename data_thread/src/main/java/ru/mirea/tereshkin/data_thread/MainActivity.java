package ru.mirea.tereshkin.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View tvInfo = (TextView) findViewById(R.id.textView2);
    }

    public void onClickRunOnUI(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
            // задача запускается в потоке пользовательского интерфейса,
            // в зависимости от того где был запущен поток может выполняться сразу или добавляться в очередь
            View tvInfo = (TextView) findViewById(R.id.textView2);
            runOnUiThread(() -> ((TextView) tvInfo).setText("runOnUiThread"));
            }
        });
        thread.start();
    }


    public void onClickPostDelayed(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // добавляет задачу в очередь
                View tvInfo = (TextView) findViewById(R.id.textView2);
                tvInfo.post(() -> ((TextView) tvInfo).setText("post"));
            }
        });
        thread.start();
    }

    public void onClickPost(View view) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // добавляет задачу в очередь только по истесении переданного кол-ва времени
                View tvInfo = (TextView) findViewById(R.id.textView2);
                tvInfo.postDelayed(() -> ((TextView) tvInfo).setText("postDelayed"), 2000);
            }
        });
        thread.start();
    }
}