package com.sevillaInc.sweattime;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    private View vista1;
    private LinearLayout llperfil;
    private LinearLayout llPoliticas;
    private LinearLayout llAgradecimientos;

    private FirebaseAuth mAuth;
    private DatabaseReference mDataBase;
    private TextView txtgenre;
    private TextView mAltura;
    private TextView mEdad;
    private TextView mName;


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista1 = inflater.inflate(R.layout.fragment_settings, container, false);
        mAuth = FirebaseAuth.getInstance();
        mDataBase = FirebaseDatabase.getInstance().getReference();
        llperfil = (LinearLayout) vista1.findViewById(R.id.llPerfil);
        llAgradecimientos=(LinearLayout)vista1.findViewById(R.id.llAgradecimiento);
        llPoliticas=(LinearLayout)vista1.findViewById(R.id.llPoliticas);

        if (mAuth.getCurrentUser() != null) {
            getUserInfo();
        } else {

        }

        llperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() != null) {
                    Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                    startActivityForResult(intent, 0);
                } else {
                    Toast.makeText(getActivity(),"Inicia sesión",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivityForResult(intent, 0);
                }
            }
        });

        llPoliticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PoliticasActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        llAgradecimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AgradecimientosActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        return vista1;
    }

    //Metodo para obtener la informacion del usuario
    private void getUserInfo() {
        String id = mAuth.getCurrentUser().getUid();
        txtgenre = (TextView) vista1.findViewById(R.id.txtgenre);
        mAltura = (TextView) vista1.findViewById(R.id.txtaltura);
        mEdad = (TextView) vista1.findViewById(R.id.txtedad);
        mName = (TextView) vista1.findViewById(R.id.txtName);
        mDataBase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String genre = dataSnapshot.child("genre").getValue().toString();
                    String altura = dataSnapshot.child("size").getValue().toString();
                    String edad = dataSnapshot.child("birthday").getValue().toString();
                    mName.setText("de "+name);
                    mName.setVisibility(View.VISIBLE);
                    txtgenre.setText(genre);
                    txtgenre.setVisibility(View.VISIBLE);
                    mAltura.setText(altura + " cm");
                    mAltura.setVisibility(View.VISIBLE);
                    mEdad.setText(edad);
                    mEdad.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
