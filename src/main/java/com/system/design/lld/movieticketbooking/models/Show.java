package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import com.system.design.lld.common.IdGenerator;

import java.util.Date;

public class Show {
    private String showId;
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private long durationInSeconds;

    public Show() {
        this.showId = IdGenerator.generate("SHID");
    }

    public Show(Movie movie, Screen screen, Date startTime, long durationInSeconds) {
        this();
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
    }

    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(long durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }
}
