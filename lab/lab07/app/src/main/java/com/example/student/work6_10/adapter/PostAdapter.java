package com.example.student.work6_10.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.student.work6_10.MainActivity;
import com.example.student.work6_10.R;

/**
เป็นแหล่งข้อมูลอ่ะ
 */

class Holder extends RecyclerView.ViewHolder{

    public ImageView image;

    public Holder(View itemView){
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.image);
    }

}



public class PostAdapter extends RecyclerView.Adapter<Holder>{
    String[] data = {
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/04.jpg",
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/05.jpg",
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/06.jpg",
            "https://raw.githubusercontent.com/iangkub/gitdemo/master/cartoon/07.jpg"
    };

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    private  Context context;
    public PostAdapter(Context context) {
        this.context = context;
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.post_item, null, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ImageView image = holder.image;
        Glide.with(context).load(data[position]).into(image);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
