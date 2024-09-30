package com.example.myjavaproject;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexValidation extends AppCompatActivity {

    EditText editTextUsername, editTextFullName, editTextEmail, editTextPhone, editTextId;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_regex_validation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextId = findViewById(R.id.editTextId);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Set the OnClickListener for the Submit button
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String username = editTextUsername.getText().toString().trim();
        String fullName = editTextFullName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String id = editTextId.getText().toString().trim();

        // Check if fields are empty
        if (TextUtils.isEmpty(username) || !isValidUsername(username)) {
            showToast("Valid Username is required (start with a letter, no spaces)");
            return;
        }
        if (TextUtils.isEmpty(fullName)) {
            showToast("Full Name is required");
            return;
        }
        if (TextUtils.isEmpty(email) || !isValidEmail(email)) {
            showToast("Valid Email is required");
            return;
        }
        if (TextUtils.isEmpty(phone) || !isValidPhone(phone)) {
            showToast("Valid Phone is required (must start with 01 and be 11 digits long)");
            return;
        }
        if (TextUtils.isEmpty(id) || !isValidId(id)) {
            showToast("Valid ID is required (digits only)");
            return;
        }

        // If all validations pass
        showToast("Form submitted successfully!");

        clearFormFields();
    }

    // Regex to validate email format
    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Regex to validate phone format
    private boolean isValidPhone(String phone) {
        String phonePattern = "^01[3|6|7|8]\\d{8}$"; // Start with 01 and has a specific format
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    // Regex to validate username format
    private boolean isValidUsername(String username) {
        String usernamePattern = "^[a-zA-Z][a-zA-Z0-9]*$"; // Start with a letter, no spaces
        Pattern pattern = Pattern.compile(usernamePattern);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    // Regex to validate ID format
    private boolean isValidId(String id) {
        String idPattern = "^[0-9]+$"; // Digits only
        Pattern pattern = Pattern.compile(idPattern);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    private void showToast(String message) {
        Toast.makeText(RegexValidation.this, message, Toast.LENGTH_SHORT).show();
    }

    private void clearFormFields() {
        editTextUsername.setText("");
        editTextFullName.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextId.setText("");
    }

}