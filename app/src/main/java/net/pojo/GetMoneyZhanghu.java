package net.pojo;

import java.util.List;

public class GetMoneyZhanghu {

    /**
     * code : 200
     * data : {"accountList":[{"id":20,"name":"建设银行龙卡","serialno":"010100101010110","initialamount":0,"currentamount":null,"remark":"","isdefault":false,"tenantId":144,"deleteFlag":"0"}]}
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
        private List<AccountListBean> accountList;

        public List<AccountListBean> getAccountList() {
            return accountList;
        }

        public void setAccountList(List<AccountListBean> accountList) {
            this.accountList = accountList;
        }

        public static class AccountListBean {
            /**
             * id : 20
             * name : 建设银行龙卡
             * serialno : 010100101010110
             * initialamount : 0
             * currentamount : null
             * remark :
             * isdefault : false
             * tenantId : 144
             * deleteFlag : 0
             */

            private int id;
            private String name;
            private String serialno;
            private int initialamount;
            private Object currentamount;
            private String remark;
            private boolean isdefault;
            private int tenantId;
            private String deleteFlag;

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

            public String getSerialno() {
                return serialno;
            }

            public void setSerialno(String serialno) {
                this.serialno = serialno;
            }

            public int getInitialamount() {
                return initialamount;
            }

            public void setInitialamount(int initialamount) {
                this.initialamount = initialamount;
            }

            public Object getCurrentamount() {
                return currentamount;
            }

            public void setCurrentamount(Object currentamount) {
                this.currentamount = currentamount;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public boolean isIsdefault() {
                return isdefault;
            }

            public void setIsdefault(boolean isdefault) {
                this.isdefault = isdefault;
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
        }
    }
}
