package net.pojo;

import java.util.List;

public class PiCiType {

    /**
     * code : 200
     * data : {"total":3,"rows":["20200626111922","20200626111806","20200614212648"]}
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
         * total : 3
         * rows : ["20200626111922","20200626111806","20200614212648"]
         */

        private int total;
        private List<String> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<String> getRows() {
            return rows;
        }

        public void setRows(List<String> rows) {
            this.rows = rows;
        }
    }
}
