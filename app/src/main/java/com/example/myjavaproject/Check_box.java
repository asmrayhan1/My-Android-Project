package com.example.myjavaproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Check_box extends AppCompatActivity {
    CheckBox checkBox1, checkBox2, checkBox3;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_box);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Checkboxes and Button
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        checkBox3 = findViewById(R.id.checkbox3);
        submitButton = findViewById(R.id.submit_button);

        // Set OnClickListener for the Button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("Selected Options: \n");

                // Check which boxes are checked
                if (checkBox1.isChecked()) {
                    result.append("Student\n");
                }
                if (checkBox2.isChecked()) {
                    result.append("Teacher\n");
                }
                if (checkBox3.isChecked()) {
                    result.append("Military\n");
                }
                // Display the result using a Toast message
                Toast.makeText(Check_box.this, result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}