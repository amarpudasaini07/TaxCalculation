package com.example.taxcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.taxcalculation.R;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private EditText mSalary;
    private Button btncalc;
    private float yearlySalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        mSalary = findViewById(R.id.mSalary);
        btncalc = findViewById(R.id.btncalc);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty()) {
                    float amount = Float.parseFloat(mSalary.getText().toString());
                    Tax t = new Tax(amount);
                    float totalamt1 = t.totalamt1();
                    float totalamt2 = t.totalamt2();
                    float totalamt3 = t.totalamt3();
                    yearlySalary = amount * 12;
                    if (yearlySalary <= 200000) {
                        result.setText(Float.toString(totalamt1));
                    } else if (yearlySalary > 200000 && yearlySalary <= 350000) {
                        result.setText(Float.toString(totalamt2));
                    } else {
                        result.setText(Float.toString(totalamt3));
                    }

                }
            }
        });
    }


    public boolean isEmpty() {
        if (TextUtils.isEmpty(mSalary.getText().toString())) {
            mSalary.setError("Please enter monthly salary");
            mSalary.requestFocus();
            return true;
        } else return false;
    }
}