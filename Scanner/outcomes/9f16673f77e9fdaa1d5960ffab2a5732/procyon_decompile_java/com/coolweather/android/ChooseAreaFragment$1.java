// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.widget.ListAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.os.Bundle;
import okhttp3.Callback;
import com.coolweather.android.util.HttpUtil;
import java.util.Iterator;
import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.widget.ListView;
import java.util.List;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.coolweather.android.db.County;
import com.coolweather.android.db.City;
import com.coolweather.android.db.Province;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemClickListener;

class ChooseAreaFragment$1 implements AdapterView$OnItemClickListener
{
    final /* synthetic */ ChooseAreaFragment this$0;
    
    ChooseAreaFragment$1(final ChooseAreaFragment this$0) {
        this.this$0 = this$0;
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        if (this.this$0.currentLevel == 0) {
            final ChooseAreaFragment this$0 = this.this$0;
            this$0.selectedProvince = (Province)this$0.provinceList.get(n);
            this.this$0.queryCities();
        }
        else {
            final int access$000 = this.this$0.currentLevel;
            final boolean refreshing = true;
            if (access$000 == (refreshing ? 1 : 0)) {
                final ChooseAreaFragment this$2 = this.this$0;
                this$2.selectedCity = (City)this$2.cityList.get(n);
                this.this$0.queryCounties();
            }
            else if (this.this$0.currentLevel == 2) {
                final String weatherId = this.this$0.countyList.get(n).getWeatherId();
                if (this.this$0.getActivity() instanceof MainActivity) {
                    final Intent intent = new Intent((Context)this.this$0.getActivity(), (Class)WeatherActivity.class);
                    intent.putExtra("weather_id", weatherId);
                    this.this$0.startActivity(intent);
                    this.this$0.getActivity().finish();
                }
                else if (this.this$0.getActivity() instanceof WeatherActivity) {
                    final WeatherActivity weatherActivity = (WeatherActivity)this.this$0.getActivity();
                    weatherActivity.drawerLayout.closeDrawers();
                    weatherActivity.swipeRefresh.setRefreshing(refreshing);
                    weatherActivity.requestWeather(weatherId);
                }
            }
        }
    }
}
