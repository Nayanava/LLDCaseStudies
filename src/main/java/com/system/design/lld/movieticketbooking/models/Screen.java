package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import com.system.design.lld.common.IdGenerator;

public class Screen {
    private String screenId;
    private SeatingArrangement seatingArrangement;
    private Theatre theatre;

    public Screen() {
        this.screenId = IdGenerator.generate("SCID");
    }

    public Screen( SeatingArrangement seatingArrangement, Theatre theatre) {
        this();
        this.seatingArrangement = seatingArrangement;
        this.theatre = theatre;
    }

    public String getScreenId() {
        return screenId;
    }

    public SeatingArrangement getSeatingArrangement() {
        return seatingArrangement;
    }

    public void setSeatingArrangement(SeatingArrangement seatingArrangement) {
        this.seatingArrangement = seatingArrangement;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
