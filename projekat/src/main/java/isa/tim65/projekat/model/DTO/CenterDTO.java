package isa.tim65.projekat.model.DTO;

import java.time.LocalTime;


public class CenterDTO {

	private Integer id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String country;
	
	private String description;
	
	private LocalTime opening;
	
	private LocalTime closing;

	private float grade;
	
	public CenterDTO() {
		super();
	}
	
	public CenterDTO(Integer id, String name, String address, String city, String country, String description,
			LocalTime opening, LocalTime closing) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.description = description;
		this.opening = opening;
		this.closing = closing;
	}

	
	public CenterDTO(Integer id, String name, String address, String city, String country, String description,
			LocalTime opening, LocalTime closing, float grade) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.description = description;
		this.opening = opening;
		this.closing = closing;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getOpening() {
		return opening;
	}

	public void setOpening(LocalTime opening) {
		this.opening = opening;
	}

	public LocalTime getClosing() {
		return closing;
	}

	public void setClosing(LocalTime closing) {
		this.closing = closing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}
	
	
	

}
