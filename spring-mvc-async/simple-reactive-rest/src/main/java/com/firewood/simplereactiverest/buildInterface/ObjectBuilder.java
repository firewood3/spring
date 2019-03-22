package com.firewood.simplereactiverest.buildInterface;

@FunctionalInterface
public interface ObjectBuilder<T> {
    T build();
}
