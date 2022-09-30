package com.htl.pojo;

import java.io.Serializable;

/**
 * question
 * @author 
 */
public class Question implements Serializable {
    private Integer id;

    private String qName;

    private String qAnsa;

    private String qAnsb;

    private String qAnsc;

    private String qAnsd;

    private String qAns;

    private Integer qType;

    private Integer creatperson;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public String getqAnsa() {
        return qAnsa;
    }

    public void setqAnsa(String qAnsa) {
        this.qAnsa = qAnsa;
    }

    public String getqAnsb() {
        return qAnsb;
    }

    public void setqAnsb(String qAnsb) {
        this.qAnsb = qAnsb;
    }

    public String getqAnsc() {
        return qAnsc;
    }

    public void setqAnsc(String qAnsc) {
        this.qAnsc = qAnsc;
    }

    public String getqAnsd() {
        return qAnsd;
    }

    public void setqAnsd(String qAnsd) {
        this.qAnsd = qAnsd;
    }

    public String getqAns() {
        return qAns;
    }

    public void setqAns(String qAns) {
        this.qAns = qAns;
    }

    public Integer getqType() {
        return qType;
    }

    public void setqType(Integer qType) {
        this.qType = qType;
    }

    public Integer getCreatperson() {
        return creatperson;
    }

    public void setCreatperson(Integer creatperson) {
        this.creatperson = creatperson;
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
        Question other = (Question) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getqName() == null ? other.getqName() == null : this.getqName().equals(other.getqName()))
            && (this.getqAnsa() == null ? other.getqAnsa() == null : this.getqAnsa().equals(other.getqAnsa()))
            && (this.getqAnsb() == null ? other.getqAnsb() == null : this.getqAnsb().equals(other.getqAnsb()))
            && (this.getqAnsc() == null ? other.getqAnsc() == null : this.getqAnsc().equals(other.getqAnsc()))
            && (this.getqAnsd() == null ? other.getqAnsd() == null : this.getqAnsd().equals(other.getqAnsd()))
            && (this.getqAns() == null ? other.getqAns() == null : this.getqAns().equals(other.getqAns()))
            && (this.getqType() == null ? other.getqType() == null : this.getqType().equals(other.getqType()))
            && (this.getCreatperson() == null ? other.getCreatperson() == null : this.getCreatperson().equals(other.getCreatperson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getqName() == null) ? 0 : getqName().hashCode());
        result = prime * result + ((getqAnsa() == null) ? 0 : getqAnsa().hashCode());
        result = prime * result + ((getqAnsb() == null) ? 0 : getqAnsb().hashCode());
        result = prime * result + ((getqAnsc() == null) ? 0 : getqAnsc().hashCode());
        result = prime * result + ((getqAnsd() == null) ? 0 : getqAnsd().hashCode());
        result = prime * result + ((getqAns() == null) ? 0 : getqAns().hashCode());
        result = prime * result + ((getqType() == null) ? 0 : getqType().hashCode());
        result = prime * result + ((getCreatperson() == null) ? 0 : getCreatperson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", qName=").append(qName);
        sb.append(", qAnsa=").append(qAnsa);
        sb.append(", qAnsb=").append(qAnsb);
        sb.append(", qAnsc=").append(qAnsc);
        sb.append(", qAnsd=").append(qAnsd);
        sb.append(", qAns=").append(qAns);
        sb.append(", qType=").append(qType);
        sb.append(", creatperson=").append(creatperson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}