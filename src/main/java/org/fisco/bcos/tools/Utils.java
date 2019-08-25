package org.fisco.bcos.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static String find_contract(int ledgerId) {
        return "";
    }

    public static String find_product_contract(int productId) {
        return "";
    }

    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject readJsonObject(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            JSONObject jsondata = JSON.parseObject(jsonStr);
            return jsondata;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray readJsonArray(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            JSONArray jsondata = JSON.parseArray(jsonStr);
            return jsondata;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean writeJsonFile(String filePath, String sets) {
        JSONObject object = new JSONObject();
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out = new PrintWriter(fw);
            out.write(sets);
            out.println();
            fw.close();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public static void main(String[] args) throws IOException {
//        testJson();
//        readJson("/home/xcrab/projects/FinTechathon/src/main/webapp/data_base/order.json");
        String test = readJsonFile("/home/xcrab/projects/FinTechathon/src/main/webapp/data_base/order.json");

//        JSONArray jsondata = JSON.parseArray(test);

//        JSONArray jsondata = Utils.readJsonArray("/home/xcrab/projects/FinTechathon/src/main/webapp/data_base/order.json");
//        JSONObject jsondata = Utils.readJsonObject("/home/xcrab/projects/FinTechathon/src/main/resources/data/account.json");
//        List<String> ar = JSON.parseArray(jsondata.getJSONArray("Account").toJSONString(), String.class);
//
//        int len = ar.size();
//
//        ArrayList<String> account = new ArrayList();
//
//        for (int i = 0; i < len; i++) {
//            account.add(ar.get(i));
//        }
//
//        account.add("test1");
//        account.add("test2");
//
//        JSONObject newObject = new JSONObject();
//
//        newObject.put("Account", account);
//
//        String output = newObject.toJSONString();
//
//        Utils.writeJsonFile("/home/xcrab/projects/FinTechathon/src/main/resources/data/account.json", output);
//
//        System.out.println(ar);
        JSONObject p2pOrderNumber = Utils.readJsonObject("/home/xcrab/projects/FinTechathon/src/main/resources/data/p2p_order_number.json");
        int no = p2pOrderNumber.getIntValue("p2p_order_number");
        System.out.println(no);
    }

}
