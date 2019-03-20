package org.oz.test.databinding.conversion;

import android.graphics.drawable.ColorDrawable;

import androidx.databinding.BindingConversion;

public class DrawableConversion {

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

}
