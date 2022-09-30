package com.htl.pojo.domain;

import java.io.Serializable;

/**
 * exampaperquestionview
 * @author 
 */
public class Exampaperquestionview implements Serializable {
    private Integer eid;

    private String exampapername;

    private Integer qid;

    private String question;

    private String typename;

    private String a;

    private String b;

    private String c;

    private String d;

    private String ans;

    private String creatperson;

    private static final long serialVersionUID = 1L;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getExampapername() {
        return exampapername;
    }

    public void setExampapername(String exampapername) {
        this.exampapername = exampapername;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getCreatperson() {
        return creatperson;
    }

    public void setCreatperson(String creatperson) {
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
        Exampaperquestionview other = (Exampaperquestionview) that;
        return (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getExampapername() == null ? other.getExampapername() == null : this.getExampapername().equals(other.getExampapername()))
            && (this.getQid() == null ? other.getQid() == null : this.getQid().equals(other.getQid()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getTypename() == null ? other.getTypename() == null : this.getTypename().equals(other.getTypename()))
            && (this.getA() == null ? other.getA() == null : this.getA().equals(other.getA()))
            && (this.getB() == null ? other.getB() == null : this.getB().equals(other.getB()))
            && (this.getC() == null ? other.getC() == null : this.getC().equals(other.getC()))
            && (this.getD() == null ? other.getD() == null : this.getD().equals(other.getD()))
            && (this.getAns() == null ? other.getAns() == null : this.getAns().equals(other.getAns()))
            && (this.getCreatperson() == null ? other.getCreatperson() == null : this.getCreatperson().equals(other.getCreatperson()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getExampapername() == null) ? 0 : getExampapername().hashCode());
        result = prime * result + ((getQid() == null) ? 0 : getQid().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getTypename() == null) ? 0 : getTypename().hashCode());
        result = prime * result + ((getA() == null) ? 0 : getA().hashCode());
        result = prime * result + ((getB() == null) ? 0 : getB().hashCode());
        result = prime * result + ((getC() == null) ? 0 : getC().hashCode());
        result = prime * result + ((getD() == null) ? 0 : getD().hashCode());
        result = prime * result + ((getAns() == null) ? 0 : getAns().hashCode());
        result = prime * result + ((getCreatperson() == null) ? 0 : getCreatperson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", exampapername=").append(exampapername);
        sb.append(", qid=").append(qid);
        sb.append(", question=").append(question);
        sb.append(", typename=").append(typename);
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", d=").append(d);
        sb.append(", ans=").append(ans);
        sb.append(", creatperson=").append(creatperson);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}