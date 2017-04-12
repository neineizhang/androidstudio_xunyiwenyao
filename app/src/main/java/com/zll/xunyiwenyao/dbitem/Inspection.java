package com.zll.xunyiwenyao.dbitem;

/**
 * Created by kejund on 17/3/23.
 */



public class Inspection {
    private int id;     //系统自增的唯一id
    private String name;//检查单名称，必填项
    private String type;//检查单类别，枚举类型，目前包括：心电图、X光、B超，以后可以添加
    private String pname;//患者名称，必填项
    private int psex;//患者性别
    private String page;//患者年龄
    private String history;//病史摘要
    private String location;//申请检查部位，必填项
    private String date;//开具日期
    private String comment;//备注信息
    private int state;//状态，未提交，已提交
    private Doctor doctor;//开具检查单的医师，必填项

    public Inspection(){

    };
    public Inspection(String ins_name, String type, String pat_name, int pat_sex, String pat_age,
                      String pat_diag, String ins_text, String ins_date, String ins_comment,
                      int ins_state, Doctor doctor){
        super();
        this.name = ins_name;
        this.type = type;
        this.pname = pat_name;
        this.psex = pat_sex;
        this.page = pat_age;
        this.history = pat_diag;
        this.location = ins_text;
        this.date = ins_date;
        this.comment = ins_comment;
        this.state = ins_state;
        this.doctor = doctor;
    }
    public String getInspectionName() {
        return name;
    }
    public void setInspectionName(String ins_name) {
        this.name = ins_name;
    }

    public String getType(){return type;}
    public void setType(String type){this.type=type;}

    public String getPatientName() {
        return pname;
    }
    public void setPatientName(String pat_name) {
        this.pname = pat_name;
    }

    public int getPatientSex() {
        return psex;
    }
    public void setPatientSex(int sex) {
        this.psex = sex;
    }

    public String getPatientAge() {
        return page;
    }
    public void setPatientAge(String age) {
        this.page = age;
    }

    public String getPatientHistory() {
        return history;
    }
    public void setPatientHistory(String history) {
        this.history = history;
    }

    public String getInspectionLoaction() {
        return location;
    }
    public void setInspectionLocation(String location) {
        this.location = location;
    }

    public String getInspectionDate() {
        return date;
    }
    public void setInspectionDate(String ins_date) {
        this.date = ins_date;
    }

    public String getInspectionComment() {
        return comment;
    }
    public void setInspectionComment(String comment) {
        this.comment = comment;
    }

    public int getInspectionState() {
        return state;
    }
    public void setInspectionState(int state) {
        this.state = state;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
