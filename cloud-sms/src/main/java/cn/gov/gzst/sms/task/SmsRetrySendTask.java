package cn.gov.gzst.sms.task;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.sms.service.ISmsSendLogService;
import cn.gov.gzst.sms.service.ISmsSendService;
import cn.gov.gzst.sms.entity.SmsSendLog;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * 短信回复任务
 */
@Component("smsrRetrySendTask")
public class SmsRetrySendTask {

	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ISmsSendLogService smsSendLogService;
	@Autowired
	private ISmsSendService smsSendService;
	private Boolean isRun=Boolean.FALSE;

	/**
	 * 这里把发送中的短信恢复发送
	 */
	@PostConstruct
	public void initRetrySendTask(){
		//找到发送中的短信重新发送
		List<SmsSendLog> smsSendLogList = smsSendLogService
				.selectList(new EntityWrapper<SmsSendLog>(SmsSendLog.class)
						.eq("status", SmsSendLog.SMS_SEND_STATUS_IN));
		//恢复处理
		for (SmsSendLog smsSendLog : smsSendLogList) {
			smsSendService.sendRetryAsyncSmsByCode(smsSendLog.getId(),smsSendLog.getPhone(), smsSendLog.getSendCode(),
					StringUtils.split(smsSendLog.getSendData(), ","));
		}
	}
	/**
	 * 检查回复并写入到日志中
	 */
	@Scheduled(fixedRate = 10000)
	public void run() {
		log.info(" 短信重发日志运行开始......................................" + (new Date()));
		if (!isRun) {
			isRun=Boolean.TRUE;
			try{
				//查询出询问短信
				//找到未发送成功的短信
				List<SmsSendLog> smsSendLogList = smsSendLogService
						.selectList(new EntityWrapper<SmsSendLog>(SmsSendLog.class)
								.eq("status", SmsSendLog.SMS_SEND_STATUS_FAIL).lt("tryNum", 3)
						);
				//恢复处理
				for (SmsSendLog smsSendLog : smsSendLogList) {
					sendByLog(smsSendLog);
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				isRun=Boolean.FALSE;
			}
		}
	}

	public void sendByLog(SmsSendLog smsSendLog){
		try {
			//更新类型
			smsSendLog.setStatus(SmsSendLog.SMS_SEND_STATUS_IN);
			//表示响应成功！
			if (smsSendLog.getTryNum() == null) {
				smsSendLog.setTryNum(0);
			}
			smsSendLog.setTryNum(smsSendLog.getTryNum() + 1);
			smsSendLogService.saveOrUpdate(smsSendLog);
			smsSendService.sendRetryAsyncSmsByCode(smsSendLog.getId(),smsSendLog.getPhone(), smsSendLog.getSendCode(),
					StringUtils.split(smsSendLog.getSendData(), ","));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
