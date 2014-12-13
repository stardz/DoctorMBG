package com.example.oo.doctormbg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Vivz on 10/25/13.
 */
public class Suivi2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.suivi2,container,false);
        Spinner s =(Spinner) v.findViewById(R.id.spinner);
        final ArrayList<String> list = new ArrayList<String>();
        list.add("CHL");
        list.add("SQL");
        list.add("PGC");
        G.fillSpinner(s,list,getActivity());
        s.setSelection(0,false);
        final TextView tv =(TextView) v.findViewById(R.id.graphTitle);
                        tv.setText("evolution de la moyenne du parametre");
        return v;
    }
}
