package cn.gov.gzst.sms.common.sms.data;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("serial")
public class GetReplyResult implements Iterable<GetReplyResult.MsgInfo>, Serializable {

	private String code;// 返回状态吗
	private String msg; // 返回消息
	private Boolean success;// 是否成功
	private String smsReceiverName = ""; // 接收器器的名称
	private List<MsgInfo> msgInfoList = new ArrayList<MsgInfo>();

	public void addMsgInfo(String msgInfo) {
		if (!StringUtils.isEmpty(msgInfo)) {
			String[] msgInfos = msgInfo.split("\\|@\\|");
			for (String msgContent : msgInfos) {
				msgInfoList.add(new MsgInfo(msgContent));
			}
		}
	}

	@Override
	public Iterator<MsgInfo> iterator() {
		return this.msgInfoList.iterator();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		if (!StringUtils.isEmpty(this.msg)) {
			addMsgInfo(this.msg);
		}
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getSmsReceiverName() {
		return smsReceiverName;
	}

	public void setSmsReceiverName(String smsReceiverName) {
		this.smsReceiverName = smsReceiverName;
	}

	public List<MsgInfo> getMsgInfoList() {
		return msgInfoList;
	}

	public void setMsgInfoList(List<MsgInfo> msgInfoList) {
		this.msgInfoList = msgInfoList;
	}

	public static class MsgInfo implements Serializable {
		private String phone; // 联系电话
		private String content;// 返回的内容
		private String date;// 返回时间
		private String smsid;// 对应发送消息ID

		public MsgInfo(String msgContent) {
			if (!StringUtils.isEmpty(msgContent)) {
				String[] msgContents = msgContent.split(",");
				if (msgContents.length == 4) {
					this.phone = msgContents[0];
					this.content = msgContents[1];
					this.date = msgContents[2];
					this.smsid = msgContents[3];
				}
			}

		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getSmsid() {
			return smsid;
		}

		public void setSmsid(String smsid) {
			this.smsid = smsid;
		}

	}
}
