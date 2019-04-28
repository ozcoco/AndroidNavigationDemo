package org.oz.test.ui.map;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.map.Map;
import com.map.Platform;
import com.map.feature.MapType;

import org.oz.test.R;
import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.MapFragmentBinding;

import java.util.Objects;

public class MapFragment extends ControllerNavBindingFragment<MapFragmentBinding, MapController> implements MapContract.View {

    public class Handle {

    }


    private Map mMap;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setHandle(new Handle());

        getBinding().setVm(ViewModelProviders.of(this).get(MapViewModel.class));

        Platform platform = MapFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getPlatform();

        com.map.MapFragment mMapFragment = com.map.MapFragment.newInstance(platform);

        getChildFragmentManager().beginTransaction().replace(R.id.container, mMapFragment).commit();

        mMap = mMapFragment.getMap();



    }

    @Override
    public void onStart() {
        super.onStart();

//        mMap.getMapStyle().setMapType(MapType.MAP_TYPE_SATELLITE);

//        mMap.getMapLocation().showMyLocation();

    }
}
