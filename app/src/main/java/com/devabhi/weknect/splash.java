package com.devabhi.weknect;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class splash extends AppCompatActivity {
    WebView web_View;
    ProgressBar progress_bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        web_View = findViewById(R.id.web_View);
        WebSettings webSettings = web_View.getSettings() ;
        webSettings.setJavaScriptEnabled(true);
        web_View.setWebViewClient(new WebViewClient());
        web_View.loadUrl("https://www.wefashend.com/");
        getSupportActionBar().hide();
        progress_bar = findViewById(R.id.progress_bar);
        progress_bar.setMax(100);

        web_View.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progress_bar.setProgress(newProgress);
            }
        });


    }
    @Override
    public void onBackPressed() { //if user presses the back button do this
        if (web_View.isFocused() && web_View.canGoBack()) { //check if in webview and the user can go back
            web_View.goBack(); //go back in webview
        } else { //do this if the webview cannot go back any further

            new AlertDialog.Builder(this) //alert the person knowing they are about to close
                    .setTitle("EXIT")
                    .setMessage("Are you sure. You want to close this app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }



}