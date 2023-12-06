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
    public static com.facebook.ads.AdView extrfbadView;

    public static AdView extraadmobMediam_Ragtangal;
    public static AdManagerAdView extraadxMediam_Ragtangal;
    public static com.facebook.ads.AdView extrafb_Ragtangal_adView;
    private ViewGroup parentView;
    private ViewGroup mrec_parentView;

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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_AAFB();
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_AAFB();
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_AAFB();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx(final ViewGroup banner_container) {
        extradxBannerAd = adxBannerAd;
        if (isAdxBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (isGoogleBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_Adx();
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // FB Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_FBAA(final ViewGroup banner_container) {
        extrfbadView = fbadView;
        if (isFBBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_FBAA();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (isGoogleBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_FBAA();
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
                Chembur_Showcard.getInstance(activity).preloadBannerAd_FBAA();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Admob_Adx(final ViewGroup banner_container) {
        extrgoogleBannerAd = googleBannerAd;
        if (isGoogleBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Admob_Adx();
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Admob_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Admob_Fb(final ViewGroup banner_container) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Admob_Fb();
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Admob_Fb();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx_Admob(final ViewGroup banner_container) {
        if (isAdxBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Adx_Admob();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (isGoogleBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Adx_Admob();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx_Fb(final ViewGroup banner_container) {
        if (isAdxBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Adx_Fb();
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Adx_Fb();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    @SuppressLint("MissingPermission")
    public void show_banner_ad_Fb_Admob(final ViewGroup banner_container) {
        if (isFBBannerLoaded) {
            extrfbadView = fbadView;
            if (parentView != null) {
                parentView.removeAllViews();
            }
            if (banner_container != null && extrfbadView != null) {
                banner_container.removeAllViews();
                banner_container.addView(extrfbadView);
                parentView = banner_container;
            }
            isFBBannerLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Banner_Fb_Admob();

        } else if (isGoogleBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Fb_Admob();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void show_banner_ad_Fb_Adx(final ViewGroup banner_container) {
        if (isFBBannerLoaded) {
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Fb_Adx();
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
                Chembur_Showcard.getInstance(activity).preload_Banner_Fb_Adx();
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
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx(final ViewGroup native_banner_ad) {
        if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Banner();
        } else if (isadmob_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            isadmob_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Banner();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Banner();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    // FB Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_FB(final ViewGroup native_banner_ad) {
        if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Native_BannerAd();
        } else if (isadmob_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            isadmob_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Native_BannerAd();
        } else if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Native_BannerAd();
        }else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob_Adx(final ViewGroup native_banner_ad) {
        if (isadmob_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            isadmob_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Native_Banner_Ad();
        } else if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Native_Banner_Ad();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob_Fb(final ViewGroup native_banner_ad) {
        if (isadmob_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            isadmob_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Native_Banner_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Native_Banner_Ad();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }
    

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx_Admob(final ViewGroup native_banner_ad) {
        if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Native_Banner_Ad();
        } else if (isadmob_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            isadmob_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Native_Banner_Ad();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx_Fb(final ViewGroup native_banner_ad) {
        if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("MyAppDataResponse", "Adx Native Banner ad show");
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Native_Banner_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("MyAppDataResponse", "FB Native Banner ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Native_Banner_Ad();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }
    

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Fb_Admob(final ViewGroup native_banner_ad) {
        if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("MyAppDataResponse", "FB Native Banner ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Native_Banner_Ad();
        } else if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("MyAppDataResponse", "Adx Native Banner ad show");
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Native_Banner_Ad();
        }
        else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Fb_Adx(final ViewGroup native_banner_ad) {
        if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native_Banner(Chembur_Showcard.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("MyAppDataResponse", "FB Native Banner ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Native_Banner_Ad();
        } else if (isadx_small_native_banner_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Banner_Ad(Chembur_Showcard.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("MyAppDataResponse", "Adx Native Banner ad show");
            isadx_small_native_banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Native_Banner_Ad();
        } else {
            show_smallnativebanner_Qureka(native_banner_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

   


    //TODO==================================================== Small Native Ad ==============================================================

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob(final ViewGroup small_native) {
        if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Admob_Small_Native_Ad();

        }

    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx(final ViewGroup small_native) {
        if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Adx_Small_Native_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_FB(final ViewGroup small_native) {
        if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Fb_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob_Adx(final ViewGroup small_native) {
        if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Small_Native_Ad();
        } else if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob_Fb(final ViewGroup small_native) {
        if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Small_Native_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Small_Native_Ad();

        }
    }

   

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx_Admob(final ViewGroup small_native) {
        if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Small_Native_Ad();
        } else if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx_Fb(final ViewGroup small_native) {
        if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Small_Native_Ad();
        } else if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Small_Native_Ad();

        }
    }
    
    @SuppressLint("MissingPermission")
    public void show_small_native_Fb_Admob(final ViewGroup small_native) {
        if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Small_Native_Ad();
        } else if (isAdmob_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Admob_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Admob Small Native ad show");
            isAdmob_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Fb_Adx(final ViewGroup small_native) {
        if (Chembur_Showcard.isFBNative_Banner_Loaded) {
            new ChMediumNative(activity).FB_Smalle_Native(Chembur_Showcard.fb_nativeBannerAd.get(0), small_native);
            Log.d("MyAppDataResponse", "FB Small Native ad show");
            Chembur_Showcard.isFBNative_Banner_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Small_Native_Ad();
        } else if (isadx_small_native_Loaded) {
            new ChMediumNative(activity).Admob_Small_Native_Ad(Chembur_Showcard.Adx_small_native_Ad.get(0), small_native);
            Log.d("MyAppDataResponse", "Adx Small Native ad show");
            isadx_small_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Small_Native_Ad();
        } else {
            show_smallnative_Qureka(small_native);
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Small_Native_Ad();

        }
    }

   


    //TODO===================================================== Native Ad =====================================================================

    @SuppressLint("MissingPermission")
    public void show_native_ad_AAFB(final ViewGroup native_ad) {
        if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Ad();
        } else if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Ad();
        } else if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Native_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_Adx(final ViewGroup native_ad) {
        if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Ad();
        } else if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Ad();
        } else if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Adx_Native_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_FBAA(final ViewGroup native_ad) {
        if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preloadFbNativeAd();
        } else if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preloadFbNativeAd();
        } else if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preloadFbNativeAd();
        }  else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preloadFbNativeAd();
        }
    }

    public void show_native_ad_Admob_Adx(final ViewGroup native_ad) {
        if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Native_Ad();
        } else if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Adx_Native_Ad();
        }
    }

    public void show_native_ad_Admob_Fb(final ViewGroup native_ad) {
        if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Native_Ad();
        } else if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Admob_Fb_Native_Ad();
        }
    }

  

    public void show_native_ad_Adx_Admob(final ViewGroup native_ad) {
        if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Native_Ad();
        } else if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Adx_Admob_Native_Ad();
        }
    }

    public void show_native_ad_Adx_Fb(final ViewGroup native_ad) {
        if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
           isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Native_Ad();
        } else if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Adx_Fb_Native_Ad();
        }
    }

  

    public void show_native_ad_Fb_Admob(final ViewGroup native_ad) {
        if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Native_Ad();
        } else if (isadmob_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Admob_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Admob Native ad show");
            isadmob_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Fb_Admob_Native_Ad();
        }
    }

    public void show_native_ad_Fb_Adx(final ViewGroup native_ad) {
        if (Chembur_Showcard.isFBNativeLoaded) {
            new ChMediumNative(activity).FB_Native(Chembur_Showcard.fbnativeAd.get(0), native_ad);
            Log.d("MyAppDataResponse", "FB Native ad show");
            Chembur_Showcard.isFBNativeLoaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Native_Ad();
        } else if (isadx_native_Loaded) {
            new ChMediumNative(activity).Admob_NativeAd(Chembur_Showcard.Adx_native_Ad.get(0), native_ad);
            Log.d("MyAppDataResponse", "Adx Native ad show");
            isadx_native_Loaded = false;
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            Chembur_Showcard.getInstance(activity).preload_Fb_Adx_Native_Ad();
        }
    }
    

    // MREC Banner
    public void show_MREC_Banner(final ViewGroup mrec_banner_ad) {
        if (isAdmob_Mediam_Ragtangal_Loaded) {
            extraadmobMediam_Ragtangal = admobMediam_Ragtangal;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (mrec_banner_ad != null && extraadmobMediam_Ragtangal != null) {
                    mrec_banner_ad.removeAllViews();
                    mrec_banner_ad.addView(extraadmobMediam_Ragtangal);
                    mrec_parentView = mrec_banner_ad;
                }
                Log.d("MyAppDataResponse", "show admob Mediam Ragtangal ad");
                isAdmob_Mediam_Ragtangal_Loaded = false;
                Chembur_Showcard.getInstance(activity).Merc_Banner_Ad();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (isAdx_Mediam_Ragtangal_Loaded) {
            extraadxMediam_Ragtangal = adxMediam_Ragtangal;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (mrec_banner_ad != null && extraadxMediam_Ragtangal != null) {
                    mrec_banner_ad.removeAllViews();
                    mrec_banner_ad.addView(extraadxMediam_Ragtangal);
                    mrec_parentView = mrec_banner_ad;
                }
                Log.d("MyAppDataResponse", "show adx Mediam Ragtangal ad");
                isAdx_Mediam_Ragtangal_Loaded = false;
                Chembur_Showcard.getInstance(activity).Merc_Banner_Ad();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (isFB_Mediam_Ragtangal_Loaded) {
            extrafb_Ragtangal_adView = fb_Ragtangal_adView;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (mrec_banner_ad != null && extrafb_Ragtangal_adView != null) {
                    mrec_banner_ad.removeAllViews();
                    mrec_banner_ad.addView(extrafb_Ragtangal_adView);
                    mrec_parentView = mrec_banner_ad;
                    Log.d("MyAppDataResponse", "show Fb Mediam Ragtangal ad");
                }
                isFB_Mediam_Ragtangal_Loaded = false;
                Chembur_Showcard.getInstance(activity).Merc_Banner_Ad();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            show_native_Qureka(mrec_banner_ad);
            Chembur_Showcard.getInstance(activity).Merc_Banner_Ad();

        }
    }

    public void show_native_Qureka(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.chembur_qureka_native_ad, (ViewGroup) null);
        RelativeLayout rlbackground = viewGroup2.findViewById(R.id.background);
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appDataResponse.getQurekaUrl() != null) {
                    LoadCustomQ.myCustom((Activity) activity, appDataResponse.getQurekaUrl());
                }
            }
        });
        viewGroup.addView(viewGroup2);
    }

    public void show_smallnative_Qureka(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.chembur_qureka_small_native_ad, (ViewGroup) null);
        RelativeLayout rlbackground = viewGroup2.findViewById(R.id.background);
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appDataResponse.getQurekaUrl() != null) {
                    LoadCustomQ.myCustom((Activity) activity, appDataResponse.getQurekaUrl());
                }

            }
        });
        viewGroup.addView(viewGroup2);
    }


    public void show_smallnativebanner_Qureka(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.chembur_qureka_small_native_banner, (ViewGroup) null);
        ConstraintLayout rlbackground = viewGroup2.findViewById(R.id.background);
        TextView ad_headline = viewGroup2.findViewById(R.id.ad_headline);
        ad_headline.setText(appname);
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (appDataResponse.getQurekaUrl() != null) {
                    LoadCustomQ.myCustom((Activity) activity, appDataResponse.getQurekaUrl());
                }

            }
        });
        viewGroup.addView(viewGroup2);
    }
}