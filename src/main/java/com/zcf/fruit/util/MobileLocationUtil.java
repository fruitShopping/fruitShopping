package com.zcf.fruit.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.lexer.Page;
import org.htmlparser.util.DefaultParserFeedback;
import org.htmlparser.util.NodeList;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
/**
 * Created by zcf on 2015/5/6.
 */
public class MobileLocationUtil {
    /**
     * 归属地查询
     * @param mobile
     * @return mobileAddress
     */
    @SuppressWarnings("unused")
    private static String getLocationByMobile(final String mobile) throws ParserConfigurationException, SAXException, IOException{
        String MOBILEURL = " http://www.youdao.com/smartresult-xml/search.s?type=mobile&q=";
        String result = callUrlByGet(MOBILEURL + mobile, "GBK");
        StringReader stringReader = new StringReader(result);
        InputSource inputSource = new InputSource(stringReader);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputSource);

        if (!(document.getElementsByTagName("location").item(0) == null)) {
            return document.getElementsByTagName("location").item(0).getFirstChild().getNodeValue();
        }else{
            return "无此号记录！";
        }
    }
    /**
     * 获取URL返回的字符串
     * @param callurl
     * @param charset
     * @return
     */
    private static String callUrlByGet(String callurl,String charset){
        String result = "";
        try {
            URL url = new URL(callurl);
            URLConnection connection = url.openConnection();
            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));
            String line;
            while((line = reader.readLine())!= null){
                result += line;
                result += "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }
    /**
     * 手机号码归属地
     * @param tel  手机号码
     * @return 135XXXXXXXX,湖北武汉-联通/移动/电信
     * @throws Exception
     * @author
     */
    public static String getMobileLocation(String tel) throws Exception{
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(tel);
        if(matcher.matches()){
            try {
                String url = "http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile=" + tel;
                String result = callUrlByGet(url, "GBK");
                StringReader stringReader = new StringReader(result);
                InputSource inputSource = new InputSource(stringReader);
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(inputSource);
                String retmsg = document.getElementsByTagName("retmsg").item(0).getFirstChild().getNodeValue();
                if (retmsg.equals("OK")) {
                    String supplier = document.getElementsByTagName("supplier").item(0).getFirstChild().getNodeValue().trim();
                    String province = document.getElementsByTagName("province").item(0).getFirstChild().getNodeValue().trim();
                    String city = document.getElementsByTagName("city").item(0).getFirstChild().getNodeValue().trim();
                    if (province.equals("-") || city.equals("-")) {

//                    return (tel + "," + supplier + ","+ getLocationByMobile(tel));
                        return (getLocationByMobile(tel) + "-" + supplier);
//                    return getLocationByMobile(tel);
                    } else {

//                    return (tel + "," + supplier + ","+ province + city);
                        return (province + city + "-" + supplier);
//                    return (province + city);
                    }

                } else {

                    return "无此号记录！";

                }
            }catch (Exception e){
                e.printStackTrace();
                return "";
            }

        }else{

            return tel+ "：手机号码格式错误！";

        }

    }


    public static String getPostString(String mobile) throws Exception
    {
        HttpClient hc=new HttpClient();
        PostMethod pm=new PostMethod("http://www.ip138.com:8080/search.asp");
        hc.getParams().setContentCharset("gb2312");
        pm.addParameter("mobile",mobile);
        pm.addParameter("action","mobile");
        hc.executeMethod(pm);

        return pm.getResponseBodyAsString();
    }
    public static String getMobileInfor(String postString) throws Exception
    {
        Parser parser=createParser(postString);
        NodeList nodelist=null;
        NodeFilter filter=new HasAttributeFilter("class","tdc2");
        nodelist=parser.extractAllNodesThatMatch(filter);
        String locaString = nodelist.elementAt(1).toPlainTextString();
        locaString = locaString.replace("&nbsp;","");
        locaString = locaString.replace("<td></td>", "");
        locaString = locaString.trim();
        String location = locaString.substring(0,4);
        String typeString = nodelist.elementAt(2).toPlainTextString();
        typeString = typeString.replace("&nbsp;","");
        typeString = typeString.replace("<td></td>", "");
        typeString = typeString.trim();
        String type = typeString.substring(0,2);
        String mobileLocation = location+"-"+type;
        System.out.println(mobileLocation);
        for(int i=0;i<nodelist.size();i++)
        {
            System.out.println(nodelist.elementAt(i).toPlainTextString().replace("&nbsp;",""));
        }
        return mobileLocation;
    }

    public static String getMobileAddress(String mobile) throws Exception
    {
        String address = "";
        try
        {
            mobile = mobile.trim();
            if (mobile.matches("^(13|15|18)\\d{9}$") || mobile.matches("^(013|015|018)\\d{9}$")) //以13，15，18开头，后面九位全为数字
            {
                String url = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + mobile;
                URLConnection connection = (URLConnection) new URL(url).openConnection();
                connection.setDoOutput(true);
                InputStream os = connection.getInputStream();
                Thread.sleep(10);
                int length = os.available();
                byte[] buff = new byte[length];
                os.read(buff);
                String s = new String(buff, "gbk");
                int len = s.indexOf("卡号归属地");
                s = s.substring(len, len+100);
                len = s.lastIndexOf("</TD>");
                address = s.substring(0, len);
                len = address.lastIndexOf(">");
                address = address.substring(len+1, address.length()-1);
                address = address.replace("&nbsp;", "");
                address = address.replace("d> -->", "");
                address = address.replace(" -->", "");
                address = address.replace("-->", "");
                s = null;
                buff = null;
                os.close();
                connection = null;
            }
        }
        catch(Exception e)
        {
            address = "未知";
            System.out.println("手机所属地查询失败====================");
        }
        return address;
    }

    public static org.htmlparser.Parser createParser(String inputHTML) {
        Lexer mLexer = new Lexer(new Page(inputHTML));
        return new org.htmlparser.Parser(mLexer,
                new DefaultParserFeedback(DefaultParserFeedback.QUIET));
    }

    public static void main(String[] args) {
        try {
            System.out.println(MobileLocationUtil.getMobileLocation("15090786057"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
