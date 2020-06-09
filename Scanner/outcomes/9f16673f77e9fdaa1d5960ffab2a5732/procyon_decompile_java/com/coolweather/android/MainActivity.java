// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.content.Intent;
import android.content.Context;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2131296283);
        if (PreferenceManager.getDefaultSharedPreferences((Context)this).getString("weather", (String)null) != null) {
            this.startActivity(new Intent((Context)this, (Class)WeatherActivity.class));
            this.finish();
        }
    }
}
