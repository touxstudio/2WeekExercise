package org.coursera.a2weekexercise;

import android.content.Intent;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

   private EditText name, phone, email, contact;
   private DatePicker date;
   private Button next;
    private int year, day, month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);


        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        contact = (EditText) findViewById(R.id.contact);
        next = (Button) findViewById(R.id.next);
        date = (DatePicker) findViewById(R.id.datePicker2);
        //Inicia el DatePicker en la fecha actual.
        date.init(year, month, day, null);

        // SI existe Intent y el Bundle no es igual a NULL
        if(getIntent() != null && getIntent().getExtras() != null){
        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if(extras != null) {
            name.setText(extras.getString("NAME"));
            phone.setText(extras.getString("PHONE"));
            email.setText(extras.getString("EMAIL"));
            contact.setText(extras.getString("CONTACT"));
            date.updateDate(extras.getInt("YEAR"), extras.getInt("MONTH") - 1, extras.getInt("DAY"));
        }
        }



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Log.v("FECHA", Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year));

                Intent i = new Intent(MainActivity.this, ReceiverActivity.class);
                i.putExtra("NAME", name.getText().toString());
                i.putExtra("PHONE", phone.getText().toString());
                i.putExtra("EMAIL", email.getText().toString());
                i.putExtra("CONTACT", contact.getText().toString());
                i.putExtra("DAY", date.getDayOfMonth());
                i.putExtra("MONTH", date.getMonth() + 1);
                i.putExtra("YEAR", date.getYear());

                startActivity(i);

            }
        });

    }

    public void mySnack(View v, String text){

        Snackbar.make(v , text, Snackbar.LENGTH_SHORT)
                .setAction(getResources().getString(R.string.snack_text), new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.v("SNACK", "Personalizado");
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                .show();

    }
}
