package com.ytw.example.recyclerviewsimple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MyRecyclerView recyclerView = (MyRecyclerView) findViewById(R.id.rv_content);

    ImageView headView = (ImageView) findViewById(R.id.iv_head);

    List<String> data = new ArrayList<String>();
    for (int i = 0; i < 20; i++) {
      data.add(i + "");
    }

    MyAdapter adapter = new MyAdapter(data);
    MyLinearLayoutManager linearLayoutManager = new MyLinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setAdapter(adapter);

    recyclerView.setHeadView(headView);
  }
}
