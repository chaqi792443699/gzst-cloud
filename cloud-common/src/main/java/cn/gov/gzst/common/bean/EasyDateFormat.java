package cn.gov.gzst.common.bean;

import cn.gov.gzst.common.utils.DateUtils;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.utils
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/5/6 12:39
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class EasyDateFormat extends DateFormat {

    private DateFormat dateFormat;

    public EasyDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return dateFormat.format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        Date date = null;
        try {
            date = DateUtils.parseDate(source);
        } catch (Exception e) {
            date = dateFormat.parse(source, pos);
        }
        return date;
    }

    // 主要还是装饰这个方法
    @Override
    public Date parse(String source) throws ParseException {
        Date date = null;
        try {
            // 先按我的规则来
            date = DateUtils.parseDate(source);
        } catch (Exception e) {
            // 不行，那就按原先的规则吧
            date = dateFormat.parse(source);
        }
        return date;
    }

    // 这里装饰clone方法的原因是因为clone方法在jackson中也有用到
    @Override
    public Object clone() {
        Object format = dateFormat.clone();
        return new EasyDateFormat((DateFormat) format);
    }
}
