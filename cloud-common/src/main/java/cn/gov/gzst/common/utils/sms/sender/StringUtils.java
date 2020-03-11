package cn.gov.gzst.common.utils.sms.sender;

import java.text.MessageFormat;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.common.utils.sms.sender
 * @title:
 * @description: 短信发送的字符处理
 * @author: jianliaoliang
 * @date: 2018/1/16 16:43
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class StringUtils extends cn.gov.gzst.common.utils.StringUtils {
   public static String getSmsContent(String content,String... datas){
       if (datas != null) {
           // 这里需要处理templateId
           Object[] dataArr = new Object[datas.length + 1];
           dataArr[0] = "";
           for (int i = 0; i < datas.length; i++) {
               dataArr[i + 1] = datas[i];
           }
           // 让索引从0开始
           content = MessageFormat.format("{0}" + content, dataArr);
       }
       return content;
   }
}
