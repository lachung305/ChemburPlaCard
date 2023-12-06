package livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia;

import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.dataresponsearray;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.gson.Gson;

import leaflist.showcard.meadiablink.chemburplacard.AppData_Utils;
import leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard;
import leaflist.showcard.meadiablink.chemburplacard.ChemburPreferencesManager;
import leaflist.showcard.meadiablink.chemburplacard.Chemburmodel.AppDataResponse;


public class MainActivity extends AppCompatActivity {

    public Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
        ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);

        AppDataResponse dataItem = new AppDataResponse();
        dataItem.setAdmobInterid("/6499/example/interstitial");
        dataItem.setAdmobBannerid("/6499/example/banner");
        dataItem.setAdmobNativeid("/6499/example/native");
        dataItem.setAdNative("admob");
        dataItem.setAdSmallNativeBanner("admob");
        dataItem.setAdInter("admob");
        dataItem.setAdBanner("admob");
        dataItem.setAdSmallNative("admob");
        dataItem.setAdInterBack("admob");
        dataItem.setAdSplash("off");
        dataItem.setAdAppopen("off");
        dataItem.setAd_appopen_inter("off");
        dataItem.setInterBackCount(1);
        dataItem.setInterCount(1);

        Gson gson = new Gson();
        String favData = gson.toJson(dataItem);
        AppData_Utils.saveStringtoPrefrence(activity, "appdatacard", favData);

        Chembur_Showcard.getInstance(MainActivity.this).setCarddata(MainActivity.this);
        Chembur_Showcard.getInstance(MainActivity.this).setAppDetail(MainActivity.this, getResources().getString(R.string.app_name), R.mipmap.ic_launcher);
        Chembur_Showcard.getInstance(MainActivity.this).card_preload(new Chembur_Showcard.AppDataback() {
            @Override
            public void OnCall() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        within();
                    }
                }, 3000);

            }
        });

    }


    public void within() {
        startActivity(new Intent(activity, MainActivity2.class));
        finish();
    }


}