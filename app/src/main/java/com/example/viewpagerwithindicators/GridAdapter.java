package com.example.viewpagerwithindicators;

import android.content.Context;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    Context context;

    int images[]={
            R.drawable.image1,
            R.drawable.image4,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image3,
            R.drawable.image5,
            R.drawable.image3,
            R.drawable.image4,
    };

    public class ViewHolder{
        public ImageView imageView;
        public TextView textTitle;
    }
    private GridItems[] items;
    private LayoutInflater mInflater;


    public GridAdapter(Context context,GridItems[] locations){
        mInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context=context;
        items=locations;

    }

    public GridItems[] getItems() {
        return items;
    }

    public void setItems(GridItems[] items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items!= null){
            return items.length;
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (items!=null && position>=0 && position < getCount()){
            return items[position];
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (items!=null && position>=0 && position < getCount()){
            return items[position].getId();
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        ViewHolder viewHolder;
        if(view==null){
            view=mInflater.inflate(R.layout.custom,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView) view.findViewById(R.id.grid_item_image);
            viewHolder.textTitle=(TextView) view.findViewById(R.id.grid_item_label);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) view.getTag();
        }
        GridItems gridItems=items[position];
        setCatImage(position,viewHolder,gridItems.getTitle());

        return view;
    }

    private void setCatImage(int position, ViewHolder viewHolder, String title) {
        viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textTitle.setText(title);

    }
}
