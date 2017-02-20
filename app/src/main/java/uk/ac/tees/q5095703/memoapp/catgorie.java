package uk.ac.tees.q5095703.memoapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Invate on 18/02/2017.
 */

public class catgorie {

    private String [] category = {"one","two"};

    public List<String> getCategory(){
        List<String> labels =  Arrays.asList(category);
        return labels;
    }


    public void addCategory(String cat) {
       // category.add(cat);
    }


}
