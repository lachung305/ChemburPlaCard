package leaflist.showcard.meadiablink.chemburplacard;

import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Admob;
;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Adx;

import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Appopen;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.FB;

import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdmob_small_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdxBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdxInterLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFBBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFBInterLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isGoogleBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isGoogleInterLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadmob_appopen_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadmob_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadmob_small_native_banner_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_appopen_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_small_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isadx_small_native_banner_Loaded;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import leaflist.showcard.meadiablink.chemburplacard.Chemburmodel.AppDataResponse;
import leaflist.showcard.meadiablink.chemburplacard.OtherIntent.LoadCustomQ;

public class Chembur_Showcard {
    private static Chembur_Showcard mInstance;
    public static Context activity;
    static AppDataback appDataback;
    public static AdView googleBannerAd;
    public static AdManagerAdView adxBannerAd;
    public static com.facebook.ads.AdView fbadView;

    public static AdView admobMediam_Ragtangal;
    public static AdManagerAdView adxMediam_Ragtangal;
    public static com.facebook.ads.AdView fb_Ragtangal_adView;

    public static ArrayList<NativeAd> Admob_small_native_banner_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Admob_small_native_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Admob_native_Ad = new ArrayList<>();

    public static ArrayList<NativeAd> Adx_small_native_banner_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Adx_small_native_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Adx_native_Ad = new ArrayList<>();
    public static boolean isFBNative_Banner_Loaded;
    public static boolean isFBNativeLoaded;
    public static ArrayList<NativeBannerAd> fb_nativeBannerAd = new ArrayList<>();
    public static ArrayList<com.facebook.ads.NativeAd> fbnativeAd = new ArrayList<>();

    public static InterstitialAd ADMOBInterstitialAd;
    public static AdManagerInterstitialAd ADXInterstitialAd;
    public static com.facebook.ads.InterstitialAd FB_interstitialAd;

    public FullScreenContentCallback fullScreenContentCallback;
    public static AppOpenAd admob_appOpenAd;
    public static AppOpenAd adx_appOpenAd;

    private int adinterCounter;
    private int adbackcounter;
    private int qurekaadCounter;
    SharedPreferences prefs;
    public static AppDataResponse appDataResponse;
    public static String appname;
    public static int applogo;

    public int current_admob_nativeid = 0;
    public int current_adx_nativeid = 0;
    public int current_facebook_nativeid = 0;

    public int current_admob_interid = 0;
    public int current_adx_interid = 0;
    public int current_facebook_interid = 0;

    public int current_admob_bannerid = 0;
    public int current_adx_bannerid = 0;
    public int current_facebook_bannerid = 0;

    public int current_admob_nativebannerid = 0;
    public int current_adx_nativebannerid = 0;
    public int current_facebook_nativebannerid = 0;

    public int current_admob_smallnativeid = 0;
    public int current_adx_smallnativeid = 0;
    public int current_facebook_smallnativeid = 0;


    public void setCarddata(Context activity1) {
        activity = activity1;
        appDataResponse = AppData_Utils.getResponse(activity);
        dataresponsearray.add(appDataResponse);
    }

    public interface AppDataback {
        void OnCall();
    }

    public void setAppDetail(Context activity1, String appname1, int applogo1) {
        activity = activity1;
        appname = appname1;
        applogo = applogo1;

    }

    public Chembur_Showcard(Context context) {
        activity = context;
        prefs = activity.getSharedPreferences(activity.getPackageName(), 0);
    }

    public static Chembur_Showcard getInstance(Context context) {
        activity = context;
        if (mInstance == null) {
            mInstance = new Chembur_Showcard(context);
        }
        return mInstance;
    }

    public static boolean isOnline(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    // --------------------------------------------------- Service -----------------------------------------------------------


    public static ArrayList<AppDataResponse> dataresponsearray = new ArrayList<>();

    // ---------------------------------------------------- Pre loadd Ads --------------------------------------------------------------

    public void card_preload(AppDataback appDataback) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {

            if (dataresponsearray.get(0).getAdNative() != null) {
                loadnative();
            }
            // Inter Ads
            if (dataresponsearray.get(0).getAdInter() != null) {
                loadinter();
            }
            // Banner Ads
            if (dataresponsearray.get(0).getAdBanner() != null) {
                loadbanner();
            }
            // Small native banner
            if (dataresponsearray.get(0).getAdSmallNativeBanner() != null) {
                loadsmallnativebanner();
            }
            // Small Native
            if (dataresponsearray.get(0).getAdSmallNative() != null) {
                loadsmallnative();
            }
//            // Back Inter Ads
            if (dataresponsearray.get(0).getAdInterBack() != null) {
                loadinterback();
            }
            callhandler(appDataback,3000L);
        }
    }


    public void loadAppopen(AppDataback appDataback) {
        // Native
        if (dataresponsearray.get(0).getAdNative() != null) {
            loadnative();
        }
        // Appopen
        if (dataresponsearray.get(0).getAdAppopen().equalsIgnoreCase(Admob)) {
            get_admob_appopen_AdsLoad();
        } else if (dataresponsearray.get(0).getAdAppopen().equalsIgnoreCase(Adx)) {
            get_adx_appopen_AdsLoad();
        }
        callhandler(appDataback,2500L);
    }

    public static ProgressDialog progressDialog;

    public void callhandler(AppDataback appDataback, long l) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Please Wait Loading data");
        progressDialog.setProgressStyle(0);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgress(0);
        progressDialog.show();
        try {
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                public void run() {
                    appDataback.OnCall();
                }
            };
            handler.postDelayed(runnable, l);
        } catch (Exception exception) {

        }
    }

    //-------------------------------------------------------- Banner Ads -------------------------------------------------------

    public void loadbanner() {
        if (dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdBanner();
            String[] platformarray = platform.split(Constnt.split);
            if (ad_banner_nerwork == platformarray.length) {
                ad_banner_nerwork = 0;
            }
            Log.d("MyAppDataResponse----", String.valueOf(ad_banner_nerwork));
            if (ad_banner_nerwork < platformarray.length) {
                switch (platformarray[ad_banner_nerwork]) {
                    case Admob:
                        preloadBannerAd_AAFB();
                        ad_banner_nerwork++;
                        break;
                    case Adx:
                        preloadBannerAd_Adx();
                        ad_banner_nerwork++;
                        break;
                    case FB:
                        preloadBannerAd_FBAA();
                        ad_banner_nerwork++;
                        break;
                }
            }
        }
    }

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void preloadBannerAd_AAFB() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(getAdsID(dataresponsearray.get(0).getAdmobBannerid(), current_admob_bannerid, 7));
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Banner.loadAd(adRequest);
            admob_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.d("MyAppDataResponse", "Admob Banner Loadedd ");
                    if (isGoogleBannerLoaded) return;
                    googleBannerAd = admob_Banner;
                    isGoogleBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    Log.d("MyAppDataResponse", "Admob Banner failed ");

                }
            });
            switchmode(Constnt.bannermode);
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void preloadBannerAd_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(getAdsID(dataresponsearray.get(0).getAdxBannerId(), current_adx_bannerid, 8));
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Adx Banner failed ");
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }
            });
            switchmode(Constnt.bannermode);
        }
    }

    // FB Mode
    public void preloadBannerAd_FBAA() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, getAdsID(dataresponsearray.get(0).getFbBannerId(), current_facebook_bannerid, 9), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Fb Banner Loadedd");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Banner Failed");
                }

                @Override
                public void onAdClicked(Ad ad) {
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };
            fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
            switchmode(Constnt.bannermode);
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad(final ViewGroup banner_container) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdBanner();
            if (!platform.equalsIgnoreCase("off")) {
                new AllType_Showcard(activity).show_banner_ad_AAF(banner_container);
            }
        }
    }

    //---------------------------------------------Small Native banner type Ads ----------------------------------------------
    public void loadsmallnativebanner() {
        if (dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdSmallNativeBanner();
            String[] platformarray = platform.split(Constnt.split);
            if (ad_nativebanner_nerwork == platformarray.length) {
                ad_nativebanner_nerwork = 0;
            }
            Log.d("MyAppDataResponse----", String.valueOf(ad_nativebanner_nerwork));
            if (ad_nativebanner_nerwork < platformarray.length) {
                switch (platformarray[ad_nativebanner_nerwork]) {
                    case Admob:
                        preload_Admob_Native_Banner_Ad();
                        ad_nativebanner_nerwork++;
                        break;
                    case Adx:
                        preload_Adx_Native_Banner();
                        ad_nativebanner_nerwork++;
                        break;
                    case FB:
                        preload_Fb_Native_BannerAd();
                        ad_nativebanner_nerwork++;
                        break;
                }
            }
        }
    }

    // Admob Mode
    void preload_Admob_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, getAdsID(dataresponsearray.get(0).getAdmobNativeid(), current_admob_nativebannerid, 10));
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
                isadmob_small_native_banner_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
            switchmode(Constnt.nativebannermode);
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    void preload_Adx_Native_Banner() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, getAdsID(dataresponsearray.get(0).getAdxNativeId(), current_adx_nativebannerid, 11));
            builder.forNativeAd(nativeAd -> {
                if (Adx_small_native_banner_Ad.size() > 0) {
                    Adx_small_native_banner_Ad.clear();
                    Adx_small_native_banner_Ad.add(nativeAd);
                } else {
                    Adx_small_native_banner_Ad.add(nativeAd);
                }
//                    Adx_small_native_banner_Ad.add(nativeAd);
                isadx_small_native_banner_Loaded = true;
                Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Failed");

                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
            switchmode(Constnt.nativebannermode);
        }
    }

    // FB Mode
    void preload_Fb_Native_BannerAd() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner_Ad = new NativeBannerAd(activity, getAdsID(dataresponsearray.get(0).getFbNativeBannerId(), current_facebook_nativebannerid, 12));
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Native ad finished downloading all assets.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Native ad failed to load: " + adError.getErrorMessage());

                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Native Banner ad is loaded");
                    if (fb_nativeBannerAd.size() > 0) {
                        fb_nativeBannerAd.clear();
                        fb_nativeBannerAd.add(fb_nativeBanner_Ad);
                    } else {
                        fb_nativeBannerAd.add(fb_nativeBanner_Ad);
                    }
//                    fb_nativeBannerAd.add(fb_nativeBanner_Ad);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("MyAppDataResponse", "FB Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner_Ad.loadAd(fb_nativeBanner_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            switchmode(Constnt.nativebannermode);
        }
    }

    public void show_small_native_banner_ad(final ViewGroup native_banner_ad) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdSmallNativeBanner();
            if (!platform.equalsIgnoreCase("off")) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Admob(native_banner_ad);
            }
        }
    }

    //--------------------------------------------- Small Native Ads --------------------------------------------------------------------------


    public void loadsmallnative() {
        if (dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdSmallNative();
            String[] platformarray = platform.split(Constnt.split);
            if (ad_smallnative_nerwork == platformarray.length) {
                ad_smallnative_nerwork = 0;
            }
            Log.d("MyAppDataResponse----", String.valueOf(ad_smallnative_nerwork));
            if (ad_smallnative_nerwork < platformarray.length) {
                switch (platformarray[ad_smallnative_nerwork]) {
                    case Admob:
                        preload_Admob_Small_Native_Ad();
                        ad_smallnative_nerwork++;
                        break;
                    case Adx:
                        preload_Adx_Small_Native_Ad();
                        ad_smallnative_nerwork++;
                        break;
                    case FB:
                        preload_Fb_Small_Native_Ad();
                        ad_smallnative_nerwork++;
                        break;
                }
            }
        }
    }

    // Admob Mode
    public void preload_Admob_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, getAdsID(dataresponsearray.get(0).getAdmobNativeid(), current_admob_smallnativeid, 13));
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Small Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
            switchmode(Constnt.smallnativemode);
        }
    }

    // Adx Mode
    public void preload_Adx_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, getAdsID(dataresponsearray.get(0).getAdxNativeId(), current_adx_smallnativeid, 14));
            builder.forNativeAd(nativeAd -> {
                Adx_small_native_Ad.add(nativeAd);
                isadx_small_native_Loaded = true;
                Log.d("MyAppDataResponse", "Adx Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Adx Small Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
            switchmode(Constnt.smallnativemode);
        }
    }

    // FB Mode
    public void preload_Fb_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, getAdsID(dataresponsearray.get(0).getFbNativeBannerId(), current_facebook_smallnativeid, 15));
            NativeAdListener nativeAdListener = new NativeAdListener() {

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Small Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                }


                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner.loadAd(fb_nativeBanner.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            switchmode(Constnt.smallnativemode);
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_ad(final ViewGroup native_banner_ad) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdSmallNative();
            if (!platform.equalsIgnoreCase("off")) {
                new AllType_Showcard(activity).show_small_native_Admob(native_banner_ad);
            }

        }
    }

    //--------------------------------------------- Native Ads --------------------------------------------------------------------------

    public int ad_native_nerwork = 0;
    public int ad_inter_nerwork = 0;
    public int ad_interback_nerwork = 0;
    public int ad_banner_nerwork = 0;
    public int ad_nativebanner_nerwork = 0;
    public int ad_smallnative_nerwork = 0;

    public void loadnative() {
        if (dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdNative();
            String[] platformarray = platform.split(",");
            if (ad_native_nerwork == platformarray.length) {
                ad_native_nerwork = 0;
            }
            Log.d("MyAppDataResponse----", String.valueOf(ad_native_nerwork));
            if (ad_native_nerwork < platformarray.length) {
                switch (platformarray[ad_native_nerwork]) {
                    case Admob:
                        preload_Admob_Native_Ad();
                        ad_native_nerwork++;
                        break;
                    case Adx:
                        preload_Adx_Native_Ad();
                        ad_native_nerwork++;
                        break;
                    case FB:
                        preloadFbNativeAd();
                        ad_native_nerwork++;
                        break;
                }
            }
        }
    }


    // Admob Mode
    @SuppressLint("MissingPermission")
    public void preload_Admob_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            Log.d("MyAppDataResponse----", String.valueOf(current_admob_nativeid));
            AdLoader adLoader = new AdLoader.Builder(activity, getAdsID(dataresponsearray.get(0).getAdmobNativeid(), current_admob_nativeid, 1))
                    .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                        @Override
                        public void onNativeAdLoaded(NativeAd nativeAd) {
                            Log.d("MyAppDataResponse----", "Admob Native ad load");
                            if (Admob_native_Ad.size() > 0) {
                                Admob_native_Ad.clear();
                                Admob_native_Ad.add(nativeAd);
                            } else {
                                Admob_native_Ad.add(nativeAd);
                            }
                            isadmob_native_Loaded = true;
                        }
                    })
                    .withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            Log.d("MyAppDataResponse----", "admob Native Ad Failed");
                            // Handle the failure by logging, altering the UI, and so on.
                        }
                    })
                    .withNativeAdOptions(new NativeAdOptions.Builder()
                            // Methods in the NativeAdOptions.Builder class can be
                            // used here to specify individual options settings.
                            .build())
                    .build();
            adLoader.loadAd(new AdRequest.Builder().build());
            switchmode(Constnt.nativemode);

        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void preload_Adx_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, getAdsID(dataresponsearray.get(0).getAdxNativeId(), current_adx_nativeid, 2));
            builder.forNativeAd(nativeAd -> {
                if (Adx_native_Ad.size() > 0) {
                    Adx_native_Ad.clear();
                    Adx_native_Ad.add(nativeAd);
                } else {
                    Adx_native_Ad.add(nativeAd);
                }
//                    Adx_native_Ad.add(nativeAd);
                isadx_native_Loaded = true;
                Log.d("MyAppDataResponse----", "Adx Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse----", "Adx Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
            switchmode(Constnt.nativemode);
        }
    }

    // FB Mode
    public void preloadFbNativeAd() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, getAdsID(dataresponsearray.get(0).getFbNativeId(), current_facebook_nativeid, 3));
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "Native ad Failed " + adError.getErrorMessage());

                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Native ad is loaded and ready to be displayed!");
                    if (fbnativeAd.size() > 0) {
                        fbnativeAd.clear();
                        fbnativeAd.add(fbnative_Ad);
                    } else {
                        fbnativeAd.add(fbnative_Ad);
                    }
//                    fbnativeAd.add(fbnative_Ad);
                    isFBNativeLoaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {

                    Log.d("MyAppDataResponse", "Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("MyAppDataResponse", "Native ad impression logged!");
                }
            };

            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
            switchmode(Constnt.nativemode);

        }
    }


    @SuppressLint("MissingPermission")
    public void show_native_ad(final ViewGroup native_ad) {

        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdNative();
            if (!platform.equalsIgnoreCase("off")) {
                new AllType_Showcard(activity).show_native_ad_AAFB(native_ad);
            }


        }
    }

    //-------------------------------------------- Inter Ads ----------------------------------------------------------------------------

    public void loadinterback() {
        if (dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdInterBack();
            String[] platformarray = platform.split(Constnt.split);
            if (ad_interback_nerwork == platformarray.length) {
                ad_interback_nerwork = 0;
            }
            Log.d("MyAppDataResponse----", String.valueOf(ad_interback_nerwork));
            if (ad_interback_nerwork < platformarray.length) {
                switch (platformarray[ad_interback_nerwork]) {
                    case Admob:
                        Load_interAds_Admob();
                        ad_interback_nerwork++;
                        break;
                    case Adx:
                        Load_interAds_Adx();
                        ad_interback_nerwork++;
                        break;
                    case FB:
                        Load_interAds_FB();
                        ad_interback_nerwork++;
                        break;
                    case Appopen:
                        if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Admob)) {
                            get_admob_appopen_AdsLoad();
                        } else if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Adx)) {
                            get_adx_appopen_AdsLoad();
                        }
                        break;
                }
            }
        }
    }

    public void loadinter() {
        if (dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdInter();
            String[] platformarray = platform.split(Constnt.split);
            if (ad_inter_nerwork == platformarray.length) {
                ad_inter_nerwork = 0;
            }
            Log.d("MyAppDataResponse----", String.valueOf(ad_inter_nerwork));
            if (ad_inter_nerwork < platformarray.length) {
                switch (platformarray[ad_inter_nerwork]) {
                    case Admob:
                        Load_interAds_Admob();
                        ad_inter_nerwork++;
                        break;
                    case Adx:
                        Load_interAds_Adx();
                        ad_inter_nerwork++;
                        break;
                    case FB:
                        Load_interAds_FB();
                        ad_inter_nerwork++;
                        break;
                    case Appopen:
                        if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Admob)) {
                            get_admob_appopen_AdsLoad();
                        } else if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Adx)) {
                            get_adx_appopen_AdsLoad();
                        }
                        break;
                }
            }
        }
    }

    // Admob Mode
    public void Load_interAds_Admob() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = getAdsID(dataresponsearray.get(0).getAdmobInterid(), current_admob_interid, 4);
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    Log.d("MyAppDataResponse", "Admob Inter Loaded");
                    ADMOBInterstitialAd = interstitialAd;
                    isGoogleInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("MyAppDataResponse", "Admob Inter Close");
                            qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                                ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (appDataback != null) {
                                    appDataback.OnCall();
                                    appDataback = null;
                                }
                                LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                            } else {
                                qurekaadCounter = qurekaadCounter + 1;
                                ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                                if (appDataback != null) {
                                    appDataback.OnCall();
                                    appDataback = null;
                                }
                            }

                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            Log.d("MyAppDataResponse", "Admob Inter failed to show" + adError.getMessage());
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.d("MyAppDataResponse", "Admob Inter Failed");

                }
            });
            switchmode(Constnt.intermode);
        }
    }

    // Adx Mode
    public void Load_interAds_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = getAdsID(dataresponsearray.get(0).getAdxInterId(), current_adx_interid, 5);
            final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    Log.d("MyAppDataResponse", "Adx Inter Loaded");
                    ADXInterstitialAd = interstitialAd;
                    isAdxInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("MyAppDataResponse", "Adx Inter Close");
                            qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                                ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (appDataback != null) {
                                    appDataback.OnCall();
                                    appDataback = null;
                                }
                                LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                            } else {
                                qurekaadCounter = qurekaadCounter + 1;
                                ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                                if (appDataback != null) {
                                    appDataback.OnCall();
                                    appDataback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.d("MyAppDataResponse", "Adx Inter Failed");

                }
            });
            switchmode(Constnt.intermode);
        }
    }

    // FB Mode
    public void Load_interAds_FB() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, getAdsID(dataresponsearray.get(0).getFbInterId(), current_facebook_interid, 6));
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    Log.d("MyAppDataResponse", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Inter Failed");

                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Inter ad Loaded");
                    FB_interstitialAd = FB_interstitial;
                    isFBInterLoaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Interstitial ad impression logged!");
                }
            };
            FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
            switchmode(Constnt.intermode);
        }
    }

    // Show Back Inter
    public void show_Interstitial_Back(AppDataback appDataback2) {
        appDataback = appDataback2;

        if (dataresponsearray.size() == 0) {
            appDataResponse = AppData_Utils.getResponse(activity);
            if (appDataResponse != null) {
                dataresponsearray.add(appDataResponse);
            }
        }

        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdInterBack();
            String[] platformarray = platform.split(Constnt.split);
            if (platformarray[0].equalsIgnoreCase(Appopen)) {
                showAd_appopen_inter(appDataback2);
            } else if (platformarray[0].equalsIgnoreCase("off")) {
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
            } else {
                show_Interstitial_Admob_Back(appDataback2);
            }
        }
    }

    // Admob Mode
    public void show_Interstitial_Admob_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                loadinterback();
            } else {
                adbackcounter = adbackcounter + 1;
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(adbackcounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                loadinterback();
            } else {
                adbackcounter = adbackcounter + 1;
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(adbackcounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                loadinterback();
            } else {
                adbackcounter = adbackcounter + 1;
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(adbackcounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        } else {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount()) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
                loadinterback();
            } else {
                adbackcounter = adbackcounter + 1;
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(adbackcounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        }
    }


    // Show Inter
    public void show_Interstitial(AppDataback appDataback2) {
        appDataback = appDataback2;

        if (Chembur_Showcard.isOnline(activity)) {
            if (dataresponsearray.size() == 0) {
                appDataResponse = AppData_Utils.getResponse(activity);
                if (appDataResponse != null) {
                    dataresponsearray.add(appDataResponse);
                }
            }
            if (dataresponsearray != null && dataresponsearray.size() > 0) {
                String platform = dataresponsearray.get(0).getAdInter();
                String[] platformarray = platform.split(Constnt.split);
                if (platformarray[0].equalsIgnoreCase(Appopen)) {
                    showAd_appopen_inter(appDataback2);
                } else if (platformarray[0].equalsIgnoreCase("off")) {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                } else {
                    show_Interstitial_Admob(appDataback2);
                }
            }
        } else {
            BottomSheetDialog networkcheckdialog = new BottomSheetDialog(activity);
            networkcheckdialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.internet_dialog, (ViewGroup) null));
            networkcheckdialog.setCancelable(false);
            TextView materialButton = (TextView) networkcheckdialog.findViewById(R.id.btn_recheck);

            materialButton.setOnClickListener(view -> {
                if (Chembur_Showcard.isOnline(activity)) {
                    networkcheckdialog.dismiss();
                    if (dataresponsearray.size() == 0) {
                        appDataResponse = AppData_Utils.getResponse(activity);
                        if (appDataResponse != null) {
                            dataresponsearray.add(appDataResponse);
                        }
                    }
                    if (dataresponsearray != null && dataresponsearray.size() > 0) {
                        String platform = dataresponsearray.get(0).getAdInter();
                        String[] platformarray = platform.split(Constnt.split);
                        if (platformarray[0].equalsIgnoreCase(Appopen)) {
                            showAd_appopen_inter(appDataback2);
                        } else if (platformarray[0].equalsIgnoreCase("off")) {
                            if (appDataback != null) {
                                appDataback.OnCall();
                                appDataback = null;
                            }
                        } else {
                            show_Interstitial_Admob(appDataback2);
                        }
                    }
                } else {
                    Toast.makeText(activity, "Please Connect Internet.", Toast.LENGTH_SHORT).show();
                }
            });
            networkcheckdialog.show();
        }
    }

    // Admob Mode
    public void show_Interstitial_Admob(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                loadinter();
            } else {
                adinterCounter = adinterCounter + 1;
                ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                loadinter();
            } else {
                adinterCounter = adinterCounter + 1;
                ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                loadinter();
            } else {
                adinterCounter = adinterCounter + 1;
                ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        } else {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
                loadinter();
            } else {
                adinterCounter = adinterCounter + 1;
                ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                    LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
                } else {
                    qurekaadCounter = qurekaadCounter + 1;
                    ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            }
        }
    }


    //---------------------------------------------- Appopen Ads ---------------------------------------------------------

    public void show_appopen_ads(AppDataback appDataback2) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            showAdIfAvailable(appDataback2);
        }
    }

    public void showAdIfAvailable(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String paltform = dataresponsearray.get(0).getAdAppopen();
            FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    admob_appOpenAd = null;
                    adx_appOpenAd = null;
                    if (paltform.equalsIgnoreCase(Admob)) {
                        get_admob_appopen_AdsLoad();
                    } else if (paltform.equalsIgnoreCase(Adx)) {
                        get_adx_appopen_AdsLoad();
                    }
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                    if (paltform.equalsIgnoreCase(Admob)) {
                        get_admob_appopen_AdsLoad();
                    } else if (paltform.equalsIgnoreCase(Adx)) {
                        get_adx_appopen_AdsLoad();
                    }
                }

                @Override
                public void onAdShowedFullScreenContent() {
                }
            };

            Log.d("MyAppDataResponse", "platttttt");
            if (paltform.equalsIgnoreCase(Admob)) {
                if (isadmob_appopen_Loaded) {
                    admob_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                    admob_appOpenAd.show((Activity) activity);
                    isadmob_appopen_Loaded = false;
                } else if (isadx_appopen_Loaded) {
                    adx_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                    adx_appOpenAd.show((Activity) activity);
                    isadx_appopen_Loaded = false;
                } else {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            } else if (paltform.equalsIgnoreCase(Adx)) {
                if (isadx_appopen_Loaded) {
                    adx_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                    adx_appOpenAd.show((Activity) activity);
                    isadx_appopen_Loaded = false;
                } else if (isadmob_appopen_Loaded) {
                    admob_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                    admob_appOpenAd.show((Activity) activity);
                    isadmob_appopen_Loaded = false;
                } else {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }
            } else if (paltform.equalsIgnoreCase("off")) {
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
            }
        }
    }

    public void showAd_appopen_inter(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String paltform = dataresponsearray.get(0).getAd_appopen_inter();
            FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    admob_appOpenAd = null;
                    adx_appOpenAd = null;
                    if (paltform.equalsIgnoreCase(Admob)) {
                        get_admob_appopen_AdsLoad();
                    } else if (paltform.equalsIgnoreCase(Adx)) {
                        get_adx_appopen_AdsLoad();
                    }
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                    if (paltform.equalsIgnoreCase(Admob)) {
                        get_admob_appopen_AdsLoad();
                    } else if (paltform.equalsIgnoreCase(Adx)) {
                        get_adx_appopen_AdsLoad();
                    }
                }

                @Override
                public void onAdShowedFullScreenContent() {
                }
            };
            if (paltform.equalsIgnoreCase(Admob)) {
                if (isadmob_appopen_Loaded) {
                    adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                        admob_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        admob_appOpenAd.show((Activity) activity);
                        isadmob_appopen_Loaded = false;
                    } else {
                        adinterCounter = adinterCounter + 1;
                        ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    }
                } else if (isadx_appopen_Loaded) {
                    adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                        adx_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        adx_appOpenAd.show((Activity) activity);
                        isadx_appopen_Loaded = false;
                    } else {
                        adinterCounter = adinterCounter + 1;
                        ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    }
                } else {
                    adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    } else {
                        adinterCounter = adinterCounter + 1;
                        ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    }
                }
            } else if (paltform.equalsIgnoreCase(Adx)) {
                if (isadx_appopen_Loaded) {
                    adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                        adx_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        adx_appOpenAd.show((Activity) activity);
                        isadx_appopen_Loaded = false;
                    } else {
                        adinterCounter = adinterCounter + 1;
                        ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    }
                } else if (isadmob_appopen_Loaded) {
                    adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                        admob_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        admob_appOpenAd.show((Activity) activity);
                        isadmob_appopen_Loaded = false;
                    } else {
                        adinterCounter = adinterCounter + 1;
                        ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    }
                } else {
                    adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adinterCounter == dataresponsearray.get(0).getInterCount()) {
                        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    } else {
                        adinterCounter = adinterCounter + 1;
                        ChemburPreferencesManager.getInstance(activity).storeClicks(adinterCounter);
                        if (appDataback != null) {
                            appDataback.OnCall();
                            appDataback = null;
                        }
                    }

                }
            } else if (paltform.equalsIgnoreCase("off")) {
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
            }
        }
    }

    // Admob
    public void get_admob_appopen_AdsLoad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob Appopen
            if (isadmob_appopen_Loaded) {
                return;
            }
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    Log.d("MyAppDataResponse", "Admob Open Ad loaded");
                    admob_appOpenAd = appOpenAd;
                    isadmob_appopen_Loaded = true;
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Adx Appopen
                    if (isadx_appopen_Loaded) {
                        return;
                    }
                    AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            super.onAdLoaded(appOpenAd);
                            Log.d("MyAppDataResponse", "Adx Open Ad loaded");
                            adx_appOpenAd = appOpenAd;
                            isadx_appopen_Loaded = true;
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                        }
                    };
                    AppOpenAd.load(activity, dataresponsearray.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, dataresponsearray.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
        }
    }

    // Adx
    public void get_adx_appopen_AdsLoad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx Appopen
            if (isadx_appopen_Loaded) {
                return;
            }
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    Log.d("MyAppDataResponse", "Adx Open Ad loaded");
                    adx_appOpenAd = appOpenAd;
                    isadx_appopen_Loaded = true;
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Admob Appopen
                    if (isadmob_appopen_Loaded) {
                        return;
                    }
                    AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            super.onAdLoaded(appOpenAd);
                            Log.d("MyAppDataResponse", "Admob Open Ad loaded");
                            admob_appOpenAd = appOpenAd;
                            isadmob_appopen_Loaded = true;
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                        }
                    };
                    AppOpenAd.load(activity, dataresponsearray.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, dataresponsearray.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
        }
    }

    // ----------------------------------------------- Splash Appopen Ads ------------------------------------------------------

    public void show_splash(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String paltform = dataresponsearray.get(0).getAdSplash();
            fullScreenContentCallback = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                }

                @Override
                public void onAdShowedFullScreenContent() {

                }
            };
            if (paltform.equalsIgnoreCase(Admob)) {
                getSplash_appopen_Admob(appDataback2);
            } else if (paltform.equalsIgnoreCase(Adx)) {
                getSplash_appopen_Adx(appDataback2);
            } else if (paltform.equalsIgnoreCase("off")) {
                new Handler().postDelayed(() -> {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
                }, 3000);
            }
        }
    }

    // Admob
    public void getSplash_appopen_Admob(AppDataback mCallback) {
        appDataback = mCallback;
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob Appopen
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    appOpenAd.show((Activity) activity);
                    Log.d("MyAppDataResponse", "Admob Appopen Show");
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Adx Appopen
                    AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            super.onAdLoaded(appOpenAd);
                            appOpenAd.show((Activity) activity);
                            Log.d("MyAppDataResponse", "Adx Appopen Show");
                            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            if (appDataback != null) {
                                appDataback.OnCall();
                                appDataback = null;
                            }
                        }
                    };
                    AppOpenAd.load(activity, dataresponsearray.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, dataresponsearray.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
        }
    }

    // Adx
    public void getSplash_appopen_Adx(AppDataback mCallback) {
        appDataback = mCallback;
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx Appopen
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    appOpenAd.show((Activity) activity);
                    Log.d("MyAppDataResponse", "Adx Appopen Show");
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Admob Appopen
                    AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            super.onAdLoaded(appOpenAd);
                            appOpenAd.show((Activity) activity);
                            Log.d("MyAppDataResponse", "Admob Appopen Show");
                            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            if (appDataback != null) {
                                appDataback.OnCall();
                                appDataback = null;
                            }
                        }
                    };
                    AppOpenAd.load(activity, dataresponsearray.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, dataresponsearray.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    @SuppressLint("VisibleForTests")
    private AdManagerAdRequest adManagerAdRequest() {
        return new AdManagerAdRequest.Builder().build();
    }

    public void show_splash_inter(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String placementId = dataresponsearray.get(0).getAdmob_splash_interid();
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    interstitialAd.show((Activity) activity);
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("MyAppDataResponse", "Admob Inter Close");
                            if (appDataback != null) {
                                appDataback.OnCall();
                                appDataback = null;
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            Log.d("MyAppDataResponse", "Admob Inter failed to show" + adError.getMessage());
                            if (appDataback != null) {
                                appDataback.OnCall();
                                appDataback = null;
                            }
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    String placementId = dataresponsearray.get(0).getAdx_splash_inter_id();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AdManagerInterstitialAd adManagerInterstitialAd) {
                            super.onAdLoaded(adManagerInterstitialAd);
                            adManagerInterstitialAd.show((Activity) activity);
                            adManagerInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("MyAppDataResponse", "Admob Inter Close");
                                    if (appDataback != null) {
                                        appDataback.OnCall();
                                        appDataback = null;
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                    Log.d("MyAppDataResponse", "Admob Inter failed to show" + adError.getMessage());
                                    if (appDataback != null) {
                                        appDataback.OnCall();
                                        appDataback = null;
                                    }
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFb_splash_inter_id());
                            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {
                                    if (appDataback != null) {
                                        appDataback.OnCall();
                                        appDataback = null;
                                    }
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    if (appDataback != null) {
                                        appDataback.OnCall();
                                        appDataback = null;
                                    }
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    FB_interstitial.show();
                                }

                                @Override
                                public void onAdClicked(Ad ad) {

                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                }
                            };
                            FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
                        }
                    });
                }
            });
        }
    }

    public String getAdsID(String adsid, int currentmode, int mode) {
        String[] adsModearray = adsid.split(Constnt.split_id);
        if (currentmode == adsModearray.length || currentmode > adsModearray.length) {
            currentmode = 0;
            switch (mode) {
                case 1:
                    current_admob_nativeid = 0;
                    break;
                case 2:
                    current_adx_nativeid = 0;
                    break;
                case 3:
                    current_facebook_nativeid = 0;
                    break;
                case 4:
                    current_admob_interid = 0;
                    break;
                case 5:
                    current_adx_interid = 0;
                    break;
                case 6:
                    current_facebook_interid = 0;
                    break;
                case 7:
                    current_admob_bannerid = 0;
                    break;
                case 8:
                    current_adx_bannerid = 0;
                    break;
                case 9:
                    current_facebook_bannerid = 0;
                    break;
                case 10:
                    current_admob_nativebannerid = 0;
                    break;
                case 11:
                    current_adx_nativebannerid = 0;
                    break;
                case 12:
                    current_facebook_nativebannerid = 0;
                    break;
                case 13:
                    current_admob_smallnativeid = 0;
                    break;
                case 14:
                    current_adx_smallnativeid = 0;
                    break;
                case 15:
                    current_facebook_smallnativeid = 0;
                    break;
            }

        }
        String adunit = adsModearray[currentmode];
        return adunit;
    }

    public void switchmode(String mode) {
        switch (mode) {
            case "native":
                current_admob_nativeid++;
                current_adx_nativeid++;
                current_facebook_nativeid++;
                break;
            case "inter":
                current_admob_interid++;
                current_adx_interid++;
                current_facebook_interid++;
                break;
            case "banner":
                current_admob_bannerid++;
                current_adx_bannerid++;
                current_facebook_bannerid++;
                break;
            case "nativebanner":
                current_admob_nativebannerid++;
                current_adx_nativebannerid++;
                current_facebook_nativebannerid++;
                break;
            case "small_native":
                current_admob_smallnativeid++;
                current_adx_smallnativeid++;
                current_facebook_smallnativeid++;
                break;

        }
    }

}