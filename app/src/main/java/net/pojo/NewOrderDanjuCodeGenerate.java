package net.pojo;

//新建订单时，需传一个生成的订单编码，这个编码每次请求都会加1
public class NewOrderDanjuCodeGenerate {

    /**
     * code : 200
     * data : {"DefaultNumber":"00000000715"}
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
         * DefaultNumber : 00000000715
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
