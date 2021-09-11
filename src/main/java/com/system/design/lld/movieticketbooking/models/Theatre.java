package com.system.design.lld.movieticketbooking.models;
/**
 * @author nayanava
 */

import com.system.design.lld.common.IdGenerator;

import java.util.List;

public class Theatre {
    private String theatreId;
    private String theatreName;
    private List<Screen> screens;

    public Theatre() {
        this.theatreId = IdGenerator.generate("THID");
    }

    public Theatre(String theatreName, List<Screen> screens) {
        this();
        this.theatreName = theatreName;
        this.screens = screens;
    }
}
