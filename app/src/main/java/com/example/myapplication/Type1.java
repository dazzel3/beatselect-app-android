package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Type1 extends AppCompatActivity {

    ArrayList<Song> al = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type1);
        // ArrayList 에 추가
        al.add(new Song("BETTER 그레이 x 로꼬 타입 트렌디한 팝 비트",R.drawable.type1_1,"아틱 Arctic",R.raw.better,"https://bsta.rs/5810dda", "arctic9114@gmail.com"));
        al.add(new Song("Cocktail 빈지노 x 재지팩트 타입 재즈 비트",R.drawable.type1_2,"그래비 Grabby",R.raw.cocktail,"https://pumpyoursound.com/fangate/detail/86991?channel=grabby","tjdtmxpvksh@naver.com"));
        al.add(new Song("True 기리보이 x 창모 타입 감성 트랩비트",R.drawable.type1_3,"프라이드 Pr!d3",R.raw.trues,"https://bit.ly/3huEBvD", "thechemicaldependent@gmail.com"));
        al.add(new Song("GOOD BYE 그레이 x 기리보이 타입 감성 비트",R.drawable.type1_4,"콜디스트 COLDE$T",R.raw.goodbye,"https://coldestbeatz.beatstars.com/beat/good-bye-5238988","presto3179@gmail.com"));
        al.add(new Song("MOTION 코드쿤스트 x 우원재 타입 감성 비트",R.drawable.type1_5,"아틱 Arctic",R.raw.motion,"https://bsta.rs/7e80b11f", "arctic9114@gmail.com"));
        al.add(new Song("Story 창모 x 폴 블랑코 타입 감성 비트",R.drawable.type1_6,"그래비 Grabby",R.raw.story,"https://pumpyoursound.com/f/pys/cm/88447","tjdtmxpvksh@naver.com"));
        al.add(new Song("AIR 김하온 x 그루비룸 타입 트렌디 팝 비트",R.drawable.type1_7,"아틱 Arctic",R.raw.air,"https://bsta.rs/ec5e4e27", "arctic9114@gmail.com"));
        al.add(new Song("REST 팔로알토 x 코드쿤스트 타입 붐뱁 비트",R.drawable.type1_8,"아틱 Arctic",R.raw.rest,"https://bsta.rs/vk7344", "arctic9114@gmail.com"));

        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, al);

        ListView lv = (ListView)findViewById(R.id.list_type1);
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



