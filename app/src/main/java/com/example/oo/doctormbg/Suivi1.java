package com.example.oo.doctormbg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        ArrayList<MyListItem> list = new ArrayList<MyListItem>();
        list.add(new MyListItem(1,"Belkadi Zohra","pourquoi ......... ",R.drawable.ic_user));
        list.add(new MyListItem(2,"Belkadi Zohra","pourquoi ......... ",R.drawable.ic_user));
        list.add(new MyListItem(3,"Dr. Hawas Salah","il faut  ......... ",R.drawable.ic_user));

        final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), list);
        lv.setAdapter(adapter);
        return v;
    }
}

class MyListItem {
    int id;
    String name;
    String text;
    int drawable;

    public MyListItem(int id, String name, String text, int drawable) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.drawable=drawable;
    }
}

 class MySimpleArrayAdapter extends ArrayAdapter<MyListItem> {
    private final Context context;
    private final ArrayList<MyListItem> values;

    public MySimpleArrayAdapter(Context context, ArrayList<MyListItem> values) {
        super(context, R.layout.element_disscusion, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_disscusion, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
        TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon_dis);
        textView.setText(values.get(position).name);
        textView2.setText(values.get(position).text);
        imageView.setImageResource(values.get(position).drawable);
        return rowView;
    }
}