package com.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName west_types
 */
@Data
public class WestTypes implements Serializable {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String link;

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
        WestTypes other = (WestTypes) that;
        return (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLink() == null ? other.getLink() == null : this.getLink().equals(other.getLink()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLink() == null) ? 0 : getLink().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", name=").append(name);
        sb.append(", id=").append(id);
        sb.append(", link=").append(link);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}