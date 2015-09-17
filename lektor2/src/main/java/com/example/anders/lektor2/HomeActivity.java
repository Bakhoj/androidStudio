package com.example.anders.lektor2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity implements View.OnClickListener{

    PreferenceManager prefs;
    Button start_but;
    EditText player_et;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //prefs.getDefaultSharedPreferences(this);
        player_et = (EditText) findViewById(R.id.home_player_editText);
        start_but = (Button) findViewById(R.id.home_start_but);

        start_but.setOnClickListener(this);

        player_et.setText(prefs.getDefaultSharedPreferences(this).getString("player_name", ""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        /* Make an Language option so the user can change the language of the game*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void startClick() {
        i = new Intent(this, Hangman_akt.class);
        i.putExtra("player_name", player_et.getText().toString());
        prefs.getDefaultSharedPreferences(this).edit().putString("player_name", player_et.getText().toString()).commit();
        this.startActivity(i);
    }

    @Override
    public void onClick(View v) {

        if(v == start_but) {
            if(player_et.getText().toString() != null){
                startClick();
            }
        }
    }
}
