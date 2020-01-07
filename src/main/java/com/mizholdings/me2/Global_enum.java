package com.mizholdings.me2;

public class Global_enum {
    /**
     * 资源类型
     */
    public enum COURSEWARE_TYPE {
        ALL("0", "", ""),
        IMAGE("7", Global.getImageUrl(), "图片"),
        VIDEO("3", "http://images.mizholdings.com/NQhMizsnM9PpRus7.mp4", "测试视频"),
        JIAO_AN("13", "http://images.mizholdings.com/zP2Fal2hMTCIsevy.pdf", "测试教案"),
        OFFICE("9", "http://images.mizholdings.com/aB1EmfmB9AfmrtE5.docx", "测试WORD"),
        ;
        public String value;
        public String url;
        public String name;

        COURSEWARE_TYPE(String value, String url, String name) {
            this.value = value;
            this.url = url;
            this.name = name;
        }
    }

    public enum LESSON_TYPE_ID {
        ALL("0", "全部"),
        MAT("2", "数学"),
        ENG("3", "英语"),
        SCI("10", "科学"),
        CHI("1", "语文"),
        HIS("4", "历史"),
        GEO("5", "地理"),
        POL("6", "政治"),
        BIO("7", "生物"),
        PHY("8", "物理"),
        CHE("9", "化学"),
        COM("11", "信息技术"),
        GEN("12", "通用技术"),
        ;
        public String value;
        public String name;

        private LESSON_TYPE_ID(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    public enum GRADEID {
        ALL("0", "全部"),
        ONE("1", "一年级"),
        TWO("2", "二年级"),
        THREE("3", "三年级"),
        FOUR("4", "四年级"),
        FIVE("5", "五年级"),
        SIX("6", "六年级"),
        SEVEN("7", "七年级"),
        EIGHT("8", "八年级"),
        NINE("9", "九年级");

        public String value;
        public String gradeName;

        private GRADEID(String value, String gradeName) {
            this.value = value;
            this.gradeName = gradeName;
        }
    }

    public enum PRIVATE_TYPE {
        OPEN("0", "开放"),
        CLOSE("1", "不开放");

        public String value;
        public String gradeName;

        private PRIVATE_TYPE(String value, String gradeName) {
            this.value = value;
            this.gradeName = gradeName;
        }
    }

    public enum PUB_TYPE {
        NO_APPLY("0", "未提交"),
        APPLY("1", "提交审核"),
        NO_PASS("1", "审核未通过"),
        PASS("1", "审核通过");

        public String value;
        public String name;

        private PUB_TYPE(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    public enum AnswerResult {
        RIGHT("0", "正确"),
        WRONG("2", "错误"),
        HALF_RIGHT("1", "半对");

        public String value;
        public String name;

        private AnswerResult(String value, String name) {
            this.value = value;
            this.name = name;
        }
    }


}
