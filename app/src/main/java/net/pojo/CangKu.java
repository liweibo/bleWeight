package net.pojo;

import java.util.List;

public class CangKu {

    /**
     * code : 200
     * data : [{"id":19,"name":"华中生鲜冷链1仓库","address":"湖北省武汉市汉阳区特一号","warehousing":0.1,"truckage":50,"type":0,"sort":"","remark":"","principal":145,"tenantId":144,"deleteFlag":"0","isDefault":null},{"id":20,"name":"华中果蔬2仓库","address":"武汉市","warehousing":null,"truckage":null,"type":0,"sort":"","remark":"","principal":null,"tenantId":144,"deleteFlag":"0","isDefault":null}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 19
         * name : 华中生鲜冷链1仓库
         * address : 湖北省武汉市汉阳区特一号
         * warehousing : 0.1
         * truckage : 50
         * type : 0
         * sort :
         * remark :
         * principal : 145
         * tenantId : 144
         * deleteFlag : 0
         * isDefault : null
         */

        private int id;
        private String name;
        private String address;
        private double warehousing;
        private int truckage;
        private int type;
        private String sort;
        private String remark;
        private int principal;
        private int tenantId;
        private String deleteFlag;
        private Object isDefault;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getWarehousing() {
            return warehousing;
        }

        public void setWarehousing(double warehousing) {
            this.warehousing = warehousing;
        }

        public int getTruckage() {
            return truckage;
        }

        public void setTruckage(int truckage) {
            this.truckage = truckage;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getPrincipal() {
            return principal;
        }

        public void setPrincipal(int principal) {
            this.principal = principal;
        }

        public int getTenantId() {
            return tenantId;
        }

        public void setTenantId(int tenantId) {
            this.tenantId = tenantId;
        }

        public String getDeleteFlag() {
            return deleteFlag;
        }

        public void setDeleteFlag(String deleteFlag) {
            this.deleteFlag = deleteFlag;
        }

        public Object getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(Object isDefault) {
            this.isDefault = isDefault;
        }
    }
}
