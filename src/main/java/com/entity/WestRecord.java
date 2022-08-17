package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName west_record
 */
@Data
public class WestRecord implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String no;

    /**
     * 
     */
    private String goodId;

    /**
     * 
     */
    private Integer number;

    /**
     * 
     */
    private BigDecimal price;

    /**
     * 
     */
    private String operationId;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Integer realNum;

    /**
     * 
     */
    private Integer preNum;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WestRecord other = (WestRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNo() == null ? other.getNo() == null : this.getNo().equals(other.getNo()))
            && (this.getGoodId() == null ? other.getGoodId() == null : this.getGoodId().equals(other.getGoodId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getOperationId() == null ? other.getOperationId() == null : this.getOperationId().equals(other.getOperationId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRealNum() == null ? other.getRealNum() == null : this.getRealNum().equals(other.getRealNum()))
            && (this.getPreNum() == null ? other.getPreNum() == null : this.getPreNum().equals(other.getPreNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNo() == null) ? 0 : getNo().hashCode());
        result = prime * result + ((getGoodId() == null) ? 0 : getGoodId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getOperationId() == null) ? 0 : getOperationId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRealNum() == null) ? 0 : getRealNum().hashCode());
        result = prime * result + ((getPreNum() == null) ? 0 : getPreNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", no=").append(no);
        sb.append(", goodId=").append(goodId);
        sb.append(", number=").append(number);
        sb.append(", price=").append(price);
        sb.append(", operationId=").append(operationId);
        sb.append(", status=").append(status);
        sb.append(", realNum=").append(realNum);
        sb.append(", preNum=").append(preNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}