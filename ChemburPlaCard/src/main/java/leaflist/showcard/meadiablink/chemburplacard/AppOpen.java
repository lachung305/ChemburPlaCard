package leaflist.showcard.meadiablink.chemburplacard;

import static com.google.adsshow.My_Manage.app_data;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

public class AppOpen implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private Activity currentActivity;
    static App blueApp;

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivityStarted(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityResumed(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityDestroyed(Activity activity) {
        this.currentActivity = null;
    }

    public AppOpen(App mapp) {
        blueApp = mapp;
        mapp.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        if (app_data != null && app_data.size() > 0) {
            My_Manage.getInstance(currentActivity).show_appopen_ads(new My_Manage.MyCallback() {
                @Override
                public void OnCall() {
                    currentActivity = null;
                }
            });
        }
    }
}