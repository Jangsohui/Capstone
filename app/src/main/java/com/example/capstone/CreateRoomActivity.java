package com.example.capstone;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// 방 생성을 위한 액티비티입니다.
public class CreateRoomActivity extends AppCompatActivity {
    EditText edtRoomName;
    Button btnCreate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_room);

        edtRoomName = findViewById(R.id.edtRoomName);
        btnCreate = findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = edtRoomName.getText().toString();

                // 방 이름이 비어있지 않은 경우 방을 생성합니다.
                if (!roomName.isEmpty()) {
                    // 방을 생성하는 코드를 작성합니다.
                    Toast.makeText(CreateRoomActivity.this,
                            roomName + " 방이 생성되었습니다.", Toast.LENGTH_SHORT).show();

                    // 방 생성 후에 RoomListActivity로 돌아갑니다.
                    finish();
                }
            }
        });
    }
}
