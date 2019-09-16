/* Score screen
    Made by Aaron Mead
 */

package com.example.aaron.endangeredbirds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("score"); //carries the score from the previous screen
        String score2 = String.valueOf(score);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView sc = (TextView) findViewById(R.id.textView2); // score box
        sc.setText(score2);

        Button btnData = (Button) findViewById(R.id.button3); //retry button
        btnData.setOnClickListener(this);
    }
    public void onClick(View v) { //returns to the main menu
        startActivity(new Intent(score.this, MainActivity.class));
    }
}
