package cn.gov.gzst.admin.utils;

import cn.gov.gzst.common.utils.FileUtil;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;

import java.io.*;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.common.utils
 * @title:
 * @description: PDF加水印
 * @author: jianliaoliang
 * @date: 2018/6/11 17:10
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class PdfWatermarkUtils {

    /**
     * 给pdf文件添加水印
     * @param sourcePath 要加水印的原pdf文件路径
     * @param targetPath 加了水印后要输出的路径
     * @param markImagePath 水印图片路径
     * @throws Exception
     */
    public static void addPdfDemandMark(String sourcePath,
                                        String targetPath, String markImagePath)  throws IOException, DocumentException {
        byte[] bytes= FileUtil.toByteArray(sourcePath);
        OutputStream outPutStream = FileUtil.openOutputStream(new File(targetPath));
        PdfReader pr = new PdfReader(bytes, "PDF".getBytes());
        // 获取文件页数
        PdfStamper stamp = new PdfStamper(pr, outPutStream);
        PdfContentByte under = stamp.getOverContent(1);
        Image img = Image.getInstance(PdfWatermarkUtils.class.getClassLoader().getResource(markImagePath));// 插入水印
        // 设置图片的显示大小
        img.setAbsolutePosition(420, 730);
        // 设置图片的显示大小
        img.scaleToFit(80, 72);
        under.addImage(img);
        stamp.close();
    }
}
