package cn.gov.gzst.oss.entity;

import cn.gov.gzst.common.common.entity.AbstractEntity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.oss.entity
 * @title: 附件实体
 * @description: 附件实体
 * @author: jianliaoliang
 * @date: 2018-04-25 15:55:59
 * @copyright: 2018 www.gzst.gov.cn Inc. All rights reserved.
 */

@TableName("oss_attachment")
@SuppressWarnings("serial")
public class Attachment extends AbstractEntity<String> {

    /**id*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**文件名称*/
    @TableField(value = "file_name")
	private String fileName;
    /**用户ID*/
    @TableField(value = "user_id")
	private String userId;
    /**上传时间*/
    @TableField(value = "upload_time")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date uploadTime;
    /**上传的ID*/
    @TableField(value = "upload_ip")
	private String uploadIp;
    /**文件扩展名*/
    @TableField(value = "file_extension")
	private String fileExtension;
    /**文件路径*/
    @TableField(value = "file_path")
	private String filePath;
    /**文件大小*/
    @TableField(value = "file_size")
	private Long fileSize;
    /**content_type*/
    @TableField(value = "content_type")
	private String contentType;
    /**状态*/
    @TableField(value = "status")
	private String status;
    /**oss的根路径*/
    @TableField(value = "base_path")
	private String basePath;
	/**对应的附件模型ID*/
	@TableField(value = "model_id")
    private String modelId;

    /**create_by*/
    @TableField(value = "create_by")
	private String createBy;
    /**create_date*/
    @TableField(value = "create_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
    /**update_by*/
    @TableField(value = "update_by")
	private String updateBy;
    /**update_date*/
    @TableField(value = "update_date")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
    /**remarks*/
    @TableField(value = "remarks")
	private String remarks;
    /**del_flag*/
    @TableField(value = "del_flag")
	private String delFlag;
	/**
	 * 项目编号
	 */
	@TableField(value = "project_id")
    private String projectId;
	/**
	 * 附件类型
	 */
	@TableField(value = "file_type")
	private String fileType;
	
	/**
	 * 获取  id
	 *@return String  id
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  fileName
	 *@return String  文件名称
	 */
	public String getFileName(){
		return this.fileName;
	}

	/**
	 * 设置  fileName
	 *@param fileName  文件名称
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	/**
	 * 获取  userId
	 *@return String  用户ID
	 */
	public String getUserId(){
		return this.userId;
	}

	/**
	 * 设置  userId
	 *@param userId  用户ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 * 获取  uploadTime
	 *@return Date  上传时间
	 */
	public Date getUploadTime(){
		return this.uploadTime;
	}

	/**
	 * 设置  uploadTime
	 *@param uploadTime  上传时间
	 */
	public void setUploadTime(Date uploadTime){
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取  uploadIp
	 *@return String  上传的ID
	 */
	public String getUploadIp(){
		return this.uploadIp;
	}

	/**
	 * 设置  uploadIp
	 *@param uploadIp  上传的ID
	 */
	public void setUploadIp(String uploadIp){
		this.uploadIp = uploadIp;
	}
	/**
	 * 获取  fileExtension
	 *@return String  文件扩展名
	 */
	public String getFileExtension(){
		return this.fileExtension;
	}

	/**
	 * 设置  fileExtension
	 *@param fileExtension  文件扩展名
	 */
	public void setFileExtension(String fileExtension){
		this.fileExtension = fileExtension;
	}
	/**
	 * 获取  filePath
	 *@return String  文件路径
	 */
	public String getFilePath(){
		return this.filePath;
	}

	/**
	 * 设置  filePath
	 *@param filePath  文件路径
	 */
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	/**
	 * 获取  fileSize
	 *@return Integer  文件大小
	 */
	public Long getFileSize(){
		return this.fileSize;
	}

	/**
	 * 设置  fileSize
	 *@param fileSize  文件大小
	 */
	public void setFileSize(Long fileSize){
		this.fileSize = fileSize;
	}
	/**
	 * 获取  contentType
	 *@return String  content_type
	 */
	public String getContentType(){
		return this.contentType;
	}

	/**
	 * 设置  contentType
	 *@param contentType  content_type
	 */
	public void setContentType(String contentType){
		this.contentType = contentType;
	}
	/**
	 * 获取  status
	 *@return String  状态
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  basePath
	 *@return String  oss的根路径
	 */
	public String getBasePath(){
		return this.basePath;
	}

	/**
	 * 设置  basePath
	 *@param basePath  oss的根路径
	 */
	public void setBasePath(String basePath){
		this.basePath = basePath;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	/**
	 * 获取  createBy
	 *@return String  create_by
	 */
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param createBy  create_by
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  createDate
	 *@return Date  create_date
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param createDate  create_date
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 * 获取  updateBy
	 *@return String  update_by
	 */
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param updateBy  update_by
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 * 获取  updateDate
	 *@return Date  update_date
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 * 设置  updateDate
	 *@param updateDate  update_date
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 * 获取  remarks
	 *@return String  remarks
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param remarks  remarks
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/**
	 * 获取  delFlag
	 *@return String  del_flag
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param delFlag  del_flag
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}