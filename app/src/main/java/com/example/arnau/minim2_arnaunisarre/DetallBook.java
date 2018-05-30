package com.example.arnau.minim2_arnaunisarre;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetallBook extends AppCompatActivity {


    private TextView id;
    private TextView author;
    private TextView title;
    private TextView description;

    public static String identificador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall_book);

        Intent i = this.getIntent();
        identificador = i.getStringExtra("id");


        API.getInstance().api.getId(identificador).enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {

                ProgressBar pb = (ProgressBar)findViewById(R.id.loading);
                pb.setVisibility(View.INVISIBLE);
                if (response.isSuccessful()){

                    Books u = (Books) response.body();

                    author = (TextView)findViewById(R.id.author_txt);
                    author.setText(u.getAuthor());
                    title = (TextView)findViewById(R.id.title_text);
                    title.setText(u.getAuthor());
                    description = (TextView)findViewById(R.id.description_text);
                    description.setText(u.getDescription());
                    id = (TextView)findViewById(R.id.id_text);
                    id.setText(u.get_id());
                    Picasso.with(getApplicationContext()).load("http://api.dsamola.tk/imagen.jpeg").into((ImageView) findViewById(R.id.image));
                }
            }

            @Override
            public void onFailure(Call<Books> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No connection", Toast.LENGTH_LONG).show();
                ProgressBar pb = (ProgressBar)findViewById(R.id.loading);
                pb.setVisibility(View.INVISIBLE);
            }
        });
    }
}
