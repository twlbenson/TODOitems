package c346.rp.edu.todoitems;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    DatePicker dp;
    Button btnUpdate;
    Button btnBack;
    EditText et;
    boolean changed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dp = findViewById(R.id.datePicker);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnBack = findViewById(R.id.buttonBack);
        et = findViewById(R.id.editTextThings);

        Intent intentReceived = getIntent();
        intentReceived = getIntent();
        String item = intentReceived.getStringExtra("Item");
        int day = intentReceived.getIntExtra("Day", 0);
        int month = intentReceived.getIntExtra("Month", 0);
        int year = intentReceived.getIntExtra("Year", 0);
        final int position = intentReceived.getIntExtra("Position",0);

        et.setText(item);
        dp.updateDate(year, month-1,day);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changed = true;

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("Changed", changed);
                intent.putExtra("Things", et.getText().toString());
                intent.putExtra("Day", dp.getDayOfMonth());
                intent.putExtra("Month", dp.getMonth()+1);
                intent.putExtra("Year", dp.getYear());
                intent.putExtra("Position", position);
                startActivity(intent);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
