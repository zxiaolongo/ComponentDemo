package com.zxl.coordinatorlayoutdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TranslucentBehaviorTextView extends CoordinatorLayout.Behavior<TextView> {

    /**
     * 标题栏的高度
     */
    private int mToolbarHeight = 0;

    public TranslucentBehaviorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //layoutDependsOn()：确定使用Behavior的View要依赖的View的类型
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof ImageView;
    }

    /**
     * 必须要加上  layout_anchor，对方也要layout_collapseMode才能使用
     * 当被依赖的View状态改变时回调
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {

        // 初始化高度
        if (mToolbarHeight == 0) {
            mToolbarHeight = child.getBottom() * 2;//为了更慢的
        }
        Log.i("-------", dependency.getY() + "-------" + mToolbarHeight);
        //
        //计算toolbar从开始移动到最后的百分比
        float percent = dependency.getY() / mToolbarHeight;

        //百分大于1，直接赋值为1
        if (percent >= 1) {
            percent = 1f;
        }

        // 计算alpha通道值
        float alpha = percent * 255;


        //设置背景颜色
        child.setBackgroundColor(Color.argb((int) alpha, 255, 0, 0));
//设置背景颜色
        child.setTextColor(Color.argb((int) alpha, 255, 255, 255));
        return true;
    }
}
