package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the food_item_mapping database table.
 * 
 */
@Embeddable
public class FoodItemMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="food_id", insertable=false, updatable=false)
	private int foodId;

	@Column(name="city_id", insertable=false, updatable=false)
	private int cityId;

	@Column(name="restaurant_id", insertable=false, updatable=false)
	private int restaurantId;

	public FoodItemMappingPK() {
	}
	public int getFoodId() {
		return this.foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getCityId() {
		return this.cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getRestaurantId() {
		return this.restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FoodItemMappingPK)) {
			return false;
		}
		FoodItemMappingPK castOther = (FoodItemMappingPK)other;
		return 
			(this.foodId == castOther.foodId)
			&& (this.cityId == castOther.cityId)
			&& (this.restaurantId == castOther.restaurantId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.foodId;
		hash = hash * prime + this.cityId;
		hash = hash * prime + this.restaurantId;
		
		return hash;
	}
}