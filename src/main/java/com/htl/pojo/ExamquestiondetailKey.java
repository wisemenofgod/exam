package com.htl.pojo;

import java.io.Serializable;

/**
 * examquestiondetail
 * @author 
 */
public class ExamquestiondetailKey implements Serializable {
    private Integer eId;

    private Integer qId;

    private Integer uId;

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
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
        ExamquestiondetailKey other = (ExamquestiondetailKey) that;
        return (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()))
            && (this.getqId() == null ? other.getqId() == null : this.getqId().equals(other.getqId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        result = prime * result + ((getqId() == null) ? 0 : getqId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eId=").append(eId);
        sb.append(", qId=").append(qId);
        sb.append(", uId=").append(uId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}