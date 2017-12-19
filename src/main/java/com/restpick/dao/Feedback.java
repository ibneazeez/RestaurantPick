package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FeedbackPK id;

	private String comments;

	private BigDecimal rating;

	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="food_id")
	private FoodItem foodItem;

	public Feedback() {
	}

	public FeedbackPK getId() {
		return this.id;
	}

	public void setId(FeedbackPK id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public FoodItem getFoodItem() {
		return this.foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

}