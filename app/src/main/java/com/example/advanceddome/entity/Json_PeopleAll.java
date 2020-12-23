package com.example.advanceddome.entity;

import java.io.Serializable;
import java.util.List;

public class Json_PeopleAll implements Serializable {

    /**
     * data : [{"gold":200,"peopleName":"李刚","talentMarketId":1,"icon":null,"hp":100,"id":1,"content":"汽车工程师","status":0},{"gold":50,"peopleName":"丁运生","talentMarketId":1,"icon":null,"hp":100,"id":2,"content":"汽车厂工人","status":1},{"gold":300,"peopleName":"方华高","talentMarketId":1,"icon":null,"hp":100,"id":3,"content":"汽车工厂技术人员","status":2},{"gold":789,"peopleName":"朱云贵","talentMarketId":1,"icon":null,"hp":100,"id":30,"content":"汽车厂工人","status":1},{"gold":150,"peopleName":"邹 辉 ","talentMarketId":1,"icon":null,"hp":100,"id":5,"content":"汽车工程师","status":0},{"gold":80,"peopleName":"杨文","talentMarketId":1,"icon":null,"hp":100,"id":6,"content":"汽车厂工人","status":1},{"gold":200,"peopleName":"朱元元","talentMarketId":1,"icon":null,"hp":100,"id":7,"content":"汽车工厂技术人员","status":2},{"gold":140,"peopleName":"周正发","talentMarketId":1,"icon":null,"hp":100,"id":8,"content":"汽车质检员","status":3},{"gold":300,"peopleName":"张伟","talentMarketId":1,"icon":null,"hp":100,"id":9,"content":"汽车工程师","status":0},{"gold":60,"peopleName":"周丽","talentMarketId":1,"icon":null,"hp":100,"id":10,"content":"汽车厂工人","status":1},{"gold":200,"peopleName":"陈天云","talentMarketId":1,"icon":null,"hp":100,"id":12,"content":"汽车质检员","status":3},{"gold":140,"peopleName":"陈敏","talentMarketId":1,"icon":null,"hp":100,"id":11,"content":"技术人员","status":2},{"gold":300,"peopleName":"王百年","talentMarketId":1,"icon":null,"hp":100,"id":13,"content":"汽车工程师","status":0},{"gold":90,"peopleName":"王莉","talentMarketId":1,"icon":null,"hp":100,"id":14,"content":"汽车厂工人","status":1},{"gold":400,"peopleName":"杨保俊","talentMarketId":1,"icon":null,"hp":100,"id":15,"content":"汽车工厂技术人员","status":2},{"gold":120,"peopleName":"张大伟","talentMarketId":1,"icon":null,"hp":100,"id":16,"content":"汽车质检员","status":3},{"gold":351,"peopleName":"徐超","talentMarketId":1,"icon":null,"hp":100,"id":17,"content":"汽车工程师","status":0},{"gold":130,"peopleName":"于少明","talentMarketId":1,"icon":null,"hp":100,"id":18,"content":"汽车厂工人","status":1},{"gold":456,"peopleName":"吴雪平","talentMarketId":1,"icon":null,"hp":100,"id":19,"content":"汽车工厂技术人员","status":2},{"gold":123,"peopleName":"崔鹏","talentMarketId":1,"icon":null,"hp":100,"id":22,"content":"汽车厂工人","status":1},{"gold":145,"peopleName":"David","talentMarketId":1,"icon":null,"hp":100,"id":23,"content":"汽车工厂技术人员","status":2},{"gold":457,"peopleName":"张先龙","talentMarketId":1,"icon":null,"hp":100,"id":24,"content":"汽车质检员","status":3},{"gold":999,"peopleName":"邓宁","talentMarketId":1,"icon":null,"hp":100,"id":25,"content":"汽车工程师","status":0},{"gold":489,"peopleName":"钟华国","talentMarketId":1,"icon":null,"hp":100,"id":26,"content":"汽车厂工人","status":1},{"gold":888,"peopleName":"罗梅","talentMarketId":1,"icon":null,"hp":100,"id":27,"content":"汽车工厂技术人员","status":2},{"gold":666,"peopleName":"张锋","talentMarketId":1,"icon":null,"hp":100,"id":29,"content":"汽车工程师","status":0},{"gold":777,"peopleName":"王琪","talentMarketId":1,"icon":null,"hp":100,"id":28,"content":"汽车质检员","status":3},{"gold":459,"peopleName":"李芳","talentMarketId":1,"icon":null,"hp":100,"id":32,"content":"汽车质检员","status":3},{"gold":479,"peopleName":"李冰","talentMarketId":1,"icon":null,"hp":100,"id":31,"content":"技术","status":2},{"gold":150,"peopleName":"省均","talentMarketId":1,"icon":null,"hp":100,"id":4,"content":"汽车质检员","status":3},{"gold":458,"peopleName":"张旭","talentMarketId":1,"icon":null,"hp":100,"id":21,"content":"汽车工程师","status":0},{"gold":365,"peopleName":"杨庆春","talentMarketId":1,"icon":null,"hp":100,"id":20,"content":"汽车质检员","status":3}]
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
         * gold : 200
         * peopleName : 李刚
         * talentMarketId : 1
         * icon : null
         * hp : 100
         * id : 1
         * content : 汽车工程师
         * status : 0
         */
        private int gold;
        private String peopleName;
        private int talentMarketId;
        private String icon;
        private int hp;
        private int id;
        private String content;
        private int status;
        private boolean isWork;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "gold=" + gold +
                    ", peopleName='" + peopleName + '\'' +
                    ", talentMarketId=" + talentMarketId +
                    ", icon='" + icon + '\'' +
                    ", hp=" + hp +
                    ", id=" + id +
                    ", content='" + content + '\'' +
                    ", status=" + status +
                    ", isWork=" + isWork +
                    '}';
        }

        public boolean isWork() {
            return isWork;
        }

        public void setWork(boolean work) {
            isWork = work;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public void setPeopleName(String peopleName) {
            this.peopleName = peopleName;
        }

        public void setTalentMarketId(int talentMarketId) {
            this.talentMarketId = talentMarketId;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getGold() {
            return gold;
        }

        public String getPeopleName() {
            return peopleName;
        }

        public int getTalentMarketId() {
            return talentMarketId;
        }

        public String getIcon() {
            return icon;
        }

        public int getHp() {
            return hp;
        }

        public int getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public int getStatus() {
            return status;
        }
    }
}
