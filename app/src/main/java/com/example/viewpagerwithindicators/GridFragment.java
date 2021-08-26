package com.example.viewpagerwithindicators;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class GridFragment extends Fragment {
    private GridView mGridView;
    private GridAdapter mGridAdapter;
    GridItems[] gridItems={};
    private Activity activity;

    @SuppressLint("ValidFragment")
    public GridFragment(GridItems[] gridItems, Activity activity) {
        this.gridItems = gridItems;
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view;

        view=inflater.inflate(R.layout.grid,container,false);
        mGridView=(GridView) view.findViewById(R.id.gridView);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (activity!=null){
            mGridAdapter=new GridAdapter(activity,gridItems);
            if (mGridView!=null){
                mGridView.setAdapter(mGridAdapter);
            }
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onGridItemClick((GridView)parent,view,position,id);
                }
            });
        }
    }

    private void onGridItemClick(GridView parent, View view, int position, long id) {

        Toast.makeText(activity,
                "Position Clicked"+position+"& Text is:"+gridItems[position].getTitle(),
                Toast.LENGTH_SHORT).show();
    }
}
