package Meal_project.Meal_project.repo;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import Meal_project.Meal_project.model.Meal;
import Meal_project.Meal_project.model.ShowMeal;

@Repository
public class MealRepository {

	private ArrayList<Meal> meals = new ArrayList<Meal>();
	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<ShowMeal> showMeals = new ArrayList<ShowMeal>();
	private ArrayList<Meal> searchResults = new ArrayList<Meal>();
	
	public MealRepository() {
		/*Meal meal1 = new Meal("2018-03-06", "00:00", "some words", 150);
		Meal meal2 = new Meal("2018-03-06", "00:00", "some words", 150);
		Meal meal3 = new Meal("2018-03-06", "00:00", "some words", 150);*/
	
	}
	
	public ArrayList<Meal> findAll(){
		return meals;
	}
	
	public ArrayList<ShowMeal> getShowMeals() {
		return showMeals;
	}
	
	public void setShowMeals(ArrayList<ShowMeal> showMeals) {
		this.showMeals = showMeals;
	}
	
	public ArrayList<String> getDates() {
		return dates;
	}
	
	public Meal findOneById(Long id){
		for(Meal m : meals) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Meal> findByDescription(String description) {
		ArrayList<Meal> retVal = new ArrayList<Meal>();
		for(Meal m : meals) {
			if(m.getDescription().contains(description)) {
				retVal.add(m);
			}
		}	
		return retVal;
	}
	
	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public ArrayList<Meal> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(ArrayList<Meal> searchResults) {
		this.searchResults = searchResults;
	}
	
	
}
