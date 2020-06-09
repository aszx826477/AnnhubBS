// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v4.app;

import android.support.v4.content.ContextCompat;
import java.util.Iterator;
import android.os.Bundle;
import android.app.PendingIntent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build$VERSION;
import android.content.Context;
import java.util.ArrayList;

public final class TaskStackBuilder implements Iterable
{
    private static final TaskStackBuilder$TaskStackBuilderImpl IMPL;
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList mIntents;
    private final Context mSourceContext;
    
    static {
        if (Build$VERSION.SDK_INT >= 11) {
            IMPL = new TaskStackBuilder$TaskStackBuilderImplHoneycomb();
        }
        else {
            IMPL = new TaskStackBuilder$TaskStackBuilderImplBase();
        }
    }
    
    private TaskStackBuilder(final Context mSourceContext) {
        this.mIntents = new ArrayList();
        this.mSourceContext = mSourceContext;
    }
    
    public static TaskStackBuilder create(final Context context) {
        return new TaskStackBuilder(context);
    }
    
    public static TaskStackBuilder from(final Context context) {
        return create(context);
    }
    
    public TaskStackBuilder addNextIntent(final Intent intent) {
        this.mIntents.add(intent);
        return this;
    }
    
    public TaskStackBuilder addNextIntentWithParentStack(final Intent intent) {
        ComponentName componentName = intent.getComponent();
        if (componentName == null) {
            componentName = intent.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (componentName != null) {
            this.addParentStack(componentName);
        }
        this.addNextIntent(intent);
        return this;
    }
    
    public TaskStackBuilder addParentStack(final Activity activity) {
        Intent intent = null;
        if (activity instanceof TaskStackBuilder$SupportParentable) {
            intent = ((TaskStackBuilder$SupportParentable)activity).getSupportParentActivityIntent();
        }
        if (intent == null) {
            intent = NavUtils.getParentActivityIntent(activity);
        }
        if (intent != null) {
            ComponentName componentName = intent.getComponent();
            if (componentName == null) {
                componentName = intent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            this.addParentStack(componentName);
            this.addNextIntent(intent);
        }
        return this;
    }
    
    public TaskStackBuilder addParentStack(final ComponentName componentName) {
        final int size = this.mIntents.size();
        try {
            Intent intent = NavUtils.getParentActivityIntent(this.mSourceContext, componentName);
            while (true) {
                if (intent == null) {
                    return this;
                }
                this.mIntents.add(size, intent);
                final Context mSourceContext = this.mSourceContext;
                try {
                    intent = NavUtils.getParentActivityIntent(mSourceContext, intent.getComponent());
                    continue;
                }
                catch (PackageManager$NameNotFoundException ex) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException((Throwable)ex);
                }
            }
        }
        catch (PackageManager$NameNotFoundException ex2) {}
    }
    
    public TaskStackBuilder addParentStack(final Class clazz) {
        return this.addParentStack(new ComponentName(this.mSourceContext, clazz));
    }
    
    public Intent editIntentAt(final int n) {
        return this.mIntents.get(n);
    }
    
    public Intent getIntent(final int n) {
        return this.editIntentAt(n);
    }
    
    public int getIntentCount() {
        return this.mIntents.size();
    }
    
    public Intent[] getIntents() {
        final Intent[] array = new Intent[this.mIntents.size()];
        if (array.length == 0) {
            return array;
        }
        array[0] = new Intent((Intent)this.mIntents.get(0)).addFlags(268484608);
        for (int i = 1; i < array.length; ++i) {
            array[i] = new Intent((Intent)this.mIntents.get(i));
        }
        return array;
    }
    
    public PendingIntent getPendingIntent(final int n, final int n2) {
        return this.getPendingIntent(n, n2, null);
    }
    
    public PendingIntent getPendingIntent(final int n, final int n2, final Bundle bundle) {
        if (!this.mIntents.isEmpty()) {
            final ArrayList mIntents = this.mIntents;
            final Intent[] array = mIntents.toArray(new Intent[mIntents.size()]);
            array[0] = new Intent(array[0]).addFlags(268484608);
            return TaskStackBuilder.IMPL.getPendingIntent(this.mSourceContext, array, n, n2, bundle);
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }
    
    public Iterator iterator() {
        return this.mIntents.iterator();
    }
    
    public void startActivities() {
        this.startActivities(null);
    }
    
    public void startActivities(final Bundle bundle) {
        if (!this.mIntents.isEmpty()) {
            final ArrayList mIntents = this.mIntents;
            final Intent[] array = mIntents.toArray(new Intent[mIntents.size()]);
            array[0] = new Intent(array[0]).addFlags(268484608);
            if (!ContextCompat.startActivities(this.mSourceContext, array, bundle)) {
                final Intent intent = new Intent(array[array.length - 1]);
                intent.addFlags(268435456);
                this.mSourceContext.startActivity(intent);
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
