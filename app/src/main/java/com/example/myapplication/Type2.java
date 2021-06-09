package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Type2 extends AppCompatActivity {

    ArrayList<Song> al = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type2);
        // ArrayList 에 추가
        al.add(new Song("Zodiac 키드밀리 타입 하드한 트랩비트",R.drawable.type2_1,"프라이드 Pr!d3",R.raw.zodiac,"https://bit.ly/2CJWM0w", "thechemicaldependent@gmail.com"));
        al.add(new Song("MAFIA 저스디스 x 나플라 타입 붐뱁비트",R.drawable.type2_2,"콜디스트 COLDE$T",R.raw.mafla,"https://coldestbeatz.beatstars.com/beat/mafia-5749389","presto3179@gmail.com"));
        al.add(new Song("Oops! 쿠기 타입 랩하기 좋은 트랩비트",R.drawable.type2_3,"프라이드 Pr!d3",R.raw.oops,"https://bit.ly/33ObVJF", "thechemicaldependent@gmail.com"));
        al.add(new Song("KOTO 동양풍 랩하기 좋은 드럼 트랩비트",R.drawable.type2_4,"화이트릿 WhiteLIT",R.raw.koto,"https://hypeddit.com/track/zq8iao","whitelit9999@naver.com"));
        al.add(new Song("Selfmade 창모 X 수퍼비 타입 빡센 트랩비트",R.drawable.type2_5,"프라이드 Pr!d3",R.raw.selfmade,"https://bit.ly/3hTupMR", "thechemicaldependent@gmail.com"));
        al.add(new Song("AK47 2 랩하기 좋은 빡센 트랩비트",R.drawable.type2_6,"프라이드 Pr!d3",R.raw.ak,"https://bit.ly/3p1jogF", "thechemicaldependent@gmail.com"));
        al.add(new Song("Skirr 찰진 동양풍 빡센 트랩비트",R.drawable.type2_7,"프라이드 Pr!d3",R.raw.skirr,"https://bit.ly/3d521oP", "thechemicaldependent@gmail.com"));
        al.add(new Song("Maestro 창모 X 수퍼비 타입 트랩비트",R.drawable.type2_8,"프라이드 Pr!d3",R.raw.maestro,"https://bit.ly/2VYRsgL", "thechemicaldependent@gmail.com"));

        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, al);

        ListView lv = (ListView)findViewById(R.id.list_type2);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 상세정보 화면으로 이동하기 (Intent 날리기)
                Intent intent = new Intent( getApplicationContext(), SongDetail.class); // 넘어갈 화면

                // intent 객체에 데이터를 실어 보내기
                // 리스트뷰 클릭 시, Intent 생성하고 position 값을 이용하여 인텐트로 넘길 값들을 넘김
                intent.putExtra("title", al.get(position).title);
                intent.putExtra("img", al.get(position).img);
                intent.putExtra("artist", al.get(position).artist);
                intent.putExtra("music",al.get(position).music);
                intent.putExtra("uri",al.get(position).uri);
                intent.putExtra("email",al.get(position).email);

                startActivity(intent);
            }
        });
    }
}