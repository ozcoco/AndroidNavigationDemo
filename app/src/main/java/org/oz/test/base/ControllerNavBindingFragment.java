package org.oz.test.base;

import android.os.Bundle;

import org.oz.test.base.controller.BaseController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

public class ControllerNavBindingFragment<B extends ViewDataBinding, C extends BaseController> extends NavBindingFragment<B> {


    private C mController;

    @Nullable
    public C getController() {

        return mController;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {

            final Class<C> clazzC = (Class<C>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

            Constructor<C> constructor = clazzC.getConstructor(getClass());

            getLifecycle().addObserver(mController = constructor.newInstance(this));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mController != null)
            getLifecycle().removeObserver(mController);

        mController = null;

    }


}
