package cn.gov.gzst.admin.common.utils;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.common.utils
 * @title:
 * @description: 国家化消息
 * @author: jianliaoliang
 * @date: 2018/3/16 9:45
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class MessageUtils extends cn.gov.gzst.common.utils.MessageUtils{
    /**
     * 根据消息键和参数 获取消息 委托给spring messageSource
     *
     * @param code
     *            消息键
     * @param args
     *            参数
     * @return
     */
    public static String getMessageByErrCode(int code, Object... args) {
        return getMessage("error."+code, args, null);
    }
}