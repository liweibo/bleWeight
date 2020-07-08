package net.pojo;

import java.util.List;

public class ProdOfPici {

    /**
     * code : 200
     * data : {"total":1,"rows":[{"TaxMoney":0,"tenant_id":144,"new_bar_code":"1000-20200614212648","MaterialId":592,"OperNumber":250,"MType":"","batch_number":"20200614212648","HeaderId":275,"TaxUnitPrice":30,"delete_Flag":"0","TaxLastMoney":7500,"Name":"雪花牛肉","material_extend_id":21,"Remark":"来自订单","DepotId":19,"UnitPrice":30,"MUnit":"千克","TaxRate":0,"Id":322,"AllPrice":7500,"BasicNumber":250}]}
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
         * total : 1
         * rows : [{"TaxMoney":0,"tenant_id":144,"new_bar_code":"1000-20200614212648","MaterialId":592,"OperNumber":250,"MType":"","batch_number":"20200614212648","HeaderId":275,"TaxUnitPrice":30,"delete_Flag":"0","TaxLastMoney":7500,"Name":"雪花牛肉","material_extend_id":21,"Remark":"来自订单","DepotId":19,"UnitPrice":30,"MUnit":"千克","TaxRate":0,"Id":322,"AllPrice":7500,"BasicNumber":250}]
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
             * TaxMoney : 0
             * tenant_id : 144
             * new_bar_code : 1000-20200614212648
             * MaterialId : 592
             * OperNumber : 250
             * MType :
             * batch_number : 20200614212648
             * HeaderId : 275
             * TaxUnitPrice : 30
             * delete_Flag : 0
             * TaxLastMoney : 7500
             * Name : 雪花牛肉
             * material_extend_id : 21
             * Remark : 来自订单
             * DepotId : 19
             * UnitPrice : 30
             * MUnit : 千克
             * TaxRate : 0
             * Id : 322
             * AllPrice : 7500
             * BasicNumber : 250
             */

            private double TaxMoney;
            private double tenant_id;
            private String new_bar_code;
            private double MaterialId;
            private double OperNumber;
            private String MType;
            private String batch_number;
            private double HeaderId;
            private double TaxUnitPrice;
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

            public double getTaxUnitPrice() {
                return TaxUnitPrice;
            }

            public void setTaxUnitPrice(double TaxUnitPrice) {
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
