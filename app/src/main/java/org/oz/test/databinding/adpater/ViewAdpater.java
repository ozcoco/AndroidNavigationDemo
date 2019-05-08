package org.oz.test.databinding.adpater;

import androidx.databinding.BindingAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.ChipGroup;

public class ViewAdpater {

    @BindingAdapter({"onItemSelectedListener"})
    public static void onNavigationItemSelectedListener(BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

    @BindingAdapter({"onChipGroupCheckedChangeListener"})
    public static void onChipGroupCheckedChangeListener(ChipGroup view, ChipGroup.OnCheckedChangeListener listener) {
        view.setOnCheckedChangeListener(listener);
    }

/*    @BindingAdapter(value = {"decorativeAdapter"}, requireAll = false)
    public static void setDecorativeAdapter(RecyclerView view) {


    }*/


}
