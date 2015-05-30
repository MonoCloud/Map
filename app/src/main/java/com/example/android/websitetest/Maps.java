package com.example.android.websitetest;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    // both lines are for the location
    private GoogleApiClient mGoogleApiClient;
    public static final String TAG = Maps.class.getSimpleName(); // change Maps to class name
    private LocationRequest mLocationRequest;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds

    }



    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClient.connect();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }
    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        // Koordinanten der Mensen
        LatLng MENSASÜD = new LatLng(54.075947, 12.104843);
        LatLng CAFE_EINSTEIN = new LatLng(54.078608, 12.115070);
        LatLng GEORG_MENSA = new LatLng(54.081630, 12.138114);
        LatLng ULME69 = new LatLng(54.086475, 12.109485);
        LatLng KLEINEULME = new LatLng(54.087361, 12.109008);


        // Koordinaten der Fakultäten
        LatLng PHILOSOHPISCH = new LatLng(54.085119, 12.136004);
        LatLng WIRTSCHAFT = new LatLng(54.086510, 12.109573);
        LatLng MEDIZIN = new LatLng(54.085487, 12.102693);

        LatLng MASCHINENBAU = new LatLng(54.077851, 12.114558);
        LatLng MATHE = new LatLng(54.087407, 12.121695);
        LatLng INFO = new LatLng(54.077851, 12.114558);
        LatLng AGRAR = new LatLng(54.075770, 12.099319);




// implementation of Fakultät markers
        mMap.addMarker(new MarkerOptions()
                .position(PHILOSOHPISCH)
                .title("Fakultät")
                .snippet("Philosophische Fakultät"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));

        mMap.addMarker(new MarkerOptions()
                .position(WIRTSCHAFT)
                .title("Fakultät")
                .snippet("Philosophische Fakultät"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));

        mMap.addMarker(new MarkerOptions()
                .position(MEDIZIN)
                .title("Fakultät")
                .snippet("Medizinische Fakultät"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));


        mMap.addMarker(new MarkerOptions()
                .position(MASCHINENBAU)
                .title("Fakultät")
                .snippet("Maschinenbau"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));

        mMap.addMarker(new MarkerOptions()
                .position(MATHE)
                .title("Fakultät")
                .snippet("Mathematische Fakultät"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));

        mMap.addMarker(new MarkerOptions()
                .position(INFO)
                .title("Fakultät")
                .snippet("Informatik und Elektrotechnik"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));

        mMap.addMarker(new MarkerOptions()
                .position(AGRAR)
                .title("Fakultät")
                .snippet("Agrar - Umweltwissenschaft Fakultät"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED));






        // implementation of mensa markers
        mMap.addMarker(new MarkerOptions()
                .position(MENSASÜD)
                .title("Mensa")
                .snippet("Mensa Süd"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        mMap.addMarker(new MarkerOptions()
                .position(CAFE_EINSTEIN)
                .title("Mensa")
                .snippet("Cafeteria Einstein"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        mMap.addMarker(new MarkerOptions()
                .position(GEORG_MENSA)
                .title("Mensa")
                .snippet("St. Georg Mensa"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        mMap.addMarker(new MarkerOptions()
                .position(KLEINEULME)
                .title("Mensa")
                .snippet("Kleine Mensa Ulme"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        mMap.addMarker(new MarkerOptions()
                .position(ULME69)
                .title("Mensa")
                .snippet("Ulme 69"))
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));






    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location services connected.");
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, (LocationListener) this);
        }
        else {
            handleNewLocation(location);
        }


    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("Aktuelle Position");

        mMap.addMarker(options)
                .setIcon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_AZURE));


        float zoomLevel = (float) 16.0; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
    }


}
