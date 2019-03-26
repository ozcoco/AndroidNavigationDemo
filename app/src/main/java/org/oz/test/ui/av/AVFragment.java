package org.oz.test.ui.av;

import android.os.Bundle;

import org.oz.test.base.ControllerNavBindingFragment;
import org.oz.test.databinding.AvFragmentBinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

public class AVFragment extends ControllerNavBindingFragment<AvFragmentBinding, AVController> implements AVContract.View {


    public class Handle {


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setHandle(new Handle());

        getBinding().setVm(ViewModelProviders.of(this).get(AvViewModel.class));

    }

}
