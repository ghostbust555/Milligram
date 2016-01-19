package com.milligram.milligram;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;

import static com.google.android.gms.location.LocationServices.*;

public class SearchingActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searching);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    public void searchSelected(View v) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void viewSavedVouchers(View v){
        Intent intent = new Intent(this, SavedVouchersActivity.class);
        startActivity(intent);
    }

    public void locationSelected(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //TODO: Add dialog for lack of permissions
            return;
        }

        LocationManager mLocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        android.location.LocationListener mLocListener = new android.location.LocationListener() {

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.v("LocationListener", "onStatusChanged");
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.v("LocationListener", "onProviderEnabled");
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.v("LocationListener", "onProviderDisabled");
            }

            @Override
            public void onLocationChanged(Location loc) {
                Log.v("LocationListener", "onLocationChanged");
                Geocoder geocoder = new Geocoder(SearchingActivity.this);
                try {
                    List<Address> addressList = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
                    String zip = addressList.get(0).getPostalCode();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        mLocManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, mLocListener, Looper.myLooper());
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_searching, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
