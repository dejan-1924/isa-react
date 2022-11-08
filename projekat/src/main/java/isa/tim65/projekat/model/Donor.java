package isa.tim65.projekat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", nullable = false, updatable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "phonenumber", nullable = false, unique = true)
	private String phoneNumber;
	
	@Column(name = "ssn", nullable = false, updatable = false, unique = true)
	private String ssn;
	
	@Column(name = "ismale", nullable = false, updatable = false)
	private boolean isMale;
	
	@Column(name = "isvalidated", nullable = false)
	private boolean isValidated;
	
	@Column(name = "profession", nullable = false)
	private String profession;
	
	@Column(name = "institution", nullable = false)
	private String institution;
	
	@Column(name = "loyaltypoints", nullable = false)
	private Integer loyaltyPoints;
	
	@Column(name = "loyaltygroup", nullable = false)
	private String loyaltyGroup;
	
	@OneToMany(mappedBy = "donor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Appointment> appointments = new HashSet<Appointment>();

	public Donor() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public Donor(String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String ssn, boolean isMale, String profession, String institution,
			Integer loyaltyPoints, String loyaltyGroup, Set<Appointment> appointments) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.isMale = isMale;
		this.profession = profession;
		this.institution = institution;
		this.loyaltyPoints = loyaltyPoints;
		this.loyaltyGroup = loyaltyGroup;
		this.appointments = appointments;
		this.isValidated = false;
	}
	

	public Donor(String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String ssn, boolean isMale, boolean isValidated, String profession,
			String institution, Integer loyaltyPoints, String loyaltyGroup, Set<Appointment> appointments) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.isMale = isMale;
		this.isValidated = isValidated;
		this.profession = profession;
		this.institution = institution;
		this.loyaltyPoints = loyaltyPoints;
		this.loyaltyGroup = loyaltyGroup;
		this.appointments = appointments;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public Integer getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(Integer loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getLoyaltyGroup() {
		return loyaltyGroup;
	}

	public void setLoyaltyGroup(String loyaltyGroup) {
		this.loyaltyGroup = loyaltyGroup;
	}

	public Set<Appointment> getAppointment() {
		return appointments;
	}

	public void setAppointment(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
	
	
	
}
