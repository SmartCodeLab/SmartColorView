package com.smart.colorview.normal.model;

import com.smart.colorview.normal.CircleColorView;

/**
 * Created by fengjh on 17/1/3.
 */

public class CircleColorModel {

    private float circleWidth;
    private float circleHeight;
    private int circleColor;
    private boolean circleSelected = false;
    private boolean selectUseOutline = false;
    private boolean normalUseOutline = false;
    private float outlineStrokeWidth;
    private int outlineStrokeColor;
    private boolean selectUseFrame = false;
    private float frameStrokeWidth;
    private int frameStrokeColor;
    private int frameCornerRadius;
    private CircleColorView.InnerType innerType;
    private float innerStrokeWidth;
    private int innerStrokeColor;
    private float innerStrokeDividerWidth;
    private float tickStrokeWidth;
    private int tickStrokeColor;
    private float tickBackgroundDividerWidth;
    private int tickBackgroundColor;

    public int getCircleColor() {
        return circleColor;
    }

    public void setCircleColor(int circleColor) {
        this.circleColor = circleColor;
    }

    public float getCircleHeight() {
        return circleHeight;
    }

    public void setCircleHeight(float circleHeight) {
        this.circleHeight = circleHeight;
    }

    public boolean isCircleSelected() {
        return circleSelected;
    }

    public void setCircleSelected(boolean circleSelected) {
        this.circleSelected = circleSelected;
    }

    public float getCircleWidth() {
        return circleWidth;
    }

    public void setCircleWidth(float circleWidth) {
        this.circleWidth = circleWidth;
    }

    public int getFrameCornerRadius() {
        return frameCornerRadius;
    }

    public void setFrameCornerRadius(int frameCornerRadius) {
        this.frameCornerRadius = frameCornerRadius;
    }

    public int getFrameStrokeColor() {
        return frameStrokeColor;
    }

    public void setFrameStrokeColor(int frameStrokeColor) {
        this.frameStrokeColor = frameStrokeColor;
    }

    public float getFrameStrokeWidth() {
        return frameStrokeWidth;
    }

    public void setFrameStrokeWidth(float frameStrokeWidth) {
        this.frameStrokeWidth = frameStrokeWidth;
    }

    public int getInnerStrokeColor() {
        return innerStrokeColor;
    }

    public void setInnerStrokeColor(int innerStrokeColor) {
        this.innerStrokeColor = innerStrokeColor;
    }

    public float getInnerStrokeDividerWidth() {
        return innerStrokeDividerWidth;
    }

    public void setInnerStrokeDividerWidth(float innerStrokeDividerWidth) {
        this.innerStrokeDividerWidth = innerStrokeDividerWidth;
    }

    public float getInnerStrokeWidth() {
        return innerStrokeWidth;
    }

    public void setInnerStrokeWidth(float innerStrokeWidth) {
        this.innerStrokeWidth = innerStrokeWidth;
    }

    public CircleColorView.InnerType getInnerType() {
        return innerType;
    }

    public void setInnerType(CircleColorView.InnerType innerType) {
        this.innerType = innerType;
    }

    public boolean isNormalUseOutline() {
        return normalUseOutline;
    }

    public void setNormalUseOutline(boolean normalUseOutline) {
        this.normalUseOutline = normalUseOutline;
    }

    public int getOutlineStrokeColor() {
        return outlineStrokeColor;
    }

    public void setOutlineStrokeColor(int outlineStrokeColor) {
        this.outlineStrokeColor = outlineStrokeColor;
    }

    public float getOutlineStrokeWidth() {
        return outlineStrokeWidth;
    }

    public void setOutlineStrokeWidth(float outlineStrokeWidth) {
        this.outlineStrokeWidth = outlineStrokeWidth;
    }

    public boolean isSelectUseFrame() {
        return selectUseFrame;
    }

    public void setSelectUseFrame(boolean selectUseFrame) {
        this.selectUseFrame = selectUseFrame;
    }

    public boolean isSelectUseOutline() {
        return selectUseOutline;
    }

    public void setSelectUseOutline(boolean selectUseOutline) {
        this.selectUseOutline = selectUseOutline;
    }

    public int getTickBackgroundColor() {
        return tickBackgroundColor;
    }

    public void setTickBackgroundColor(int tickBackgroundColor) {
        this.tickBackgroundColor = tickBackgroundColor;
    }

    public float getTickBackgroundDividerWidth() {
        return tickBackgroundDividerWidth;
    }

    public void setTickBackgroundDividerWidth(float tickBackgroundDividerWidth) {
        this.tickBackgroundDividerWidth = tickBackgroundDividerWidth;
    }

    public int getTickStrokeColor() {
        return tickStrokeColor;
    }

    public void setTickStrokeColor(int tickStrokeColor) {
        this.tickStrokeColor = tickStrokeColor;
    }

    public float getTickStrokeWidth() {
        return tickStrokeWidth;
    }

    public void setTickStrokeWidth(float tickStrokeWidth) {
        this.tickStrokeWidth = tickStrokeWidth;
    }
}
