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
import okhttp3.Callback;
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

class ChooseAreaFragment$3$1 implements Runnable
{
    final /* synthetic */ ChooseAreaFragment$3 this$1;
    
    ChooseAreaFragment$3$1(final ChooseAreaFragment$3 this$1) {
        this.this$1 = this$1;
    }
    
    public void run() {
        this.this$1.this$0.closeProgressDialog();
        if ("province".equals(this.this$1.val$type)) {
            this.this$1.this$0.queryProvinces();
        }
        else if ("city".equals(this.this$1.val$type)) {
            this.this$1.this$0.queryCities();
        }
        else if ("county".equals(this.this$1.val$type)) {
            this.this$1.this$0.queryCounties();
        }
    }
}
