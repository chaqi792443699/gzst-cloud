package cn.gov.gzst.common.aip.recognizer;

import cn.gov.gzst.common.aip.bean.BusinessLicense;
import cn.gov.gzst.common.utils.DateUtils;
import com.baidu.aip.ocr.AipOcr;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.baidu.aip.idcard
 * @title:
 * @description: 营业执照识别
 * @author: jianliaoliang
 * @date: 2018/4/21 18:13
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class BusinessLicenseRecognizer {

    private AipOcr aipOcr;

    public BusinessLicenseRecognizer(AipOcr aipOcr){
        this.aipOcr=aipOcr;
    }

    public BusinessLicense recognizeBusinessLicense(String fileUrl){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        try {
            //从URL中识别
            URL url = new URL(fileUrl);
            byte[] file = IOUtils.toByteArray(url);
            JSONObject jsonObject = aipOcr.businessLicense(file, options);
            BusinessLicense businessLicense=parseBusinessLicense(jsonObject);
            return businessLicense;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BusinessLicense parseBusinessLicense(JSONObject jsonObject)  throws ParseException {
        BusinessLicense businessLicense=new BusinessLicense();
        JSONObject wordsResult=jsonObject.optJSONObject("words_result");
        businessLicense.setName(wordsResult.optJSONObject("单位名称").optString("words"));
        businessLicense.setUnifiedSocialCreditcode(wordsResult.optJSONObject("社会信用代码").optString("words"));
        businessLicense.setRegisterDate(DateUtils.parseDate(wordsResult.optJSONObject("成立日期").optString("words"),"yyyy年MM月dd日"));
        businessLicense.setValidity(wordsResult.optJSONObject("有效期").optString("words"));
        businessLicense.setLegalPerson(wordsResult.optJSONObject("法人").optString("words"));
        return businessLicense;
    }


}
