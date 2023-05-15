package com.example.capstone;

import android.widget.EditText;
import android.widget.TextView;

import org.pircbotx.Configuration;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

import java.io.IOException;

public class MyListener extends ListenerAdapter {
//    TextView  tvChat; //좀 이해가 안되네. 여기서 사용한 tvChat이랑 RoomActivity의 tvChat이 연결되어 있는건가?
    //이렇게 수정하면 되지 않으려나? 아니 뭐 확인을 해야지 오류가 나는걸 알던 말던하지 거 참 -재은
    private RoomActivity room;
    
    String message,oldText,newText;
    PircBotX bot;

    public void setRoomActivity(RoomActivity roomActivity) {
        this.room = roomActivity;
    }

    //깃허브에서 가져온 예시코드
    @Override
    public void onGenericMessage(GenericMessageEvent event) {
        if (event.getMessage().startsWith("?helloworld"))
            event.respond("Hello world!");
    }

    public static void main(String[] args) throws Exception {
        MyListener listenerTest = new MyListener();
        Configuration configuration = new Configuration.Builder()
                .setName("testUser") //닉네임 입력
                .addServer("irc.freenode.net") //무료 네트워크 서버 제공
                .addAutoJoinChannel("#testCap") //채널 이름은 임의로 가능
                .addListener(listenerTest) //리스너 추가
                .buildConfiguration();

        //봇 만들기
        PircBotX bot = new PircBotX(configuration);
        //서버에 연결
        bot.startBot();
    }

    //찾아보니까 이 메서드도 있다. 뭐. 다있다.
    //이건 자동호출이란다.
    @Override
    public void onMessage(MessageEvent event) {
        //목표 : 버튼 클릭시 EditText의 내용을 가져와서 출력할 수 있도록 만들어야함
        //그냥 내 코드 복붙해도 되는데 왜 내가 이걸 다시 치고 있을까. 내 노트북 충전기를 놓고 왔기 때문이지.
        // EditText에서 메시지를 가져옴. 오래된 메세지도 계속 보이도록 코딩할 것

        //2.
        String message = event.getMessage();

        // RoomActivity의 TextView인 tvChat 업데이트
        if (room != null) { //null은 걱정하지 말아라! 객체 생성이 잘 되었다면 오류가 나지 않을것이다. 반대로 말하면, 오류가나면 객체 생성이 안된것.
            TextView tvChat = room.findViewById(R.id.tvChat);
            oldText = tvChat.getText().toString();
            String nickname = bot.getNick();
            newText = oldText + "\n" + nickname + ": " + message;
            room.tvChat.setText(newText);
            tvChat.setText(message);
        }
    }

    //이게 있어야 메세지를 보내줄수 있다.
    public void sendMessage(String message) {
        bot.send().message("#testCap", message);
    }

//    public void setListenerTest(MyListener listenerTest) {
//        room.listenerTest = listenerTest;
//    }
}
