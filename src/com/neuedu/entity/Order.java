package com.neuedu.entity;

import java.sql.Timestamp;

public class Order {
    private Integer oid;                /**序号*/
    private String onum;                /**订单号*/
    private Integer uid;                /**用户ID*/
    private Integer gid;                /**商品ID*/
    private Integer gnum;               /**商品数量*/
    private Timestamp ocreatedate;      /**订单创建时间*/
    private Integer oifpay;             /**是否付款*/
    private Timestamp paydate;          /**付款时间*/
    private Integer oifdelivery;        /**是否发货*/
    private Timestamp deliverydate;     /**发货时间*/
    private Integer oiffinish;          /**是否完成*/
    private Timestamp finishdate;       /**完成时间*/
    private Integer oifreturnorder;     /**是否取消订单*/
    private Integer oifreturn;          /**是否退货*/
    private Integer oifmoney;           /**是否退款*/
    private Timestamp oifreturndate;    /**取消或者退货时间*/
    private Goods goods;
    private User user;
    public Order() {
    }

    public Order(Integer oid, String onum, Integer uid, Integer gid, Integer gnum, Timestamp ocreatedate, Integer oifpay, Timestamp paydate, Integer oifdelivery, Timestamp deliverydate, Integer oiffinish, Timestamp finishdate, Integer oifreturnorder, Integer oifreturn, Integer oifmoney, Timestamp oifreturndate) {
        this.oid = oid;
        this.onum = onum;
        this.uid = uid;
        this.gid = gid;
        this.gnum = gnum;
        this.ocreatedate = ocreatedate;
        this.oifpay = oifpay;
        this.paydate = paydate;
        this.oifdelivery = oifdelivery;
        this.deliverydate = deliverydate;
        this.oiffinish = oiffinish;
        this.finishdate = finishdate;
        this.oifreturnorder = oifreturnorder;
        this.oifreturn = oifreturn;
        this.oifmoney = oifmoney;
        this.oifreturndate = oifreturndate;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Timestamp getOcreatedate() {
        return ocreatedate;
    }

    public void setOcreatedate(Timestamp ocreatedate) {
        this.ocreatedate = ocreatedate;
    }

    public Integer getOifpay() {
        return oifpay;
    }

    public void setOifpay(Integer oifpay) {
        this.oifpay = oifpay;
    }

    public Timestamp getPaydate() {
        return paydate;
    }

    public void setPaydate(Timestamp paydate) {
        this.paydate = paydate;
    }

    public Integer getOifdelivery() {
        return oifdelivery;
    }

    public void setOifdelivery(Integer oifdelivery) {
        this.oifdelivery = oifdelivery;
    }

    public Timestamp getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Timestamp deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Integer getOiffinish() {
        return oiffinish;
    }

    public void setOiffinish(Integer oiffinish) {
        this.oiffinish = oiffinish;
    }

    public Timestamp getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Timestamp finishdate) {
        this.finishdate = finishdate;
    }

    public Integer getOifreturnorder() {
        return oifreturnorder;
    }

    public void setOifreturnorder(Integer oifreturnorder) {
        this.oifreturnorder = oifreturnorder;
    }

    public Integer getOifreturn() {
        return oifreturn;
    }

    public void setOifreturn(Integer oifreturn) {
        this.oifreturn = oifreturn;
    }

    public Integer getOifmoney() {
        return oifmoney;
    }

    public void setOifmoney(Integer oifmoney) {
        this.oifmoney = oifmoney;
    }

    public Timestamp getOifreturndate() {
        return oifreturndate;
    }

    public void setOifreturndate(Timestamp oifreturndate) {
        this.oifreturndate = oifreturndate;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", onum='" + onum + '\'' +
                ", uid=" + uid +
                ", gid=" + gid +
                ", gnum=" + gnum +
                ", ocreatedate=" + ocreatedate +
                ", oifpay=" + oifpay +
                ", paydate=" + paydate +
                ", oifdelivery=" + oifdelivery +
                ", deliverydate=" + deliverydate +
                ", oiffinish=" + oiffinish +
                ", finishdate=" + finishdate +
                ", oifreturnorder=" + oifreturnorder +
                ", oifreturn=" + oifreturn +
                ", oifmoney=" + oifmoney +
                ", oifreturndate=" + oifreturndate +
                ", goods=" + goods +
                ", user=" + user +
                '}';
    }
}
