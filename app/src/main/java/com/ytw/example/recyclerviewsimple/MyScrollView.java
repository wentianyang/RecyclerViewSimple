package com.ytw.example.recyclerviewsimple;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by ytw on 2017/5/28.
 */

public class MyScrollView extends ScrollView {

  private ImageView mHeadView;

  int mHeadOriginheight;

  public MyScrollView(Context context) {
    super(context);
    init(context);
  }

  public MyScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context);
  }

  void init(Context context) {
    mHeadOriginheight = context.getResources().getDimensionPixelSize(R.dimen.head_height);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    LinearLayout linearLayout = (LinearLayout) getChildAt(0);
    mHeadView = (ImageView) linearLayout.getChildAt(0);
    setOverScrollMode(View.OVER_SCROLL_NEVER);
    smoothScrollTo(0, 0);
  }

  @Override
  protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
      int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

    if (scrollY == 0 && deltaY < 0) {
      //过度下拉
      mHeadView.getLayoutParams().height = mHeadView.getHeight() - deltaY;
      mHeadView.requestLayout();
    } else if (scrollY == scrollRangeY && deltaY > 0) {
      //过度上拉
      if (mHeadView.getHeight() > mHeadOriginheight) {
        mHeadView.getLayoutParams().height = mHeadView.getHeight() - deltaY;
        mHeadView.requestLayout();
      }
    } else {
      //正常情况
      if (deltaY > 0) {
        if (mHeadView.getHeight() > mHeadOriginheight) {
          //当头部的高度大于初始的高度时
          //先停止ScrollView的滑动，直到当前头部高度减小到等于初始高度
          mHeadView.getLayoutParams().height = mHeadView.getHeight() - deltaY;
          mHeadView.requestLayout();
        } else {
          //当头部的高度等于初始的高度时，对ScrollView进行滑动
          super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
              maxOverScrollX, maxOverScrollY, isTouchEvent);
        }
      } else {
        super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
            maxOverScrollX, maxOverScrollY, isTouchEvent);
      }
    }

    return false;
  }

  @Override public boolean onTouchEvent(MotionEvent ev) {
    switch (ev.getAction()) {
      case MotionEvent.ACTION_UP:
        ValueAnimator valueAnimator =
            ValueAnimator.ofFloat(mHeadView.getHeight(), mHeadOriginheight);
        valueAnimator.setDuration(400);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override public void onAnimationUpdate(ValueAnimator animation) {
            float value = (float) animation.getAnimatedValue();
            mHeadView.getLayoutParams().height = (int) value;
            mHeadView.requestLayout();
          }
        });
        valueAnimator.start();
        break;
    }

    return super.onTouchEvent(ev);
  }
}
