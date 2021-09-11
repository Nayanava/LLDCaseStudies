package com.system.design.lld.movieticketbooking.repository;
/**
 * @author nayanava
 */

import com.system.design.lld.movieticketbooking.exceptions.InvalidShowException;
import com.system.design.lld.movieticketbooking.models.Show;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InMemoryShowRepository implements IShowRepository{

    private final Map<String, Show> showMap = new HashMap<>();

    @Override
    public void save(Show entity) throws InvalidObjectException {
        showMap.put(entity.getShowId(), entity);
    }

    @Override
    public Show get(String id) {
        if(!showMap.containsKey(id)) {
            throw new InvalidShowException();
        }
        return showMap.get(id);
    }

    @Override
    public boolean update(Show entity) {
        if(!showMap.containsKey(entity.getShowId())) {
            return false;
        }
        showMap.put(entity.getShowId(), entity);
        return true;
    }

    @Override
    public void delete(String s) {
    }
}
