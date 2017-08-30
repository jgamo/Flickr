package com.example.t410.flickr;

/**
 * Created by T410 on 29/08/2017.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class AdaptadorGaleria extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Photos> items;

    public AdaptadorGaleria (Activity activity, ArrayList<Photos> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Photos> gallery) {
        for (int i = 0; i < gallery.size(); i++) {
            items.add(gallery.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item, null);
        }

        Photos dir = items.get(position);
        ImageView imagen = (ImageView) v.findViewById(R.id.imagenItem);
        //String url= "http://embasdenart.weebly.com/uploads/4/0/0/2/40023047/2208230.jpg?250";
        Glide.with(imagen.getContext()).load(dir.getUrl()).crossFade().centerCrop().placeholder(R.drawable.f).into(imagen);
        Toast.makeText(imagen.getContext(), dir.getUrl(), Toast.LENGTH_SHORT).show();
        return v;
    }
}

