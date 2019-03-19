package org.oz.test.ui.rfid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.oz.test.R;
import org.oz.test.base.BaseFragment;
import org.oz.test.databinding.FragmentMainBinding;
import org.oz.test.databinding.RfidFragmentBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

public class RFIDFragment extends BaseFragment {

    private static int count = 0;

    private RfidViewModel mViewModel;

    public static RFIDFragment newInstance() {
        return new RFIDFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(RfidViewModel.class);

        mViewModel.count.setValue(count++);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final RfidFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.rfid_fragment, container, false);

        binding.setLifecycleOwner(this);

        binding.setVm(mViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel
    }


}
