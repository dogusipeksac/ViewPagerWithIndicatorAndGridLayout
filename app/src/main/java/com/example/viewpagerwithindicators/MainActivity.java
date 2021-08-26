package com.example.viewpagerwithindicators;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends FragmentActivity {

    public PageIndicator mIndicator;
    private ViewPager awesomePager;
    private PagerAdapter pagerAdapter;

    ArrayList<Category> categoryArrayList;
    String imageNames[]={
            "image1",
            "image2",
            "image3",
            "image4",
            "image5",
            "image6",
            "image7",
            "image2",
            "image3",
            "image4",
            "image2",
            "image3",
            "image4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        awesomePager=(ViewPager) findViewById(R.id.pager);
        mIndicator=(PageIndicator) findViewById(R.id.pagerIndicator);
        ArrayList<String> list=new ArrayList<String>();
        Category category=new Category();
        for(int i=0;i<imageNames.length;i++){
            list.add(i,imageNames[i]);
            category.name=list.get(i);
        }
        categoryArrayList=new ArrayList<Category>();
        categoryArrayList.add(category);
        Iterator<String> it=list.iterator();
        List<GridFragment> gridFragmentList=new ArrayList<GridFragment>();
        int i=0;
        while (it.hasNext()){
            ArrayList<GridItems> imlst=new ArrayList<GridItems>();
            GridItems itm=new GridItems(0,it.next());
            imlst.add(itm);
            i=i+1;

            if(it.hasNext()){
                GridItems itm1=new GridItems(1,it.next());
                imlst.add(itm);
                i=i+1;
            }
            if(it.hasNext()){
                GridItems itm2=new GridItems(2,it.next());
                imlst.add(itm2);
                i=i+1;
            }
            if(it.hasNext()){
                GridItems itm3=new GridItems(3,it.next());
                imlst.add(itm3);
                i=i+1;
            }
            GridItems[] gp={};
            GridItems[] gridPage=imlst.toArray(gp);
            gridFragmentList.add(new GridFragment(gridPage,MainActivity.this));
        }
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),gridFragmentList);
        awesomePager.setAdapter(pagerAdapter);
        mIndicator.setViewPager(awesomePager);

    }

    private class PagerAdapter extends FragmentPagerAdapter{

        private List<GridFragment> fragments;

        public PagerAdapter(FragmentManager fm, List<GridFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}