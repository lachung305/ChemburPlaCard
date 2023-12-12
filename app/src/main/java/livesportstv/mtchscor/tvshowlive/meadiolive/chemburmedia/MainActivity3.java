package livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard;

public class MainActivity3 extends AppCompatActivity {
    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnew);

        activity = this;
        Chembur_Showcard.getInstance(activity).show_native_ad(findViewById(R.id.native_ads));
        Chembur_Showcard.getInstance(activity).show_banner_ad(findViewById(R.id.native_banner));
        Chembur_Showcard.getInstance(activity).show_small_native_ad(findViewById(R.id.small_native));
        Chembur_Showcard.getInstance(activity).show_small_native_banner_ad(findViewById(R.id.small_nativebanner));

        findViewById(R.id.inter).setOnClickListener(v -> Chembur_Showcard.getInstance(activity).show_Interstitial(() -> {

        }));


    }
}