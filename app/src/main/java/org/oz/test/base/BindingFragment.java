package org.oz.test.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BindingFragment<B extends ViewDataBinding> extends BaseFragment {

    private B mBinding;

    public B getBinding() {

        if (mBinding == null)
            mBinding = DataBindingUtil.findBinding(Objects.requireNonNull(getView()));

        return mBinding;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mBinding != null)
            mBinding.unbind();

        mBinding = null;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {

            final Class<B> clazz = (Class<B>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

            final Method method = clazz.getMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);

            mBinding = (B) method.invoke(null, inflater, container, false);

            mBinding.setLifecycleOwner(this);

            return mBinding.getRoot();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*    @NonNull
    @LayoutRes
     protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        mBinding.setLifecycleOwner(this);

        return mBinding.getRoot();
    }*/

}
