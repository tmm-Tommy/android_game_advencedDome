package com.example.advanceddome.entity;

import java.util.List;

public class Json_NotCarAll {

    /**
     * data : [{"costTime":2,"CarType":{"size":6,"price":2000,"id":1,"repairPrice":50,"content":"轿车汽车标准型","carTypeName":"轿车汽车","lastUpdateTime":1575103866},"userFactoryId":1,"carTypeId":1,"id":1760,"userLineId":3348},{"costTime":1,"CarType":{"size":7,"price":3000,"id":2,"repairPrice":60,"content":"MPV汽车标准型","carTypeName":"MPV汽车","lastUpdateTime":1568880985},"userFactoryId":1,"carTypeId":2,"id":1761,"userLineId":3349}]
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
         * costTime : 2
         * CarType : {"size":6,"price":2000,"id":1,"repairPrice":50,"content":"轿车汽车标准型","carTypeName":"轿车汽车","lastUpdateTime":1575103866}
         * userFactoryId : 1
         * carTypeId : 1
         * id : 1760
         * userLineId : 3348
         */
        private int costTime;
        private CarTypeEntity CarType;
        private int userFactoryId;
        private int carTypeId;
        private int id;
        private int userLineId;

        public void setCostTime(int costTime) {
            this.costTime = costTime;
        }

        public void setCarType(CarTypeEntity CarType) {
            this.CarType = CarType;
        }

        public void setUserFactoryId(int userFactoryId) {
            this.userFactoryId = userFactoryId;
        }

        public void setCarTypeId(int carTypeId) {
            this.carTypeId = carTypeId;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setUserLineId(int userLineId) {
            this.userLineId = userLineId;
        }

        public int getCostTime() {
            return costTime;
        }

        public CarTypeEntity getCarType() {
            return CarType;
        }

        public int getUserFactoryId() {
            return userFactoryId;
        }

        public int getCarTypeId() {
            return carTypeId;
        }

        public int getId() {
            return id;
        }

        public int getUserLineId() {
            return userLineId;
        }

        public class CarTypeEntity {
            /**
             * size : 6
             * price : 2000
             * id : 1
             * repairPrice : 50
             * content : 轿车汽车标准型
             * carTypeName : 轿车汽车
             * lastUpdateTime : 1575103866
             */
            private int size;
            private int price;
            private int id;
            private int repairPrice;
            private String content;
            private String carTypeName;
            private int lastUpdateTime;

            public void setSize(int size) {
                this.size = size;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setRepairPrice(int repairPrice) {
                this.repairPrice = repairPrice;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setCarTypeName(String carTypeName) {
                this.carTypeName = carTypeName;
            }

            public void setLastUpdateTime(int lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public int getSize() {
                return size;
            }

            public int getPrice() {
                return price;
            }

            public int getId() {
                return id;
            }

            public int getRepairPrice() {
                return repairPrice;
            }

            public String getContent() {
                return content;
            }

            public String getCarTypeName() {
                return carTypeName;
            }

            public int getLastUpdateTime() {
                return lastUpdateTime;
            }
        }
    }
}
