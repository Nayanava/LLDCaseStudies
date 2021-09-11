package com.system.design.lld.movieticketbooking.providers;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.models.Seat;
import com.system.design.lld.movieticketbooking.models.Show;

import java.io.*;
import java.util.List;

public interface SeatsLockProvider {
    boolean lockSeats(String userId, Show show, List<Seat> seats);
    boolean unlockSeats(String userId, Show show, List<Seat> seats);
    boolean isAtLeastOneSeatLocked(String userId, Show show, List<Seat> seats);
}
