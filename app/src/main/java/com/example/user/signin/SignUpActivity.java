package com.example.user.signin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEditText, emailEditText, usernameEditText, passwordEditText;
    private Button signUp ;
    UserDetails userDetails;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameEditText = findViewById(R.id.signupnameEditTextId);
        emailEditText = findViewById(R.id.signupEmailEditTextId);
        usernameEditText = findViewById(R.id.signupusernameEditTextId);
        passwordEditText = findViewById(R.id.signupPasswordEditTextId);
        signUp = findViewById(R.id.signupbutton);
        userDetails = new UserDetails();
        databaseHelper = new DatabaseHelper(this);

        signUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setUsername(username);
        userDetails.setPassword(password);

        long rowId = databaseHelper.insertData(userDetails);

        if (rowId > 0) {
            Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Row insertion failed", Toast.LENGTH_SHORT).show();
        }

    }


}
