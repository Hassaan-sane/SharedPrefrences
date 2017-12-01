package com.example.sane.sharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etField = (EditText) findViewById(R.id.ET);
        Button BtnSave = (Button) findViewById(R.id.BtnSave);


        final String MYPREF = "Mypref";
        final String Field = "field";

        SharedPreferences preference = getSharedPreferences(MYPREF, MODE_PRIVATE);
        String restoredText = preference.getString(Field, "");
        Log.d("TAAG", restoredText);
        etField.setText(restoredText);
        if (restoredText == "") {
            String name = preference.getString(Field, "bcbcbc");
            etField.setText(name);
        }

        final SharedPreferences Sp = getSharedPreferences(MYPREF, Context.MODE_PRIVATE);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String savedtext = etField.getText().toString();

                SharedPreferences.Editor editor = Sp.edit();
                editor.putString(Field, savedtext);
                editor.apply();
                editor.commit();
                Log.d("TAAG", savedtext);
            }
        });


    }
}
