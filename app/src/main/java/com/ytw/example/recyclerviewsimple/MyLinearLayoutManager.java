package com.ytw.example.recyclerviewsimple;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ytw on 2017/5/18.
 */

public class MyLinearLayoutManager extends LinearLayoutManager {

  private MyRecyclerView myRecyclerView;

  public MyLinearLayoutManager(Context context) {
    super(context);
  }

  public MyLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
    super(context, orientation, reverseLayout);
  }

  @Override public void onAttachedToWindow(RecyclerView view) {
    super.onAttachedToWindow(view);
    myRecyclerView = (MyRecyclerView) view;
  }

  @Override
  public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {

    // dy<0 手下滑
    // dy>0 手上滑

    //scrollVerticallyBy() 里面调用的是scrollBy()
    //而scrollBy()返回的是实际滑动的距离
    final int scrolled = super.scrollVerticallyBy(dy, recycler, state);
    final int over = dy - scrolled;
    if (over < 0) {
      //过度下滑
      //myRecyclerView.headView.getLayoutParams().height = myRecyclerView.headView.getHeight() - over;
      //myRecyclerView.headView.requestLayout();
    } else if (over > 0) {
      //过度上滑
    } else {
      //正常滑动
      if (dy > 0) {
        //if (myRecyclerView.headView.getHeight() > myRecyclerView.originHeight) {
        //  myRecyclerView.headView.getLayoutParams().height =
        //      myRecyclerView.headView.getHeight() - dy;
        //  myRecyclerView.headView.requestLayout();
        //}
      }
    }
    return scrolled;
  }
}
