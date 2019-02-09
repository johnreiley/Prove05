package com.example.prove05;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private Scripture scripture;
    public static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String book    = extras.getString(MainActivity.EXTRA_BOOK);
            String chapter = extras.getString(MainActivity.EXTRA_CHAPTER);
            String verse   = extras.getString(MainActivity.EXTRA_VERSE);

            scripture = new Scripture(book, chapter, verse);
        }

        Log.d(LOG_TAG, "Received intent with " + scripture.getScriptureReference());

        TextView scriptureView = findViewById(R.id.newScriptureView);
        scriptureView.setText(scripture.getScriptureReference());

    }

    /**
     *
     * @param view
     */
    public void saveScripture(View view) {
        sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString(MainActivity.EXTRA_BOOK,    scripture.getBook());
        editor.putString(MainActivity.EXTRA_CHAPTER, scripture.getChapter());
        editor.putString(MainActivity.EXTRA_VERSE,   scripture.getVerse());
        editor.apply();

        showSaveToast();
    }

    /**
     *
     */
    public void showSaveToast() {
        Context context = getApplicationContext();
        CharSequence text = "Scripture Saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}


