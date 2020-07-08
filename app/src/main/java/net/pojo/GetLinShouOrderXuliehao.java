package net.pojo;

public class GetLinShouOrderXuliehao {

    /**
     * code : 200
     * data : {"DefaultNumber":"00000000705"}
     */

    private int code;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * DefaultNumber : 00000000705
         */

        private String DefaultNumber;

        public String getDefaultNumber() {
            return DefaultNumber;
        }

        public void setDefaultNumber(String DefaultNumber) {
            this.DefaultNumber = DefaultNumber;
        }
    }
}
