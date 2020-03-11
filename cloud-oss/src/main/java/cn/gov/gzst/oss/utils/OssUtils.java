package cn.gov.gzst.oss.utils;

import org.apache.tika.Tika;

/**
 * @version V1.0
 * @description: OSS 工具类
 * @author: jianliaoliang
 */
public class OssUtils {
    public static String getContentType(byte[] file){
        try {
            //Instantiating tika facade class
            Tika tika = new Tika();
            //detecting the file type using detect method
            String filetype = tika.detect(file);
            return filetype;
        }catch (Exception e){

        }
        return "";
    }
}
