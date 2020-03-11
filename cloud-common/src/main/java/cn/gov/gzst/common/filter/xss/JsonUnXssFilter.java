package cn.gov.gzst.common.filter.xss;

import cn.gov.gzst.common.utils.StringUtils;
import com.alibaba.fastjson.serializer.ValueFilter;
import org.apache.commons.lang.StringEscapeUtils;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.common.filter.xss
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/4/24 15:14
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class JsonUnXssFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        // 判断如果是字符串反解析
        if (value instanceof String && value != null){
            return StringEscapeUtils.unescapeHtml(value+"");
        }
        return value;
    }
}
