package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import com.system.design.lld.common.IdGenerator;

public class Movie {
    private String movieId;
    private String movieName;

    public Movie() {
        this.movieId = IdGenerator.generate("MVID");
    }

    public Movie(String movieName) {
        this();
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
