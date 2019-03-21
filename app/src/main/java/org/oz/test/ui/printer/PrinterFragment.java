package org.oz.test.ui.printer;

import android.os.Bundle;

import org.oz.test.base.NavBindingFragment;
import org.oz.test.databinding.PrinterFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class PrinterFragment extends NavBindingFragment<PrinterFragmentBinding> {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setVm(ViewModelProviders.of(this).get(PrinterViewModel.class));
    }

}
