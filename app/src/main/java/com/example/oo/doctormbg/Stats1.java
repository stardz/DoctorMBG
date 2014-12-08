package com.example.oo.doctormbg;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.beardedhen.androidbootstrap.BootstrapButton;
/**
 * Created by Vivz on 10/25/13.
 */
public class Stats1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.stats1,container,false);
        BootstrapButton btnMom= (BootstrapButton)v.findViewById(R.id.womBtn);
        BootstrapButton btnChi=(BootstrapButton)v.findViewById(R.id.childBtn);
        btnChi.setBootstrapType("danger");
        btnChi.setLeftIcon("fa-star");
        return v;
    }

}
