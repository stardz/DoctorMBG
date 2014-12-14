package com.example.oo.doctormbg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
        tv.setText( "Last Name : "+"Belkadi\n"+
                    "First Name : "+" Zohra\n"+
                    "Birth Date : "+"12/11/1979\n"+
                    "ID : "+"1565152757\n"+
                    "Begin Date : "+"15/11/2014");
        ListView lv = (ListView) v.findViewById(R.id.discussion);
        ArrayList<MyListItem> list = new ArrayList<MyListItem>();
        list.add(new MyListItem(1,"Belkadi Zohra","why is it so .............. ........................... ......... v v vv v v v .................. ......... ......... .................. ......... ......... ",R.drawable.ic_user));
        list.add(new MyListItem(2,"Belkadi Zohra","How can I ......... ",R.drawable.ic_user));
        list.add(new MyListItem(3,"Dr. Hawas Salah","you have to  ......... ",R.drawable.ic_user));
        Log.d("debugging", list.toString());
        final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), list);
        lv.setAdapter(adapter);
        adapter.add(new MyListItem(3,"Dr. Hawas Salah","or you can  ......... ",R.drawable.ic_user));
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
        Log.d("debugging", values.toString());
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_disscusion, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
        TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView.setText(values.get(position).name);
        textView2.setText(values.get(position).text);
        imageView.setImageResource(values.get(position).drawable);
        Log.d("debugging", position + "  " );
        return rowView;
    }

    public void add(MyListItem mli) {
        this.values.add(mli);
    }
}