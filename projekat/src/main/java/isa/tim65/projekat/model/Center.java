package isa.tim65.projekat.model;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Center {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "opening", nullable = false)
	private LocalTime opening;
	
	@Column(name = "closing", nullable = false)
	private LocalTime closing;
	
	@Column(name = "grade", nullable = false)
	private float grade;
	
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CenterAdmin> centerAdmins = new HashSet<CenterAdmin>();
	
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Appointment> appointments = new HashSet<Appointment>();

	public Center() {
		super();
	}
	
	public Center(Integer id, String name, String address, String city, String country, String description,
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

	public Center(String name, String address, String city, String country, String description,
			LocalTime opening, LocalTime closing, float grade, Set<CenterAdmin> centerAdmins,
			Set<Appointment> appointments) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.description = description;
		this.opening = opening;
		this.closing = closing;
		this.grade = grade;
		this.centerAdmins = centerAdmins;
		this.appointments = appointments;
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

	public Set<CenterAdmin> getCenterAdmins() {
		return centerAdmins;
	}

	public void setCenterAdmins(Set<CenterAdmin> centerAdmins) {
		this.centerAdmins = centerAdmins;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
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
