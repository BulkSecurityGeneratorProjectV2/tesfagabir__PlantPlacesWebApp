package com.plantplaces.ui;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class AddPlant {

	@Inject
	private Plant plant;

	@Inject
	private IPlantService plantService;

	private String message = "foo";

	public String execute() {
		String returnValue = "";

		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();

		try {
			plantService.save(plant);

			// what is the message that we want to show?
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Saved");
			// display the message
			currentInstance.addMessage(null, fm);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			returnValue = "fail";

			// what is the message that we want to show?
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Save", "Plant not Saved");
			// display the message
			currentInstance.addMessage(null, fm);

		}
		return returnValue;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}