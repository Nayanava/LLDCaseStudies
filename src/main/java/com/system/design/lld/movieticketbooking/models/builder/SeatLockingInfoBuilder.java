package com.system.design.lld.movieticketbooking.models.builder;

import com.system.design.lld.movieticketbooking.models.Seat;
import com.system.design.lld.movieticketbooking.models.SeatLockingInfo;

import java.util.Date;

public class SeatLockingInfoBuilder {
        private Seat seat;
        private String showId;
        private Date timeOfLock;
        private long timeToLive;
        public SeatLockingInfoBuilder() {
        }

        public SeatLockingInfoBuilder setSeat(Seat seat) {
            this.seat = seat;
            return this;
        }

        public SeatLockingInfoBuilder setShowId(String showId) {
            this.showId = showId;
            return this;
        }

        public SeatLockingInfoBuilder setTimeOfLock(Date timeOfLock) {
            this.timeOfLock = timeOfLock;
            return this;
        }

        public SeatLockingInfoBuilder setTimeToLive(long timeToLive) {
            this.timeToLive = timeToLive;
            return this;
        }
        public SeatLockingInfo build() {
            return new SeatLockingInfo(this.seat, this.showId, this.timeOfLock, 60000);
        }
    }