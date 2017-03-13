package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called for checking which RadioButton is clicked in Question 1
     *
     * @param view
     */
    public void onRadioBtnSelectQ1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.donut_rdo_btn:
                if (checked)
                    break;
            case R.id.marshmallow_rdo_btn:
                if (checked)
                    break;
            case R.id.lolipop_rdo_btn:
                if (checked)
                    break;
        }
    }


    /**
     * This method is called for checking which CheckBox is clicked in Question 2
     *
     * @param view
     */
    public void onCheckBoxCheckedQ2(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.TextView_checkbox:
                if (checked)
                    break;
            case R.id.StringView_checkbox:
                if (checked)
                    break;
            case R.id.ImageView_checkBox:
                if (checked)
                    break;
        }
    }

    /**
     * This method is called for checking which RadioButton is clicked in Question 3
     *
     * @param view
     */
    public void onRadioBtnSelectQ3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.package_rdo_btn:
                if (checked)
                    break;
            case R.id.assets_rdo_btn:
                if (checked)
                    break;
            case R.id.layout_rdo_btn:
                if (checked)
                    break;
        }
    }


    /**
     * This method is called for checking which CheckBox is clicked in Question 5
     *
     * @param view
     */
    public void onCheckBoxCheckedQ5(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.v5View_checkbox:
                if (checked)
                    break;
            case R.id.v7View_checkbox:
                if (checked)
                    break;
            case R.id.v6View_checkBox:
                if (checked)
                    break;
        }
    }

    /**
     * This method is called when user click on ResultButton
     *
     * @param view
     */
    public void onResultBtnClicked(View view) {

        //Question 1
        RadioButton donutRadioBtnChecked = (RadioButton) findViewById(R.id.donut_rdo_btn);
        boolean hasRadioButtonChecked = donutRadioBtnChecked.isChecked();

        //Question 2
        CheckBox textViewCheckBoxChecked = (CheckBox) findViewById(R.id.TextView_checkbox);
        boolean hasTextViewCheckBoxChecked = textViewCheckBoxChecked.isChecked();

        CheckBox stringViewCheckBoxChecked = (CheckBox) findViewById(R.id.StringView_checkbox);
        boolean hasStringViewCheckBoxChecked = stringViewCheckBoxChecked.isChecked();

        CheckBox imageViewCheckBoxChecked = (CheckBox) findViewById(R.id.ImageView_checkBox);
        boolean hasImageViewCheckBoxChecked = imageViewCheckBoxChecked.isChecked();

        //Question 3
        RadioButton layoutRadioBtnChecked = (RadioButton) findViewById(R.id.layout_rdo_btn);
        boolean haslayoutRadioBtnChecked = layoutRadioBtnChecked.isChecked();

        //Question 4
        EditText answerEditText = (EditText) findViewById(R.id.answer_editText_view);
        String hasAnswerInput = answerEditText.getText().toString();

        //Question 5
        CheckBox v5ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v5View_checkbox);
        boolean hasV5ViewCheckBoxChecked = v5ViewCheckBoxChecked.isChecked();

        CheckBox v7ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v7View_checkbox);
        boolean hasV7ViewCheckBoxChecked = v7ViewCheckBoxChecked.isChecked();

        CheckBox v6ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v6View_checkBox);
        boolean hasV6ViewCheckBoxChecked = v6ViewCheckBoxChecked.isChecked();


        /**
         * totalScore stores all score when user checked all the RadioButton or CheckBoxes or input any Text in EditText
         */
        int totalScore = calculateScore(hasRadioButtonChecked, hasTextViewCheckBoxChecked,
                hasStringViewCheckBoxChecked, hasImageViewCheckBoxChecked, haslayoutRadioBtnChecked, hasAnswerInput,
                hasV5ViewCheckBoxChecked, hasV7ViewCheckBoxChecked, hasV6ViewCheckBoxChecked);

        /**
         * This function checks whether how many correct answer does user gave and shows feedback to user with a Toast with message
         */
        if (totalScore == 5) {
            Toast.makeText(this, "Great Job!! ALL Answer is Correct ", Toast.LENGTH_LONG).show();
        } else if (totalScore == 4) {
            Toast.makeText(this, "You Have Corrected " + totalScore, Toast.LENGTH_SHORT).show();
        } else if (totalScore < 4) {
            Toast.makeText(this, "Try Again " + totalScore + " Answers is Correct", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * This method is called for calculating the Score
     *
     * @return
     */
    public int calculateScore(boolean addRadioButtonChecked, boolean addTextViewCheckBoxChecked,
                              boolean addStringViewCheckBoxChecked, boolean addImageViewCheckBoxChecked, boolean addlayoutRadioBtnChecked,
                              String addAnswerInput, boolean addV5ViewCheckBoxChecked, boolean addV7ViewCheckBoxChecked, boolean addV6ViewCheckBoxChecked) {

        //to keep temporary score stored in this variable
        int tempScore = 0;

        //Question 1 logic
        if (addRadioButtonChecked) {
            tempScore += 1;
        }

        //Question 2 logic
        if (addTextViewCheckBoxChecked && !addStringViewCheckBoxChecked && addImageViewCheckBoxChecked) {
            tempScore += 1;
        }

        //Question 3 logic
        if (addlayoutRadioBtnChecked) {
            tempScore += 1;
        }

        //Question 4 logic
        if (addAnswerInput.equalsIgnoreCase("parent")) {
            tempScore += 1;
        }

        //Question 5 logic
        if (!addV5ViewCheckBoxChecked && !addV6ViewCheckBoxChecked && addV7ViewCheckBoxChecked) {
            tempScore += 1;
        }
        //returns total score by adding with score variable
        return (score + tempScore);
    }


    /**
     * This method called when user click on Send to Email and it takes to user to the email app to send user score
     *
     * @param view
     */
    public void onSendToBtnClicked(View view) {
        //This is the text edit view wehre user input the name
        EditText nameEditText = (EditText) findViewById(R.id.name_editText_view);
        String nameInput = nameEditText.getText().toString();

        //Question 1
        RadioButton donutRadioBtnChecked = (RadioButton) findViewById(R.id.donut_rdo_btn);
        boolean hasRadioButtonChecked = donutRadioBtnChecked.isChecked();

        //Question 2
        CheckBox textViewCheckBoxChecked = (CheckBox) findViewById(R.id.TextView_checkbox);
        boolean hasTextViewCheckBoxChecked = textViewCheckBoxChecked.isChecked();

        CheckBox stringViewCheckBoxChecked = (CheckBox) findViewById(R.id.StringView_checkbox);
        boolean hasStringViewCheckBoxChecked = stringViewCheckBoxChecked.isChecked();

        CheckBox imageViewCheckBoxChecked = (CheckBox) findViewById(R.id.ImageView_checkBox);
        boolean hasImageViewCheckBoxChecked = imageViewCheckBoxChecked.isChecked();

        //Question 3
        RadioButton layoutRadioBtnChecked = (RadioButton) findViewById(R.id.layout_rdo_btn);
        boolean haslayoutRadioBtnChecked = layoutRadioBtnChecked.isChecked();

        //Question 4
        EditText answerEditText = (EditText) findViewById(R.id.answer_editText_view);
        String hasAnswerInput = answerEditText.getText().toString();

        //Question 5
        CheckBox v5ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v5View_checkbox);
        boolean hasV5ViewCheckBoxChecked = v5ViewCheckBoxChecked.isChecked();

        CheckBox v7ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v7View_checkbox);
        boolean hasV7ViewCheckBoxChecked = v7ViewCheckBoxChecked.isChecked();

        CheckBox v6ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v6View_checkBox);
        boolean hasV6ViewCheckBoxChecked = v6ViewCheckBoxChecked.isChecked();

        //Total Score stores here
        int totalScore = calculateScore(hasRadioButtonChecked, hasTextViewCheckBoxChecked,
                hasStringViewCheckBoxChecked, hasImageViewCheckBoxChecked, haslayoutRadioBtnChecked, hasAnswerInput,
                hasV5ViewCheckBoxChecked, hasV7ViewCheckBoxChecked, hasV6ViewCheckBoxChecked);

        String message = createScoreSummary(totalScore, nameInput);

        /**
         * intent function to send user score by email app
         */
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Quiz App Score of " + nameInput);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method called to create the String where user score and name is present to send it via email
     *
     * @param addName    is user name which is user entered
     * @param finalScore is to store finalScore of corrected answer of the user
     * @return
     */
    private String createScoreSummary(int finalScore, String addName) {
        String scoreSummary = "Hello " + addName + "\nYour Score is: " + finalScore + "/5" + "\nThank You :)";
        return scoreSummary;
    }

    /**
     * This method called on Reset butoon to reset all selection
     *
     * @param view
     */
    public void reset(View view) {

        //name input reset
        EditText nameEditText = (EditText) findViewById(R.id.name_editText_view);
        nameEditText.setText("");

        //Question 1 reset
        RadioButton donutRadioBtnChecked = (RadioButton) findViewById(R.id.donut_rdo_btn);
        donutRadioBtnChecked.setChecked(false);

        RadioButton lolipopRadioBtnChecked = (RadioButton) findViewById(R.id.lolipop_rdo_btn);
        lolipopRadioBtnChecked.setChecked(false);

        RadioButton marshmallowRadioBtnChecked = (RadioButton) findViewById(R.id.marshmallow_rdo_btn);
        marshmallowRadioBtnChecked.setChecked(false);

        //Question 2 reset
        CheckBox textViewCheckBoxChecked = (CheckBox) findViewById(R.id.TextView_checkbox);
        textViewCheckBoxChecked.setChecked(false);

        CheckBox stringViewCheckBoxChecked = (CheckBox) findViewById(R.id.StringView_checkbox);
        stringViewCheckBoxChecked.setChecked(false);

        CheckBox imageViewCheckBoxChecked = (CheckBox) findViewById(R.id.ImageView_checkBox);
        imageViewCheckBoxChecked.setChecked(false);

        //Question 3 reset
        RadioButton layoutRadioBtnChecked = (RadioButton) findViewById(R.id.layout_rdo_btn);
        layoutRadioBtnChecked.setChecked(false);

        RadioButton packageRadioBtnChecked = (RadioButton) findViewById(R.id.package_rdo_btn);
        packageRadioBtnChecked.setChecked(false);

        RadioButton assetsRadioBtnChecked = (RadioButton) findViewById(R.id.assets_rdo_btn);
        assetsRadioBtnChecked.setChecked(false);

        //Question 4 reset
        EditText answerEditText = (EditText) findViewById(R.id.answer_editText_view);
        answerEditText.setText("");

        //Question 5 reset
        CheckBox v5ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v5View_checkbox);
        v5ViewCheckBoxChecked.setChecked(false);

        CheckBox v7ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v7View_checkbox);
        v7ViewCheckBoxChecked.setChecked(false);

        CheckBox v6ViewCheckBoxChecked = (CheckBox) findViewById(R.id.v6View_checkBox);
        v6ViewCheckBoxChecked.setChecked(false);
    }
}