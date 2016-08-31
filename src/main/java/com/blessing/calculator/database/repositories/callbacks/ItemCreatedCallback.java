package com.blessing.calculator.database.repositories.callbacks;

/**
 * Created by blessingorazulume on 7/15/16.
 */
public interface ItemCreatedCallback<T> {
    void onItemCreated(T item);
}
