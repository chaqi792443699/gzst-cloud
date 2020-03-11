package cn.gov.gzst.assessment.entity;

import cn.gov.gzst.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 费用类别实体类
 * </p>
 *
 * @author chaqi
 * @since 2019-04-10
 */
@TableName("cwpg_cost")
public class FinanceCost extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键（PK）
     */
    @TableId(value = "ID", type = IdType.UUID)
    @ApiModelProperty(name = "id",value = "主键（PK）",dataType = "String")
    private String id;

    /**
     * 费用编号
     */
    @TableField("COST_NUMBER")
    @ApiModelProperty(name = "costNumber",value = "费用编号",dataType = "String")
    private String costNumber;

    /**
     * 费用类别
     */
    @TableField("COST_TYPE")
    @ApiModelProperty(name = "costType",value = "费用类别",dataType = "String")
    private String costType;

    /**
     * 合同类型不同，费用类别不同
     */
    @TableField("CONTRACT_TYPE")
    @ApiModelProperty(name = "contractType",value = "合同类型不同，费用类别不同",dataType = "String")
    private String contractType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCostNumber() {
        return costNumber;
    }

    public void setCostNumber(String costNumber) {
        this.costNumber = costNumber;
    }
    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }
    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    @Override
    public String toString() {
        return "FinanceCost{" +
        "id=" + id +
        ", costNumber=" + costNumber +
        ", costType=" + costType +
        ", contractType=" + contractType +
        "}";
    }
}
