package uk.ac.tees.q5095703.memoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;

//import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

//import gms.drive.*;

public class MainActivity extends AppCompatActivity {
 //   private GoogleApiClient mGoogleApiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DateBaseHandler dh = new DateBaseHandler(this);
        GridView gridView = (GridView) findViewById(R.id.grid);
        dh.addLecturer(new JournalEntry("note", "String cat","String date","String longe", "String lat"));
        List employeeList = dh.getAll();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, employeeList);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                switch (position) {
                    case 0:

                        break;
                    case 1:
                        break;

                }

            }
        });

        gridView.setAdapter(adapter);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        catgorie db = new catgorie();
        List<String> lables = db.getCategory();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        final Context context = this;
       Button button = (Button) findViewById(R.id.addButton);

        // Add next button event listener
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, addEntry.class);
                        intent.putExtra("message", "cat");
                        startActivity(intent);
                    }
                }

        );

    }
}
