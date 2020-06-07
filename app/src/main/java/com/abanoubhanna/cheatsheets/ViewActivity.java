package com.abanoubhanna.cheatsheets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ViewActivity extends AppCompatActivity {

    static String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        WebView sheet = findViewById(R.id.webView);

        //get the key of the sheet clicked
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            num = extras.getString("num");
        }

        //WebSettings webSettings = sheet.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        //get the number of the sheet
        sheet.loadUrl("file:///android_asset/" + num + ".html");
        sheet.setWebViewClient(new WebViewClient());

        //ad
        MobileAds.initialize(this, "ca-app-pub-4971969455307153~7909282677");
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent goBack = new Intent(this, MainActivity.class);
        startActivity(goBack);
        this.finish();
    }
}
