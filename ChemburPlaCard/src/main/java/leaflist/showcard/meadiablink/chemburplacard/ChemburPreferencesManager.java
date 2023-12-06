package leaflist.showcard.meadiablink.chemburplacard;

import android.content.Context;
import android.content.SharedPreferences;

public class ChemburPreferencesManager {
    private SharedPreferences sharedPrefs;
    private static final String APP_PREFS = "adcount";
    private static final String APP_PREFS1 = "adcountbackpress";
    private static final String APP_PREFS2 = "qurekaadcounter";
    private static ChemburPreferencesManager instance;

    private ChemburPreferencesManager(Context context) {
        sharedPrefs = context.getApplicationContext().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        sharedPrefs = context.getApplicationContext().getSharedPreferences(APP_PREFS1, Context.MODE_PRIVATE);
    }

    public static synchronized ChemburPreferencesManager getInstance(Context context) {
        if (instance == null)
            instance = new ChemburPreferencesManager(context);

        return instance;
    }

    public void storeClicks(int count) {

        SharedPreferences.Editor meditor = sharedPrefs.edit();
        meditor.putInt(APP_PREFS, count);
        meditor.apply();
    }

    public void backpressstoreClicks(int count) {

        SharedPreferences.Editor meditor = sharedPrefs.edit();
        meditor.putInt(APP_PREFS1, count);
        meditor.apply();
    }

    public void qurekaadcounterstoreclick(int count){
        SharedPreferences.Editor meditor = sharedPrefs.edit();
        meditor.putInt(APP_PREFS2, count);
        meditor.apply();
    }

    public int getNumberOfClicks() {
        int clicksNumber = sharedPrefs.getInt(APP_PREFS, 1);
        return clicksNumber;
    }

    public int getbackpressNumberOfClicks() {
        int backpressclicksNumber = sharedPrefs.getInt(APP_PREFS1, 1);
        return backpressclicksNumber;
    }

    public int getqurekaadcounter() {
        int qurekaadcounter = sharedPrefs.getInt(APP_PREFS2, 1);
        return qurekaadcounter;
    }
}
