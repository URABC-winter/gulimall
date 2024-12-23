package com.gulimall.coupou.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gulimall.common.annotation.Excel;
import com.gulimall.common.core.domain.BaseEntity;

/**
 * 优惠券领取历史记录对象 sms_coupon_history
 * 
 * @author ruoyi
 * @date 2024-11-23
 */
public class SmsCouponHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 优惠券id */
    @Excel(name = "优惠券id")
    private Long couponId;

    /** 会员id */
    @Excel(name = "会员id")
    private Long memberId;

    /** 会员名字 */
    @Excel(name = "会员名字")
    private String memberNickName;

    /** 获取方式[0->后台赠送；1->主动领取] */
    @Excel(name = "获取方式[0->后台赠送；1->主动领取]")
    private Integer getType;

    /** 使用状态[0->未使用；1->已使用；2->已过期] */
    @Excel(name = "使用状态[0->未使用；1->已使用；2->已过期]")
    private Integer useType;

    /** 使用时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date useTime;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 订单号 */
    @Excel(name = "订单号")
    private Long orderSn;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setMemberNickName(String memberNickName) 
    {
        this.memberNickName = memberNickName;
    }

    public String getMemberNickName() 
    {
        return memberNickName;
    }
    public void setGetType(Integer getType) 
    {
        this.getType = getType;
    }

    public Integer getGetType() 
    {
        return getType;
    }
    public void setUseType(Integer useType) 
    {
        this.useType = useType;
    }

    public Integer getUseType() 
    {
        return useType;
    }
    public void setUseTime(Date useTime) 
    {
        this.useTime = useTime;
    }

    public Date getUseTime() 
    {
        return useTime;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderSn(Long orderSn) 
    {
        this.orderSn = orderSn;
    }

    public Long getOrderSn() 
    {
        return orderSn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("couponId", getCouponId())
            .append("memberId", getMemberId())
            .append("memberNickName", getMemberNickName())
            .append("getType", getGetType())
            .append("createTime", getCreateTime())
            .append("useType", getUseType())
            .append("useTime", getUseTime())
            .append("orderId", getOrderId())
            .append("orderSn", getOrderSn())
            .toString();
    }
}
