package com.example.advanceddome.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.advanceddome.R;
import com.example.advanceddome.entity.Json_NoticeAll;

public class MyNotice extends AppCompatActivity {

    private ImageView mMainReturn;
    private TextView mNoticeTitle;
    private TextView mNoticeText;
    private ImageView mNoticeIv;
    private VideoView mNoticeVv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notice);
        initView();
        setView();
        click();
    }

    private void click() {
        mMainReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
           Json_NoticeAll.DataEntity entity = (Json_NoticeAll.DataEntity) bundle.getSerializable("noticeEntity");
           if (entity!=null){
               mNoticeTitle.setText(entity.getInformationName());
               mNoticeText.setText(entity.getWords());
               if (entity.getIcon()!=null){
               Glide.with(this).load("http://172.168.10.100/"+entity.getIcon()).into(mNoticeIv);
               }else {
                   mNoticeIv.setVisibility(View.GONE);
               }
               if (entity.getVideo()!=null){
                   mNoticeVv.setVideoPath("http://172.168.10.100"+entity.getVideo());
                   mNoticeVv.start();
               }else {
                   mNoticeVv.setVisibility(View.GONE);
               }
           }
        }
    }

    private void initView() {
        mMainReturn = findViewById(R.id.main_return);
        mNoticeTitle = findViewById(R.id.notice_title);
        mNoticeText = findViewById(R.id.notice_text);
        mNoticeIv = findViewById(R.id.notice_iv);
        mNoticeVv = findViewById(R.id.notice_vv);
    }
}