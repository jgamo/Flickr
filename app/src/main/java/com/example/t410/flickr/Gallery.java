package com.example.t410.flickr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Gallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        //Bundle datos = this.getIntent().getExtras();
        //String json = getIntent().getStringExtra("string");
        String json = MainActivity.photos.get(0).getId()+"\n"+MainActivity.photos.get(0).getOwner()
                +"\n"+MainActivity.photos.get(0).getTitle();
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setText(json);
    }
}
