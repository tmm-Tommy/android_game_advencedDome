package com.example.advanceddome.entity;

import java.io.Serializable;
import java.util.List;

public class Json_StageAll {

    /**
     * data : [{"stageName":"MPV汽车放置底盘","plStepId":5,"id":5,"content":"将汽车底盘放置在作业线上","nextStageId":6},{"stageName":"MPV汽车左前悬挂","plStepId":6,"id":6,"content":"机械臂将汽车左前悬挂固定在汽车底盘左前部","nextStageId":7},{"stageName":"MPV汽车右前悬挂","plStepId":7,"id":7,"content":"机械臂将汽车右前悬挂固定在汽车底盘右前部","nextStageId":8},{"stageName":"MPV汽车左后悬挂","plStepId":8,"id":8,"content":"机械臂将汽车左后悬挂固定在汽车底盘左后部","nextStageId":9},{"stageName":"MPV汽车右后悬挂","plStepId":9,"id":9,"content":"机械臂将汽车右后悬挂固定在汽车底盘左后部","nextStageId":10},{"stageName":"MPV汽车固定车架","plStepId":10,"id":10,"content":"将汽车车架固定在底盘上","nextStageId":12},{"stageName":"MPV汽车发动机","plStepId":12,"id":11,"content":"将发动机放置进车架前部","nextStageId":13},{"stageName":"MPV汽车椅子","plStepId":11,"id":12,"content":"将前排座椅后排座椅固定在车内","nextStageId":11},{"stageName":"MPV汽车方向盘","plStepId":13,"id":13,"content":"将方向盘放入车内前部","nextStageId":14},{"stageName":"MPV汽车左前车门","plStepId":14,"id":14,"content":"将左前车门固定在车架上","nextStageId":15},{"stageName":"MPV汽车右前车门","plStepId":15,"id":15,"content":"将右前车门固定在车架上","nextStageId":16},{"stageName":"MPV汽车左后车门","plStepId":16,"id":16,"content":"将左后车门固定在车架上","nextStageId":17},{"stageName":"MPV汽车右后车门","plStepId":17,"id":17,"content":"将右后车门固定在车架上","nextStageId":18},{"stageName":"MPV汽车引擎盖","plStepId":18,"id":18,"content":"安装引擎盖","nextStageId":19},{"stageName":"MPV汽车前挡风玻璃","plStepId":19,"id":19,"content":"安装前挡风玻璃","nextStageId":20},{"stageName":"MPV汽车后挡风玻璃","plStepId":20,"id":20,"content":"安装后挡风玻璃","nextStageId":21},{"stageName":"MPV汽车左前轮胎","plStepId":21,"id":21,"content":"机械臂在底盘上安装左前轮胎","nextStageId":22},{"stageName":"MPV汽车右前轮胎","plStepId":22,"id":22,"content":"机械臂在底盘上安装右前轮胎","nextStageId":23},{"stageName":"MPV汽车左后轮胎","plStepId":23,"id":23,"content":"机械臂在底盘上安装左后轮胎","nextStageId":24},{"stageName":"MPV汽车右后轮胎","plStepId":24,"id":24,"content":"机械臂在底盘上安装右后轮胎","nextStageId":null},{"stageName":"轿车汽车放置底盘","plStepId":25,"id":25,"content":"将汽车底盘放置在作业线上","nextStageId":26},{"stageName":"轿车汽车左前悬挂","plStepId":26,"id":26,"content":"机械臂将汽车左前悬挂固定在汽车底盘左前部","nextStageId":27},{"stageName":"轿车汽车右前悬挂","plStepId":27,"id":27,"content":"机械臂将汽车右前悬挂固定在汽车底盘右前部","nextStageId":28},{"stageName":"轿车汽车左后悬挂","plStepId":28,"id":28,"content":"机械臂将汽车左后悬挂固定在汽车底盘左后部","nextStageId":29},{"stageName":"轿车汽车右后悬挂","plStepId":29,"id":29,"content":"机械臂将汽车右后悬挂固定在汽车底盘左后部","nextStageId":30},{"stageName":"轿车汽车固定车架","plStepId":30,"id":30,"content":"将汽车车架固定在底盘上","nextStageId":32},{"stageName":"轿车汽车发动机","plStepId":32,"id":31,"content":"将发动机放置进车架前部","nextStageId":33},{"stageName":"轿车汽车椅子","plStepId":31,"id":32,"content":"将前排座椅后排座椅固定在车内","nextStageId":31},{"stageName":"轿车汽车方向盘","plStepId":33,"id":33,"content":"将方向盘放入车内前部","nextStageId":34},{"stageName":"轿车汽车左前车门","plStepId":34,"id":34,"content":"将左前车门固定在车架上","nextStageId":35},{"stageName":"轿车汽车右前车门","plStepId":35,"id":35,"content":"将右前车门固定在车架上","nextStageId":36},{"stageName":"轿车汽车左后车门","plStepId":36,"id":36,"content":"将左后车门固定在车架上","nextStageId":37},{"stageName":"轿车汽车右后车门","plStepId":37,"id":37,"content":"将右后车门固定在车架上","nextStageId":38},{"stageName":"轿车汽车引擎盖","plStepId":38,"id":38,"content":"安装引擎盖","nextStageId":39},{"stageName":"轿车汽车前挡风玻璃","plStepId":39,"id":39,"content":"安装前挡风玻璃","nextStageId":40},{"stageName":"轿车汽车后挡风玻璃","plStepId":40,"id":40,"content":"安装后挡风玻璃","nextStageId":41},{"stageName":"轿车汽车左前轮胎","plStepId":41,"id":41,"content":"机械臂在底盘上安装左前轮胎","nextStageId":42},{"stageName":"轿车汽车右前轮胎","plStepId":42,"id":42,"content":"机械臂在底盘上安装右前轮胎","nextStageId":43},{"stageName":"轿车汽车左后轮胎","plStepId":43,"id":43,"content":"机械臂在底盘上安装左后轮胎","nextStageId":44},{"stageName":"轿车汽车右后轮胎","plStepId":44,"id":44,"content":"机械臂在底盘上安装右后轮胎","nextStageId":null},{"stageName":"SUV汽车放置底盘","plStepId":45,"id":45,"content":"将汽车底盘放置在作业线上","nextStageId":46},{"stageName":"SUV汽车左前悬挂","plStepId":46,"id":46,"content":"机械臂将汽车左前悬挂固定在汽车底盘左前部","nextStageId":47},{"stageName":"SUV汽车右前悬挂","plStepId":47,"id":47,"content":"机械臂将汽车右前悬挂固定在汽车底盘右前部","nextStageId":48},{"stageName":"SUV汽车左后悬挂","plStepId":48,"id":48,"content":"机械臂将汽车左后悬挂固定在汽车底盘左后部","nextStageId":49},{"stageName":"SUV汽车右后悬挂","plStepId":49,"id":49,"content":"机械臂将汽车右后悬挂固定在汽车底盘左后部","nextStageId":50},{"stageName":"SUV汽车固定车架","plStepId":50,"id":50,"content":"将汽车车架固定在底盘上","nextStageId":52},{"stageName":"SUV汽车发动机","plStepId":52,"id":51,"content":"将发动机放置进车架前部","nextStageId":53},{"stageName":"SUV汽车椅子","plStepId":51,"id":52,"content":"将前排座椅后排座椅固定在车内","nextStageId":51},{"stageName":"SUV汽车方向盘","plStepId":53,"id":53,"content":"将方向盘放入车内前部","nextStageId":54},{"stageName":"SUV汽车左前车门","plStepId":54,"id":54,"content":"将左前车门固定在车架上","nextStageId":55},{"stageName":"SUV汽车右前车门","plStepId":55,"id":55,"content":"将右前车门固定在车架上","nextStageId":56},{"stageName":"SUV汽车左后车门","plStepId":56,"id":56,"content":"将左后车门固定在车架上","nextStageId":57},{"stageName":"SUV汽车右后车门","plStepId":57,"id":57,"content":"将右后车门固定在车架上","nextStageId":58},{"stageName":"SUV汽车引擎盖","plStepId":58,"id":58,"content":"安装引擎盖","nextStageId":59},{"stageName":"SUV汽车前挡风玻璃","plStepId":59,"id":59,"content":"安装前挡风玻璃","nextStageId":60},{"stageName":"SUV汽车后挡风玻璃","plStepId":60,"id":60,"content":"安装后挡风玻璃","nextStageId":61},{"stageName":"SUV汽车左前轮胎","plStepId":61,"id":61,"content":"机械臂在底盘上安装左前轮胎","nextStageId":62},{"stageName":"SUV汽车右前轮胎","plStepId":62,"id":62,"content":"机械臂在底盘上安装右前轮胎","nextStageId":63},{"stageName":"SUV汽车左后轮胎","plStepId":63,"id":63,"content":"机械臂在底盘上安装左后轮胎","nextStageId":64},{"stageName":"SUV汽车右后轮胎","plStepId":64,"id":64,"content":"机械臂在底盘上安装右后轮胎","nextStageId":null}]
     * message : SUCCESS
     * status : 200
     */
    private List<DataEntity> data;
    private String message;
    private int status;

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public class DataEntity implements Serializable {
        /**
         * stageName : MPV汽车放置底盘
         * plStepId : 5
         * id : 5
         * content : 将汽车底盘放置在作业线上
         * nextStageId : 6
         */
        private String stageName;
        private int plStepId;
        private int id;
        private String content;
        private int nextStageId;

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }

        public void setPlStepId(int plStepId) {
            this.plStepId = plStepId;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setNextStageId(int nextStageId) {
            this.nextStageId = nextStageId;
        }

        public String getStageName() {
            return stageName;
        }

        public int getPlStepId() {
            return plStepId;
        }

        public int getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public int getNextStageId() {
            return nextStageId;
        }
    }
}
