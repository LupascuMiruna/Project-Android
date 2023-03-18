package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email, password, confirmPassword;
    Button register;
    TextView existingUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.editTextRegUsername);
        email = findViewById(R.id.editTextRegEmail);
        password = findViewById(R.id.editTextRegPassword);
        confirmPassword = findViewById(R.id.editTextRegConfPassword);
        register = findViewById(R.id.buttonReg);
        existingUser = findViewById(R.id.textViewExistingUser);

        existingUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameInput = username.getText().toString();
                String emailInput = email.getText().toString();
                String passwordInput = password.getText().toString();
                String confPassInput = confirmPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "projectDB", null, 1);

                if(usernameInput.length() == 0 || emailInput.length() == 0 || passwordInput.length() == 0 || confPassInput.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_SHORT);
                } else {
                    if(passwordInput.compareTo(confPassInput) == 0){
                        if(isValidPassword(passwordInput)) {
                            db.register(usernameInput, emailInput, passwordInput);
                            Toast.makeText(getApplicationContext(), "Succesfully regitered", Toast.LENGTH_LONG);
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        } else{
                            Toast.makeText(getApplicationContext(), "Password must contain at least 6 characters, a letter and a digit", Toast.LENGTH_SHORT);
                        }
                    } else{
                        Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT);
                    }
                }
            }
        });
    }

    public static boolean isValidPassword(String password) {
        boolean digit = false, letter = false;
        if (password.length() < 6) {
            return false;
        }
        for(int index = 0; index < password.length(); index++) {
            if (Character.isLetter(password.charAt(index))) {
                letter = true;
            }
            if (Character.isDigit(password.charAt(index))) {
                digit = true;
            }
        }
        return digit && letter;
    }
}