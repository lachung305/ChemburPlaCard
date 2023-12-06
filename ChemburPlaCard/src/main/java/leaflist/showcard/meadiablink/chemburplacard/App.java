
package leaflist.showcard.meadiablink.chemburplacard;


import android.app.Application;
import androidx.annotation.NonNull;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class App extends Application {
    AppOpen appOpenManager;
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        AudienceNetworkAds.initialize(this);
        appOpenManager = new AppOpen(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}