package com.davidhousman.rainmaker;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);



        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                double myLatitude = location.getLatitude();
                double myLongitude = location.getLongitude();

                String myLatString = String.valueOf(myLatitude);
                String myLongString = String.valueOf(myLongitude);

                Log.i("Latitude", myLatString);
                Log.i("Longitude", myLongString);

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };





        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
