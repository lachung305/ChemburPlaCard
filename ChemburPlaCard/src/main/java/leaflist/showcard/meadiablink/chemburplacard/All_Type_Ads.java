package leaflist.showcard.meadiablink.chemburplacard;

import static com.google.adsshow.App.arrAdDataStart;
import static com.google.adsshow.My_Manage.admobMediam_Ragtangal;
import static com.google.adsshow.My_Manage.adxBannerAd;
import static com.google.adsshow.My_Manage.adxMediam_Ragtangal;
import static com.google.adsshow.My_Manage.fb_Ragtangal_adView;
import static com.google.adsshow.My_Manage.fbadView;
import static com.google.adsshow.My_Manage.googleBannerAd;
import static com.livecricket.hsapp.fieldcricket.cricketsports.Main_Ads.matchalldetail_Splace_Activity.convertedObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.adsshow.qureka_mycustomtab.qureka_LoadCustom;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;

public class All_Type_Ads {
    Context activity;
    public static AdView extrgoogleBannerAd;
    public static AdManagerAdView extradxBannerAd;
    public static com.facebook.ads.AdView extrfbadView;

    public static AdView extraadmobMediam_Ragtangal;
    public static AdManagerAdView extraadxMediam_Ragtangal;
    public static com.facebook.ads.AdView extrafb_Ragtangal_adView;
    private ViewGroup parentView;
    private ViewGroup mrec_parentView;

    public All_Type_Ads(Context context) {
        this.activity = context;
    }

    //==================================================== Banner Ads ==================================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_AAF(final ViewGroup banner_container) {
        if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_AAFB();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_AAFB();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isFBBannerLoaded) {
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
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_AAFB();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx(final ViewGroup banner_container) {
        extradxBannerAd = adxBannerAd;
        if (My_Manage.isAdxBannerLoaded) {
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extradxBannerAd != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extradxBannerAd);
                    parentView = banner_container;
                }
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isFBBannerLoaded) {
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
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // FB Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_FBAA(final ViewGroup banner_container) {
        extrfbadView = fbadView;
        if (My_Manage.isFBBannerLoaded) {
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrfbadView != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extrfbadView);
                    parentView = banner_container;
                }
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_FBAA();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_FBAA();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preloadBannerAd_FBAA();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Admob_Adx(final ViewGroup banner_container) {
        extrgoogleBannerAd = googleBannerAd;
        if (My_Manage.isGoogleBannerLoaded) {
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrgoogleBannerAd != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extrgoogleBannerAd);
                    parentView = banner_container;
                }
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Admob_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Admob_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Admob_Fb(final ViewGroup banner_container) {
        if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Admob_Fb();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isFBBannerLoaded) {
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
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Admob_Fb();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Admob_Wortise(final ViewGroup banner_container) {
        if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Admob_Wortise();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx_Admob(final ViewGroup banner_container) {
        if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Adx_Admob();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Adx_Admob();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx_Fb(final ViewGroup banner_container) {
        if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Adx_Fb();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isFBBannerLoaded) {
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
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Adx_Fb();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Adx_Wortise(final ViewGroup banner_container) {
        if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Adx_Wortise();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_banner_ad_Fb_Admob(final ViewGroup banner_container) {
        if (My_Manage.isFBBannerLoaded) {
            extrfbadView = fbadView;
            if (parentView != null) {
                parentView.removeAllViews();
            }
            if (banner_container != null && extrfbadView != null) {
                banner_container.removeAllViews();
                banner_container.addView(extrfbadView);
                parentView = banner_container;
            }
            My_Manage.isFBBannerLoaded = false;
            My_Manage.getInstance(activity).preload_Banner_Fb_Admob();

        } else if (My_Manage.isGoogleBannerLoaded) {
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
                My_Manage.isGoogleBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Fb_Admob();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void show_banner_ad_Fb_Adx(final ViewGroup banner_container) {
        if (My_Manage.isFBBannerLoaded) {
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
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Fb_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (My_Manage.isAdxBannerLoaded) {
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
                My_Manage.isAdxBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Fb_Adx();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void show_banner_ad_Fb_Wortise(final ViewGroup banner_container) {
        if (My_Manage.isFBBannerLoaded) {
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
                My_Manage.isFBBannerLoaded = false;
                My_Manage.getInstance(activity).preload_Banner_Fb_Wortise();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //===================================================== Small Native Banner Ad ====================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob(final ViewGroup native_banner_ad) {
        if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else if (My_Manage.isWortise_small_NativeLoaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.wortise_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isWortise_small_NativeLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx(final ViewGroup native_banner_ad) {
        if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Banner();
        } else if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Banner();
        } else if (My_Manage.isWortise_small_NativeLoaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.wortise_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isWortise_small_NativeLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Banner();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Banner();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    // FB Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_FB(final ViewGroup native_banner_ad) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Native_BannerAd();
        } else if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Native_BannerAd();
        } else if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Native_BannerAd();
        } else if (My_Manage.isWortise_small_NativeLoaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.wortise_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isWortise_small_NativeLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Native_BannerAd();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob_Adx(final ViewGroup native_banner_ad) {
        if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Adx_Native_Banner_Ad();
        } else if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Adx_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob_Fb(final ViewGroup native_banner_ad) {
        if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Fb_Native_Banner_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Fb_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob_Wortise(final ViewGroup native_banner_ad) {
        if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Wortise_Native_Banner_Ad();
        } else if (My_Manage.isWortise_small_NativeLoaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.wortise_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isWortise_small_NativeLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Wortise_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx_Admob(final ViewGroup native_banner_ad) {
        if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Admob_Native_Banner_Ad();
        } else if (My_Manage.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Admob_small_native_banner_Ad.get(0), native_banner_ad);
            My_Manage.isadmob_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Admob_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx_Fb(final ViewGroup native_banner_ad) {
        if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("FootBall", "Adx Native Banner ad show");
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Fb_Native_Banner_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("FootBall", "FB Native Banner ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Fb_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx_Wortise(final ViewGroup native_banner_ad) {
        if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("FootBall", "Adx Native Banner ad show");
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Wortise_Native_Banner_Ad();
        } else if (My_Manage.isWortise_small_NativeLoaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.wortise_native_banner_Ad.get(0), native_banner_ad);
            Log.d("FootBall", "Wortise Native Banner ad show");
            My_Manage.isWortise_small_NativeLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Wortise_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Fb_Admob(final ViewGroup native_banner_ad) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("FootBall", "FB Native Banner ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Admob_Native_Banner_Ad();
        } else if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("FootBall", "Adx Native Banner ad show");
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Admob_Native_Banner_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Fb_Adx(final ViewGroup native_banner_ad) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("FootBall", "FB Native Banner ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Adx_Native_Banner_Ad();
        } else if (My_Manage.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.Adx_small_native_banner_Ad.get(0), native_banner_ad);
            Log.d("FootBall", "Adx Native Banner ad show");
            My_Manage.isadx_small_native_banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Adx_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Fb_Wortise(final ViewGroup native_banner_ad) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(My_Manage.fb_nativeBannerAd.get(0), native_banner_ad);
            Log.d("FootBall", "FB Native Banner ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Wortise_Native_Banner_Ad();
        } else if (My_Manage.isWortise_small_NativeLoaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(My_Manage.wortise_native_banner_Ad.get(0), native_banner_ad);
            Log.d("FootBall", "Wortise Native Banner ad show");
            My_Manage.isWortise_small_NativeLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Wortise_Native_Banner_Ad();
        } else {
            show_nativeBanner_Qureka(native_banner_ad);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }
    }


    //===================================================== Small Native Ad ==============================================================

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob(final ViewGroup small_native) {
        if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else if (My_Manage.isWortise_Native_BannerLoaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.wortise_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Wortise Small Native ad show");
            My_Manage.isWortise_Native_BannerLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Admob_Small_Native_Ad();

        }

    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx(final ViewGroup small_native) {
        if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else if (My_Manage.isWortise_Native_BannerLoaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.wortise_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Wortise Small Native ad show");
            My_Manage.isWortise_Native_BannerLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Adx_Small_Native_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_FB(final ViewGroup small_native) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else if (My_Manage.isWortise_Native_BannerLoaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.wortise_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Wortise Small Native ad show");
            My_Manage.isWortise_Native_BannerLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Fb_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob_Adx(final ViewGroup small_native) {
        if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Adx_Small_Native_Ad();
        } else if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Adx_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Admob_Adx_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob_Fb(final ViewGroup small_native) {
        if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Fb_Small_Native_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Fb_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Admob_Fb_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob_Wortise(final ViewGroup small_native) {
        if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Wortise_Small_Native_Ad();
        } else if (My_Manage.isWortise_Native_BannerLoaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.wortise_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Wortise Small Native ad show");
            My_Manage.isWortise_Native_BannerLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Wortise_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Admob_Wortise_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx_Admob(final ViewGroup small_native) {
        if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Admob_Small_Native_Ad();
        } else if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Admob_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Adx_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx_Fb(final ViewGroup small_native) {
        if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Fb_Small_Native_Ad();
        } else if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Fb_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Adx_Fb_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx_Wortise(final ViewGroup small_native) {
        if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Wortise_Small_Native_Ad();
        } else if (My_Manage.isWortise_Native_BannerLoaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.wortise_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Wortise Small Native ad show");
            My_Manage.isWortise_Native_BannerLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Wortise_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Adx_Wortise_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Fb_Admob(final ViewGroup small_native) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Admob_Small_Native_Ad();
        } else if (My_Manage.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Admob_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Admob Small Native ad show");
            My_Manage.isAdmob_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Admob_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Fb_Admob_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Fb_Adx(final ViewGroup small_native) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Adx_Small_Native_Ad();
        } else if (My_Manage.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.Adx_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Adx Small Native ad show");
            My_Manage.isadx_small_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Adx_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Fb_Adx_Small_Native_Ad();

        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Fb_Wortise(final ViewGroup small_native) {
        if (My_Manage.isFBNative_Banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(My_Manage.fb_nativeBannerAd.get(0), small_native);
            Log.d("FootBall", "FB Small Native ad show");
            My_Manage.isFBNative_Banner_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Wortise_Small_Native_Ad();
        } else if (My_Manage.isWortise_Native_BannerLoaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(My_Manage.wortise_small_native_Ad.get(0), small_native);
            Log.d("FootBall", "Wortise Small Native ad show");
            My_Manage.isWortise_Native_BannerLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Wortise_Small_Native_Ad();
        } else {
            show_nativeBanner_Qureka(small_native);
            My_Manage.getInstance(activity).preload_Fb_Wortise_Small_Native_Ad();

        }
    }


    //====================================================== Native Ad =====================================================================

    @SuppressLint("MissingPermission")
    public void show_native_ad_AAFB(final ViewGroup native_ad) {
        if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Ad();
        } else if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Ad();
        } else if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Ad();
        } else if (My_Manage.isWortiseNativeLoaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.wortise_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Wortise Native ad show");
            My_Manage.isWortiseNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Admob_Native_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_Adx(final ViewGroup native_ad) {
        if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Ad();
        } else if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Ad();
        } else if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Ad();
        } else if (My_Manage.isWortiseNativeLoaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.wortise_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Wortise Native ad show");
            My_Manage.isWortiseNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Adx_Native_Ad();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_FBAA(final ViewGroup native_ad) {
        if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preloadFbNativeAd();
        } else if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preloadFbNativeAd();
        } else if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preloadFbNativeAd();
        } else if (My_Manage.isWortiseNativeLoaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.wortise_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Wortise Native ad show");
            My_Manage.isWortiseNativeLoaded = false;
            My_Manage.getInstance(activity).preloadFbNativeAd();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preloadFbNativeAd();
        }
    }

    public void show_native_ad_Admob_Adx(final ViewGroup native_ad) {
        if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Adx_Native_Ad();
        } else if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Adx_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Admob_Adx_Native_Ad();
        }
    }

    public void show_native_ad_Admob_Fb(final ViewGroup native_ad) {
        if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Fb_Native_Ad();
        } else if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Fb_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Admob_Fb_Native_Ad();
        }
    }

    public void show_native_ad_Admob_Wortise(final ViewGroup native_ad) {
        if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Admob_Wortise_Native_Ad();
        } else if (My_Manage.isWortiseNativeLoaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.wortise_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Wortise Native ad show");
            My_Manage.isWortiseNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Admob_Wortise_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Admob_Wortise_Native_Ad();
        }
    }

    public void show_native_ad_Adx_Admob(final ViewGroup native_ad) {
        if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Admob_Native_Ad();
        } else if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Admob_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Adx_Admob_Native_Ad();
        }
    }

    public void show_native_ad_Adx_Fb(final ViewGroup native_ad) {
        if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Fb_Native_Ad();
        } else if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Fb_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Adx_Fb_Native_Ad();
        }
    }

    public void show_native_ad_Adx_Wortise(final ViewGroup native_ad) {
        if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Adx_Wortise_Native_Ad();
        } else if (My_Manage.isWortiseNativeLoaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.wortise_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Wortise Native ad show");
            My_Manage.isWortiseNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Adx_Wortise_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Adx_Wortise_Native_Ad();
        }
    }

    public void show_native_ad_Fb_Admob(final ViewGroup native_ad) {
        if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Admob_Native_Ad();
        } else if (My_Manage.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Admob_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Admob Native ad show");
            My_Manage.isadmob_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Admob_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Fb_Admob_Native_Ad();
        }
    }

    public void show_native_ad_Fb_Adx(final ViewGroup native_ad) {
        if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Adx_Native_Ad();
        } else if (My_Manage.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.Adx_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Adx Native ad show");
            My_Manage.isadx_native_Loaded = false;
            My_Manage.getInstance(activity).preload_Fb_Adx_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Fb_Adx_Native_Ad();
        }
    }

    public void show_native_ad_Fb_Wortise(final ViewGroup native_ad) {
        if (My_Manage.isFBNativeLoaded) {
            new NativeAds(activity).FB_Native(My_Manage.fbnativeAd.get(0), native_ad);
            Log.d("FootBall", "FB Native ad show");
            My_Manage.isFBNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Wortise_Native_Ad();
        } else if (My_Manage.isWortiseNativeLoaded) {
            new NativeAds(activity).Admob_NativeAd(My_Manage.wortise_native_Ad.get(0), native_ad);
            Log.d("FootBall", "Wortise Native ad show");
            My_Manage.isWortiseNativeLoaded = false;
            My_Manage.getInstance(activity).preload_Fb_Wortise_Native_Ad();
        } else {
            show_native_Qureka(native_ad);
            My_Manage.getInstance(activity).preload_Fb_Wortise_Native_Ad();
        }
    }

    // MREC Banner
    public void show_MREC_Banner(final ViewGroup mrec_banner_ad) {
        if (My_Manage.isAdmob_Mediam_Ragtangal_Loaded) {
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
                Log.d("FootBall", "show admob Mediam Ragtangal ad");
                My_Manage.isAdmob_Mediam_Ragtangal_Loaded = false;
                My_Manage.getInstance(activity).Merc_Banner_Ad();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (My_Manage.isAdx_Mediam_Ragtangal_Loaded) {
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
                Log.d("FootBall", "show adx Mediam Ragtangal ad");
                My_Manage.isAdx_Mediam_Ragtangal_Loaded = false;
                My_Manage.getInstance(activity).Merc_Banner_Ad();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else if (My_Manage.isFB_Mediam_Ragtangal_Loaded) {
            extrafb_Ragtangal_adView = fb_Ragtangal_adView;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (mrec_banner_ad != null && extrafb_Ragtangal_adView != null) {
                    mrec_banner_ad.removeAllViews();
                    mrec_banner_ad.addView(extrafb_Ragtangal_adView);
                    mrec_parentView = mrec_banner_ad;
                    Log.d("FootBall", "show Fb Mediam Ragtangal ad");
                }
                My_Manage.isFB_Mediam_Ragtangal_Loaded = false;
                My_Manage.getInstance(activity).Merc_Banner_Ad();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            show_native_Qureka(mrec_banner_ad);
            My_Manage.getInstance(activity).Merc_Banner_Ad();

        }
    }

    public void show_native_Local(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.matchalldetail_local_native_ad, (ViewGroup) null);
        RelativeLayout rlbackground = viewGroup2.findViewById(R.id.background);
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.ad_headline);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.ad_app_icon);
        ImageView adbanner = (ImageView) viewGroup2.findViewById(R.id.ad_banner);
        try {
            if (arrAdDataStart != null && arrAdDataStart.size() > 0) {
                textView2.setText(arrAdDataStart.get(0).getAppName());
                Glide.with(activity).load(arrAdDataStart.get(0).getAppIcon()).into(imageView);
                Glide.with(activity).load(arrAdDataStart.get(0).getApp_banner()).into(adbanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Manage.getInstance(activity).onLocalIntent();
            }
        });
        viewGroup.addView(viewGroup2);
    }

    public void show_nativeBanner_Local(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.matchalldetail_local_small_native_ad, (ViewGroup) null);
        RelativeLayout rlbackground = viewGroup2.findViewById(R.id.background);
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.ad_headline);
        ImageView imageView = (ImageView) viewGroup2.findViewById(R.id.ad_app_icon);
        try {
            if (arrAdDataStart != null && arrAdDataStart.size() > 0) {
                textView2.setText(arrAdDataStart.get(0).getAppName());
//                Picasso.get().load(arrAdDataStart.get(0).getAppIcon()).into(imageView);
                Glide.with(activity).load(arrAdDataStart.get(0).getAppIcon()).into(imageView);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Manage.getInstance(activity).onLocalIntent();
            }
        });
        viewGroup.addView(viewGroup2);
    }


    public void show_native_Qureka(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.matchalldetail_qureka_native_ad, (ViewGroup) null);
        RelativeLayout rlbackground = viewGroup2.findViewById(R.id.background);
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (convertedObject.getQurekaUrl() != null) {
                    qureka_LoadCustom.myCustom((Activity) activity, convertedObject.getQurekaUrl());
                }
            }
        });
        viewGroup.addView(viewGroup2);
    }

    public void show_nativeBanner_Qureka(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.matchalldetail_qureka_small_native_ad, (ViewGroup) null);
        RelativeLayout rlbackground = viewGroup2.findViewById(R.id.background);
        rlbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (convertedObject.getQurekaUrl() != null) {
                    qureka_LoadCustom.myCustom((Activity) activity, convertedObject.getQurekaUrl());
                }

            }
        });
        viewGroup.addView(viewGroup2);
    }

}