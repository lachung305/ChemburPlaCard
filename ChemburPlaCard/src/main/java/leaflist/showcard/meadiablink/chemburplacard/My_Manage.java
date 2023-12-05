package leaflist.showcard.meadiablink.chemburplacard;

import static com.google.adsshow.App.arrAdDataStart;
import static com.livecricket.hsapp.fieldcricket.cricketsports.Main_Ads.matchalldetail_Splace_Activity.convertedObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
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

import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.adsshow.RetrofitResponce.AdListResponse;
import com.google.adsshow.RetrofitResponce.DataItem;
import com.google.adsshow.qureka_mycustomtab.qureka_LoadCustom;
import com.google.adsshow.retrofit.APIClient;
import com.google.adsshow.retrofit.RetrofitInterface;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.livecricket.hsapp.fieldcricket.cricketsports.Main_Ads.matchalldetail_PrivacyPolicyActivity;
import com.livecricket.hsapp.fieldcricket.cricketsports.Main_Ads.matchalldetail_Splace_Activity;
import com.livecricket.hsapp.fieldcricket.cricketsports.Main_Ads.matchalldetail_Utils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class My_Manage {
    private static My_Manage mInstance;
    public static Context activity;
    static MyCallback myCallback;
    public static String Admob = "admob";
    public static String Adx = "adx";
    public static String FB = "fb";
    public static String Mrec = "mrec";

    public static String Local = "local";
    public static String Appopen = "appopen";
    public static String Admob_Adx = "admob_adx";
    public static String Admob_Fb = "admob_fb";
    public static String Admob_Wortise = "admob_wortise";
    public static String Adx_Admob = "adx_admob";
    public static String Adx_Fb = "adx_fb";
    public static String Adx_Wortise = "adx_wortise";
    public static String Fb_Admob = "fb_admob";
    public static String Fb_Adx = "fb_adx";
    public static String Fb_Wortise = "fb_wortise";


    // Banner
    public static boolean isGoogleBannerLoaded;
    public static boolean isAdxBannerLoaded;
    public static boolean isFBBannerLoaded;
    public static AdView googleBannerAd;
    public static AdManagerAdView adxBannerAd;
    public static com.facebook.ads.AdView fbadView;

    // Mediam Ragtangal
    public static boolean isAdmob_Mediam_Ragtangal_Loaded;
    public static boolean isAdx_Mediam_Ragtangal_Loaded;
    public static boolean isFB_Mediam_Ragtangal_Loaded;
    public static AdView admobMediam_Ragtangal;
    public static AdManagerAdView adxMediam_Ragtangal;
    public static com.facebook.ads.AdView fb_Ragtangal_adView;

    // Native
    public static boolean isadmob_small_native_banner_Loaded;
    public static boolean isAdmob_small_native_Loaded;
    public static boolean isadmob_native_Loaded;

    public static ArrayList<NativeAd> Admob_small_native_banner_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Admob_small_native_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Admob_native_Ad = new ArrayList<>();
    public static boolean isadx_small_native_banner_Loaded;
    public static boolean isadx_small_native_Loaded;
    public static boolean isadx_native_Loaded;
    public static ArrayList<NativeAd> Adx_small_native_banner_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Adx_small_native_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> Adx_native_Ad = new ArrayList<>();
    public static boolean isFBNative_Banner_Loaded;
    public static boolean isFBNativeLoaded;
    public static ArrayList<NativeBannerAd> fb_nativeBannerAd = new ArrayList<>();
    public static ArrayList<com.facebook.ads.NativeAd> fbnativeAd = new ArrayList<>();
    public static boolean isWortise_small_NativeLoaded;
    public static boolean isWortise_Native_BannerLoaded;
    public static boolean isWortiseNativeLoaded;

    public static ArrayList<NativeAd> wortise_native_banner_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> wortise_small_native_Ad = new ArrayList<>();
    public static ArrayList<NativeAd> wortise_native_Ad = new ArrayList<>();

    // Inter
    public static boolean isGoogleInterLoaded;
    public static boolean isAdxInterLoaded;
    public static boolean isFBInterLoaded;

    public static InterstitialAd ADMOBInterstitialAd;
    public static AdManagerInterstitialAd ADXInterstitialAd;
    public static com.facebook.ads.InterstitialAd FB_interstitialAd;

    // Appopen
    public static boolean isadmob_appopen_Loaded;
    public static boolean isadx_appopen_Loaded;
    FullScreenContentCallback fullScreenContentCallback;
    public static AppOpenAd admob_appOpenAd;
    public static AppOpenAd adx_appOpenAd;

    private int adCounter;
    private int adBackCounter;
    private int QurekaadCounter;
    SharedPreferences prefs;

    public interface MyCallback {
        void OnCall();
    }

    public My_Manage(Context context) {
        activity = context;
        prefs = activity.getSharedPreferences(activity.getPackageName(), 0);
    }

    public static My_Manage getInstance(Context context) {
        activity = context;
        if (mInstance == null) {
            mInstance = new My_Manage(context);
        }
        return mInstance;
    }

    public static boolean isOnline(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    // --------------------------------------------------- Service -----------------------------------------------------------

    int success = 0;

    public static native String updateAppData();

    public void installcounter() {
        RetrofitInterface apiInterface = APIClient.getClient().create(RetrofitInterface.class);
        Call<Object> call1 = apiInterface.updatecounter(activity.getPackageName(), updateAppData());
        call1.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String data = new Gson().toJson(response.body());
                    try {
                        JSONObject jsonObject = new JSONObject(data);
                        success = jsonObject.getInt("success");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                call.cancel();
            }
        });
    }

    public static ArrayList<DataItem> app_data = new ArrayList<>();

    static {
        System.loadLibrary("native-lib");
    }

    public static native String fetchdatastring();

    public void App_Data() {
        try {
            RetrofitInterface apiInterface = APIClient.getClient().create(RetrofitInterface.class);
            Call<AdListResponse> call1 = apiInterface.getadsdetail(activity.getPackageName(), fetchdatastring());
            call1.enqueue(new Callback<AdListResponse>() {
                @Override
                public void onResponse(@NotNull Call<AdListResponse> call, @NotNull Response<AdListResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        if (response.body().getData() != null) {
                            app_data.clear();

                            List<DataItem> dataItemList = new ArrayList<>();
                            if (response.body().getData() != null && !response.body().getData().isEmpty()) {
                                try {
                                    String decryptedtext1 = decrypt(response.body().data);
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<List<DataItem>>() {
                                    }.getType();
                                    dataItemList = gson.fromJson(decryptedtext1, type);
                                    System.out.println("plaintext  Data:  " + dataItemList.size());

                                    if (dataItemList != null && dataItemList.size() > 0) {

                                        DataItem item = dataItemList.get(0);
                                        String favData = gson.toJson(item);
                                        matchalldetail_Utils.saveStringtoPrefrence(activity, "adresponse", favData);

                                        convertedObject = matchalldetail_Utils.getResponse(activity);
                                        app_data.addAll(dataItemList);
                                        String ridirect_app = app_data.get(0).getRedirectApp();
                                        if (!ridirect_app.equalsIgnoreCase("")) {
                                            activity.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://play.google.com/store/apps/details?id=" + ridirect_app)));
                                        } else {
                                            preload_Ad();
                                        }
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        } else {
                            With_out();
                            Toast.makeText(activity, "Server not Response", Toast.LENGTH_SHORT).show();
                        }
                    }

                    Log.d("TAG", "Faile ");
                }

                @Override
                public void onFailure(Call<AdListResponse> call, Throwable t) {
                    call.cancel();
                    With_out();
                }
            });
            Log.d("TAG", "Faile-2 ");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String decrypt(@NotNull String input) {
        byte[] bytes = Base64.decode(input, Base64.DEFAULT);
        if (bytes.length < 17) {
            return null;
        }
        byte[] keybytes = Arrays.copyOfRange(bytes, 0, 16);
        byte[] ivBytes = Arrays.copyOfRange(bytes, 16, 32);
        byte[] contentBytes = Arrays.copyOfRange(bytes, 32, bytes.length);
        try {
            Cipher ciper = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(keybytes, "AES");
            IvParameterSpec iv = new IvParameterSpec(ivBytes, 0, ciper.getBlockSize());
            ciper.init(Cipher.DECRYPT_MODE, keySpec, iv);
            return new String(ciper.doFinal(contentBytes));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException |
                 InvalidAlgorithmParameterException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException ignored) {
        }
        return null;
    }


    public void With_out() {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).getAdSplash().equalsIgnoreCase("inter")) {
                My_Manage.getInstance(activity).show_splash_inter(() -> within());
            } else {
                My_Manage.getInstance(activity).show_splash(() -> within());
            }
        }
    }

    // ---------------------------------------------------- Pre loadd Ads --------------------------------------------------------------

    public void preload_Ad() {
        if (app_data != null && app_data.size() > 0) {

            // Native
            if (app_data.get(0).getAdNative().equalsIgnoreCase(Admob)) {
                preload_Admob_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Adx)) {
                preload_Adx_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(FB)) {
                preloadFbNativeAd();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Admob_Adx)) {
                preload_Admob_Adx_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Admob_Fb)) {
                preload_Admob_Fb_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Admob_Wortise)) {
                preload_Admob_Wortise_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Adx_Admob)) {
                preload_Adx_Admob_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Adx_Fb)) {
                preload_Adx_Fb_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Adx_Wortise)) {
                preload_Adx_Wortise_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Fb_Admob)) {
                preload_Fb_Admob_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Fb_Adx)) {
                preload_Fb_Adx_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Fb_Wortise)) {
                preload_Fb_Wortise_Native_Ad();
            } else if (app_data.get(0).getAdNative().equalsIgnoreCase(Mrec)) {
                Merc_Banner_Ad();
            }

            // Inter Ads
            if (app_data.get(0).getAdInter().equalsIgnoreCase(Admob)) {
                Load_interAds_Admob();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Adx)) {
                Load_interAds_Adx();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(FB)) {
                Load_interAds_FB();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Admob_Adx)) {
                Admob_Adx();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Admob_Fb)) {
                Admob_Fb();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Admob_Wortise)) {
                Admob_Wortise();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Adx_Admob)) {
                Adx_Admob();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Adx_Fb)) {
                Adx_Fb();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Adx_Wortise)) {
                Adx_Wortise();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Fb_Admob)) {
                Fb_Admob();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Fb_Adx)) {
                Fb_Adx();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Fb_Wortise)) {
                Fb_Wortise();
            } else if (app_data.get(0).getAdInter().equalsIgnoreCase(Appopen)) {
                if (app_data.get(0).getAd_appopen_inter().equalsIgnoreCase(Admob)) {
                    get_admob_appopen_AdsLoad();
                } else if (app_data.get(0).getAd_appopen_inter().equalsIgnoreCase(Adx)) {
                    get_adx_appopen_AdsLoad();
                }
            }

            // Banner Ads
            if (app_data.get(0).getAdBanner().equalsIgnoreCase(Admob)) {
                preloadBannerAd_AAFB();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Adx)) {
                preloadBannerAd_Adx();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(FB)) {
                preloadBannerAd_FBAA();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Admob_Adx)) {
                preload_Banner_Admob_Adx();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Admob_Fb)) {
                preload_Banner_Admob_Fb();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Admob_Wortise)) {
                preload_Banner_Admob_Wortise();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Adx_Admob)) {
                preload_Banner_Adx_Admob();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Adx_Fb)) {
                preload_Banner_Adx_Fb();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Adx_Wortise)) {
                preload_Banner_Adx_Wortise();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Fb_Admob)) {
                preload_Banner_Fb_Admob();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Fb_Adx)) {
                preload_Banner_Fb_Adx();
            } else if (app_data.get(0).getAdBanner().equalsIgnoreCase(Fb_Wortise)) {
                preload_Banner_Fb_Wortise();
            }

            // Small native banner
            if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob)) {
                preload_Admob_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx)) {
                preload_Adx_Native_Banner();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(FB)) {
                preload_Fb_Native_BannerAd();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob_Adx)) {
                preload_Admob_Adx_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob_Fb)) {
                preload_Admob_Fb_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Admob_Wortise)) {
                preload_Admob_Wortise_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx_Admob)) {
                preload_Adx_Admob_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx_Fb)) {
                preload_Adx_Fb_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Adx_Wortise)) {
                preload_Adx_Wortise_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Fb_Admob)) {
                preload_Fb_Admob_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Fb_Adx)) {
                preload_Fb_Adx_Native_Banner_Ad();
            } else if (app_data.get(0).getAdSmallNativeBanner().equalsIgnoreCase(Fb_Wortise)) {
                preload_Fb_Wortise_Native_Banner_Ad();
            }

            // Small Native
            if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Admob)) {
                preload_Admob_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Adx)) {
                preload_Adx_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(FB)) {
                preload_Fb_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Admob_Adx)) {
                preload_Admob_Adx_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Admob_Fb)) {
                preload_Admob_Fb_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Admob_Wortise)) {
                preload_Admob_Wortise_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Adx_Admob)) {
                preload_Adx_Admob_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Adx_Fb)) {
                preload_Adx_Fb_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Adx_Wortise)) {
                preload_Adx_Wortise_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Fb_Admob)) {
                preload_Fb_Admob_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Fb_Adx)) {
                preload_Fb_Adx_Small_Native_Ad();
            } else if (app_data.get(0).getAdSmallNative().equalsIgnoreCase(Fb_Wortise)) {
                preload_Fb_Wortise_Small_Native_Ad();
            }


//            // Back Inter Ads
            if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Admob)) {
                Load_interAds_Admob();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Adx)) {
                Load_interAds_Adx();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(FB)) {
                Load_interAds_FB();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Admob_Adx)) {
                Admob_Adx();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Admob_Fb)) {
                Admob_Fb();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Admob_Wortise)) {
                Admob_Wortise();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Adx_Admob)) {
                Adx_Admob();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Adx_Fb)) {
                Adx_Fb();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Adx_Wortise)) {
                Adx_Wortise();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Fb_Admob)) {
                Fb_Admob();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Fb_Adx)) {
                Fb_Adx();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Fb_Wortise)) {
                Fb_Wortise();
            } else if (app_data.get(0).getAdInterBack().equalsIgnoreCase(Appopen)) {
                if (app_data.get(0).getAd_appopen_inter().equalsIgnoreCase(Admob)) {
                    get_admob_appopen_AdsLoad();
                } else if (app_data.get(0).getAd_appopen_inter().equalsIgnoreCase(Adx)) {
                    get_adx_appopen_AdsLoad();
                }
            }

            // Appopen
            if (app_data.get(0).getAdAppopen().equalsIgnoreCase(Admob)) {
                get_admob_appopen_AdsLoad();
            } else if (app_data.get(0).getAdAppopen().equalsIgnoreCase(Adx)) {
                get_adx_appopen_AdsLoad();
            }
            With_out();
        }
    }

    //-------------------------------------------------------- Banner Ads -------------------------------------------------------

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void preloadBannerAd_AAFB() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Banner.loadAd(adRequest);
            admob_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.d("FootBall", "Admob Banner Loadedd ");
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
                    adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
                    @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Banner.loadAd(adRequest);
                    adx_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("FootBall", "Adx Banner Loadedd ");
                            adxBannerAd = adx_Banner;
                            isAdxBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            // Fb Banner
                            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "Fb banner onError: " + adError.getErrorCode());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Banner Loadedd ");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
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
                    admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
                    AdRequest adRequest = new AdRequest.Builder().build();
                    admob_Banner.loadAd(adRequest);
                    admob_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            Log.d("FootBall", "Admob Banner Loadedd ");
                            if (isGoogleBannerLoaded) return;
                            googleBannerAd = admob_Banner;
                            isGoogleBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                            // Fb Banner
                            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Banner Loadedd ");
                                    fbadView = fb_banner;
                                    isFBBannerLoaded = true;
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "Fb banner onError: " + adError.getErrorCode());
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
                    Log.d("FootBall", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }
            });
        }
    }

    // FB Mode
    public void preloadBannerAd_FBAA() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Banner Failed");
                    // Admob
                    if (isGoogleBannerLoaded) return;
                    final AdView admob_BannerAd = new AdView(activity);
                    admob_BannerAd.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    admob_BannerAd.setAdUnitId(app_data.get(0).getAdmobBannerid());
                    AdRequest adRequest = new AdRequest.Builder().build();
                    admob_BannerAd.loadAd(adRequest);
                    admob_BannerAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            Log.d("FootBall", "Admob Banner Loadedd ");
                            if (isGoogleBannerLoaded) return;
                            googleBannerAd = admob_BannerAd;
                            isGoogleBannerLoaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                            Log.d("FootBall", "Admob Banner Failed");
                            // Adx
                            if (isAdxBannerLoaded) return;
                            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                            adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
                            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                            adx_Banner.loadAd(adRequest);
                            adx_Banner.setAdListener(new AdListener() {

                                @Override
                                public void onAdLoaded() {
                                    super.onAdLoaded();
                                    Log.d("FootBall", "Adx Banner Loadedd ");
                                    adxBannerAd = adx_Banner;
                                    isAdxBannerLoaded = true;
                                }

                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("FootBall", "Adx Banner Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Banner.loadAd(adRequest);
            admob_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.d("FootBall", "Admob Banner Loadedd ");
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
                    adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
                    @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Banner.loadAd(adRequest);
                    adx_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("FootBall", "Adx Banner Loadedd ");
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
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Banner.loadAd(adRequest);
            admob_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.d("FootBall", "Admob Banner Loadedd ");
                    if (isGoogleBannerLoaded) return;
                    googleBannerAd = admob_Banner;
                    isGoogleBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    // FB
                    final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                    com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "Fb Banner Loadedd ");
                            fbadView = fb_banner;
                            isFBBannerLoaded = true;
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Banner Failed");
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

    public void preload_Banner_Admob_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleBannerLoaded) return;
            final AdView admob_Banner = new AdView(activity);
            admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Banner.loadAd(adRequest);
            admob_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    Log.d("FootBall", "Admob Banner Loadedd ");
                    if (isGoogleBannerLoaded) return;
                    googleBannerAd = admob_Banner;
                    isGoogleBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                }
            });
        }
    }

    public void preload_Banner_Adx_Admob() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("FootBall", "Adx Banner Loadedd ");
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
                    admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
                    AdRequest adRequest = new AdRequest.Builder().build();
                    admob_Banner.loadAd(adRequest);
                    admob_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            Log.d("FootBall", "Admob Banner Loadedd ");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("FootBall", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // FB
                    final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                    com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "Fb Banner Loadedd ");
                            fbadView = fb_banner;
                            isFBBannerLoaded = true;
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Banner Failed");
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

    public void preload_Banner_Adx_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isAdxBannerLoaded) return;
            final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
            adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
            adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
            @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            adx_Banner.loadAd(adRequest);
            adx_Banner.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("FootBall", "Adx Banner Loadedd ");
                    adxBannerAd = adx_Banner;
                    isAdxBannerLoaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                }
            });
        }
    }

    public void preload_Banner_Fb_Admob() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Banner Failed");
                    // Admob
                    if (isGoogleBannerLoaded) return;
                    final AdView admob_Banner = new AdView(activity);
                    admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid());
                    AdRequest adRequest = new AdRequest.Builder().build();
                    admob_Banner.loadAd(adRequest);
                    admob_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            Log.d("FootBall", "Admob Banner Loadedd ");
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
        if (app_data != null && app_data.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Banner Failed");
                    // Adx
                    if (isAdxBannerLoaded) return;
                    final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                    adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                    adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId());
                    @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Banner.loadAd(adRequest);
                    adx_Banner.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("FootBall", "Adx Banner Loadedd ");
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

    public void preload_Banner_Fb_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId(), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Fb Banner Loadedd ");
                    fbadView = fb_banner;
                    isFBBannerLoaded = true;
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Banner Failed");
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
        if (app_data != null && app_data.size() > 0) {
            String platform = app_data.get(0).getAdBanner();
            if (platform.equalsIgnoreCase(Admob)) {
                new All_Type_Ads(activity).show_banner_ad_AAF(banner_container);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new All_Type_Ads(activity).show_banner_ad_Adx(banner_container);
            } else if (platform.equalsIgnoreCase(FB)) {
                new All_Type_Ads(activity).show_banner_ad_FBAA(banner_container);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new All_Type_Ads(activity).show_banner_ad_Admob_Adx(banner_container);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new All_Type_Ads(activity).show_banner_ad_Admob_Fb(banner_container);
            } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                new All_Type_Ads(activity).show_banner_ad_Admob_Wortise(banner_container);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new All_Type_Ads(activity).show_banner_ad_Adx_Admob(banner_container);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new All_Type_Ads(activity).show_banner_ad_Adx_Fb(banner_container);
            } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                new All_Type_Ads(activity).show_banner_ad_Adx_Wortise(banner_container);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new All_Type_Ads(activity).show_banner_ad_Fb_Admob(banner_container);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new All_Type_Ads(activity).show_banner_ad_Fb_Adx(banner_container);
            } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                new All_Type_Ads(activity).show_banner_ad_Fb_Wortise(banner_container);
            }
        }
    }

    //---------------------------------------------Small Native banner type Ads ----------------------------------------------

    // Admob Mode
    void preload_Admob_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
                isadmob_small_native_banner_Loaded = true;
                Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Banner Ad Failed");
                    // Adx
                    if (isadx_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_small_native_banner_Ad.size() > 0) {
                            Adx_small_native_banner_Ad.clear();
                            Adx_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Adx_small_native_banner_Ad.add(nativeAd);
                        }
                        isadx_small_native_banner_Loaded = true;
                        Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Small Native Banner Ad Failed");
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Small Native Banner ad is loaded");
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
                                    Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                    Log.d("FootBall", "FB Small Native Banner ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                    Log.d("FootBall", "FB Small Native Banner ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                if (Adx_small_native_banner_Ad.size() > 0) {
                    Adx_small_native_banner_Ad.clear();
                    Adx_small_native_banner_Ad.add(nativeAd);
                } else {
                    Adx_small_native_banner_Ad.add(nativeAd);
                }
//                    Adx_small_native_banner_Ad.add(nativeAd);
                isadx_small_native_banner_Loaded = true;
                Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Banner Ad Failed");
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
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
                            Log.d("FootBall", "Admob Small Native Banner Ad Failed");
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {

                                    Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Small Native Banner ad is loaded");
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

                                    Log.d("FootBall", "FB Small Native Banner ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                    Log.d("FootBall", "FB Small Native Banner ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner_Ad = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Native ad finished downloading all assets.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Native ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                        Log.d("FootBall", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Native Ad Failed");
                            // Adx
                            if (isadx_small_native_banner_Loaded) {
                                return;
                            }
                            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                            builder.forNativeAd(nativeAd -> {
                                if (Adx_small_native_banner_Ad.size() > 0) {
                                    Adx_small_native_banner_Ad.clear();
                                    Adx_small_native_banner_Ad.add(nativeAd);
                                } else {
                                    Adx_small_native_banner_Ad.add(nativeAd);
                                }
//                                    Adx_small_native_banner_Ad.add(nativeAd);
                                isadx_small_native_banner_Loaded = true;
                                Log.d("FootBall", "Adx Native Ad Loaded");
                            });
                            builder.withAdListener(new AdListener() {
                                @SuppressLint("MissingPermission")
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("FootBall", "Adx Native Ad Failed");
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
                    Log.d("FootBall", "FB Native Banner ad is loaded");
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
                    Log.d("FootBall", "FB Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner_Ad.loadAd(fb_nativeBanner_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Admob_Adx_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
//                    Admob_small_native_banner_Ad.add(nativeAd);
                isadmob_small_native_banner_Loaded = true;
                Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Banner Ad Failed");
                    // Adx
                    if (isadx_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_small_native_banner_Ad.size() > 0) {
                            Adx_small_native_banner_Ad.clear();
                            Adx_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Adx_small_native_banner_Ad.add(nativeAd);
                        }
//                            Adx_small_native_banner_Ad.add(nativeAd);
                        isadx_small_native_banner_Loaded = true;
                        Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Small Native Banner Ad Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
//                    Admob_small_native_banner_Ad.add(nativeAd);
                isadmob_small_native_banner_Loaded = true;
                Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Banner Ad Failed");
                    // Fb
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                            //preload_Admob_Fb_Native_Banner_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "FB Small Native Banner ad is loaded");
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

                            Log.d("FootBall", "FB Small Native Banner ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                            Log.d("FootBall", "FB Small Native Banner ad impression logged!");
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

    public void preload_Admob_Wortise_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_small_native_banner_Ad.size() > 0) {
                    Admob_small_native_banner_Ad.clear();
                    Admob_small_native_banner_Ad.add(nativeAd);
                } else {
                    Admob_small_native_banner_Ad.add(nativeAd);
                }
//                    Admob_small_native_banner_Ad.add(nativeAd);
                isadmob_small_native_banner_Loaded = true;
                Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Banner Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Adx_Admob_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                if (Adx_small_native_banner_Ad.size() > 0) {
                    Adx_small_native_banner_Ad.clear();
                    Adx_small_native_banner_Ad.add(nativeAd);
                } else {
                    Adx_small_native_banner_Ad.add(nativeAd);
                }
//                    Adx_small_native_banner_Ad.add(nativeAd);
                isadx_small_native_banner_Loaded = true;
                Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Banner Ad Failed");
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                        Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Small Native Banner Ad Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                if (Adx_small_native_banner_Ad.size() > 0) {
                    Adx_small_native_banner_Ad.clear();
                    Adx_small_native_banner_Ad.add(nativeAd);
                } else {
                    Adx_small_native_banner_Ad.add(nativeAd);
                }
//                    Adx_small_native_banner_Ad.add(nativeAd);
                isadx_small_native_banner_Loaded = true;
                Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Banner Ad Failed");
                    // Fb
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                            //preload_Adx_Fb_Native_Banner_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "FB Small Native Banner ad is loaded");
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

                            Log.d("FootBall", "FB Small Native Banner ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                            Log.d("FootBall", "FB Small Native Banner ad impression logged!");
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

    public void preload_Adx_Wortise_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                if (Adx_small_native_banner_Ad.size() > 0) {
                    Adx_small_native_banner_Ad.clear();
                    Adx_small_native_banner_Ad.add(nativeAd);
                } else {
                    Adx_small_native_banner_Ad.add(nativeAd);
                }
//                    Adx_small_native_banner_Ad.add(nativeAd);
                isadx_small_native_banner_Loaded = true;
                Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Banner Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }

    public void preload_Fb_Admob_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isadmob_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_small_native_banner_Ad.size() > 0) {
                            Admob_small_native_banner_Ad.clear();
                            Admob_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Admob_small_native_banner_Ad.add(nativeAd);
                        }
//                            Admob_small_native_banner_Ad.add(nativeAd);
                        isadmob_small_native_banner_Loaded = true;
                        Log.d("FootBall", "Admob Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Small Native Banner Ad Failed");
                            //preload_Fb_Admob_Native_Banner_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native Banner ad is loaded");
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

                    Log.d("FootBall", "FB Small Native Banner ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Small Native Banner ad impression logged!");
                }
            };
            // Request an ad
            fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Fb_Adx_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                    // Adx
                    if (isadx_small_native_banner_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_small_native_banner_Ad.size() > 0) {
                            Adx_small_native_banner_Ad.clear();
                            Adx_small_native_banner_Ad.add(nativeAd);
                        } else {
                            Adx_small_native_banner_Ad.add(nativeAd);
                        }
//                            Adx_small_native_banner_Ad.add(nativeAd);
                        isadx_small_native_banner_Loaded = true;
                        Log.d("FootBall", "Adx Small Native Banner Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Small Native Banner Ad Failed");
                            // preload_Fb_Adx_Native_Banner_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native Banner ad is loaded");
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

                    Log.d("FootBall", "FB Small Native Banner ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Small Native Banner ad impression logged!");
                }
            };
            // Request an ad
            fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Fb_Wortise_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_native_BannerAd = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Native Banner Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Native Banner ad failed to load: " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native Banner ad is loaded");
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

                    Log.d("FootBall", "FB Small Native Banner ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Small Native Banner ad impression logged!");
                }
            };
            // Request an ad
            fb_native_BannerAd.loadAd(fb_native_BannerAd.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void show_small_native_banner_ad(final ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            String platform = app_data.get(0).getAdSmallNativeBanner();
            if (platform.equalsIgnoreCase(Admob)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(FB)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_FB(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Admob_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Admob_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Admob_Wortise(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Adx_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Adx_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Adx_Wortise(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Fb_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Fb_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                new All_Type_Ads(activity).show_samll_native_bannerad_Fb_Wortise(native_banner_ad);
            }
        }
    }

    //--------------------------------------------- Small Native Ads --------------------------------------------------------------------------

    // Admob Mode
    public void preload_Admob_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("FootBall", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Ad Failed");
                    // Adx
                    if (isadx_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Adx_small_native_Ad.add(nativeAd);
                        isadx_small_native_Loaded = true;
                        Log.d("FootBall", "Adx Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Small Native Ad Failed");
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Small Native ad failed " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Small Native ad is loaded");
                                    fb_nativeBannerAd.add(fb_nativeBanner);
                                    isFBNative_Banner_Loaded = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {

                                    Log.d("FootBall", "FB Small Native ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                    Log.d("FootBall", "FB Small Native ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Adx_small_native_Ad.add(nativeAd);
                isadx_small_native_Loaded = true;
                Log.d("FootBall", "Adx Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Ad Failed");
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Admob_small_native_Ad.add(nativeAd);
                        isAdmob_small_native_Loaded = true;
                        Log.d("FootBall", "Admob Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Small Native Ad Failed");
                            // FB
                            if (isFBNative_Banner_Loaded) {
                                return;
                            }
                            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Small Native ad failed " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Small Native ad is loaded");
                                    fb_nativeBannerAd.add(fb_nativeBanner);
                                    isFBNative_Banner_Loaded = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {

                                    Log.d("FootBall", "FB Small Native ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                    Log.d("FootBall", "FB Small Native ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // fb
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native Banner ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Small Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Admob_small_native_Ad.add(nativeAd);
                        isAdmob_small_native_Loaded = true;
                        Log.d("FootBall", "Admob Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Small Native Ad Failed");
                            // Adx
                            if (isadx_small_native_Loaded) {
                                return;
                            }
                            AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                            builder.forNativeAd(nativeAd -> {
                                Adx_small_native_Ad.add(nativeAd);
                                isadx_small_native_Loaded = true;
                                Log.d("FootBall", "Adx Small Native Ad Loaded");
                            });
                            builder.withAdListener(new AdListener() {
                                @SuppressLint("MissingPermission")
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("FootBall", "Adx Small Native Ad Failed");
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
                    Log.d("FootBall", "FB Small Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "FB Small Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner.loadAd(fb_nativeBanner.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Admob_Adx_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("FootBall", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Ad Failed");
                    // Adx
                    if (isadx_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Adx_small_native_Ad.add(nativeAd);
                        isadx_small_native_Loaded = true;
                        Log.d("FootBall", "Adx Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Small Native Ad Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("FootBall", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Ad Failed");
                    // FB
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                            //preload_Admob_Fb_Small_Native_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "FB Small Native ad is loaded");
                            fb_nativeBannerAd.add(fb_nativeBanner);
                            isFBNative_Banner_Loaded = true;
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                            Log.d("FootBall", "FB Small Native ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                            Log.d("FootBall", "FB Small Native ad impression logged!");
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

    public void preload_Admob_Wortise_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isAdmob_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Admob_small_native_Ad.add(nativeAd);
                isAdmob_small_native_Loaded = true;
                Log.d("FootBall", "Admob Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint({"MissingPermission", "VisibleForTests"})
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Small Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Adx_Admob_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Adx_small_native_Ad.add(nativeAd);
                isadx_small_native_Loaded = true;
                Log.d("FootBall", "Adx Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Ad Failed");
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Admob_small_native_Ad.add(nativeAd);
                        isAdmob_small_native_Loaded = true;
                        Log.d("FootBall", "Admob Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Small Native Ad Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Adx_small_native_Ad.add(nativeAd);
                isadx_small_native_Loaded = true;
                Log.d("FootBall", "Adx Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Ad Failed");
                    // FB
                    if (isFBNative_Banner_Loaded) {
                        return;
                    }
                    final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            // Native ad finished downloading all assets
                            Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                            //preload_Adx_Fb_Small_Native_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "FB Small Native ad is loaded");
                            fb_nativeBannerAd.add(fb_nativeBanner);
                            isFBNative_Banner_Loaded = true;
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                            Log.d("FootBall", "FB Small Native ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                            Log.d("FootBall", "FB Small Native ad impression logged!");
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

    public void preload_Adx_Wortise_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_small_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Adx_small_native_Ad.add(nativeAd);
                isadx_small_native_Loaded = true;
                Log.d("FootBall", "Adx Small Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Small Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdManagerAdRequest.Builder().build());
        }
    }

    public void preload_Fb_Admob_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                    // Admob
                    if (isAdmob_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        Admob_small_native_Ad.add(nativeAd);
                        isAdmob_small_native_Loaded = true;
                        Log.d("FootBall", "Admob Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint({"MissingPermission", "VisibleForTests"})
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Small Native Ad Failed");
                            //preload_Fb_Admob_Small_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {

                    Log.d("FootBall", "FB Small Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Small Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner.loadAd(fb_nativeBanner.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Fb_Adx_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                    // Adx
                    if (isadx_small_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Adx_small_native_Ad.add(nativeAd);
                        isadx_small_native_Loaded = true;
                        Log.d("FootBall", "Adx Small Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Small Native Ad Failed");
                            //preload_Fb_Adx_Small_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdManagerAdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {

                    Log.d("FootBall", "FB Small Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Small Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner.loadAd(fb_nativeBanner.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    public void preload_Fb_Wortise_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBNative_Banner_Loaded) {
                return;
            }
            final NativeBannerAd fb_nativeBanner = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "FB Small Native Ad finished downloading all assets");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Small Native ad is loaded");
                    fb_nativeBannerAd.add(fb_nativeBanner);
                    isFBNative_Banner_Loaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {

                    Log.d("FootBall", "FB Small Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "FB Small Native ad impression logged!");
                }
            };
            // Request an ad
            fb_nativeBanner.loadAd(fb_nativeBanner.buildLoadAdConfig().withAdListener(nativeAdListener).build());
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_ad(final ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            String platform = app_data.get(0).getAdSmallNative();
            if (platform.equalsIgnoreCase(Admob)) {
                new All_Type_Ads(activity).show_small_native_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new All_Type_Ads(activity).show_small_native_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(FB)) {
                new All_Type_Ads(activity).show_small_native_FB(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new All_Type_Ads(activity).show_small_native_Admob_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new All_Type_Ads(activity).show_small_native_Admob_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                new All_Type_Ads(activity).show_small_native_Admob_Wortise(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new All_Type_Ads(activity).show_small_native_Adx_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new All_Type_Ads(activity).show_small_native_Adx_Fb(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                new All_Type_Ads(activity).show_small_native_Adx_Wortise(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new All_Type_Ads(activity).show_small_native_Fb_Admob(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new All_Type_Ads(activity).show_small_native_Fb_Adx(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                new All_Type_Ads(activity).show_small_native_Fb_Wortise(native_banner_ad);
            } else if (platform.equalsIgnoreCase(Local)) {
                new All_Type_Ads(activity).show_nativeBanner_Local(native_banner_ad);
            }
        }
    }

    //--------------------------------------------- Native Ads --------------------------------------------------------------------------

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void preload_Admob_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_native_Ad.size() > 0) {
                    Admob_native_Ad.clear();
                    Admob_native_Ad.add(nativeAd);
                } else {
                    Admob_native_Ad.add(nativeAd);
                }
//                    Admob_native_Ad.add(nativeAd);
                isadmob_native_Loaded = true;
                Log.d("FootBall", "Admob Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Native Ad Failed");
                    // Adx
                    if (isadx_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        if (Adx_native_Ad.size() > 0) {
                            Adx_native_Ad.clear();
                            Adx_native_Ad.add(nativeAd);
                        } else {
                            Adx_native_Ad.add(nativeAd);
                        }
//                            Adx_native_Ad.add(nativeAd);
                        isadx_native_Loaded = true;
                        Log.d("FootBall", "Adx Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @SuppressLint("MissingPermission")
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Adx Native Ad Failed");
                            // FB
                            if (isFBNativeLoaded) {
                                return;
                            }
                            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("FootBall", "FB Native ad finished downloading all assets.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Native ad Failed " + adError.getErrorMessage());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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
                                    Log.d("FootBall", "Native ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                    Log.d("FootBall", "Native ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                if (Adx_native_Ad.size() > 0) {
                    Adx_native_Ad.clear();
                    Adx_native_Ad.add(nativeAd);
                } else {
                    Adx_native_Ad.add(nativeAd);
                }
//                    Adx_native_Ad.add(nativeAd);
                isadx_native_Loaded = true;
                Log.d("FootBall", "Adx Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Adx Native Ad Failed");
                    // Admob Native
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("FootBall", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Native Ad Failed");
                            // FB
                            if (isFBNativeLoaded) {
                                return;
                            }
                            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
                            NativeAdListener nativeAdListener = new NativeAdListener() {
                                @Override
                                public void onMediaDownloaded(Ad ad) {
                                    // Native ad finished downloading all assets
                                    Log.d("FootBall", "FB Native ad finished downloading all assets.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Native ad Failed " + adError.getErrorMessage());
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
                                    Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
                                }

                                @Override
                                public void onAdClicked(Ad ad) {

                                    Log.d("FootBall", "Native ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {

                                    Log.d("FootBall", "Native ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    // Native ad finished downloading all assets
                    Log.d("FootBall", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "Native ad Failed " + adError.getErrorMessage());
                    // Admob
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("FootBall", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Native Ad Failed");
                            // Adx
                            if (isadx_native_Loaded) {
                                return;
                            }
                            AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                            builder.forNativeAd(nativeAd -> {
                                if (Adx_native_Ad.size() > 0) {
                                    Adx_native_Ad.clear();
                                    Adx_native_Ad.add(nativeAd);
                                } else {
                                    Adx_native_Ad.add(nativeAd);
                                }
//                                    Adx_native_Ad.add(nativeAd);
                                isadx_native_Loaded = true;
                                Log.d("FootBall", "Adx Native Ad Loaded");
                            });
                            builder.withAdListener(new AdListener() {
                                @Override
                                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                    super.onAdFailedToLoad(loadAdError);
                                    Log.d("FootBall", "Adx Native Ad Failed");
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
                    Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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

                    Log.d("FootBall", "Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {

                    Log.d("FootBall", "Native ad impression logged!");
                }
            };
            // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        }
    }

    public void preload_Admob_Adx_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                if (Admob_native_Ad.size() > 0) {
                    Admob_native_Ad.clear();
                    Admob_native_Ad.add(nativeAd);
                } else {
                    Admob_native_Ad.add(nativeAd);
                }
//                    Admob_native_Ad.add(nativeAd);
                isadmob_native_Loaded = true;
                Log.d("FootBall", "Admob Native Ad Loaded");
            });
            builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d("FootBall", "Admob Native Ad Failed");
                    // Adx
                    if (isadx_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Log.d("FootBall", "Adx Native Ad Loaded");
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
                            Log.d("FootBall", "Adx Native Ad Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Log.d("FootBall", "Admob Native Ad Loaded");
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
                    Log.d("FootBall", "Admob Native Ad Failed");
                    //Fb
                    if (isFBNativeLoaded) {
                        return;
                    }
                    final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            Log.d("FootBall", "Native ad finished downloading all assets.");
                        }

                        @SuppressLint("MissingPermission")
                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "Native ad Failed " + adError.getErrorMessage());
                            //preload_Admob_Fb_Native_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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
                            Log.d("FootBall", "Native ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {
                            Log.d("FootBall", "Native ad impression logged!");
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

    public void preload_Admob_Wortise_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob Native
            if (isadmob_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
            builder.forNativeAd(nativeAd -> {
                Log.d("FootBall", "Admob Native Ad Loaded");
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
                    Log.d("FootBall", "Admob Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Adx_Admob_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Log.d("FootBall", "Adx Native Ad Loaded");
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
                    Log.d("FootBall", "Adx Native Ad Failed");
                    // Admob Native
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("FootBall", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Native Ad Failed");
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
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Log.d("FootBall", "Adx Native Ad Loaded");
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
                    Log.d("FootBall", "Adx Native Ad Failed");
                    //Fb Native
                    if (isFBNativeLoaded) {
                        return;
                    }
                    final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
                    NativeAdListener nativeAdListener = new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {
                            Log.d("FootBall", "Native ad finished downloading all assets.");
                        }

                        @SuppressLint("MissingPermission")
                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "Native ad Failed " + adError.getErrorMessage());
                            //preload_Adx_Fb_Native_Ad();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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
                            Log.d("FootBall", "Native ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {
                            Log.d("FootBall", "Native ad impression logged!");
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

    public void preload_Adx_Wortise_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx
            if (isadx_native_Loaded) {
                return;
            }
            final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
            builder.forNativeAd(nativeAd -> {
                Log.d("FootBall", "Adx Native Ad Loaded");
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
                    Log.d("FootBall", "Adx Native Ad Failed");
                }

                public void onAdLoaded() {
                    super.onAdLoaded();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    public void preload_Fb_Admob_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    Log.d("FootBall", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "Native ad Failed " + adError.getErrorMessage());
                    // Admob Native
                    if (isadmob_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid());
                    builder.forNativeAd(nativeAd -> {
                        if (Admob_native_Ad.size() > 0) {
                            Admob_native_Ad.clear();
                            Admob_native_Ad.add(nativeAd);
                        } else {
                            Admob_native_Ad.add(nativeAd);
                        }
//                            Admob_native_Ad.add(nativeAd);
                        isadmob_native_Loaded = true;
                        Log.d("FootBall", "Admob Native Ad Loaded");
                    });
                    builder.withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            Log.d("FootBall", "Admob Native Ad Failed");
                            // preload_Fb_Admob_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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
                    Log.d("FootBall", "Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "Native ad impression logged!");
                }
            };
            // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        }
    }

    public void preload_Fb_Adx_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    Log.d("FootBall", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "Native ad Failed " + adError.getErrorMessage());
                    // Adx
                    if (isadx_native_Loaded) {
                        return;
                    }
                    final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId());
                    builder.forNativeAd(nativeAd -> {
                        Log.d("FootBall", "Adx Native Ad Loaded");
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
                            Log.d("FootBall", "Adx Native Ad Failed");
                            //preload_Fb_Adx_Native_Ad();
                        }

                        public void onAdLoaded() {
                            super.onAdLoaded();
                        }
                    }).build().loadAd(new AdRequest.Builder().build());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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
                    Log.d("FootBall", "Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "Native ad impression logged!");
                }
            };
            // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        }
    }

    public void preload_Fb_Wortise_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            //Fb
            if (isFBNativeLoaded) {
                return;
            }
            final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId());
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {
                    Log.d("FootBall", "Native ad finished downloading all assets.");
                }

                @SuppressLint("MissingPermission")
                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "Native ad Failed " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "Native ad is loaded and ready to be displayed!");
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
                    Log.d("FootBall", "Native ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "Native ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            //Admob Mediam Ragtangal
            if (isAdmob_Mediam_Ragtangal_Loaded) {
                return;
            }
            final AdView admob_Mediam_Ragtangal = new AdView(activity);
            admob_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
            admob_Mediam_Ragtangal.setAdUnitId(app_data.get(0).getAdmobMediumRectangleid());
            AdRequest adRequest = new AdRequest.Builder().build();
            admob_Mediam_Ragtangal.loadAd(adRequest);
            admob_Mediam_Ragtangal.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    Log.d("FootBall", "admob mediam ragtangal loaded");
                    admobMediam_Ragtangal = admob_Mediam_Ragtangal;
                    isAdmob_Mediam_Ragtangal_Loaded = true;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                    Log.d("FootBall", "admob mediam ragtangal failed");
                    // Adx
                    if (isAdx_Mediam_Ragtangal_Loaded) {
                        return;
                    }
                    final AdManagerAdView adx_Mediam_Ragtangal = new AdManagerAdView(activity);
                    adx_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
                    adx_Mediam_Ragtangal.setAdUnitId(app_data.get(0).getAdxMediumRectangleid());
                    AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    adx_Mediam_Ragtangal.loadAd(adRequest);
                    adx_Mediam_Ragtangal.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d("FootBall", "adx mediam ragtangal loaded");
                            adxMediam_Ragtangal = adx_Mediam_Ragtangal;
                            isAdx_Mediam_Ragtangal_Loaded = true;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                            Log.d("FootBall", "adx mediam ragtangal failed");
                            // Fb
                            if (isFB_Mediam_Ragtangal_Loaded) {
                                return;
                            }
                            final com.facebook.ads.AdView fb_Ragtangal = new com.facebook.ads.AdView(activity, app_data.get(0).getFbMediumRectangleId(), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                            com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB mediam ragtangal Loadedd ");
                                    fb_Ragtangal_adView = fb_Ragtangal;
                                    isFB_Mediam_Ragtangal_Loaded = true;
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "Fb mediam ragtangal onError: " + adError.getErrorCode());
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

        if (app_data != null && app_data.size() > 0) {
            String platform = app_data.get(0).getAdNative();
            if (platform.equalsIgnoreCase(Admob)) {
                new All_Type_Ads(activity).show_native_ad_AAFB(native_ad);
            } else if (platform.equalsIgnoreCase(Adx)) {
                new All_Type_Ads(activity).show_native_ad_Adx(native_ad);
            } else if (platform.equalsIgnoreCase(FB)) {
                new All_Type_Ads(activity).show_native_ad_FBAA(native_ad);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                new All_Type_Ads(activity).show_native_ad_Admob_Adx(native_ad);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                new All_Type_Ads(activity).show_native_ad_Admob_Fb(native_ad);
            } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                new All_Type_Ads(activity).show_native_ad_Admob_Wortise(native_ad);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                new All_Type_Ads(activity).show_native_ad_Adx_Admob(native_ad);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                new All_Type_Ads(activity).show_native_ad_Adx_Fb(native_ad);
            } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                new All_Type_Ads(activity).show_native_ad_Adx_Wortise(native_ad);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                new All_Type_Ads(activity).show_native_ad_Fb_Admob(native_ad);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                new All_Type_Ads(activity).show_native_ad_Fb_Adx(native_ad);
            } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                new All_Type_Ads(activity).show_native_ad_Fb_Wortise(native_ad);
            } else if (platform.equalsIgnoreCase(Mrec)) {
                new All_Type_Ads(activity).show_MREC_Banner(native_ad);
            } else if (platform.equalsIgnoreCase(Local)) {
                new All_Type_Ads(activity).show_native_Local(native_ad);
            }
        }
    }

    //-------------------------------------------- Inter Ads ----------------------------------------------------------------------------

    // Admob Mode
    public void Load_interAds_Admob() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobInterid();
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    Log.d("FootBall", "Admob Inter Loaded");
                    ADMOBInterstitialAd = interstitialAd;
                    isGoogleInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Admob Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                            }

                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.d("FootBall", "Admob Inter Failed");
                    // ADX
                    if (isAdxInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdxInterId();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                            super.onAdLoaded(interstitialAd);
                            Log.d("FootBall", "Adx Inter Loaded");
                            ADXInterstitialAd = interstitialAd;
                            isAdxInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Adx Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
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
                            Log.d("FootBall", "Adx Inter Failed");
                            // FB
                            if (isFBInterLoaded) {
                                return;
                            }
                            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
                            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {

                                    Log.d("FootBall", "FB Inter ad Show.");
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {

                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                    }
                                    Log.d("FootBall", "FB  Inter Ad Close.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Inter Failed to Load: " + adError.getErrorCode());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Inter ad Loaded");
                                    FB_interstitialAd = FB_interstitial;
                                    isFBInterLoaded = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                    Log.d("FootBall", "FB Interstitial ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                    Log.d("FootBall", "FB Interstitial ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxInterId();
            final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    Log.d("FootBall", "Adx Inter Loaded");
                    ADXInterstitialAd = interstitialAd;
                    isAdxInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Adx Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
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
                    Log.d("FootBall", "Adx Inter Failed");
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdmobInterid();
                    AdRequest adRequest = new AdRequest.Builder().build();
                    InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d("FootBall", "Admob Inter Loaded");
                            ADMOBInterstitialAd = interstitialAd;
                            isGoogleInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Admob Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                                    Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d("FootBall", "Admob Inter Failed");
                            // FB
                            if (isFBInterLoaded) {
                                return;
                            }
                            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
                            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {
                                    Log.d("FootBall", "FB Inter ad Show.");
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                    }
                                    Log.d("FootBall", "FB  Inter Ad Close.");
                                }

                                @Override
                                public void onError(Ad ad, AdError adError) {
                                    Log.d("FootBall", "FB Inter Failed to Load: " + adError.getErrorCode());
                                }

                                @Override
                                public void onAdLoaded(Ad ad) {
                                    Log.d("FootBall", "FB Inter ad Loaded");
                                    FB_interstitialAd = FB_interstitial;
                                    isFBInterLoaded = true;
                                }

                                @Override
                                public void onAdClicked(Ad ad) {
                                    Log.d("FootBall", "FB Interstitial ad clicked!");
                                }

                                @Override
                                public void onLoggingImpression(Ad ad) {
                                    Log.d("FootBall", "FB Interstitial ad impression logged!");
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
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    Log.d("FootBall", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Inter Failed");
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdmobInterid();
                    final AdRequest adRequest = new AdRequest.Builder().build();
                    InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d("FootBall", "Admob Inter Loaded");
                            ADMOBInterstitialAd = interstitialAd;
                            isGoogleInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Admob Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                                    Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d("FootBall", "Admob Inter Failed");
                            // ADX
                            if (isAdxInterLoaded) {
                                return;
                            }
                            String placementId = app_data.get(0).getAdxInterId();
                            AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                                @Override
                                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                                    super.onAdLoaded(interstitialAd);
                                    ADXInterstitialAd = interstitialAd;
                                    Log.d("FootBall", "Adx Inter Loaded");
                                    isAdxInterLoaded = true;
                                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            Log.d("FootBall", "Adx Inter Close");
                                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                                if (myCallback != null) {
                                                    myCallback.OnCall();
                                                    myCallback = null;
                                                }
                                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                            } else {
                                                QurekaadCounter = QurekaadCounter + 1;
                                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                                if (myCallback != null) {
                                                    myCallback.OnCall();
                                                    myCallback = null;
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
                                    Log.d("FootBall", "Adx Inter Failed");
                                }
                            });
                        }
                    });
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Inter ad Loaded");
                    FB_interstitialAd = FB_interstitial;
                    isFBInterLoaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad impression logged!");
                }
            };
            FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
        }
    }

    public void Admob_Adx() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobInterid();
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    Log.d("FootBall", "Admob Inter Loaded");
                    ADMOBInterstitialAd = interstitialAd;
                    isGoogleInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Admob Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.d("FootBall", "Admob Inter Failed");
                    // ADX
                    if (isAdxInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdxInterId();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                            super.onAdLoaded(interstitialAd);
                            Log.d("FootBall", "Adx Inter Loaded");
                            ADXInterstitialAd = interstitialAd;
                            isAdxInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Adx Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
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
                            Log.d("FootBall", "Adx Inter Failed");
                            //Admob_Adx();
                        }
                    });
                }
            });
        }
    }

    public void Admob_Fb() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobInterid();
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    Log.d("FootBall", "Admob Inter Loaded");
                    ADMOBInterstitialAd = interstitialAd;
                    isGoogleInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Admob Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.d("FootBall", "Admob Inter Failed");
                    // FB
                    if (isFBInterLoaded) {
                        return;
                    }
                    final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
                    InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                        @Override
                        public void onInterstitialDisplayed(Ad ad) {
                            Log.d("FootBall", "FB Interstitial ad displayed.");
                        }

                        @Override
                        public void onInterstitialDismissed(Ad ad) {
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                            }
                            Log.d("FootBall", "FB Inter ad Close.");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Inter Failed" + adError);
                            // Admob_Fb();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "FB Inter ad Loaded");
                            FB_interstitialAd = FB_interstitial;
                            isFBInterLoaded = true;
                        }

                        @Override
                        public void onAdClicked(Ad ad) {
                            Log.d("FootBall", "FB Interstitial ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {
                            Log.d("FootBall", "FB Interstitial ad impression logged!");
                        }
                    };
                    FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
                }
            });
        }
    }

    public void Admob_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            // Admob
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobInterid();
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    Log.d("FootBall", "Admob Inter Loaded");
                    ADMOBInterstitialAd = interstitialAd;
                    isGoogleInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Admob Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                        }
                    });
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    Log.d("FootBall", "Admob Inter Failed");
                }
            });
        }
    }

    public void Adx_Admob() {
        if (app_data != null && app_data.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxInterId();
            @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    Log.d("FootBall", "Adx Inter Loaded");
                    ADXInterstitialAd = interstitialAd;
                    isAdxInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Adx Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
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
                    Log.d("FootBall", "Adx Inter Failed");
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdmobInterid();
                    final AdRequest adRequest = new AdRequest.Builder().build();
                    InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d("FootBall", "Admob Inter Loaded");
                            ADMOBInterstitialAd = interstitialAd;
                            isGoogleInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Admob Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                                    Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d("FootBall", "Admob Inter Failed");
                            //Adx_Admob();
                        }
                    });
                }
            });
        }
    }

    public void Adx_Fb() {
        if (app_data != null && app_data.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxInterId();
            @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    Log.d("FootBall", "Adx Inter Loaded");
                    ADXInterstitialAd = interstitialAd;
                    isAdxInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Adx Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
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
                    Log.d("FootBall", "Adx Inter Failed");
                    // FB
                    if (isFBInterLoaded) {
                        return;
                    }
                    final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
                    InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                        @Override
                        public void onInterstitialDisplayed(Ad ad) {
                            Log.d("FootBall", "FB Interstitial ad displayed.");
                        }

                        @Override
                        public void onInterstitialDismissed(Ad ad) {
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                            }
                            Log.d("FootBall", "FB Inter ad Close.");
                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            Log.d("FootBall", "FB Inter Failed" + adError);
                            //Adx_Fb();
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            Log.d("FootBall", "FB Inter ad Loaded");
                            FB_interstitialAd = FB_interstitial;
                            isFBInterLoaded = true;
                        }

                        @Override
                        public void onAdClicked(Ad ad) {
                            Log.d("FootBall", "FB Interstitial ad clicked!");
                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {
                            Log.d("FootBall", "FB Interstitial ad impression logged!");
                        }
                    };
                    FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
                }
            });
        }
    }

    public void Adx_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            // ADX
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxInterId();
            @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
            AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    Log.d("FootBall", "Adx Inter Loaded");
                    ADXInterstitialAd = interstitialAd;
                    isAdxInterLoaded = true;
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Adx Inter Close");
                            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
                                }
                                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                            } else {
                                QurekaadCounter = QurekaadCounter + 1;
                                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                if (myCallback != null) {
                                    myCallback.OnCall();
                                    myCallback = null;
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
                    Log.d("FootBall", "Adx Inter Failed");
                }
            });
        }
    }

    public void Fb_Admob() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                    } else {
                        QurekaadCounter = QurekaadCounter + 1;
                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                    Log.d("FootBall", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Inter Failed" + adError);
                    // Admob
                    if (isGoogleInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdmobInterid();
                    final AdRequest adRequest = new AdRequest.Builder().build();
                    InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            Log.d("FootBall", "Admob Inter Loaded");
                            ADMOBInterstitialAd = interstitialAd;
                            isGoogleInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Admob Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                                    Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                                }

                                @Override
                                public void onAdShowedFullScreenContent() {
                                }
                            });
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.d("FootBall", "Admob Inter Failed");
                            //Fb_Admob();
                        }
                    });
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Inter ad Loaded");
                    FB_interstitialAd = FB_interstitial;
                    isFBInterLoaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad impression logged!");
                }
            };
            FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
        }
    }

    public void Fb_Adx() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                    } else {
                        QurekaadCounter = QurekaadCounter + 1;
                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                    Log.d("FootBall", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Inter Failed" + adError);
                    // ADX
                    if (isAdxInterLoaded) {
                        return;
                    }
                    String placementId = app_data.get(0).getAdxInterId();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                            super.onAdLoaded(interstitialAd);
                            Log.d("FootBall", "Adx Inter Loaded");
                            ADXInterstitialAd = interstitialAd;
                            isAdxInterLoaded = true;
                            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Adx Inter Close");
                                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
                                        }
                                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                                    } else {
                                        QurekaadCounter = QurekaadCounter + 1;
                                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                                        if (myCallback != null) {
                                            myCallback.OnCall();
                                            myCallback = null;
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
                            Log.d("FootBall", "Adx Inter Failed");
                            //Fb_Adx();
                        }
                    });
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Inter ad Loaded");
                    FB_interstitialAd = FB_interstitial;
                    isFBInterLoaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad impression logged!");
                }
            };
            FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
        }
    }

    public void Fb_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            // FB
            if (isFBInterLoaded) {
                return;
            }
            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFbInterId());
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                    if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                        qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                    } else {
                        QurekaadCounter = QurekaadCounter + 1;
                        SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                    Log.d("FootBall", "FB Inter ad Close.");
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.d("FootBall", "FB Inter Failed" + adError);
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d("FootBall", "FB Inter ad Loaded");
                    FB_interstitialAd = FB_interstitial;
                    isFBInterLoaded = true;
                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d("FootBall", "FB Interstitial ad impression logged!");
                }
            };
            FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
        }
    }

    // Show Back Inter
    public void show_Interstitial_Back(MyCallback myCallback2) {
        myCallback = myCallback2;

        if (app_data.size() == 0) {
            convertedObject = matchalldetail_Utils.getResponse(activity);
            if (convertedObject != null) {
                app_data.add(convertedObject);
            }
        }
        if (app_data != null && app_data.size() > 0) {
            String platform = app_data.get(0).getAdInterBack();
            if (platform.equalsIgnoreCase(Admob)) {
                show_Interstitial_Admob_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Adx)) {
                show_Interstitial_Adx_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(FB)) {
                show_Interstitial_FB_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                show_Interstitial_Admob_Adx_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                show_Interstitial_Admob_Fb_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                show_Interstitial_Admob_Wortise_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                show_Interstitial_Adx_Admob_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                show_Interstitial_Adx_Fb_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                show_Interstitial_Adx_Wortise_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                show_Interstitial_Fb_Admob_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                show_Interstitial_Fb_Adx_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                show_Interstitial_Fb_Wortise_Back(myCallback2);
            } else if (platform.equalsIgnoreCase(Appopen)) {
                showAd_appopen_inter(myCallback2);
            } else if (platform.equalsIgnoreCase(Local)) {
                show_local_interad(myCallback2);
            } else if (platform.equalsIgnoreCase("off")) {
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
            }
        }
    }

    // Admob Mode
    public void show_Interstitial_Admob_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Load_interAds_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // Adx Mode
    public void show_Interstitial_Adx_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Load_interAds_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // FB Mode
    public void show_Interstitial_FB_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_FB();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_FB();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_FB();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Load_interAds_FB();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Admob_Adx Mode
    public void show_Interstitial_Admob_Adx_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Admob_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Admob_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Admob_Fb Mode
    public void show_Interstitial_Admob_Fb_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Fb();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Admob_Fb();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Admob_Fb();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Admob_Wortise Mode
    public void show_Interstitial_Admob_Wortise_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Wortise();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Admob_Wortise();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // Adx_Admob Mode
    public void show_Interstitial_Adx_Admob_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Adx_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Adx_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Adx_Fb Mode
    public void show_Interstitial_Adx_Fb_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Fb();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Adx_Fb();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Adx_Fb();

            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // Adx_Wortise Mode
    public void show_Interstitial_Adx_Wortise_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Wortise();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {

            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Adx_Wortise();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Fb_Admob mode
    public void show_Interstitial_Fb_Admob_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Fb_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Fb_Admob();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Fb_Adx mode
    public void show_Interstitial_Fb_Adx_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Fb_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Fb_Adx();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Fb_Wortise mode
    public void show_Interstitial_Fb_Wortise_Back(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Wortise();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adBackCounter = SharedPreferencesManager.getInstance(activity).getbackpressNumberOfClicks();
            if (adBackCounter == app_data.get(0).getInterBackCount()) {
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(1);
                show_qureka_interad(myCallback2);
                Fb_Wortise();
            } else {
                adBackCounter = adBackCounter + 1;
                SharedPreferencesManager.getInstance(activity).backpressstoreClicks(adBackCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }


        }
    }

    // Show Inter
    public void show_Interstitial(MyCallback myCallback2) {
        myCallback = myCallback2;

        if (My_Manage.isOnline(activity)) {
            if (app_data.size() == 0) {
                convertedObject = matchalldetail_Utils.getResponse(activity);
                if (convertedObject != null) {
                    app_data.add(convertedObject);
                }
            }
            if (app_data != null && app_data.size() > 0) {
                String platform = app_data.get(0).getAdInter();
                if (platform.equalsIgnoreCase(Admob)) {
                    show_Interstitial_Admob(myCallback2);
                } else if (platform.equalsIgnoreCase(Adx)) {
                    show_Interstitial_Adx(myCallback2);
                } else if (platform.equalsIgnoreCase(FB)) {
                    show_Interstitial_FB(myCallback2);
                } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                    show_Interstitial_Admob_Adx(myCallback2);
                } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                    show_Interstitial_Admob_Fb(myCallback2);
                } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                    show_Interstitial_Admob_Wortise(myCallback2);
                } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                    show_Interstitial_Adx_Admob(myCallback2);
                } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                    show_Interstitial_Adx_Fb(myCallback2);
                } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                    show_Interstitial_Adx_Wortise(myCallback2);
                } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                    show_Interstitial_Fb_Admob(myCallback2);
                } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                    show_Interstitial_Fb_Adx(myCallback2);
                } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                    show_Interstitial_Fb_Wortise(myCallback2);
                } else if (platform.equalsIgnoreCase(Appopen)) {
                    showAd_appopen_inter(myCallback2);
                } else if (platform.equalsIgnoreCase(Local)) {
                    show_local_interad(myCallback2);
                } else if (platform.equalsIgnoreCase("off")) {
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            BottomSheetDialog networkcheckdialog = new BottomSheetDialog(activity);
            networkcheckdialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.internet_dialog, (ViewGroup) null));
            networkcheckdialog.setCancelable(false);
            TextView materialButton = (TextView) networkcheckdialog.findViewById(R.id.btn_recheck);

            materialButton.setOnClickListener(view -> {
                if (My_Manage.isOnline(activity)) {
                    networkcheckdialog.dismiss();
                    if (app_data.size() == 0) {
                        convertedObject = matchalldetail_Utils.getResponse(activity);
                        if (convertedObject != null) {
                            app_data.add(convertedObject);
                        }
                    }
                    if (app_data != null && app_data.size() > 0) {
                        String platform = app_data.get(0).getAdInter();
                        if (platform.equalsIgnoreCase(Admob)) {
                            show_Interstitial_Admob(myCallback2);
                        } else if (platform.equalsIgnoreCase(Adx)) {
                            show_Interstitial_Adx(myCallback2);
                        } else if (platform.equalsIgnoreCase(FB)) {
                            show_Interstitial_FB(myCallback2);
                        } else if (platform.equalsIgnoreCase(Admob_Adx)) {
                            show_Interstitial_Admob_Adx(myCallback2);
                        } else if (platform.equalsIgnoreCase(Admob_Fb)) {
                            show_Interstitial_Admob_Fb(myCallback2);
                        } else if (platform.equalsIgnoreCase(Admob_Wortise)) {
                            show_Interstitial_Admob_Wortise(myCallback2);
                        } else if (platform.equalsIgnoreCase(Adx_Admob)) {
                            show_Interstitial_Adx_Admob(myCallback2);
                        } else if (platform.equalsIgnoreCase(Adx_Fb)) {
                            show_Interstitial_Adx_Fb(myCallback2);
                        } else if (platform.equalsIgnoreCase(Adx_Wortise)) {
                            show_Interstitial_Adx_Wortise(myCallback2);
                        } else if (platform.equalsIgnoreCase(Fb_Admob)) {
                            show_Interstitial_Fb_Admob(myCallback2);
                        } else if (platform.equalsIgnoreCase(Fb_Adx)) {
                            show_Interstitial_Fb_Adx(myCallback2);
                        } else if (platform.equalsIgnoreCase(Fb_Wortise)) {
                            show_Interstitial_Fb_Wortise(myCallback2);
                        } else if (platform.equalsIgnoreCase(Appopen)) {
                            showAd_appopen_inter(myCallback2);
                        } else if (platform.equalsIgnoreCase(Local)) {
                            show_local_interad(myCallback2);
                        } else if (platform.equalsIgnoreCase("off")) {
                            if (myCallback != null) {
                                myCallback.OnCall();
                                myCallback = null;
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
    public void show_Interstitial_Admob(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Load_interAds_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // Adx Mode
    public void show_Interstitial_Adx(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Load_interAds_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // FB Mode
    public void show_Interstitial_FB(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Load_interAds_FB();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Load_interAds_FB();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Load_interAds_FB();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Load_interAds_FB();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // Admob_Adx Mode
    public void show_Interstitial_Admob_Adx(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Admob_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Admob_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        }
    }

    // Admob_Fb Mode
    public void show_Interstitial_Admob_Fb(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Fb();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Admob_Fb();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Admob_Fb();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Admob_Wortise Mode
    public void show_Interstitial_Admob_Wortise(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Admob_Wortise();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Admob_Wortise();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Adx_Admob Mode
    public void show_Interstitial_Adx_Admob(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Adx_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Adx_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Adx_Fb Mode
    public void show_Interstitial_Adx_Fb(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Fb();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Adx_Fb();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Adx_Fb();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Adx_Wortise Mode
    public void show_Interstitial_Adx_Wortise(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Adx_Wortise();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Adx_Wortise();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Fb_Admob mode
    public void show_Interstitial_Fb_Admob(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isGoogleInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADMOBInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADMOBInterstitialAd.show((Activity) activity);
                isGoogleInterLoaded = false;
                Fb_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Fb_Admob();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }

    // Fb_Adx mode
    public void show_Interstitial_Fb_Adx(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else if (isAdxInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && ADXInterstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                ADXInterstitialAd.show((Activity) activity);
                isAdxInterLoaded = false;
                Fb_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Fb_Adx();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }


        }
    }

    // Fb_Wortise mode
    public void show_Interstitial_Fb_Wortise(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (isFBInterLoaded) {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount() && FB_interstitialAd != null) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                FB_interstitialAd.show();
                isFBInterLoaded = false;
                Fb_Wortise();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }
        } else {
            adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
            if (adCounter == app_data.get(0).getInterCount()) {
                SharedPreferencesManager.getInstance(activity).storeClicks(1);
                show_qureka_interad(myCallback2);
                Fb_Wortise();
            } else {
                adCounter = adCounter + 1;
                SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
                if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                    qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
                } else {
                    QurekaadCounter = QurekaadCounter + 1;
                    SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }
            }

        }
    }


    //---------------------------------------------- Appopen Ads ---------------------------------------------------------

    public void show_appopen_ads(MyCallback myCallback2) {
        if (app_data != null && app_data.size() > 0) {
            showAdIfAvailable(myCallback2);
        }
    }

    public void showAdIfAvailable(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (app_data != null && app_data.size() > 0) {
            String paltform = app_data.get(0).getAdAppopen();
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
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
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

            Log.d("FootBall", "platttttt");
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
            } else if (paltform.equalsIgnoreCase(Local)) {
                show_local_appopen(null);
            } else if (paltform.equalsIgnoreCase("off")) {
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
            }
        }
    }

    public void showAd_appopen_inter(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (app_data != null && app_data.size() > 0) {
            String paltform = app_data.get(0).getAd_appopen_inter();
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
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
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
                    adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        SharedPreferencesManager.getInstance(activity).storeClicks(1);
                        admob_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        admob_appOpenAd.show((Activity) activity);
                        isadmob_appopen_Loaded = false;
                    } else {
                        adCounter = adCounter + 1;
                        SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                } else if (isadx_appopen_Loaded) {
                    adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        SharedPreferencesManager.getInstance(activity).storeClicks(1);
                        adx_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        adx_appOpenAd.show((Activity) activity);
                        isadx_appopen_Loaded = false;
                    } else {
                        adCounter = adCounter + 1;
                        SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                } else {
                    adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        SharedPreferencesManager.getInstance(activity).storeClicks(1);
                        show_qureka_appopen(null);
                    } else {
                        adCounter = adCounter + 1;
                        SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                }
            } else if (paltform.equalsIgnoreCase(Adx)) {
                if (isadx_appopen_Loaded) {
                    adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        SharedPreferencesManager.getInstance(activity).storeClicks(1);
                        adx_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        adx_appOpenAd.show((Activity) activity);
                        isadx_appopen_Loaded = false;
                    } else {
                        adCounter = adCounter + 1;
                        SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                } else if (isadmob_appopen_Loaded) {
                    adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        SharedPreferencesManager.getInstance(activity).storeClicks(1);
                        admob_appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        admob_appOpenAd.show((Activity) activity);
                        isadmob_appopen_Loaded = false;
                    } else {
                        adCounter = adCounter + 1;
                        SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }
                } else {
                    adCounter = SharedPreferencesManager.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        SharedPreferencesManager.getInstance(activity).storeClicks(1);
                        show_qureka_appopen(null);
                    } else {
                        adCounter = adCounter + 1;
                        SharedPreferencesManager.getInstance(activity).storeClicks(adCounter);
                        if (myCallback != null) {
                            myCallback.OnCall();
                            myCallback = null;
                        }
                    }

                }
            } else if (paltform.equalsIgnoreCase("off")) {
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
            }
        }
    }

    // Admob
    public void get_admob_appopen_AdsLoad() {
        if (app_data != null && app_data.size() > 0) {
            // Admob Appopen
            if (isadmob_appopen_Loaded) {
                return;
            }
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    Log.d("FootBall", "Admob Open Ad loaded");
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
                            Log.d("FootBall", "Adx Open Ad loaded");
                            adx_appOpenAd = appOpenAd;
                            isadx_appopen_Loaded = true;
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                        }
                    };
                    AppOpenAd.load(activity, app_data.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, app_data.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
        }
    }

    // Adx
    public void get_adx_appopen_AdsLoad() {
        if (app_data != null && app_data.size() > 0) {
            // Adx Appopen
            if (isadx_appopen_Loaded) {
                return;
            }
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    Log.d("FootBall", "Adx Open Ad loaded");
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
                            Log.d("FootBall", "Admob Open Ad loaded");
                            admob_appOpenAd = appOpenAd;
                            isadmob_appopen_Loaded = true;
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                        }
                    };
                    AppOpenAd.load(activity, app_data.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, app_data.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
        }
    }

    // ----------------------------------------------- Splash Appopen Ads ------------------------------------------------------

    public void show_splash(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (app_data != null && app_data.size() > 0) {
            String paltform = app_data.get(0).getAdSplash();
            fullScreenContentCallback = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
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
                getSplash_appopen_Admob(myCallback2);
            } else if (paltform.equalsIgnoreCase(Adx)) {
                getSplash_appopen_Adx(myCallback2);
            } else if (paltform.equalsIgnoreCase(Local)) {
                show_local_appopen(myCallback2);
            } else if (paltform.equalsIgnoreCase("off")) {
                new Handler().postDelayed(() -> {
                    if (myCallback != null) {
                        myCallback.OnCall();
                        myCallback = null;
                    }
                }, 3000);
            }
        }
    }

    // Admob
    public void getSplash_appopen_Admob(MyCallback mCallback) {
        myCallback = mCallback;
        if (app_data != null && app_data.size() > 0) {
            // Admob Appopen
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    appOpenAd.show((Activity) activity);
                    Log.d("FootBall", "Admob Appopen Show");
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Adx Appopen
                    AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            super.onAdLoaded(appOpenAd);
                            appOpenAd.show((Activity) activity);
                            Log.d("FootBall", "Adx Appopen Show");
                            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            show_qureka_appopen(myCallback);
                        }
                    };
                    AppOpenAd.load(activity, app_data.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, app_data.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
        }
    }

    // Adx
    public void getSplash_appopen_Adx(MyCallback mCallback) {
        myCallback = mCallback;
        if (app_data != null && app_data.size() > 0) {
            // Adx Appopen
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    appOpenAd.show((Activity) activity);
                    Log.d("FootBall", "Adx Appopen Show");
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    // Admob Appopen
                    AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                        public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                            super.onAdLoaded(appOpenAd);
                            appOpenAd.show((Activity) activity);
                            Log.d("FootBall", "Admob Appopen Show");
                            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        }

                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            super.onAdFailedToLoad(loadAdError);
                            show_qureka_appopen(myCallback);
                        }
                    };
                    AppOpenAd.load(activity, app_data.get(0).getAdmobAppopenid(), getAdRequest(), 1, loadCallback);
                }
            };
            AppOpenAd.load(activity, app_data.get(0).getAdxAppopenId(), adManagerAdRequest(), 1, loadCallback);
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    @SuppressLint("VisibleForTests")
    private AdManagerAdRequest adManagerAdRequest() {
        return new AdManagerAdRequest.Builder().build();
    }

    public void show_splash_inter(MyCallback myCallback2) {
        myCallback = myCallback2;
        if (app_data != null && app_data.size() > 0) {
            String placementId = app_data.get(0).getAdmob_splash_interid();
            final AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    super.onAdLoaded(interstitialAd);
                    interstitialAd.show((Activity) activity);
                    interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Log.d("FootBall", "Admob Inter Close");
                            if (myCallback != null) {
                                myCallback.OnCall();
                                myCallback = null;
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                            if (myCallback != null) {
                                myCallback.OnCall();
                                myCallback = null;
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
                    String placementId = app_data.get(0).getAdx_splash_inter_id();
                    @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                    AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull AdManagerInterstitialAd adManagerInterstitialAd) {
                            super.onAdLoaded(adManagerInterstitialAd);
                            adManagerInterstitialAd.show((Activity) activity);
                            adManagerInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    Log.d("FootBall", "Admob Inter Close");
                                    if (myCallback != null) {
                                        myCallback.OnCall();
                                        myCallback = null;
                                    }
                                }

                                @Override
                                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                    Log.d("FootBall", "Admob Inter failed to show" + adError.getMessage());
                                    if (myCallback != null) {
                                        myCallback.OnCall();
                                        myCallback = null;
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
                            final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, app_data.get(0).getFb_splash_inter_id());
                            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                                @Override
                                public void onInterstitialDisplayed(Ad ad) {
                                }

                                @Override
                                public void onInterstitialDismissed(Ad ad) {
                                    if (myCallback != null) {
                                        myCallback.OnCall();
                                        myCallback = null;
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

    public final void show_local_appopen(MyCallback myCallback1) {
        Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
        dialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.matchalldetail_local_appopen, (ViewGroup) null));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.llPersonalAd);
        TextView textView = (TextView) dialog.findViewById(R.id.install);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ll_continue_app);
        TextView textView2 = (TextView) dialog.findViewById(R.id.txt_appname);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.app_icon);
        ImageView adbanner = (ImageView) dialog.findViewById(R.id.ad_banner);

        try {
            if (arrAdDataStart != null && arrAdDataStart.size() > 0) {
                textView2.setText(arrAdDataStart.get(0).getAppName());
                Glide.with(activity).load(arrAdDataStart.get(0).getAppIcon()).into(imageView);
                Glide.with(activity).load(arrAdDataStart.get(0).getApp_banner()).into(adbanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        relativeLayout.setOnClickListener(v -> onLocalIntent());
        linearLayout.setOnClickListener(v -> {
            dialog.dismiss();
            if (myCallback1 != null) {
                within();
            } else {
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
            }
        });

        textView.setOnClickListener(v -> onLocalIntent());
        Log.d("FootBall", "Local AppOpen Ad Show");
        dialog.show();
    }


    public final void show_qureka_appopen(MyCallback myCallback1) {
        Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
        dialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.matchalldetail_qureka_appopen, (ViewGroup) null));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        RelativeLayout relativeLayout = (RelativeLayout) dialog.findViewById(R.id.llPersonalAd);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ll_continue_app);


        linearLayout.setOnClickListener(v -> {
            dialog.dismiss();
            if (myCallback1 != null) {
                within();

            } else {
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
            }
        });
        relativeLayout.setOnClickListener(v -> {
            if (convertedObject.getQurekaUrl() != null) {
                qureka_LoadCustom.myCustom((Activity) activity, convertedObject.getQurekaUrl());
            }
        });
        Log.d("FootBall", "qureka AppOpen Ad Show");
        dialog.show();
    }

    public void onLocalIntent() {
        if (arrAdDataStart != null && arrAdDataStart.size() > 0) {
            try {
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + arrAdDataStart.get(0).getPackagename())));
            } catch (ActivityNotFoundException anfe) {
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + arrAdDataStart.get(0).getPackagename())));
            }
        }

    }

    private void show_local_interad(MyCallback myCallback2) {
        Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
        dialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.matchalldetail_local_inter_ad, (ViewGroup) null));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.slide_in_bottom);
        TextView textView = (TextView) dialog.findViewById(R.id.install);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ad_close);
        TextView textView2 = (TextView) dialog.findViewById(R.id.appname);
        ImageView imageView = (ImageView) dialog.findViewById(R.id.app_icon);
        ImageView adbanner = (ImageView) dialog.findViewById(R.id.ad_banner);

        ((CardView) dialog.findViewById(R.id.cvTopAd)).startAnimation(animation);
        try {
            textView.setText("Install");
            if (arrAdDataStart != null && arrAdDataStart.size() > 0) {
                textView2.setText(arrAdDataStart.get(0).getAppName());
                Glide.with(activity).load(arrAdDataStart.get(0).getAppIcon()).into(imageView);
                Glide.with(activity).load(arrAdDataStart.get(0).getApp_banner()).into(adbanner);
            }
        } catch (Exception unused) {
            throw new RuntimeException(unused);
        }

        ((CardView) dialog.findViewById(R.id.cvTopAd)).setOnClickListener(v -> onLocalIntent());
        textView.setOnClickListener(v -> onLocalIntent());
        linearLayout.setOnClickListener(v -> {
            dialog.dismiss();
            if (myCallback != null) {
                myCallback.OnCall();
                myCallback = null;
            }
        });

        Log.d("FootBall", "Local inter Ad Show");
        dialog.show();

    }

    private void show_qureka_interad(MyCallback myCallback2) {
        Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
        dialog.setContentView(LayoutInflater.from(activity).inflate(R.layout.matchalldetail_qureka_inter_ad, (ViewGroup) null));
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(-1, -1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        Animation animation = AnimationUtils.loadAnimation(activity, R.anim.slide_in_bottom);
        TextView textView = (TextView) dialog.findViewById(R.id.install);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.ad_close);
        ((CardView) dialog.findViewById(R.id.cvTopAd)).startAnimation(animation);

        ((CardView) dialog.findViewById(R.id.cvTopAd)).setOnClickListener(v -> {
            if (convertedObject.getQurekaUrl() != null) {
                qureka_LoadCustom.myCustom((Activity) activity, convertedObject.getQurekaUrl());

            }
        });
        textView.setOnClickListener(v -> {
            if (convertedObject.getQurekaUrl() != null) {
                qureka_LoadCustom.myCustom((Activity) activity, convertedObject.getQurekaUrl());
            }
        });
        linearLayout.setOnClickListener(v -> {
            QurekaadCounter = SharedPreferencesManager.getInstance(activity).getqurekaadcounter();
            if (QurekaadCounter == app_data.get(0).getQurekainterCount()) {
                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
                dialog.dismiss();
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
                qureka_LoadCustom.myCustom(activity, app_data.get(0).getQurekaUrl());
            } else {
                QurekaadCounter = QurekaadCounter + 1;
                SharedPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(QurekaadCounter);
                dialog.dismiss();
                if (myCallback != null) {
                    myCallback.OnCall();
                    myCallback = null;
                }
            }
        });
        Log.d("FootBall", "qureka inter Ad Show");
        dialog.show();

    }

    public void within() {
        activity.startActivity(new Intent(activity, matchalldetail_PrivacyPolicyActivity.class));
        ((matchalldetail_Splace_Activity) activity).finish();
    }
}