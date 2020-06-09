// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import com.baidu.location.LocationClientOption;
import java.util.List;
import com.baidu.location.Address;
import android.location.Location;
import com.baidu.location.b.h;
import android.os.Message;
import android.os.Bundle;
import com.baidu.location.b.e;
import com.baidu.location.d.j;
import com.baidu.location.f;
import com.baidu.location.d.b;
import android.content.Intent;
import java.util.Iterator;
import android.os.Messenger;
import com.baidu.location.BDLocation;
import java.util.ArrayList;

class a$b implements Runnable
{
    final /* synthetic */ a a;
    private int b;
    private boolean c;
    
    public void run() {
        if (this.c) {
            return;
        }
        ++this.b;
        this.a.m = false;
    }
}
