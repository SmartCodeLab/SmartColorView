
package com.smart.demo.smartcolorview.rectangle;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.smart.colorview.normal.model.RectangleColorModel;
import com.smart.demo.smartcolorview.R;
import com.smart.demo.smartcolorview.base.BaseActivity;
import com.smart.demo.smartcolorview.biz.ColorManager;
import com.smart.demo.smartcolorview.intf.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class RectangleColorActivity extends BaseActivity {

    @Bind(R.id.rectangleRecyclerView)
    RecyclerView mRecyclerView;
    private RectangleColorAdapter mRectangleColorAdapter;
    private List<RectangleColorModel> mRectangleColorModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int style = ColorManager.RECTANGLE_COLOR_STYLE01;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("style")) {
            style = bundle.getInt("style");
        }
        mRectangleColorModels.clear();
        List<RectangleColorModel> colorList = ColorManager.getRectangleColorList(this, style, false, 15);
        mRectangleColorModels.addAll(colorList);
        GridLayoutManager manager = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(manager);
        mRectangleColorAdapter = new RectangleColorAdapter(this, mRectangleColorModels);
        mRecyclerView.setAdapter(mRectangleColorAdapter);
        mRectangleColorAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mRectangleColorAdapter.changeSelected(position);
            }
        });
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_rectangle_color;
    }
}
