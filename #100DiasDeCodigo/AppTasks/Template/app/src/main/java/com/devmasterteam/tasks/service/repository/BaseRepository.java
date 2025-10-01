package com.devmasterteam.tasks.service.repository;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import com.devmasterteam.tasks.R;
import com.google.gson.Gson;

import okhttp3.ResponseBody;

public class BaseRepository {

    Context context;

    public BaseRepository(Context context) {
        this.context = context;
    }

    public String handleFailure(ResponseBody response) {
        try {
            return new Gson().fromJson(response.string(), String.class);
        } catch (Exception e) {
            return context.getString(R.string.error_unexpected);
        }
    }

    boolean isConnectionAvailable() {
        boolean result = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) this.context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Network networkCapabilities = connectivityManager.getActiveNetwork();
                if (networkCapabilities == null) {
                    return false;
                }

                NetworkCapabilities activeNow = connectivityManager.getNetworkCapabilities(networkCapabilities);
                if (activeNow == null) {
                    return false;
                }

                result = (activeNow.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || activeNow.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));

            } else {
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if (networkInfo != null) {
                    int type = networkInfo.getType();
                    result = ((type == ConnectivityManager.TYPE_WIFI)
                            || (type == ConnectivityManager.TYPE_MOBILE)
                            || (type == ConnectivityManager.TYPE_ETHERNET));
                }
            }
        }
        return result;
    }
}
