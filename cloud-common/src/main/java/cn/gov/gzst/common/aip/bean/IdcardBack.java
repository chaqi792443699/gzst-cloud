package cn.gov.gzst.common.aip.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.baidu.aip.bean
 * @title:
 * @description: 身份证反面
 * @author: jianliaoliang
 * @date: 2018/4/21 19:00
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class IdcardBack  implements Serializable {
    /**签发机关*/
    private String issuingAuthority;
    /**有效期限开始日期*/
    private Date usefulLifeBegin;
    /**有效期限结束日期*/
    private Date usefulLifeEnd;

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    public Date getUsefulLifeBegin() {
        return usefulLifeBegin;
    }

    public void setUsefulLifeBegin(Date usefulLifeBegin) {
        this.usefulLifeBegin = usefulLifeBegin;
    }

    public Date getUsefulLifeEnd() {
        return usefulLifeEnd;
    }

    public void setUsefulLifeEnd(Date usefulLifeEnd) {
        this.usefulLifeEnd = usefulLifeEnd;
    }
}
