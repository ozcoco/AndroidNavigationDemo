package org.oz.test.ui.bt;

import android.os.Bundle;

import org.oz.test.base.NavBindingFragment;
import org.oz.test.databinding.BluetoothFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class BluetoothFragment extends NavBindingFragment<BluetoothFragmentBinding> {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setVm(ViewModelProviders.of(this).get(BluetoothViewModel.class));

    }


}
