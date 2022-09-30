package com.htl.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * myclassview
 *
 * @author
 */
public class Myclassview implements Serializable {
    private Integer uid;

    private String username;

    private String email;

    private String identity;

    private Integer cid;

    private String classname;

    private String classdetails;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creattime;

    private String creatperson;

    private Integer classnumber;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassdetails() {
        return classdetails;
    }

    public void setClassdetails(String classdetails) {
        this.classdetails = classdetails;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getCreatperson() {
        return creatperson;
    }

    public void setCreatperson(String creatperson) {
        this.creatperson = creatperson;
    }

    public Integer getClassnumber() {
        return classnumber;
    }

    public void setClassnumber(Integer classnumber) {
        this.classnumber = classnumber;
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
        Myclassview other = (Myclassview) that;
        return (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
                && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
                && (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
                && (this.getClassname() == null ? other.getClassname() == null : this.getClassname().equals(other.getClassname()))
                && (this.getClassdetails() == null ? other.getClassdetails() == null : this.getClassdetails().equals(other.getClassdetails()))
                && (this.getCreattime() == null ? other.getCreattime() == null : this.getCreattime().equals(other.getCreattime()))
                && (this.getCreatperson() == null ? other.getCreatperson() == null : this.getCreatperson().equals(other.getCreatperson()))
                && (this.getClassnumber() == null ? other.getClassnumber() == null : this.getClassnumber().equals(other.getClassnumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getClassname() == null) ? 0 : getClassname().hashCode());
        result = prime * result + ((getClassdetails() == null) ? 0 : getClassdetails().hashCode());
        result = prime * result + ((getCreattime() == null) ? 0 : getCreattime().hashCode());
        result = prime * result + ((getCreatperson() == null) ? 0 : getCreatperson().hashCode());
        result = prime * result + ((getClassnumber() == null) ? 0 : getClassnumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", username=").append(username);
        sb.append(", email=").append(email);
        sb.append(", identity=").append(identity);
        sb.append(", cid=").append(cid);
        sb.append(", classname=").append(classname);
        sb.append(", classdetails=").append(classdetails);
        sb.append(", creattime=").append(creattime);
        sb.append(", creatperson=").append(creatperson);
        sb.append(", classnumber=").append(classnumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}