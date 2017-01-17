package com.smart.colorview.normal.model;

import com.smart.colorview.normal.RectangleColorView;

/**
 * Created by fengjh on 17/1/3.
 */

public class RectangleColorModel {

    private float rectangleWidth;
    private float rectangleHeight;
    private int rectangleColor;
    private float rectangleColorRadius;
    private float rectOutlineStrokeWidth;
    private int rectOutlineStrokeColor;
    private float rectTickStrokeWidth;
    private int rectTickStrokeColor;
    private int rectTickBackgroundColor;
    private RectangleColorView.TickDirection tickDirection;
    private boolean rectSelected = false;
    private boolean rectShowTick = false;
    private RectangleColorView.TickType tickType;
    private float rectTickWidth;
    private float rectTickHeight;

    public int getRectangleColor() {
        return rectangleColor;
    }

    public void setRectangleColor(int rectangleColor) {
        this.rectangleColor = rectangleColor;
    }

    public float getRectangleColorRadius() {
        return rectangleColorRadius;
    }

    public void setRectangleColorRadius(float rectangleColorRadius) {
        this.rectangleColorRadius = rectangleColorRadius;
    }

    public float getRectangleHeight() {
        return rectangleHeight;
    }

    public void setRectangleHeight(float rectangleHeight) {
        this.rectangleHeight = rectangleHeight;
    }

    public float getRectangleWidth() {
        return rectangleWidth;
    }

    public void setRectangleWidth(float rectangleWidth) {
        this.rectangleWidth = rectangleWidth;
    }

    public int getRectOutlineStrokeColor() {
        return rectOutlineStrokeColor;
    }

    public void setRectOutlineStrokeColor(int rectOutlineStrokeColor) {
        this.rectOutlineStrokeColor = rectOutlineStrokeColor;
    }

    public float getRectOutlineStrokeWidth() {
        return rectOutlineStrokeWidth;
    }

    public void setRectOutlineStrokeWidth(float rectOutlineStrokeWidth) {
        this.rectOutlineStrokeWidth = rectOutlineStrokeWidth;
    }

    public boolean isRectSelected() {
        return rectSelected;
    }

    public void setRectSelected(boolean rectSelected) {
        this.rectSelected = rectSelected;
    }

    public boolean isRectShowTick() {
        return rectShowTick;
    }

    public void setRectShowTick(boolean rectShowTick) {
        this.rectShowTick = rectShowTick;
    }

    public int getRectTickBackgroundColor() {
        return rectTickBackgroundColor;
    }

    public void setRectTickBackgroundColor(int rectTickBackgroundColor) {
        this.rectTickBackgroundColor = rectTickBackgroundColor;
    }

    public int getRectTickStrokeColor() {
        return rectTickStrokeColor;
    }

    public void setRectTickStrokeColor(int rectTickStrokeColor) {
        this.rectTickStrokeColor = rectTickStrokeColor;
    }

    public float getRectTickStrokeWidth() {
        return rectTickStrokeWidth;
    }

    public void setRectTickStrokeWidth(float rectTickStrokeWidth) {
        this.rectTickStrokeWidth = rectTickStrokeWidth;
    }

    public RectangleColorView.TickDirection getTickDirection() {
        return tickDirection;
    }

    public void setTickDirection(RectangleColorView.TickDirection tickDirection) {
        this.tickDirection = tickDirection;
    }

    public RectangleColorView.TickType getTickType() {
        return tickType;
    }

    public void setTickType(RectangleColorView.TickType tickType) {
        this.tickType = tickType;
    }

    public float getRectTickHeight() {
        return rectTickHeight;
    }

    public void setRectTickHeight(float rectTickHeight) {
        this.rectTickHeight = rectTickHeight;
    }

    public float getRectTickWidth() {
        return rectTickWidth;
    }

    public void setRectTickWidth(float rectTickWidth) {
        this.rectTickWidth = rectTickWidth;
    }
}
