package com.microCredit.sms.util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.List;

/**
 * Created by zcf on 2015/4/30.
 */
public class Test {

    public static String URL = "http://AXXXX.api2.ofpay.com/onlineorder.do";

    public static void main(String[] args)throws Exception
    {
//       String userid = Constants.USER_ID;
//       String userpws = md5Encode(Constants.USERPWS).toLowerCase();
//       String cardid = Constants.FAST_CARD_ID;
//        String cardnum = "1";
//        String mctype = "";
//        String sporder_id = "20151127211625001";
//        String sporder_time = "20151127211625";
//        String game_userid = "18827414104";//13907132763
//        String version = Constants.VERSION;
//        String KeyStr = "OFCARD";
////        包体=userid+userpws+cardid+cardnum+sporder_id+sporder_time+ game_userid
//        String bodyString = userid+userpws+cardid+cardnum+sporder_id+sporder_time+ game_userid+ KeyStr;
//        String md5String = md5Encode(bodyString);
//        String md5_str = md5String.toUpperCase();
//
//        String ret_url = "";
//        String requestContext = "userid="+userid+"&userpws="+userpws+"&cardid="+cardid+"" +
//                "&cardnum="+cardnum+"&sporder_id="+sporder_id+"&sporder_time="+sporder_time+"&game_userid="+game_userid+""+
//                "&md5_str="+md5_str+"&version="+version+"&ret_url="+ret_url+"&mctype="+mctype;
//        System.out.println(requestContext);
//        String responseString = sendRequest(requestContext);
//        System.out.println(responseString);

//        DuXMLDoc doc = new DuXMLDoc();
//        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
//                "<orderinfo>" +
//                "  <err_msg/>" +
//                "  <retcode>1</retcode>" +
//                "  <orderid>S1511275432822</orderid>" +
//                "  <cardid>141611</cardid>" +
//                "  <cardnum>1</cardnum>" +
//                "  <ordercash>1.54</ordercash>" +
//                "  <cardname>湖北移动话费1元直充</cardname>" +
//                "  <sporder_id>20151127211625001</sporder_id>" +
//                "  <game_userid>18827414104</game_userid>" +
//                "  <game_state>0</game_state>" +
//                "</orderinfo>";
//        try {
//            xmlElements(xml);
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//        }

        String mobileRechargeURL = "http://axxxx.api2.ofpay.com/onlineorder.do?";
        System.out.println(mobileRechargeURL.substring(0,mobileRechargeURL.indexOf("?")));
    }

    public static List xmlElements(String xmlDoc) {
        //创建一个新的字符串
        StringReader read = new StringReader(xmlDoc);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
            System.out.println(root.getName());//输出根元素的名称（测试）
            //得到根元素所有子元素的集合
            List jiedian = root.getChildren();
            //获得XML中的命名空间（XML中未定义可不写）
            Namespace ns = root.getNamespace();

            System.out.println(root.getChild("err_msg",ns).getText());
            System.out.println(root.getChild("retcode",ns).getText());
        } catch (JDOMException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
        return null;
    }

    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String sendRequest(String requestContext){
        try{
            URL = URL+"?"+requestContext;
            System.out.println("sendRequest request:" + URL);
//            byte[] sendData = requestContext.getBytes();

            java.net.URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(1000000);
            // 如果通过post提交数据，必须设置允许对外输出数据

            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "text/xml");
            conn.setRequestProperty("Charset", "GBK");
//            conn.setRequestProperty("Content-Length", String.valueOf(sendData.length));
            OutputStream outStream = conn.getOutputStream();
//            outStream.write(sendData);
            outStream.flush();
            outStream.close();
            System.out.println("sendRequest getResponseCode:" + conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                // 获得服务器响应的数据
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));
                // 返回的数据
                String retData = null;
                String responseData = "";
                while ((retData = in.readLine()) != null) {
                    responseData += retData;
                }
                in.close();
                System.out.println("sendRequest responseData" +responseData);

                return responseData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
