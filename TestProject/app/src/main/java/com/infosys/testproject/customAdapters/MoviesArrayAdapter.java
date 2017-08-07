package com.infosys.testproject.customAdapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.infosys.testproject.R;
import com.infosys.testproject.dataModels.MoviesModel;

/**
 * Created by grimReaper on 8/5/2017.
 */

public class MoviesArrayAdapter extends ArrayAdapter {
    Context context;
    int resource;
    MoviesModel[] moviesData;
    LayoutInflater mLayoutInflator;
    public MoviesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull MoviesModel[] moviesData) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.moviesData = moviesData;
        mLayoutInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = mLayoutInflator.inflate(resource,null);  //now we have the converted design in java
        ImageView mThumnail =(ImageView) convertView.findViewById(R.id.img_vu_movie_thumbnail);
        TextView  mTitle = (TextView) convertView.findViewById(R.id.txt_vu_movies_title);
        TextView  mSubTitle = (TextView) convertView.findViewById(R.id.txt_vu_movies_subtitle);
        TextView  mLikes = (TextView) convertView.findViewById(R.id.txt_vu_movies_likes);
        TextView  mDislikes = (TextView) convertView.findViewById(R.id.txt_vu_movies_dislikes);

        mTitle.setText(moviesData[position].Title);
        mSubTitle.setText(moviesData[position].SubTitle);
        mLikes.setText(moviesData[position].likes);
        mDislikes.setText(moviesData[position].Dislikes);

      //  mThumnail.setImageResource(context.getResources().getDrawable(moviesData[position].thumnailIds));

        return convertView;
    }

    @Override
    public int getCount() {
        return moviesData.length;
    }
}
