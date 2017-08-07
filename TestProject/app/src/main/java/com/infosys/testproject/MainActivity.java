package com.infosys.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.infosys.testproject.customAdapters.MoviesArrayAdapter;
import com.infosys.testproject.dataModels.MoviesModel;

public class MainActivity extends AppCompatActivity {

    ListView listViewMovies;
    MoviesArrayAdapter mMovieAdapter;
    MoviesModel[] mMovieModalData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovieModalData = new MoviesModel[]{new MoviesModel(R.mipmap.ic_launcher,"TITANIC","JOHAN CARRy","5M","10M")};

        listViewMovies  =(ListView) findViewById(R.id.lst_vu_movies);
        mMovieAdapter = new MoviesArrayAdapter(MainActivity.this,R.layout.dummy_row_style_movies,mMovieModalData);
        listViewMovies.setAdapter(mMovieAdapter);


    }
}
