package isa.tim65.projekat.model;

import java.util.Date;

import javax.persistence.*;


@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "beginning", nullable = false)
	private Date beginning;
	
	@Column(name = "ending", nullable = false)
	private Date ending;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "donor_id")
	private Donor donor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "center_id")
	private Center center;

	public Appointment() {
		super();
	}

	public Appointment(Date beginning, Date ending, Donor donor, Center center) {
		super();
		this.beginning = beginning;
		this.ending = ending;
		this.donor = donor;
		this.center = center;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBeginning() {
		return beginning;
	}

	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}

	public Date getEnding() {
		return ending;
	}

	public void setEnding(Date ending) {
		this.ending = ending;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
	
}
