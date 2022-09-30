package com.htl.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * examquestiondetail
 * @author 
 */
public class Examquestiondetail extends ExamquestiondetailKey implements Serializable {
    private String choose;

    private Date time;

    private static final long serialVersionUID = 1L;

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

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
        Examquestiondetail other = (Examquestiondetail) that;
        return (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()))
            && (this.getqId() == null ? other.getqId() == null : this.getqId().equals(other.getqId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getChoose() == null ? other.getChoose() == null : this.getChoose().equals(other.getChoose()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        result = prime * result + ((getqId() == null) ? 0 : getqId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getChoose() == null) ? 0 : getChoose().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", choose=").append(choose);
        sb.append(", time=").append(time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}