package ru.mirea.tereshkin.loadermanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    EditText editText;
    TextView textView;
    private static final String TAG = "loaderManager";
    private static final int loaderId = 0001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        TextView textView = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {

        if (id == loaderId) {
           return new NewLoader(this, args);
        }
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        if (loader.getId() == loaderId) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(data);
        }
    }
    public void onClick(View view){
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        Bundle bundle = new Bundle();
        bundle.putString(NewLoader.ARG_WORD, ((TextView) editText).getText().toString());
        getSupportLoaderManager().initLoader(loaderId, bundle, this);
    }
}