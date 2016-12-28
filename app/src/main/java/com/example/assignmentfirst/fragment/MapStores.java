package com.example.assignmentfirst.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.assignmentfirst.R;
import com.example.assignmentfirst.api.Parser;
import com.example.assignmentfirst.extras.Keys;
import com.example.assignmentfirst.pojos.StoreData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import org.json.JSONException;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Inspiron on 12/27/2016.
 */

public class MapStores extends Fragment implements OnMapReadyCallback {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_view_layout,container,false);
    }
    private ClusterManager<StoreData> mClusterManager;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mClusterManager = new ClusterManager<StoreData>(getActivity(),googleMap);
        mClusterManager.addItems(Parser.parseData(getArguments().getString(Keys.StoreList)));
        googleMap.setOnCameraIdleListener(mClusterManager);

        LatLng location = null;
        if(Parser.parseData(getArguments().getString(Keys.StoreList)).size() > 0)
            for(StoreData data:Parser.parseData(getArguments().getString(Keys.StoreList))) {
                location = new LatLng(data.getLat(),data.getLong());
//                          googleMap.addMarker(new MarkerOptions().position(location)
//                                   .title(data.getName()));

            }
        if(location != null)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 5));
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
}
