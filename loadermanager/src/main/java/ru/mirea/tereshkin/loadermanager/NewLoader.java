package ru.mirea.tereshkin.loadermanager;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NewLoader extends AsyncTaskLoader<String> {

    private String input_text;
    public static final String ARG_WORD = "arg";

    public NewLoader(@NonNull Context context, Bundle bundle) {
        super(context);
        if (bundle != null) {
            input_text = bundle.getString(ARG_WORD);
        }
    }

    @Override
    public void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return shuffleString(input_text);
    }

    public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        return shuffled;
    }
}
