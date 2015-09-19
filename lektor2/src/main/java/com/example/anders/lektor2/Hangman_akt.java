package com.example.anders.lektor2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Hangman_akt extends Activity implements View.OnClickListener {

    Button submit;
    ImageView hang_pic;
    TextView text;

    Intent i;
    Galgelogik gl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman_akt);

        text = (TextView) findViewById(R.id.hangman_akt_text);
        submit = (Button) findViewById(R.id.game_submit_but);
        hang_pic = (ImageView) findViewById(R.id.game_hangman_pic);
        submit.setOnClickListener(this);
        i = getIntent();
        gl = new Galgelogik();

        String s = i.getExtras().getString("player_name");

        text.setText(text.getText().toString() + s + ". " + gl.getSynligtOrd() + " " + gl.getOrdet());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hangman_akt, menu);
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

    private void oneWrong(){
        switch (gl.getAntalForkerteBogstaver()){
            case 0:
                hang_pic.setImageResource(R.drawable.galge);
                break;
            case 1:
                hang_pic.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                hang_pic.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                hang_pic.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                hang_pic.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                hang_pic.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                hang_pic.setImageResource(R.drawable.forkert6);
                break;
            default:
                hang_pic.setImageResource(R.drawable.galge);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == submit){
            gl.gætBogstav("a");

            if(gl.erSidsteBogstavKorrekt()){

            } else {oneWrong();}

        }
    }
}
