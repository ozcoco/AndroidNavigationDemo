package org.oz.test.ui.rfid;

import android.os.Bundle;

import org.oz.test.base.NavBindingFragment;
import org.oz.test.databinding.RfidFragmentBinding;
import org.oz.test.ui.bt.BluetoothController;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class RFIDFragment extends NavBindingFragment<RfidFragmentBinding> implements RFIDContract.View {

    private RFIDController mRFIDController;

    public class Handle {


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLifecycle().addObserver(mRFIDController = new RFIDController(this));
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RfidViewModel viewModel = ViewModelProviders.of(this).get(RfidViewModel.class);

        getBinding().setHandle(new Handle());

        getBinding().setVm(viewModel);

    }

}
