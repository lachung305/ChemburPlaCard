package leaflist.showcard.meadiablink.chemburplacard;

import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Admob;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Admob_Adx;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Admob_Fb;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Adx;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Adx_Admob;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Adx_Fb;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Appopen;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.FB;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Fb_Admob;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Fb_Adx;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.Mrec;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdmob_Mediam_Ragtangal_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdmob_small_native_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdxBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdxInterLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isAdx_Mediam_Ragtangal_Loaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFBBannerLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFBInterLoaded;
import static leaflist.showcard.meadiablink.chemburplacard.Constnt.isFB_Mediam_Ragtangal_Loaded;
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
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

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

            // Native
            if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Admob)) {
                preload_Admob_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Adx)) {
                preload_Adx_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(FB)) {
                preloadFbNativeAd();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Admob_Adx)) {
                preload_Admob_Adx_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Admob_Fb)) {
                preload_Admob_Fb_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Adx_Admob)) {
                preload_Adx_Admob_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Adx_Fb)) {
                preload_Adx_Fb_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Fb_Admob)) {
                preload_Fb_Admob_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Fb_Adx)) {
                preload_Fb_Adx_Native_Ad();
            } else if (dataresponsearray.get(0).getAdNative().equalsIgnoreCase(Mrec)) {
                Merc_Banner_Ad();
            }

            // Inter Ads
            if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Admob)) {
                Load_interAds_Admob();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Adx)) {
                Load_interAds_Adx();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(FB)) {
                Load_interAds_FB();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Admob_Adx)) {
                Admob_Adx();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Admob_Fb)) {
                Admob_Fb();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Adx_Admob)) {
                Adx_Admob();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Adx_Fb)) {
                Adx_Fb();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Fb_Admob)) {
                Fb_Admob();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Fb_Adx)) {
                Fb_Adx();
            } else if (dataresponsearray.get(0).getAdInter().equalsIgnoreCase(Appopen)) {
                if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Admob)) {
                    get_admob_appopen_AdsLoad();
                } else if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Adx)) {
                    get_adx_appopen_AdsLoad();
                }
            }

            // Banner Ads
            if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Admob)) {
                preloadBannerAd_AAFB();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Adx)) {
                preloadBannerAd_Adx();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(FB)) {
                preloadBannerAd_FBAA();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Admob_Adx)) {
                preload_Banner_Admob_Adx();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Admob_Fb)) {
                preload_Banner_Admob_Fb();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Adx_Admob)) {
                preload_Banner_Adx_Admob();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Adx_Fb)) {
                preload_Banner_Adx_Fb();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Fb_Admob)) {
                preload_Banner_Fb_Admob();
            } else if (dataresponsearray.get(0).getAdBanner().equalsIgnoreCase(Fb_Adx)) {
                preload_Banner_Fb_Adx();
            }

            // Small native banner
            if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob)) {
                preload_Admob_Native_Banner_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx)) {
                preload_Adx_Native_Banner();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(FB)) {
                preload_Fb_Native_BannerAd();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob_Adx)) {
                preload_Admob_Adx_Native_Banner_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob_Fb)) {
                preload_Admob_Fb_Native_Banner_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx_Admob)) {
                preload_Adx_Admob_Native_Banner_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx_Fb)) {
                preload_Adx_Fb_Native_Banner_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Fb_Admob)) {
                preload_Fb_Admob_Native_Banner_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Fb_Adx)) {
                preload_Fb_Adx_Native_Banner_Ad();
            }

            // Small Native
            if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Admob)) {
                preload_Admob_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Adx)) {
                preload_Adx_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(FB)) {
                preload_Fb_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Admob_Adx)) {
                preload_Admob_Adx_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Admob_Fb)) {
                preload_Admob_Fb_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Adx_Admob)) {
                preload_Adx_Admob_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Adx_Fb)) {
                preload_Adx_Fb_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Fb_Admob)) {
                preload_Fb_Admob_Small_Native_Ad();
            } else if (dataresponsearray.get(0).getAdSmallNative().equalsIgnoreCase(Fb_Adx)) {
                preload_Fb_Adx_Small_Native_Ad();
            }


//            // Back Inter Ads
            if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Admob)) {
                Load_interAds_Admob();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Adx)) {
                Load_interAds_Adx();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(FB)) {
                Load_interAds_FB();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Admob_Adx)) {
                Admob_Adx();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Admob_Fb)) {
                Admob_Fb();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Adx_Admob)) {
                Adx_Admob();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Adx_Fb)) {
                Adx_Fb();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Fb_Admob)) {
                Fb_Admob();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Fb_Adx)) {
                Fb_Adx();
            } else if (dataresponsearray.get(0).getAdInterBack().equalsIgnoreCase(Appopen)) {
                if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Admob)) {
                    get_admob_appopen_AdsLoad();
                } else if (dataresponsearray.get(0).getAd_appopen_inter().equalsIgnoreCase(Adx)) {
                    get_adx_appopen_AdsLoad();
                }
            }

            // Appopen
            if (dataresponsearray.get(0).getAdAppopen().equalsIgnoreCase(Admob)) {
                get_admob_appopen_AdsLoad();
            } else if (dataresponsearray.get(0).getAdAppopen().equalsIgnoreCase(Adx)) {
                get_adx_appopen_AdsLoad();
            }
            appDataback.OnCall();
        }
    }

    //-------------------------------------------------------- Banner Ads -------------------------------------------------------

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void preloadBannerAd_AAFB() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
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
                    // Adx
                    if (isAdxBannerLoaded) return;
                    final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                    adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
                    @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Banner.loadAd(adRequest);
                    adx_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                            adxBannerAd = adx_Banner;
                            isAdxBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            // Fb Banner
                            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "Fb banner onError: " + adError.getErrorCode());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Banner Loadedd ");
                                    fbadView = fb_banner;
                                    isFBBannerLoaded = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                }
                            };
                            fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
                        }
                    });
                }
            });
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
            adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Admob
                    if (isGoogleBannerLoaded) return;
                    final AdView admob_Banner = new AdView(activity);
                    admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    admob_Banner.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
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
                            // Fb Banner
                            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Banner Loadedd ");
                                    fbadView = fb_banner;
                                    isFBBannerLoaded = true;
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "Fb banner onError: " + adError.getErrorCode());
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                }
                            };
                            fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
                        }
                    });
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }
            });
        }
    }

    // FB Mode
    public void preloadBannerAd_FBAA() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Banner Failed");
                    // Admob
                    if (isGoogleBannerLoaded) return;
                    final AdView admob_BannerAd = new AdView(activity);
                    admob_BannerAd.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    admob_BannerAd.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
                    AdRequest adRequest = new AdRequest.Builder().build();
                    admob_BannerAd.loadAd(adRequest);
                    admob_BannerAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            Log.d("MyAppDataResponse", "Admob Banner Loadedd ");
                            if (isGoogleBannerLoaded) return;
                            googleBannerAd = admob_BannerAd;
                            isGoogleBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                            Log.d("MyAppDataResponse", "Admob Banner Failed");
                            // Adx
                            if (isAdxBannerLoaded) return;
                            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                            adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
                            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                            adx_Banner.loadAd(adRequest);
                            adx_Banner.setAdListener(new AdListener() {

                                @Override
                                public void onAdLoaded() {
                                    super.onAdLoaded();
                                    Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                                    adxBannerAd = adx_Banner;
                                    isAdxBannerLoaded = true;
                                }

                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("MyAppDataResponse", "Adx Banner Failed");
                                }
                            });
                        }
                    });
                }

                @Override
                public void onAdClicked(Ad ad) {
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };
            fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
        }
    }

    public void preload_Banner_Admob_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
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
                    // Adx
                    if (isAdxBannerLoaded) return;
                    final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                    adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
                    @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Banner.loadAd(adRequest);
                    adx_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                            adxBannerAd = adx_Banner;
                            isAdxBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            //  preload_Banner_Admob_Adx();
                        }
                    });
                }
            });
        }
    }

    public void preload_Banner_Admob_Fb() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
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
                    // FB
                    final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                    com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("MyAppDataResponse", "Fb Banner Loadedd ");
                            fbadView = fb_banner;
                            isFBBannerLoaded = true;
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Banner Failed");
                            // preload_Banner_Admob_Fb();
                        }

                        @Override
                        public void onAdClicked(Ad ad) {
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {
                        }
                    };
                    fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
                }
            });
        }
    }

    public void preload_Banner_Adx_Admob() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Admob
                    if (isGoogleBannerLoaded) return;
                    final AdView admob_Banner = new AdView(activity);
                    admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    admob_Banner.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
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
                            // preload_Banner_Adx_Admob();
                        }
                    });
                }
            });
        }

    }

    public void preload_Banner_Adx_Fb() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // FB
                    final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                    com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("MyAppDataResponse", "Fb Banner Loadedd ");
                            fbadView = fb_banner;
                            isFBBannerLoaded = true;
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Banner Failed");
                            //preload_Banner_Adx_Fb();
                        }

                        @Override
                        public void onAdClicked(Ad ad) {
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {
                        }
                    };
                    fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
                }
            });
        }
    }

    public void preload_Banner_Fb_Admob() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Banner Failed");
                    // Admob
                    if (isGoogleBannerLoaded) return;
                    final AdView admob_Banner = new AdView(activity);
                    admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    admob_Banner.setAdUnitId(dataresponsearray.get(0).getAdmobBannerid());
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
                            //preload_Banner_Fb_Admob();
                        }
                    });
                }

                @Override
                public void onAdClicked(Ad ad) {
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };
            fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
        }
    }

    public void preload_Banner_Fb_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Banner Failed");
                    // Adx
                    if (isAdxBannerLoaded) return;
                    final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                    adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    adx_Banner.setAdUnitId(dataresponsearray.get(0).getAdxBannerId());
                    @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Banner.loadAd(adRequest);
                    adx_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("MyAppDataResponse", "Adx Banner Loadedd ");
                            adxBannerAd = adx_Banner;
                            isAdxBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            //preload_Banner_Fb_Adx();
                        }
                    });
                }

                @Override
                public void onAdClicked(Ad ad) {
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                }
            };
            fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
        }
    }


    @SuppressLint("MissingPermission")
    public void show_banner_ad(final ViewGroup banner_container) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdBanner();
            if (platform.equalsIgnoreCase(Admob)) {
                new AllType_Showcard(activity).show_banner_ad_AAF(banner_container);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new AllType_Showcard(activity).show_banner_ad_Adx(banner_container);
            } else if (platform.equalsIgnoreCase(FB)) {
                new AllType_Showcard(activity).show_banner_ad_FBAA(banner_container);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new AllType_Showcard(activity).show_banner_ad_Admob_Adx(banner_container);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new AllType_Showcard(activity).show_banner_ad_Admob_Fb(banner_container);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new AllType_Showcard(activity).show_banner_ad_Adx_Admob(banner_container);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new AllType_Showcard(activity).show_banner_ad_Adx_Fb(banner_container);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new AllType_Showcard(activity).show_banner_ad_Fb_Admob(banner_container);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new AllType_Showcard(activity).show_banner_ad_Fb_Adx(banner_container);
            }
        }
    }

    //---------------------------------------------Small Native banner type Ads ----------------------------------------------

    // Admob Mode
    void preload_Admob_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
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
                    // Adx
                    if (isadx_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_small_native_banner_Ad.size() > 0) {
                            Adx_small_native_banner_Ad.clear();
                            Adx_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Adx_small_native_banner_Ad.add(nativeAd);
                        }
                        isadx_small_native_banner_Loaded = true;
                        Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Failed");
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                                    if (fb_nativeBannerAd.size() > 0) {
                                        fb_nativeBannerAd.clear();
                                        fb_nativeBannerAd.add(fb_nativeBanner);
                                    } else {
                                        fb_nativeBannerAd.add(fb_nativeBanner);
                                    }
                                    isFBNative_Banner_Loaded = true;
                                }

                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("MyAppDataResponse", "FB Native Banner Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Small Native Banner ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Small Native Banner ad impression logged!");
                                }
                            };
                            // Request an ad
                            fb_nativeBanner.loadAd(fb_nativeBanner.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
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
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Loaded");
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Failed");
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("MyAppDataResponse", "FB Native Banner Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {

                                    Log.d("MyAppDataResponse", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                                    if (fb_nativeBannerAd.size() > 0) {
                                        fb_nativeBannerAd.clear();
                                        fb_nativeBannerAd.add(fb_native_BannerAd);
                                    } else {
                                        fb_nativeBannerAd.add(fb_native_BannerAd);
                                    }
//                                    fb_nativeBannerAd.add(fb_native_BannerAd);
                                    isFBNative_Banner_Loaded = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {

                                    Log.d("MyAppDataResponse", "FB Small Native Banner ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                    Log.d("MyAppDataResponse", "FB Small Native Banner ad impression logged!");
                                }
                            };
                            // Request an ad
                            fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }

    // FB Mode
    void preload_Fb_Native_BannerAd() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner_Ad = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Native ad finished downloading all assets.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Native ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                            // Adx
                            if (isadx_small_native_banner_Loaded) {
                                return;
                            }
                            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                            builder.forNativeAd(nativeAd -> {
                                if (Adx_small_native_banner_Ad.size() > 0) {
                                    Adx_small_native_banner_Ad.clear();
                                    Adx_small_native_banner_Ad.add(nativeAd);
                                } else {
                                    Adx_small_native_banner_Ad.add(nativeAd);
                                }
//                                    Adx_small_native_banner_Ad.add(nativeAd);
                                isadx_small_native_banner_Loaded = true;
                                Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                            });
                            builder.withAdListener(new AdListener() {
                                @SuppressLint("MissingPermission")
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                                }

                                public void onAdLoaded() {
                                    super.onAdLoaded();
                                }
                            }).build().loadAd(new AdManagerAdRequest.Builder().build());
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
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
        }
    }

    public void preload_Admob_Adx_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
//                    Admob_small_native_banner_Ad.add(nativeAd);
                isadmob_small_native_banner_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Failed");
                    // Adx
                    if (isadx_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_small_native_banner_Ad.size() > 0) {
                            Adx_small_native_banner_Ad.clear();
                            Adx_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Adx_small_native_banner_Ad.add(nativeAd);
                        }
//                            Adx_small_native_banner_Ad.add(nativeAd);
                        isadx_small_native_banner_Loaded = true;
                        Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Failed");
                            //preload_Admob_Adx_Native_Banner_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Admob_Fb_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
//                    Admob_small_native_banner_Ad.add(nativeAd);
                isadmob_small_native_banner_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Failed");
                    // Fb
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("MyAppDataResponse", "FB Native Banner Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                            //preload_Admob_Fb_Native_Banner_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                            if (fb_nativeBannerAd.size() > 0) {
                                fb_nativeBannerAd.clear();
                                fb_nativeBannerAd.add(fb_native_BannerAd);
                            } else {
                                fb_nativeBannerAd.add(fb_native_BannerAd);
                            }
//                            fb_nativeBannerAd.add(fb_native_BannerAd);
                            isFBNative_Banner_Loaded = true;
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                            Log.d("MyAppDataResponse", "FB Small Native Banner ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                            Log.d("MyAppDataResponse", "FB Small Native Banner ad impression logged!");
                        }
                    };
                    // Request an ad
                    fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Adx_Admob_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Failed");
                            // preload_Adx_Admob_Native_Banner_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }

    public void preload_Adx_Fb_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                    // Fb
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("MyAppDataResponse", "FB Native Banner Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                            //preload_Adx_Fb_Native_Banner_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                            if (fb_nativeBannerAd.size() > 0) {
                                fb_nativeBannerAd.clear();
                                fb_nativeBannerAd.add(fb_native_BannerAd);
                            } else {
                                fb_nativeBannerAd.add(fb_native_BannerAd);
                            }
//                            fb_nativeBannerAd.add(fb_native_BannerAd);
                            isFBNative_Banner_Loaded = true;
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                            Log.d("MyAppDataResponse", "FB Small Native Banner ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                            Log.d("MyAppDataResponse", "FB Small Native Banner ad impression logged!");
                        }
                    };
                    // Request an ad
                    fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }


    public void preload_Fb_Admob_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Native Banner Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Small Native Banner Ad Failed");
                            //preload_Fb_Admob_Native_Banner_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                    if (fb_nativeBannerAd.size() > 0) {
                        fb_nativeBannerAd.clear();
                        fb_nativeBannerAd.add(fb_native_BannerAd);
                    } else {
                        fb_nativeBannerAd.add(fb_native_BannerAd);
                    }
//                    fb_nativeBannerAd.add(fb_native_BannerAd);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {

                    Log.d("MyAppDataResponse", "FB Small Native Banner ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("MyAppDataResponse", "FB Small Native Banner ad impression logged!");
                }
            };
            // Request an ad
            fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Fb_Adx_Native_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Native Banner Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                    // Adx
                    if (isadx_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_small_native_banner_Ad.size() > 0) {
                            Adx_small_native_banner_Ad.clear();
                            Adx_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Adx_small_native_banner_Ad.add(nativeAd);
                        }
//                            Adx_small_native_banner_Ad.add(nativeAd);
                        isadx_small_native_banner_Loaded = true;
                        Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Adx Small Native Banner Ad Failed");
                            // preload_Fb_Adx_Native_Banner_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native Banner ad is loaded");
                    if (fb_nativeBannerAd.size() > 0) {
                        fb_nativeBannerAd.clear();
                        fb_nativeBannerAd.add(fb_native_BannerAd);
                    } else {
                        fb_nativeBannerAd.add(fb_native_BannerAd);
                    }
//                    fb_nativeBannerAd.add(fb_native_BannerAd);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {

                    Log.d("MyAppDataResponse", "FB Small Native Banner ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("MyAppDataResponse", "FB Small Native Banner ad impression logged!");
                }
            };
            // Request an ad
            fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void show_small_native_banner_ad(final ViewGroup native_banner_ad) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdSmallNativeBanner();
            if (platform.equalsIgnoreCase(Admob)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(FB)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_FB(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Admob_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Admob_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Adx_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Adx_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Fb_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new AllType_Showcard(activity).show_samll_native_bannerad_Fb_Adx(native_banner_ad);
            }
        }
    }

    //--------------------------------------------- Small Native Ads --------------------------------------------------------------------------

    // Admob Mode
    public void preload_Admob_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
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
                    // Adx
                    if (isadx_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("MyAppDataResponse", "FB Small Native Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Small Native ad failed " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Small Native ad is loaded");
                                    fb_nativeBannerAd.add(fb_nativeBanner);
                                    isFBNative_Banner_Loaded = true;
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
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    // Adx Mode
    public void preload_Adx_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
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
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("MyAppDataResponse", "FB Small Native Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Small Native ad failed " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Small Native ad is loaded");
                                    fb_nativeBannerAd.add(fb_nativeBanner);
                                    isFBNative_Banner_Loaded = true;
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
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }

    // FB Mode
    public void preload_Fb_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
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
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
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
                            // Adx
                            if (isadx_small_native_Loaded) {
                                return;
                            }
                            AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
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
        }
    }

    public void preload_Admob_Adx_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Small Native Ad Failed");
                    // Adx
                    if (isadx_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                            //preload_Admob_Adx_Small_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Admob_Fb_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Small Native Ad Failed");
                    // FB
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("MyAppDataResponse", "FB Small Native Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                            //preload_Admob_Fb_Small_Native_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("MyAppDataResponse", "FB Small Native ad is loaded");
                            fb_nativeBannerAd.add(fb_nativeBanner);
                            isFBNative_Banner_Loaded = true;
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
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Adx_Admob_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Admob_small_native_Ad.add(nativeAd);
                        isAdmob_small_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Small Native Ad Failed");
                            //preload_Adx_Admob_Small_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }

    public void preload_Adx_Fb_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                    // FB
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("MyAppDataResponse", "FB Small Native Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                            //preload_Adx_Fb_Small_Native_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("MyAppDataResponse", "FB Small Native ad is loaded");
                            fb_nativeBannerAd.add(fb_nativeBanner);
                            isFBNative_Banner_Loaded = true;
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
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }


    public void preload_Fb_Admob_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Small Native Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Admob_small_native_Ad.add(nativeAd);
                        isAdmob_small_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Small Native Ad Failed");
                            //preload_Fb_Admob_Small_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
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
        }
    }

    public void preload_Fb_Adx_Small_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, dataresponsearray.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("MyAppDataResponse", "FB Small Native Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                    // Adx
                    if (isadx_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
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
                            //preload_Fb_Adx_Small_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Small Native ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
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
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_ad(final ViewGroup native_banner_ad) {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdSmallNative();
            if (platform.equalsIgnoreCase(Admob)) {
                new AllType_Showcard(activity).show_small_native_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new AllType_Showcard(activity).show_small_native_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(FB)) {
                new AllType_Showcard(activity).show_small_native_FB(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new AllType_Showcard(activity).show_small_native_Admob_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new AllType_Showcard(activity).show_small_native_Admob_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new AllType_Showcard(activity).show_small_native_Adx_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new AllType_Showcard(activity).show_small_native_Adx_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new AllType_Showcard(activity).show_small_native_Fb_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new AllType_Showcard(activity).show_small_native_Fb_Adx(native_banner_ad);
            }
        }
    }

    //--------------------------------------------- Native Ads --------------------------------------------------------------------------

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void preload_Admob_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_native_Ad.size() > 0) {
                    Admob_native_Ad.clear();
                    Admob_native_Ad.add(nativeAd);
                } else {
                    Admob_native_Ad.add(nativeAd);
                }
//                    Admob_native_Ad.add(nativeAd);
                isadmob_native_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                    // Adx
                    if (isadx_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_native_Ad.size() > 0) {
                            Adx_native_Ad.clear();
                            Adx_native_Ad.add(nativeAd);
                        } else {
                            Adx_native_Ad.add(nativeAd);
                        }
//                            Adx_native_Ad.add(nativeAd);
                        isadx_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                            // FB
                            if (isFBNativeLoaded) {
                                return;
                            }
                            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("MyAppDataResponse", "FB Native ad finished downloading all assets.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Native ad Failed " + adError.getErrorMessage());
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
//                                    fbnativeAd.add(fbnative_Ad);
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
                            // Request an ad
//                            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());

                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
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
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                if (Adx_native_Ad.size() > 0) {
                    Adx_native_Ad.clear();
                    Adx_native_Ad.add(nativeAd);
                } else {
                    Adx_native_Ad.add(nativeAd);
                }
//                    Adx_native_Ad.add(nativeAd);
                isadx_native_Loaded = true;
                Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                    // Admob Native
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                            // FB
                            if (isFBNativeLoaded) {
                                return;
                            }
                            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("MyAppDataResponse", "FB Native ad finished downloading all assets.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Native ad Failed " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    if (fbnativeAd.size() > 0) {
                                        fbnativeAd.clear();
                                        fbnativeAd.add(fbnative_Ad);
                                    } else {
                                        fbnativeAd.add(fbnative_Ad);
                                    }
//                                    fbnativeAd.add(fbnative_Ad);
                                    isFBNativeLoaded = true;
                                    // Native ad is loaded and ready to be displayed
                                    Log.d("MyAppDataResponse", "Native ad is loaded and ready to be displayed!");
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
                            // Request an ad
//                            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    // FB Mode
    public void preloadFbNativeAd() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
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
                    // Admob
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                            // Adx
                            if (isadx_native_Loaded) {
                                return;
                            }
                            AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                            builder.forNativeAd(nativeAd -> {
                                if (Adx_native_Ad.size() > 0) {
                                    Adx_native_Ad.clear();
                                    Adx_native_Ad.add(nativeAd);
                                } else {
                                    Adx_native_Ad.add(nativeAd);
                                }
//                                    Adx_native_Ad.add(nativeAd);
                                isadx_native_Loaded = true;
                                Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                            });
                            builder.withAdListener(new AdListener() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                                }

                                public void onAdLoaded() {
                                    super.onAdLoaded();
                                }
                            }).build().loadAd(new AdRequest.Builder().build());
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
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
            // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        }
    }

    public void preload_Admob_Adx_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_native_Ad.size() > 0) {
                    Admob_native_Ad.clear();
                    Admob_native_Ad.add(nativeAd);
                } else {
                    Admob_native_Ad.add(nativeAd);
                }
//                    Admob_native_Ad.add(nativeAd);
                isadmob_native_Loaded = true;
                Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                    // Adx
                    if (isadx_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                        if (Adx_native_Ad.size() > 0) {
                            Adx_native_Ad.clear();
                            Adx_native_Ad.add(nativeAd);
                        } else {
                            Adx_native_Ad.add(nativeAd);
                        }
//                            Adx_native_Ad.add(nativeAd);
                        isadx_native_Loaded = true;
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                            //preload_Admob_Adx_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Admob_Fb_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
                if (Admob_native_Ad.size() > 0) {
                    Admob_native_Ad.clear();
                    Admob_native_Ad.add(nativeAd);
                } else {
                    Admob_native_Ad.add(nativeAd);
                }
//                    Admob_native_Ad.add(nativeAd);
                isadmob_native_Loaded = true;
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                    //Fb
                    if (isFBNativeLoaded) {
                        return;
                    }
                    final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            Log.d("MyAppDataResponse", "Native ad finished downloading all assets.");
                        }

                        @SuppressLint("MissingPermission")
                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "Native ad Failed " + adError.getErrorMessage());
                            //preload_Admob_Fb_Native_Ad();
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
//                            fbnativeAd.add(fbnative_Ad);
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
                    // Request an ad
//                    fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                    fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }


    public void preload_Adx_Admob_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                if (Adx_native_Ad.size() > 0) {
                    Adx_native_Ad.clear();
                    Adx_native_Ad.add(nativeAd);
                } else {
                    Adx_native_Ad.add(nativeAd);
                }
//                    Adx_native_Ad.add(nativeAd);
                isadx_native_Loaded = true;
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                    // Admob Native
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                            // preload_Adx_Admob_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Adx_Fb_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                if (Adx_native_Ad.size() > 0) {
                    Adx_native_Ad.clear();
                    Adx_native_Ad.add(nativeAd);
                } else {
                    Adx_native_Ad.add(nativeAd);
                }
//                    Adx_native_Ad.add(nativeAd);
                isadx_native_Loaded = true;
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                    //Fb Native
                    if (isFBNativeLoaded) {
                        return;
                    }
                    final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            Log.d("MyAppDataResponse", "Native ad finished downloading all assets.");
                        }

                        @SuppressLint("MissingPermission")
                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "Native ad Failed " + adError.getErrorMessage());
                            //preload_Adx_Fb_Native_Ad();
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
//                            fbnativeAd.add(fbnative_Ad);
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
                    // Request an ad
//                    fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                    fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Fb_Admob_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "Native ad Failed " + adError.getErrorMessage());
                    // Admob Native
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("MyAppDataResponse", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Admob Native Ad Failed");
                            // preload_Fb_Admob_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
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
            // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        }
    }

    public void preload_Fb_Adx_Native_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, dataresponsearray.get(0).getFbNativeId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    Log.d("MyAppDataResponse", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "Native ad Failed " + adError.getErrorMessage());
                    // Adx
                    if (isadx_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, dataresponsearray.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Log.d("MyAppDataResponse", "Adx Native Ad Loaded");
                        if (Adx_native_Ad.size() > 0) {
                            Adx_native_Ad.clear();
                            Adx_native_Ad.add(nativeAd);
                        } else {
                            Adx_native_Ad.add(nativeAd);
                        }
//                            Adx_native_Ad.add(nativeAd);
                        isadx_native_Loaded = true;
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("MyAppDataResponse", "Adx Native Ad Failed");
                            //preload_Fb_Adx_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
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
            // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        }
    }


    // Mode MREC Banner
    @SuppressLint("MissingPermission")
    public void Merc_Banner_Ad() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            //Admob Mediam Ragtangal
            if (isAdmob_Mediam_Ragtangal_Loaded) {
                return;
            }
            final AdView admob_Mediam_Ragtangal = new AdView(activity);
            admob_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
            admob_Mediam_Ragtangal.setAdUnitId(dataresponsearray.get(0).getAdmobMediumRectangleid());
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Mediam_Ragtangal.loadAd(adRequest);
            admob_Mediam_Ragtangal.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("MyAppDataResponse", "admob mediam ragtangal loaded");
                    admobMediam_Ragtangal = admob_Mediam_Ragtangal;
                    isAdmob_Mediam_Ragtangal_Loaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    Log.d("MyAppDataResponse", "admob mediam ragtangal failed");
                    // Adx
                    if (isAdx_Mediam_Ragtangal_Loaded) {
                        return;
                    }
                    final AdManagerAdView adx_Mediam_Ragtangal = new AdManagerAdView(activity);
                    adx_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
                    adx_Mediam_Ragtangal.setAdUnitId(dataresponsearray.get(0).getAdxMediumRectangleid());
                    AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Mediam_Ragtangal.loadAd(adRequest);
                    adx_Mediam_Ragtangal.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("MyAppDataResponse", "adx mediam ragtangal loaded");
                            adxMediam_Ragtangal = adx_Mediam_Ragtangal;
                            isAdx_Mediam_Ragtangal_Loaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                            Log.d("MyAppDataResponse", "adx mediam ragtangal failed");
                            // Fb
                            if (isFB_Mediam_Ragtangal_Loaded) {
                                return;
                            }
                            final com.facebook.ads.AdView fb_Ragtangal = new com.facebook.ads.AdView(activity, dataresponsearray.get(0).getFbMediumRectangleId(), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB mediam ragtangal Loadedd ");
                                    fb_Ragtangal_adView = fb_Ragtangal;
                                    isFB_Mediam_Ragtangal_Loaded = true;
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "Fb mediam ragtangal onError: " + adError.getErrorCode());
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                }
                            };
                            fb_Ragtangal.loadAd(fb_Ragtangal.buildLoadAdConfig().withAdListener(adListener).build());
                        }
                    });
                }
            });
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad(final ViewGroup native_ad) {

        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            String platform = dataresponsearray.get(0).getAdNative();
            if (platform.equalsIgnoreCase(Admob)) {
                new AllType_Showcard(activity).show_native_ad_AAFB(native_ad);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new AllType_Showcard(activity).show_native_ad_Adx(native_ad);
            } else if (platform.equalsIgnoreCase(FB)) {
                new AllType_Showcard(activity).show_native_ad_FBAA(native_ad);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new AllType_Showcard(activity).show_native_ad_Admob_Adx(native_ad);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new AllType_Showcard(activity).show_native_ad_Admob_Fb(native_ad);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new AllType_Showcard(activity).show_native_ad_Adx_Admob(native_ad);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new AllType_Showcard(activity).show_native_ad_Adx_Fb(native_ad);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new AllType_Showcard(activity).show_native_ad_Fb_Admob(native_ad);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new AllType_Showcard(activity).show_native_ad_Fb_Adx(native_ad);
            } else if (platform.equalsIgnoreCase(Mrec)) {
                new AllType_Showcard(activity).show_MREC_Banner(native_ad);
            }
        }
    }

    //-------------------------------------------- Inter Ads ----------------------------------------------------------------------------

    // Admob Mode
    public void Load_interAds_Admob() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = dataresponsearray.get(0).getAdmobInterid();
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
                    // ADX
                    if (isAdxInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdxInterId();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
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
                            // FB
                            if (isFBInterLoaded) {
                                return;
                            }
                            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
                            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {

                                    Log.d("MyAppDataResponse", "FB Inter ad Show.");
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {

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
                                    Log.d("MyAppDataResponse", "FB  Inter Ad Close.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Inter Failed to Load: " + adError.getErrorCode());
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
                        }

                    });
                }
            });
        }
    }

    // Adx Mode
    public void Load_interAds_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = dataresponsearray.get(0).getAdxInterId();
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
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdmobInterid();
                    AdRequest adRequest = new AdRequest.Builder().build();
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
                            // FB
                            if (isFBInterLoaded) {
                                return;
                            }
                            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
                            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {
                                    Log.d("MyAppDataResponse", "FB Inter ad Show.");
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {
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
                                    Log.d("MyAppDataResponse", "FB  Inter Ad Close.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("MyAppDataResponse", "FB Inter Failed to Load: " + adError.getErrorCode());
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
                        }
                    });
                }
            });
        }
    }

    // FB Mode
    public void Load_interAds_FB() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
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
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdmobInterid();
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
                            // ADX
                            if (isAdxInterLoaded) {
                                return;
                            }
                            String placementId = dataresponsearray.get(0).getAdxInterId();
                            AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                                @Override
                                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                                    super.onAdLoaded(interstitialAd);
                                    ADXInterstitialAd = interstitialAd;
                                    Log.d("MyAppDataResponse", "Adx Inter Loaded");
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
                        }
                    });
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
        }
    }

    public void Admob_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = dataresponsearray.get(0).getAdmobInterid();
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
                    // ADX
                    if (isAdxInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdxInterId();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
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
                            //Admob_Adx();
                        }
                    });
                }
            });
        }
    }

    public void Admob_Fb() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = dataresponsearray.get(0).getAdmobInterid();
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
                    // FB
                    if (isFBInterLoaded) {
                        return;
                    }
                    final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
                    InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                        @Override
                        public void onInterstitialDisplayed(Ad ad) {
                            Log.d("MyAppDataResponse", "FB Interstitial ad displayed.");
                        }

                        @Override
                        public void onInterstitialDismissed(Ad ad) {
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
                            Log.d("MyAppDataResponse", "FB Inter ad Close.");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Inter Failed" + adError);
                            // Admob_Fb();
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
                }
            });
        }
    }

    public void Adx_Admob() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = dataresponsearray.get(0).getAdxInterId();
            @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
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
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdmobInterid();
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
                            //Adx_Admob();
                        }
                    });
                }
            });
        }
    }

    public void Adx_Fb() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = dataresponsearray.get(0).getAdxInterId();
            @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
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
                    // FB
                    if (isFBInterLoaded) {
                        return;
                    }
                    final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
                    InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                        @Override
                        public void onInterstitialDisplayed(Ad ad) {
                            Log.d("MyAppDataResponse", "FB Interstitial ad displayed.");
                        }

                        @Override
                        public void onInterstitialDismissed(Ad ad) {
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
                            Log.d("MyAppDataResponse", "FB Inter ad Close.");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("MyAppDataResponse", "FB Inter Failed" + adError);
                            //Adx_Fb();
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
                }
            });
        }
    }

    public void Fb_Admob() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
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
                    Log.d("MyAppDataResponse", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Inter Failed" + adError);
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdmobInterid();
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
                            //Fb_Admob();
                        }
                    });
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
        }
    }

    public void Fb_Adx() {
        if (dataresponsearray != null && dataresponsearray.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, dataresponsearray.get(0).getFbInterId());
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("MyAppDataResponse", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
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
                    Log.d("MyAppDataResponse", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("MyAppDataResponse", "FB Inter Failed" + adError);
                    // ADX
                    if (isAdxInterLoaded) {
                        return;
                    }
                    String placementId = dataresponsearray.get(0).getAdxInterId();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
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
                            //Fb_Adx();
                        }
                    });
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
            if (platform.equalsIgnoreCase(Admob)) {
                show_Interstitial_Admob_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Adx)) {
                show_Interstitial_Adx_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(FB)) {
                show_Interstitial_FB_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                show_Interstitial_Admob_Adx_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                show_Interstitial_Admob_Fb_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                show_Interstitial_Adx_Admob_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                show_Interstitial_Adx_Fb_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                show_Interstitial_Fb_Admob_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                show_Interstitial_Fb_Adx_Back(appDataback2);
            } else if (platform.equalsIgnoreCase(Appopen)) {
                showAd_appopen_inter(appDataback2);
            } else if (platform.equalsIgnoreCase("off")) {
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
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
                Load_interAds_Admob();
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
                Load_interAds_Admob();
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
                Load_interAds_Admob();
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
                show_qureka_interad(appDataback2);
                Load_interAds_Admob();
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

    // Adx Mode
    public void show_Interstitial_Adx_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isAdxInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_Adx();
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
        } else if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_Adx();
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
                Load_interAds_Adx();
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
                show_qureka_interad(appDataback2);
                Load_interAds_Adx();
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

    // FB Mode
    public void show_Interstitial_FB_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isFBInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_FB();
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
        } else if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_FB();
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
                Load_interAds_FB();
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
                show_qureka_interad(appDataback2);
                Load_interAds_FB();
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

    // Admob_Adx Mode
    public void show_Interstitial_Admob_Adx_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Adx();
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
                Admob_Adx();
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
                show_qureka_interad(appDataback2);
                Admob_Adx();
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

    // Admob_Fb Mode
    public void show_Interstitial_Admob_Fb_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Fb();
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
                Admob_Fb();
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
                show_qureka_interad(appDataback2);
                Admob_Fb();
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


    // Adx_Admob Mode
    public void show_Interstitial_Adx_Admob_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isAdxInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Admob();
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
        } else if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Adx_Admob();
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
                show_qureka_interad(appDataback2);
                Adx_Admob();
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

    // Adx_Fb Mode
    public void show_Interstitial_Adx_Fb_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isAdxInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Fb();
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
                Adx_Fb();
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
                show_qureka_interad(appDataback2);
                Adx_Fb();

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

    // Fb_Admob mode
    public void show_Interstitial_Fb_Admob_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isFBInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Admob();
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
        } else if (isGoogleInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Fb_Admob();
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
                show_qureka_interad(appDataback2);
                Fb_Admob();
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

    // Fb_Adx mode
    public void show_Interstitial_Fb_Adx_Back(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isFBInterLoaded) {
            adbackcounter = ChemburPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adbackcounter == dataresponsearray.get(0).getInterBackCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Adx();
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
                Fb_Adx();
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
                show_qureka_interad(appDataback2);
                Fb_Adx();
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
                if (platform.equalsIgnoreCase(Admob)) {
                    show_Interstitial_Admob(appDataback2);
                } else if (platform.equalsIgnoreCase(Adx)) {
                    show_Interstitial_Adx(appDataback2);
                } else if (platform.equalsIgnoreCase(FB)) {
                    show_Interstitial_FB(appDataback2);
                } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                    show_Interstitial_Admob_Adx(appDataback2);
                } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                    show_Interstitial_Admob_Fb(appDataback2);
                } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                    show_Interstitial_Adx_Admob(appDataback2);
                } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                    show_Interstitial_Adx_Fb(appDataback2);
                } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                    show_Interstitial_Fb_Admob(appDataback2);
                } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                    show_Interstitial_Fb_Adx(appDataback2);
                } else if (platform.equalsIgnoreCase(Appopen)) {
                    showAd_appopen_inter(appDataback2);
                } else if (platform.equalsIgnoreCase("off")) {
                    if (appDataback != null) {
                        appDataback.OnCall();
                        appDataback = null;
                    }
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
                        if (platform.equalsIgnoreCase(Admob)) {
                            show_Interstitial_Admob(appDataback2);
                        } else if (platform.equalsIgnoreCase(Adx)) {
                            show_Interstitial_Adx(appDataback2);
                        } else if (platform.equalsIgnoreCase(FB)) {
                            show_Interstitial_FB(appDataback2);
                        } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                            show_Interstitial_Admob_Adx(appDataback2);
                        } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                            show_Interstitial_Admob_Fb(appDataback2);
                        } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                            show_Interstitial_Adx_Admob(appDataback2);
                        } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                            show_Interstitial_Adx_Fb(appDataback2);
                        } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                            show_Interstitial_Fb_Admob(appDataback2);
                        } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                            show_Interstitial_Fb_Adx(appDataback2);
                        } else if (platform.equalsIgnoreCase(Appopen)) {
                            showAd_appopen_inter(appDataback2);
                        } else if (platform.equalsIgnoreCase("off")) {
                            if (appDataback != null) {
                                appDataback.OnCall();
                                appDataback = null;
                            }
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
                Load_interAds_Admob();
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
                Load_interAds_Admob();
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
                Load_interAds_Admob();
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
                show_qureka_interad(appDataback2);
                Load_interAds_Admob();
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

    // Adx Mode
    public void show_Interstitial_Adx(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isAdxInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_Adx();
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
        } else if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_Adx();
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
                Load_interAds_Adx();
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
                show_qureka_interad(appDataback2);
                Load_interAds_Adx();
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

    // FB Mode
    public void show_Interstitial_FB(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isFBInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_FB();
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
        } else if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_FB();
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
                Load_interAds_FB();
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
                show_qureka_interad(appDataback2);
                Load_interAds_FB();
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

    // Admob_Adx Mode
    public void show_Interstitial_Admob_Adx(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Adx();
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
                Admob_Adx();
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
                show_qureka_interad(appDataback2);
                Admob_Adx();
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

    // Admob_Fb Mode
    public void show_Interstitial_Admob_Fb(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Fb();
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
                Admob_Fb();
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
                show_qureka_interad(appDataback2);
                Admob_Fb();
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

    // Adx_Admob Mode
    public void show_Interstitial_Adx_Admob(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isAdxInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Admob();
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
        } else if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Adx_Admob();
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
                show_qureka_interad(appDataback2);
                Adx_Admob();
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

    // Adx_Fb Mode
    public void show_Interstitial_Adx_Fb(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isAdxInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADXInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Fb();
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
                Adx_Fb();
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
                show_qureka_interad(appDataback2);
                Adx_Fb();
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

    // Fb_Admob mode
    public void show_Interstitial_Fb_Admob(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isFBInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Admob();
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
        } else if (isGoogleInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Fb_Admob();
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
                show_qureka_interad(appDataback2);
                Fb_Admob();
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

    // Fb_Adx mode
    public void show_Interstitial_Fb_Adx(AppDataback appDataback2) {
        appDataback = appDataback2;
        if (isFBInterLoaded) {
            adinterCounter = ChemburPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adinterCounter == dataresponsearray.get(0).getInterCount() && FB_interstitialAd != null) {
                ChemburPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Adx();
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
                Fb_Adx();
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
                show_qureka_interad(appDataback2);
                Fb_Adx();
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
                    show_qureka_appopen(null);
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
                    show_qureka_appopen(null);
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
                        show_qureka_appopen(null);
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
                        show_qureka_appopen(null);
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
                            show_qureka_appopen(appDataback);
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
                            show_qureka_appopen(appDataback);
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
                                    show_qureka_interad(null);
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


    public final void show_qureka_appopen(AppDataback appDataback1) {
        Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
        dialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.chembur_qureka_appopen, (ViewGroup) null));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.llPersonalAd);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ll_continue_app);
        ImageView iv_myapp_logo = dialog.findViewById(R.id.iv_myapp_logo);
        TextView txt_myapp_name = dialog.findViewById(R.id.txt_myapp_name);

        iv_myapp_logo.setImageDrawable(activity.getDrawable(applogo));
        txt_myapp_name.setText(appname);


        linearLayout.setOnClickListener(v -> {
            dialog.dismiss();
            if (appDataback1 != null) {
//                within();
                appDataback1.OnCall();

            } else {
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
            }
        });
        relativeLayout.setOnClickListener(v -> {
            if (appDataResponse.getQurekaUrl() != null) {
                LoadCustomQ.myCustom((Activity) activity, appDataResponse.getQurekaUrl());
            }
        });
        Log.d("MyAppDataResponse", "qureka AppOpen Ad Show");
        dialog.show();
    }

    private void show_qureka_interad(AppDataback appDataback2) {
        Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
        dialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.chembur_qureka_inter_ad, (ViewGroup) null));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.slide_in_bottom);
        TextView textView = (TextView) dialog.findViewById(R.id.install);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ad_close);
        ((CardView) dialog.findViewById(R.id.cvTopAd)).startAnimation(animation);

        ((CardView) dialog.findViewById(R.id.cvTopAd)).setOnClickListener(v -> {
            if (appDataResponse.getQurekaUrl() != null) {
                LoadCustomQ.myCustom((Activity) activity, appDataResponse.getQurekaUrl());

            }
        });
        textView.setOnClickListener(v -> {
            if (appDataResponse.getQurekaUrl() != null) {
                LoadCustomQ.myCustom((Activity) activity, appDataResponse.getQurekaUrl());
            }
        });
        linearLayout.setOnClickListener(v -> {
            qurekaadCounter = ChemburPreferencesManager.getInstance(activity).getqurekaadcounter();
            if (qurekaadCounter == dataresponsearray.get(0).getQurekainterCount()) {
                ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                dialog.dismiss();
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
                LoadCustomQ.myCustom(activity, dataresponsearray.get(0).getQurekaUrl());
            } else {
                qurekaadCounter = qurekaadCounter + 1;
                ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(qurekaadCounter);
                dialog.dismiss();
                if (appDataback != null) {
                    appDataback.OnCall();
                    appDataback = null;
                }
            }
        });
        Log.d("MyAppDataResponse", "qureka inter Ad Show");
        dialog.show();

    }


}