package com.example.irisjang.datemate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AddNewDateInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_date_info);

        getSupportActionBar().setElevation(0); //this gets rid of shadow under action bar
        setTitle("Add new date info");


        final Button setTimeButton = (Button) findViewById(R.id.set_date);
        setTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        final Button setDateButton = (Button) findViewById(R.id.set_time);
        setDateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showTimePickerDialog(v);
            }
        });


        final Button button = (Button) findViewById(R.id.confirm_date);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goBackToHome(v);
            }
        });
    }

    /* Following method called when "add date" button clicked */
    public void goBackToHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment myFragment = new TimePickerFragment(); //create instance of the time picker fragment
        myFragment.show(getSupportFragmentManager(), "timePicker");

    }

    public void showDatePickerDialog(View v) {
        DialogFragment myFragment = new DatePickerFragment(); //create instance of the time picker fragment
        myFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_new_date_info, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        /* this method hides the "three dot" settings menu at top right */
        MenuItem item= menu.findItem(R.id.action_settings);
        item.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
