package com.example.image_scanning.bean;

import java.util.List;

public class AddScanDataRequestBean {
    private List<ReqBody> input;

    public List<ReqBody> getInput() {
        return input;
    }

    public void setInput(List<ReqBody> input) {
        this.input = input;
    }

    public class ReqBody {
        private String waybill ;
        private String s3path ;
        private String validation_result ;
        private String validation_type ;
        private String created_date ;
        private String created_time ;
        private String sync_date ;
        private String sync_time ;
        private String validation_output ;

        public String getWaybill() {
            return waybill;
        }

        public void setWaybill(String waybill) {
            this.waybill = waybill;
        }

        public String getS3path() {
            return s3path;
        }

        public void setS3path(String s3path) {
            this.s3path = s3path;
        }

        public String getValidation_result() {
            return validation_result;
        }

        public void setValidation_result(String validation_result) {
            this.validation_result = validation_result;
        }

        public String getValidation_type() {
            return validation_type;
        }

        public void setValidation_type(String validation_type) {
            this.validation_type = validation_type;
        }

        public String getCreated_date() {
            return created_date;
        }

        public void setCreated_date(String created_date) {
            this.created_date = created_date;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getSync_date() {
            return sync_date;
        }

        public void setSync_date(String sync_date) {
            this.sync_date = sync_date;
        }

        public String getSync_time() {
            return sync_time;
        }

        public void setSync_time(String sync_time) {
            this.sync_time = sync_time;
        }

        public String getValidation_output() {
            return validation_output;
        }

        public void setValidation_output(String validation_output) {
            this.validation_output = validation_output;
        }
    }


}
