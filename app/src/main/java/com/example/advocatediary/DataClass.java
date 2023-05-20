package com.example.advocatediary;

public class DataClass {
    private String datacaseNo;
    private String dataclientName;
    private String dataoppName;
    private String datafilingDate;
    private String datacaseType;
    private String datajudgeName;
    private String dataareaCase;
    private String datachargeAmount;
    private String dataImage;
    private String key;


    public String getDatacaseNo(){return datacaseNo;}
    public String getDataclientName(){return dataclientName;}
    public String getDataoppName(){return dataoppName;}
    public String getDatafilingDate(){return datafilingDate;}
    public String getDatacaseType(){return datacaseType;}
    public String getDatajudgeName(){return datajudgeName;}
    public String getDataareaCase(){return dataareaCase;}
    public String getDatachargeAmount(){return datachargeAmount;}
    public String getDataImage(){return dataImage;}
    public String getkey(){return key;}

    public DataClass(String datacaseNo, String dataclientName, String dataoppName, String dataImage, String datafilingDate, String datacaseType, String datajudgeName, String dataareaCase, String datachargeAmount) {
        this.datacaseNo = datacaseNo;
        this.dataclientName = dataclientName;
        this.dataoppName = dataoppName;
        this.datafilingDate = datafilingDate;
        this.datacaseType = datacaseType;
        this.datajudgeName = datajudgeName;
        this.dataareaCase = dataareaCase;
        this.datachargeAmount = datachargeAmount;
        this.dataImage = dataImage;
    }
    public DataClass(){

    }

    public void setDatacaseNo(String datacaseNo) {
        this.datacaseNo = datacaseNo;
    }

    public void setDataclientName(String dataclientName) {
        this.dataclientName = dataclientName;
    }

    public void setDataoppName(String dataoppName) {
        this.dataoppName = dataoppName;
    }

    public void setDatafilingDate(String datafilingDate) {
        this.datafilingDate = datafilingDate;
    }

    public void setDatacaseType(String datacaseType) {
        this.datacaseType = datacaseType;
    }

    public void setDatajudgeName(String datajudgeName) {
        this.datajudgeName = datajudgeName;
    }

    public void setDataareaCase(String dataareaCase) {
        this.dataareaCase = dataareaCase;
    }

    public void setDatachargeAmount(String datachargeAmount) {
        this.datachargeAmount = datachargeAmount;
    }

    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
