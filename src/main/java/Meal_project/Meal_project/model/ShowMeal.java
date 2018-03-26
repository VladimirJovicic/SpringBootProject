package Meal_project.Meal_project.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ShowMeal")
public class ShowMeal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String date;
	private ArrayList<String> desctiptions;
	private ArrayList<String> times;
	private int summedCalories;
	
	public ShowMeal(){
		date = "";
		desctiptions = new ArrayList<String>();
		times = new ArrayList<String>();
		summedCalories = 0;
		
	}

	public String getDate() {
		return date;
	}
	
	
	public ShowMeal(String date, ArrayList<String> desctiptions, 
			ArrayList<String> times, int summedCalories) {
		this.date = date;
		this.desctiptions = desctiptions;
		this.times = times;
		this.summedCalories = summedCalories;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ArrayList<String> getDesctiptions() {
		return desctiptions;
	}

	public void setDesctiptions(ArrayList<String> desctiptions) {
		this.desctiptions = desctiptions;
	}

	public ArrayList<String> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<String> times) {
		this.times = times;
	}

	public int getSummedCalories() {
		return summedCalories;
	}

	public void setSummedCalories(int summedCalories) {
		this.summedCalories = summedCalories;
	}
	
	
}
