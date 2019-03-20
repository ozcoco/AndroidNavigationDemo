package org.oz.test.base;


import android.os.Bundle;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

public abstract class NavBindingFragment<B extends ViewDataBinding> extends BindingFragment<B> {

    private NavController mNavController;


    @Nullable
    public NavController getNavController() {

        if (mNavController == null) {

            Fragment fragment = getChildFragmentManager().getPrimaryNavigationFragment();

            mNavController = NavHostFragment.findNavController(Objects.requireNonNull(fragment));
        }

        return mNavController;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getNavController().restoreState(savedInstanceState);
    }


    @Override
    public void onPause() {
        super.onPause();

        getNavController().saveState();

    }
}
