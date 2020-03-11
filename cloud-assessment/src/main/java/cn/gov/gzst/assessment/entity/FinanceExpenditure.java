package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@TableName("cwpg_expenditure")
public class FinanceExpenditure extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "String")
    private String id;

    /**
     * 合同预算编号（外键）
     */
    @TableField("CONTRACT_ID")
    @ApiModelProperty(name = "contractId",value = "合同预算编号（外键）",dataType = "String")
    private String contractId;

    /**
     * 费用编号（外键）
     */
    @TableField("COST_ID")
    @ApiModelProperty(name = "costId",value = "费用编号（外键）",dataType = "String")
    private String costId;

    /**
     * 实际支出（自筹）
     */
    @TableField("EXPENDITURE_ZC")
    @ApiModelProperty(name = "expenditureZc",value = "实际支出（自筹）",dataType = "BigDecimal")
    private BigDecimal expenditureZc;

    /**
     * 实际支出（专项）
     */
    @TableField("EXPENDITURE_ZX")
    @ApiModelProperty(name = "expenditureZx",value = "实际支出（专项）",dataType = "BigDecimal")
    private BigDecimal expenditureZx;

    /**
     * 费用调整原因说明，审批情况
     */
    @TableField("DESCRIPTION")
    @ApiModelProperty(name = "description",value = "费用调整原因说明，审批情况",dataType = "String")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }
    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }
    public BigDecimal getExpenditureZc() {
        return expenditureZc;
    }

    public void setExpenditureZc(BigDecimal expenditureZc) {
        this.expenditureZc = expenditureZc;
    }
    public BigDecimal getExpenditureZx() {
        return expenditureZx;
    }

    public void setExpenditureZx(BigDecimal expenditureZx) {
        this.expenditureZx = expenditureZx;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FinanceExpenditure{" +
        "id=" + id +
        ", contractId=" + contractId +
        ", costId=" + costId +
        ", expenditureZc=" + expenditureZc +
        ", expenditureZx=" + expenditureZx +
        ", description=" + description +
        "}";
    }
}
