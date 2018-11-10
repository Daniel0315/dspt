package com.neuedu.utils;

import javax.servlet.http.Part;
import java.io.*;

public class ImgUtils {
    public static String imgHandle(Part part,String servletPath) throws IOException {
        String oldFileName=part.getSubmittedFileName();
        if (!ifImg(oldFileName)){
            return null;
        }
        /**
         * 如果上传文件的文件夹不存在就去创建
         */
        File path=new File(servletPath);
        if (!path.exists()){
            path.mkdir();
        }

        /**
         * 文件上传
         */
        String newFileName=String.valueOf(System.nanoTime())+oldFileName.substring(oldFileName.lastIndexOf("."));
       File file=new File(servletPath,newFileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        InputStream in=part.getInputStream();
        OutputStream out=new FileOutputStream(file);
        BufferedInputStream bis=new BufferedInputStream(in);
        BufferedOutputStream bos=new BufferedOutputStream(out);

        byte []bs=new byte[1024];
        int len=0;
        while ((len=bis.read(bs))!=-1){
            bos.write(bs,0,len);
        }

        bos.flush();
        bos.close();
        out.close();
        bis.close();
        in.close();

        return newFileName;
    }

    /**
     * 判断文件是否是图片
     * @param oldFileName
     * @return
     */
    public static Boolean ifImg(String oldFileName){
        if (oldFileName.lastIndexOf(".")>-1){
            //判断扩展名是否是图片类型
            String extension=oldFileName.substring(oldFileName.lastIndexOf("."));
            if (".jpg|.png|.svg|.gif|.gpeg".indexOf(extension)<=-1){
                return false;
            }
        }else {
            return false;
        }
        return true;
    }
}
