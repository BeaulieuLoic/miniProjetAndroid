package com.example.mini_projet_android;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class MonAdaptateurDeListe extends ArrayAdapter<String>{
 
    private ArrayList<String> urls_images_pour_la_liste = null;
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
          getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
        View rowView = inflater.inflate(R.layout.list_row, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
 
        if(convertView == null ){
			Picasso.with(rowView.getContext()).load(urls_images_pour_la_liste.get(position)).into(imageView);
        }
        else{
            rowView = (View)convertView;
        }
        return rowView;
    }
 
    public MonAdaptateurDeListe(Context context, ArrayList<String> values) {
        super(context, R.layout.list_row, values);
        this.urls_images_pour_la_liste = values;
    }
}
