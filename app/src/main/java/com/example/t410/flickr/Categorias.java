package com.example.t410.flickr;

import android.graphics.drawable.Drawable;

/**
 * Created by T410 on 27/08/2017.
 */

public class Categorias {
    private String nombre;
    private Drawable d;
    private String catId;

    public Categorias(){
        nombre ="";
        d=null;
    }
    public Categorias(String cId, String nom, Drawable obj){
        catId = cId;
        nombre =nom;
        d=obj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Drawable getImagen() {
        return d;
    }

    public void setImagen(Drawable d) {
        this.d = d;
    }

    public String getCategoryId(){return catId;}

    public void setCategoryId(String categoryId){this.catId = categoryId;}
}
