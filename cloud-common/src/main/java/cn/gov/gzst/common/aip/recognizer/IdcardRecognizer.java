package cn.gov.gzst.common.aip.recognizer;

import cn.gov.gzst.common.aip.bean.IdcardBack;
import cn.gov.gzst.common.aip.bean.IdcardFront;
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
 * @description: 身份证识别
 * @author: jianliaoliang
 * @date: 2018/4/21 18:13
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class IdcardRecognizer {

    private AipOcr aipOcr;

    public IdcardRecognizer(AipOcr aipOcr){
        this.aipOcr=aipOcr;
    }

    public IdcardFront recognizeIdcardFront(String fileUrl){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");
        String idCardSide = "front";
        try {
           //从URL中识别
            URL url = new URL(fileUrl);
            byte[] file = IOUtils.toByteArray(url);
            JSONObject jsonObject = aipOcr.idcard(file, idCardSide, options);
            IdcardFront idcardFront=parseIdcardFront(jsonObject);
            return idcardFront;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public IdcardBack recognizeIdcardBack(String fileUrl){
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");
        String idCardSide = "back";
        try {
            //从URL中识别
            URL url = new URL(fileUrl);
            byte[] file = IOUtils.toByteArray(url);
            JSONObject jsonObject = aipOcr.idcard(file, idCardSide, options);
            IdcardBack idcardBack=parseIdcardBack(jsonObject);
            return idcardBack;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public IdcardBack parseIdcardBack(JSONObject jsonObject)  throws ParseException {
        IdcardBack idcardBack=new IdcardBack();
        JSONObject wordsResult=jsonObject.optJSONObject("words_result");
        idcardBack.setIssuingAuthority(wordsResult.optJSONObject("签发机关").optString("words"));
        idcardBack.setUsefulLifeBegin(DateUtils.parseDate(wordsResult.optJSONObject("失效日期").optString("words"),"yyyyMMdd"));
        idcardBack.setUsefulLifeEnd(DateUtils.parseDate(wordsResult.optJSONObject("签发日期").optString("words"),"yyyyMMdd"));
        return idcardBack;
    }

    public IdcardFront parseIdcardFront(JSONObject jsonObject) throws ParseException {
        IdcardFront idcardFront=new IdcardFront();
        JSONObject wordsResult=jsonObject.optJSONObject("words_result");
        idcardFront.setAddress(wordsResult.optJSONObject("住址").optString("words"));
        idcardFront.setIdcard(wordsResult.optJSONObject("公民身份号码").optString("words"));
        idcardFront.setBirthdate(DateUtils.parseDate(wordsResult.optJSONObject("出生").optString("words"),"yyyyMMdd"));
        idcardFront.setName(wordsResult.optJSONObject("姓名").optString("words"));
        idcardFront.setSex(wordsResult.optJSONObject("性别").optString("words"));
        idcardFront.setNation(wordsResult.optJSONObject("民族").optString("words"));
        return idcardFront;
    }
}
