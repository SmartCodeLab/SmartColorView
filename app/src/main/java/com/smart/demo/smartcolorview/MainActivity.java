package com.smart.demo.smartcolorview;

import android.os.Bundle;
import android.view.View;

import com.smart.colorview.normal.CircleColorView;
import com.smart.colorview.normal.RectangleColorView;
import com.smart.colorview.normal.model.CircleColorModel;
import com.smart.colorview.normal.model.RectangleColorModel;
import com.smart.demo.smartcolorview.base.BaseActivity;
import com.smart.demo.smartcolorview.biz.ColorManager;
import com.smart.demo.smartcolorview.circle.CircleColorActivity;
import com.smart.demo.smartcolorview.rectangle.RectangleColorActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.circleColorView01)
    CircleColorView mCircleColorView01;
    @Bind(R.id.circleColorView02)
    CircleColorView mCircleColorView02;
    @Bind(R.id.circleColorView03)
    CircleColorView mCircleColorView03;
    @Bind(R.id.rectangleColorView04)
    RectangleColorView mRectangleColorView04;
    @Bind(R.id.rectangleColorView05)
    RectangleColorView mRectangleColorView05;

    @OnClick({R.id.circleColorView01, R.id.circleColorView02,
            R.id.circleColorView03, R.id.rectangleColorView04,
            R.id.rectangleColorView05})
    public void click(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.circleColorView01:
                bundle.putInt("style", ColorManager.CIRCLE_COLOR_STYLE01);
                openActivity(CircleColorActivity.class, bundle);
                break;
            case R.id.circleColorView02:
                bundle.putInt("style", ColorManager.CIRCLE_COLOR_STYLE02);
                openActivity(CircleColorActivity.class, bundle);
                break;
            case R.id.circleColorView03:
                bundle.putInt("style", ColorManager.CIRCLE_COLOR_STYLE03);
                openActivity(CircleColorActivity.class, bundle);
                break;
            case R.id.rectangleColorView04:
                bundle.putInt("style", ColorManager.RECTANGLE_COLOR_STYLE01);
                openActivity(RectangleColorActivity.class, bundle);
                break;
            case R.id.rectangleColorView05:
                bundle.putInt("style", ColorManager.RECTANGLE_COLOR_STYLE02);
                openActivity(RectangleColorActivity.class, bundle);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<CircleColorModel> colorList01 = ColorManager.getCircleColorList(this, ColorManager.CIRCLE_COLOR_STYLE01, true, -1);
        mCircleColorView01.setCircleColorModel(colorList01.get(18));
        List<CircleColorModel> colorList02 = ColorManager.getCircleColorList(this, ColorManager.CIRCLE_COLOR_STYLE02, true, -1);
        mCircleColorView02.setCircleColorModel(colorList02.get(18));
        List<CircleColorModel> colorList03 = ColorManager.getCircleColorList(this, ColorManager.CIRCLE_COLOR_STYLE03, true, -1);
        mCircleColorView03.setCircleColorModel(colorList03.get(18));
        List<RectangleColorModel> colorList04 = ColorManager.getRectangleColorList(this, ColorManager.RECTANGLE_COLOR_STYLE01, true, -1);
        mRectangleColorView04.setRectangleColorModel(colorList04.get(18));
        List<RectangleColorModel> colorList05 = ColorManager.getRectangleColorList(this, ColorManager.RECTANGLE_COLOR_STYLE02, true, -1);
        mRectangleColorView05.setRectangleColorModel(colorList05.get(18));
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }
}
