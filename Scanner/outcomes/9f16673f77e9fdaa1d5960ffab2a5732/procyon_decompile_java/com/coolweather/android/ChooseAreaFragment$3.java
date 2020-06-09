// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.widget.ListAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.widget.AdapterView$OnItemClickListener;
import android.os.Bundle;
import android.content.Context;
import com.coolweather.android.util.HttpUtil;
import com.coolweather.android.db.County;
import java.util.Iterator;
import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import android.widget.TextView;
import com.coolweather.android.db.Province;
import com.coolweather.android.db.City;
import android.app.ProgressDialog;
import android.widget.ListView;
import java.util.List;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.support.v4.app.Fragment;
import com.coolweather.android.util.Utility;
import okhttp3.Response;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

class ChooseAreaFragment$3 implements Callback
{
    final /* synthetic */ ChooseAreaFragment this$0;
    final /* synthetic */ String val$type;
    
    ChooseAreaFragment$3(final ChooseAreaFragment this$0, final String val$type) {
        this.this$0 = this$0;
        this.val$type = val$type;
    }
    
    public void onFailure(final Call call, final IOException ex) {
        this.this$0.getActivity().runOnUiThread((Runnable)new ChooseAreaFragment$3$2(this));
    }
    
    public void onResponse(final Call call, final Response response) {
        final String string = response.body().string();
        boolean b = false;
        if ("province".equals(this.val$type)) {
            b = Utility.handleProvinceResponse(string);
        }
        else if ("city".equals(this.val$type)) {
            b = Utility.handleCityResponse(string, this.this$0.selectedProvince.getId());
        }
        else if ("county".equals(this.val$type)) {
            b = Utility.handleCountyResponse(string, this.this$0.selectedCity.getId());
        }
        if (b) {
            this.this$0.getActivity().runOnUiThread((Runnable)new ChooseAreaFragment$3$1(this));
        }
    }
}
