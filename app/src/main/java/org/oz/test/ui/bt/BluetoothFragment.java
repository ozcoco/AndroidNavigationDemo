package org.oz.test.ui.bt;

import android.os.Bundle;
import android.view.View;

import org.oz.test.base.NavBindingFragment;
import org.oz.test.databinding.BluetoothFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class BluetoothFragment extends NavBindingFragment<BluetoothFragmentBinding> implements BluetoothContract.View {

    private BluetoothController mBluetoothController;

    public class Handle {

        public void onPickPrinter(View view) {

            if (mBluetoothController != null)
                mBluetoothController.print();

        }

        public void onPrint(View view) {

            if (mBluetoothController != null)
                mBluetoothController.pickPrinter();

        }


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLifecycle().addObserver(mBluetoothController = new BluetoothController(this));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setVm(ViewModelProviders.of(this).get(BluetoothViewModel.class));
        getBinding().setHandle(new Handle());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        getLifecycle().removeObserver(mBluetoothController);

    }
}
