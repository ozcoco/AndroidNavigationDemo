package org.oz.test.ui.map;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.MapFragmentBinding;

public class MapFragment extends ControllerNavBindingFragment<MapFragmentBinding, MapController> implements MapContract.View {


    public class Handle {


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setHandle(new Handle());

        getBinding().setVm(ViewModelProviders.of(this).get(MapViewModel.class));

    }

}
