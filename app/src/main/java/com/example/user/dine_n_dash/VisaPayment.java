package com.example.user.dine_n_dash;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class VisaPayment extends AppCompatActivity {
private EditText cardNo;
private EditText expDate;
private EditText cvv;
private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa_payment);


        btn1 = findViewById(R.id.button4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                cardNo = findViewById(R.id.cardNoinput);
                expDate = findViewById(R.id.expDate);
                cvv = findViewById(R.id.cvv);


                if(cardNo.getText().toString().equals("") || cardNo.length() != 16){
                    Toast.makeText(VisaPayment.this,"Please enter the card number and length must be 16 .",Toast.LENGTH_SHORT).show();
                }else if(expDate.getText().toString().equals(null) || expDate.length() != 5){
                        Toast.makeText(VisaPayment.this, "Please enter the expiry date and length must be 5.", Toast.LENGTH_SHORT).show();
                }else if(cvv.getText().toString().equals("") || cvv.length() != 3){
                    Toast.makeText(VisaPayment.this,"Please enter the security code(cvv) and length must be 3.",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(VisaPayment.this, PaymentSuccess.class));
                }


            }
        });


    }

    public void back1(View view) {

            startActivity(new Intent(VisaPayment.this, PaymentMethod.class));

    }


}
