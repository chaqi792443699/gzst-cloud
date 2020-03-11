package cn.gov.gzst.email.task;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.StringUtils;
import cn.gov.gzst.email.entity.SendLog;
import cn.gov.gzst.email.service.ISendLogService;
import cn.gov.gzst.email.service.ISendService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 邮件回复任务
 */
@Component("retrySendTask")
public class RetrySendTask {

	public final Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ISendLogService sendLogService;
	@Autowired
	private ISendService sendService;
	private Boolean isRun=Boolean.FALSE;

	/**
	 * 这里把发送中的邮件恢复发送
	 */
	@PostConstruct
	public void initRetrySendTask(){
		//找到发送中的邮件重新发送
		List<SendLog> emailSendLogList = sendLogService
				.selectList(new EntityWrapper<SendLog>(SendLog.class)
						.eq("status", SendLog.EMAIL_SEND_STATUS_IN));
		//恢复处理
		for (SendLog emailSendLog : emailSendLogList) {
			sendService.sendRetryAsyncEmailByCode(emailSendLog.getId(),emailSendLog.getEmail(), emailSendLog.getSendCode(),
					JSON.parseObject(emailSendLog.getSendData(), Map.class));
		}
	}
	/**
	 * 检查回复并写入到日志中
	 */
	@Scheduled(fixedRate = 10000)
	public void run() {
		log.info(" 邮件重发日志运行开始......................................" + (new Date()));
		if (!isRun) {
			isRun=Boolean.TRUE;
			try {
				//查询出询问邮件
				//找到未发送成功的邮件
				List<SendLog> emailSendLogList = sendLogService
						.selectList(new EntityWrapper<SendLog>(SendLog.class)
								.eq("status", SendLog.EMAIL_SEND_STATUS_FAIL).lt("tryNum", 3)
						);
				//恢复处理
				for (SendLog emailSendLog : emailSendLogList) {
					sendByLog(emailSendLog);
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				isRun=Boolean.FALSE;
			}
		}
	}

	public void sendByLog(SendLog emailSendLog){
		try {
			//更新类型
			emailSendLog.setStatus(SendLog.EMAIL_SEND_STATUS_IN);
			//表示响应成功！
			if (emailSendLog.getTryNum() == null) {
				emailSendLog.setTryNum(0);
			}
			emailSendLog.setTryNum(emailSendLog.getTryNum() + 1);
			sendLogService.saveOrUpdate(emailSendLog);
			sendService.sendRetryAsyncEmailByCode(emailSendLog.getId(),emailSendLog.getEmail(), emailSendLog.getSendCode(),
					JSON.parseObject(emailSendLog.getSendData(), Map.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
