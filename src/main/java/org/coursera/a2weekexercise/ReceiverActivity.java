package org.coursera.a2weekexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiverActivity extends AppCompatActivity {

    private String names, phones, emails, contacts;

    private int day , month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        TextView name = (TextView) findViewById(R.id.name);
        TextView date = (TextView) findViewById(R.id.date);
        TextView phone = (TextView) findViewById(R.id.phone);
        TextView email = (TextView) findViewById(R.id.email);
        TextView contact = (TextView) findViewById(R.id.contact);

        //TextView mTextView = (TextView) findViewById(R.id.textView);
        Button edit = (Button) findViewById(R.id.edit);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if(extras != null) {

            day = extras.getInt("DAY");
            month = extras.getInt("MONTH");
            year = extras.getInt("YEAR");

            Log.v("FECHA", day + "/" + month + "/" + year);

            names = extras.getString("NAME");
            name.setText(names);

            date.setText(day + "/" + month + "/" + year );
            phones = extras.getString("PHONE");
            phone.setText(phones);
            emails = extras.getString("EMAIL");
            email.setText(emails);
            contacts = extras.getString("CONTACT");
            contact.setText(contacts);
        }

        //mTextView.setText("Nombre: " + name + "\n"+ "Telefono: " + phone + "\n" + "Email: " + email + "\n"+ "Mensaje: " + contact);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ReceiverActivity.this, MainActivity.class);
                i.putExtra("NAME", names);
                i.putExtra("PHONE", phones);
                i.putExtra("EMAIL", emails);
                i.putExtra("CONTACT", contacts);
                i.putExtra("DAY", day);
                i.putExtra("MONTH", month);
                i.putExtra("YEAR", year);

                startActivity(i);

            }
        });

    }
}
