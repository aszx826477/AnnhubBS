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
import android.widget.Toast;

class ChooseAreaFragment$3$2 implements Runnable
{
    final /* synthetic */ ChooseAreaFragment$3 this$1;
    
    ChooseAreaFragment$3$2(final ChooseAreaFragment$3 this$1) {
        this.this$1 = this$1;
    }
    
    public void run() {
        this.this$1.this$0.closeProgressDialog();
        Toast.makeText(this.this$1.this$0.getContext(), (CharSequence)"\u52a0\u8f7d\u5931\u8d25", 0).show();
    }
}
