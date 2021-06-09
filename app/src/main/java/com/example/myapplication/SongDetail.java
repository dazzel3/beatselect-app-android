package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class SongDetail extends AppCompatActivity {

    Button btn1, btn2, btn3;
    MediaPlayer mp;
    SeekBar seekBar;

    Button purchase;
    String uri, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        uri = getIntent().getStringExtra("uri");
        email = getIntent().getStringExtra("email");

        purchase = (Button) findViewById(R.id.btn_purchase);

        //purchase 버튼 클릭 시, 이벤트 처리
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // purchase 버튼 클릭하면 PopupMenu 생성됨
                PopupMenu popup = new PopupMenu(getApplicationContext(), v);

                getMenuInflater().inflate(R.menu.purchase_popup, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.p1:
                                // PopupMenu 에서 문의 클릭 시, 대화상자 나옴
                                AlertDialog.Builder dlg = new AlertDialog.Builder(SongDetail.this);
                                dlg.setTitle("BeatMaker Contact"); // 제목
                                dlg.setMessage(email); // 메세지 -> 각 아티스트에 해당하는 이메일 주소
                                dlg.setPositiveButton("확인",new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
                                        // 확인 클릭 시, Toast 메세지
                                        Toast.makeText(getApplication(), "확인을 누르셨습니다.",Toast.LENGTH_SHORT).show();
                                    }
                                });
                                dlg.show();
                                break;
                            case R.id.p2:
                                // PopupMenu 에서 구매링크 클릭 시, 해당 url로 이동
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                                startActivity(intent2);
                                // 해당 url 이동하며 나오는 Toast 메세지
                                Toast.makeText(getApplication(), "구매링크로 이동합니다.", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });

                popup.show(); //PopupMenu 보이기
            }
        });

        TextView tvTitle = (TextView) findViewById(R.id.textView1);
        TextView tvArtist = (TextView) findViewById(R.id.textView2);
        ImageView iv = (ImageView) findViewById(R.id.imageView1);

        Intent intent = getIntent(); // 보내온 Intent를 얻는다
        tvTitle.setText(intent.getStringExtra("title"));
        tvArtist.setText(intent.getStringExtra("artist"));
        iv.setImageResource(intent.getIntExtra("img", 0));

        btn1 = (Button) findViewById(R.id.btn_play);
        btn2 = (Button) findViewById(R.id.btn_stop);
        btn3 = (Button) findViewById(R.id.btn_pause);

        mp = MediaPlayer.create(SongDetail.this, intent.getIntExtra("music", 0));

        seekBar = (SeekBar) findViewById(R.id.playbar);
        seekBar.setVisibility(ProgressBar.VISIBLE);
        seekBar.setMax(mp.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mp.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                Thread();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                try {
                    mp.prepare();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
                mp.seekTo(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });


    }

    public void Thread() {
        Runnable task = new Runnable() {


            public void run() {
                // 음악이 재생중일때
                while (mp.isPlaying()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    seekBar.setProgress(mp.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }
}

