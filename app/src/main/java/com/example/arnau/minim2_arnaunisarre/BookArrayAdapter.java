package com.example.arnau.minim2_arnaunisarre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookArrayAdapter extends ArrayAdapter<Books> {
    public BookArrayAdapter(@NonNull Context context, List<Books> resource) {
        super(context, 0,resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Books u = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.book_layout, parent, false);
        }
        Picasso.with(super.getContext()).load("http://api.dsamola.tk/imagen.jpeg").into((ImageView) convertView.findViewById(R.id.avatar_image));
        TextView et = (TextView)convertView.findViewById(R.id.username_txt);
        et.setText(u.getTitle());
        return convertView;
    }
}
