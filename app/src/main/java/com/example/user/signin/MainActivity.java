package com.example.user.signin;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button LogInButton,SignupHereButton;
    private EditText UserNameEditText,PasswordEditText;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogInButton= findViewById(R.id.logInbuttonId);
        SignupHereButton= findViewById(R.id.signupbuttonId);
        UserNameEditText= findViewById(R.id.logInusernameEditTextId);
        PasswordEditText= findViewById(R.id.logInpasswordEditTextId);
        databaseHelper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();


        LogInButton.setOnClickListener(this);
        SignupHereButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        String UserName=UserNameEditText.getText().toString();
        String Password=PasswordEditText.getText().toString();

        if(view.getId()==R.id.logInbuttonId)
        {
            Boolean result =databaseHelper.findPassword(UserName,Password);
            if(result==true){
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            } else{

                Toast.makeText(getApplicationContext(), "username and Password didn't match", Toast.LENGTH_SHORT).show();
            }
        }else if (view.getId()==R.id.signupbuttonId){
            Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
            startActivity(intent);
        }

    }
}
