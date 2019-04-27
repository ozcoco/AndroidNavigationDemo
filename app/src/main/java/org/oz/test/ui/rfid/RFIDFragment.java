package org.oz.test.ui.rfid;

import android.os.Bundle;
import android.view.View;

import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.RfidFragmentBinding;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class RFIDFragment extends ControllerNavBindingFragment<RfidFragmentBinding, RFIDController> implements RFIDContract.View {

    public class Handle {

        public void onScan(View v) {

//            getBinding().getVm().scan();

        }

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       /* RfidViewModel viewModel = ViewModelProviders.of(Objects.requireNonNull(getParentFragment())).get(RfidViewModel.class);

        viewModel.count.setValue(viewModel.count.getValue() + 1);

        getBinding().setHandle(new Handle());

        getBinding().setVm(viewModel);*/

    }

}
