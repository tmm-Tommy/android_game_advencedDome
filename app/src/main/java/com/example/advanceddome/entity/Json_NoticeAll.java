package com.example.advanceddome.entity;

import java.io.Serializable;
import java.util.List;

public class Json_NoticeAll {

    /**
     * data : [{"informationName":"绝不仅仅是油改电 试驾广汽本田纯电动车型VE-1","words":"随着国内新能源发展的步伐越走越快，越来越多的企业，加入了中国新能源汽车发展的大军。特别是到9102年，笔者注意到，一直态度表现暧昧的合资车企，也开始布局自身的新能源产品。日系企业，在新能源技术研究与应用方面，一直走在世界的前列。而作为其中对于技术和驾驶乐趣的\u201c偏执狂\u201d日本本田汽车，也将与近期在华推出了首款兼具驾驶乐趣的新能源汽车-广汽本田VE -1。笔者有幸在这款车型，上市之前短暂的体验了一下。那么这款车型是否很好的展现了运动与新能源汽车的和谐并存呢？","icon":"/factory_uploads/2019/10/25/20191025112249640.jpg","id":31,"time":1572075000,"video":"/factory_uploads/2019/10/25/20191025112249595.mp4","status":3}]
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
         * informationName : 绝不仅仅是油改电 试驾广汽本田纯电动车型VE-1
         * words : 随着国内新能源发展的步伐越走越快，越来越多的企业，加入了中国新能源汽车发展的大军。特别是到9102年，笔者注意到，一直态度表现暧昧的合资车企，也开始布局自身的新能源产品。日系企业，在新能源技术研究与应用方面，一直走在世界的前列。而作为其中对于技术和驾驶乐趣的“偏执狂”日本本田汽车，也将与近期在华推出了首款兼具驾驶乐趣的新能源汽车-广汽本田VE -1。笔者有幸在这款车型，上市之前短暂的体验了一下。那么这款车型是否很好的展现了运动与新能源汽车的和谐并存呢？
         * icon : /factory_uploads/2019/10/25/20191025112249640.jpg
         * id : 31
         * time : 1572075000
         * video : /factory_uploads/2019/10/25/20191025112249595.mp4
         * status : 3
         */
        private String informationName;
        private String words;
        private String icon;
        private int id;
        private int time;
        private String video;
        private int status;

        public void setInformationName(String informationName) {
            this.informationName = informationName;
        }

        public void setWords(String words) {
            this.words = words;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getInformationName() {
            return informationName;
        }

        public String getWords() {
            return words;
        }

        public String getIcon() {
            return icon;
        }

        public int getId() {
            return id;
        }

        public int getTime() {
            return time;
        }

        public String getVideo() {
            return video;
        }

        public int getStatus() {
            return status;
        }
    }
}
