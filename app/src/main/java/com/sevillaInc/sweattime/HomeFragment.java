package com.sevillaInc.sweattime;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sevillaInc.sweattime.workexcercise.StartWorkAct_I;
import com.sevillaInc.sweattime.workexcercise.StartWorkAct_II;
import com.sevillaInc.sweattime.workexcercise.StartWorkAct_III;
import com.sevillaInc.sweattime.workexcercise.StartWorkAct_IV;

import java.text.SimpleDateFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View vista;
    private LinearLayout fitones;
    private LinearLayout fitII;
    private LinearLayout fitIII;
    private LinearLayout fitIV;
    private LinearLayout fitV;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_home, container, false);

        fitones =(LinearLayout)vista.findViewById(R.id.fitone);
        fitII=(LinearLayout)vista.findViewById(R.id.fittwo);
        fitIII=(LinearLayout)vista.findViewById(R.id.fitthree);
        fitIV=(LinearLayout)vista.findViewById(R.id.fitfour);
        fitV=(LinearLayout)vista.findViewById(R.id.fitfive);

        fitones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), StartWorkAct.class);
                startActivityForResult(intent, 0);
            }
        });
        fitII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), StartWorkAct_I.class);
                startActivityForResult(intent, 0);
            }
        });
        fitIII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), StartWorkAct_II.class);
                startActivityForResult(intent, 0);
            }
        });
        fitIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), StartWorkAct_III.class);
                startActivityForResult(intent, 0);
            }
        });
        fitV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), StartWorkAct_IV.class);
                startActivityForResult(intent, 0);
            }
        });

        //actualizacion de la fecha
        TextView tdate = (TextView)vista.findViewById(R.id.date);
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM");
        String dateString = sdf.format(date);
        tdate.setText(dateString);

        return vista;
    }
}

        /*
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(0);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = (TextView)vista.findViewById(R.id.date);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM");
                                String dateString = sdf.format(date);
                                tdate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();*/