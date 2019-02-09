package com.example.prove05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_BOOK = "book";
    public static final String EXTRA_CHAPTER = "chapter";
    public static final String EXTRA_VERSE = "verse";
    SharedPreferences sharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     */
    public void launchAddScripture(View view) {

        Log.d(LOG_TAG, "Button Tapped!");

        EditText bookEdit    = findViewById(R.id.editBook);
        EditText chapterEdit = findViewById(R.id.editChapter);
        EditText verseEdit   = findViewById(R.id.editVerse);

        Log.d(LOG_TAG, "About to create intent with " + bookEdit.getText() + " "
                             + chapterEdit.getText() + ":" + verseEdit.getText());

        Intent scriptureIntent = new Intent(getBaseContext(), SecondActivity.class);
        scriptureIntent.putExtra(EXTRA_BOOK, bookEdit.getText().toString());
        scriptureIntent.putExtra(EXTRA_CHAPTER, chapterEdit.getText().toString());
        scriptureIntent.putExtra(EXTRA_VERSE, verseEdit.getText().toString());

        startActivity(scriptureIntent);
    }

    /**
     *
     */
    public void loadScripture(View view) {
        //SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        String book = SecondActivity.sharedPref.getString(EXTRA_BOOK,
                getResources().getString(R.string.default_value));
        String chapter = SecondActivity.sharedPref.getString(EXTRA_CHAPTER,
                getResources().getString(R.string.default_value));
        String verse = SecondActivity.sharedPref.getString(EXTRA_VERSE,
                getResources().getString(R.string.default_value));

        EditText bookEdit    = findViewById(R.id.editBook);
        EditText chapterEdit = findViewById(R.id.editChapter);
        EditText verseEdit   = findViewById(R.id.editVerse);

        bookEdit.setText(book);
        chapterEdit.setText(chapter);
        verseEdit.setText(verse);
    }
}
