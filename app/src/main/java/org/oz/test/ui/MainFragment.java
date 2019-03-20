package org.oz.test.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.oz.test.R;
import org.oz.test.base.BaseFragment;
import org.oz.test.databinding.FragmentMainBinding;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;


public class MainFragment extends BaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private NavController mNavController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo getArguments
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        binding.setLifecycleOwner(this);

        binding.navigation.setOnNavigationItemSelectedListener(this);

        return binding.getRoot();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (mNavController == null)
            mNavController = NavHostFragment.findNavController(Objects.requireNonNull(getChildFragmentManager().findFragmentById(R.id.nav_host_fragment)));

        switch (item.getItemId()) {

            case R.id.navigation_home:
                //todo

                mNavController.navigate(R.id.to_nav_rfid);

                return true;

            case R.id.navigation_dashboard:

                mNavController.navigate(R.id.to_nav_bluetooth);

                return true;
            case R.id.navigation_notifications:

                mNavController.navigate(R.id.to_nav_printer);

                return true;
        }

        return false;
    }

}
