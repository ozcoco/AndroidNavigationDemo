package org.oz.test.base;

import android.widget.Toast;

import org.oz.test.base.contract.IView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment implements IView {


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }
}
