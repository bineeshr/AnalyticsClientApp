package com.gm.android.vehicle.papiconfigrequest;

import android.os.Build;
import android.os.SystemClock;

import com.gm.android.vehicle.papiconfigrequest.emulated.EmulatedVinUtil;
import com.gm.android.vehicle.papiconfigrequest.payload.ConfigResponse;
import com.gm.android.vehicle.papiconfigrequest.util.HardwareUtil;

public class RetrieveAnalyticsConfguration {

    private static final boolean DEFAULT_ANALYTICS_ENABLED = false;
    private static final String DEFAULT_ITEMS_TO_SYNC = "50";
    private static final String DEFAULT_TIME_TO_SYNC= "300";
    private static final String DEFAULT_FIRST_TIME_TO_SYNC = "60";
    private static final String DEFAULT_ANALYTICS_URL = "BACK-OFFICE ENDPOINT";
    private static final String DEFAULT_MAX_RETRIES = "1";
    private static final String DEFAULT_TIME_TO_RETRY = "30";
    private static final String DEFAULT_MAX_QUERIES = "2";
    private static final String DEFAULT_VIN_PART = "VINVINVIN";
    private static final String DEFAULT_GUID = "null";
    private static final String DEFAULT_VIN = EmulatedVinUtil.getVin();
    private static final String DEFAULT_SID = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());

    public static ConfigResponse mConfigResponse;

    public RetrieveAnalyticsConfguration(ConfigResponse configResponse){
        mConfigResponse = configResponse;
    }

    public static void setConfigurationValues(ConfigResponse response){
        if(HardwareUtil.isVehicle() && response != null){
            mConfigResponse.setAnalyticsEnabled(response.analyticsEnabled);
            mConfigResponse.setItemsToSync(response.itemsToSync);
            mConfigResponse.setTimeToSync(response.timeToSync);
            mConfigResponse.setFirstTimeToSync(response.firstTimeToSync);
            mConfigResponse.setAnalyticsURL(response.analyticsURL);
        }else{
            mConfigResponse.setAnalyticsEnabled(DEFAULT_ANALYTICS_ENABLED);
            mConfigResponse.setItemsToSync(DEFAULT_ITEMS_TO_SYNC);
            mConfigResponse.setTimeToSync(DEFAULT_TIME_TO_SYNC); // 300 seconds
            mConfigResponse.setFirstTimeToSync(DEFAULT_FIRST_TIME_TO_SYNC); //60 seconds
            mConfigResponse.setAnalyticsURL(DEFAULT_ANALYTICS_URL);
        }
        mConfigResponse.setMaxRetries(DEFAULT_MAX_RETRIES);
        mConfigResponse.setTimeToRetry(DEFAULT_TIME_TO_RETRY);
        mConfigResponse.setMaxQueues(DEFAULT_MAX_QUERIES);
        mConfigResponse.setVinPart(DEFAULT_VIN_PART);
        mConfigResponse.setGuid(DEFAULT_GUID);
        mConfigResponse.setVin(DEFAULT_VIN);
        mConfigResponse.setSid(DEFAULT_SID);
    }
}
