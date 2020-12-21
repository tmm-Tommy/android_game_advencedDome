package com.example.advanceddome.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.example.advanceddome.R;
import com.example.advanceddome.entity.Json_NotCarAll;
import com.example.advanceddome.entity.Json_OkCarAll;
import com.example.advanceddome.utils.MyHttp;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MyCarTable extends AppCompatActivity {

    private ImageView mMainReturn;
    private TextView mCarNotCar;
    private TextView mOrderSwitchView;
    private ListView mMycarLv;
    private List<Json_OkCarAll.DataEntity> okCars;
    private List<Json_NotCarAll.DataEntity> notCars;
    private ItemMycarTableAdapter itemMycarTableAdapter;
    private Gson gson;
    private ItemMynotcarTableAdapter itemMynotcarTableAdapter;
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private TextView mMyworkAll;
    private TextView mMyworkJc;
    private TextView mMyworkMpv;
    private TextView mMyworkSuv;
    private LinearLayout mItemCarView;
    private GridView mItemCarGv;
    private ItemMycarTableviewAdapter itemMycarTableviewAdapter;
    private LinearLayout mItemCarTable;
    private boolean isViewTable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car_table);
        initView();
        setView();
        click();
    }

    private void setView() {
        updateMainView();
    }

    /**
     * 刷新所有数据并显示界面
     */
    private void updateMainView() {
        MyHttp.Call(this, "Interface/index/getUserNormalCarStoreAll", true, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_OkCarAll json_okCarAll1 = gson.fromJson(jsonObject.toString(), Json_OkCarAll.class);
                okCars = json_okCarAll1.getData();
                MyHttp.Call(MyCarTable.this, "Interface/index/getUserRepairCarStoreAll", false, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        gson = new Gson();
                        Json_OkCarAll json_okCarAll2 = gson.fromJson(jsonObject.toString(), Json_OkCarAll.class);
                        okCars.addAll(json_okCarAll2.getData());
                        itemMycarTableAdapter.notifyDataSetChanged();
                        //显示视图数据
                        int jc = 0;
                        int mpv = 0;
                        int suv = 0;
                        for (Json_OkCarAll.DataEntity entity : okCars) {
                            switch (entity.getCarTypeId()) {
                                case 1:
                                    jc++;
                                    break;
                                case 2:
                                    mpv++;
                                    break;
                                case 3:
                                    suv++;
                                    break;
                            }
                        }
                        mMyworkAll.setText((suv + jc + mpv) + "");
                        mMyworkJc.setText(jc + "");
                        mMyworkMpv.setText(mpv + "");
                        mMyworkSuv.setText(suv + "");
                        itemMycarTableviewAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
        MyHttp.Call(this, "Interface/index/getUserQualityAll", false, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_NotCarAll json_notCarAll = gson.fromJson(jsonObject.toString(), Json_NotCarAll.class);
                notCars = json_notCarAll.getData();
                itemMynotcarTableAdapter.notifyDataSetChanged();
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
        //显示问题车辆
        mCarNotCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View viewLog = LayoutInflater.from(getApplicationContext()).inflate(R.layout.log_car_notcar, null);
                final AlertDialog log = new AlertDialog.Builder(MyCarTable.this)
                        .setView(viewLog)
                        .show();
                //获取id
                ListView logMycarLv = (ListView) viewLog.findViewById(R.id.log_mycar_lv);
                TextView tv_cancel = viewLog.findViewById(R.id.log_mycar_cancel);
                logMycarLv.setAdapter(itemMynotcarTableAdapter);
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        log.cancel();
                    }
                });
            }
        });
        //点击动画显示界面
        mOrderSwitchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderSwitchView.setEnabled(false);
                final LinearLayout showLayout = isViewTable ? mItemCarTable : mItemCarView;
                final LinearLayout disLayout = !isViewTable ? mItemCarTable : mItemCarView;

                showLayout.animate().alpha(0).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        mOrderSwitchView.setEnabled(true);
                        showLayout.setVisibility(View.GONE);
                        isViewTable = !isViewTable;
                        mOrderSwitchView.setText(isViewTable?"切换视图":"切换表格");
                        disLayout.animate().alpha(1).setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                disLayout.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        }).start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }).start();


            }
        });
    }

    private void initView() {
        mMainReturn = findViewById(R.id.main_return);
        mCarNotCar = findViewById(R.id.car_notCar);
        mOrderSwitchView = findViewById(R.id.order_switchView);
        mMycarLv = findViewById(R.id.mycar_lv);
        okCars = new ArrayList<>();
        itemMycarTableAdapter = new ItemMycarTableAdapter();
        mMycarLv.setAdapter(itemMycarTableAdapter);
        notCars = new ArrayList<>();
        itemMynotcarTableAdapter = new ItemMynotcarTableAdapter();
        mMyworkAll = findViewById(R.id.mywork_all);
        mMyworkJc = findViewById(R.id.mywork_jc);
        mMyworkMpv = findViewById(R.id.mywork_mpv);
        mMyworkSuv = findViewById(R.id.mywork_suv);
        mItemCarView = findViewById(R.id.item_car_view);
        itemMycarTableviewAdapter = new ItemMycarTableviewAdapter();
        mItemCarView = findViewById(R.id.item_car_view);
        mItemCarGv = findViewById(R.id.item_car_Gv);
        mItemCarGv.setAdapter(itemMycarTableviewAdapter);
        mItemCarTable = findViewById(R.id.item_car_table);
    }

    public class ItemMycarTableAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return okCars.size();
        }

        @Override
        public Json_OkCarAll.DataEntity getItem(int position) {
            return okCars.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_mycar_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_OkCarAll.DataEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(final Json_OkCarAll.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemCarId.setText(object.getId() + "");
                holder.itemCarType.setText(object.getCarType().getCarTypeName() + "");
                holder.itemCarNum.setText(object.getNum() + "");
                holder.itemCarSize.setText(object.getCarType().getSize() + "");
                holder.itemCarcolor.setText(object.getCarTypeId()==0?"红色":object.getCarTypeId()==1?"白色":"蓝色");
                holder.itemCarGold.setText(decimalFormat.format(object.getCarType().getPrice()) + "");
                holder.itemCarSet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //卖出
                        MyHttp.Call(MyCarTable.this, "Interface/index/sellUserCar?userCarStoreId=" + object.getId(), true, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getInt("status") == 200) {
                                        Toast.makeText(MyCarTable.this, "卖出成功", Toast.LENGTH_SHORT).show();
                                        updateMainView();
                                    } else {
                                        Toast.makeText(MyCarTable.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
            private TextView itemCarId;
            private TextView itemCarType;
            private TextView itemCarNum;
            private TextView itemCarSize;
            private TextView itemCarcolor;
            private TextView itemCarGold;
            private Button itemCarSet;

            public ViewHolder(View view) {
                itemCarId = (TextView) view.findViewById(R.id.item_car_id);
                itemCarType = (TextView) view.findViewById(R.id.item_car_type);
                itemCarNum = (TextView) view.findViewById(R.id.item_car_num);
                itemCarSize = (TextView) view.findViewById(R.id.item_car_size);
                itemCarcolor = (TextView) view.findViewById(R.id.item_Car_color);
                itemCarGold = (TextView) view.findViewById(R.id.item_car_gold);
                itemCarSet = (Button) view.findViewById(R.id.item_car_set);
            }
        }
    }

    public class ItemMynotcarTableAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return notCars.size();
        }

        @Override
        public Json_NotCarAll.DataEntity getItem(int position) {
            return notCars.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_mynotcar_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_NotCarAll.DataEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(final Json_NotCarAll.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemMynotcarId.setText(object.getId() + "");
                holder.itemMynotcarColor.setText(object.getCarTypeId()==0?"红色":object.getCarTypeId()==1?"白色":"蓝色");
                holder.itemMynotcarNotPrice.setText(decimalFormat.format(object.getCarType().getRepairPrice()) + "");
                holder.itemMynotcarType.setText(object.getCarType().getCarTypeName() + "");
                holder.itemMynotcarSet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //维修车辆

                        //维修
                        MyHttp.Call(MyCarTable.this, "Interface/index/repairCar?userQualityId=" + object.getId(), true, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getInt("status") == 200) {
                                        Toast.makeText(MyCarTable.this, "维修成功", Toast.LENGTH_SHORT).show();
                                        updateMainView();
                                    } else {
                                        Toast.makeText(MyCarTable.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
            private TextView itemMynotcarId;
            private TextView itemMynotcarType;
            private TextView itemMynotcarColor;
            private TextView itemMynotcarNotPrice;
            private Button itemMynotcarSet;

            public ViewHolder(View view) {
                itemMynotcarId = (TextView) view.findViewById(R.id.item_mynotcar_id);
                itemMynotcarType = (TextView) view.findViewById(R.id.item_mynotcar_type);
                itemMynotcarColor = (TextView) view.findViewById(R.id.item_mynotcar_color);
                itemMynotcarNotPrice = (TextView) view.findViewById(R.id.item_mynotcar_notPrice);
                itemMynotcarSet = (Button) view.findViewById(R.id.item_mynotcar_set);
            }
        }
    }

    public class ItemMycarTableviewAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return okCars.size();
        }

        @Override
        public Json_OkCarAll.DataEntity getItem(int position) {
            return okCars.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_mycar_tableview, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_OkCarAll.DataEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(Json_OkCarAll.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemMycarviewIv.setImageResource(object.getCarTypeId() == 1 ?
                        R.drawable.car_red_plan : object.getCarTypeId() == 2 ? R.drawable.car_white_plan :
                        R.drawable.car_blue_plan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private ImageView itemMycarviewIv;

            public ViewHolder(View view) {
                itemMycarviewIv = (ImageView) view.findViewById(R.id.item_mycarview_iv);
            }
        }
    }

}