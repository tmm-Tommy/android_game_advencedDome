package com.example.advanceddome.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.example.advanceddome.R;
import com.example.advanceddome.entity.Json_MaterialAll;
import com.example.advanceddome.entity.Json_MaterialLog;
import com.example.advanceddome.utils.MyHttp;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyMaterialAll extends AppCompatActivity {

    private ImageView mMainReturn;
    private ListView mMaterialLv;
    private List<Json_MaterialAll.DataEntity> materials;
    private List<Json_MaterialLog.DataEntity> materialLogs;
    private int userLine = 0;
    private ItemMaterialTableAdapter itemMaterialTableAdapter;
    private Gson gson;
    private boolean isFilter2 = false;
    private boolean isFilter4 = false;
    private TextView mMaterialFilter2;
    private TextView mMaterialFilter4;
    private TextView mMaterialLog;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private ItemMateriallogTableAdapter itemMateriallogTableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_material_all);
        initView();
        setView();
        click();
    }

    private void setView() {
        if (getIntent() != null)
            userLine = getIntent().getIntExtra("userLine", 0);
        updataMainView();
    }

    /**
     * 获取数据并显示界面
     */
    private void updataMainView() {
        MyHttp.Call(this, "Interface/index/supplyListTEditer", true, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_MaterialAll json_materialAll = gson.fromJson(jsonObject.toString(), Json_MaterialAll.class);
                materials = json_materialAll.getData();
                itemMaterialTableAdapter.notifyDataSetChanged();
            }
        });
        MyHttp.Call(this, "Interface/index/getUserMaterialLog", false, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_MaterialLog json_materialLog = gson.fromJson(jsonObject.toString(), Json_MaterialLog.class);
                materialLogs = json_materialLog.getData();
                Collections.sort(materialLogs, new Comparator<Json_MaterialLog.DataEntity>() {
                    @Override
                    public int compare(Json_MaterialLog.DataEntity dataEntity, Json_MaterialLog.DataEntity t1) {
                        return t1.getTime() - dataEntity.getTime();
                    }
                });
                itemMateriallogTableAdapter.notifyDataSetChanged();
            }
        });
    }

    private void click() {
        mMainReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //点击排序
        mMaterialFilter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFilter2 = !isFilter2;
                Collections.sort(materials, new Comparator<Json_MaterialAll.DataEntity>() {
                    @Override
                    public int compare(Json_MaterialAll.DataEntity dataEntity, Json_MaterialAll.DataEntity t1) {
                        if (isFilter2)
                            return dataEntity.getMaterialName().charAt(0) - t1.getMaterialName().charAt(0);
                        else
                            return t1.getMaterialName().charAt(0) - dataEntity.getMaterialName().charAt(0);
                    }
                });
                itemMaterialTableAdapter.notifyDataSetChanged();
                mMaterialFilter2.setText("商品名称" + (isFilter2 ? "▲" : "▼"));
            }
        });
        mMaterialFilter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFilter4 = !isFilter4;
                Collections.sort(materials, new Comparator<Json_MaterialAll.DataEntity>() {
                    @Override
                    public int compare(Json_MaterialAll.DataEntity dataEntity, Json_MaterialAll.DataEntity t1) {
                        if (isFilter4)
                            return dataEntity.getPrice() - t1.getPrice();
                        else return t1.getPrice() - dataEntity.getPrice();
                    }
                });
                itemMaterialTableAdapter.notifyDataSetChanged();
                mMaterialFilter4.setText("价格" + (isFilter4 ? "▲" : "▼"));
            }

        });
        //点击显示日志
        mMaterialLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updataMainView();
                View viewLog = LayoutInflater.from(getApplicationContext()).inflate(R.layout.log_material_log,null);
                final AlertDialog log = new AlertDialog.Builder(MyMaterialAll.this)
                        .setView(viewLog)
                        .show();
                //获取id
                log.getWindow().setLayout(1800, LinearLayout.LayoutParams.WRAP_CONTENT);
                ListView  logMaterialLv = (ListView) viewLog.findViewById(R.id.log_material_lv);
                TextView logMaterialCancel = (TextView) viewLog.findViewById(R.id.log_material_cancel);
                TextView logMaterialAutoAdd  = viewLog.findViewById(R.id.log_material_autoAdd);
                logMaterialCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        log.cancel();
                    }
                });
                logMaterialAutoAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //自动补货
                        MyHttp.Call(MyMaterialAll.this, "Interface/index/addUserMaterial?userLineId="+userLine, true, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getInt("status") == 200){
                                        Toast.makeText(MyMaterialAll.this, "补货成功!", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(MyMaterialAll.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
                logMaterialLv.setAdapter(itemMateriallogTableAdapter);
            }
        });
    }

    private void initView() {
        mMainReturn = findViewById(R.id.main_return);
        mMaterialLv = findViewById(R.id.material_lv);
        materials = new ArrayList<>();
        itemMaterialTableAdapter = new ItemMaterialTableAdapter();
        mMaterialLv.setAdapter(itemMaterialTableAdapter);
        mMaterialFilter2 = findViewById(R.id.material_filter2);
        mMaterialFilter4 = findViewById(R.id.material_filter4);
        mMaterialLog = findViewById(R.id.material_log);
        materialLogs = new ArrayList<>();
        itemMateriallogTableAdapter = new ItemMateriallogTableAdapter();
    }

    public class ItemMaterialTableAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return materials.size();
        }

        @Override
        public Json_MaterialAll.DataEntity getItem(int position) {
            return materials.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_material_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_MaterialAll.DataEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(final Json_MaterialAll.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemMaterialId.setText(object.getId() + "");
                holder.itemMaterialName.setText(object.getMaterialName() + "");
                holder.itemMaterialNum.setText(object.getNum() + "");
                holder.itemMaterialPrice.setText(object.getPrice() + "");
                holder.itemMaterialSuperName.setText(object.getSupplyName() + "");
                holder.itemMaterialSet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MyHttp.Call(MyMaterialAll.this, "Interface/index/addUserMaterialStore?userLineId=" + userLine + "&num=" + object.getNum() + "&supplyListId=" + object.getId(), true, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getInt("status") == 200) {
                                        Toast.makeText(MyMaterialAll.this, "进货成功!", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MyMaterialAll.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView itemMaterialId;
            private TextView itemMaterialName;
            private TextView itemMaterialSuperName;
            private TextView itemMaterialPrice;
            private TextView itemMaterialNum;
            private TextView itemMaterialSet;

            public ViewHolder(View view) {
                itemMaterialId = (TextView) view.findViewById(R.id.item_material_id);
                itemMaterialName = (TextView) view.findViewById(R.id.item_material_name);
                itemMaterialSuperName = (TextView) view.findViewById(R.id.item_material_superName);
                itemMaterialPrice = (TextView) view.findViewById(R.id.item_material_price);
                itemMaterialNum = (TextView) view.findViewById(R.id.item_material_num);
                itemMaterialSet = (TextView) view.findViewById(R.id.item_material_set);
            }
        }
    }

    public class ItemMateriallogTableAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return materialLogs.size();
        }

        @Override
        public Json_MaterialLog.DataEntity getItem(int position) {
            return materialLogs.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_materiallog_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_MaterialLog.DataEntity)getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(Json_MaterialLog.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemMateriallogId.setText(object.getId()+"");
                holder.itemMateriallogName.setText(object.getMaterialName()+"");
                holder.itemMateriallogNum.setText(object.getNum()+"");
                holder.itemMateriallogPrice.setText(object.getPrice()+"");
                holder.itemMateriallogSuperName.setText(object.getSupplyName()+"");
                holder.itemMateriallogTime.setText(simpleDateFormat.format(object.getTime()*1000L));
                holder.itemMateriallogUserLine.setText(object.getLineName()+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView itemMateriallogId;
            private TextView itemMateriallogName;
            private TextView itemMateriallogSuperName;
            private TextView itemMateriallogUserLine;
            private TextView itemMateriallogTime;
            private TextView itemMateriallogPrice;
            private TextView itemMateriallogNum;

            public ViewHolder(View view) {
                itemMateriallogId = (TextView) view.findViewById(R.id.item_materiallog_id);
                itemMateriallogName = (TextView) view.findViewById(R.id.item_materiallog_name);
                itemMateriallogSuperName = (TextView) view.findViewById(R.id.item_materiallog_superName);
                itemMateriallogUserLine = (TextView) view.findViewById(R.id.item_materiallog_userLine);
                itemMateriallogTime = (TextView) view.findViewById(R.id.item_materiallog_time);
                itemMateriallogPrice = (TextView) view.findViewById(R.id.item_materiallog_price);
                itemMateriallogNum = (TextView) view.findViewById(R.id.item_materiallog_num);
            }
        }
    }


}