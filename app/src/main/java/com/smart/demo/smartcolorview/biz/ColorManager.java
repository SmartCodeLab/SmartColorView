package com.smart.demo.smartcolorview.biz;

import android.content.Context;

import com.smart.colorview.normal.CircleColorView;
import com.smart.colorview.normal.RectangleColorView;
import com.smart.colorview.normal.model.CircleColorModel;
import com.smart.colorview.normal.model.RectangleColorModel;
import com.smart.colorview.utils.ColorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjh on 17/1/3.
 */

public class ColorManager {

    public static final int CIRCLE_COLOR_STYLE01 = 1;
    public static final int CIRCLE_COLOR_STYLE02 = 2;
    public static final int CIRCLE_COLOR_STYLE03 = 3;
    public static final int RECTANGLE_COLOR_STYLE01 = 4;
    public static final int RECTANGLE_COLOR_STYLE02 = 5;

    public static List<CircleColorModel> getCircleColorList(Context context, int style, boolean selected, int selectIndex) {
        ArrayList<CircleColorModel> list = new ArrayList<>();
        int[] smartColor = ColorUtils.getSmartColor(context);
        for (int i = 0; i < smartColor.length; i++) {
            CircleColorModel colorModel = new CircleColorModel();
            colorModel.setCircleColor(smartColor[i]);
            switch (style) {
                case CIRCLE_COLOR_STYLE01: {
                    colorModel.setSelectUseOutline(true);
                    colorModel.setOutlineStrokeWidth(4);
                    colorModel.setOutlineStrokeColor(smartColor[i]);
                    colorModel.setInnerType(CircleColorView.InnerType.INNER);
                    colorModel.setInnerStrokeWidth(0);
                    colorModel.setInnerStrokeDividerWidth(14);
                    if (i == selectIndex) {
                        colorModel.setCircleSelected(true);
                    } else {
                        colorModel.setCircleSelected(selected);
                    }
                }
                break;
                case CIRCLE_COLOR_STYLE02: {
                    colorModel.setSelectUseOutline(true);
                    colorModel.setNormalUseOutline(true);
                    colorModel.setOutlineStrokeWidth(4);
                    colorModel.setOutlineStrokeColor(0xffb1b1b1);
                    colorModel.setInnerType(CircleColorView.InnerType.TICK);
                    colorModel.setTickBackgroundDividerWidth(28);
                    colorModel.setTickStrokeWidth(6);
                    colorModel.setTickStrokeColor(0xffffffff);
                    colorModel.setTickBackgroundColor(0x55dddddd);
                    if (i == selectIndex) {
                        colorModel.setCircleSelected(true);
                    } else {
                        colorModel.setCircleSelected(selected);
                    }
                }
                break;
                case CIRCLE_COLOR_STYLE03: {
                    colorModel.setSelectUseOutline(true);
                    colorModel.setNormalUseOutline(true);
                    colorModel.setOutlineStrokeWidth(3);
                    colorModel.setOutlineStrokeColor(0xffb1b1b1);
                    colorModel.setInnerType(CircleColorView.InnerType.NORMAL);
                    colorModel.setSelectUseFrame(true);
                    colorModel.setFrameStrokeColor(0xff0079f1);
                    colorModel.setFrameStrokeWidth(6);
                    colorModel.setFrameCornerRadius(20);
                    if (i == selectIndex) {
                        colorModel.setCircleSelected(true);
                    } else {
                        colorModel.setCircleSelected(selected);
                    }
                }
                break;
            }
            list.add(colorModel);
        }
        return list;
    }

    public static List<RectangleColorModel> getRectangleColorList(Context context, int style, boolean selected, int selectIndex) {
        ArrayList<RectangleColorModel> list = new ArrayList<>();
        int[] smartColor = ColorUtils.getSmartColor(context);
        for (int i = 0; i < smartColor.length; i++) {
            RectangleColorModel colorModel = new RectangleColorModel();
            colorModel.setRectangleColor(smartColor[i]);
            switch (style) {
                case RECTANGLE_COLOR_STYLE01: {
                    colorModel.setTickType(RectangleColorView.TickType.CUSTOM);
                    colorModel.setRectTickWidth(80);
                    colorModel.setRectTickHeight(80);
                    colorModel.setRectTickStrokeWidth(6);
                    colorModel.setRectTickStrokeColor(0xffffffff);
                    colorModel.setRectTickBackgroundColor(0xff11b435);
                    colorModel.setTickDirection(RectangleColorView.TickDirection.RIGHT_BOTTOM);
                    colorModel.setRectShowTick(true);
                    if (i == selectIndex) {
                        colorModel.setRectSelected(true);
                    } else {
                        colorModel.setRectSelected(selected);
                    }
                }
                break;
                case RECTANGLE_COLOR_STYLE02: {
                    colorModel.setRectangleColorRadius(26);
                    colorModel.setRectTickStrokeWidth(4);
                    colorModel.setRectTickStrokeColor(0xffffffff);
                    colorModel.setRectTickBackgroundColor(0xfffadb71);
                    colorModel.setTickDirection(RectangleColorView.TickDirection.RIGHT_BOTTOM);
                    colorModel.setRectShowTick(true);
                    if (i == selectIndex) {
                        colorModel.setRectSelected(true);
                    } else {
                        colorModel.setRectSelected(selected);
                    }
                }
                break;
            }
            list.add(colorModel);
        }
        return list;
    }
}
