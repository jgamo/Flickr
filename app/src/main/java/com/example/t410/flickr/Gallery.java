package com.example.t410.flickr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {
    static String finalUrl="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ArrayList<Photos> galeria= new ArrayList<>();
        for (int i = 0; i < MainActivity.photos.size(); i++) {
            galeria.add(new Photos(MainActivity.photos.get(i).getId(),MainActivity.photos.get(i).getOwner(),
                    obtenerUrl(MainActivity.photos.get(i).getId()),MainActivity.photos.get(i).getTitle()));
        }

        AdaptadorGaleria adaptador = new AdaptadorGaleria(this, galeria);
        GridView grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(adaptador);
    }
    public String obtenerUrl(String imageId){
        String url="https://api.flickr.com/services/rest/?method=flickr.photos.getSizes&api_key=4eed399365e073258f5417bb7154cfc8&photo_id="+imageId+"&format=json&nojsoncallback=1";
        finalUrl="";
        final int SIMPLE_REQUEST = 1;
        RequestQueue queue = Volley.newRequestQueue(this);  // this = context
        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jarr = response.getJSONObject("sizes").getJSONArray("size");
                    finalUrl = jarr.getJSONObject(4).getString("source");

                } catch (JSONException e) {
                    //  e.printStackTrace();
                }
            }
        } , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Procesar VolleyError
            }
        });

        request.setTag(SIMPLE_REQUEST);
        queue.add(request);

        return finalUrl;
    }
}
