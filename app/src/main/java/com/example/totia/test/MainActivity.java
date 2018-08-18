package com.example.totia.test;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button button,btn1,btn2;
    EditText txt1,txt2,txt3;
    RadioButton radioButton1,radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.form);
                dialog.setTitle("فرم");
                btn1 = (Button) dialog.findViewById(R.id.btn1);
                btn2 = (Button) dialog.findViewById(R.id.btn2);
                txt1 = (EditText) dialog.findViewById(R.id.txt1);
                txt2 = (EditText) dialog.findViewById(R.id.txt2);
                txt3 = (EditText) dialog.findViewById(R.id.txt3);
                radioButton1 = (RadioButton) dialog.findViewById(R.id.radioButton1);
                radioButton2 = (RadioButton) dialog.findViewById(R.id.radioButton2);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = getApplicationContext();
                        int duration = Toast.LENGTH_LONG;
                        String s1 = txt1.getText().toString();
                        String s2 = txt2.getText().toString();
                        String s3 = txt3.getText().toString();

                        StringBuffer result = new StringBuffer();
                        if (radioButton1.isChecked())
                            result.append("Female");
                        if (radioButton2.isChecked())
                            result.append("Male");

                        Toast toast = Toast.makeText(context,"First name: "+s1+"\n Last name: "+s2+"\n ID: "+s3
                                +"\n Sex: "+result.toString() ,duration);

                        toast.show();
                        dialog.cancel();
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to close application?")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setIcon(R.mipmap.ic_launcher);
        AlertDialog alert = builder.create();
        alert.setTitle("Alert");
        alert.show();
    }


}