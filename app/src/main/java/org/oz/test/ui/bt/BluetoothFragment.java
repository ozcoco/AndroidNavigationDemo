package org.oz.test.ui.bt;

import android.os.Bundle;
import android.view.View;

import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.BluetoothFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class BluetoothFragment extends ControllerNavBindingFragment<BluetoothFragmentBinding, BluetoothController> implements BluetoothContract.View {


    public class Handle {

        public void onPickPrinter(View view) {

            final BluetoothController controller = getController();

            if (controller != null)
                controller.pickPrinter();

        }

        public void onPrint(View view) {

            final BluetoothController controller = getController();

            if (controller != null)
                controller.print();

        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setVm(ViewModelProviders.of(this).get(BluetoothViewModel.class));

        getBinding().setHandle(new Handle());

    }

}
