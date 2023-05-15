package com.example.capstone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.pircbotx.exception.IrcException;

import java.io.IOException;

public class RoomActivity extends AppCompatActivity { //방 내부에 있는 코드 아직은 뒤로가기 버튼만 누를 수 있음.
    //리스너 객체 생성 코드
    MyListener listenerTest;
    Button btnBack, btnSetup, btnSend;
    TextView tvRoomname, tvChat;
    EditText edtInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room);

        // MyListener 객체를 생성
        listenerTest = new MyListener();

        btnBack = findViewById(R.id.btnBack);
        btnSetup = findViewById(R.id.btnSetup);
        tvRoomname = findViewById(R.id.tvRoomname);
        tvChat = findViewById(R.id.tvChat);
        btnSend = findViewById(R.id.btnSend);
        edtInput = findViewById(R.id.edtInput);

//        //생성 후 봇 생성
//        try { //본래 깃허브 코드는 아예 서버 구성이 메인코드이지만 우리는 메인말고 안쪽 방에서 서버와 연결한다.
//            //그렇기 때문에 Exception을 던져 주었다.
//            //하지만 지금 내가 코드를 상상으로 치고 있기 때문에, 잘 돌아갈지 모르겠다. 나의 상상에서는 이렇게 하면 될 것 같았다.
//            //그러니까, 지금 나는 우리 집의 여분 노트북으로 작업중이기에 굉장히 느리고, 애뮬레이터가 돌아가지 않아 확인이 어렵다. -재은
//            listenerTest.startBotTest();
//        } catch (IOException | IrcException e) {
//            throw new RuntimeException(e);
//        }
        
        //메세지 보내는 버튼
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //가져와서 메세지 보내기, 그러면 onMessage가 받아서 처리해주겠지.
                listenerTest.sendMessage(edtInput.getText().toString());
            }
        });


        //뒤로가기 버튼
        btnBack.setOnClickListener(new View.OnClickListener() { // 뒤로가기 버튼을 눌렀을 때 다시 룸 리스트 화면으로 돌아감
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RoomlistActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //혹시 리스너가 필요하면 사용
//    public MyListener getListener() {
//        return listenerTest;
//    }
}
