package com.example.oo.doctormbg;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Oo on 08/12/2014.
 */
public class G{
    static void fillSpinner(Spinner spinner,ArrayList<String> listeItems,Activity ctxte){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                ctxte, android.R.layout.simple_spinner_item, listeItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}