package com.example.arnau.minim2_arnaunisarre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class llistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llista);

        API.getInstance().api.getBooks().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {
                if (response.isSuccessful()){
                    final List<Books>  bookArray = response.body();
                    final ListView lv = (ListView) findViewById(R.id.books_list);
                    BookArrayAdapter uaa = new BookArrayAdapter(getApplicationContext(), bookArray);
                    lv.setAdapter(uaa);
                   ProgressBar pb = (ProgressBar)findViewById(R.id.loading);
                    pb.setVisibility(View.INVISIBLE);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent i = new Intent(getApplicationContext(), DetallBook.class);



                            Books u = bookArray.get(position);
                            String a= u.get_id();


                            i.putExtra("id", u.get_id());

                            startActivity(i);

                        }
                    });

                }
            }



            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No connection", Toast.LENGTH_LONG).show();
                ProgressBar pb = (ProgressBar)findViewById(R.id.loading);
                pb.setVisibility(View.INVISIBLE);
            }
        });




    }
}
