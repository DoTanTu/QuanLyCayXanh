package com.example.quanlycayxanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button button;
    EditText userName;
    EditText password;
    TextView textView;
    CheckBox checkBox;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView txt = (TextView) findViewById(R.id.textView_lg);
        txt.setPaintFlags(txt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        userName = (EditText) findViewById(R.id.id_userName_lg);
        password = (EditText) findViewById(R.id.id_pass_lg);
        button = (Button) findViewById(R.id.id_button_lg);
        checkBox = (CheckBox) findViewById(R.id.id_checkbox_login);
        textView = (TextView) findViewById(R.id.textView_lg);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        userName.setText(sharedPreferences.getString("taikhoan", ""));
        password.setText(sharedPreferences.getString("matkhau", ""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked", false));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                directSignUp();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = userName.getText().toString();
                String Pass = password.getText().toString();

                String userName_login = "DoTanTu";
                String passWord_login = "12345";

                if (User.equals(userName_login) == true && Pass.equals(passWord_login) == true) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT);
                    if (checkBox.isChecked()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", User);
                        editor.putString("matkhau", Pass);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                    directHome();

                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("taikhoan");
                    editor.remove("matkhau");
                    editor.remove("checked");
                    editor.commit();
                    if (User.equals("") || Pass.equals(""))
                        Toast.makeText(LoginActivity.this, "You need to fill in information", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(LoginActivity.this, "Check again username or password", Toast.LENGTH_SHORT).show();

                }

            }

        });


    }

    public void directHome() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void directSignUp() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}
