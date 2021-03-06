package com.hopline.hoplinevendor;

import java.io.Serializable;

public class OrderStatusTo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1450634329486933208L;
	private Integer orderId;
	private String orderStatus;
	private String paidYN;
	private String cancelReason;
	private boolean success;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getPaidYN() {
		return paidYN;
	}
	public void setPaidYN(String paidYN) {
		this.paidYN = paidYN;
	}
	
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	

}
