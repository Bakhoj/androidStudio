package com.example.anders.lektor2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HangmanAct extends Activity implements View.OnClickListener {

    Button submit;
    ImageView hangPic;
    TextView guessLetET;
    TextView usedLetText;
    TextView visibleWordText;
    RelativeLayout bag;

    Intent i;
    Galgelogik gl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);

        guessLetET = (TextView) findViewById(R.id.game_guess_letter_et);
        usedLetText = (TextView) findViewById(R.id.game_used_letters_text);
        visibleWordText = (TextView) findViewById(R.id.game_visible_word);
        submit = (Button) findViewById(R.id.game_submit_but);
        hangPic = (ImageView) findViewById(R.id.game_hangman_pic);
        bag = (RelativeLayout) findViewById(R.id.baggrund_hangman);
        submit.setOnClickListener(this);
        i = getIntent();
        gl = new Galgelogik();

        String s = i.getExtras().getString("player_name");

        update();

        //text.setText(text.getText().toString() + s + ". " + gl.getSynligtOrd() + " " + gl.getOrdet());
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

    private void update() {
        switch (gl.getAntalForkerteBogstaver()) {
            case 0:
                hangPic.setImageResource(R.drawable.galge);
                bag.setBackgroundResource(R.drawable.baggrundgalge);
                break;
            case 1:
                hangPic.setImageResource(R.drawable.forkert1);
                bag.setBackgroundResource(R.drawable.bagforkert1);
                break;
            case 2:
                hangPic.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                hangPic.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                hangPic.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                hangPic.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                hangPic.setImageResource(R.drawable.forkert6);
                break;
            default:
                hangPic.setImageResource(R.drawable.galge);
        }

        visibleWordText.setText(gl.getSynligtOrd());
        guessLetET.setText("");
        usedLetText.setText(gl.getBrugteBogstaver().toString());
    }

    @Override
    public void onClick(View v) {
        if (v == submit) {
            gl.gætBogstav(guessLetET.getText().toString());
            guessLetET.setText("");
            if(!gl.erSpilletSlut()){
                update();
            }

        }
    }
}
