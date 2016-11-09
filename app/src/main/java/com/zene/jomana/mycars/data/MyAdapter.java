package com.zene.jomana.mycars.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.zene.jomana.mycars.R;

public class MyAdapter extends ArrayAdapter<MyCar> {
    public MyAdapter(Context context, int resource){
        super(context,resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.activity_my_adapter,parent,false);
        TextView tvType=(TextView)convertView.findViewById(R.id.tvType);
        TextView tvYear=(TextView)convertView.findViewById(R.id.tvYear);
        TextView tvPrice=(TextView)convertView.findViewById(R.id.tvYear);
        final MyCar myCar=getItem(position);
        myCar.setType(myCar.getType());
        myCar.setYear(myCar.getYear());
        myCar.setPrice(myCar.getPrice());
        return convertView;

    }
}
