package net;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class Constant {
    static public String usualInterfaceAddr = "http://129.211.40.187:8080";

    static public String portCheng="ttyS2";
    static public List<String> portChengls=new ArrayList<>();

    //登陆
    static public String loginpath = "/user/login";
    static public String logintoken = "";

    static public List<String> cangkuid =new ArrayList<>();
    static public List<String> cangkuname =new ArrayList<>();
    static public String myinfoname;



    //按物料分，拿到物料类别
    static public String wuliaopath = "/materialCategory/getAllList";
    static public String parentId = "-1";//parentId=-1


    //某个物料类别下对应的商品  传仓库id（查询仓库id可获取）与物料类别id（物料分类接口可获取），只传物料类别id也可以。
    static public String prodOfwuliaopath = "/depotItem/getMaterialList";
    static public String depotId = "";//仓库id
    static public String mcId = "";


    //获取仓库
    static public String cangku = "/depot/getAllList";
    //我的信息
    static public String myinfo = "/user/getUserSession";
    //批次类别
    static public String picitype = "/depotHead/getBatchNumberList";

    //批次下具体商品
    static public String proOfpicitype = "/depotItem/getMaterialList";
    static public String batchNumber = "";//批次号

    //获取客户 post form-data
    static public String getKehu = "/supplier/findBySelect_cus";//批次号  findBySelect_cus
    static public String UBType = "UserCustomer";//客户类型，目前写死UserCustomer
    static public String UBKeyId = "";//tenantId，从我的信息中获取


    //新增客户 post form-data
    static public String addkehu = "/supplier/add";
    //key：info  value：   getInfoV()
    static public String addkehuConta = "";
    static public String addkehuteleph = "";
    static public String addkehuAddress = "";


    //获取零售订单序列号
    static public String linshouorderXuliehao = "/depotHead/buildNumber";
    //获取收款账户
    static public String shoukaunzhanghu = "/account/getAccount";
    //查询商品库存  传仓库id mid。mid即materialId，就是物料id
    static public String queryProdkucun = "/depotItem/findStockNumById";
    static public String mId = "";


    //创建订单所需stock数据 就是上面查询商品库存的接口，不要重复定义了。。。
    static public String neworderStockdata = "/depotItem/findStockNumById";//不要用这个  用上面的。
    //创建订单所需订单编码数据
    static public String neworderCodedata = "/depotHead/buildNumber";

    //新建订单
    static public String neworder = "/depotHead/addDepotHeadAndDetail";
    static public List<String> neworderJsonInsertArra ;


    //新增客户要传入的value，key传info
    public static String getInfoV(){
        String infoV = "{\"supplier\":\"" +
                "易大大串串2" +
                "\",\"contacts\":\"" +
                addkehuConta +
                "\",\"telephone\":\"" +
                addkehuteleph +
                "\",\"email\":\"" +
                "yyy123@qq.com" +
                "\",\"phonenum\":\"" +
                "18672332929" +
                "\",\"fax\":\"\",\"" +
                "BeginNeedGet" +
                "\":\"\",\"BeginNeedPay\":\"\",\"AllNeedGet\":\"\",\"AllNeedPay\":\"\",\"taxNum\":\"\",\"taxRate\":\"\",\"bankName\":\"\",\"accountNumber\":\"\"," +

                "\"address\":\"" +
                addkehuAddress +

                "\",\"description\":\"\",\"type\":\"客户\",\"enabled\":1}";

        return infoV;
    }



    public static String getLoginPara() {

        String s = usualInterfaceAddr + loginpath;

        return s;
    }

    //物料类别
    public static String getWuliaoPara() {

        String s = usualInterfaceAddr + wuliaopath;

        return s;
    }


    //物料类别下商品
    //某个物料类别下对应的商品  传仓库id（查询仓库id可获取）与物料类别id（物料分类接口可获取），只传物料类别id也可以。
    public static String getProdOfWuliaoPara() {
        String s = usualInterfaceAddr + prodOfwuliaopath;
        return s;
    }


    //仓库获取
    public static String getCangkuPara() {
        String s = usualInterfaceAddr + cangku;
        return s;
    }


    //我的
    public static String getMyPara() {
        String s = usualInterfaceAddr + myinfo;
        return s;
    }


    //批次类别获取
    public static String getPiciTypePara() {
        String s = usualInterfaceAddr + picitype;
        return s;
    }


    //批次类别下的商品获取，传批次号与仓库（只传批次号也可以）
    public static String getProOfPiciTypePara() {
        String s = usualInterfaceAddr + proOfpicitype;
        return s;
    }
    //获取客户
    public static String getHuoquKehuPara() {
        String s = usualInterfaceAddr + getKehu;
        return s;
    }

    //增加客户
    public static String getaddKehuPara() {
        String s = usualInterfaceAddr + addkehu;
        return s;
    }

    //获取零售订单序列号
    public static String getLinshouOrderXulhPara() {
        String s = usualInterfaceAddr + linshouorderXuliehao;
        return s;
    }

    //获取收款账户
    public static String getShouKuanZhanghuPara() {
        String s = usualInterfaceAddr + shoukaunzhanghu;
        return s;
    }

    //查询商品库存
    public static String getqueryProdkucunPara() {
        String s = usualInterfaceAddr + queryProdkucun;
        return s;
    }

    //新建订单时需要的stock数据
    public static String getneworderStockdataPara() {
        String s = usualInterfaceAddr + neworderStockdata;
        return s;
    }

    //新建订单时需要的订单编码数据
    public static String getneworderCodePara() {
        String s = usualInterfaceAddr + neworderCodedata;
        return s;
    }

    //新建订单
    public static String getneworderPara() {
        String s = usualInterfaceAddr + neworder;
        return s;
    }
    //新建订单时传的json
    public static String getneworderJson() {
        String s = "{\n" +
                "    \"info\": \"{\\\"Type\\\":\\\"出库\\\",\\\"SubType\\\":\\\"零售\\\"," +
                "\\\"DefaultNumber\\\":\\\"" +
                "LSCK00000000714" +
                "\\\",\\\"Number\\\":\\\"" +
                "LSCK00000000714" +
                "\\\",\\\"batchNumber\\\":\\\"\\\",\\\"LinkNumber\\\":\\\"\\\",\\\"OperTime\\\":\\\"2020-06-23 11:29:18\\\",\\\"OrganId\\\":\\\"81\\\",\\\"HandsPersonId\\\":\\\"\\\",\\\"Salesman\\\":\\\"<19>\\\",\\\"AccountId\\\":\\\"20\\\",\\\"ChangeAmount\\\":1," +

                "\\\"TotalPrice\\\":\\\"" +
                "1.00" +
                "\\\",\\\"PayType\\\":\\\"" +
                "现付" +
                "\\\",\\\"Remark\\\":\\\"\\\",\\\"AccountMoneyList\\\":\\\"\\\",\\\"Discount\\\":\\\"\\\",\\\"DiscountMoney\\\":\\\"\\\",\\\"DiscountLastMoney\\\":\\\"\\\",\\\"OtherMoney\\\":\\\"\\\"}\",\n" +
                "    " +
                "\"inserted\": \"" +



                "[" +
                //list数组中存放多个这种对象，至于这个对象怎么组成  在具体的java代码中进行实现
                "{" +
                "\\\"DepotId\\\":\\\"" +
                "19" +
                "\\\",\\\"DepotName\\\":\\\"" +
                "华中生鲜冷链1仓库" +
                "\\\",\\\"MaterialName\\\":\\\"" +
                "1001_ 大白菜(本地)(千克)" +
                "\\\",\\\"batchNumber\\\":\\\"" +
                "20200614212648" +
                "\\\",\\\"MType\\\":\\\"\\\",\\\"newBarCode\\\":\\\"1000-20200614212648\\\",\\\"MaterialExtendId\\\":\\\"22\\\",\\\"Stock\\\":\\\"8\\\",\\\"AnotherDepotId\\\":\\\"\\\"," +
                "\\\"Unit\\\":\\\"" +
                "千克" +
                "\\\",\\\"OperNumber\\\":\\\"1\\\"," +
                "\\\"UnitPrice\\\":\\\"" +
                "1" +
                "\\\",\\\"TaxUnitPrice\\\":\\\"1.00\\\"," +
                "\\\"AllPrice\\\":\\\"" +
                "1" +
                "\\\",\\\"TaxRate\\\":\\\"0\\\",\\\"TaxMoney\\\":\\\"0.00\\\"," +
                "\\\"TaxLastMoney\\\":\\\"1.00\\\",\\\"Remark\\\":\\\"\\\"" +
                "}"

                +
                "]"

                +

                "\",\n" +

                "    \"deleted\": \"[]\",\n" +
                "    \"updated\": \"[]\"\n" +
                "}";
        return s;
    }


}