package com.example.aaron.endangeredbirds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnData = (Button) findViewById(R.id.button);
        btnData.setOnClickListener(this);

    }

    public void onClick(View v) {
        TextView t = (TextView) findViewById(R.id.text1);
        startActivity(new Intent(MainActivity.this, questions.class));
    }
}
