package org.oz.test.ui.rfid;

import android.os.Bundle;

import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.RfidFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class RFIDFragment extends ControllerNavBindingFragment<RfidFragmentBinding, RFIDController> implements RFIDContract.View {

    public class Handle {

    }

    private static int count = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RfidViewModel viewModel = ViewModelProviders.of(this).get(RfidViewModel.class);

        viewModel.count.setValue(count++);

        getBinding().setHandle(new Handle());

        getBinding().setVm(viewModel);

    }

}
