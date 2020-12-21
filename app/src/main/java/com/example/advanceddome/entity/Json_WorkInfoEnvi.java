package com.example.advanceddome.entity;

import java.util.List;

public class Json_WorkInfoEnvi {

    /**
     * data : [{"beam":"245","acOnOff":1,"outTemp":"13℃","id":"1","lightSwitch":0,"power":"100","time":"05:15","workshopTemp":"3℃","day":"18","powerConsume":"41"}]
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
         * beam : 245
         * acOnOff : 1
         * outTemp : 13℃
         * id : 1
         * lightSwitch : 0
         * power : 100
         * time : 05:15
         * workshopTemp : 3℃
         * day : 18
         * powerConsume : 41
         */
        private String beam;
        private int acOnOff;
        private String outTemp;
        private String id;
        private int lightSwitch;
        private String power;
        private String time;
        private String workshopTemp;
        private String day;
        private String powerConsume;

        public void setBeam(String beam) {
            this.beam = beam;
        }

        public void setAcOnOff(int acOnOff) {
            this.acOnOff = acOnOff;
        }

        public void setOutTemp(String outTemp) {
            this.outTemp = outTemp;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setLightSwitch(int lightSwitch) {
            this.lightSwitch = lightSwitch;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setWorkshopTemp(String workshopTemp) {
            this.workshopTemp = workshopTemp;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public void setPowerConsume(String powerConsume) {
            this.powerConsume = powerConsume;
        }

        public String getBeam() {
            return beam;
        }

        public int getAcOnOff() {
            return acOnOff;
        }

        public String getOutTemp() {
            return outTemp;
        }

        public String getId() {
            return id;
        }

        public int getLightSwitch() {
            return lightSwitch;
        }

        public String getPower() {
            return power;
        }

        public String getTime() {
            return time;
        }

        public String getWorkshopTemp() {
            return workshopTemp;
        }

        public String getDay() {
            return day;
        }

        public String getPowerConsume() {
            return powerConsume;
        }
    }
}
