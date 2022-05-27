package ru.mirea.tereshkin.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import java.text.BreakIterator;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private NewLooper newLooper;
    private Message message;
    EditText age_edit;
    EditText work_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText age_edit = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText work_edit = (EditText) findViewById(R.id.editTextTextPersonName2);
        NewLooper newLooper = new NewLooper();
        newLooper.start();
    }
    public void onClick(View view){
        Message message = new Message();
        Bundle bundle = new Bundle();
        int age = Integer.parseInt(age_edit.getText().toString());
        String work = work_edit.getText().toString();
        bundle.putInt("AGE", age);
        bundle.putString("WORK", work);
        message.setData(bundle);
        if (newLooper != null) {
            newLooper.handler.sendMessage(message);
        }
    }
}