package net.pojo;

import java.util.List;

public class ProdOfWuLiao {

    /**
     * code : 200
     * data : {"total":2,"rows":[{"TaxMoney":135,"tenant_id":144,"new_bar_code":"1004-20200626111806","MaterialId":596,"OperNumber":1500,"MType":"","batch_number":"20200626111806","HeaderId":283,"TaxUnitPrice":3.09,"delete_Flag":"0","TaxLastMoney":4635,"Name":"山东水晶红富士苹果","material_extend_id":25,"Remark":"来自订单","DepotId":19,"UnitPrice":3,"MUnit":"千克","TaxRate":3,"Id":336,"AllPrice":4500,"BasicNumber":1500},{"TaxMoney":54,"tenant_id":144,"new_bar_code":"1005-20200626111806","MaterialId":597,"OperNumber":2000,"MType":"","batch_number":"20200626111806","HeaderId":283,"TaxUnitPrice":0.93,"delete_Flag":"0","TaxLastMoney":1854,"Name":"胡萝卜","material_extend_id":26,"Remark":"来自订单","DepotId":19,"UnitPrice":0.9,"MUnit":"千克","TaxRate":3,"Id":335,"AllPrice":1800,"BasicNumber":2000}]}
     */

    private double code;
    private DataBean data;

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
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
         * total : 2
         * rows : [{"TaxMoney":135,"tenant_id":144,"new_bar_code":"1004-20200626111806","MaterialId":596,"OperNumber":1500,"MType":"","batch_number":"20200626111806","HeaderId":283,"TaxUnitPrice":3.09,"delete_Flag":"0","TaxLastMoney":4635,"Name":"山东水晶红富士苹果","material_extend_id":25,"Remark":"来自订单","DepotId":19,"UnitPrice":3,"MUnit":"千克","TaxRate":3,"Id":336,"AllPrice":4500,"BasicNumber":1500},{"TaxMoney":54,"tenant_id":144,"new_bar_code":"1005-20200626111806","MaterialId":597,"OperNumber":2000,"MType":"","batch_number":"20200626111806","HeaderId":283,"TaxUnitPrice":0.93,"delete_Flag":"0","TaxLastMoney":1854,"Name":"胡萝卜","material_extend_id":26,"Remark":"来自订单","DepotId":19,"UnitPrice":0.9,"MUnit":"千克","TaxRate":3,"Id":335,"AllPrice":1800,"BasicNumber":2000}]
         */

        private double total;
        private List<RowsBean> rows;

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public List<RowsBean> getRows() {
            return rows;
        }

        public void setRows(List<RowsBean> rows) {
            this.rows = rows;
        }

        public static class RowsBean {
            /**
             * TaxMoney : 135
             * tenant_id : 144
             * new_bar_code : 1004-20200626111806
             * MaterialId : 596
             * OperNumber : 1500
             * MType :
             * batch_number : 20200626111806
             * HeaderId : 283
             * TaxUnitPrice : 3.09
             * delete_Flag : 0
             * TaxLastMoney : 4635
             * Name : 山东水晶红富士苹果
             * material_extend_id : 25
             * Remark : 来自订单
             * DepotId : 19
             * UnitPrice : 3
             * MUnit : 千克
             * TaxRate : 3
             * Id : 336
             * AllPrice : 4500
             * BasicNumber : 1500
             */

            private double TaxMoney;
            private double tenant_id;
            private String new_bar_code;
            private double MaterialId;
            private double OperNumber;
            private String MType;
            private String batch_number;
            private double HeaderId;
            private float TaxUnitPrice;
            private String delete_Flag;
            private double TaxLastMoney;
            private String Name;
            private double material_extend_id;
            private String Remark;
            private double DepotId;
            private double UnitPrice;
            private String MUnit;
            private double TaxRate;
            private double Id;
            private double AllPrice;
            private double BasicNumber;

            public double getTaxMoney() {
                return TaxMoney;
            }

            public void setTaxMoney(double TaxMoney) {
                this.TaxMoney = TaxMoney;
            }

            public double getTenant_id() {
                return tenant_id;
            }

            public void setTenant_id(double tenant_id) {
                this.tenant_id = tenant_id;
            }

            public String getNew_bar_code() {
                return new_bar_code;
            }

            public void setNew_bar_code(String new_bar_code) {
                this.new_bar_code = new_bar_code;
            }

            public double getMaterialId() {
                return MaterialId;
            }

            public void setMaterialId(double MaterialId) {
                this.MaterialId = MaterialId;
            }

            public double getOperNumber() {
                return OperNumber;
            }

            public void setOperNumber(double OperNumber) {
                this.OperNumber = OperNumber;
            }

            public String getMType() {
                return MType;
            }

            public void setMType(String MType) {
                this.MType = MType;
            }

            public String getBatch_number() {
                return batch_number;
            }

            public void setBatch_number(String batch_number) {
                this.batch_number = batch_number;
            }

            public double getHeaderId() {
                return HeaderId;
            }

            public void setHeaderId(double HeaderId) {
                this.HeaderId = HeaderId;
            }

            public float getTaxUnitPrice() {
                return TaxUnitPrice;
            }

            public void setTaxUnitPrice(float TaxUnitPrice) {
                this.TaxUnitPrice = TaxUnitPrice;
            }

            public String getDelete_Flag() {
                return delete_Flag;
            }

            public void setDelete_Flag(String delete_Flag) {
                this.delete_Flag = delete_Flag;
            }

            public double getTaxLastMoney() {
                return TaxLastMoney;
            }

            public void setTaxLastMoney(double TaxLastMoney) {
                this.TaxLastMoney = TaxLastMoney;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public double getMaterial_extend_id() {
                return material_extend_id;
            }

            public void setMaterial_extend_id(double material_extend_id) {
                this.material_extend_id = material_extend_id;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public double getDepotId() {
                return DepotId;
            }

            public void setDepotId(double DepotId) {
                this.DepotId = DepotId;
            }

            public double getUnitPrice() {
                return UnitPrice;
            }

            public void setUnitPrice(double UnitPrice) {
                this.UnitPrice = UnitPrice;
            }

            public String getMUnit() {
                return MUnit;
            }

            public void setMUnit(String MUnit) {
                this.MUnit = MUnit;
            }

            public double getTaxRate() {
                return TaxRate;
            }

            public void setTaxRate(double TaxRate) {
                this.TaxRate = TaxRate;
            }

            public double getId() {
                return Id;
            }

            public void setId(double Id) {
                this.Id = Id;
            }

            public double getAllPrice() {
                return AllPrice;
            }

            public void setAllPrice(double AllPrice) {
                this.AllPrice = AllPrice;
            }

            public double getBasicNumber() {
                return BasicNumber;
            }

            public void setBasicNumber(double BasicNumber) {
                this.BasicNumber = BasicNumber;
            }
        }
    }
}
