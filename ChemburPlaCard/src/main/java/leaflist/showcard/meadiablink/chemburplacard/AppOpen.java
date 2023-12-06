package leaflist.showcard.meadiablink.chemburplacard;


import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.dataresponsearray;

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
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            Chembur_Showcard.getInstance(currentActivity).show_appopen_ads(new Chembur_Showcard.AppDataback() {
                @Override
                public void OnCall() {
                    currentActivity = null;
                }
            });
        }
    }
}