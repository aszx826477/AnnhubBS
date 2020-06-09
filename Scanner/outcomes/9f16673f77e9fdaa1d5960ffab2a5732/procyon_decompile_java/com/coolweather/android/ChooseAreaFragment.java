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

public class ChooseAreaFragment extends Fragment
{
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;
    public static final int LEVEL_PROVINCE = 0;
    private static final String TAG = "ChooseAreaFragment";
    private ArrayAdapter adapter;
    private Button backButton;
    private List cityList;
    private List countyList;
    private int currentLevel;
    private List dataList;
    private ListView listView;
    private ProgressDialog progressDialog;
    private List provinceList;
    private City selectedCity;
    private Province selectedProvince;
    private TextView titleText;
    
    public ChooseAreaFragment() {
        this.dataList = new ArrayList();
    }
    
    private void closeProgressDialog() {
        final ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
    
    private void queryCities() {
        this.titleText.setText((CharSequence)this.selectedProvince.getProvinceName());
        this.backButton.setVisibility(0);
        final String[] array = { "provinceid = ?", null };
        final String value = String.valueOf(this.selectedProvince.getId());
        final int currentLevel = 1;
        array[currentLevel] = value;
        this.cityList = DataSupport.where(array).find(City.class);
        if (this.cityList.size() > 0) {
            this.dataList.clear();
            final Iterator<City> iterator = (Iterator<City>)this.cityList.iterator();
            while (iterator.hasNext()) {
                this.dataList.add(iterator.next().getCityName());
            }
            this.adapter.notifyDataSetChanged();
            this.listView.setSelection(0);
            this.currentLevel = currentLevel;
        }
        else {
            final int provinceCode = this.selectedProvince.getProvinceCode();
            final StringBuilder sb = new StringBuilder();
            sb.append("http://guolin.tech/api/china/");
            sb.append(provinceCode);
            this.queryFromServer(sb.toString(), "city");
        }
    }
    
    private void queryCounties() {
        this.titleText.setText((CharSequence)this.selectedCity.getCityName());
        this.backButton.setVisibility(0);
        final int currentLevel = 2;
        final String[] array = new String[currentLevel];
        array[0] = "cityid = ?";
        array[1] = String.valueOf(this.selectedCity.getId());
        this.countyList = DataSupport.where(array).find(County.class);
        if (this.countyList.size() > 0) {
            this.dataList.clear();
            final Iterator<County> iterator = (Iterator<County>)this.countyList.iterator();
            while (iterator.hasNext()) {
                this.dataList.add(iterator.next().getCountyName());
            }
            this.adapter.notifyDataSetChanged();
            this.listView.setSelection(0);
            this.currentLevel = currentLevel;
        }
        else {
            final int provinceCode = this.selectedProvince.getProvinceCode();
            final int cityCode = this.selectedCity.getCityCode();
            final StringBuilder sb = new StringBuilder();
            sb.append("http://guolin.tech/api/china/");
            sb.append(provinceCode);
            sb.append("/");
            sb.append(cityCode);
            this.queryFromServer(sb.toString(), "county");
        }
    }
    
    private void queryFromServer(final String s, final String s2) {
        this.showProgressDialog();
        HttpUtil.sendOkHttpRequest(s, new ChooseAreaFragment$3(this, s2));
    }
    
    private void queryProvinces() {
        this.titleText.setText((CharSequence)"\u4e2d\u56fd");
        this.backButton.setVisibility(8);
        this.provinceList = DataSupport.findAll(Province.class, new long[0]);
        if (this.provinceList.size() > 0) {
            this.dataList.clear();
            final Iterator<Province> iterator = this.provinceList.iterator();
            while (iterator.hasNext()) {
                this.dataList.add(iterator.next().getProvinceName());
            }
            this.adapter.notifyDataSetChanged();
            this.listView.setSelection(0);
            this.currentLevel = 0;
        }
        else {
            this.queryFromServer("http://guolin.tech/api/china", "province");
        }
    }
    
    private void showProgressDialog() {
        if (this.progressDialog == null) {
            (this.progressDialog = new ProgressDialog((Context)this.getActivity())).setMessage((CharSequence)"\u6b63\u5728\u52a0\u8f7d...");
            this.progressDialog.setCanceledOnTouchOutside(false);
        }
        this.progressDialog.show();
    }
    
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        this.listView.setOnItemClickListener((AdapterView$OnItemClickListener)new ChooseAreaFragment$1(this));
        this.backButton.setOnClickListener((View$OnClickListener)new ChooseAreaFragment$2(this));
        this.queryProvinces();
    }
    
    public View onCreateView(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle) {
        final View inflate = layoutInflater.inflate(2131296286, viewGroup, false);
        this.titleText = (TextView)inflate.findViewById(2131165307);
        this.backButton = (Button)inflate.findViewById(2131165208);
        this.listView = (ListView)inflate.findViewById(2131165247);
        this.adapter = new ArrayAdapter(this.getContext(), 17367043, this.dataList);
        this.listView.setAdapter((ListAdapter)this.adapter);
        return inflate;
    }
}
