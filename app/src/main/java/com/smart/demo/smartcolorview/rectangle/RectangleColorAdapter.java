package com.smart.demo.smartcolorview.rectangle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smart.colorview.normal.RectangleColorView;
import com.smart.colorview.normal.model.RectangleColorModel;
import com.smart.demo.smartcolorview.R;
import com.smart.demo.smartcolorview.intf.OnItemClickListener;
import com.smart.demo.smartcolorview.utils.DensityUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fengjh on 17/1/3.
 */

public class RectangleColorAdapter extends RecyclerView.Adapter<RectangleColorAdapter.RectangleColorViewHolder> {

    private List<RectangleColorModel> mRectangleColorModels;
    private int mItemWidth, mItemHeight;
    private OnItemClickListener mOnItemClickListener;

    public RectangleColorAdapter(Context context, List<RectangleColorModel> mRectangleColorModels) {
        this.mRectangleColorModels = mRectangleColorModels;
        int screenWidth = DensityUtils.screenWidth(context);
        mItemWidth = mItemHeight = screenWidth / 5;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RectangleColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_rectangle_color, parent, false);
        return new RectangleColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RectangleColorViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.mLinearLayout.getLayoutParams();
        params.width = mItemWidth;
        params.height = mItemHeight;
        holder.mLinearLayout.setLayoutParams(params);
        holder.mLinearLayout.requestLayout();
        RectangleColorModel colorModel = mRectangleColorModels.get(position);
        holder.mRectangleColorView.setRectangleColorModel(colorModel);
        holder.mRectangleColorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(view, holder.getLayoutPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRectangleColorModels.size();
    }

    public void changeSelected(int position) {
        if (position < mRectangleColorModels.size() && position >= 0) {
            for (int i = 0; i < mRectangleColorModels.size(); i++) {
                mRectangleColorModels.get(i).setRectSelected(false);
            }
            mRectangleColorModels.get(position).setRectSelected(true);
            notifyDataSetChanged();
        }
    }

    public class RectangleColorViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.linear_item_rectangle_color_container)
        LinearLayout mLinearLayout;
        @Bind(R.id.rectangleColorView)
        RectangleColorView mRectangleColorView;

        public RectangleColorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
