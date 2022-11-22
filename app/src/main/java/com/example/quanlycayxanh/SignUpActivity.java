package com.example.quanlycayxanh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class SignUpActivity extends AppCompatActivity {
    Button button;
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText password;
    EditText confirmPassword;
    TextView textView;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstName = (EditText) findViewById(R.id.id_firstname_account);
        lastName =  (EditText) findViewById(R.id.id_lastname_account);
        email = (EditText) findViewById(R.id.id_email_new) ;
        confirmPassword = (EditText) findViewById(R.id.id_confirm_pass_new) ;
        button = (Button) findViewById(R.id.id_button_new_account);
        textView = (TextView) findViewById(R.id.textView_new_account);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTextView();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fistNames = firstName.getText().toString();
                String lastNames = lastName.getText().toString();
                String Emails = email.getText().toString();
                String PassWords = password.getText().toString();
                String confirmPasswords = confirmPassword.getText().toString();
                if(fistNames.equals("")||lastNames.equals("")||Emails.equals("")||PassWords.equals("")||confirmPasswords.equals(""))
                    Toast.makeText(SignUpActivity.this,"You need to enter information",Toast.LENGTH_SHORT).show();

                else
                if(PassWords.equals(confirmPasswords)==true)
                    setButton();
                else
                    Toast.makeText(SignUpActivity.this,"password incorrect",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setButton(){
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void setTextView() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
