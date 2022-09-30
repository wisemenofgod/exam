package com.htl.pojo.domain;

import java.io.Serializable;

/**
 * myquestionview
 * @author 
 */
public class Myquestionview implements Serializable {
    private Integer uid;

    private String creatperson;

    private Integer id;

    private String question;

    private String a;

    private String b;

    private String c;

    private String d;

    private String ans;

    private String typename;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCreatperson() {
        return creatperson;
    }

    public void setCreatperson(String creatperson) {
        this.creatperson = creatperson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
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
        Myquestionview other = (Myquestionview) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getCreatperson() == null ? other.getCreatperson() == null : this.getCreatperson().equals(other.getCreatperson()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQuestion() == null ? other.getQuestion() == null : this.getQuestion().equals(other.getQuestion()))
            && (this.getA() == null ? other.getA() == null : this.getA().equals(other.getA()))
            && (this.getB() == null ? other.getB() == null : this.getB().equals(other.getB()))
            && (this.getC() == null ? other.getC() == null : this.getC().equals(other.getC()))
            && (this.getD() == null ? other.getD() == null : this.getD().equals(other.getD()))
            && (this.getAns() == null ? other.getAns() == null : this.getAns().equals(other.getAns()))
            && (this.getTypename() == null ? other.getTypename() == null : this.getTypename().equals(other.getTypename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getCreatperson() == null) ? 0 : getCreatperson().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQuestion() == null) ? 0 : getQuestion().hashCode());
        result = prime * result + ((getA() == null) ? 0 : getA().hashCode());
        result = prime * result + ((getB() == null) ? 0 : getB().hashCode());
        result = prime * result + ((getC() == null) ? 0 : getC().hashCode());
        result = prime * result + ((getD() == null) ? 0 : getD().hashCode());
        result = prime * result + ((getAns() == null) ? 0 : getAns().hashCode());
        result = prime * result + ((getTypename() == null) ? 0 : getTypename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", creatperson=").append(creatperson);
        sb.append(", id=").append(id);
        sb.append(", question=").append(question);
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", d=").append(d);
        sb.append(", ans=").append(ans);
        sb.append(", typename=").append(typename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}