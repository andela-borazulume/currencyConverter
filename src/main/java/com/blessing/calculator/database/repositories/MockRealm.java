package com.blessing.calculator.database.repositories;

import com.blessing.calculator.models.Blessing;

import java.util.ArrayList;

/**
 * Created by blessingorazulume on 7/14/16.
 */
public enum MockRealm {
    INSTANCE;

    private ArrayList<Blessing> allBlessings = new ArrayList<Blessing>();

    protected boolean addToBlessing(Blessing blessing) {
        if(blessing != null){
            allBlessings.add(blessing);

            return true;
        }

        return false;
    }

    protected Blessing getOneBlessing(String name){
      Blessing foundBlessing = itContains(name);
        if(foundBlessing != null)
            return foundBlessing;
        return null;
    }

    public boolean deleteBlessing(){
        //I can't delete blessing
        return false;
    }

    private Blessing itContains(String name){
        //yes id is better but am lazy
        for(Blessing blessing: allBlessings){
            if(blessing.getName().equals(name))

                return blessing;
        }

        return null;
    }
}
