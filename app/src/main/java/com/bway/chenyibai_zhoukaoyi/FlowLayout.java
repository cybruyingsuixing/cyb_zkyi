package com.bway.chenyibai_zhoukaoyi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {


    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取子控件的宽度与高度
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthmode = MeasureSpec.getMode(widthMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int heightmode = MeasureSpec.getMode(heightMeasureSpec);
        int heightsize = MeasureSpec.getSize(heightMeasureSpec);

        //定义变量
        int width = 0;
        int height = 0;
        int linewidth = 0;
        int lineheight = 0;
        int totalheight = 0;

        View childview;
        int childwidth = 0;
        int childheight = 0;


        for (int i = 0; i < getChildCount(); i++) {

            childview = getChildAt(i);
            //获取宽度
            childwidth = childview.getMeasuredWidth();
            //获取高度
            childheight = childview.getMeasuredHeight();

            //如果每行的宽度大于父控件，则进行换行
            if (linewidth + childwidth > widthsize) {

                //换行之后
                width = widthsize;
                //当前的高度等于新来的子控件的高度
                totalheight += lineheight;
                lineheight = childheight;

            } else {
                //否则的话不进行换行，继续向后拼接

                linewidth += childwidth;
                lineheight = Math.max(lineheight, childheight);
                width = Math.max(width, linewidth);

            }
            if (i == getChildCount() - 1) {

                totalheight += lineheight;
                height = totalheight;
            }


            width = widthmode == MeasureSpec.EXACTLY ? widthsize : width;
            height = heightmode == MeasureSpec.EXACTLY ? heightsize : height;
            //确定最终的宽高
            setMeasuredDimension(width, height);
        }


    }

    //布局
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        //定义变量
        int width = 0;
        int height = 0;
        int linewidth = 0;
        int lineheight = 0;
        int totalheight = 0;

        View childview;
        int childwidth = 0;
        int childheight = 0;

        for (int i = 0; i < getChildCount(); i++) {
            childview = getChildAt(i);
            childwidth = childview.getMeasuredWidth();
            childheight = childview.getMeasuredHeight();

            if (i % 2 == 0) {
                totalheight += childheight;
                childwidth = getWidth() / 2;
                linewidth = 0;
                layoutChildView(childview, linewidth, totalheight, linewidth + childwidth, totalheight + childheight);
            } else {

                totalheight += childheight;
                childwidth = getWidth() / 2;
                linewidth = childwidth;
                layoutChildView(childview, linewidth, totalheight, linewidth + childwidth, totalheight + childheight);
            }
        }


    }



       public void layoutChildView (View child,int l, int h, int r, int b){

        child.layout(l, h, r, b);

    }

}