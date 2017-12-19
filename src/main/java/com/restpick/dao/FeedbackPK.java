package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the feedback database table.
 * 
 */
@Embeddable
public class FeedbackPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ip_address")
	private String ipAddress;

	@Column(name="restaurant_id")
	private int restaurantId;

	@Column(name="food_id", insertable=false, updatable=false)
	private int foodId;

	public FeedbackPK() {
	}
	public String getIpAddress() {
		return this.ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getRestaurantId() {
		return this.restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getFoodId() {
		return this.foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FeedbackPK)) {
			return false;
		}
		FeedbackPK castOther = (FeedbackPK)other;
		return 
			this.ipAddress.equals(castOther.ipAddress)
			&& (this.restaurantId == castOther.restaurantId)
			&& (this.foodId == castOther.foodId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ipAddress.hashCode();
		hash = hash * prime + this.restaurantId;
		hash = hash * prime + this.foodId;
		
		return hash;
	}
}