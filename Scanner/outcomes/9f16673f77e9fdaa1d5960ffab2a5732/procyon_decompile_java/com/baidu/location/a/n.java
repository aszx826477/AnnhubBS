// 
// Decompiled by Procyon v0.5.30
// 

package com.baidu.location.a;

import android.hardware.SensorEvent;
import android.hardware.Sensor;
import com.baidu.location.f;
import android.hardware.SensorManager;
import android.hardware.SensorEventListener;

public class n implements SensorEventListener
{
    private static n c;
    private float[] a;
    private SensorManager b;
    private float d;
    private boolean e;
    private boolean f;
    private boolean g;
    
    private n() {
        this.e = false;
        this.f = false;
        this.g = false;
    }
    
    public static n a() {
        synchronized (n.class) {
            if (n.c == null) {
                n.c = new n();
            }
            return n.c;
        }
    }
    
    public void a(final boolean e) {
        this.e = e;
    }
    
    public void b() {
        synchronized (this) {
            if (this.g) {
                return;
            }
            if (!this.e) {
                return;
            }
            if (this.b == null) {
                this.b = (SensorManager)com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.b != null) {
                final Sensor defaultSensor = this.b.getDefaultSensor(11);
                if (defaultSensor != null && this.e) {
                    this.b.registerListener((SensorEventListener)this, defaultSensor, 3);
                }
            }
            this.g = true;
        }
    }
    
    public void c() {
        synchronized (this) {
            if (!this.g) {
                return;
            }
            if (this.b != null) {
                this.b.unregisterListener((SensorEventListener)this);
                this.b = null;
            }
            this.g = false;
        }
    }
    
    public boolean d() {
        return this.e;
    }
    
    public float e() {
        return this.d;
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            this.a = sensorEvent.values.clone();
            final float[] a = this.a;
            if (a != null) {
                final float[] array = new float[9];
                try {
                    SensorManager.getRotationMatrixFromVector(array, a);
                    final float[] array2 = new float[3];
                    SensorManager.getOrientation(array, array2);
                    this.d = (float)Math.toDegrees(array2[0]);
                    float d;
                    if (this.d >= 0.0f) {
                        d = this.d;
                    }
                    else {
                        d = this.d + 360.0f;
                    }
                    this.d = (float)Math.floor(d);
                }
                catch (Exception ex) {
                    this.d = 0.0f;
                }
            }
        }
    }
}
