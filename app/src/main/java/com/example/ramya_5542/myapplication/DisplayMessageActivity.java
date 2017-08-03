package com.example.ramya_5542.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        final StringBuilder display = new StringBuilder();
        display.append("Hello! ");
        display.append(message);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(display);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1=(Button)findViewById(R.id.button);

        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String message1=display.toString();
                Intent intent1=new Intent();
                intent1.putExtra("Message",message1);
                setResult(1,intent1);
                finish();//finishing activity
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
