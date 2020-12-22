package com.example.advanceddome;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.advanceddome.activity.AllPeopleTable;
import com.example.advanceddome.activity.MyCarTable;
import com.example.advanceddome.activity.MyMaterialAll;
import com.example.advanceddome.activity.MyNotice;
import com.example.advanceddome.activity.MyOrderTable;
import com.example.advanceddome.activity.MyWorkInfo;
import com.example.advanceddome.entity.Json_NotCarAll;
import com.example.advanceddome.entity.Json_NoticeAll;
import com.example.advanceddome.entity.Json_PeopleAll;
import com.example.advanceddome.entity.Json_StageAll;
import com.example.advanceddome.entity.Json_StepCostAll;
import com.example.advanceddome.entity.Json_SupplyAll;
import com.example.advanceddome.entity.Json_UserLineAll;
import com.example.advanceddome.entity.WorkTableEntity;
import com.example.advanceddome.utils.DataBase;
import com.example.advanceddome.utils.MyHttp;
import com.example.advanceddome.utils.StringUtils;
import com.google.gson.Gson;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mMainSwitchLine;
    private DrawerLayout mMainLayoutMenu;
    private ListView mMainLvMenu;
    private List<Json_UserLineAll> userLines;//每条线的所有数据
    private List<Json_PeopleAll.DataEntity> userPersonEntities;//    所有已经删选好的人才市场数据
    private List<Json_UserLineAll.DataEntity.UserLineStepEntity> userLineStepEntities;//一条所有环节数据
    private List<Json_SupplyAll.DataEntity> supplyList;
    OkHttpClient client;
    Gson gson;
    MainMenuLvAdapter mainMenuLvAdapter;
    private LinearLayout mMainPeople1Layout;
    private TextView mMainPeople1Name;
    private ProgressBar mMainPeople1HqV;
    private TextView mMainPeople1Hq;
    private LinearLayout mMainPeople2Layout;
    private TextView mMainPeople2Name;
    private ProgressBar mMainPeople2HpV;
    private TextView mMainPeople2Hp;
    private LinearLayout mMainPeople3Layout;
    private TextView mMainPeople3Name;
    private ProgressBar mMainPeople3HpV;
    private TextView mMainPeople3Hp;
    private LinearLayout mMainPeople4Layout;
    private TextView mMainPeople4Name;
    private ProgressBar mMainPeople4HpV;
    private TextView mMainPeople4Hp;
    List<LinearLayout> peopleLayouts;
    private Json_UserLineAll.DataEntity nowLineEntity;
    private TextView mMainAllPeople;
    Intent intent;
    private TextView mMainNextStep;
    private GridView mMainGv;
    ItemStepTableAdapter itemStepTableAdapter;
    private TextView mMainMyWorkInfo;
    SharedPreferences sharedPreferences;
    private Request request;
    private SmartRefreshLayout mMainRefresh;
    private boolean isAutoRefresh = false;  //是否为为自动刷新
    private TextView mMainMyTable;
    private ListView mMainLvTable;
    private List<WorkTableEntity> tableEntities;
    MainTableLvAdapter mainTableLvAdapter;
    private TextView logSelectTitle;
    private RadioGroup logSelectLayout;
    private RadioButton logSelectRb1;
    private RadioButton logSelectRb2;
    private RadioButton logSelectRb3;
    private TextView logSelectCancel;
    private TextView logSelectSubmit;
    private int selectState;
    private TextView mMainNotice;
    private Json_NoticeAll.DataEntity noticeEntity;
    private Bundle bundle;
    private Response execute;

    @Override
    protected void onResume() {
        super.onResume();
        try {
            //获取IP
            sharedPreferences = getSharedPreferences(DataBase.SP_TABLE, MODE_PRIVATE);
            String ip = sharedPreferences.getString(DataBase.SP_IP, "");
            if (!"".equals(ip)) {
                //设置ip
                MyHttp.HEAD_URL = "http://" + ip + "/";//设置ip
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setView();
        click();
    }

    private void click() {
        //点击切换
        mMainSwitchLine.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                mMainLayoutMenu.openDrawer(Gravity.START);
            }
        });
        //点击切换生产线数据
        mMainLvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                updateUserLineView(i);
                mMainLayoutMenu.closeDrawers();
            }
        });
        //点击状态报表
        mMainMyTable.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                mMainLayoutMenu.openDrawer(Gravity.END);
            }
        });
        //点击分配员工
        for (int i = 0; i < peopleLayouts.size(); i++) {
            final int finalI = i;
            peopleLayouts.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (userLines.get(nowLineEntity.getPos()).getData() != null)
                            addUserLinePeople(userLines.get(nowLineEntity.getPos()).getData().getId(), finalI, true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //点击跳转-查看全部人员
        mMainAllPeople.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("userLineSize", userPersonEntities.size());
                    for (int i = 0; i < userPersonEntities.size(); i++) {
                        bundle.putSerializable("userLine" + i, userPersonEntities.get(i));
                    }
                    intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(MainActivity.this, AllPeopleTable.class);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this, Pair.<View, String>create(mMainAllPeople, "allPeopleTitle")).toBundle()
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //点击进入下一个环节
        mMainNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextStep();
            }
        });
        //点击进入我的工厂
        mMainMyWorkInfo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                intent = new Intent();
                intent.setClass(MainActivity.this, MyWorkInfo.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        MainActivity.this, Pair.<View, String>create(mMainMyWorkInfo, "myWorkInfo")).toBundle()
                );
            }
        });
        //下拉刷新
        mMainRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                try {
                    if (!isAutoRefresh) {
                        updateUserLineView(nowLineEntity.getPos());
                        updateRight(nowLineEntity.getPos());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //点击进入资讯
        mMainNotice.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                try {
                    intent = new Intent();
                    intent.setClass(MainActivity.this, MyNotice.class);
                    bundle = new Bundle();
                    bundle.putSerializable("noticeEntity",noticeEntity);
                    intent.putExtras(bundle);
                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this, Pair.<View, String>create(mMainNotice, "myNotice")).toBundle()
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setView() {
        //同步获取4条线数据
        updateUserLineView(-1);
    }

    /**
     * /同步获取4条线数据
     *
     * @param pos 刷新哪条数据,-1为默认第1条
     */
    private void updateUserLineView(final int pos) {
        //获取资讯
        MyHttp.Call(this, "dataInterface/Information/getAll", false, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_NoticeAll json_noticeAll = gson.fromJson(jsonObject.toString(), Json_NoticeAll.class);
                int index = new Random().nextInt(json_noticeAll.getData().size());
                noticeEntity = json_noticeAll.getData().get(index);
                mMainNotice.setText(noticeEntity.getInformationName());
            }
        });
        //获取生产线
        new Thread() {
            @Override
            public void run() {
                userLines.clear();
                userPersonEntities.clear();
                //获取动画
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mMainRefresh.autoRefresh();
                        isAutoRefresh = true;
                    }
                });
                for (int i = 0; i < 4; i++) {
                    try {
                        client = new OkHttpClient();
                        request = new Request.Builder().url(MyHttp.HEAD_URL + "Interface/index/getUserlineContent?pos=" + i).build();
                        Call call = client.newCall(request);
                        execute = call.execute();
                        String resData = execute.body().string();
                        if (resData.contains("\"status\":400")) {
                            //不存在
                            Json_UserLineAll json_userLineAll = new Json_UserLineAll();
                            json_userLineAll.setPosition(i);
                            userLines.add(json_userLineAll);
                        } else {
                            //存在
                            gson = new Gson();
                            Json_UserLineAll json_userLineAll = gson.fromJson(resData, Json_UserLineAll.class);
                            json_userLineAll.setPosition(i);
                            //合并人员
                            for (Json_UserLineAll.DataEntity.UserPositionEntity entity1 : json_userLineAll.getData().getUserPosition()) {
                                for (Json_UserLineAll.DataEntity.UserPersonEntity entity2 : json_userLineAll.getData().getUserPerson()) {
                                    if (entity1.getUserPersonId() == entity2.getId()) {
                                        entity1.setPersonEntity(entity2);
                                        break;
                                    }
                                }
                            }
                            userLines.add(json_userLineAll);
                        }
                    } catch (IOException e) {
                        if(mMainRefresh!=null)
                        mMainRefresh.finishRefresh();   //结束下拉动画
                        e.printStackTrace();
                    }
                }
                //获取完成
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (pos == -1) {
                            //刚进入的:给如默认值
                            updateRight(2);
                        } else {
                            updateRight(pos);
                        }
                        mMainRefresh.finishRefresh();   //结束下拉动画
                        isAutoRefresh = false;
                        mainMenuLvAdapter.notifyDataSetChanged();   //刷新菜单适配器
                        //默认删选人才市场
                        addUserLinePeople(0, 0, false);
                    }
                });
            }
        }.start();
    }

    //刷新当前生产线数据
    private void updateRight(final int pos) {
        try {
            Json_UserLineAll.DataEntity entity = userLines.get(pos).getData();//获取当前生产线数据
            if (entity != null) {
                //获取当前环节
                nowLineEntity = entity; //获取当前生产线所有信息
                if (entity.getUserPosition() != null) {
                    //有生产线并有人工作
                    mMainSwitchLine.setText("切换生产线-当前" + (pos + 1) + "生产线");
                    formPeopleView(entity);
                    formStepView(entity);
                } else {
                    //有生产线但没有人工作
                    formPeopleView(entity);
                }

            } else {
                //点击发现生产线没有创建
                View viewLog = LayoutInflater.from(getApplicationContext()).inflate(R.layout.log_select3_rb, null);
                final AlertDialog log = new AlertDialog.Builder(MainActivity.this)
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
                logSelectTitle.setText("请选择生产线的类型!");
                logSelectRb1.setText("轿车生产线");
                logSelectRb2.setText("MPV生产线");
                logSelectRb3.setText("SUV生产线");
                selectState = 0;
                logSelectLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i) {
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
                        createUserLine(selectState, pos, log);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * //获取每个环节的生成工序名和工序需要材料的数据,并合并
     *
     * @param entity
     */
    private void formStepStage(final Json_UserLineAll.DataEntity entity) {
        //获取每个环节的生成工序名和工序需要材料的数据,并合并
        MyHttp.Call(MainActivity.this, "dataInterface/Stage/getAll", false, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_StageAll json_stageAll = gson.fromJson(jsonObject.toString(), Json_StageAll.class);
                //合并工序
                for (Json_StageAll.DataEntity entity1 : json_stageAll.getData()) {
                    for (Json_UserLineAll.DataEntity.UserLineStepEntity entity2 : entity.getUserLineStep()) {
                        //找到对应的环节
                        if (entity1.getPlStepId() == entity2.getProcessId()) {
                            entity2.setStageEntity(entity1);
                            break;
                        }
                    }
                }
                MyHttp.Call(MainActivity.this, "dataInterface/plStepCost/getAll", false, new com.android.volley.Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        gson = new Gson();
                        Json_StepCostAll json_stepCostAll = gson.fromJson(jsonObject.toString(), Json_StepCostAll.class);
                        //合并环节需要的材料数据
                        for (Json_StepCostAll.DataEntity entity1 : json_stepCostAll.getData()) {
                            for (Json_UserLineAll.DataEntity.UserLineStepEntity entity2 : entity.getUserLineStep()) {
                                //找到对应的环节
                                if (entity1.getPlStepId() == entity2.getProcessId()) {
                                    entity2.setStepCostEntity(entity1);
                                    break;
                                }
                            }
                        }
                        itemStepTableAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    //获取环节数据,并刷新试图
    private void formStepView(Json_UserLineAll.DataEntity entity) {
        try {
            if (entity != null) {
                userLineStepEntities = entity.getUserLineStep();//获取当前生产线环节数据
                //环节排序
                Collections.sort(userLineStepEntities, new Comparator<Json_UserLineAll.DataEntity.UserLineStepEntity>() {
                    @Override
                    public int compare(Json_UserLineAll.DataEntity.UserLineStepEntity o1, Json_UserLineAll.DataEntity.UserLineStepEntity o2) {
                        return o1.getProcessId() - o2.getProcessId();
                    }
                });
                formStepStage(entity);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void formPeopleView(Json_UserLineAll.DataEntity entity) {
        try {
            TextView t_name = null;
            ProgressBar p_hq = null;
            TextView t_hq = null;
            LinearLayout l_layout = null;
            String type = "";
            //先初始化
            mMainPeople1Name.setText("工程师");
            mMainPeople2Name.setText("操作员");
            mMainPeople3Name.setText("技术员");
            mMainPeople4Name.setText("质检员");
            mMainPeople1HqV.setProgress(0);
            mMainPeople2HpV.setProgress(0);
            mMainPeople3HpV.setProgress(0);
            mMainPeople4HpV.setProgress(0);
            mMainPeople1Hq.setText("点击分配员工");
            mMainPeople2Hp.setText("点击分配员工");
            mMainPeople3Hp.setText("点击分配员工");
            mMainPeople4Hp.setText("点击分配员工");
            mMainPeople1Layout.setBackgroundResource(R.drawable.main_people_red);
            mMainPeople2Layout.setBackgroundResource(R.drawable.main_people_red);
            mMainPeople3Layout.setBackgroundResource(R.drawable.main_people_red);
            mMainPeople4Layout.setBackgroundResource(R.drawable.main_people_red);
            for (Json_UserLineAll.DataEntity.UserPositionEntity obj : entity.getUserPosition()) {
                switch (obj.getPersonEntity().getType()) {
                    case 0:
                        type = "工程师";
                        t_name = mMainPeople1Name;
                        t_hq = mMainPeople1Hq;
                        p_hq = mMainPeople1HqV;
                        l_layout = mMainPeople1Layout;
                        break;
                    case 1:
                        type = "操作员";
                        t_name = mMainPeople2Name;
                        t_hq = mMainPeople2Hp;
                        p_hq = mMainPeople2HpV;
                        l_layout = mMainPeople2Layout;
                        break;
                    case 2:
                        type = "技术员";
                        t_name = mMainPeople3Name;
                        t_hq = mMainPeople3Hp;
                        p_hq = mMainPeople3HpV;
                        l_layout = mMainPeople3Layout;
                        break;
                    case 3:
                        type = "质检员";
                        t_name = mMainPeople4Name;
                        t_hq = mMainPeople4Hp;
                        p_hq = mMainPeople4HpV;
                        l_layout = mMainPeople4Layout;
                        break;
                }
                t_name.setText(type + ":" + obj.getPersonEntity().getPersonName());
                t_hq.setText("体力:" + obj.getPersonEntity().getHp());
                p_hq.setProgress(obj.getPersonEntity().getHp());
                l_layout.setBackgroundResource(R.drawable.main_people_green);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建生产线
     *
     * @param line 生产线类型
     * @param pos  生产线位置
     */
    private void createUserLine(int line, int pos, final AlertDialog alertDialog) {
        MyHttp.Call(MainActivity.this, "Interface/index/createStudentLine?lineId=" + (line + 1) + "&pos=" + pos, false, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    if (jsonObject.getInt("status") == 200) {
                        updateUserLineView(nowLineEntity.getPos());
                        Toast.makeText(MainActivity.this, "创建成功!", Toast.LENGTH_SHORT).show();
                        if (alertDialog != null) alertDialog.cancel();
                    } else {
                        Toast.makeText(MainActivity.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 分配员工
     *
     * @param userLine 生产线id
     * @param workType 分配岗位type
     * @param isAdd    是:分配员工,否:只删选人才市场不奉陪
     */
    private void addUserLinePeople(final int userLine, final int workType, final boolean isAdd) {
        MyHttp.Call(this, "dataInterface/People/getAll", false, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_PeopleAll json_peopleAll = gson.fromJson(jsonObject.toString(), Json_PeopleAll.class);
                userPersonEntities = json_peopleAll.getData();
                //删选出未招聘的
                for (Json_PeopleAll.DataEntity entity : userPersonEntities) {
                    c:
                    for (int i = 0; i < userLines.size(); i++) {
                        if (userLines.get(i).getData() != null)
                            for (int j = 0; j < userLines.get(i).getData().getUserPerson().size(); j++) {
                                Json_UserLineAll.DataEntity.UserPersonEntity userPersonEntity = userLines.get(i).getData().getUserPerson().get(j);
                                if (entity.getPeopleName().equals(userPersonEntity.getPersonName())) {
                                    entity.setWork(true);
                                    break c;
                                }
                            }
                    }
                }
                if (isAdd) {
                    //找到一个该岗位的员工
                    for (Json_PeopleAll.DataEntity entity : userPersonEntities) {
                        if (!entity.isWork() && entity.getStatus() == workType) {
                            //先新增到宿舍
                            MyHttp.Call(MainActivity.this, "dataInterface/UserPeople/create?" +
                                    "userWorkId=1&power=100&peopleId=" + entity.getId() + "&userProductionLineId=" + userLine + "&workPostId=0", false, new com.android.volley.Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject jsonObject) {
                                    //分配员工
                                    MyHttp.Call(MainActivity.this, "Interface/index/addUserPosition?userLineId=" + userLine + "&type=" + workType, false, new com.android.volley.Response.Listener<JSONObject>() {
                                        @Override
                                        public void onResponse(JSONObject jsonObject) {
                                            try {
                                                if (jsonObject.getInt("status") == 200) {
                                                    Toast.makeText(MainActivity.this, "分配成功!", Toast.LENGTH_SHORT).show();
                                                    //刷新
                                                    updateUserLineView(nowLineEntity.getPos());
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                }
                            });
                            break;
                        }
                    }
                }

            }
        });
    }

    /**
     * 修改环节耐久度
     *
     * @param id //环节id
     */
    private void modifyStep(int id) {
        MyHttp.Call(this, "dataInterface/UserPlStepInfo/updatePower?id=" + id + "&power=100", true, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    if (jsonObject.getInt("status") == 200) {
                        Toast.makeText(MainActivity.this, "维修成功", Toast.LENGTH_SHORT).show();
                        updateUserLineView(nowLineEntity.getPos());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 进去下一个环节
     */
    private void nextStep() {
        //获取供货动列表
        MyHttp.Call(this, "Interface/index/supplyListTEditer", false, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                gson = new Gson();
                Json_SupplyAll json_supplyAll = gson.fromJson(jsonObject.toString(), Json_SupplyAll.class);
                supplyList = json_supplyAll.getData();
                //筛选出自己需要的材料
                for (Json_SupplyAll.DataEntity entity1 : supplyList) {
                    //获取当前环节
                    Json_UserLineAll.DataEntity.UserLineStepEntity nowEntity = null;
                    for (Json_UserLineAll.DataEntity.UserLineStepEntity entity : nowLineEntity.getUserLineStep()) {
                        if (nowLineEntity.getLineStepId() == entity.getProcessId()) {
                            nowEntity = entity;
                            break;
                        }
                    }
                    if (StringUtils.isInclude(nowEntity.getStageEntity().getStageName(), entity1.getMaterialName())) {
                        //执行进仓
                        MyHttp.Call(MainActivity.this, "Interface/index/addUserMaterialStore?userLineId=" + nowLineEntity.getId() + "&num=" + entity1.getNum() + "&supplyListId=" + entity1.getId(), true, new com.android.volley.Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getInt("status") == 200) {
                                        Toast.makeText(MainActivity.this, "进仓成功!", Toast.LENGTH_SHORT).show();
                                        //进行补货
                                        MyHttp.Call(MainActivity.this, "Interface/index/addUserMaterial?userLineId=" + nowLineEntity.getId(), false, new com.android.volley.Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject jsonObject) {
                                                //进行下跳入下一个环节
                                                MyHttp.Call(MainActivity.this, "Interface/index/nextLineStep?userLineId=" + nowLineEntity.getId(), false, new com.android.volley.Response.Listener<JSONObject>() {
                                                    @Override
                                                    public void onResponse(JSONObject jsonObject) {
                                                        try {
                                                            if (jsonObject.getInt("status") == 200) {
                                                                Toast.makeText(MainActivity.this, "下一个环节操作成功!", Toast.LENGTH_SHORT).show();
                                                                //进行下跳入下一个环节
                                                                updateUserLineView(nowLineEntity.getPos());
                                                            } else {
                                                                Toast.makeText(MainActivity.this, "下一个环节提示:" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                                            }
                                                        } catch (JSONException e) {
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                    } else {
                                        Toast.makeText(MainActivity.this, "进货提示:" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        break;
                    }
                    Toast.makeText(MainActivity.this, "没有找到材料!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        mMainSwitchLine = findViewById(R.id.main_switchLine);
        mMainLayoutMenu = findViewById(R.id.main_layout_menu);
        mMainLvMenu = findViewById(R.id.main_lv_menu);
        userLines = new ArrayList<>();
        mainMenuLvAdapter = new MainMenuLvAdapter();
        mMainLvMenu.setAdapter(mainMenuLvAdapter);
        mMainPeople1Layout = findViewById(R.id.main_people1_layout);
        mMainPeople1Name = findViewById(R.id.main_people1_name);
        mMainPeople1HqV = findViewById(R.id.main_people1_hqV);
        mMainPeople1Hq = findViewById(R.id.main_people1_hq);
        mMainPeople2Layout = findViewById(R.id.main_people2_layout);
        mMainPeople2Name = findViewById(R.id.main_people2_name);
        mMainPeople2HpV = findViewById(R.id.main_people2_hpV);
        mMainPeople2Hp = findViewById(R.id.main_people2_hp);
        mMainPeople3Layout = findViewById(R.id.main_people3_layout);
        mMainPeople3Name = findViewById(R.id.main_people3_name);
        mMainPeople3HpV = findViewById(R.id.main_people3_hpV);
        mMainPeople3Hp = findViewById(R.id.main_people3_hp);
        mMainPeople4Layout = findViewById(R.id.main_people4_layout);
        mMainPeople4Name = findViewById(R.id.main_people4_name);
        mMainPeople4HpV = findViewById(R.id.main_people4_hpV);
        mMainPeople4Hp = findViewById(R.id.main_people4_hp);
        peopleLayouts = new ArrayList<>();
        peopleLayouts.add(mMainPeople1Layout);
        peopleLayouts.add(mMainPeople2Layout);
        peopleLayouts.add(mMainPeople3Layout);
        peopleLayouts.add(mMainPeople4Layout);
        mMainAllPeople = findViewById(R.id.main_allPeople);
        userPersonEntities = new ArrayList<>();
        userLineStepEntities = new ArrayList<>();
        mMainGv = findViewById(R.id.main_gv);
        itemStepTableAdapter = new ItemStepTableAdapter();
        mMainNextStep = findViewById(R.id.main_nextStep);
        mMainGv.setAdapter(itemStepTableAdapter);
        supplyList = new ArrayList<>();
        mMainMyWorkInfo = findViewById(R.id.main_myWorkInfo);
        mMainRefresh = findViewById(R.id.main_refresh);
        mMainMyTable = findViewById(R.id.main_myTable);
        mMainLvTable = findViewById(R.id.main_lv_table);
        tableEntities = new ArrayList<>();
        tableEntities.add(new WorkTableEntity("订单仓库", MyOrderTable.class));
        tableEntities.add(new WorkTableEntity("材料仓库", MyMaterialAll.class));
        tableEntities.add(new WorkTableEntity("车辆仓库", MyCarTable.class));
        mainTableLvAdapter = new MainTableLvAdapter();
        mMainLvTable.setAdapter(mainTableLvAdapter);
        mMainNotice = findViewById(R.id.main_notice);
        mMainNotice.setSelected(true);
    }

    //菜单适配器
    public class MainMenuLvAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return userLines.size();
        }

        @Override
        public Json_UserLineAll getItem(int position) {
            return userLines.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.main_menu_lv, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_UserLineAll) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(Json_UserLineAll object, ViewHolder holder) {
            //TODO implement
            try {
             if (object.getData() != null) {
                 int lineId = object.getData().getLineId();
                 holder.menuItemLine.setText((lineId == 1 ? "轿车" : lineId == 2 ? "MPV" : "SUV") + "生产线位置:" + (object.getPosition() + 1));
                 if (object.getData().getIsAI() == 1)
                        holder.menuItemV.setBackgroundResource(R.drawable.shape_menu_yellow);
                    else
                    holder.menuItemV.setBackgroundResource(R.drawable.shape_menu_green);
                } else {
                    //没有创建
                 holder.menuItemLine.setText("未创建位置:" + (object.getPosition() + 1));
                    holder.menuItemV.setBackgroundResource(R.drawable.shape_menu_red);
                }

            } catch (Exception e) {
                holder.menuItemLine.setText("未创建位置:" + (object.getPosition() + 1));
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView menuItemLine;
            private View menuItemV;

            public ViewHolder(View view) {
                menuItemLine = (TextView) view.findViewById(R.id.menu_item_line);
                menuItemV = (View) view.findViewById(R.id.menu_item_v);
            }
        }
    }

    //环节适配器
    public class ItemStepTableAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return userLineStepEntities.size();
        }

        @Override
        public Json_UserLineAll.DataEntity.UserLineStepEntity getItem(int position) {
            return userLineStepEntities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_step_table, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((Json_UserLineAll.DataEntity.UserLineStepEntity) getItem(position), (ViewHolder) convertView.getTag(), position);
            return convertView;
        }

        private void initializeViews(final Json_UserLineAll.DataEntity.UserLineStepEntity object, ViewHolder holder, int position) {
            //TODO implement
            try {
                holder.itemStepStep.setText("第" + (position + 1) + "步骤");
                int lineStepId = userLines.get(nowLineEntity.getPos()).getData().getLineStepId();//当前环节
                holder.itemStepState.setBackgroundResource(lineStepId == object.getProcessId() ?
                        R.drawable.shape_step_blue : object.getHp() <= 0 ?
                        R.drawable.shape_step_red : R.drawable.shape_step_green);
                String naem = object.getStageEntity().getStageName();
                holder.itemStepName.setText(naem + "");
                holder.itemStepHq.setText("耐久度:" + object.getHp() + "/" + "所耗:" + object.getConsume());
                holder.itemStepUpdate.setVisibility(object.getHp() <= 0 ? View.VISIBLE : View.GONE);
                holder.itemStepUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //维修环节
                        modifyStep(object.getId());
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private TextView itemStepStep;
            private View itemStepState;
            private TextView itemStepName;
            private TextView itemStepHq;
            private Button itemStepUpdate;

            public ViewHolder(View view) {
                itemStepStep = (TextView) view.findViewById(R.id.item_step_step);
                itemStepState = (View) view.findViewById(R.id.item_step_state);
                itemStepName = (TextView) view.findViewById(R.id.item_step_name);
                itemStepHq = (TextView) view.findViewById(R.id.item_step_hq);
                itemStepUpdate = (Button) view.findViewById(R.id.item_step_update);
            }
        }
    }

    public class MainTableLvAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return tableEntities.size();
        }

        @Override
        public WorkTableEntity getItem(int position) {
            return tableEntities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.main_table_lv, null);
                convertView.setTag(new ViewHolder(convertView));
            }
            initializeViews((WorkTableEntity) getItem(position), (ViewHolder) convertView.getTag());
            return convertView;
        }

        private void initializeViews(final WorkTableEntity object, final ViewHolder holder) {
            //TODO implement
            try {
                holder.tableItemName.setText(object.getName());
                holder.tableItemLayout.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void onClick(View view) {
                        intent = new Intent();
                        intent.setClass(MainActivity.this, object.getToActivity());
                        intent.putExtra("userLine", nowLineEntity.getId());
                        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                                MainActivity.this, Pair.<View, String>create(holder.tableItemName, "myTableTitle")).toBundle()
                        );
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected class ViewHolder {
            private LinearLayout tableItemLayout;
            private TextView tableItemName;

            public ViewHolder(View view) {
                tableItemLayout = (LinearLayout) view.findViewById(R.id.table_item_layout);
                tableItemName = (TextView) view.findViewById(R.id.table_item_name);
            }
        }
    }


}