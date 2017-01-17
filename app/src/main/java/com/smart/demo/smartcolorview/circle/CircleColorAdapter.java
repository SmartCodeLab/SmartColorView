package com.smart.demo.smartcolorview.circle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smart.colorview.normal.CircleColorView;
import com.smart.colorview.normal.model.CircleColorModel;
import com.smart.demo.smartcolorview.R;
import com.smart.demo.smartcolorview.intf.OnItemClickListener;
import com.smart.demo.smartcolorview.utils.DensityUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by fengjh on 17/1/3.
 */

public class CircleColorAdapter extends RecyclerView.Adapter<CircleColorAdapter.CircleColorViewHolder> {

    private List<CircleColorModel> mCircleColorModels;
    private int mItemWidth, mItemHeight;
    private OnItemClickListener mOnItemClickListener;

    public CircleColorAdapter(Context context, List<CircleColorModel> mCircleColorModels) {
        this.mCircleColorModels = mCircleColorModels;
        int screenWidth = DensityUtils.screenWidth(context);
        mItemWidth = mItemHeight = screenWidth / 5;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public CircleColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_circle_color, parent, false);
        return new CircleColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CircleColorViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.mLinearLayout.getLayoutParams();
        params.width = mItemWidth;
        params.height = mItemHeight;
        holder.mLinearLayout.setLayoutParams(params);
        holder.mLinearLayout.requestLayout();
        CircleColorModel colorModel = mCircleColorModels.get(position);
        holder.mCircleColorView.setCircleColorModel(colorModel);
        holder.mCircleColorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(holder.mCircleColorView, holder.getLayoutPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCircleColorModels.size();
    }

    public void changeSelected(int position) {
        if (position < mCircleColorModels.size() && position >= 0) {
            for (int i = 0; i < mCircleColorModels.size(); i++) {
                mCircleColorModels.get(i).setCircleSelected(false);
            }
            mCircleColorModels.get(position).setCircleSelected(true);
            notifyDataSetChanged();
        }
    }

    public class CircleColorViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.linear_item_circle_color_container)
        LinearLayout mLinearLayout;
        @Bind(R.id.circleColorView)
        CircleColorView mCircleColorView;

        public CircleColorViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
