
package leaflist.showcard.meadiablink.chemburplacard;


import android.app.Application;
import androidx.annotation.NonNull;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class ChemburApp extends Application {
    ChemburAppOpen chemburAppOpenManager;
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
        AudienceNetworkAds.initialize(this);
        chemburAppOpenManager = new ChemburAppOpen(this);
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}