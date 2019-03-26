package org.oz.test.ui;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.oz.test.R;
import org.oz.test.base.NavBindingFragment;
import org.oz.test.databinding.FragmentMainBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;


public class MainFragment extends NavBindingFragment<FragmentMainBinding> implements MainContract.View {

    public class Handle implements BottomNavigationView.OnNavigationItemSelectedListener {

        /**
         * onNavigationItemSelected
         */
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {

                case R.id.navigation_rfid:

                    getNavController().navigate(R.id.to_nav_rfid);

                    break;

                case R.id.navigation_bluetooth:

                    getNavController().navigate(R.id.to_nav_bluetooth);

                    break;

                case R.id.navigation_printer:

                    getNavController().navigate(R.id.to_nav_printer);

                    break;

                    case R.id.navigation_av:

                    getNavController().navigate(R.id.to_nav_av);

                    break;
            }

            getBinding().getVm().print();

            showMessage("onNavigationItemSelected");

            return true;
        }


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getBinding().setVm(ViewModelProviders.of(this).get(MainViewModel.class));

        getBinding().setHandle(new Handle());
    }


}
