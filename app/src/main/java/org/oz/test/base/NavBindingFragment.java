package org.oz.test.base;


import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

public abstract class NavBindingFragment<B extends ViewDataBinding> extends BindingFragment<B> {

    private NavController mNavController;

    public NavController getNavController() {

        if (mNavController == null) {

            Fragment fragment = getChildFragmentManager().getPrimaryNavigationFragment();

            if (fragment != null)
                mNavController = NavHostFragment.findNavController(fragment);
            else
                mNavController = NavHostFragment.findNavController(this);
        }

        return mNavController;
    }


}
