package com.ytw.example.recyclerviewsimple;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by ytw on 2017/5/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

  private List<Item> mData;

  public MyAdapter(List<Item> data) {
    this.mData = data;
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
    MyViewHolder viewHolder = new MyViewHolder(view);
    return viewHolder;
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.mTextView.setText(mData.get(position).content);
    holder.mTextView.setBackgroundColor(Color.parseColor(mData.get(position).color));
  }

  @Override public int getItemCount() {
    return mData.size();
  }

  static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView mTextView;

    public MyViewHolder(View itemView) {
      super(itemView);
      mTextView = (TextView) itemView.findViewById(R.id.tv_content);
    }
  }
}
