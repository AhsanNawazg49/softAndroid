package com.infosys.testproject.dataModels;

/**
 * Created by grimReaper on 8/5/2017.
 */

public class MoviesModel {

    public int thumnailIds;
    public String Title;
    public String SubTitle;
    public String likes;
    public String Dislikes;

    public MoviesModel(int thumnailIds, String title, String subTitle, String likes, String dislikes) {
        this.thumnailIds = thumnailIds;
        this.Title = title;
        this.SubTitle = subTitle;
        this.likes = likes;
        this. Dislikes = dislikes;
    }
}
