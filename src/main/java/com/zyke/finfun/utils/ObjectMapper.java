package com.zyke.finfun.utils;

public interface ObjectMapper<T, U> {

    U map(T object);
}
