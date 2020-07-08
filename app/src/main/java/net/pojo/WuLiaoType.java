package net.pojo;

import java.util.List;

public class WuLiaoType {

    /**
     * code : 200
     * data : [{"id":33,"name":"鱼肉生鲜","categorylevel":null,"parentid":-1,"sort":"0","status":"1","serialNo":"001","remark":"","createTime":"2020-06-14T13:07:20.000+0000","creator":144,"updateTime":"2020-06-14T13:07:20.000+0000","updater":144,"tenantId":144},{"id":34,"name":"果蔬","categorylevel":null,"parentid":-1,"sort":"1","status":"1","serialNo":"002","remark":"","createTime":"2020-06-14T13:07:35.000+0000","creator":144,"updateTime":"2020-06-14T13:07:35.000+0000","updater":144,"tenantId":144},{"id":35,"name":"海鲜","categorylevel":null,"parentid":-1,"sort":"3","status":"1","serialNo":"003","remark":"","createTime":"2020-06-26T02:58:08.000+0000","creator":144,"updateTime":"2020-06-26T02:58:08.000+0000","updater":144,"tenantId":144},{"id":36,"name":"进口水果","categorylevel":null,"parentid":-1,"sort":"4","status":"1","serialNo":"004","remark":"","createTime":"2020-06-26T02:58:25.000+0000","creator":144,"updateTime":"2020-06-26T02:58:25.000+0000","updater":144,"tenantId":144},{"id":37,"name":"干果","categorylevel":null,"parentid":-1,"sort":"5","status":"1","serialNo":"005","remark":"","createTime":"2020-06-26T02:58:46.000+0000","creator":144,"updateTime":"2020-06-26T02:58:46.000+0000","updater":144,"tenantId":144},{"id":38,"name":"龙虾类","categorylevel":null,"parentid":-1,"sort":"6","status":"1","serialNo":"006","remark":"","createTime":"2020-06-26T03:00:23.000+0000","creator":144,"updateTime":"2020-06-26T03:00:23.000+0000","updater":144,"tenantId":144}]
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
         * id : 33
         * name : 鱼肉生鲜
         * categorylevel : null
         * parentid : -1
         * sort : 0
         * status : 1
         * serialNo : 001
         * remark :
         * createTime : 2020-06-14T13:07:20.000+0000
         * creator : 144
         * updateTime : 2020-06-14T13:07:20.000+0000
         * updater : 144
         * tenantId : 144
         */

        private int id;
        private String name;
        private Object categorylevel;
        private int parentid;
        private String sort;
        private String status;
        private String serialNo;
        private String remark;
        private String createTime;
        private int creator;
        private String updateTime;
        private int updater;
        private int tenantId;

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

        public Object getCategorylevel() {
            return categorylevel;
        }

        public void setCategorylevel(Object categorylevel) {
            this.categorylevel = categorylevel;
        }

        public int getParentid() {
            return parentid;
        }

        public void setParentid(int parentid) {
            this.parentid = parentid;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getCreator() {
            return creator;
        }

        public void setCreator(int creator) {
            this.creator = creator;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getUpdater() {
            return updater;
        }

        public void setUpdater(int updater) {
            this.updater = updater;
        }

        public int getTenantId() {
            return tenantId;
        }

        public void setTenantId(int tenantId) {
            this.tenantId = tenantId;
        }
    }
}




