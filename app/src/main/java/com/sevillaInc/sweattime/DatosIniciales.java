package com.sevillaInc.sweattime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DatosIniciales extends AppCompatActivity {
//android:theme="@style/SplashTheme"
    private EditText profilename;
    private EditText email;
    private EditText pass;
    private TextView mBirthday;
    private EditText estatura;
    private RadioButton mRbMale;
    private RadioButton mRbFemale;
    private RadioButton mRbOtherGender;
    private TextView skipt;
    private Button mButtonRegister;
    private static final String  TAG = "DatosIniciales";
    private DatePickerDialog.OnDateSetListener mDatelistener;

    //variables de datos a registrar
    private String name= "";
    private String correo = "";
    private String password="";
    private String cumple="";
    private String genre="";
    private String size="";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_iniciales);
        mAuth=FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        profilename= (EditText) findViewById(R.id.profileName);
        email= (EditText) findViewById(R.id.editTextEmail);
        pass= (EditText) findViewById(R.id.password);
        estatura= (EditText) findViewById(R.id.profileSize);
        mBirthday = (TextView) findViewById(R.id.profileBirthday);
        mRbMale = (RadioButton) findViewById(R.id.radioButtonMale);
        mRbFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        mRbOtherGender = (RadioButton)findViewById(R.id.radioButtonOtherGender);
        mButtonRegister= (Button) findViewById(R.id.create_newprofil);
        skipt= findViewById(R.id.Skipt);

        //clic en registrar
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=profilename.getText().toString();
                correo = email.getText().toString();
                password=pass.getText().toString();
                cumple=mBirthday.getText().toString();
                size=estatura.getText().toString();
                if (mRbMale.isChecked()) {
                    genre="M";
                } else if (mRbFemale.isChecked()) {
                    genre = "F";
                } else if (mRbOtherGender.isChecked()) {
                    genre = "OTHER";
                }
                //validaciones de pasword y datos
                if(!name.isEmpty() &&  !correo.isEmpty() && !password.isEmpty() && !cumple.isEmpty() && !size.isEmpty()){
                    if(password.length()>=6){
                        registerUser();
                    }else {
                        Toast.makeText(DatosIniciales.this, "El password debe tener 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(DatosIniciales.this, "Completar campos", Toast.LENGTH_SHORT).show();
                }

                //Intent intent = new Intent (v.getContext(), MainActivity.class);
                //startActivityForResult(intent, 0);
            }
        });
        //clic para desplegar el calendario
        mBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(DatosIniciales.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDatelistener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        //colocar la fecha seleccionada
        mDatelistener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG,"onDateSet: mm/dd/yyy: "+month+"/"+dayOfMonth+"/"+year);
                String date = dayOfMonth+"/"+month+"/"+year;
                mBirthday.setText(date);
            }
        };
        //clic en saltar
        skipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });
    }
    //funcion para registrar el usuario
    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(correo, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //mapa de valores
                    Map<String, Object> map = new HashMap<>();
                    map.put("name",name);
                    map.put("email",correo);
                    map.put("password",password);
                    map.put("birthday",cumple);
                    map.put("genre",genre);
                    map.put("size",size);
                    //obtenemos el id asignado por la firebase
                    String id= mAuth.getCurrentUser().getUid();
                    //pasamos el mapa de valores
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            //validams que la tarea sea exitosa
                            if(task2.isSuccessful()){
                                startActivity(new Intent(DatosIniciales.this, MainActivity.class));
                                //evitamos que vuelva a la pantalla con finsh cuando ya se ha registrado
                                finish();
                            }else{
                                Toast.makeText(DatosIniciales.this, "Algo fallo ups!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    Toast.makeText(DatosIniciales.this, "No pudimos completar su registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
