package com.example.advanceddome.entity;

import java.util.List;

public class Json_MaterialLog {

    /**
     * data : [{"supplyName":"新星汽车配件","materialName":"SUV底盘","price":200,"num":2,"userFactoryId":1,"lineName":"轿车车型生产线","id":560,"supplyListId":15,"time":1608461490,"userLineId":3357},{"supplyName":"细末汽车配件","materialName":"轿车底盘","price":900,"num":1,"userFactoryId":1,"lineName":"轿车车型生产线","id":559,"supplyListId":128,"time":1608461471,"userLineId":3357},{"supplyName":"新星汽车配件","materialName":"轿车座椅","price":2000,"num":1,"userFactoryId":1,"lineName":"轿车车型生产线","id":558,"supplyListId":5,"time":1608457631,"userLineId":3359},{"supplyName":"细末汽车配件","materialName":"轿车车架","price":400,"num":1,"userFactoryId":1,"lineName":"轿车车型生产线","id":557,"supplyListId":114,"time":1608457627,"userLineId":3359},{"supplyName":"细末汽车配件","materialName":"轿车悬挂","price":270,"num":1,"userFactoryId":1,"lineName":"轿车车型生产线","id":556,"supplyListId":121,"time":1608457621,"userLineId":3359},{"supplyName":"细末汽车配件","materialName":"轿车悬挂","price":270,"num":1,"userFactoryId":1,"lineName":"轿车车型生产线","id":555,"supplyListId":121,"time":1608457616,"userLineId":3359},{"supplyName":"枫叶汽车配件","materialName":"轿车悬挂","price":17250,"num":5,"userFactoryId":1,"lineName":"轿车车型生产线","id":554,"supplyListId":55,"time":1608457613,"userLineId":3359},{"supplyName":"枫叶汽车配件","materialName":"轿车悬挂","price":17250,"num":5,"userFactoryId":1,"lineName":"轿车车型生产线","id":553,"supplyListId":55,"time":1608457610,"userLineId":3359},{"supplyName":"细末汽车配件","materialName":"轿车底盘","price":900,"num":1,"userFactoryId":1,"lineName":"轿车车型生产线","id":552,"supplyListId":128,"time":1608457608,"userLineId":3359}]
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

    public class DataEntity {
        /**
         * supplyName : 新星汽车配件
         * materialName : SUV底盘
         * price : 200
         * num : 2
         * userFactoryId : 1
         * lineName : 轿车车型生产线
         * id : 560
         * supplyListId : 15
         * time : 1608461490
         * userLineId : 3357
         */
        private String supplyName;
        private String materialName;
        private int price;
        private int num;
        private int userFactoryId;
        private String lineName;
        private int id;
        private int supplyListId;
        private int time;
        private int userLineId;

        public void setSupplyName(String supplyName) {
            this.supplyName = supplyName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setUserFactoryId(int userFactoryId) {
            this.userFactoryId = userFactoryId;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSupplyListId(int supplyListId) {
            this.supplyListId = supplyListId;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setUserLineId(int userLineId) {
            this.userLineId = userLineId;
        }

        public String getSupplyName() {
            return supplyName;
        }

        public String getMaterialName() {
            return materialName;
        }

        public int getPrice() {
            return price;
        }

        public int getNum() {
            return num;
        }

        public int getUserFactoryId() {
            return userFactoryId;
        }

        public String getLineName() {
            return lineName;
        }

        public int getId() {
            return id;
        }

        public int getSupplyListId() {
            return supplyListId;
        }

        public int getTime() {
            return time;
        }

        public int getUserLineId() {
            return userLineId;
        }
    }
}
