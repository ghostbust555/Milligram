package com.milligram.milligram;

import android.app.Service;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import android.location.LocationListener;

/**
 * Created by ghost on 1/17/2016.
 */
public class LocationHelper {

    public static Location getLocation(Context context) {



        LocationManager locationManager = (LocationManager)context.getSystemService(Service.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String provider = locationManager.getBestProvider(criteria, true);

        Log.v("Provider", provider);

        // FIXME: Something crashes the emulator when a GPS fix is sent through DDMS
       // locationManager.requestSingleUpdate(provider, locationListener, Looper.myLooper());
        return locationManager.getLastKnownLocation(provider);
    }
}