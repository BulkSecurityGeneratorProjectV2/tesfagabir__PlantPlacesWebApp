package com.plantplaces.ui;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants {

	@Inject
	private Plant plant;

	public String execute() {
		if (plant != null && plant.getName().equalsIgnoreCase("Redbud")) {
			return "search";
			
		} else {
			return "noresults";
		}
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}
	
	public List<Plant> completePlants(String query){
		List<Plant> plants = new ArrayList<Plant>();
		
		//Create plants and add them to the collection.
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		plants.add(redbud);
		
		Plant pawpaw = new Plant();
		pawpaw.setName("Pawpaw");
		plants.add(pawpaw);
		
		Plant nasturtium = new Plant();
		nasturtium.setName("Nasturtium");
		plants.add(nasturtium);
		
		return plants;
		
	}
}
