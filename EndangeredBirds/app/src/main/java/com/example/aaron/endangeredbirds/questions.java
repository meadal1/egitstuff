/* Questions
    Made by Aaron Mead
 */
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
    private int count; //question count
    private Question[] questions; //all the questions
    private TextView q; //the actual question
    private TextView wrong; //shows up when you get a question wrong
    private ImageView i; //image of bird
    private RadioButton a1; //first answer
    private RadioButton a2; //second answer
    private RadioButton a3; //third answer
    private RadioButton a4; //fourth answer
    private RadioGroup rg; //surrounds the radiobuttons
    private int score; //records score
    private Button btnData; //next question button
    private boolean end; //if wrong answer selected on last question this is used to move on

    @Override
    protected void onCreate(Bundle savedInstanceState) { //when questions opened
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        count = 0;
        score = 0;
        questions = new Question[10]; //creating all the birds
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

        q = (TextView) findViewById(R.id.q); //question
        wrong = (TextView) findViewById(R.id.textView7); //in case wrong
        i = (ImageView) findViewById(R.id.imageView); //picture
        rg = (RadioGroup) findViewById(R.id.rg); //radiogroup
        a1 = (RadioButton) findViewById(R.id.radioButton); //first answer
        a1.setText(questions[0].getAnswer1());
        a2 = (RadioButton) findViewById(R.id.radioButton2); //second answer
        a2.setText(questions[0].getAnswer2());
        a3 = (RadioButton) findViewById(R.id.radioButton4); //third answer
        a3.setText(questions[0].getAnswer3());
        a4 = (RadioButton) findViewById(R.id.radioButton3); //fourth answer
        a4.setText(questions[0].getAnswer4());
        q.setText(questions[0].getQuestion()); //question

        btnData = (Button) findViewById(R.id.button2); //submit button
        btnData.setOnClickListener(this);

    }

    public void onClick(View v) { //when button clicked
        if(count < 9) { //if not on last question
            updateQuestion();
        }
        else if(count == 9) { //if on last question
            if(end) { //if answer was wrong on last question
                Intent i = new Intent(getApplicationContext(), score.class); //move to score
                i.putExtra("score", score); //send score variable
                startActivity(i);
            }
            else { //dont change the pictures, just check if correct then move on
                justCheck();
            }

        }
    }

    public void updateQuestion() { //updates the pictures and answers
        int selectedId = rg.getCheckedRadioButtonId(); //chosen answer
        RadioButton selected = (RadioButton) findViewById(selectedId); //choose selected one
        if(questions[count].getCorrectAnswer() == selected.getText()) { //if selected is right
            a1.setVisibility(View.VISIBLE); //in case still invisible from wrong answer chosen
            a2.setVisibility(View.VISIBLE);
            a3.setVisibility(View.VISIBLE);
            a4.setVisibility(View.VISIBLE);
            wrong.setVisibility(View.INVISIBLE); //in case still visible from wrong answer chosen
            btnData.setText("SUBMIT"); // in case still set to continue
            count++; //next question
            score = getScore() + 1; //score up
            selected.setChecked(false); //reset selected
            q.setText(questions[count].getQuestion()); //set question to new question
            a1.setText(questions[count].getAnswer1()); //sets the first answer
            a2.setText(questions[count].getAnswer2()); //sets the second answer
            a3.setText(questions[count].getAnswer3()); //sets the third answer
            a4.setText(questions[count].getAnswer4()); //sets the fourth answer
            switch(count) {
                case 1:
                    i.setImageResource(R.drawable.pukeko); //pukeko pic
                    break;
                case 2:
                    i.setImageResource(R.drawable.albatross); //albatross pic
                    break;
                case 3:
                    i.setImageResource(R.drawable.takahe); //takahe pic
                    break;
                case 4:
                    i.setImageResource(R.drawable.robin); //robin pic
                    break;
                case 5:
                    i.setImageResource(R.drawable.falcon); //falcon pic
                    break;
                case 6:
                    i.setImageResource(R.drawable.kea); //kea pic
                    break;
                case 7:
                    i.setImageResource(R.drawable.fantail); //fantail pic
                    break;
                case 8:
                    i.setImageResource(R.drawable.pigeon); //pigeon pic
                    break;
                case 9:
                    i.setImageResource(R.drawable.tui); //tui pic
                    break;
            }
        }
        else {
            a1.setVisibility(View.INVISIBLE); //hide radio buttons
            a2.setVisibility(View.INVISIBLE);
            a3.setVisibility(View.INVISIBLE);
            a4.setVisibility(View.INVISIBLE);
            wrong.setVisibility(View.VISIBLE); //show text saying you're wrong
            wrong.setText(("You were incorrect. The right answer is ") + questions[count].getCorrectAnswer());
            score--; //score down because it will go up on button click
            a1.setText(questions[count].getCorrectAnswer()); //just to move on
            a1.setChecked(true); //just to move on
            btnData.setText("CONTINUE");
        }

    }

    public void justCheck() { //only used on the final question so it doesnt change pictures
        int selectedId = rg.getCheckedRadioButtonId();
        RadioButton selected = (RadioButton) findViewById(selectedId);
        if(questions[count].getCorrectAnswer() == selected.getText()) { //check if right
            score++;
            Intent i = new Intent(getApplicationContext(), score.class); //move to score
            i.putExtra("score", score); //send score to next screen
            startActivity(i);
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
            end = true;
        }
    }

    public int getScore() { //gets the score
        return score;
    }
}
