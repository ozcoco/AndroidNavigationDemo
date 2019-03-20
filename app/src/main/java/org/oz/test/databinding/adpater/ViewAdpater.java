package org.oz.test.databinding.adpater;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAdpater {

    @BindingAdapter({"onItemSelectedListener"})
    public static void onNavigationItemSelectedListener(BottomNavigationView view, BottomNavigationView.OnNavigationItemSelectedListener listener) {
        view.setOnNavigationItemSelectedListener(listener);
    }

/*    @BindingAdapter(value = {"decorativeAdapter"}, requireAll = false)
    public static void setDecorativeAdapter(RecyclerView view) {


    }*/


}
