package com.example.oo.doctormbg;

import android.app.LauncherActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        final TextView tv = (TextView) v.findViewById(R.id.textView_info);
        tv.setText( "Last Name : "+"Belkadi\n"+
                    "First Name : "+" Zohra\n"+
                    "Birth Date : "+"12/11/1979\n"+
                    "ID : "+"1565152757\n"+
                    "Begin Date : "+"15/11/2014");
        final ListView lv = (ListView) v.findViewById(R.id.discussion);
        final ArrayList<MyListItem> list = new ArrayList<MyListItem>();
        LauncherActivity.ListItem l1 = new LauncherActivity.ListItem();

        list.add(new MyListItem("Belkadi Zohra",R.drawable.ic_user,tv));
        list.add(new MyListItem("Hadji Samira",R.drawable.ic_user,tv));
        list.add(new MyListItem("NAME",R.drawable.ic_user,tv));
        list.add(new MyListItem("NAME",R.drawable.ic_user,tv));
        list.add(new MyListItem("NAME",R.drawable.ic_user,tv));
        list.add(new MyListItem("NAME",R.drawable.ic_user,tv));
        list.add(new MyListItem("NAME",R.drawable.ic_user,tv));

        Log.d("debugging", list.toString());
        final MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(getActivity(), list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition= position;

                // Show Alert
                /*Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();*/
                switch(itemPosition) {
                    case 0:
                        tv.setText( "Last Name : "+"Belkadi\n"+
                                "First Name : "+" Zohra\n"+
                                "Birth Date : "+"12/11/1979\n"+
                                "ID : "+"1565152757\n"+
                                "Begin Date : "+"15/11/2014");
                        break;
                    case 1:
                        tv.setText( "Last Name : "+"Hadji\n"+
                                "First Name : "+" Zohra\n"+
                                "Birth Date : "+"10/01/1977\n"+
                                "ID : "+"1565465456457\n"+
                                "Begin Date : "+"16/10/2014");
                        break;
                    case 2:
                        tv.setText( "Last Name : "+"name\n"+
                                "First Name : "+" name\n"+
                                "Birth Date : "+"12/11/1979\n"+
                                "ID : "+"1565152757\n"+
                                "Begin Date : "+"15/11/2014");
                        break;
                    default:
                        tv.setText( "Last Name : "+"name\n"+
                                "First Name : "+" name\n"+
                                "Birth Date : "+"12/11/1979\n"+
                                "ID : "+"1565152757\n"+
                                "Begin Date : "+"15/11/2014");
                        break;
                }

            }

        });



        return v;
    }
}

class MyListItem {
    String text;
    int drawable;
    TextView tv;

    public MyListItem(String text, int drawable, TextView tv) {
        this.text = text;
        this.drawable=drawable;
        this.tv = tv;
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
        TextView textView2 = (TextView) rowView.findViewById(R.id.line);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        textView2.setText(values.get(position).text);
        imageView.setImageResource(values.get(position).drawable);
        Log.d("debugging", position + "  " );
        return rowView;
    }

    public void add(MyListItem mli) {
        this.values.add(mli);
    }
}