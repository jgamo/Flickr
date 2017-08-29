package com.example.t410.flickr;

/**
 * Created by T410 on 27/08/2017.
 */
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import 	android.app.Activity;
import java.util.ArrayList;

   public class AdaptadorCategorias extends BaseAdapter {

       protected Activity activity;
       protected ArrayList<Categorias> items;

       public AdaptadorCategorias (Activity activity, ArrayList<Categorias> items) {
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

       public void addAll(ArrayList<Categorias> categoria) {
           for (int i = 0; i < categoria.size(); i++) {
               items.add(categoria.get(i));
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
               v = inf.inflate(R.layout.lista_personalizada, null);
           }

           Categorias dir = items.get(position);

           TextView title = (TextView) v.findViewById(R.id.category);
           title.setText(dir.getNombre());

           ImageView imagen = (ImageView) v.findViewById(R.id.imageView4);
           imagen.setImageDrawable(dir.getImagen());

           return v;
       }
   }


