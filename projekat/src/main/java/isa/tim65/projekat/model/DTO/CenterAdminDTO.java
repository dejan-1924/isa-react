package isa.tim65.projekat.model.DTO;


public class CenterAdminDTO {
	private String email;
	private String password;
	private String name;
	private String surname;
	private String address;
	private String city;
	private String country;
	private String phoneNumber;
	private String ssn;
	private boolean isMale;
	private Integer centerId;
	private String gender;
	
	public CenterAdminDTO() {
		super();
	}

	public CenterAdminDTO(String email, String password, String name, String surname, String address, String city,
			String country, String phoneNumber, String ssn, boolean isMale, Integer centerId) {
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
		this.centerId = centerId;
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
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	@Override
	public String toString() {
		return "CenterAdminDTO [email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", address=" + address + ", city=" + city + ", country=" + country + ", phoneNumber=" + phoneNumber
				+ ", ssn=" + ssn + ", isMale=" + isMale + ", centerId=" + centerId + "]";
	}
}
