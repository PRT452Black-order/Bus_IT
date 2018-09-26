package com.example.cdu_nb.bus_it;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;


import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Color;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


//import cdu.xeon.data.bean.Driver;
//import cdu.xeon.data.mapmodules.Route;
//import cdu.xeon.data.mapmodules.DirectionFinder;
//import cdu.xeon.data.mapmodules.DirectionFinderListener;
//
//import java.util.List;
//import cdu.xeon.data.bean.Skip;
//import cdu.xeon.data.repository.Repository;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapPageActivity extends AppCompatActivity implements OnMapReadyCallback{

    // initialisation of the variables
//    private Driver driver;
    private MapView mapView;
    private static final String TAG = "MapActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 15f;
    private static final int LOCATION_REQUEST = 500;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    //variables for checking for permission
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    private Marker mMarker;
    Marker marker1,marker2,marker3,marker4,marker5,marker6;

    ArrayList<LatLng> listPoints;
    private  double lat = 0.0;
    private double lng = 0.0;

    private LatLng landfillpos1;
    public static MapPageActivity instance =null;
    //     on creating the application
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
//        driver=Repository.getDriverDetails(this,1);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

//        Bundle bundle = getIntent().getBundleExtra("location");
//        if(bundle == null){
//
//            lat = Repository.getLandfill(this).get(0).getLatitude();
//            lng = Repository.getLandfill(this).get(0).getLongitude();
//        }else{
//            lat = bundle.getDouble("lan");
//            lng = bundle.getDouble("lon");
//        }
//
//        findViewById(R.id.empBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                driver=Repository.getDriverDetails(getApplicationContext(),1);
//                String stau= Repository.emptySkip(getApplicationContext(),driver.getId(),1);
//                driver=Repository.getDriverDetails(getApplicationContext(),1);
//                if (driver.getLoaded()==0){
//                    Toast.makeText(getApplicationContext(), "Skip empty successfully!", Toast.LENGTH_LONG).show();
//                }else if (driver.getLoaded()==1){
//                    Toast.makeText(getApplicationContext(), "Skip empty failed!", Toast.LENGTH_LONG).show();
//                }
//
//
//            }
//        });


//        findViewById(R.id.navButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String startLat=""+lat;
//                String startlng=""+lng;
//                String desLat=""+landfillpos1.latitude;
//                String desLng=""+landfillpos1.longitude;
//
//
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse("http://maps.google.com/maps?saddr="+startLat+","+startlng+"&daddr="+desLat+","+desLng));
//                startActivity(intent);
//
//
//
//            }
//        });



        listPoints = new ArrayList<>();

        // Construct a FusedLocationProviderClient.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        getLocationPermission();
        updateLocationUI();

        mapView=findViewById(R.id.mapView1);
        mapView.setBackgroundColor(0000);
    }

    //    preparing the map
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        GoogleMapOptions options = new GoogleMapOptions();
//
        options.mapType(GoogleMap.MAP_TYPE_SATELLITE)
                .compassEnabled(false)
                .rotateGesturesEnabled(false)
                .tiltGesturesEnabled(false);


        if (mLocationPermissionsGranted) {
            getDeviceLocation();
//            getGeolocation();
//
//            // skip 6
//            String skip6N = Repository.getSkip(this).get(5).getName();
//            double lat6 = Repository.getSkip(this).get(5).getLatitude();
//            double lng6 = Repository.getSkip(this).get(5).getLongitude();
//            LatLng skip6L = new LatLng(lat6, lng6);
//
//            marker6= mMap.addMarker(new MarkerOptions().position(skip6L)
//                    .title(skip6N)
//                    .snippet("click for more details"));
//            if (Repository.getSkip(this).get(5).getFull()==0){
//                marker6.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
//            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip6L));
//
//
//            //skip 5
//            String skip5N = Repository.getSkip(this).get(4).getName();
//            double lat5 = Repository.getSkip(this).get(4).getLatitude();
//            double lng5 = Repository.getSkip(this).get(4).getLongitude();
//            LatLng skip5L = new LatLng(lat5, lng5);
//
//            marker5= mMap.addMarker(new MarkerOptions().position(skip5L)
//                    .title(skip5N)
//                    .snippet("click for more details"));
//            if (Repository.getSkip(this).get(4).getFull()==0){
//                marker5.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
//            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip5L));
//
//            //skip 4
//            String skip4N = Repository.getSkip(this).get(3).getName();
//            double lat4 = Repository.getSkip(this).get(3).getLatitude();
//            double lng4 = Repository.getSkip(this).get(3).getLongitude();
//            LatLng skip4L = new LatLng(lat4, lng4);
//
//            marker4= mMap.addMarker(new MarkerOptions().position(skip4L)
//                    .title(skip4N)
//                    .snippet("click for more details"));
//            if (Repository.getSkip(this).get(0).getFull()==0){
//                marker4.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
//            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip4L));
//
//
//            //skip 3
//            String skip3N = Repository.getSkip(this).get(2).getName();
//            double lat3 = Repository.getSkip(this).get(2).getLatitude();
//            double lng3 = Repository.getSkip(this).get(2).getLongitude();
//            LatLng skip3L = new LatLng(lat3, lng3);
//
//            marker3= mMap.addMarker(new MarkerOptions().position(skip3L)
//                    .title(skip3N)
//                    .snippet("click for more details"));
//            if (Repository.getSkip(this).get(2).getFull()==0){
//                marker3.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
//            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip3L));
//
//            //skip 2
//            String skip2N = Repository.getSkip(this).get(1).getName();
//            double lat2 = Repository.getSkip(this).get(1).getLatitude();
//            double lng2 = Repository.getSkip(this).get(1).getLongitude();
//            LatLng skip2L = new LatLng(lat2, lng2);
//
//            marker2= mMap.addMarker(new MarkerOptions().position(skip2L)
//                    .title(skip2N)
//                    .snippet("click for more details"));
//            if (Repository.getSkip(this).get(1).getFull()==0){
//                marker2.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
//            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2L));


//            mMap.addMarker(new MarkerOptions().position(skip2L)
//                    .title(skip2N))
//                    .snippet("click for more details"));
////                    .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2L));

            //skip 1
//            String skip1N = Repository.getSkip(this).get(0).getName();
//            double lat1 = Repository.getSkip(this).get(0).getLatitude();
//            double lng1 = Repository.getSkip(this).get(0).getLongitude();
//            LatLng skip1L = new LatLng(lat1, lng1);
//            marker1= mMap.addMarker(new MarkerOptions().position(skip1L)
//                    .title(skip1N));
//            if (Repository.getSkip(this).get(0).getFull()==0){
//                marker1.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.end_green));
            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip1L));

//            LatLng skip2 = new LatLng(-12.366347, 130.877126);
//            mMap.addMarker(new MarkerOptions().position(skip2)
//                    .title("Skip 2"));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip2));

//            String skiptitle = "click For more skip details";
//            String skipID = "ID: 12587";

//            String title = "This is Title";
//            String subTitle = "This is \nSubtitle";
            //Marker
//            MarkerOptions markerOpt = new MarkerOptions();
//            markerOpt.position(new LatLng(-12.366347, 130.877126))
//                    .title(title)
//                    .snippet(subTitle)
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.start_blue));
//
//            //Set Custom InfoWindow Adapter
//            CustomInfoWindowAdapter adapter = new CustomInfoWindowAdapter(MapPageActivity.this);
//            mMap.setInfoWindowAdapter(adapter);
//            mMap.addMarker(markerOpt).showInfoWindow();


            //landfill
//            String landfill  = Repository.getLandfill(this).get(0).getName();
//            double latland = Repository.getLandfill(this).get(0).getLatitude();
//            double lngland = Repository.getLandfill(this).get(0).getLongitude();
//            LatLng lndfillpos = new LatLng(latland, lngland);
//            landfillpos1=lndfillpos;
//            mMap.addMarker(new MarkerOptions().position(lndfillpos)
//                    .title(landfill)
//                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.landfill)));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(lndfillpos));

//            LatLng skipRoute = new LatLng(lat, lng);

            //Save first point select
            // listPoints.add(skipRoute);
//                    //Create marker
//                    MarkerOptions markerOptions = new MarkerOptions();
//                    markerOptions.position(latLng);
//
//                    if (listPoints.size() == 1) {
//                        //Add first marker to the map
//                        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
//                    } else {
//                        //Add second marker to the map
//                        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//                    }
//                    mMap.addMarker(markerOptions);
            // if (listPoints.size() == 2) {
            //Create the URL to get request from first marker to second marker
//            String url = getRequestUrl(landfillpos1, skipRoute);
//            cdu.xeon.smartskips.MapPageActivity.TaskRequestDirections taskRequestDirections = new cdu.xeon.smartskips.MapPageActivity.TaskRequestDirections();
//            taskRequestDirections.execute(url);





//            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
////                @Override
////                public void onInfoWindowClick(Marker marker) {
////                    Intent intent1 = new Intent(MapPageActivity.this, SkipDetails.class);
////                    String title = marker.getTitle();
////                    intent1.putExtra("markertitle", title);
////                    Bundle bundle=new Bundle();
////                    bundle.putString("ID",marker.getTitle());
////                    intent1.putExtra("bundle",bundle);
////                    startActivity(intent1);
////                    // mMap.clear();
////                }
////            });


//            mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
//                @Override
//                public void onMapLongClick(LatLng latLng) {
            //Reset marker when already 2
//                    if (listPoints.size() == 2) {
//                        listPoints.clear();
//                        mMap.clear();
//                    }


            //  }
//                }
//            });

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            mMap.getUiSettings().isMapToolbarEnabled();
            mMap.getUiSettings().setScrollGesturesEnabled(true);
            mMap.getUiSettings().isRotateGesturesEnabled();
            mMap.getUiSettings().setZoomControlsEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            updateLocationUI();

        }

//        public void getGeolocation() {
//
////            // initialize and set skip location
//            String skip6N = Repository.getSkip(this).get(5).getName();
//            double lat = Repository.getSkip(this).get(5).getLatitude();
//            double lng = Repository.getSkip(this).get(5).getLongitude();
//
//            LatLng skip6L = new LatLng(lat, lng);
//            mMap.addMarker(new MarkerOptions().position(skip6L)
//                    .title(skip6N));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(skip6L));
//        }
//

//    public void getinfowindow(){mi'd
////
////        Marker melbourne = mMap.addMarker(new MarkerOptions()
////                .position()
////                .title("Melbourne")
////                .snippet("Population: 4,137,400"));
////
////    }

    // getting device's location
    private void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if(mLocationPermissionsGranted){

                Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete: found location!");
                            Location currentLocation = (Location) task.getResult();

                            MarkerOptions marker = new MarkerOptions().position(new LatLng(currentLocation.getLatitude(),
                                    currentLocation.getLongitude())).title("Driver Location");
//                            marker.getIcon().
//                            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.plowtruck));
                            mMap.addMarker(marker);


                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    DEFAULT_ZOOM,
                                    "Driver Location");
                        }else{
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapPageActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }
    }

    //    //camera movement
    private void moveCamera(LatLng latLng, float zoom, String title ){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));

        if(!title.equals("My Location")){
            MarkerOptions options = new MarkerOptions()
                    .position(latLng)
                    .title(title)
                    ;
            mMap.addMarker(options);
        }
    }

    //updating location
    private void updateLocationUI() {
        if (mMap == null) {
            return;
        }
        try {
            if (mLocationPermissionsGranted) {
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                mMap.setMyLocationEnabled(false);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                Task location = mFusedLocationProviderClient.getLastLocation();
                location = null;

                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }

//    //initialisation process
//    private void init(){
//        Button btnMap = (Button) findViewById(R.id.btnMap);
//        btnMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MapPageActivity.this, MapPageActivity.class);
//                startActivity(intent);
//            }
//        });
//    }

    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapPageActivity.this);
    }

    //     enabling all services and requesting permission
//     checking if the services are enabled
    public boolean isServiceOK(){
        Log.d(TAG,"isServicesOK: checking google services version");
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MapPageActivity.this);

        if(available == ConnectionResult.SUCCESS) {
            //user can make request
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //occured errors can be resolved
            Log.d(TAG, "isServicesOK: an error occured but we can fix this");
            Dialog dialog= GoogleApiAvailability.getInstance().getErrorDialog(MapPageActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, " map request cannot be made",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    // checking the location permission
    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COURSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
                initMap();
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @SuppressLint("MissingPermission")
    public void onRequestPermissionsResults(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case LOCATION_REQUEST:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                }
                break;
        }
        initMap();
    }

    //requesting permission on result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                        break;
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    private String getRequestUrl(LatLng origin, LatLng dest) {
        //Value of origin
        String str_org = "origin=" + origin.latitude +","+origin.longitude;
        //Value of destination
        String str_dest = "destination=" + dest.latitude+","+dest.longitude;
        //Set value enable the sensor
        String sensor = "sensor=false";
        //Mode for find direction
        String mode = "mode=driving";
        //Build the full param
        String param = str_org +"&" + str_dest + "&" +sensor+"&" +mode;
        //Output format
        String output = "json";
        //Create url to request
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + param;
        return url;
    }

    private String requestDirection(String reqUrl) throws IOException {
        String responseString = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try{
            URL url = new URL(reqUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            //Get the response result
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            responseString = stringBuffer.toString();
            bufferedReader.close();
            inputStreamReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            httpURLConnection.disconnect();
        }
        return responseString;
    }

    public class TaskRequestDirections extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String responseString = "";
            try {
                responseString = requestDirection(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  responseString;
        }

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            //Parse json here
//            cdu.xeon.smartskips.MapPageActivity.TaskParser taskParser = new cdu.xeon.smartskips.MapPageActivity.TaskParser();
//            taskParser.execute(s);
//        }
    }

    public class TaskParser extends AsyncTask<String, Void, List<List<HashMap<String, String>>> > {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... strings) {
            JSONObject jsonObject = null;
            List<List<HashMap<String, String>>> routes = null;
            try {
                jsonObject = new JSONObject(strings[0]);
                DirectionParser directionsParser = new DirectionParser();
                routes = directionsParser.parse(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return routes;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> lists) {
            //Get list route and display it into the map

            ArrayList points = null;

            PolylineOptions polylineOptions = null;

            for (List<HashMap<String, String>> path : lists) {
                points = new ArrayList();
                polylineOptions = new PolylineOptions();

                for (HashMap<String, String> point : path) {
                    double lat = Double.parseDouble(point.get("lat"));
                    double lon = Double.parseDouble(point.get("lon"));
                    points.add(new LatLng(lat, lon));
                }

                polylineOptions.addAll(points);
                polylineOptions.width(15);
                polylineOptions.color(Color.BLUE);
                polylineOptions.geodesic(true);
            }

            if (polylineOptions != null) {
                mMap.addPolyline(polylineOptions);
            } else {
                Toast.makeText(getApplicationContext(), "Direction not found!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}