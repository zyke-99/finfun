package com.zyke.finfun.mapper;

public interface ObjectMapper<T, U> {

    U map(T object);
}
