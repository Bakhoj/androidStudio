package com.example.anders.lektor1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ovelse4 extends Activity implements View.OnClickListener{

    Button ok_but;
    TextView URL_text;
    WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse4);

        ok_but = (Button) findViewById(R.id.øve4_akt_but_ok);
        URL_text = (EditText) findViewById(R.id.øve4_akt_URL);
        browser = (WebView) findViewById(R.id.øve4_akt_webView);

        ok_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == ok_but){
            browser.loadUrl(URL_text.getText().toString());
        }
    }
}
