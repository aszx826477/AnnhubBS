// 
// Decompiled by Procyon v0.5.30
// 

package com.coolweather.android;

import android.widget.ListAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;
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
import android.view.View;
import android.view.View$OnClickListener;

class ChooseAreaFragment$2 implements View$OnClickListener
{
    final /* synthetic */ ChooseAreaFragment this$0;
    
    ChooseAreaFragment$2(final ChooseAreaFragment this$0) {
        this.this$0 = this$0;
    }
    
    public void onClick(final View view) {
        if (this.this$0.currentLevel == 2) {
            this.this$0.queryCities();
        }
        else if (this.this$0.currentLevel == 1) {
            this.this$0.queryProvinces();
        }
    }
}
