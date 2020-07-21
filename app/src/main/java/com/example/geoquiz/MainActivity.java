package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TextView mRequestionTextView;
    private TextView mRequestionTextView2;
    private Question[] mQuestionsBank = new Question[] {
            new Question(R.string.question1,true),
            new Question(R.string.question2, false),
            new Question(R.string.question3,true),
            new Question(R.string.question4, false),
            new Question(R.string.question5,true),
            new Question(R.string.question6, false),
            new Question(R.string.question7,true),
    };
    private  int mCurrentIndex = 0;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.queestion_text_view);
        updateQuestion();

        mTrueButton =  (Button) findViewById(R.id.true_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast true_tost =Toast.makeText(MainActivity.this,
//                        R.string.correct_toast,
//                        Toast.LENGTH_SHORT);
//                true_tost.setGravity(Gravity.CENTER,-100,0);
//                true_tost.show();
//
                checkAnswer(true);
           }


        });


        mFalseButton =(Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast fals_toast = Toast.makeText(MainActivity.this,
//                        R.string.incorrect_toast,
//                        Toast.LENGTH_SHORT
//                        );
//                fals_toast.setGravity(Gravity.TOP, 0, 0);
//                fals_toast.show();

                checkAnswer(false);

            }
        });
        mTrueButton =  (Button) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mCurrentIndex = mCurrentIndex +1;
                updateQuestion();
            }


        });



    }

    private void updateQuestion() {
        int question = mQuestionsBank[mCurrentIndex].getTextResid();
        mQuestionTextView.setText(question);
    };

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionsBank[mCurrentIndex].isAnsver();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;

        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG)
                .show();
        mRequestionTextView  = (TextView) findViewById(R.id.request_text);
        mRequestionTextView.setText(String.valueOf(answerIsTrue));
        mRequestionTextView2  = (TextView) findViewById(R.id.request_text2);
        mRequestionTextView2.setText(String.valueOf(userPressedTrue));


    };

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called Стартанул");
    };

    @Override
    public void onPause () {
        super.onPause();
        Log.d(TAG, "onPause() called Стартанул");
    };


    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "onResume() called");
    };

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "onStop() called");
    };

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    };

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {

        super.onSaveInstanceState(saveInstanceState);
        Log.d(TAG, "onSaveInstanceState");
        saveInstanceState.putInt(KEY_INDEX, mCurrentIndex);

    }


}