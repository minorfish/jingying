package com.test.jingying.datas;

/**
 * Created by guoyumei on 5/3/15.
 */
public class MovieItem {
    private int movieSrcId;
    private String movieTitle;
    private int ranSrcId;
    private String score;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRanSrcId() {
        return ranSrcId;
    }

    public void setRanSrcId(int ranSrcId) {
        this.ranSrcId = ranSrcId;
    }


    public int getMovieSrcId() {
        return movieSrcId;
    }

    public void setMovieSrcId(int movieSrcId) {
        this.movieSrcId = movieSrcId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public MovieItem() {
    }

    public MovieItem(int movieSrcId, int ranSrcId, String movieTitle, String score) {
        this.movieSrcId = movieSrcId;
        this.ranSrcId = ranSrcId;
        this.movieTitle = movieTitle;
        this.score = score;
    }
}
