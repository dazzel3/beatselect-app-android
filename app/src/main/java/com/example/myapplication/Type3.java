package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
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

public class Type3 extends AppCompatActivity {

    ArrayList<Song> al = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type3);
        // ArrayList 에 추가
        al.add(new Song("I'M FINE 페노메코 x pH-1 타입 트렌디한 비트",R.drawable.type3_1,"콜디스트 COLDE$T",R.raw.imfine,"https://coldestbeatz.beatstars.com/beat/im-fine-5046247", "presto3179@gmail.com"));
        al.add(new Song("Velvet 기리보이 타입 통통튀는 트랩비트",R.drawable.type3_2,"프라이드 Pr!d3", R.raw.velvet, "https://bit.ly/2PpngHN", "thechemicaldependent@gmail.com"));
        al.add(new Song("YEAH 그레이 x 오르내림 타입 퓨처 팝 비트",R.drawable.type3_3,"태비 TAEB", R.raw.imfine,"https://www.beatstars.com/beat/5774455","sdf2390@gmail.com"));
        al.add(new Song("COCKTAIL 보이콜드 x 쿠기 타입 밝은 트랩비트",R.drawable.type3_4,"콜디스트 COLDE$T",R.raw.cocktails,"https://coldestbeatz.beatstars.com/beat/cocktail-5686062","presto3179@gmail.com"));
        al.add(new Song("Pilot 기리보이 x 서동현 타입 시원한 비트",R.drawable.type3_5,"WhiteLIT & Thunder Dragon",R.raw.pilot,"https://hypeddit.com/track/u1mmu5","whitelit9999@naver.com"));
        al.add(new Song("Fiction 서동현 타입 상큼한 여름 비트",R.drawable.type3_6,"대한 daehan",R.raw.fiction,"https://pumpyoursound.com/f/pys/fiction/92927","yeorim_16@naver.com"));
        al.add(new Song("사람들은 다똑같아 염따 x 서동현 타입 비트",R.drawable.type3_7,"찬스 chAN's",R.raw.same,"https://chans.beatstars.com/beat/--3432386","monshow@naver.com"));
        al.add(new Song("RUN! 그루비룸 x 김하온 타입 신나는 비트",R.drawable.type3_8,"푸시보이 PoosieBoy",R.raw.run,"https://hypeddit.com/track/2jbptv","poosiebo2@gmail.com"));

        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row, al);

        ListView lv = (ListView)findViewById(R.id.list_type3);
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

// 리스트뷰의 Adapter
class MyAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Song> al;
    LayoutInflater inf;

    public MyAdapter(Context context, int layout, ArrayList<Song> al) {
        this.context = context;
        this.layout = layout;
        this.al = al;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return al.size();
    }
    @Override
    public Object getItem(int position) {
        return al.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inf.inflate(layout, null);
        }
        ImageView iv = (ImageView)convertView.findViewById(R.id.imageView1);
        TextView tvName = (TextView)convertView.findViewById(R.id.textView1);
        TextView tvInfo = (TextView)convertView.findViewById(R.id.textView2);

        Song m = al.get(position);
        iv.setImageResource(m.img);
        tvName.setText(m.title);
        tvInfo.setText(m.artist);

        return convertView;
    }
}

class Song {
    String title = ""; // 곡 title
    int img; // 앨범 이미지
    String artist = ""; // artist 이름
    int music; // 음악 파일
    String uri; // 비트 구매 url
    String email; // artist 이메일

    public Song(String title, int img, String artist, int music, String uri, String email) {
        super();
        this.title = title;
        this.img = img;
        this.artist = artist;
        this.music = music;
        this.uri = uri;
        this.email = email;
    }
    public Song() {}
}