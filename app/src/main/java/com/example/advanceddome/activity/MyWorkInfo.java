package com.example.advanceddome.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.example.advanceddome.R;
import com.example.advanceddome.entity.Json_WorkInfo;
import com.example.advanceddome.entity.Json_WorkInfoEnvi;
import com.example.advanceddome.utils.DataBase;
import com.example.advanceddome.utils.MyHttp;
import com.google.gson.Gson;
import com.zjun.widget.RuleView;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MyWorkInfo extends AppCompatActivity {

    private ImageView mMainReturn;
    private TextView mMainReset;
    private TextView mMyworkMoney;
    private TextView mMyworkUpdateMoney;
    private TextView mMyworkMeg;
    private TextView mMyworkUpdateMeg;
    private TextView mMyworkCar;
    private TextView mMyworkUpdateCar;
    private TextView mMyworkNowElect;
    private RuleView mMyworkElect;
    private RelativeLayout mMyworkSwitchLayout;
    private Switch mMyworkSwitch;
    private RuleView mMyworkDu;
    private ImageView mMyworkSnow;
    private ImageView mMyworkSum;
    private ImageView mMyworkClose;
    private TextView mMainUpdateIP;
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    Gson gson;
    private TextView mMyworkTvDu;
    private TextView mMyworkSetEletr;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_work_info);
        initView();
        setView();
        click();
    }

    private void setView() {
        updaetMainView(true);
    }

    /**
     * 刷新全界面数据
     */
    private void updaetMainView(boolean isLog) {
        //获取工厂数据
        MyHttp.Call(this, "dataInterface/UserWorkInfo/getInfo?id=1", isLog, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                final Json_WorkInfo json_workInfo = gson.fromJson(jsonObject.toString(), Json_WorkInfo.class);
                MyHttp.Call(MyWorkInfo.this, "dataInterface/UserWorkEnvironmental/getInfo?id=1", false, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        gson = new Gson();
                        Json_WorkInfoEnvi json_workInfoEnvi = gson.fromJson(jsonObject.toString(), Json_WorkInfoEnvi.class);
                        //获取数据后,进行显示
                        Json_WorkInfo.DataEntity dataWork = json_workInfo.getData().get(0);
                        Json_WorkInfoEnvi.DataEntity dataEnvi = json_workInfoEnvi.getData().get(0);
                        //工厂资金
                        mMyworkMoney.setText(decimalFormat.format(dataWork.getPrice()) + "￥");
                        //工厂仓库容量
                        mMyworkMeg.setText(dataWork.getPartCapacity() + "m²");
                        //工厂车库容量
                        mMyworkCar.setText(dataWork.getCarCapacity() + "m²");
                        //用电
                        mMyworkNowElect.setText("当前电力消耗：" + dataEnvi.getPowerConsume() + "w");
                        mMyworkElect.setValue(0, 100, Integer.valueOf(dataEnvi.getPower()), 1, 10);
                        //灯光
                        mMyworkSwitchLayout.setBackgroundResource(dataEnvi.getLightSwitch() == 0 ? R.drawable.factory_off : R.drawable.factory_on);
                        mMyworkSwitch.setChecked(dataEnvi.getLightSwitch() == 0 ?false:true);
                        //空调
                        mMyworkTvDu.setText("工厂温度:" + dataEnvi.getWorkshopTemp());
                        mMyworkDu.setValue(0, 100, Integer.valueOf(dataEnvi.getWorkshopTemp().split("℃")[0]), 1, 10);
                        setAoo(dataEnvi.getAcOnOff(), false);
                    }
                });
            }
        });
    }

    /**
     * 设置空调图标
     */
    private void setAoo(int state, boolean isToast) {
        mMyworkSnow.setImageResource(R.drawable.snow_off);
        mMyworkSum.setImageResource(R.drawable.sun_off);
        switch (state) {
            case 1:
                mMyworkSnow.setImageResource(R.drawable.snow_on);
                break;
            case 2:
                mMyworkSum.setImageResource(R.drawable.sum_on);
                break;
        }
        updateWorkData("dataInterface/UserWorkEnvironmental/updateAcOnOff?id=1&acOnOff=" + state, isToast);
    }

    private void click() {
        //退出
        mMainReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //重置数据
        mMainReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateWorkData("Interface/index/resetGame", true);
            }
        });
        //点击关闭空调
        mMyworkClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //设置空调状态：状态：0关闭，1冷风，2暖风
                setAoo(0, true);
            }
        });
        //点击空调-冷风
        mMyworkSnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAoo(1, true);
            }
        });
        //点击空调-暖风
        mMyworkSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAoo(2, true);
            }
        });
        //点击控制灯光
        mMyworkSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyworkSwitchLayout.setBackgroundResource(mMyworkSwitch.isChecked() ? R.drawable.factory_on : R.drawable.factory_off);
                /**
                 * 设置灯光
                 *
                 * @param state
                 */
                updateWorkData("dataInterface/UserWorkEnvironmental/updateLightSwitch?id=1&lightSwitch="+(mMyworkSwitch.isChecked() ? 1 : 0),true);
            }
        });
        //点击修改能耗供应
        mMyworkSetEletr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateWorkData("dataInterface/UserWorkEnvironmental/updatePower?id=1&power=" + ((int) mMyworkElect.getCurrentValue()),true);
            }
        });
        //修改工厂资金
        mMyworkUpdateMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUpdaetLog("dataInterface/UserWorkInfo/updatePrice?id=1&price=","资金");
            }
        });
        //修改仓库容量
        mMyworkUpdateMeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUpdaetLog("dataInterface/UserWorkInfo/updatePartCapacity?id=1&partCapacity=","仓库容量");
            }
        });
        //修改车库容量
        mMyworkUpdateCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUpdaetLog("dataInterface/UserWorkInfo/updateCarCapacity?id=1&carCapacity=","车库容量");
            }
        });
        //设置ip
        mMainUpdateIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editText = new EditText(MyWorkInfo.this);
                editText.setHint("规范输入:172.168.10.100:8085");
                new AlertDialog.Builder(MyWorkInfo.this)
                        .setTitle("修改工厂使用IP+端口:")
                        .setView(editText)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String e_tv = editText.getText().toString();
                                if (!"".equals(e_tv)){
                                    sharedPreferences = getSharedPreferences(DataBase.SP_TABLE,MODE_PRIVATE);
                                    editor = sharedPreferences.edit();
                                    editor.putString(DataBase.SP_IP,e_tv).apply();
                                    Toast.makeText(MyWorkInfo.this, "操作成功!", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(MyWorkInfo.this, "未改变", Toast.LENGTH_SHORT).show();
                                }

                            }
                        })
                        .setNeutralButton("取消", null)
                        .show();
            }
        });
    }

    private void showUpdaetLog(final String urlHead,String title) {
        final EditText editText = new EditText(MyWorkInfo.this);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        new AlertDialog.Builder(MyWorkInfo.this)
                .setTitle("修改工厂:"+title)
                .setView(editText)
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String e_tv = editText.getText().toString();
                        if (!"".equals(e_tv)&&e_tv.length()<=8){
                            Long value_tv = Long.valueOf(e_tv);
                            updateWorkData(urlHead+value_tv,true);
                        }else {
                            Toast.makeText(MyWorkInfo.this, "未改变", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNeutralButton("取消", null)
                .show();
    }

    /**
     * 修改数据总方法
     */
    private void updateWorkData(String url, final boolean isLog) {
        MyHttp.Call(this, url, false, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    if (jsonObject.getInt("status") == 200 && isLog) {
                        Toast.makeText(MyWorkInfo.this, "操作成功", Toast.LENGTH_SHORT).show();
                        updaetMainView(true);
                    }else {
                        if (isLog)
                        Toast.makeText(MyWorkInfo.this, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        mMainReturn = findViewById(R.id.main_return);
        mMainReset = findViewById(R.id.main_reset);
        mMyworkMoney = findViewById(R.id.mywork_money);
        mMyworkUpdateMoney = findViewById(R.id.mywork_updateMoney);
        mMyworkMeg = findViewById(R.id.mywork_Meg);
        mMyworkUpdateMeg = findViewById(R.id.mywork_updateMeg);
        mMyworkCar = findViewById(R.id.mywork_car);
        mMyworkUpdateCar = findViewById(R.id.mywork_updateCar);
        mMyworkNowElect = findViewById(R.id.mywork_nowElect);
        mMyworkElect = findViewById(R.id.mywork_elect);
        mMyworkSwitchLayout = findViewById(R.id.mywork_switch_layout);
        mMyworkSwitch = findViewById(R.id.mywork_switch);
        mMyworkDu = findViewById(R.id.mywork_du);
        mMyworkSnow = findViewById(R.id.mywork_snow);
        mMyworkSum = findViewById(R.id.mywork_sum);
        mMyworkClose = findViewById(R.id.mywork_close);
        mMainUpdateIP = findViewById(R.id.main_updateIP);
        mMyworkTvDu = findViewById(R.id.mywork_tvDu);
        //设置默认状态
        mMyworkDu.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        mMyworkSetEletr = findViewById(R.id.mywork_setEletr);
    }
}