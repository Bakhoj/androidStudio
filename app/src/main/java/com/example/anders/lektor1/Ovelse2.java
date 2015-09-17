package com.example.anders.lektor1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ovelse2 extends Activity implements View.OnClickListener{

    Button submit_but;
    TextView welcomeText;
    TextView nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse2);

        submit_but = (Button) findViewById(R.id.øve2_akt_submit);
        welcomeText = (TextView) findViewById(R.id.øve2_akt_textField);
        nameField = (TextView) findViewById(R.id.øve2_nameField);

        submit_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == submit_but){
            welcomeText.setText("Welcome " + nameField.getText() + "!");
        }
    }
}
