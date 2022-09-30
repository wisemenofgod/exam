package com.htl.pojo.domain;

import java.io.Serializable;

/**
 * exampaper_question_key
 * @author 
 */
public class ExampaperQuestionKeyKey implements Serializable {
    private Integer qId;

    private Integer eId;

    private static final long serialVersionUID = 1L;

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
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
        ExampaperQuestionKeyKey other = (ExampaperQuestionKeyKey) that;
        return (this.getqId() == null ? other.getqId() == null : this.getqId().equals(other.getqId()))
            && (this.geteId() == null ? other.geteId() == null : this.geteId().equals(other.geteId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getqId() == null) ? 0 : getqId().hashCode());
        result = prime * result + ((geteId() == null) ? 0 : geteId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", qId=").append(qId);
        sb.append(", eId=").append(eId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}