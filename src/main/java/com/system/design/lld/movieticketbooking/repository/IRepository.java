package com.system.design.lld.movieticketbooking.repository;

import java.io.*;
import java.util.List;
import java.util.function.Function;

public interface IRepository<TObj, TId> {
    void save(TObj entity) throws InvalidObjectException;
    TObj get(TId id);
    boolean update(TObj entity);
    void delete(TId id);
}