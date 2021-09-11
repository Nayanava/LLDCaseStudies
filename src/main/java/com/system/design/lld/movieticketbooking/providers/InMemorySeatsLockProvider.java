package com.system.design.lld.movieticketbooking.providers;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.exceptions.SeatTemporarilyUnavailableException;
import com.system.design.lld.movieticketbooking.models.Seat;
import com.system.design.lld.movieticketbooking.models.SeatLockingInfo;
import com.system.design.lld.movieticketbooking.models.Show;
import com.system.design.lld.movieticketbooking.models.builder.SeatLockingInfoBuilder;

import java.util.*;

public class InMemorySeatsLockProvider implements SeatsLockProvider {

    private Map<String, Map<Seat, SeatLockingInfo>> locks;

    public InMemorySeatsLockProvider(Map<String, Map<Seat, SeatLockingInfo>> locks) {
        this.locks = locks;
    }

    @Override
    public boolean lockSeats(String userId, Show show, List<Seat> seats) {
        synchronized (show.getShowId()) {
            if( !locks.containsKey(show.getShowId()) ) {
                locks.put(show.getShowId(), new HashMap<>());
            } else {
                if(isAtLeastOneSeatLocked(userId, show, seats)) {
                    throw new SeatTemporarilyUnavailableException();
                }
            }
            this.createLockOnSeats(show, seats);
        }
        return true;
    }

    @Override
    public boolean unlockSeats(String userId, Show show, List<Seat> seats) {
        return false;
    }

    @Override
    public boolean isAtLeastOneSeatLocked(String userId, Show show, List<Seat> seats) {
        return seats.stream()
                .anyMatch(seat ->  {
                        if(!locks.getOrDefault(show.getShowId(), new HashMap<>()).containsKey(seat)) {
                            return false;
                        }
                        var seatLockingInfo = locks.get(show.getShowId()).get(seat);
                        return System.currentTimeMillis() < seatLockingInfo.getTimeOfLock().getTime() + seatLockingInfo.getTimeToLive();
                        //TODO:: remove the SeatLockingInfo which has expired TTL from the map
                    });
    }

    private void createLockOnSeats(Show show, List<Seat> seats) {
        var lockReference = locks.get(show.getShowId());

        for(Seat seat : seats) {
            lockReference.putIfAbsent(seat, new SeatLockingInfoBuilder()
                    .setSeat(seat)
                    .setShowId(show.getShowId())
                    .setTimeOfLock(new Date(System.currentTimeMillis()))
                    .build());
        }
    }
}
