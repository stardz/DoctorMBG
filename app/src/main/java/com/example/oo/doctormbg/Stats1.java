package com.example.oo.doctormbg;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.XLabels;
import com.github.mikephil.charting.utils.YLabels;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Vivz on 10/25/13.
 */
public class Stats1 extends Fragment /*implements SeekBar.OnSeekBarChangeListener*/ {
    private LineChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.stats1,container,false);
        final BootstrapButton btnMom= (BootstrapButton)v.findViewById(R.id.womBtn);
        final BootstrapButton btnChi=(BootstrapButton)v.findViewById(R.id.childBtn);
        final BootstrapButton btnLog=(BootstrapButton)v.findViewById(R.id.valBtn);
        final Spinner param=(Spinner)v.findViewById(R.id.spinner);
        final Spinner debut=(Spinner)v.findViewById(R.id.spinner2);
        final Spinner fin=(Spinner)v.findViewById(R.id.spinner3);
        final Activity contexte=getActivity();
        G.fillSpinner(param,new ArrayList(Arrays.asList("item1","item2","item3")),contexte);
        G.fillSpinner(debut,new ArrayList(Arrays.asList("1","2","3","4","5","6","7")),contexte);
        G.fillSpinner(fin,new ArrayList(Arrays.asList("1","2","3","4","5","6","7")),contexte);
        btnChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    btnMom.setBootstrapType("default");
                    btnChi.setBootstrapType("success");
                    G.fillSpinner(param,new ArrayList(Arrays.asList("Tall","weight","....")),contexte);
                    G.fillSpinner(debut,new ArrayList(Arrays.asList("1","2","3","4","5","6","...")),contexte);
                    G.fillSpinner(fin,new ArrayList(Arrays.asList("1","2","3","4","5","6","...")),contexte);
            }
        });
        btnMom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChi.setBootstrapType("default");
                btnMom.setBootstrapType("success");
                G.fillSpinner(param,new ArrayList(Arrays.asList("Tall","weight","...")),contexte);
                G.fillSpinner(debut,new ArrayList(Arrays.asList("1","2","3","4","5","6","...")),contexte);
                G.fillSpinner(fin,new ArrayList(Arrays.asList("1","2","3","4","5","6","...")),contexte);
            }
        });
        /*
               ************ Chart ***************
         */

        mChart = (LineChart) v.findViewById(R.id.chart1);
        // if enabled, the chart will always start at zero on the y-axis
        mChart.setStartAtZero(true);

        // disable the drawing of values into the chart
        mChart.setDrawYValues(false);

        mChart.setDrawBorder(false);

        mChart.setDrawLegend(false);

        // no description text
        mChart.setDescription("");
        mChart.setUnit(" $");

        // enable value highlighting
        mChart.setHighlightEnabled(true);

        // enable touch gestures
        mChart.setTouchEnabled(true);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDrawGridBackground(false);
        mChart.setDrawVerticalGrid(false);

      //  Typeface tf = Typeface.createFromAsset(v.getAssets(), "OpenSans-Regular.ttf");
     //   mChart.setValueTypeface(tf);

         XLabels x = mChart.getXLabels();
      //  x.setTypeface(tf);

        YLabels y = mChart.getYLabels();
      //  y.setTypeface(tf);
        y.setLabelCount(5);



        // dont forget to refresh the
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //  mChart.invalidate();
                // add data
                setData(36, 100);
                mChart.animateXY(2000, 2000);
            }
        });


        /**********************************************************************************************/

        return v;
    }
    private void setData(int count, float range) {

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < 36; i++) {
            xVals.add((i) + "");
        }

        ArrayList<Entry> vals1 = new ArrayList<Entry>();

        for (int i = 0; i < 36; i++) {
            float mult = (range + 1);
            float val = (float) (i+10*Math.random()-10*Math.random()) + 20;// + (float)
            // ((mult *
            // 0.1) / 10);
            vals1.add(new Entry(val, i));
        }

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(vals1, "DataSet 1");
        set1.setDrawCubic(true);
        set1.setCubicIntensity(0.2f);
        set1.setDrawFilled(true);
        set1.setDrawCircles(false);
        set1.setLineWidth(2f);
        set1.setCircleSize(5f);
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setColor(Color.rgb(104, 241, 175));

        ArrayList<LineDataSet> dataSets = new ArrayList<LineDataSet>();
        dataSets.add(set1);

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        // set data
        mChart.setData(data);
    }
}
