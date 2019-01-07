package com.example.user.dine_n_dash;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;

public class PaymentMethod extends AppCompatActivity {
private RadioGroup rg;
private RadioButton rb;
private RadioButton visa;
private RadioButton pp;
private RadioButton jp;
private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        rg =  findViewById(R.id.methodGroup);
        visa = findViewById(R.id.visaradio);
        pp = findViewById(R.id.ppradio);
        jp = findViewById(R.id.jpradio);

        btn=findViewById(R.id.proceed);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=rg.getCheckedRadioButtonId();
                rb=findViewById(selectedId);
                if(rb == visa){
                    startActivity(new Intent(PaymentMethod.this, VisaPayment.class));
                }else if(rb == pp){
                    Intent ppWeb = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.paypal.com/my/signin?country.x=MY&locale.x=en_MY"));
                    startActivity(ppWeb);
                    startActivity(new Intent(PaymentMethod.this, PaymentSuccess.class));
                }else if(rb == jp){
                    Intent jpWeb = new Intent(Intent.ACTION_VIEW,Uri.parse("https://billercentre.jompay.com.my/login.aspx"));
                    startActivity(jpWeb);
                    startActivity(new Intent(PaymentMethod.this, PaymentSuccess.class));
                }else{
                    Toast.makeText(PaymentMethod.this,"Please select one method.",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


    public void back(View view) {
        startActivity(new Intent(PaymentMethod.this, PaymentMethod.class));
    }
}
