package net.pojo;

public class LoginPojo {

    /**
     * code : 200
     * data : {"user":{"id":144,"username":"18672332925","loginName":"18672332925","password":"e10adc3949ba59abbe56e057f20f883e","position":null,"department":null,"email":null,"phonenum":null,"ismanager":1,"isystem":0,"status":0,"description":null,"remark":null,"tenantId":144},"msgTip":"user can login","token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNDQiLCJpYXQiOjE1OTMwMTE1OTUsImV4cCI6MTc1MDc5OTU5NX0.92QDADm9sjRmldRWWp01D--DzvV3ooJ9N7NZ47I7D_HqIgFew-oLu-GuZUK5XObPjpDbpnYHefHng_VlNuEDAg"}
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
         * user : {"id":144,"username":"18672332925","loginName":"18672332925","password":"e10adc3949ba59abbe56e057f20f883e","position":null,"department":null,"email":null,"phonenum":null,"ismanager":1,"isystem":0,"status":0,"description":null,"remark":null,"tenantId":144}
         * msgTip : user can login
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxNDQiLCJpYXQiOjE1OTMwMTE1OTUsImV4cCI6MTc1MDc5OTU5NX0.92QDADm9sjRmldRWWp01D--DzvV3ooJ9N7NZ47I7D_HqIgFew-oLu-GuZUK5XObPjpDbpnYHefHng_VlNuEDAg
         */

        private UserBean user;
        private String msgTip;
        private String token;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getMsgTip() {
            return msgTip;
        }

        public void setMsgTip(String msgTip) {
            this.msgTip = msgTip;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserBean {
            /**
             * id : 144
             * username : 18672332925
             * loginName : 18672332925
             * password : e10adc3949ba59abbe56e057f20f883e
             * position : null
             * department : null
             * email : null
             * phonenum : null
             * ismanager : 1
             * isystem : 0
             * status : 0
             * description : null
             * remark : null
             * tenantId : 144
             */

            private int id;
            private String username;
            private String loginName;
            private String password;
            private Object position;
            private Object department;
            private Object email;
            private Object phonenum;
            private int ismanager;
            private int isystem;
            private int status;
            private Object description;
            private Object remark;
            private int tenantId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getPosition() {
                return position;
            }

            public void setPosition(Object position) {
                this.position = position;
            }

            public Object getDepartment() {
                return department;
            }

            public void setDepartment(Object department) {
                this.department = department;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getPhonenum() {
                return phonenum;
            }

            public void setPhonenum(Object phonenum) {
                this.phonenum = phonenum;
            }

            public int getIsmanager() {
                return ismanager;
            }

            public void setIsmanager(int ismanager) {
                this.ismanager = ismanager;
            }

            public int getIsystem() {
                return isystem;
            }

            public void setIsystem(int isystem) {
                this.isystem = isystem;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public int getTenantId() {
                return tenantId;
            }

            public void setTenantId(int tenantId) {
                this.tenantId = tenantId;
            }
        }
    }
}
