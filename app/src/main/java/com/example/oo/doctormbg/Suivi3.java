package com.example.oo.doctormbg;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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


        final CharSequence[] items = {"add a visit", "pLan a visit"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick a choice");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                Log.d("debugging","item : "+ item+"");
                switch(item) {
                    case 0: // add
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        // Get the layout inflater
                        LayoutInflater inflater = getActivity().getLayoutInflater();

                        View v = inflater.inflate(R.layout.add_visite, null);
                        // Inflate and set the layout for the dialog
                        // Pass null as the parent view because its going in the dialog layout
                        builder.setView(v)
                                // Add action buttons
                                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        // sign in the user ...

                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //LoginDialogFragment.this.getDialog().cancel();
                                    }
                                });
                        builder.create();
                        builder.show();
                        break;
                    case 1: // plan
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                        // Get the layout inflater
                        LayoutInflater inflater2 = getActivity().getLayoutInflater();

                        View v2 = inflater2.inflate(R.layout.add_visite, null);
                        ((TextView) v2.findViewById(R.id.title2)).setText("Plan a visit");
                        // Inflate and set the layout for the dialog
                        // Pass null as the parent view because its going in the dialog layout
                        builder2.setView(v2)
                                // Add action buttons
                                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        // sign in the user ...

                                    }
                                })
                                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //LoginDialogFragment.this.getDialog().cancel();
                                    }
                                });
                        builder2.create();
                        builder2.show();
                        break;
                }
            }
        });
        ImageButton b = (ImageButton) v.findViewById(R.id.imageButton3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

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