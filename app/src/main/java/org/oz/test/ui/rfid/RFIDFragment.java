package org.oz.test.ui.rfid;

import android.os.Bundle;

import org.oz.test.base.NavBindingFragment;
import org.oz.test.databinding.RfidFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class RFIDFragment extends NavBindingFragment<RfidFragmentBinding> {

    private static int count = 0;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RfidViewModel viewModel = ViewModelProviders.of(this).get(RfidViewModel.class);

        viewModel.count.setValue(count++);

        getBinding().setVm(viewModel);

    }


}
