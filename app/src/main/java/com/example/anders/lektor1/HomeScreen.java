package com.example.anders.lektor1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends Activity implements View.OnClickListener{

    Button øve1;
    Button øve2;
    Button øve3;
    Button øve4;
    Button øve5;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        øve1 = (Button) findViewById(R.id.øve1_button);
        øve2 = (Button) findViewById(R.id.øve2_button);
        øve3 = (Button) findViewById(R.id.øve3_button);
        øve4 = (Button) findViewById(R.id.øve4_button);
        øve5 = (Button) findViewById(R.id.øve5_button);

        øve1.setOnClickListener(this);
        øve2.setOnClickListener(this);
        øve3.setOnClickListener(this);
        øve4.setOnClickListener(this);
        øve5.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == øve1) {
            System.out.println("øvelse1 trykket");
            i = new Intent(this, Ovelse1.class);
            this.startActivity(i);
        } else if(v == øve2) {
            System.out.println("øvelse2 trykket");
            i = new Intent(this, Ovelse2.class);
            this.startActivity(i);
        } else if(v == øve3) {
            System.out.println("øvelse3 trykket");
            i = new Intent(this, Ovelse3.class);
            this.startActivity(i);
        } else if(v == øve4) {
            System.out.println("øvelse4 trykket");
            i = new Intent(this, Ovelse4.class);
            this.startActivity(i);
        } else if(v == øve5) {
            System.out.println("øvelse5 trykket");
            i = new Intent(this, Ovelse5.class);
            this.startActivity(i);
        }
    }
}
