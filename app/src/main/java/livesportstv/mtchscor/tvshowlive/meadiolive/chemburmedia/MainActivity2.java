package livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard;

public class MainActivity2 extends AppCompatActivity {
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
        Chembur_Showcard.getInstance(activity).card_preload(new Chembur_Showcard.AppDataback() {
            @Override
            public void OnCall() {
                Chembur_Showcard.progressDialog.dismiss();
            }
        });

        findViewById(R.id.inter).setOnClickListener(v -> Chembur_Showcard.getInstance(activity).show_Interstitial(() -> {
            startActivity(new Intent(MainActivity2.this,MainActivity3.class));

        }));


    }
}