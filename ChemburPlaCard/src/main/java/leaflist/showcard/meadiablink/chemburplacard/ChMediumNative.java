package leaflist.showcard.meadiablink.chemburplacard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeBannerAd;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

import java.util.ArrayList;
import java.util.List;

public class ChMediumNative {

    public Context activity;
    public ChMediumNative(Context context) {
        this.activity = context;
    }

    // Google Native Ads
    public void Admob_NativeAd(final NativeAd nativeAd, ViewGroup native_ADmobAds_Layout) {
        NativeAdView adView = (NativeAdView) LayoutInflater.from(activity).inflate(R.layout.admob_native, null);
        native_ADmobAds_Layout.removeAllViews();
        native_ADmobAds_Layout.addView(adView);
        Native_Ad(nativeAd, adView);

    }

    @SuppressLint("WrongConstant")
    private void Native_Ad(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView((TextView) adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(4);
        } else {
            adView.getBodyView().setVisibility(0);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(4);
        } else {
            adView.getCallToActionView().setVisibility(0);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(8);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(0);
        }
        adView.setNativeAd(nativeAd);
    }

    // Google small Native Ads
    public void Admob_Small_Native_Ad(final NativeAd nativeAd, ViewGroup native_ADmobAds_Layout) {
        NativeAdView adView = (NativeAdView) LayoutInflater.from(activity).inflate(R.layout.admob_native_banner, null);
        native_ADmobAds_Layout.removeAllViews();
        native_ADmobAds_Layout.addView(adView);
        Small_Native_Ad(nativeAd, adView);
    }

    @SuppressLint("WrongConstant")
    private void Small_Native_Ad(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_app_icon));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView((TextView) adView.findViewById(R.id.ad_call_to_action));

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(4);
        } else {
            adView.getBodyView().setVisibility(0);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(4);
        } else {
            adView.getCallToActionView().setVisibility(0);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        adView.setNativeAd(nativeAd);
    }

    // Google Small Native Banner Ad
    public void Admob_Small_Native_Banner_Ad(final NativeAd nativeAd, ViewGroup native_ADmobAds_Layout) {
        NativeAdView adView = (NativeAdView) LayoutInflater.from(activity).inflate(R.layout.admob_samall_native, null);
        native_ADmobAds_Layout.removeAllViews();
        native_ADmobAds_Layout.addView(adView);
        Small_Native_Banner_Ads(nativeAd, adView);
    }

    @SuppressLint("WrongConstant")
    private void Small_Native_Banner_Ads(NativeAd nativeAd, NativeAdView adView) {
        adView.setVisibility(View.VISIBLE);
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(4);
        } else {
            adView.getBodyView().setVisibility(0);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(4);
        } else {
            adView.getCallToActionView().setVisibility(0);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(8);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(0);
        }
        adView.setNativeAd(nativeAd);
    }

    // FB Native Ads
    public void FB_Native(final com.facebook.ads.NativeAd nativeAd, ViewGroup native_fb_Layout) {
        NativeAdLayout adView = (NativeAdLayout) LayoutInflater.from(activity).inflate(R.layout.fb_native, null);
        native_fb_Layout.removeAllViews();
        native_fb_Layout.addView(adView);
        Fb_Native_inflateAd(nativeAd, adView);
    }

    private void Fb_Native_inflateAd(com.facebook.ads.NativeAd nativeAd, NativeAdLayout nativeAdLayout) {
        nativeAd.unregisterView();
        // Add the AdOptionsView
        LinearLayout adChoicesContainer = nativeAdLayout.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        com.facebook.ads.MediaView nativeAdMedia = nativeAdLayout.findViewById(R.id.native_ad_media);
        ImageView nativeAdIcon = nativeAdLayout.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = nativeAdLayout.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = nativeAdLayout.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = nativeAdLayout.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = nativeAdLayout.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = nativeAdLayout.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(nativeAdLayout, nativeAdMedia, nativeAdIcon, clickableViews);
    }

    // FB Native Banner Ads
    public void FB_Smalle_Native(final NativeBannerAd nativeBannerAd, ViewGroup fb_native_banner_Layout) {
        NativeAdLayout adView = (NativeAdLayout) LayoutInflater.from(activity).inflate(R.layout.fb_samall_native, null);
        fb_native_banner_Layout.removeAllViews();
        fb_native_banner_Layout.addView(adView);
        inflateAd(nativeBannerAd, adView);
    }

    private void inflateAd(NativeBannerAd nativeBannerAd, NativeAdLayout nativeAdLayout) {
        // Unregister last ad
        nativeBannerAd.unregisterView();
        LinearLayout adChoicesContainer = nativeAdLayout.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeBannerAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        com.facebook.ads.MediaView nativeAdIcon = nativeAdLayout.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = nativeAdLayout.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = nativeAdLayout.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = nativeAdLayout.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = nativeAdLayout.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = nativeAdLayout.findViewById(R.id.native_ad_call_to_action);

        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdBody.setText(nativeBannerAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        // Register the Title and CTA button to listen for clicks.
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, nativeAdIcon, clickableViews);
    }

    // FB Small Native Banner Ads
    public void FB_Smalle_Native_Banner(final NativeBannerAd nativeBannerAd, ViewGroup fb_native_banner_Layout) {
        NativeAdLayout adView = (NativeAdLayout) LayoutInflater.from(activity).inflate(R.layout.fb_samall_native_banner, null);
        fb_native_banner_Layout.removeAllViews();
        fb_native_banner_Layout.addView(adView);
        Fb_Samll_Native_banner_inflateAd(nativeBannerAd, adView);
    }

    private void Fb_Samll_Native_banner_inflateAd(NativeBannerAd nativeBannerAd, NativeAdLayout nativeAdLayout) {
        // Unregister last ad
        nativeBannerAd.unregisterView();
        LinearLayout adChoicesContainer = nativeAdLayout.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeBannerAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        ImageView nativeAdIcon = nativeAdLayout.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = nativeAdLayout.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = nativeAdLayout.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = nativeAdLayout.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = nativeAdLayout.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = nativeAdLayout.findViewById(R.id.native_ad_call_to_action);

        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdBody.setText(nativeBannerAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        // Register the Title and CTA button to listen for clicks.
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, nativeAdIcon, clickableViews);
    }
}