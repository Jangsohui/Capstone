package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtId, edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtId = findViewById(R.id.edtId);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = edtId.getText().toString();
                String password = edtPassword.getText().toString();

                // 로그인 처리를 하면 됩니다.
                // 예시: 입력받은 사용자 이름과 비밀번호를 체크하여 로그인 처리
                if (true) { //userId.equals("sohee") && password.equals("0000")
                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                    // 로그인 처리 후 RoomActivity 화면으로 이동합니다.
                    Intent intent = new Intent(MainActivity.this, RoomlistActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}