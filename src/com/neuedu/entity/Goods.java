package com.neuedu.entity;

public class Goods {
    private Integer gid;            /**商品id*/
    private String gname;           /**商品名称*/
    private Double gprice;          /**商品单价*/
    private Integer grepertory;     /**库存*/
    private Integer gsalesvolume;   /**销售量*/
    private String gstandard;       /**规格*/
    private String gimg;            /**图片路径*/
    private String gremarks;        /**备注*/
    private Integer cid;            /**类型号*/
    private Integer ifdelete;       /**判断商品信息是否可以删除  0：未删除   1：删除*/
    private Type type;
    public Goods() {
    }

    public Goods(Integer gid, String gname, Double gprice, Integer grepertory, Integer gsalesvolume, String gstandard, String gimg, String gremarks, Integer cid) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.grepertory = grepertory;
        this.gsalesvolume = gsalesvolume;
        this.gstandard = gstandard;
        this.gimg = gimg;
        this.gremarks = gremarks;
        this.cid = cid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public Integer getGrepertory() {
        return grepertory;
    }

    public void setGrepertory(Integer grepertory) {
        this.grepertory = grepertory;
    }

    public Integer getGsalesvolume() {
        return gsalesvolume;
    }

    public void setGsalesvolume(Integer gsalesvolume) {
        this.gsalesvolume = gsalesvolume;
    }

    public String getGstandard() {
        return gstandard;
    }

    public void setGstandard(String gstandard) {
        this.gstandard = gstandard;
    }

    public String getGimg() {
        return gimg;
    }

    public void setGimg(String gimg) {
        this.gimg = gimg;
    }

    public String getGremarks() {
        return gremarks;
    }

    public void setGremarks(String gremarks) {
        this.gremarks = gremarks;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(Integer ifdelete) {
        this.ifdelete = ifdelete;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", grepertory=" + grepertory +
                ", gsalesvolume=" + gsalesvolume +
                ", gstandard='" + gstandard + '\'' +
                ", gimg='" + gimg + '\'' +
                ", gremarks='" + gremarks + '\'' +
                ", cid=" + cid +
                ", ifdelete=" + ifdelete +
                ", type=" + type +
                '}';
    }
}
