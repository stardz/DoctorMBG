package com.example.oo.doctormbg;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Legend;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.YLabels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Vivz on 10/25/13.
 */
public class Stats2 extends Fragment implements OnChartValueSelectedListener {
    private ScatterChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.stats2,container,false);
        final BootstrapButton btnMom= (BootstrapButton)v.findViewById(R.id.womBtn);
        final BootstrapButton btnChi=(BootstrapButton)v.findViewById(R.id.childBtn);
        final BootstrapButton btnVal=(BootstrapButton)v.findViewById(R.id.valBtn);
        final Spinner param=(Spinner)v.findViewById(R.id.spinner);
        final Spinner debut=(Spinner)v.findViewById(R.id.spinner2);
        final Activity contexte=getActivity();
        G.fillSpinner(param,new ArrayList(Arrays.asList("height", "Weight", "item3","...")),contexte);
        G.fillSpinner(debut,new ArrayList(Arrays.asList("height", "Weight", "item3","...")),contexte);
        btnChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMom.setBootstrapType("default");
                btnChi.setBootstrapType("success");
                G.fillSpinner(param,new ArrayList(Arrays.asList("height", "Weight", "item3","...")),contexte);
                G.fillSpinner(debut,new ArrayList(Arrays.asList("height", "Weight", "item3","...")),contexte);
            }
        });
        btnMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChi.setBootstrapType("default");
                btnMom.setBootstrapType("success");
                G.fillSpinner(param,new ArrayList(Arrays.asList("height", "Weight", "blood sugar","...")),contexte);
                G.fillSpinner(debut,new ArrayList(Arrays.asList("height", "Weight", "blood sugar","...")),contexte);
            }
        });
        /*
             Scatter
         */

        mChart = (ScatterChart) v.findViewById(R.id.chart1);
        mChart.setDescription("");

        //   Typeface tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        // mChart.setValueTypeface(tf);

        mChart.setOnChartValueSelectedListener(this);

        mChart.setDrawGridBackground(false);

        mChart.setTouchEnabled(true);
        mChart.setHighlightEnabled(true);
        mChart.setDrawYValues(false);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        mChart.setMaxVisibleValueCount(200);
        mChart.setPinchZoom(true);


       // Legend l = mChart.getLegend();
        //l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        //      l.setTypeface(tf);

        YLabels yl = mChart.getYLabels();
        //  yl.setTypeface(tf);

        XLabels xl = mChart.getXLabels();
//        xl.setTypeface(tf);
        btnVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onChanged();
            }
        });
        return v;
    }
    public void onChanged() {


        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            xVals.add((i) + "");
        }

        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < 50; i++) {
                float val = (float) (i+(Math.random()*10%5)-(Math.random()*10%5)) + 10;
                yVals1.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        ScatterDataSet set1 = new ScatterDataSet(yVals1, "DS 1");
        set1.setScatterShape(ScatterChart.ScatterShape.SQUARE);
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0]);


        set1.setScatterShapeSize(8f);

        ArrayList<ScatterDataSet> dataSets = new ArrayList<ScatterDataSet>();
        dataSets.add(set1); // add the datasets


        // create a data object with the datasets
        ScatterData data = new ScatterData(xVals, dataSets);

        mChart.setData(data);
        mChart.invalidate();
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex) {
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex
        );
    }

    @Override
    public void onNothingSelected() {

    }

}