package com.example.anders.lektor1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ovelse3 extends Activity implements View.OnClickListener{

    Button vejledning_but;
    Button indstillinger_but;

    TextView choice_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse3);

        vejledning_but = (Button) findViewById(R.id.øve3_but_vejledning);
        indstillinger_but = (Button) findViewById(R.id.øve3_but_indstillinger);

        choice_text = (TextView) findViewById(R.id.øve3_akt_text);

        vejledning_but.setOnClickListener(this);
        indstillinger_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == vejledning_but){
            choice_text.setText("Du har valgt Vejledning");
        } else if(v == indstillinger_but){
            choice_text.setText("Du har valgt Indstillinger");
        }
    }
}
