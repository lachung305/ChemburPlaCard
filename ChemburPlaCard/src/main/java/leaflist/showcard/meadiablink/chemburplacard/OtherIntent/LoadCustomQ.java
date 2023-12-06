package leaflist.showcard.meadiablink.chemburplacard.OtherIntent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;

import androidx.browser.customtabs.CustomTabsIntent;

import leaflist.showcard.meadiablink.chemburplacard.R;

public class LoadCustomQ {
    public static void myCustom(Context activity, String str) {
        if (str.isEmpty()) {
            str = "";
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            Bundle bundle = new Bundle();
            bundle.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            intent.putExtras(bundle);
            intent.putExtra(CustomTabsIntent.EXTRA_TOOLBAR_COLOR, activity.getResources().getColor(R.color.appcolor));
            intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_INSTANT_APPS, true);
            intent.setPackage("com.android.chrome");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
