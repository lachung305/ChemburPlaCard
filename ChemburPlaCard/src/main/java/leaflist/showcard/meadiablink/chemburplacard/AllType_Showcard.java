package leaflist.showcard.meadiablink.chemburplacard;

import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.admobMediam_Ragtangal;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.adxBannerAd;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.adxMediam_Ragtangal;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.appname;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.appDataResponse;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.fb_Ragtangal_adView;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.fbadView;
import static leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard.googleBannerAd;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdmob_Mediam_Ragtangal_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdmob_small_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdxBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdx_Mediam_Ragtangal_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFBBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFB_Mediam_Ragtangal_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isGoogleBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadmob_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadmob_small_native_banner_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_small_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_small_native_banner_Loaded;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import leaflist.showcard.meadiablink.chemburplacard.OtherIntent.LoadCustomQ;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;

public class AllType_Showcard {
    Context activity;
    public static AdView extrgoogleBannerAd;
    public static AdManagerAdView extradxBannerAd;
    public static com.facebook.ads.AdView extrfbadView;;
    private ViewGroup parentView;

    public AllType_Showcard(Context context) {
        this.activity = context;
    }

    //TODO=================================================== Banner Ads ==================================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_AAF(final ViewGroup banner_container) {
        if (isGoogleBannerLoaded) {
            extrgoogleBannerAd = googleBannerAd;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrgoogleBannerAd != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extrgoogleBannerAd);
                    parentView = banner_container;
                }
                isGoogleBannerLoaded = false;
                Chembur_Showcard.getInstance(activity).loadbanner();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (isAdxBannerLoaded) {
            extradxBannerAd = adxBannerAd;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extradxBannerAd != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extradxBannerAd);
                    parentView = banner_container;
                }
                isAdxBannerLoaded = false;
                Chembur_Showcard.getInstance(activity).loadbanner();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (isFBBannerLoaded) {
            extrfbadView = fbadView;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrfbadView != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extrfbadView);
                    parentView = banner_container;
                }
                isFBBannerLoaded = false;
                Chembur_Showcard.getInstance(activity).loadbanner();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    //TODO===================================================== Small Native Banner Ad ====================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob(final ViewGroup native_banner_ad) {
        if (isadmob_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            isadmob_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadsmallnativebanner();
        } else if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadsmallnativebanner();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadsmallnativebanner();
        } else {
            Chembur_Showcard.getInstance(activity).loadsmallnativebanner();

        }
    }


    //TODO==================================================== Small Native Ad ==============================================================

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob(final ViewGroup small_native) {
        if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadsmallnative();
        } else if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadsmallnative();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadsmallnative();
        } else {
            Chembur_Showcard.getInstance(activity).loadsmallnative();
        }

    }


    //TODO===================================================== Native Ad =====================================================================

    @SuppressLint("MissingPermission")
    public void show_native_ad_AAFB(final ViewGroup native_ad) {

        if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse----", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadnative();
        } else if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse----", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).loadnative();
        } else if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).loadnative();
        } else {
            Log.d("MyAppDataResponse----", String.valueOf(isadmob_native_Loaded));
            Chembur_Showcard.getInstance(activity).loadnative();

        }
    }

}