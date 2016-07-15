package database.repositories;

import database.LocalDatabase;
import database.repositories.callbacks.ItemCreatedCallback;
import database.repositories.callbacks.ItemDeletedCallback;
import models.Blessing;

import java.util.List;

/**
 * Created by blessingorazulume on 7/14/16.
 */
public class BlessingDatabase implements LocalDatabase<Blessing> {


    @Override
    public Blessing getItem(String id) {
        return MockRealm.INSTANCE.getOneBlessing(id);
    }

    @Override
    public void create(Blessing item, ItemCreatedCallback<Blessing> itemCreated) {
        MockRealm.INSTANCE.addToBlessing(item);
        itemCreated.onItemCreated(item);
    }

    @Override
    public void delete(Blessing item, ItemDeletedCallback itemDeletedCallback) {

    }

    @Override
    public void update(Blessing item) {

    }

    @Override
    public List<Blessing> getAll() {
        return null;
    }
}
