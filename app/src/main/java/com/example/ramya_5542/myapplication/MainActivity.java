package com.example.ramya_5542.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =" ";
    EditText editText;
    TextView textViewObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewObj= (TextView) findViewById(R.id.textView3);
        editText = (EditText) findViewById(R.id.editText);


        Button buttonObj=(Button)findViewById(R.id.button2);

        buttonObj.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivityForResult(intent, 1);
            }
        }) ;
    }

     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {

            if (data!=null){ // here i can also use resultcode
                String myStrObj=data.getStringExtra("Message");
                textViewObj.setText(myStrObj);
            }


        }
    }

}
