package com.example.t410.flickr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

import android.support.v4.content.res.ResourcesCompat;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
        static ArrayList<Photos> photos = new ArrayList<>();
        static int cont = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        final ArrayList<Categorias> category = new ArrayList<>();
        category.add(new Categorias("1971337@N20","Animales", ResourcesCompat.getDrawable(getResources(), R.drawable.img, null)));
        category.add(new Categorias("467432@N21","Playas", ResourcesCompat.getDrawable(getResources(), R.drawable.beach, null)));
        category.add(new Categorias("662057@N24","Paisajes", ResourcesCompat.getDrawable(getResources(), R.drawable.skyview, null)));
        category.add(new Categorias("48025892@N00","Comidas", ResourcesCompat.getDrawable(getResources(), R.drawable.food, null)));
        category.add(new Categorias("53326846@N00","Bandera", ResourcesCompat.getDrawable(getResources(), R.drawable.flag, null)));

        AdaptadorCategorias adaptador = new AdaptadorCategorias(this, category);
        Spinner categorias = (Spinner)findViewById(R.id.spinner);
        categorias.setAdapter(adaptador);
        categorias.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                        if(cont==0){
                            cont++;
                        } else {
                            String url = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=4eed399365e073258f5417bb7154cfc8&text="+category.get(position).getNombre()+"&per_page=2&format=json&nojsoncallback=1";
                            llamarJson(url);
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.d("Seleccionado: nada", "No seleccionado" );
                        Toast.makeText(getApplicationContext(), "No Seleccionado:", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void llamarJson(String url) {
        final int SIMPLE_REQUEST = 1;
        RequestQueue queue = Volley.newRequestQueue(this);  // this = context
        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(getApplicationContext(), "Respuesta :"+ response.toString(), Toast.LENGTH_SHORT).show();
                //Log.d("Respuesta", response.toString());
                try {
                    JSONArray jarr = response.getJSONObject("photos").getJSONArray("photo");
                    for (int i = 0; i < jarr.length(); i++) {
                        photos.add(new Photos(jarr.getJSONObject(i).getString("id"),jarr.getJSONObject(i).getString("owner"),
                                "",jarr.getJSONObject(i).getString("title")));
                    }
                    Intent act = new Intent(MainActivity.this, Gallery.class);
                    startActivity(act);

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
    }
}


