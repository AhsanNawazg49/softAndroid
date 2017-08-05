package com.infosys.testproject.customAdapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.infosys.testproject.dataModels.MoviesModel;

/**
 * Created by grimReaper on 8/5/2017.
 */

public class MoviesArrayAdapter extends ArrayAdapter {
    Context context;
    int resource;
    MoviesModel[] moviesData;
    public MoviesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull MoviesModel[] moviesData) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.moviesData = moviesData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public int getCount() {
        return moviesData.length;
    }
}
