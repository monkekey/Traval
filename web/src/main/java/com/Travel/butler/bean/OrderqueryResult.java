package com.Travel.butler.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 订单查询返回结果
 * Created by Leo on 2017/8/31.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderqueryResult extends MchBaseResult {

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String device_info;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String openid;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String is_subscribe;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String trade_type;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String trade_state;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String bank_type;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String total_fee;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String settlement_total_fee;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String fee_type;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String cash_fee;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String cash_fee_type;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String transaction_id;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String out_trade_no;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String attach;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String time_end;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String trade_state_desc;

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(String settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(String cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public void setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
    }
}
