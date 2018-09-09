package com.gm.android.vehicle.papiconfigrequest.util;

import android.os.Build;

public class HardwareUtil {

    private static final String HARMAN = "harman";
    private static final String GM = "gm";

    public static boolean isVehicle() {
        return HARMAN.equalsIgnoreCase(Build.MANUFACTURER)
                || GM.equalsIgnoreCase(Build.MANUFACTURER);
    }
}
