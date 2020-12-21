package com.example.advanceddome.entity;

import java.io.Serializable;
import java.util.List;

public class Json_StepCostAll {

    /**
     * data : [{"partId":8,"num":1,"plStepId":22,"id":22},{"partId":8,"num":1,"plStepId":21,"id":21},{"partId":8,"num":1,"plStepId":23,"id":23},{"partId":14,"num":1,"plStepId":5,"id":5},{"partId":21,"num":1,"plStepId":6,"id":6},{"partId":21,"num":1,"plStepId":7,"id":7},{"partId":21,"num":1,"plStepId":8,"id":8},{"partId":21,"num":1,"plStepId":9,"id":9},{"partId":30,"num":1,"plStepId":10,"id":10},{"partId":11,"num":1,"plStepId":11,"id":11},{"partId":24,"num":1,"plStepId":12,"id":12},{"partId":26,"num":1,"plStepId":13,"id":13},{"partId":32,"num":1,"plStepId":14,"id":14},{"partId":32,"num":1,"plStepId":15,"id":15},{"partId":32,"num":1,"plStepId":16,"id":16},{"partId":32,"num":1,"plStepId":17,"id":17},{"partId":17,"num":1,"plStepId":18,"id":18},{"partId":5,"num":1,"plStepId":19,"id":19},{"partId":36,"num":1,"plStepId":20,"id":20},{"partId":8,"num":1,"plStepId":24,"id":24},{"partId":13,"num":1,"plStepId":25,"id":25},{"partId":20,"num":1,"plStepId":26,"id":26},{"partId":20,"num":1,"plStepId":27,"id":27},{"partId":20,"num":1,"plStepId":28,"id":28},{"partId":20,"num":1,"plStepId":29,"id":29},{"partId":29,"num":1,"plStepId":30,"id":30},{"partId":1,"num":1,"plStepId":31,"id":31},{"partId":23,"num":1,"plStepId":32,"id":32},{"partId":25,"num":1,"plStepId":33,"id":33},{"partId":31,"num":1,"plStepId":34,"id":34},{"partId":31,"num":1,"plStepId":35,"id":35},{"partId":31,"num":1,"plStepId":36,"id":36},{"partId":31,"num":1,"plStepId":37,"id":37},{"partId":16,"num":1,"plStepId":38,"id":38},{"partId":4,"num":1,"plStepId":39,"id":39},{"partId":35,"num":1,"plStepId":40,"id":40},{"partId":7,"num":1,"plStepId":41,"id":41},{"partId":7,"num":1,"plStepId":42,"id":42},{"partId":7,"num":1,"plStepId":43,"id":43},{"partId":7,"num":1,"plStepId":44,"id":44},{"partId":15,"num":1,"plStepId":45,"id":45},{"partId":22,"num":1,"plStepId":46,"id":46},{"partId":22,"num":1,"plStepId":47,"id":47},{"partId":22,"num":1,"plStepId":48,"id":48},{"partId":22,"num":1,"plStepId":49,"id":49},{"partId":19,"num":1,"plStepId":50,"id":50},{"partId":12,"num":1,"plStepId":51,"id":51},{"partId":38,"num":1,"plStepId":52,"id":52},{"partId":34,"num":1,"plStepId":53,"id":53},{"partId":33,"num":1,"plStepId":54,"id":54},{"partId":33,"num":1,"plStepId":55,"id":55},{"partId":33,"num":1,"plStepId":56,"id":56},{"partId":33,"num":1,"plStepId":57,"id":57},{"partId":18,"num":1,"plStepId":58,"id":58},{"partId":10,"num":1,"plStepId":59,"id":59},{"partId":37,"num":1,"plStepId":60,"id":60},{"partId":9,"num":1,"plStepId":61,"id":61},{"partId":9,"num":1,"plStepId":62,"id":62},{"partId":9,"num":1,"plStepId":63,"id":63},{"partId":9,"num":1,"plStepId":64,"id":64}]
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

    public class DataEntity  implements Serializable {
        /**
         * partId : 8
         * num : 1
         * plStepId : 22
         * id : 22
         */
        private int partId;
        private int num;
        private int plStepId;
        private int id;

        public void setPartId(int partId) {
            this.partId = partId;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setPlStepId(int plStepId) {
            this.plStepId = plStepId;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPartId() {
            return partId;
        }

        public int getNum() {
            return num;
        }

        public int getPlStepId() {
            return plStepId;
        }

        public int getId() {
            return id;
        }
    }
}
