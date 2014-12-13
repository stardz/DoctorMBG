package com.example.oo.doctormbg;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vivz on 10/25/13.
 */
public class Suivi3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.suivi3,container,false);
        View v =inflater.inflate(R.layout.suivi3,container,false);
        ListView lv = (ListView) v.findViewById(R.id.visite_resultat);
        ArrayList<MyResultItem> list = new ArrayList<MyResultItem>();
        list.add(new MyResultItem(1,"CHL","0.5",true));
        list.add(new MyResultItem(2,"ADN","0.5",false));
        list.add(new MyResultItem(3,"IRM","0.7",true));

        final ResultArrayAdapter adapter = new ResultArrayAdapter(getActivity(), list);
        lv.setAdapter(adapter);
        return v;
    }
}

class MyResultItem {
    int id;
    String item;
    String text;
    int drawable;

    public MyResultItem(int id, String item, String text, boolean good) {
        this.id = id;
        this.item = item;
        this.text = text;
        if(good) {
            this.drawable=R.drawable.check521;
        } else {
            this.drawable=R.drawable.close47;
        }

    }
}

class ResultArrayAdapter extends ArrayAdapter<MyResultItem> {
    private final Context context;
    private final ArrayList<MyResultItem> values;

    public ResultArrayAdapter(Context context, ArrayList<MyResultItem> values) {
        super(context, R.layout.element_disscusion, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.visite_result, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        EditText editText = (EditText) rowView.findViewById(R.id.editText);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        textView.setText(values.get(position).item);
        editText.setText(values.get(position).text);
        imageView.setImageResource(values.get(position).drawable);
        return rowView;
    }
}