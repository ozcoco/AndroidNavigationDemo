package org.oz.test.ui.map;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.map.Map;
import com.map.Platform;
import com.map.constant.MapType;

import org.oz.test.R;
import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.MapFragmentBinding;

import java.util.Objects;

public class MapFragment extends ControllerNavBindingFragment<MapFragmentBinding, MapController> implements MapContract.View {

    public final static String TAG = MapFragment.class.getCanonicalName();

    public class Handle {

    }


    private Map mMap;

    private com.map.MapFragment mMapFragment;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = super.onCreateView(inflater, container, savedInstanceState);

        Platform platform = MapFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getPlatform();

        mMapFragment = com.map.MapFragment.newInstance(platform);

        getChildFragmentManager().beginTransaction().replace(R.id.container, mMapFragment).commitNow();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setHandle(new Handle());

        getBinding().setVm(ViewModelProviders.of(this).get(MapViewModel.class));

    }

    @Override
    public void onStart() {
        super.onStart();

        initMap();
    }

    private void initMap() {

        mMap = mMapFragment.getMap();

        mMap.getMapStyle().setMapType(MapType.MAP_TYPE_SATELLITE);

        mMap.getMapStyle().setZoomControlsEnabled(false);

        mMap.getMapLocation().showMyLocation();

        mMap.getMapLocation().setOnMyLocationChangeListener(location -> {

            Log.i(TAG, "initMap: " + location.toString());

        });


        mMap.getMapLocation().setPinCenterControlsEnabled(true);

    }


}
