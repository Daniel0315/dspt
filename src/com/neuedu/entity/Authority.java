package com.neuedu.entity;

public class Authority {
    private Integer aid;
    private String acontent;
    private Integer ifdelete;
    private String url;
    private String aphone;

    public Authority() {
    }

    public Authority(Integer aid, String acontent, Integer ifdelete, String url, String aphone) {
        this.aid = aid;
        this.acontent = acontent;
        this.ifdelete = ifdelete;
        this.url = url;
        this.aphone = aphone;
    }

    public Authority(Integer aid, String acontent, Integer ifdelete, String url) {
        this.aid = aid;
        this.acontent = acontent;
        this.ifdelete = ifdelete;
        this.url = url;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

    public Integer getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "aid=" + aid +
                ", acontent='" + acontent + '\'' +
                ", ifdelete=" + ifdelete +
                ", url='" + url + '\'' +
                ", aphone='" + aphone + '\'' +
                '}';
    }
}
