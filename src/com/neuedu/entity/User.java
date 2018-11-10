package com.neuedu.entity;

import java.sql.Date;

public class User {
    private Integer uid;           //用户id
    private String uname;          //用户账号
    private String upwd;           //用户密码   大于8位
    private String usex;           //性别
    private Date ubirthday;        //生日
    private String receiver;       //收货人
    private String raddress;       //收货地址
    private String rtelephone;     //收货电话
    private Integer rlevel;        //等级       1：普通vip；2：管理员
    private String raids;          //权限
    private Integer ifdelete;      //是否删除    0：存在，   1：删除
    private String uemail;         //注册邮箱
    private String uphone;         //注册手机号
    private Authority authority;
    public User() {
    }

    public User(Integer uid, String uname, String upwd, String usex, Date ubirthday, String receiver, String raddress, String rtelephone, Integer rlevel, String raids, Integer ifdelete, String uemail, String uphone) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.ubirthday = ubirthday;
        this.receiver = receiver;
        this.raddress = raddress;
        this.rtelephone = rtelephone;
        this.rlevel = rlevel;
        this.raids = raids;
        this.ifdelete = ifdelete;
        this.uemail = uemail;
        this.uphone = uphone;
    }

    public User(String uname, String upwd, Integer rlevel) {
        this.uname = uname;
        this.upwd = upwd;
        this.rlevel = rlevel;
    }

    public User(Integer uid,String uname,String upwd, String usex, String receiver, String raddress, String rtelephone, Integer rlevel) {
        this.uid=uid;
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.receiver = receiver;
        this.raddress = raddress;
        this.rtelephone = rtelephone;
        this.rlevel = rlevel;
    }

    public User(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public User(String uname, String usex, Date ubirthday, String receiver, String raddress, String rtelephone) {
        this.uname = uname;
        this.usex = usex;
        this.ubirthday = ubirthday;
        this.receiver = receiver;
        this.raddress = raddress;
        this.rtelephone = rtelephone;
    }

    public User(Integer uid, String uname, String upwd, String usex, Date ubirthday, String receiver, String raddress, String rtelephone, Integer rlevel, String raids, Integer ifdelete) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.ubirthday = ubirthday;
        this.receiver = receiver;
        this.raddress = raddress;
        this.rtelephone = rtelephone;
        this.rlevel = rlevel;
        this.raids = raids;
        this.ifdelete = ifdelete;

    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress;
    }

    public String getRtelephone() {
        return rtelephone;
    }

    public void setRtelephone(String rtelephone) {
        this.rtelephone = rtelephone;
    }

    public Integer getRlevel() {
        return rlevel;
    }

    public void setRlevel(Integer rlevel) {
        this.rlevel = rlevel;
    }

    public String getRaids() {
        return raids;
    }

    public void setRaids(String raids) {
        this.raids = raids;
    }

    public Integer getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex='" + usex + '\'' +
                ", ubirthday=" + ubirthday +
                ", receiver='" + receiver + '\'' +
                ", raddress='" + raddress + '\'' +
                ", rtelephone='" + rtelephone + '\'' +
                ", rlevel=" + rlevel +
                ", raids='" + raids + '\'' +
                ", ifdelete=" + ifdelete +
                ", uemail='" + uemail + '\'' +
                ", uphone='" + uphone + '\'' +
                '}';
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public void setUbirthday(String ubirthday) {
    }
}
