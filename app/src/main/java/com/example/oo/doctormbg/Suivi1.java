package com.example.oo.doctormbg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Vivz on 10/25/13.
 */
public class Suivi1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.suivi1,container,false);
        TextView tv = (TextView) v.findViewById(R.id.textView_info);
        tv.setText( "Nom : "+"Belkadi\n"+
                    "Prenom : "+" Zohra\n"+
                    "Date de naissance : "+"12/11/1979\n"+
                    "NSS : "+"1565152757\n"+
                    "date debut : "+"15/11/2014");
        ListView lv = (ListView) v.findViewById(R.id.discussion);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                return null;
            }
        });
        return v;
    }
}
