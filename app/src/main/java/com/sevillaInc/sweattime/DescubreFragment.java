package com.sevillaInc.sweattime;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DescubreFragment extends Fragment {

    private ImageView imageView;
    private ImageView di;
    private ImageView dii;
    private ImageView diii;
    private ImageView div;
    private ImageView dv;
    private ImageView dvi;
    private ImageView dvii;
    private ImageView dviii;
    private View vist;

    public DescubreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vist =inflater.inflate(R.layout.fragment_descubre, container, false);

        imageView= (ImageView)vist.findViewById(R.id.imageView);
        di= (ImageView)vist.findViewById(R.id.d_I);
        dii= (ImageView)vist.findViewById(R.id.d_II);
        diii= (ImageView)vist.findViewById(R.id.d_III);
        div= (ImageView)vist.findViewById(R.id.d_IV);
        dv= (ImageView)vist.findViewById(R.id.d_V);
        dvi= (ImageView)vist.findViewById(R.id.d_VI);
        dvii= (ImageView)vist.findViewById(R.id.d_VII);
        dviii= (ImageView)vist.findViewById(R.id.d_VIII);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), VideosActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        dii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        diii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        dv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        dvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        dvii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        diii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MoreActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        return vist;
    }

}
