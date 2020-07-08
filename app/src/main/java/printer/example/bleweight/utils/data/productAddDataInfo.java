package printer.example.bleweight.utils.data;


public class productAddDataInfo {


    private String xuhao ;

    private String prodName;

    private String danjia;

    private String jianshu;

    private String zhongliang;
    private String xiaoji;


    public productAddDataInfo(String xuhao, String prodName,
                              String danjia,
                              String jianshu,
                              String zhongliang,
                              String xiaoji) {
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

    public String getdanjia() {
        return danjia;
    }

    public productAddDataInfo setdanjia(String danjia) {
        this.danjia = danjia;
        return this;
    }

    public String getjianshu() {
        return jianshu;
    }

    public productAddDataInfo setjianshu(String jianshu) {
        this.jianshu = jianshu;
        return this;
    }

    public String getzhongliang() {
        return zhongliang;
    }

    public productAddDataInfo setzhongliang(String zhongliang) {
        this.zhongliang = zhongliang;
        return this;
    }

    public String getXiaoji() {
        return xiaoji;
    }

    public productAddDataInfo setxiaoji(String xiaoji) {
        this.xiaoji = xiaoji;
        return this;
    }


    @Override
    public String toString() {
        return "-----test------";
    }
}
