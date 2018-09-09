// ICaptureAnalytics.aidl
package com.gm.analytics;

// Declare any non-default types here with import statements

interface IAnalyticsInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
String event(in Bundle event,in Bundle[] option);
}
