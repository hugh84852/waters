package com.example.myapplication;
import java.util.List;
public class memberlst {
    /**
     * records : [{"id":"rec1iX2guzJjKOAMh","fields":{"sto_id":["rechLovrtmc63vJ8I"],"cat_id":["rec0DdBrLDS2mJr04","rechhKasnfYTL17tj","recRcXsiI2FI7XS2Q","rec5tMXxS0A6KpCNs"],"com_id":["recgQCCP3v6nYZtKA"],"c_id":"recqJMUCabrFaOsUX","member_gender":"男","member_name":"簡豪廷","shopcar":"13","sell_to_change":["recuBxNamRf9P8jZy","recIzX0H2I4aGfBOR"],"member_phone":"0912345678","member_password":"12345"},"createdTime":"2019-05-14T02:05:09.000Z"},{"id":"reckaxjrW2pXV4tXv","fields":{"as_seller_evaluation":["recbvR0hjNXtaj5x7"],"normalshop_shopcar":"2","member_account":"406401234","member_gender":"男","member_name":"土豆","sell_to_change":["recsoNFlahYPIl1QC"],"member_phone":"0945678912","member_password":"12345"},"createdTime":"2019-05-14T02:05:09.000Z"},{"id":"recqclcZ8ucw4DUqE","fields":{"normalshop_shopcar":"1, 3, 2","order":["recCMVzr59JGBlyK6","recraVpEvrDma8MqK"],"as_buyer_evaluation":["recILiay5NLCHPoC8","recW0bDSHdD6whOR4"],"member_account":"406401238","member_gender":"女","member_name":"黃千祐","member_phone":"0911456788","member_password":"12345"},"createdTime":"2019-05-14T02:05:09.000Z"}]
     * offset : recqclcZ8ucw4DUqE
     */

    private String offset;
    private List<RecordsBean> records;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {


        private String id;
        private FieldsBean fields;
        private String createdTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public FieldsBean getFields() {
            return fields;
        }

        public void setFields(FieldsBean fields) {
            this.fields = fields;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public static class FieldsBean {


            private String member_account;
            private String member_name;


            public String getMember_account() {
                return member_account;
            }

            public void setMember_account(String member_account) {
                this.member_account = member_account;
            }


            public String getMember_name() {
                return member_name;
            }

            public void setMember_name(String member_name) {
                this.member_name = member_name;
            }


        }
    }
}
