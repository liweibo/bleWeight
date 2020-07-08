package net.pojo;

public class NewOrder {

    /**
     * msg : 商品:大白菜库存不足
     * code : 8000004
     */

    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
