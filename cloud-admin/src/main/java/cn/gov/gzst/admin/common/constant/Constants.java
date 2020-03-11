package cn.gov.gzst.admin.common.constant;

public interface Constants {
	/**编码**/
	public final static String DEFAULT_SMS_VERIFY_TEMPLATE_CODE = "vercode"; //默认短信验证模板
	public final static String DEFAULT_EMAIL_VERIFY_TEMPLATE_CODE = "vercode"; //默认邮件验证模板
	public final static String SEND_REGISTER_INFO_TEMPLATE_CODE  = "w7orizfed2"; //默认用户名密码
	public final static String SEND_RETRIEVE_PASSWORD_INFO_TEMPLATE_CODE  = "zynerpfrtn"; //默认用户名密码
   /***procDefKey**/
	public final static String USER_AUTH_PROC_DEF_KEY = "upmsUserAuth"; //用户认证

	public final static String USER_AUTH_REVIEW_TASK_DEF_KEY = "firstUserReview"; //一级审核

	/***procDefKey**/
	public final static String ENTERPRISE_AUTH_PROC_DEF_KEY = "upmsEnterpriseAuth"; //用户认证

	public final static String ENTERPRISE_AUTH_REVIEW_TASK_DEF_KEY = "firstEnterpriseReview"; //一级审核

	/***procDefKey**/
	public final static String TECHNICAL_DEMAND_AUDIT_PROC_DEF_KEY = "technicalDemandAudit"; //用户认证

	public final static String TECHNICAL_DEMAND_AUDIT_RETRY_APPLY_TASK_DEF_KEY = "userRetryApply"; //重新提交

	public final static String TECHNICAL_DEMAND_AUDIT_REVIEW_TASK_DEF_KEY = "firstReview"; //一级审核



	//消息模板
	public final static String  MESSAGE_ENTERPRISE_MEMBER_APPLY_TEMPLATE_CODE = "gx729s22b3"; //用户申请企业成员模板

	public final static String  MESSAGE_ENTERPRISE_MEMBER_INVITE_TEMPLATE_CODE = "7p4nf7ltfd"; //用户申请企业成员模板

	public final static String  MESSAGE_ENTERPRISE_MEMBER_APPLY_AUDIT_PASS_TEMPLATE_CODE = "bb534x3k2r"; //用户申请企业成员审核通过模板

	public final static String  MESSAGE_ENTERPRISE_MEMBER_APPLY_AUDIT_NO_PASS_TEMPLATE_CODE = "zskx822q2a"; //用户申请企业成员审核不通过模板

	public final static String  MESSAGE_ENTERPRISE_MEMBER_INVITE_AUDIT_PASS_TEMPLATE_CODE = "7lrvmsb10x"; //企业要求请成员审核通过模板

	public final static String  MESSAGE_ENTERPRISE_MEMBER_INVITE_AUDIT_NO_PASS_TEMPLATE_CODE = "2jdh2r5axl"; //企业要求请成员审核不通过模板
}
