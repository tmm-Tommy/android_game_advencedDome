package com.example.advanceddome.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.example.advanceddome.R;
import com.example.advanceddome.entity.Json_OrderAll;
import com.example.advanceddome.utils.MyHttp;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyOrderTable extends AppCompatActivity {

    private ImageView mMainReturn;
    private TextView mOrderAddOrder;
    private ListView mOrderLv;
    private List<Json_OrderAll.DataEntity> orders;
    private List<String> engines;
    private List<String> hangs;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    ItemOrderTableAdapter itemOrderTableAdapter;
    Gson gson;
    private RadioGroup logOrderCarid;
    private RadioButton logOrderCarid1;
    private RadioButton logOrderCarid2;
    private RadioButton logOrderCarid3;
    private TextView logOrderTime;
    private RadioButton logOrderSpeed1;
    private EditText logOrderNum;
    private Spinner logOrderEngine;
    private RadioGroup logOrderSpeed;
    private RadioButton logOrderSpeed2;
    private RadioGroup logOrderWheel;
    private RadioButton logOrderWheel1;
    private RadioButton logOrderWheel2;
    private RadioGroup logOrderControl;
    private RadioButton logOrderControl1;
    private RadioButton logOrderControl2;
    private RadioGroup logOrderBrake;
    private RadioButton logOrderBrake1;
    private RadioButton logOrderBrake2;
    private Spinner logOrderHang;
    private TextView logOrderCancel;
    private TextView logOrderSubmit;
    private Json_OrderAll.DataEntity submitObj;
    private AlertDialog addLog;
    private TextView logSelectTitle;
    private RadioGroup logSelectLayout;
    private RadioButton logSelectRb1;
    private RadioButton logSelectRb2;
    private RadioButton logSelectRb3;
    private TextView logSelectCancel;
    private TextView logSelectSubmit;
    private int selectState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_table);
        initView();
        setView();
        click();
    }

    private void setView() {
        updateMainView();
        //点击新增
        mOrderAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //先选择时间
                new TimePickerBuilder(MyOrderTable.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        submitObj = new Json_OrderAll.DataEntity();
                        submitObj.setTime((int) (date.getTime() / 1000L));
                        //如果确定显示其他选项
                        View viewLog = LayoutInflater.from(getApplicationContext()).inflate(R.layout.log_order_add, null);
                        addLog = new AlertDialog.Builder(MyOrderTable.this)
                                .setView(viewLog)
                                .setCancelable(false)
                                .show();
                        //对话框操作
                        setLogData(submitObj, viewLog, addLog, date);
                    }
                })
                        .setCancelText("取消")
                        .setSubmitText("其他参数")
                        .setType(new boolean[]{true, true, true, false, false, false}).build().show();


            }
        });
    }

    private void setLogData(final Json_OrderAll.DataEntity submitObj, View viewLog, final AlertDialog addLog, Date date) {
        //初始化
        submitObj.setUserWorkId(1);
        submitObj.setUserAppointmentName("工厂1");
        submitObj.setContent("工厂1");
        submitObj.setType(0);
        submitObj.setGold(2000);
        //获取id
        logOrderCarid = (RadioGroup) viewLog.findViewById(R.id.log_order_carid);
        logOrderCarid1 = (RadioButton) viewLog.findViewById(R.id.log_order_carid1);
        logOrderCarid2 = (RadioButton) viewLog.findViewById(R.id.log_order_carid2);
        logOrderCarid3 = (RadioButton) viewLog.findViewById(R.id.log_order_carid3);
        logOrderTime = (TextView) viewLog.findViewById(R.id.log_order_time);
        logOrderNum = (EditText) viewLog.findViewById(R.id.log_order_num);
        logOrderEngine = (Spinner) viewLog.findViewById(R.id.log_order_engine);
        logOrderSpeed = (RadioGroup) viewLog.findViewById(R.id.log_order_speed);
        logOrderSpeed1 = (RadioButton) viewLog.findViewById(R.id.log_order_speed1);
        logOrderSpeed2 = (RadioButton) viewLog.findViewById(R.id.log_order_speed2);
        logOrderWheel = (RadioGroup) viewLog.findViewById(R.id.log_order_wheel);
        logOrderWheel1 = (RadioButton) viewLog.findViewById(R.id.log_order_wheel1);
        logOrderWheel2 = (RadioButton) viewLog.findViewById(R.id.log_order_wheel2);
        logOrderControl = (RadioGroup) viewLog.findViewById(R.id.log_order_control);
        logOrderControl1 = (RadioButton) viewLog.findViewById(R.id.log_order_control1);
        logOrderControl2 = (RadioButton) viewLog.findViewById(R.id.log_order_control2);
        logOrderBrake = (RadioGroup) viewLog.findViewById(R.id.log_order_brake);
        logOrderBrake1 = (RadioButton) viewLog.findViewById(R.id.log_order_brake1);
        logOrderBrake2 = (RadioButton) viewLog.findViewById(R.id.log_order_brake2);
        logOrderHang = (Spinner) viewLog.findViewById(R.id.log_order_hang);
        logOrderCancel = (TextView) viewLog.findViewById(R.id.log_order_cancel);
        logOrderSubmit = (TextView) viewLog.findViewById(R.id.log_order_submit);
        //设置时间
        logOrderTime.setText(simpleDateFormat.format(date));
        //设置适配器
        logOrderEngine.setAdapter(new ArrayAdapter(MyOrderTable.this, android.R.layout.simple_list_item_1, engines));
        logOrderHang.setAdapter(new ArrayAdapter(MyOrderTable.this, android.R.layout.simple_list_item_1, hangs));
        //点击事件
        logOrderCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (addLog != null)
                    addLog.cancel();
            }
        });
        //设置数据
        logOrderCarid.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int tem = 0;
                switch (i) {
                    case R.id.log_order_carid1:
                        tem = 0;
                        break;
                    case R.id.log_order_carid2:
                        tem = 1;
                        break;
                    case R.id.log_order_carid3:
                        tem = 2;
                        break;
                }
                submitObj.setCarId(tem);
                submitObj.setColor(tem);
            }
        });
        logOrderTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        logOrderEngine.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                submitObj.setEngine(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        logOrderSpeed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int tem = 0;
                switch (i) {
                    case R.id.log_order_speed1:
                        tem = 0;
                        break;
                    case R.id.log_order_speed2:
                        tem = 1;
                        break;
                }
                submitObj.setSpeed(tem);
            }
        });
        logOrderWheel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int tem = 0;
                switch (i) {
                    case R.id.log_order_wheel1:
                        tem = 0;
                        break;
                    case R.id.log_order_wheel2:
                        tem = 1;
                        break;
                }
                submitObj.setWheel(tem);
            }
        });
        logOrderControl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int tem = 0;
                switch (i) {
                    case R.id.log_order_control1:
                        tem = 0;
                        break;
                    case R.id.log_order_control2:
                        tem = 1;
                        break;
                }
                submitObj.setControl(tem);
            }
        });
        logOrderBrake.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int tem = 0;
                switch (i) {
                    case R.id.log_order_brake1:
                        tem = 0;
                        break;
                    case R.id.log_order_brake2:
                        tem = 1;
                        break;
                }
                submitObj.setBrake(tem);
            }
        });
        logOrderHang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                submitObj.setHang(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //点击下订单
        logOrderSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //验证
                String num_s = logOrderNum.getText().toString();
                if ("".equals(num_s) || submitObj.getTime() == 0) {
                    Toast.makeText(MyOrderTable.this, "请填充完整!", Toast.LENGTH_SHORT).show();
                    return;
                }
                submitObj.setNum(Integer.parseInt(num_s));
                if (submitObj.getNum() <= 0) {
                    Toast.makeText(MyOrderTable.this, "数值错误!", Toast.LENGTH_SHORT).show();
                    return;
                }
                //提交
                MyHttp.Call(MyOrderTable.this, "dataInterface/UserAppointment/create?userWorkId=" + submitObj.getUserWorkId() + "&userAppointmentName=" + submitObj.getUserAppointmentName() +
                        "&content=" + submitObj.getContent() + "&type=" + submitObj.getType() + "&carId=" + submitObj.getCarId() + "&time=" + submitObj.getTime()
                        + "&num=" + submitObj.getNum() + "&gold=" + submitObj.getGold() + "&engine=" + submitObj.getEngine() + "&speed=" + submitObj.getSpeed()
                        + "&wheel=" + submitObj.getWheel() + "&control=" + submitObj.getControl() + "&brake=" + submitObj.getBrake() + "&hang=" + submitObj.getHang()
                        + "&color=" + submitObj.getColor(), true, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            if (jsonObject.getInt("status") == 200) {
                                Toast.makeText(MyOrderTable.this, "下单成功!", Toast.LENGTH_SHORT).show();
                                updateMainView();
                                if (addLog != null)
                                    addLog.cancel();
                            } else {
                                Toast.makeText(MyOrderTable.this, "下单失败!", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    /**
     * 获取所有数据并刷新页面
     */
    private void updateMainView() {
        MyHttp.Call(MyOrderTable.this, "dataInterface/UserAppointment/getAll", true, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_OrderAll json_orderAll = gson.fromJson(jsonObject.toString(), Json_OrderAll.class);
                orders = json_orderAll.getData();
                itemOrderTableAdapter.notifyDataSetChanged();
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
        //点击设置订单状态
        mOrderLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                View viewLog = LayoutInflater.from(getApplicationContext()).inflate(R.layout.log_select3_rb, null);
                final AlertDialog log = new AlertDialog.Builder(MyOrderTable.this)
                        .setCancelable(false)
                        .setView(viewLog)
                        .show();
                //获取id
                logSelectTitle = (TextView) viewLog.findViewById(R.id.log_select_title);
                logSelectLayout = (RadioGroup) viewLog.findViewById(R.id.log_select_layout);
                logSelectRb1 = (RadioButton) viewLog.findViewById(R.id.log_select_rb1);
                logSelectRb2 = (RadioButton) viewLog.findViewById(R.id.log_select_rb2);
                logSelectRb3 = (RadioButton) viewLog.findViewById(R.id.log_select_rb3);
                logSelectCancel = (TextView) viewLog.findViewById(R.id.log_select_cancel);
                logSelectSubmit = (TextView) viewLog.findViewById(R.id.log_select_submit);
                //操作
                logSelectTitle.setText("修改订单状态");
                logSelectRb1.setText("已下单");
                logSelectRb2.setText("生产中");
                logSelectRb3.setText("已完成");
                selectState = 0;
                logSelectLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.log_select_rb1:
                                selectState = 0;
                                break;
                            case R.id.log_select_rb2:
                                selectState = 1;
                                break;
                            case R.id.log_select_rb3:
                                selectState = 2;
                                break;
                        }
                    }
                });
                logSelectCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        log.cancel();
                    }
                });
                logSelectSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //提交修改
                        MyHttp.Call(MyOrderTable.this, "dataInterface/UserAppointment/updateType?id="+orders.get(i).getId()+"&type="+selectState, false, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getInt("status") == 200){
                                        Toast.makeText(MyOrderTable.this, "操作成功", Toast.LENGTH_SHORT).show();
                                        updateMainView();
                                        log.cancel();
                                    }else {
                                        Toast.makeText(MyOrderTable.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    private void initView() {
        mMainReturn = findViewById(R.id.main_return);
        mOrderAddOrder = findViewById(R.id.order_addOrder);
        mOrderLv = findViewById(R.id.order_lv);
        engines = new ArrayList<>();
        engines.add("1.0");
        engines.add("1.5");
        engines.add("2.0");
        engines.add("2.5");
        engines.add("3.0");
        engines.add("4.0");
        hangs = new ArrayList<>();
        hangs.add("独立悬挂");
        hangs.add("主动悬挂");
        hangs.add("横臂式悬挂");
        hangs.add("纵臂式悬挂");
        hangs.add("烛式悬挂");
        hangs.add("多连杆式悬挂");
        hangs.add("麦弗逊式悬挂");
        orders = new ArrayList<>();
        itemOrderTableAdapter = new ItemOrderTableAdapter();
        mOrderLv.setAdapter(itemOrderTableAdapter);
    }

    public class ItemOrderTableAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return orders.size();
        }

        @Override
        public Json_OrderAll.DataEntity getItem(int position) {
            return orders.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_order_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_OrderAll.DataEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(Json_OrderAll.DataEntity object, ViewHolder holder) {
            //TODO implement
            try {
                holder.itemOrderCarId.setText(object.getCarId() == 0 ? "红色" : object.getCarId() == 1 ? "白色" : "蓝色");
                holder.itemOrderTime.setText(simpleDateFormat.format(object.getTime() * 1000L));
                holder.itemOrderNum.setText(object.getNum() + "");
                holder.itemOrderEngine.setText(engines.get(object.getEngine()) + "");
                holder.itemOrderSpeed.setText(object.getSpeed() == 0 ? "自动" : "手动");
                holder.itemOrderWheel.setText(object.getWheel() == 0 ? "烤漆" : "电漆");
                holder.itemOrderControl.setText(object.getControl() == 0 ? "低配" : "高配");
                holder.itemOrderBrake.setText(object.getBrake() == 0 ? "鼓式制动器" : "盘式制动器");
                holder.itemOrderHang.setText(hangs.get(object.getHang()));
                holder.itemOrderType.setText(object.getType() == 0 ? "已下单" : object.getType() == 1 ? "生产中" : "完成");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView itemOrderCarId;
            private TextView itemOrderTime;
            private TextView itemOrderNum;
            private TextView itemOrderEngine;
            private TextView itemOrderSpeed;
            private TextView itemOrderWheel;
            private TextView itemOrderControl;
            private TextView itemOrderBrake;
            private TextView itemOrderHang;
            private TextView itemOrderType;

            public ViewHolder(View view) {
                itemOrderCarId = (TextView) view.findViewById(R.id.item_order_carId);
                itemOrderTime = (TextView) view.findViewById(R.id.item_order_time);
                itemOrderNum = (TextView) view.findViewById(R.id.item_order_num);
                itemOrderEngine = (TextView) view.findViewById(R.id.item_order_engine);
                itemOrderSpeed = (TextView) view.findViewById(R.id.item_order_speed);
                itemOrderWheel = (TextView) view.findViewById(R.id.item_order_wheel);
                itemOrderControl = (TextView) view.findViewById(R.id.item_order_control);
                itemOrderBrake = (TextView) view.findViewById(R.id.item_order_brake);
                itemOrderHang = (TextView) view.findViewById(R.id.item_order_hang);
                itemOrderType = (TextView) view.findViewById(R.id.item_order_type);
            }
        }
    }

}