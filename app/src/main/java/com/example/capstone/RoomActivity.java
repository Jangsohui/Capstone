package com.example.capstone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity { //방 내부에 있는 코드 아직은 뒤로가기 버튼만 누를 수 있음.

    Button btnBack, btnSetup;
    TextView tvRoomname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room);

        btnBack = findViewById(R.id.btnBack);
        btnSetup = findViewById(R.id.btnSetup);
        tvRoomname = findViewById(R.id.tvRoomname);

        btnBack.setOnClickListener(new View.OnClickListener() { // 뒤로가기 버튼을 눌렀을 때 다시 룸 리스트 화면으로 돌아감
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RoomlistActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

//컨텍스트
