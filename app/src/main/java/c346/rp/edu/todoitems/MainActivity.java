package c346.rp.edu.todoitems;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tvItem;
    ListView lv;
    ArrayList<listOfItem> itemList;
    ArrayAdapter<listOfItem> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvItem = findViewById(R.id.textViewItem);
        lv = findViewById(R.id.listViewItems);

        itemList = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2019,8,1);
        Calendar date2 = Calendar.getInstance();
        date2.set(2019,10,22);

        itemList.add(new listOfItem("MSA" , date1));
        itemList.add(new listOfItem("Go and haircut" , date2));

        aa = new CustomAdapter(this, R.layout.row, itemList);

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("Item", itemList.get(position).getItem());
                intent.putExtra("Day", itemList.get(position).getDate().get(Calendar.DAY_OF_MONTH));
                intent.putExtra("Month", itemList.get(position).getDate().get(Calendar.MONTH));
                intent.putExtra("Year", itemList.get(position).getDate().get(Calendar.YEAR));
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });

        Intent intentReceived = getIntent();
        boolean changed = intentReceived.getBooleanExtra("Changed", false);
        String things = intentReceived.getStringExtra("Things");
        int day = intentReceived.getIntExtra("Day", 0);
        int month = intentReceived.getIntExtra("Month", 0);
        int year = intentReceived.getIntExtra("Year", 0);
        int position = intentReceived.getIntExtra("Position", 0);

        Calendar newDate = Calendar.getInstance();
        newDate.set(year, month, day);

        if (changed){
            itemList.set(position,new listOfItem(things, newDate));
            aa.notifyDataSetChanged();
        }
    }
}
