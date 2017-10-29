package com.dev.bollha.tcc_prototipo;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment {
    private LocationManager locationManager;
    private android.location.LocationListener locationListener;
    //private GoogleMap mMap;

    public MapaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment_mapa =  inflater.inflate(R.layout.fragment_mapa, container, false);
//        mEdtLongitude = (EditText)fragment_mapa.findViewById(R.id.edtLongitude);
//        mEdtLatitude = (EditText)fragment_mapa.findViewById(R.id.edtLatitude);

        return fragment_mapa;
    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
//        locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                LatLng marker = new LatLng(location.getLatitude(), location.getLongitude());
//                mEdtLongitude.setText(new Double(marker.longitude).toString());
//                mEdtLatitude.setText(new Double(marker.latitude).toString());
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 30));
//                mMap.clear();
//                mMap.addMarker(new MarkerOptions().title("Você está aqui!").position(marker));
//            }
//
//            @Override
//            public void onStatusChanged(String s, int i, Bundle bundle) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String s) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String s) {
//                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                startActivity(intent);
//            }
//        };
//
//        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            requestPermissions(new String[]{
//                    Manifest.permission.ACCESS_FINE_LOCATION,
//                    Manifest.permission.ACCESS_COARSE_LOCATION,
//                    Manifest.permission.INTERNET
//            }, 10);
//            return;
//        }else {
//            callLocation();
//        }
//
//    }

    private void callLocation(){
        locationManager.requestLocationUpdates("gps", 2000, 10, locationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    callLocation();
                }
        }
    }

//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//    }
}
