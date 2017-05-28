package com.ytw.example.recyclerviewsimple;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by ytw on 2017/5/18.
 */

public class MyRecyclerView extends RecyclerView {

  public MyRecyclerView(Context context) {
    super(context);
  }

  public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  @Override protected void onMeasure(int widthSpec, int heightSpec) {
    int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
    super.onMeasure(widthSpec, expandSpec);
  }
}
