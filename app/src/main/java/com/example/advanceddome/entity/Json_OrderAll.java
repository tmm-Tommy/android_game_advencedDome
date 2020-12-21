package com.example.advanceddome.entity;

import java.util.List;

public class Json_OrderAll {

    /**
     * data : [{"hang":0,"color":0,"userWorkId":1,"wheel":0,"num":1,"control":0,"type":0,"content":"初始订单","speed":0,"carId":1,"gold":1000,"brake":0,"engine":2,"userAppointmentName":"订单一","id":980,"time":1571639400},{"hang":2,"color":1,"userWorkId":1,"wheel":1,"num":1,"control":1,"type":0,"content":"初始订单","speed":1,"carId":2,"gold":2000,"brake":1,"engine":2,"userAppointmentName":"订单二","id":981,"time":1571639400}]
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

    public static class DataEntity {
        /**
         * hang : 0
         * color : 0
         * userWorkId : 1
         * wheel : 0
         * num : 1
         * control : 0
         * type : 0
         * content : 初始订单
         * speed : 0
         * carId : 1
         * gold : 1000
         * brake : 0
         * engine : 2
         * userAppointmentName : 订单一
         * id : 980
         * time : 1571639400
         */
        private int hang;
        private int color;
        private int userWorkId;
        private int wheel;
        private int num;
        private int control;
        private int type;
        private String content;
        private int speed;
        private int carId;
        private int gold;
        private int brake;
        private int engine;
        private String userAppointmentName;
        private int id;
        private int time;

        public void setHang(int hang) {
            this.hang = hang;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public void setUserWorkId(int userWorkId) {
            this.userWorkId = userWorkId;
        }

        public void setWheel(int wheel) {
            this.wheel = wheel;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public void setControl(int control) {
            this.control = control;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public void setBrake(int brake) {
            this.brake = brake;
        }

        public void setEngine(int engine) {
            this.engine = engine;
        }

        public void setUserAppointmentName(String userAppointmentName) {
            this.userAppointmentName = userAppointmentName;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getHang() {
            return hang;
        }

        public int getColor() {
            return color;
        }

        public int getUserWorkId() {
            return userWorkId;
        }

        public int getWheel() {
            return wheel;
        }

        public int getNum() {
            return num;
        }

        public int getControl() {
            return control;
        }

        public int getType() {
            return type;
        }

        public String getContent() {
            return content;
        }

        public int getSpeed() {
            return speed;
        }

        public int getCarId() {
            return carId;
        }

        public int getGold() {
            return gold;
        }

        public int getBrake() {
            return brake;
        }

        public int getEngine() {
            return engine;
        }

        public String getUserAppointmentName() {
            return userAppointmentName;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }
    }
}
