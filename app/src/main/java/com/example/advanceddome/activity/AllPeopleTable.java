package com.example.advanceddome.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advanceddome.MainActivity;
import com.example.advanceddome.R;
import com.example.advanceddome.entity.Json_PeopleAll;
import com.example.advanceddome.entity.Json_UserLineAll;
import com.example.advanceddome.utils.MyHttp;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllPeopleTable extends AppCompatActivity {


    private ImageView mMainReturn;
    private ListView mAllpeopleLv;
    private List<Json_UserLineAll> userLineAlls;
    private List<Json_PeopleAll.DataEntity> userPersonEntities;//所有宿舍
    private Gson gson;
    ItemAllpeopleTableAdapter itemAllpeopleTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_people_table);
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
        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                int userLineSize = bundle.getInt("userLineSize", -1);
                if (userLineSize != -1) {
                    //通过上一个界面获取所有宿舍里的人
                    for (int i = 0; i < userLineSize; i++) {
                        userPersonEntities.add((Json_PeopleAll.DataEntity) bundle.getSerializable("userLine" + i));
                    }
                    itemAllpeopleTableAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        mMainReturn = findViewById(R.id.main_return);
        mAllpeopleLv = findViewById(R.id.allpeople_lv);
        userPersonEntities = new ArrayList<>();
         itemAllpeopleTableAdapter  = new ItemAllpeopleTableAdapter();
        mAllpeopleLv.setAdapter(itemAllpeopleTableAdapter);
    }

    public class ItemAllpeopleTableAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return userPersonEntities.size();
        }

        @Override
        public Json_PeopleAll.DataEntity getItem(int position) {
            return userPersonEntities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_allpeople_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews(( Json_PeopleAll.DataEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews( Json_PeopleAll.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemAllpeopleId.setText(object.getId()+"");
                holder.itemAllpeopleName.setText(object.getPeopleName()+"");
                holder.itemAllpeoplePost.setText(object.getContent()+"");
                holder.itemAllpeoplePrice.setText(object.getGold()+"");
                holder.itemAllpeopleState.setText(object.isWork()?"已雇佣":"未雇佣");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView itemAllpeopleId;
            private TextView itemAllpeopleName;
            private TextView itemAllpeoplePost;
            private TextView itemAllpeoplePrice;
            private TextView itemAllpeopleState;

            public ViewHolder(View view) {
                itemAllpeopleId = (TextView) view.findViewById(R.id.item_allpeople_id);
                itemAllpeopleName = (TextView) view.findViewById(R.id.item_allpeople_name);
                itemAllpeoplePost = (TextView) view.findViewById(R.id.item_allpeople_post);
                itemAllpeoplePrice = (TextView) view.findViewById(R.id.item_allpeople_price);
                itemAllpeopleState = (TextView) view.findViewById(R.id.item_allpeople_state);
            }
        }
    }

}