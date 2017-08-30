package com.example.t410.flickr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ArrayList<Photos> galeria= new ArrayList<>();
        for (int i = 0; i < MainActivity.photos.size(); i++) {
            galeria.add(new Photos(MainActivity.photos.get(i).getId(),MainActivity.photos.get(i).getOwner(),
                    MainActivity.photos.get(i).getUrl(),MainActivity.photos.get(i).getTitle()));
        }
        //TextView tv = (TextView)findViewById(R.id.tv2);
        //tv.setText(galeria.get(0).getId()+"  "+galeria.get(0).getOwner()+"  "+galeria.get(0).getUrl()+"  "+galeria.get(0).getTitle());
        Log.d("LIISTAAA: ", galeria.toString());
        AdaptadorGaleria adaptador = new AdaptadorGaleria(this, galeria);

         GridView grid = (GridView) findViewById(R.id.grid);
         grid.setAdapter(adaptador);
        //adaptador.setDropDownViewResource(android.R.layout.simple_expandable_list_item_1);

        /*ImageView img = (ImageView)findViewById(R.id.imageView);
        String url= "http://embasdenart.weebly.com/uploads/4/0/0/2/40023047/2208230.jpg?250";
        Glide.with(this).load(url).into(img);
        String json = MainActivity.photos.get(0).getId()+"\n"+MainActivity.photos.get(0).getOwner()
                +"\n"+MainActivity.photos.get(0).getTitle();
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(json);*/
    }
}
