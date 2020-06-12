package com.hackernight.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_ID = "message_pref";
    private EditText messageeditText;
    private TextView messagetextView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageeditText = findViewById(R.id.message_edittext);
        messagetextView = findViewById(R.id.show_message_textview);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message =  messageeditText.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("message",message);
                editor.apply();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences getsharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
        String value = getsharedPreferences.getString("message","nothing to show!!!");
        messagetextView.setText(value);
    }
}