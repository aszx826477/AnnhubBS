// 
// Decompiled by Procyon v0.5.30
// 

package android.support.v7.app;

import android.support.v7.widget.Toolbar;
import android.support.v7.view.ActionMode$Callback;
import android.support.v4.app.ActivityCompat;
import android.support.v7.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.TaskStackBuilder;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.content.res.Configuration;
import android.support.v4.app.NavUtils;
import android.content.Intent;
import android.content.Context;
import android.support.v7.widget.VectorEnabledTintResources;
import android.view.MenuInflater;
import android.app.Activity;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.ViewGroup$LayoutParams;
import android.view.View;
import android.content.res.Resources;
import android.support.v4.app.TaskStackBuilder$SupportParentable;
import android.support.v4.app.FragmentActivity;

public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder$SupportParentable, ActionBarDrawerToggle$DelegateProvider
{
    private AppCompatDelegate mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private int mThemeId;
    
    public AppCompatActivity() {
        this.mThemeId = 0;
    }
    
    public void addContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.getDelegate().addContentView(view, viewGroup$LayoutParams);
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        if (KeyEventCompat.isCtrlPressed(keyEvent)) {
            if (keyEvent.getUnicodeChar(keyEvent.getMetaState() & 0xFFFF8FFF) == 60) {
                final int action = keyEvent.getAction();
                final boolean mEatKeyUpEvent = true;
                if (action == 0) {
                    final ActionBar supportActionBar = this.getSupportActionBar();
                    if (supportActionBar != null && supportActionBar.isShowing() && supportActionBar.requestFocus()) {
                        return this.mEatKeyUpEvent = mEatKeyUpEvent;
                    }
                }
                else if (action == (mEatKeyUpEvent ? 1 : 0) && this.mEatKeyUpEvent) {
                    this.mEatKeyUpEvent = false;
                    return mEatKeyUpEvent;
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }
    
    public View findViewById(final int n) {
        return this.getDelegate().findViewById(n);
    }
    
    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create(this, this);
        }
        return this.mDelegate;
    }
    
    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        return this.getDelegate().getDrawerToggleDelegate();
    }
    
    public MenuInflater getMenuInflater() {
        return this.getDelegate().getMenuInflater();
    }
    
    public Resources getResources() {
        if (this.mResources == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources((Context)this, super.getResources());
        }
        Resources resources = this.mResources;
        if (resources == null) {
            resources = super.getResources();
        }
        return resources;
    }
    
    public ActionBar getSupportActionBar() {
        return this.getDelegate().getSupportActionBar();
    }
    
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }
    
    public void invalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.getDelegate().onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }
    
    public void onContentChanged() {
        this.onSupportContentChanged();
    }
    
    protected void onCreate(final Bundle bundle) {
        final AppCompatDelegate delegate = this.getDelegate();
        delegate.installViewFactory();
        delegate.onCreate(bundle);
        if (delegate.applyDayNight() && this.mThemeId != 0) {
            if (Build$VERSION.SDK_INT >= 23) {
                this.onApplyThemeResource(this.getTheme(), this.mThemeId, false);
            }
            else {
                this.setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }
    
    public void onCreateSupportNavigateUpTaskStack(final TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.getDelegate().onDestroy();
    }
    
    public final boolean onMenuItemSelected(final int n, final MenuItem menuItem) {
        if (super.onMenuItemSelected(n, menuItem)) {
            return true;
        }
        final ActionBar supportActionBar = this.getSupportActionBar();
        return menuItem.getItemId() == 16908332 && supportActionBar != null && (supportActionBar.getDisplayOptions() & 0x4) != 0x0 && this.onSupportNavigateUp();
    }
    
    public boolean onMenuOpened(final int n, final Menu menu) {
        return super.onMenuOpened(n, menu);
    }
    
    public void onPanelClosed(final int n, final Menu menu) {
        super.onPanelClosed(n, menu);
    }
    
    protected void onPostCreate(final Bundle bundle) {
        super.onPostCreate(bundle);
        this.getDelegate().onPostCreate(bundle);
    }
    
    protected void onPostResume() {
        super.onPostResume();
        this.getDelegate().onPostResume();
    }
    
    public void onPrepareSupportNavigateUpTaskStack(final TaskStackBuilder taskStackBuilder) {
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.getDelegate().onSaveInstanceState(bundle);
    }
    
    protected void onStart() {
        super.onStart();
        this.getDelegate().onStart();
    }
    
    protected void onStop() {
        super.onStop();
        this.getDelegate().onStop();
    }
    
    public void onSupportActionModeFinished(final ActionMode actionMode) {
    }
    
    public void onSupportActionModeStarted(final ActionMode actionMode) {
    }
    
    public void onSupportContentChanged() {
    }
    
    public boolean onSupportNavigateUp() {
        final Intent supportParentActivityIntent = this.getSupportParentActivityIntent();
        if (supportParentActivityIntent != null) {
            if (this.supportShouldUpRecreateTask(supportParentActivityIntent)) {
                final TaskStackBuilder create = TaskStackBuilder.create((Context)this);
                this.onCreateSupportNavigateUpTaskStack(create);
                this.onPrepareSupportNavigateUpTaskStack(create);
                create.startActivities();
                try {
                    ActivityCompat.finishAffinity(this);
                }
                catch (IllegalStateException ex) {
                    this.finish();
                }
            }
            else {
                this.supportNavigateUpTo(supportParentActivityIntent);
            }
            return true;
        }
        return false;
    }
    
    protected void onTitleChanged(final CharSequence title, final int n) {
        super.onTitleChanged(title, n);
        this.getDelegate().setTitle(title);
    }
    
    public ActionMode onWindowStartingSupportActionMode(final ActionMode$Callback actionMode$Callback) {
        return null;
    }
    
    public void setContentView(final int contentView) {
        this.getDelegate().setContentView(contentView);
    }
    
    public void setContentView(final View contentView) {
        this.getDelegate().setContentView(contentView);
    }
    
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        this.getDelegate().setContentView(view, viewGroup$LayoutParams);
    }
    
    public void setSupportActionBar(final Toolbar supportActionBar) {
        this.getDelegate().setSupportActionBar(supportActionBar);
    }
    
    public void setSupportProgress(final int n) {
    }
    
    public void setSupportProgressBarIndeterminate(final boolean b) {
    }
    
    public void setSupportProgressBarIndeterminateVisibility(final boolean b) {
    }
    
    public void setSupportProgressBarVisibility(final boolean b) {
    }
    
    public void setTheme(final int n) {
        super.setTheme(n);
        this.mThemeId = n;
    }
    
    public ActionMode startSupportActionMode(final ActionMode$Callback actionMode$Callback) {
        return this.getDelegate().startSupportActionMode(actionMode$Callback);
    }
    
    public void supportInvalidateOptionsMenu() {
        this.getDelegate().invalidateOptionsMenu();
    }
    
    public void supportNavigateUpTo(final Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }
    
    public boolean supportRequestWindowFeature(final int n) {
        return this.getDelegate().requestWindowFeature(n);
    }
    
    public boolean supportShouldUpRecreateTask(final Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }
}
