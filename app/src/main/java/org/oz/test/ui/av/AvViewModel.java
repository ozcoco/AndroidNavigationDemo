package org.oz.test.ui.av;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.oz.test.widgets.view.ChoiceChipGroup;

public class AvViewModel extends AndroidViewModel implements AVContract.Model {

    public static class BindingAdapter {

        @androidx.databinding.BindingAdapter({"onChipCheckedChangeListener"})
        public static void onChipCheckedChangeListener(ChoiceChipGroup view, ChoiceChipGroup.OnChipCheckedChangeListener listener) {

            view.setOnChipCheckedChangeListener(listener);

        }

    }


    public AvViewModel(@NonNull Application application) {
        super(application);
    }
    // TODO: Implement the ViewModel
}
