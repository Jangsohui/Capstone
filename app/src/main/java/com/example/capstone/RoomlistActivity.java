package com.example.capstone;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class RoomlistActivity extends AppCompatActivity {
    Button btnCreateRoom; //이건 방 만드는 버튼인데 아직 구현중이라 사용 XX
    ListView lvRoomList;

    // 가상의 방 목록
    ArrayList<String> roomList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_list);

//        btnCreateRoom = findViewById(R.id.btnCreateRoom);
        lvRoomList = findViewById(R.id.lvRoomList);

        // 가상의 방 목록을 생성합니다. 아직 연동 안해서 for이용해서 가상으로 만듬
        roomList = new ArrayList<>();
        roomList.add("캡스톤");
        for (int i = 1; i <= 20; i++) {
            roomList.add("방 " + i);
        }

        // 방 목록을 리스트뷰에 표시한다. 내가 들어갈 수 있는 방 종류
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, roomList);
        lvRoomList.setAdapter(adapter);


        // 리스트뷰의 아이템을 클릭하면 해당 방에 입장합니다.
        lvRoomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //입장하는거 알기 위해서 토스트 띄움
                String roomName = (String) parent.getItemAtPosition(position);
                Toast.makeText(RoomlistActivity.this, roomName + "에 입장합니다.", Toast.LENGTH_SHORT).show();

                // 로그인 처리 후 RoomActivity 화면으로 이동합니다.
                Intent intent = new Intent(RoomlistActivity.this, RoomActivity.class);
                startActivity(intent);

            }
        });
    }
}

//        // 방 생성 버튼을 누르면 CreateRoomActivity로 이동합니다.
//        btnCreateRoom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RoomlistActivity.this, CreateRoomActivity.class);
//                startActivity(intent);
//            }
//        });
