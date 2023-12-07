package leaflist.showcard.meadiablink.chemburplacard;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import leaflist.showcard.meadiablink.chemburplacard.Chemburmodel.AppDataResponse;

public class AppData_Utils {

    public static String PREFS_NAME = "shared_prefrence";

    public static void saveStringtoPrefrence(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static AppDataResponse getResponse(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String s = sharedpreferences.getString("appdatacard", "");
        return new Gson().fromJson(s, AppDataResponse.class);
    }

}
