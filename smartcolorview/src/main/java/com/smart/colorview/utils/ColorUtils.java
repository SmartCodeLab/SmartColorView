package com.smart.colorview.utils;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by fengjh on 16/12/23.
 */

public class ColorUtils {

    public static int[] getSmartColor(Context context) {
        int[] color = new int[30];
        Resources resources = context.getResources();
        if (resources != null) {
            int index = 0;
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 5; j++) {
                    color[index++] = resources.getColor(ResUtils.getColorId(context, "smart_color_" + i + j));
                }
            }
        }
        return color;
    }

    public static int[] getBlueColor(Context context) {
        int[] color = new int[14];
        Resources resources = context.getResources();
        if (resources != null) {
            for (int i = 1; i <= 14; i++) {
                color[i - 1] = resources.getColor(ResUtils.getColorId(context, "smart_color_blue" + i));
            }
        }
        return color;
    }

    public static int[] getPurpleColor(Context context) {
        int[] color = new int[14];
        Resources resources = context.getResources();
        if (resources != null) {
            for (int i = 1; i <= 14; i++) {
                color[i - 1] = resources.getColor(ResUtils.getColorId(context, "smart_color_purple" + i));
            }
        }
        return color;
    }

    public static int[] getGreenColor(Context context) {
        int[] color = new int[14];
        Resources resources = context.getResources();
        if (resources != null) {
            for (int i = 1; i <= 14; i++) {
                color[i - 1] = resources.getColor(ResUtils.getColorId(context, "smart_color_green" + i));
            }
        }
        return color;
    }

    public static int[] getOrangeColor(Context context) {
        int[] color = new int[14];
        Resources resources = context.getResources();
        if (resources != null) {
            for (int i = 1; i <= 14; i++) {
                color[i - 1] = resources.getColor(ResUtils.getColorId(context, "smart_color_orange" + i));
            }
        }
        return color;
    }

    public static int[] getRedColor(Context context) {
        int[] color = new int[14];
        Resources resources = context.getResources();
        if (resources != null) {
            for (int i = 1; i <= 14; i++) {
                color[i - 1] = resources.getColor(ResUtils.getColorId(context, "smart_color_red" + i));
            }
        }
        return color;
    }
}
