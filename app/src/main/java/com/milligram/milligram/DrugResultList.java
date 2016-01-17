package com.milligram.milligram;

import com.google.gson.Gson;
import java.util.List;

/**
 * Created by ghost on 1/15/2016.
 */
public class DrugResultList {
    public List<com.milligram.milligram.DrugResult> located_drugs;

    public static DrugResultList fromJson(String s) {
        return new Gson().fromJson(s, DrugResultList.class);
    }
    public String toString() {
        return new Gson().toJson(this);
    }
}
