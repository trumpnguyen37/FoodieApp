//package com.example.androidproject;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.widget.Toast;
//
//import com.example.androidproject.DRVinterface.LoadMore;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public class DashBoardActivity extends AppCompatActivity {
//
////    private RecyclerView recyclerView;
////    private StaticRvAdapter staticRvAdapter;
////
////    List<DynamicRVModel> items = new ArrayList<>();
////    DynamicRVAdapter dynamicRVAdapter;
////
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_dash_board);
////
////        ArrayList<StaticRvModel> item = new ArrayList<>();
////        item.add(new StaticRvModel(R.drawable.pizza, "pizza"));
////        item.add(new StaticRvModel(R.drawable.pizza, "burger"));
////        item.add(new StaticRvModel(R.drawable.pizza, "fries"));
////        item.add(new StaticRvModel(R.drawable.pizza, "sand witch"));
////        item.add(new StaticRvModel(R.drawable.pizza, "icecream"));
////
////        recyclerView = findViewById(R.id.rv_1);
////        staticRvAdapter = new StaticRvAdapter(item);
////        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
////        recyclerView.setAdapter(staticRvAdapter);
////
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////        items.add(new DynamicRVModel("Burger"));
////
////        RecyclerView drv = findViewById(R.id.rv_2);
////        drv.setLayoutManager(new LinearLayoutManager(this));
////        dynamicRVAdapter = new DynamicRVAdapter(drv,this,items);
////        drv.setAdapter(dynamicRVAdapter);
////        dynamicRVAdapter.setLoadMore(new LoadMore() {
////            @Override
////            public void onLoadMore() {
////                if (items.size()<=10){
////                    item.add(null);
////                    dynamicRVAdapter.notifyItemInserted(items.size()-1);
////                    new Handler().postDelayed(new Runnable() {
////                        @Override
////                        public void run() {
////                            items.remove(items.size()-1);
////                            dynamicRVAdapter.notifyItemRemoved(items.size());
////
////                            int index = items.size();
////                            int end = index+10;
////                            for(int i = index; i<end; i++){
////                                String name = UUID.randomUUID().toString();
////                                DynamicRVModel item = new DynamicRVModel(name);
////                                items.add(item);
////                            }
////                            dynamicRVAdapter.notifyDataSetChanged();
////                            dynamicRVAdapter.setLoaded();
////                        }
////                    },4000);
////                }
////                else
////                    Toast.makeText(DashBoardActivity.this, "Data Completed", Toast.LENGTH_SHORT).show();
////            }
////        });
////    }
//}