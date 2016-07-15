package database;

import database.repositories.callbacks.ItemCreatedCallback;
import database.repositories.callbacks.ItemDeletedCallback;

import java.util.List;

/**
 * Created by blessingorazulume on 7/14/16.
 */
public interface LocalDatabase<T> {
    //get, post, put, delete
    T getItem(String id);
    void create(T item, ItemCreatedCallback<T> itemCreated);

    void delete(T item, ItemDeletedCallback itemDeletedCallback);

    void update(T item);

    List<T> getAll();

}
