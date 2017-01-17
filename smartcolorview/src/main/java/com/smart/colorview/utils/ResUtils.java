package com.smart.colorview.utils;

import android.content.Context;

/**
 * Created by fengjh on 16/12/23.
 */

public class ResUtils {

    public static int getColorId(Context context, String name) {
        return context.getResources().getIdentifier(name, "color", context.getPackageName());
    }
}
