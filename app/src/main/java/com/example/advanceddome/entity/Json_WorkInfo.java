package com.example.advanceddome.entity;

import java.util.List;

public class Json_WorkInfo {

    /**
     * data : [{"carCapacity":50000,"price":903100,"id":"1","partCapacity":10000}]
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
         * carCapacity : 50000
         * price : 903100
         * id : 1
         * partCapacity : 10000
         */
        private int carCapacity;
        private int price;
        private String id;
        private int partCapacity;

        public void setCarCapacity(int carCapacity) {
            this.carCapacity = carCapacity;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setPartCapacity(int partCapacity) {
            this.partCapacity = partCapacity;
        }

        public int getCarCapacity() {
            return carCapacity;
        }

        public int getPrice() {
            return price;
        }

        public String getId() {
            return id;
        }

        public int getPartCapacity() {
            return partCapacity;
        }
    }
}
