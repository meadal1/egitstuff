package com.example.aaron.endangeredbirds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ImageView;

public class questions extends AppCompatActivity implements View.OnClickListener {
    private int count;
    private Question[] questions;
    private TextView q;
    private TextView wrong;
    private ImageView i;
    private RadioButton a1;
    private RadioButton a2;
    private RadioButton a3;
    private RadioButton a4;
    private RadioGroup rg;
    private int score;
    private Button btnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        count = 0;
        score = 0;
        questions = new Question[10];
        questions[0] = new Question("What bird is this?", "kiwi", "pukeko", "sparrow", "takahe", "kiwi");
        questions[1] = new Question("What bird is this?", "takahe", "pukeko", "albatross", "sparrow", "pukeko");
        questions[2] = new Question("What bird is this?", "eagle", "seagull", "pigeon", "albatross", "albatross");
        questions[3] = new Question("What bird is this?", "takahe", "pukeko", "owl", "kiwi", "takahe");
        questions[4] = new Question("What bird is this?", "sparrow", "robin", "seagull", "bellbird", "robin");
        questions[5] = new Question("What bird is this?", "eagle", "owl", "hawk", "falcon", "falcon");
        questions[6] = new Question("What bird is this?", "moa", "kea", "kiwi", "cockatiel", "kea");
        questions[7] = new Question("What bird is this?", "bluebird", "bellbird", "fantail", "sparrow", "fantail");
        questions[8] = new Question("What bird is this?", "seagull", "blackbird", "tui", "pigeon", "pigeon");
        questions[9] = new Question("What bird is this?", "tui", "silvereye", "kaka", "hihi", "tui");

        q = (TextView) findViewById(R.id.q);
        wrong = (TextView) findViewById(R.id.textView7);
        i = (ImageView) findViewById(R.id.imageView);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg = (RadioGroup) findViewById(R.id.rg);
        a1 = (RadioButton) findViewById(R.id.radioButton);
        a1.setText(questions[0].getAnswer1());
        a2 = (RadioButton) findViewById(R.id.radioButton2);
        a2.setText(questions[0].getAnswer2());
        a3 = (RadioButton) findViewById(R.id.radioButton4);
        a3.setText(questions[0].getAnswer3());
        a4 = (RadioButton) findViewById(R.id.radioButton3);
        a4.setText(questions[0].getAnswer4());
        q.setText(questions[0].getQuestion());

        btnData = (Button) findViewById(R.id.button2);
        btnData.setOnClickListener(this);

    }

    public void onClick(View v) {
        if(count < 9) {
            updateQuestion();
        }
        else if(count == 9) {
            justCheck();
        }
    }

    public void updateQuestion() {
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton selected = (RadioButton) findViewById(selectedId);
        if(questions[count].getCorrectAnswer() == selected.getText()) {
            a1.setVisibility(View.VISIBLE);
            a2.setVisibility(View.VISIBLE);
            a3.setVisibility(View.VISIBLE);
            a4.setVisibility(View.VISIBLE);
            wrong.setVisibility(View.INVISIBLE);
            btnData.setText("SUBMIT");
            count++;
            score = getScore() + 1;
            selected.setChecked(false);
            q.setText(questions[count].getQuestion());
            a1.setText(questions[count].getAnswer1());
            a2.setText(questions[count].getAnswer2());
            a3.setText(questions[count].getAnswer3());
            a4.setText(questions[count].getAnswer4());
            switch(count) {
                case 1:
                    i.setImageResource(R.drawable.pukeko);
                    break;
                case 2:
                    i.setImageResource(R.drawable.albatross);
                    break;
                case 3:
                    i.setImageResource(R.drawable.takahe);
                    break;
                case 4:
                    i.setImageResource(R.drawable.robin);
                    break;
                case 5:
                    i.setImageResource(R.drawable.falcon);
                    break;
                case 6:
                    i.setImageResource(R.drawable.kea);
                    break;
                case 7:
                    i.setImageResource(R.drawable.fantail);
                    break;
                case 8:
                    i.setImageResource(R.drawable.pigeon);
                    break;
                case 9:
                    i.setImageResource(R.drawable.tui);
                    break;
            }
        }
        else {
            a1.setVisibility(View.INVISIBLE);
            a2.setVisibility(View.INVISIBLE);
            a3.setVisibility(View.INVISIBLE);
            a4.setVisibility(View.INVISIBLE);
            wrong.setVisibility(View.VISIBLE);
            wrong.setText(("You were incorrect. The right answer is ") + questions[count].getCorrectAnswer());
            score--;
            a1.setText(questions[count].getCorrectAnswer());
            a1.setChecked(true);
            btnData.setText("CONTINUE");
        }

    }

    public void justCheck() {
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton selected = (RadioButton) findViewById(selectedId);
        if(questions[count].getCorrectAnswer() == selected.getText()) {
            score++;
            Intent i = new Intent(getApplicationContext(), score.class);
            i.putExtra("score", score);
            startActivity(i);
        }
    }

    public int getScore() {
        return score;
    }
}
