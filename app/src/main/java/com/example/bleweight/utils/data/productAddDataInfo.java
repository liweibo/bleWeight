package com.example.bleweight.utils.data;


public class productAddDataInfo {


    private String xuhao ;

    private String prodName;

    private int danjia;

    private int jianshu;

    private double zhongliang;
    private int xiaoji;


    public productAddDataInfo(String xuhao, String prodName,
                              int danjia,
                              int jianshu,
                              double zhongliang,
                              int xiaoji) {
        this.xuhao = xuhao;
        this.prodName = prodName;
        this.danjia = danjia;
        this.jianshu = jianshu;
        this.zhongliang = zhongliang;
        this.xiaoji = xiaoji;

    }


    public String getxuhao() {
        return xuhao;
    }

    public productAddDataInfo setxuhao(String xuhao) {
        this.xuhao = xuhao;
        return this;
    }

    public String getprodName() {
        return prodName;
    }

    public productAddDataInfo setprodName(String prodName) {
        this.prodName = prodName;
        return this;
    }

    public int getdanjia() {
        return danjia;
    }

    public productAddDataInfo setdanjia(int danjia) {
        this.danjia = danjia;
        return this;
    }

    public int getjianshu() {
        return jianshu;
    }

    public productAddDataInfo setjianshu(int jianshu) {
        this.jianshu = jianshu;
        return this;
    }

    public double getzhongliang() {
        return zhongliang;
    }

    public productAddDataInfo setzhongliang(double zhongliang) {
        this.zhongliang = zhongliang;
        return this;
    }

    public int getXiaoji() {
        return xiaoji;
    }

    public productAddDataInfo setxiaoji(int xiaoji) {
        this.xiaoji = xiaoji;
        return this;
    }


    @Override
    public String toString() {
        return "-----test------";
    }
}
