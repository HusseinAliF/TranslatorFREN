package com.mohammed.translatorfren;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Objects;

public class TranslatePage extends AppCompatActivity {

    EditText userText;
    Button submit;
    TextView translatedWord;
    String text;

    private HashMap<String, String[]> translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate_page);

        userText = findViewById(R.id.foreignWord);
        translatedWord = findViewById(R.id.arabicTranslated);
        submit = findViewById(R.id.submitTranslate);

        ValueClass value = new ValueClass();
        //This return key what user write..
        String languageKey = value.Dialog(this);
        //use languageKey to return String data from database as a String
        String data = "";//fill this with database data and the key is from user choose

        translate = ValueClass.gson.fromJson(data, ValueClass.typeToken);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text = userText.getText().toString();

                if (text.trim().matches("")) {
                    Toast.makeText(TranslatePage.this, "Enter valid input", Toast.LENGTH_SHORT).show();
                } else {
                    if (translate.get(text) == null) {
                        Toast.makeText(TranslatePage.this, "We cant get this word", Toast.LENGTH_SHORT).show();
                    } else {
                        for (String blank :translate.get(text)) {
                            translatedWord.append(blank);
                        }
                    }
                }
            }
        });
    }

}
