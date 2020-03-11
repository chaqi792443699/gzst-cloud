package cn.gov.gzst.common.utils;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * PDF转换工具
 *
 * @author jianliaoliang
 * @version 2017-01-19
 */
public class PdfUtil {
    /**
     * 日志对象
     */
    protected static Logger logger = LoggerFactory.getLogger(PdfUtil.class);
    /**
     * 获取license
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = PdfUtil.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ex="+e.toString());
        }
        return result;
    }

    public static void transfer(String src,String dist) {
        // 验证License
        if (getLicense()) {
            logger.info("授权正确！");
        }

        try {
            File file = new File(dist);
            if(!file.exists()) {
                file.createNewFile();
            }
            logger.info("正在转换文档...");
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(src);
            doc.save(os, SaveFormat.PDF);
            os.flush();
            os.close();
            logger.info("转换结束...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
