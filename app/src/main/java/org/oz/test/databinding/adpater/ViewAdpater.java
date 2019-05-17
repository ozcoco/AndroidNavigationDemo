package org.oz.test.databinding.adpater;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.databinding.BindingAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.chip.ChipGroup;

public class ViewAdpater {

    @BindingAdapter({"clipToOutline"})
    public static void clipToOutline(View view, boolean enable) {

        view.setClipToOutline(enable);

        if (enable)
            view.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {

                    outline.setOval(new Rect(0, 0, view.getWidth(), view.getHeight()));
                }
            });

    }

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
