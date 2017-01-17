package com.smart.demo.smartcolorview.circle;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.smart.colorview.normal.model.CircleColorModel;
import com.smart.demo.smartcolorview.R;
import com.smart.demo.smartcolorview.base.BaseActivity;
import com.smart.demo.smartcolorview.biz.ColorManager;
import com.smart.demo.smartcolorview.intf.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class CircleColorActivity extends BaseActivity {

    @Bind(R.id.circleColorRecyclerView)
    RecyclerView mRecyclerView;
    private CircleColorAdapter mCircleColorAdapter;
    private List<CircleColorModel> mCircleColorModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = ColorManager.CIRCLE_COLOR_STYLE01;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("style")) {
            style = bundle.getInt("style");
        }
        mCircleColorModels.clear();
        List<CircleColorModel> colorList = ColorManager.getCircleColorList(this, style, false, 15);
        mCircleColorModels.addAll(colorList);
        GridLayoutManager manager = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(manager);
        mCircleColorAdapter = new CircleColorAdapter(this, mCircleColorModels);
        mRecyclerView.setAdapter(mCircleColorAdapter);
        mCircleColorAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mCircleColorAdapter.changeSelected(position);
            }
        });
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_circle_color;
    }
}
