package com.devmasterteam.tasks.service.helper;

import android.content.Context;
import android.os.Build;

import androidx.biometric.BiometricManager;

public class FingerPrintHelper {

    public boolean isAvailable(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return false;
        }

        String s = "";

        BiometricManager biometricManager = BiometricManager.from(context);
        switch (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                s = "";
                break;
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                s = "";
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                s = "";
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                s = "";
                break;
        }
        return false;
    }
}
