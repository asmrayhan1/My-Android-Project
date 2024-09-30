package com.example.myjavaproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Radio_button extends AppCompatActivity {

    RadioGroup radioGroup;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the RadioGroup and Button
        radioGroup = findViewById(R.id.radioGroup);
        submitButton = findViewById(R.id.submitButton);

        // Set OnClickListener for the submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected RadioButton's ID
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // If a radio button is selected
                if (selectedId != -1) {
                    // Find the RadioButton by its ID
                    RadioButton selectedRadioButton = findViewById(selectedId);

                    // Get the text of the selected RadioButton
                    String selectedText = selectedRadioButton.getText().toString();

                    // Display the selected option in a Toast
                    Toast.makeText(Radio_button.this, "Selected: " + selectedText, Toast.LENGTH_LONG).show();
                } else {
                    // If no RadioButton is selected, show a message
                    Toast.makeText(Radio_button.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}