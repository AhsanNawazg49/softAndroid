package com.infosys.testproject.dataModels;

/**
 * Created by grimReaper on 8/5/2017.
 */

public class MoviesModel {

    public int thumnailIds;
    public String Title;
    public String SubTitle;
    public String LikesTitle;
    public String DislikesTitle;

    public MoviesModel(int thumnailIds, String title, String subTitle, String likesTitle, String dislikesTitle) {
        this.thumnailIds = thumnailIds;
        this.Title = title;
        this.SubTitle = subTitle;
        this.LikesTitle = likesTitle;
        this. DislikesTitle = dislikesTitle;
    }
}
