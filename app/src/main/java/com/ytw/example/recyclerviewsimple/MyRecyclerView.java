package com.ytw.example.recyclerviewsimple;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by ytw on 2017/5/18.
 */

public class MyRecyclerView extends RecyclerView {

  ImageView headView;
  //初始高度
  int originHeight;

  public void setHeadView(ImageView headView) {
    this.headView = headView;
  }

  public MyRecyclerView(Context context) {
    super(context);
    init(context);
  }

  public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  void init(Context context) {
    originHeight = context.getResources().getDimensionPixelSize(R.dimen.head_height);
  }

  @Override public boolean onTouchEvent(MotionEvent e) {

    if (e.getAction() == MotionEvent.ACTION_UP) {
      //当手机离开屏幕时执行此操作
      // ofFloat() 参数接收的是一个数组
      ValueAnimator animator = new ValueAnimator().ofFloat(headView.getHeight(), originHeight - 200,
          originHeight);
      animator.setDuration(1000);
      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override public void onAnimationUpdate(ValueAnimator animation) {
          float value = (float) animation.getAnimatedValue();
          headView.getLayoutParams().height = (int) value;
          headView.requestLayout();
        }
      });
      animator.start();
    }
    return super.onTouchEvent(e);
  }
}
