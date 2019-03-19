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

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;


public class MainFragment extends BaseFragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentMainBinding mFragmentMainBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo getArguments
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mFragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        mFragmentMainBinding.setLifecycleOwner(this);

        mFragmentMainBinding.navigation.setOnNavigationItemSelectedListener(this);

        return mFragmentMainBinding.getRoot();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.navigation_home:
                //todo

                Navigation.findNavController(mFragmentMainBinding.container).navigate(R.id.to_nav_main);

                return true;

            case R.id.navigation_dashboard:

                Navigation.findNavController(mFragmentMainBinding.container).navigate(R.id.to_nav_bluetooth);

                return true;
            case R.id.navigation_notifications:

                Navigation.findNavController(mFragmentMainBinding.container).navigate(R.id.to_nav_printer);

                return true;
        }

        return false;
    }

}
