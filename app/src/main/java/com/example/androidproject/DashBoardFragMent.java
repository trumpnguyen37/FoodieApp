package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DashBoardFragMent extends Fragment implements UpdateRecyclerView{

    private RecyclerView recyclerView, recyclerView2;
    private StaticRvAdapter staticRvAdapter;

    ArrayList<DynamicRVModel> items = new ArrayList<>();
    DynamicRVAdapter dynamicRVAdapter;
    int pos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_dash_board, container, false);

        final ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.pizzamieng, "pizza"));
        item.add(new StaticRvModel(R.drawable.burger, "burger"));
        item.add(new StaticRvModel(R.drawable.fries, "fries"));
        item.add(new StaticRvModel(R.drawable.sandwich, "sandwich"));
        item.add(new StaticRvModel(R.drawable.icecream, "icecream"));

        recyclerView = root.findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item, getActivity(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);

        items = new ArrayList<>();

        recyclerView2 = root.findViewById(R.id.rv_2);
        dynamicRVAdapter = new DynamicRVAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(dynamicRVAdapter);


        return root;
    }

    @Override
    public void callback(int position, ArrayList<DynamicRVModel> items) {
        dynamicRVAdapter = new DynamicRVAdapter(items);
        dynamicRVAdapter.notifyDataSetChanged();
        recyclerView2.setAdapter(dynamicRVAdapter);


        dynamicRVAdapter.setOnItemClickListner(new DynamicRVAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int position) {
                pos = items.get(position).getPos();

                Intent intent = new Intent(getActivity(), resDetailActivity.class);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        });

    }
}
