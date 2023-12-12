package livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

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

import leaflist.showcard.meadiablink.chemburplacard.AppData_Utils;
import leaflist.showcard.meadiablink.chemburplacard.ChemburPreferencesManager;
import leaflist.showcard.meadiablink.chemburplacard.Chembur_Showcard;
import leaflist.showcard.meadiablink.chemburplacard.Constnt;
import livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia.retrofit.APIClient;
import livesportstv.mtchscor.tvshowlive.meadiolive.chemburmedia.retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = this;
        ChemburPreferencesManager.getInstance(activity).backpressstoreClicks(1);
        ChemburPreferencesManager.getInstance(activity).storeClicks(1);
        ChemburPreferencesManager.getInstance(activity).qurekaadcounterstoreclick(1);
        App_Data();

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

    public static ArrayList<AppDataItem> app_data = new ArrayList<>();

    public void App_Data() {
        try {
            RetrofitInterface apiInterface = APIClient.getClient().create(RetrofitInterface.class);
            Call<AdListResponse> call1 = apiInterface.getadsdetail(activity.getPackageName(), "adservice/get_TEST.php");
            call1.enqueue(new Callback<AdListResponse>() {
                @Override
                public void onResponse(@NotNull Call<AdListResponse> call, @NotNull Response<AdListResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        if (response.body().getData() != null) {
                            app_data.clear();
                            List<AppDataItem> appDataItemList = new ArrayList<>();
                            if (response.body().getData() != null && !response.body().getData().isEmpty()) {
                                try {
                                    String decryptedtext1 = decrypt(response.body().data);
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<List<AppDataItem>>() {
                                    }.getType();
                                    appDataItemList = gson.fromJson(decryptedtext1, type);
                                    if (appDataItemList != null && appDataItemList.size() > 0) {

                                        AppDataItem item = appDataItemList.get(0);
                                        String favData = gson.toJson(item);
                                        AppData_Utils.saveStringtoPrefrence(activity, Constnt.appdatacard, favData);
                                        app_data.addAll(appDataItemList);
                                        String ridirect_app = app_data.get(0).getRedirectApp();
                                        if (!ridirect_app.equalsIgnoreCase("")) {
                                            activity.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://play.google.com/store/apps/details?id=" + ridirect_app)));
                                        } else {
                                            Chembur_Showcard.getInstance(MainActivity.this).setCarddata(MainActivity.this);
                                            Chembur_Showcard.getInstance(MainActivity.this).setAppDetail(MainActivity.this, getResources().getString(R.string.app_name), R.mipmap.ic_launcher);
                                            Chembur_Showcard.getInstance(MainActivity.this).card_preload(new Chembur_Showcard.AppDataback() {
                                                @Override
                                                public void OnCall() {
                                                    With_out();
                                                }
                                            });
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

    public void With_out() {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).getAdSplash().equalsIgnoreCase("inter")) {
                Chembur_Showcard.getInstance(activity).show_splash_inter(() -> within());
            } else {
                Chembur_Showcard.getInstance(activity).show_splash(() -> within());
            }
        }
    }

    public void within() {
        startActivity(new Intent(activity, MainActivity2.class));
        finish();
    }


}