package com.mohammed.translatorfren;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button toTranslate;
    EditText userText;
    Button smbmit;
    TextView translatedWord;

    HashMap <String,String[]> hashMap =new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toTranslate =findViewById(R.id.toTranslate);
        //Add new words here
        String []wordHello ={"اهلا","مرحبا"};
        hashMap.put("Hello",wordHello);

        //Convert HashMap to Json String
        String json =ValueClass.gson.toJson(hashMap,ValueClass.typeToken);

        /*Todo
        *Save json String here in Database but with key that in ValueClass
        *if you use English word use English_JSON_KEY and FRENCH_JSON_KEY if you use French
        */
    }
}
