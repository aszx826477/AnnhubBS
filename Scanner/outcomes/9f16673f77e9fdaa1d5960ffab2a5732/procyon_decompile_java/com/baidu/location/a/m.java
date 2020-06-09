// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import java.util.Iterator;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import com.baidu.location.f;
import java.util.ArrayList;
import android.hardware.SensorManager;
import java.util.List;
import android.hardware.SensorEventListener;

public class m implements SensorEventListener
{
    private static Object a;
    private static m b;
    private float[] c;
    private int d;
    private List e;
    private List f;
    private boolean g;
    private boolean h;
    private SensorManager i;
    
    static {
        m.a = new Object();
        m.b = null;
    }
    
    public m() {
        this.d = 0;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = false;
        this.h = false;
        try {
            Label_0077: {
                if (this.i != null) {
                    break Label_0077;
                }
                final Object systemService = com.baidu.location.f.getServiceContext().getSystemService("sensor");
                try {
                    this.i = (SensorManager)systemService;
                    if (this.i.getDefaultSensor(6) != null) {
                        this.h = true;
                    }
                }
                catch (Exception ex) {
                    this.h = false;
                }
            }
        }
        catch (Exception ex2) {}
    }
    
    public static m a() {
        synchronized (m.a) {
            if (m.b == null) {
                m.b = new m();
            }
            return m.b;
        }
    }
    
    public void b() {
        if (!this.h) {
            return;
        }
        if (this.g) {
            return;
        }
        Label_0137: {
            try {
                this.d = 0;
                final List e = this.e;
                try {
                    e.clear();
                    final List f = this.f;
                    try {
                        f.clear();
                        Label_0083: {
                            if (this.i != null) {
                                break Label_0083;
                            }
                            final Object systemService = com.baidu.location.f.getServiceContext().getSystemService("sensor");
                            try {
                                this.i = (SensorManager)systemService;
                                if (this.i == null) {
                                    break Label_0137;
                                }
                                final Sensor defaultSensor = this.i.getDefaultSensor(6);
                                if (defaultSensor != null) {
                                    this.i.registerListener((SensorEventListener)this, defaultSensor, 2);
                                }
                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    catch (Exception ex2) {}
                }
                catch (Exception ex3) {}
            }
            catch (Exception ex4) {}
        }
        this.g = true;
    }
    
    public void c() {
        if (!this.g) {
            return;
        }
        try {
            if (this.i != null) {
                this.i.unregisterListener((SensorEventListener)this);
                this.i = null;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        this.g = false;
    }
    
    public float d() {
        synchronized (this.f) {
            final int abs = Math.abs((int)(System.currentTimeMillis() / 1000L) - this.d);
            final int n = 5;
            float floatValue = 0.0f;
            if (abs <= n && this.f.size() > 0) {
                try {
                    floatValue = this.f.get(this.f.size() - 1);
                }
                finally {}
            }
            return floatValue;
        }
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public void onSensorChanged(SensorEvent f) {
        if (f.sensor.getType() == 6) {
            if (this.g) {
                this.c = f.values.clone();
                final int d = (int)(System.currentTimeMillis() / 1000L);
                if (d != this.d) {
                    this.d = d;
                    if (this.e.size() <= 0) {
                        return;
                    }
                    final int size = this.e.size();
                    float n = 0.0f;
                    final Iterator<Float> iterator = (Iterator<Float>)this.e.iterator();
                    while (iterator.hasNext()) {
                        n += iterator.next();
                    }
                    final float n2 = n / size;
                    f = (SensorEvent)this.f;
                    // monitorenter(f)
                    List list = null;
                    try {
                        final List f2 = this.f;
                        try {
                            f2.add(n2);
                            final List f3;
                            list = (f3 = this.f);
                            final int n3 = f3.size();
                            final int n4 = 4;
                            final int n5 = n3;
                            final int n6 = n4;
                            if (n5 >= n6) {
                                final m m = this;
                                final List f4 = m.f;
                                final List f5 = f4;
                                final int n7 = 0;
                                f5.remove(n7);
                            }
                        }
                        catch (Exception ex2) {
                            final Exception ex;
                            ex.printStackTrace();
                            this.f.clear();
                        }
                    }
                    catch (Exception ex3) {}
                    finally {
                        // monitorexit(f)
                        this.e.clear();
                        return;
                    }
                    // monitorexit(f)
                    try {
                        final List f3 = list;
                        final int n3 = f3.size();
                        final int n4 = 4;
                        final int n5 = n3;
                        final int n6 = n4;
                        if (n5 >= n6) {
                            final m m = this;
                            final List f5;
                            final List f4 = f5 = m.f;
                            final int n7 = 0;
                            f5.remove(n7);
                        }
                    }
                    catch (Exception ex) {}
                }
                this.e.add(this.c[0]);
            }
        }
    }
}
