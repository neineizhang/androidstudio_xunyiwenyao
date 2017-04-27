package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.util.HttpHelper;
import com.zll.xunyiwenyao.util.JsonHelper;
import com.zll.xunyiwenyao.webitem.ResponseItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kejund on 17/4/20.
 */

public class InspectionWebService {
    private static List<Inspection> inspectionList;
    private static List<String> typeList;


    public static void initDB() throws JSONException {
        String url = "http://222.29.100.155/b2b2c/api/mobile/recipe/getInspection.do?";

        String s = HttpHelper.sendGet(url, "");
        Map m = JsonHelper.toMap(s);
        ResponseItem responditem = new  ResponseItem();
        responditem = (ResponseItem) JsonHelper.toJavaBean(responditem, m);
        System.out.println(JsonHelper.toJSON(responditem));
        System.out.println("___________");


        JSONObject jo = new JSONObject(s);
        JSONArray ja = jo.getJSONArray("data");
        System.out.println(ja.length());

        Inspection inspection;
        inspectionList = new ArrayList<Inspection>();
        for(int i = 0; i < ja.length(); i++){
            JSONObject jsonobj = (JSONObject) ja.get(i);
            inspection = new Inspection(jsonobj.getInt("inspection_id"), jsonobj.getString("inspection_name"),
                    jsonobj.getString("inspection_type"), jsonobj.getString("pname"),
                    jsonobj.getInt("psex"),  jsonobj.getInt("page"),
                    jsonobj.getString("history"), jsonobj.getString("location"),
                    jsonobj.getString("create_date_text"), jsonobj.getString("comment"),
                            jsonobj.getInt("status"), jsonobj.getInt("doctor_id"),
                    jsonobj.getString("doctor_name"));
            inspectionList.add(inspection);
            System.out.println("success add:"+JsonHelper.toJSON(inspection));
        }
//        JSONObject jsonobj1 = (JSONObject) ja.get(1);
//        jasonS=jsonobj1.getString("inspection_name");
//        for(int i = 0; i < ja.length(); i++){
//            Inspection inspection = new Inspection();
//            JSONObject jsonobj = (JSONObject) ja.get(i);
//            inspection.setInspectionName(jsonobj.getString("inspection_name"));
//            inspection.setType(jsonobj.getString("inspection_type"));
//            inspection.setInspectionLocation(jsonobj.getString("location"));
//            inspection.setPatientSex(jsonobj.getInt("psex"));
//
//            inspectionList.add(inspection);
//            System.out.println("success add:"+JsonHelper.toJSON(inspection));
//        }

        //获取检查单的所有类别
        String listURL = "http://222.29.100.155/b2b2c/api/mobile/recipe/listAllInspectionType.do?";

        typeList = new ArrayList<String>();
        s = HttpHelper.sendGet(listURL, "");
        m = JsonHelper.toMap(s);
        responditem = new  ResponseItem();
        responditem = (ResponseItem) JsonHelper.toJavaBean(responditem, m);
        System.out.println(JsonHelper.toJSON(responditem));
        System.out.println("___________");


        jo = new JSONObject(s);
        ja = jo.getJSONArray("data");
        System.out.println(ja.length());

        for(int i = 0; i < ja.length(); i++){
            JSONObject jsonobj = (JSONObject) ja.get(i);
            typeList.add(jsonobj.getString("type_name"));
//            arrs_type[i]=jsonobj.getString("type_name");
            System.out.println("success add:"+jsonobj.getString("type_name"));
        }


    }
    public static void main(String[] args) {
        try {
            InspectionWebService.initDB();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<Inspection> getAllInspection() {return inspectionList;};

    public static void addInspection(Inspection item){

        inspectionList.add(item);
//        String url = "http://222.29.100.155/b2b2c/api/mobile/recipe/addInspection.do?";

//        String s = HttpHelper.sendGet(url, item); 如何生成jsonString
    }

    public static void updateInspection ( Inspection inspection){}

    public static void deleteInspection (Inspection inspection){}

    public static void updateInspectionByPosition(int position,Inspection item){
        inspectionList.set(position,item);
    }
    public static void deleteInspectionByPosition(int position){
        inspectionList.remove(position);
    }

    public static String[] listAllInspectionType(){
        String[] arrs_type =  new String[typeList.size()];
        typeList.toArray(arrs_type);
        return arrs_type;
    }

}
