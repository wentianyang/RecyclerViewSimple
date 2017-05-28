package com.ytw.example.recyclerviewsimple;

/**
 * Created by Administrator on 2017/5/28.
 */

public class Item {
  static final int TYPE_TITLE = 1;
  static final int TYPE_CONTENT = 2;

  int type;
  String content;
  String color;
  int spanSize = 1;

  public Item(int type, String color, int spanSize) {
    this.type = type;
    this.color = color;
    this.spanSize = spanSize;

    if (type == TYPE_TITLE) {
      content = "标题 - " + color;
    } else {
      content = "子项 - " + color;
    }
  }
}
