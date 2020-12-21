package com.example.advanceddome.entity;

import java.io.Serializable;
import java.util.List;

public class Json_UserLineAll implements Serializable {

    /**
     * data : {"lineStepId":15,"isAI":1,"userCarStore":[{"num":1,"carTypeId":2,"id":9219,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9213,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9218,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9217,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9212,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9211,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9209,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9210,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":1,"id":9208,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":2,"id":9216,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9215,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":1,"id":9207,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9206,"type":0,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9205,"type":0,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":2,"id":9214,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":1,"id":9204,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9203,"type":0,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9202,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9201,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9200,"type":0,"carTypeName":"轿车汽车"}],"userQuality":[{"size":7,"costTime":3,"price":3000,"carTypeId":2,"id":1677,"repairPrice":60,"content":"MPV汽车标准型"},{"size":7,"costTime":1,"price":3000,"carTypeId":2,"id":1676,"repairPrice":60,"content":"MPV汽车标准型"}],"userFactoryId":1,"lineId":2,"userPerson":[{"personName":"David","price":145,"hp":100,"typeName":"技术人员","personId":23,"id":15649,"type":2},{"personName":"邓宁","price":999,"hp":40,"typeName":"工程师","personId":25,"id":15648,"type":0},{"personName":"崔鹏","price":123,"hp":40,"typeName":"工人","personId":22,"id":15647,"type":1},{"personName":"徐超","price":351,"hp":50,"typeName":"工程师","personId":17,"id":15646,"type":0},{"personName":"杨保俊","price":400,"hp":80,"typeName":"技术人员","personId":15,"id":15645,"type":2},{"personName":"张大伟","price":120,"hp":40,"typeName":"质检员","personId":16,"id":15644,"type":3}],"costTime":0,"pos":3,"userLineStep":[{"processId":24,"costTime":0,"nextLineStepName":null,"hp":70,"step":20,"consume":30,"id":36988,"nextUserLineStepId":-1},{"processId":23,"costTime":0,"nextLineStepName":"MPV车型生产环节20","hp":70,"step":19,"consume":30,"id":36987,"nextUserLineStepId":24},{"processId":22,"costTime":0,"nextLineStepName":"MPV车型生产环节19","hp":70,"step":18,"consume":30,"id":36986,"nextUserLineStepId":23},{"processId":21,"costTime":0,"nextLineStepName":"MPV车型生产环节18","hp":70,"step":17,"consume":30,"id":36985,"nextUserLineStepId":22},{"processId":20,"costTime":0,"nextLineStepName":"MPV车型生产环节17","hp":70,"step":16,"consume":30,"id":36984,"nextUserLineStepId":21},{"processId":19,"costTime":0,"nextLineStepName":"MPV车型生产环节16","hp":70,"step":15,"consume":30,"id":36983,"nextUserLineStepId":20},{"processId":18,"costTime":0,"nextLineStepName":"MPV车型生产环节15","hp":70,"step":14,"consume":30,"id":36982,"nextUserLineStepId":19},{"processId":17,"costTime":0,"nextLineStepName":"MPV车型生产环节14","hp":70,"step":13,"consume":30,"id":36981,"nextUserLineStepId":18},{"processId":16,"costTime":0,"nextLineStepName":"MPV车型生产环节13","hp":70,"step":12,"consume":30,"id":36980,"nextUserLineStepId":17},{"processId":15,"costTime":0,"nextLineStepName":"MPV车型生产环节12","hp":70,"step":11,"consume":30,"id":36979,"nextUserLineStepId":16},{"processId":14,"costTime":0,"nextLineStepName":"MPV车型生产环节11","hp":40,"step":10,"consume":30,"id":36978,"nextUserLineStepId":15},{"processId":13,"costTime":0,"nextLineStepName":"MPV车型生产环节10","hp":40,"step":9,"consume":30,"id":36977,"nextUserLineStepId":14},{"processId":11,"costTime":0,"nextLineStepName":"MPV车型生产环节9","hp":40,"step":8,"consume":30,"id":36976,"nextUserLineStepId":13},{"processId":12,"costTime":0,"nextLineStepName":"MPV车型生产环节8","hp":40,"step":7,"consume":30,"id":36975,"nextUserLineStepId":12},{"processId":10,"costTime":0,"nextLineStepName":"MPV车型生产环节7","hp":40,"step":6,"consume":30,"id":36974,"nextUserLineStepId":11},{"processId":9,"costTime":0,"nextLineStepName":"MPV车型生产环节6","hp":40,"step":5,"consume":30,"id":36973,"nextUserLineStepId":10},{"processId":8,"costTime":0,"nextLineStepName":"MPV车型生产环节5","hp":40,"step":4,"consume":30,"id":36972,"nextUserLineStepId":9},{"processId":7,"costTime":0,"nextLineStepName":"MPV车型生产环节4","hp":40,"step":3,"consume":30,"id":36971,"nextUserLineStepId":8},{"processId":6,"costTime":0,"nextLineStepName":"MPV车型生产环节3","hp":40,"step":2,"consume":30,"id":36970,"nextUserLineStepId":7},{"processId":5,"costTime":0,"nextLineStepName":"MPV车型生产环节2","hp":40,"step":1,"consume":30,"id":36969,"nextUserLineStepId":6}],"userPosition":[{"positionName":"MPV汽车检测人员","personName":"张大伟","positionId":8,"consume":2,"id":15515,"userPersonId":15644},{"positionName":"MPV汽车工人","personName":"崔鹏","positionId":6,"consume":2,"id":15514,"userPersonId":15647},{"positionName":"MPV汽车技术人员","personName":"杨保俊","positionId":7,"consume":2,"id":15516,"userPersonId":15645},{"positionName":"MPV汽车工程师","personName":"邓宁","positionId":5,"consume":2,"id":15512,"userPersonId":15648}],"userMaterialStore":[{"materialName":"MPV前盖","size":1,"num":3,"id":25684,"iconUrl":"/factory_uploads/icon/ui_qiangai02.png","materialId":17},{"materialName":"轿车引擎","size":2,"num":1,"id":25703,"iconUrl":"/factory_uploads/icon/ui_fadongji01.png","materialId":1},{"materialName":"MPV底盘","size":3,"num":2,"id":25683,"iconUrl":"/factory_uploads/icon/ui_dipan02.png","materialId":14},{"materialName":"MPV方向盘","size":1,"num":1,"id":25685,"iconUrl":"/factory_uploads/icon/ui_fangxiangpan02.png","materialId":26}],"id":3275,"status":0}
     * message : SUCCESS
     * status : 200
     */
    private DataEntity data;
    private String message;
    private int status;
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataEntity getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public static class DataEntity implements Serializable  {
        /**
         * lineStepId : 15
         * isAI : 1
         * userCarStore : [{"num":1,"carTypeId":2,"id":9219,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9213,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9218,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9217,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9212,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9211,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9209,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9210,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":1,"id":9208,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":2,"id":9216,"type":1,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":2,"id":9215,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":1,"id":9207,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9206,"type":0,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9205,"type":0,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":2,"id":9214,"type":0,"carTypeName":"MPV汽车"},{"num":1,"carTypeId":1,"id":9204,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9203,"type":0,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9202,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9201,"type":1,"carTypeName":"轿车汽车"},{"num":1,"carTypeId":1,"id":9200,"type":0,"carTypeName":"轿车汽车"}]
         * userQuality : [{"size":7,"costTime":3,"price":3000,"carTypeId":2,"id":1677,"repairPrice":60,"content":"MPV汽车标准型"},{"size":7,"costTime":1,"price":3000,"carTypeId":2,"id":1676,"repairPrice":60,"content":"MPV汽车标准型"}]
         * userFactoryId : 1
         * lineId : 2
         * userPerson : [{"personName":"David","price":145,"hp":100,"typeName":"技术人员","personId":23,"id":15649,"type":2},{"personName":"邓宁","price":999,"hp":40,"typeName":"工程师","personId":25,"id":15648,"type":0},{"personName":"崔鹏","price":123,"hp":40,"typeName":"工人","personId":22,"id":15647,"type":1},{"personName":"徐超","price":351,"hp":50,"typeName":"工程师","personId":17,"id":15646,"type":0},{"personName":"杨保俊","price":400,"hp":80,"typeName":"技术人员","personId":15,"id":15645,"type":2},{"personName":"张大伟","price":120,"hp":40,"typeName":"质检员","personId":16,"id":15644,"type":3}]
         * costTime : 0
         * pos : 3
         * userLineStep : [{"processId":24,"costTime":0,"nextLineStepName":null,"hp":70,"step":20,"consume":30,"id":36988,"nextUserLineStepId":-1},{"processId":23,"costTime":0,"nextLineStepName":"MPV车型生产环节20","hp":70,"step":19,"consume":30,"id":36987,"nextUserLineStepId":24},{"processId":22,"costTime":0,"nextLineStepName":"MPV车型生产环节19","hp":70,"step":18,"consume":30,"id":36986,"nextUserLineStepId":23},{"processId":21,"costTime":0,"nextLineStepName":"MPV车型生产环节18","hp":70,"step":17,"consume":30,"id":36985,"nextUserLineStepId":22},{"processId":20,"costTime":0,"nextLineStepName":"MPV车型生产环节17","hp":70,"step":16,"consume":30,"id":36984,"nextUserLineStepId":21},{"processId":19,"costTime":0,"nextLineStepName":"MPV车型生产环节16","hp":70,"step":15,"consume":30,"id":36983,"nextUserLineStepId":20},{"processId":18,"costTime":0,"nextLineStepName":"MPV车型生产环节15","hp":70,"step":14,"consume":30,"id":36982,"nextUserLineStepId":19},{"processId":17,"costTime":0,"nextLineStepName":"MPV车型生产环节14","hp":70,"step":13,"consume":30,"id":36981,"nextUserLineStepId":18},{"processId":16,"costTime":0,"nextLineStepName":"MPV车型生产环节13","hp":70,"step":12,"consume":30,"id":36980,"nextUserLineStepId":17},{"processId":15,"costTime":0,"nextLineStepName":"MPV车型生产环节12","hp":70,"step":11,"consume":30,"id":36979,"nextUserLineStepId":16},{"processId":14,"costTime":0,"nextLineStepName":"MPV车型生产环节11","hp":40,"step":10,"consume":30,"id":36978,"nextUserLineStepId":15},{"processId":13,"costTime":0,"nextLineStepName":"MPV车型生产环节10","hp":40,"step":9,"consume":30,"id":36977,"nextUserLineStepId":14},{"processId":11,"costTime":0,"nextLineStepName":"MPV车型生产环节9","hp":40,"step":8,"consume":30,"id":36976,"nextUserLineStepId":13},{"processId":12,"costTime":0,"nextLineStepName":"MPV车型生产环节8","hp":40,"step":7,"consume":30,"id":36975,"nextUserLineStepId":12},{"processId":10,"costTime":0,"nextLineStepName":"MPV车型生产环节7","hp":40,"step":6,"consume":30,"id":36974,"nextUserLineStepId":11},{"processId":9,"costTime":0,"nextLineStepName":"MPV车型生产环节6","hp":40,"step":5,"consume":30,"id":36973,"nextUserLineStepId":10},{"processId":8,"costTime":0,"nextLineStepName":"MPV车型生产环节5","hp":40,"step":4,"consume":30,"id":36972,"nextUserLineStepId":9},{"processId":7,"costTime":0,"nextLineStepName":"MPV车型生产环节4","hp":40,"step":3,"consume":30,"id":36971,"nextUserLineStepId":8},{"processId":6,"costTime":0,"nextLineStepName":"MPV车型生产环节3","hp":40,"step":2,"consume":30,"id":36970,"nextUserLineStepId":7},{"processId":5,"costTime":0,"nextLineStepName":"MPV车型生产环节2","hp":40,"step":1,"consume":30,"id":36969,"nextUserLineStepId":6}]
         * userPosition : [{"positionName":"MPV汽车检测人员","personName":"张大伟","positionId":8,"consume":2,"id":15515,"userPersonId":15644},{"positionName":"MPV汽车工人","personName":"崔鹏","positionId":6,"consume":2,"id":15514,"userPersonId":15647},{"positionName":"MPV汽车技术人员","personName":"杨保俊","positionId":7,"consume":2,"id":15516,"userPersonId":15645},{"positionName":"MPV汽车工程师","personName":"邓宁","positionId":5,"consume":2,"id":15512,"userPersonId":15648}]
         * userMaterialStore : [{"materialName":"MPV前盖","size":1,"num":3,"id":25684,"iconUrl":"/factory_uploads/icon/ui_qiangai02.png","materialId":17},{"materialName":"轿车引擎","size":2,"num":1,"id":25703,"iconUrl":"/factory_uploads/icon/ui_fadongji01.png","materialId":1},{"materialName":"MPV底盘","size":3,"num":2,"id":25683,"iconUrl":"/factory_uploads/icon/ui_dipan02.png","materialId":14},{"materialName":"MPV方向盘","size":1,"num":1,"id":25685,"iconUrl":"/factory_uploads/icon/ui_fangxiangpan02.png","materialId":26}]
         * id : 3275
         * status : 0
         */
        private int lineStepId;
        private int isAI;
        private List<UserCarStoreEntity> userCarStore;
        private List<UserQualityEntity> userQuality;
        private int userFactoryId;
        private int lineId;
        private List<UserPersonEntity> userPerson;
        private int costTime;
        private int pos;
        private List<UserLineStepEntity> userLineStep;
        private List<UserPositionEntity> userPosition;
        private List<UserMaterialStoreEntity> userMaterialStore;
        private int id;
        private int status;

        public void setLineStepId(int lineStepId) {
            this.lineStepId = lineStepId;
        }

        public void setIsAI(int isAI) {
            this.isAI = isAI;
        }

        public void setUserCarStore(List<UserCarStoreEntity> userCarStore) {
            this.userCarStore = userCarStore;
        }

        public void setUserQuality(List<UserQualityEntity> userQuality) {
            this.userQuality = userQuality;
        }

        public void setUserFactoryId(int userFactoryId) {
            this.userFactoryId = userFactoryId;
        }

        public void setLineId(int lineId) {
            this.lineId = lineId;
        }

        public void setUserPerson(List<UserPersonEntity> userPerson) {
            this.userPerson = userPerson;
        }

        public void setCostTime(int costTime) {
            this.costTime = costTime;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public void setUserLineStep(List<UserLineStepEntity> userLineStep) {
            this.userLineStep = userLineStep;
        }

        public void setUserPosition(List<UserPositionEntity> userPosition) {
            this.userPosition = userPosition;
        }

        public void setUserMaterialStore(List<UserMaterialStoreEntity> userMaterialStore) {
            this.userMaterialStore = userMaterialStore;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getLineStepId() {
            return lineStepId;
        }

        public int getIsAI() {
            return isAI;
        }

        public List<UserCarStoreEntity> getUserCarStore() {
            return userCarStore;
        }

        public List<UserQualityEntity> getUserQuality() {
            return userQuality;
        }

        public int getUserFactoryId() {
            return userFactoryId;
        }

        public int getLineId() {
            return lineId;
        }

        public List<UserPersonEntity> getUserPerson() {
            return userPerson;
        }

        public int getCostTime() {
            return costTime;
        }

        public int getPos() {
            return pos;
        }

        public List<UserLineStepEntity> getUserLineStep() {
            return userLineStep;
        }

        public List<UserPositionEntity> getUserPosition() {
            return userPosition;
        }

        public List<UserMaterialStoreEntity> getUserMaterialStore() {
            return userMaterialStore;
        }

        public int getId() {
            return id;
        }

        public int getStatus() {
            return status;
        }

        public static class UserCarStoreEntity implements Serializable  {
            /**
             * num : 1
             * carTypeId : 2
             * id : 9219
             * type : 0
             * carTypeName : MPV汽车
             */
            private int num;
            private int carTypeId;
            private int id;
            private int type;
            private String carTypeName;

            public void setNum(int num) {
                this.num = num;
            }

            public void setCarTypeId(int carTypeId) {
                this.carTypeId = carTypeId;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setType(int type) {
                this.type = type;
            }

            public void setCarTypeName(String carTypeName) {
                this.carTypeName = carTypeName;
            }

            public int getNum() {
                return num;
            }

            public int getCarTypeId() {
                return carTypeId;
            }

            public int getId() {
                return id;
            }

            public int getType() {
                return type;
            }

            public String getCarTypeName() {
                return carTypeName;
            }
        }

        public static class UserQualityEntity implements Serializable  {
            /**
             * size : 7
             * costTime : 3
             * price : 3000
             * carTypeId : 2
             * id : 1677
             * repairPrice : 60
             * content : MPV汽车标准型
             */
            private int size;
            private int costTime;
            private int price;
            private int carTypeId;
            private int id;
            private int repairPrice;
            private String content;

            public void setSize(int size) {
                this.size = size;
            }

            public void setCostTime(int costTime) {
                this.costTime = costTime;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public void setCarTypeId(int carTypeId) {
                this.carTypeId = carTypeId;
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

            public int getSize() {
                return size;
            }

            public int getCostTime() {
                return costTime;
            }

            public int getPrice() {
                return price;
            }

            public int getCarTypeId() {
                return carTypeId;
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
        }

        public static class UserPersonEntity implements Serializable  {
            /**
             * personName : David
             * price : 145
             * hp : 100
             * typeName : 技术人员
             * personId : 23
             * id : 15649
             * type : 2
             */
            private String personName;
            private int price;
            private int hp;
            private String typeName;
            private int personId;
            private int id;
            private int type;

            @Override
            public String toString() {
                return "UserPersonEntity{" +
                        "personName='" + personName + '\'' +
                        ", price=" + price +
                        ", hp=" + hp +
                        ", typeName='" + typeName + '\'' +
                        ", personId=" + personId +
                        ", id=" + id +
                        ", type=" + type +
                        '}';
            }

            public void setPersonName(String personName) {
                this.personName = personName;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public void setHp(int hp) {
                this.hp = hp;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public void setPersonId(int personId) {
                this.personId = personId;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getPersonName() {
                return personName;
            }

            public int getPrice() {
                return price;
            }

            public int getHp() {
                return hp;
            }

            public String getTypeName() {
                return typeName;
            }

            public int getPersonId() {
                return personId;
            }

            public int getId() {
                return id;
            }

            public int getType() {
                return type;
            }
        }

        public static class UserLineStepEntity implements Serializable {
            /**
             * processId : 24
             * costTime : 0
             * nextLineStepName : null
             * hp : 70
             * step : 20
             * consume : 30
             * id : 36988
             * nextUserLineStepId : -1
             */
            private int processId;
            private int costTime;
            private String nextLineStepName;
            private int hp;
            private int step;
            private int consume;
            private int id;
            private int nextUserLineStepId;
            private Json_StageAll.DataEntity stageEntity;
            private Json_StepCostAll.DataEntity stepCostEntity;

            public Json_StepCostAll.DataEntity getStepCostEntity() {
                return stepCostEntity;
            }

            public void setStepCostEntity(Json_StepCostAll.DataEntity stepCostEntity) {
                this.stepCostEntity = stepCostEntity;
            }

            public Json_StageAll.DataEntity getStageEntity() {
                return stageEntity;
            }

            public void setStageEntity(Json_StageAll.DataEntity stageEntity) {
                this.stageEntity = stageEntity;
            }

            public void setProcessId(int processId) {
                this.processId = processId;
            }

            public void setCostTime(int costTime) {
                this.costTime = costTime;
            }

            public void setNextLineStepName(String nextLineStepName) {
                this.nextLineStepName = nextLineStepName;
            }

            public void setHp(int hp) {
                this.hp = hp;
            }

            public void setStep(int step) {
                this.step = step;
            }

            public void setConsume(int consume) {
                this.consume = consume;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setNextUserLineStepId(int nextUserLineStepId) {
                this.nextUserLineStepId = nextUserLineStepId;
            }

            public int getProcessId() {
                return processId;
            }

            public int getCostTime() {
                return costTime;
            }

            public String getNextLineStepName() {
                return nextLineStepName;
            }

            public int getHp() {
                return hp;
            }

            public int getStep() {
                return step;
            }

            public int getConsume() {
                return consume;
            }

            public int getId() {
                return id;
            }

            public int getNextUserLineStepId() {
                return nextUserLineStepId;
            }
        }

        public static class UserPositionEntity implements Serializable  {
            /**
             * positionName : MPV汽车检测人员
             * personName : 张大伟
             * positionId : 8
             * consume : 2
             * id : 15515
             * userPersonId : 15644
             */
            private String positionName;
            private String personName;
            private int positionId;
            private int consume;
            private int id;
            private int userPersonId;
            private UserPersonEntity personEntity;

            public UserPersonEntity getPersonEntity() {
                return personEntity;
            }

            public void setPersonEntity(UserPersonEntity personEntity) {
                this.personEntity = personEntity;
            }

            public void setPositionName(String positionName) {
                this.positionName = positionName;
            }

            public void setPersonName(String personName) {
                this.personName = personName;
            }

            public void setPositionId(int positionId) {
                this.positionId = positionId;
            }

            public void setConsume(int consume) {
                this.consume = consume;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setUserPersonId(int userPersonId) {
                this.userPersonId = userPersonId;
            }

            public String getPositionName() {
                return positionName;
            }

            public String getPersonName() {
                return personName;
            }

            public int getPositionId() {
                return positionId;
            }

            public int getConsume() {
                return consume;
            }

            public int getId() {
                return id;
            }

            public int getUserPersonId() {
                return userPersonId;
            }
        }

        public static class UserMaterialStoreEntity implements Serializable  {
            /**
             * materialName : MPV前盖
             * size : 1
             * num : 3
             * id : 25684
             * iconUrl : /factory_uploads/icon/ui_qiangai02.png
             * materialId : 17
             */
            private String materialName;
            private int size;
            private int num;
            private int id;
            private String iconUrl;
            private int materialId;

            public void setMaterialName(String materialName) {
                this.materialName = materialName;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public void setMaterialId(int materialId) {
                this.materialId = materialId;
            }

            public String getMaterialName() {
                return materialName;
            }

            public int getSize() {
                return size;
            }

            public int getNum() {
                return num;
            }

            public int getId() {
                return id;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public int getMaterialId() {
                return materialId;
            }
        }
    }
}
