package com.zcf.fruit.common.file;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 文件上传工具类
 * Created by zcf on 2016/9/25.
 */
public class FileUpload {
    /*
     *采用spring提供的上传文件的方法
     */
    public static String springUpload(HttpServletRequest request, String filePath) throws IllegalStateException, IOException
    {
        String imgURL = "";
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file != null && file.getSize() > 0)
                {
                    String realPath = request.getSession().getServletContext().getRealPath("/") + filePath;
//                    String fileName = file.getOriginalFilename();
                    String fileName = FileNameUtils.genFileName("png");
                    String path = realPath + fileName;
                    imgURL = imgURL + filePath + fileName + ",";
                    System.out.println(path);
                    //上传
                    File file2 = new File(realPath);
                    //如果文件夹不存在则创建
                    if  (!file2 .exists()  && !file2 .isDirectory())
                    {
                        System.out.println("//不存在");
                        file2 .mkdir();
                    } else
                    {
                        System.out.println("//目录存在");
                    }
                    file.transferTo(new File(path));
                }
            }
        }
        if(imgURL.length() > 0){
            imgURL = imgURL.substring(0,imgURL.length()-1);
        }
        System.out.println(imgURL);
        return imgURL;
    }

    /**
     * 文件删除
     * @param request 请求
     * @param filePath 文件路径
     */
    public static void fileDelete(HttpServletRequest request, String filePath){
        String realPath = request.getSession().getServletContext().getRealPath("/") + filePath;
        File f = new File(realPath);
        f.delete();
    }
}
