package uk.ac.tees.q5095703.memoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class addEntry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        setContentView(R.layout.activity_add_entry);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText mEdit   = (EditText)findViewById(R.id.textArea);
        catgorie db = new catgorie();
        List<String> lables = db.getCategory();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        final Context context = this;
        Button button = (Button) findViewById(R.id.addButton);



        if(message != null){

            spinner.setSelection(1);
        } else{
            spinner.setSelection(0);

        }




        // Add next button event listener
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String choice = spinner.getSelectedItem().toString();
                        String text = mEdit.getText().toString();
                        if(choice != null){
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);}
                    }
                }

        );
    }


}
