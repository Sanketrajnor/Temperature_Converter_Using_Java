package com.example.temperature_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ansBtn,againBtn;
    TextView showAns;
    RadioButton c2f,f2c;
    EditText getVal;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = findViewById(R.id.ansbtn);
        againBtn = findViewById(R.id.againbtn);
        c2f = findViewById(R.id.c2f);
        f2c = findViewById(R.id.f2c);
        showAns = findViewById(R.id.showans);
        getVal = findViewById(R.id.getvalue);
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getVal.getText().toString().isEmpty()){
                    showAns.setText("Please enter temperature");
                }else{
                    x=Double.parseDouble(String.valueOf(getVal.getText()));
                    if(c2f.isChecked()){
                        x=(x*9)/5+32;
                        showAns.setText(String.valueOf(x)+"Degree F");
                    } else if (f2c.isChecked()) {
                        x=(x-32)*5/9;
                        showAns.setText(String.valueOf(x)+"Degree C");
                    }
                    else{
                        showAns.setText("Please Select Any Option...");
                    }
                }
            }
        });
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAns.setText("0.0");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });
    }
}