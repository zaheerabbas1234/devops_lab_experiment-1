package com.citizen.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Citizen {
	
	@Id
	private String citizenId
	private String citizenName;
	private String vaccineName;
	private String vaccineCenterId;
	private String vaccineCenterAddress;
	
	
	public Citizen() {
		super();
	}


	public Citizen(String citizenId, String citizenName, String vaccineName, String vaccineCenterId,
			String vaccineCenterAddress) {
		super();
		this.citizenId = citizenId;
		this.citizenName = citizenName;
		this.vaccineName = vaccineName;
		this.vaccineCenterId = vaccineCenterId;
		this.vaccineCenterAddress = vaccineCenterAddress;
	}


	public String getCitizenId() {
		return citizenId;
	}


	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}


	public String getCitizenName() {
		return citizenName;
	}


	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}


	public String getVaccineName() {
		return vaccineName;
	}


	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}


	public String getVaccineCenterId() {
		return vaccineCenterId;
	}


	public void setVaccineCenterId(String vaccineCenterId) {
		this.vaccineCenterId = vaccineCenterId;
	}


	public String getVaccineCenterAddress() {
		return vaccineCenterAddress;
	}


	public void setVaccineCenterAddress(String vaccineCenterAddress) {
		this.vaccineCenterAddress = vaccineCenterAddress;
	}


	@Override
	public String toString() {
		return "Citizen [citizenId=" + citizenId + ", citizenName=" + citizenName + ", vaccineName=" + vaccineName
				+ ", vaccineCenterId=" + vaccineCenterId + ", vaccineCenterAddress=" + vaccineCenterAddress + "]";
	}
	
	

}
