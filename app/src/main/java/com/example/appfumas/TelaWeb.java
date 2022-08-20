package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TelaWeb extends AppCompatActivity {
    WebView wv;
    public static String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_web);
        wv = findViewById(R.id.web);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(link);
    }
}