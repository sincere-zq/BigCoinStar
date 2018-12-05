package com.netson.commonmodule.utils;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

/**
 * Drawable工具类
 */
public class DrawableUtils {
    /**
     * 设置drawabletop
     */
    public static void drawableTop(TextView textView, int resId) {
        Drawable drawable = textView.getContext().getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }
}
