package com.system.design.lld.movieticketbooking.service;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.models.Seat;
import com.system.design.lld.movieticketbooking.models.SeatState;
import com.system.design.lld.movieticketbooking.models.Show;
import com.system.design.lld.movieticketbooking.providers.SeatsLockProvider;
import com.system.design.lld.movieticketbooking.repository.IShowRepository;
import com.system.design.lld.movieticketbooking.repository.InMemoryShowRepository;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ShowService {

    IShowRepository showRepository;
    SeatsLockProvider seatsLockProvider;

    public ShowService(IShowRepository showRepository,
                       SeatsLockProvider seatsLockProvider) {
        this.showRepository = showRepository;
        this.seatsLockProvider = seatsLockProvider;
    }

    public Show getShowDetails(String showId) {
        return showRepository.get(showId);
    }

    public boolean seatsAvailable(String userId, Show show, List<Seat> seats) {
        if(seatsLockProvider.isAtLeastOneSeatLocked(userId, show, seats)) {
            return false;
        }
        if(atLeastOneSeatIsPermanentlyUnavailable(show, seats)) {
            return false;
        }
        return true;
    }

    public boolean atLeastOneSeatIsPermanentlyUnavailable(Show show, List<Seat> seats) {
        Set<Seat> availableSeats = show.getScreen()
                .getSeatingArrangement()
                .getSeats()
                .stream()
                .filter(seat -> seat.getSeatState() == SeatState.AVAILABLE)
                .collect(Collectors.toSet());
        for(var seat : seats) {
            if(!availableSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }
}
