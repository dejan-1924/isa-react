package isa.tim65.projekat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import isa.tim65.projekat.model.Appointment;
import isa.tim65.projekat.model.Center;
import isa.tim65.projekat.model.CenterAdmin;
import isa.tim65.projekat.model.Donor;
import isa.tim65.projekat.model.SystemAdmin;
import isa.tim65.projekat.repository.AppointmentRepository;
import isa.tim65.projekat.repository.CenterAdminRepository;
import isa.tim65.projekat.repository.CenterRepository;
import isa.tim65.projekat.repository.DonorRepository;
import isa.tim65.projekat.repository.SystemAdminRepository;

@SpringBootApplication
public class ProjekatApplication implements CommandLineRunner {
	@Autowired
	private CenterRepository centerRepo;
	
	@Autowired 
	private DonorRepository donorRepo;
	
	@Autowired
	private CenterAdminRepository centerAdminRepo;
	
	@Autowired
	private SystemAdminRepository systemAdminRepo;
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjekatApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Center c1 = new Center("prvi", "Amara Hodzica 12", "Maglaj", "Bosna", "neki opis", LocalTime.of(7, 0), LocalTime.of(13, 0), (float) 4.5, null, null);
		Center c2 = new Center("drugi", "Jasmina Fazlica 3", "Beograd", "Srbija", "drugi opis", LocalTime.of(6, 0), LocalTime.of(12, 0), (float) 3.9, null, null);
		centerRepo.save(c1);
		centerRepo.save(c2);
		
		Donor d1 = new Donor("donor1@gmail.com", "donor", "pera", "peric",
				"Jelene Karleuse 1", "Maglaj", "Bosna", "+38766123213", "0101000123000", true, true,
				"Glavni baja", "Teretana", 100, "prva", null);
		Donor d2 = new Donor("donor2@gmail.com", "donor", "mika", "mikic",
				"Ace Lukasa 2", "Sabac", "Srbija", "+38166123233", "0101000123001", true, true,
				"Klosar", "Lopovski sabirni centar", 200, "druga", null);
		Donor d3 = new Donor("donor3@gmail.com", "donor", "zika", "zikic",
				"Teje Tairovic 13", "Subotica", "Madjarska", "+38066123213", "0101000123002", true, false,
				"Madjarski sahista", "Sah klub Sandor", 50, "prva", null);
		Donor d4 = new Donor("donor4@gmail.com", "donor", "lepa", "lukic",
				"Sake Polumente 3", "Banja Koviljaca", "Srbija", "+38166123273", "0101000123009", false, true,
				"Estradna pevaljka", "Estrada", 250, "druga", null);
		donorRepo.save(d1);
		donorRepo.save(d2);
		donorRepo.save(d3);
		donorRepo.save(d4);
		
		CenterAdmin ca1 = new CenterAdmin("centeradmin1@gmail.com", "centeradmin", "Jela", "Jelic", 
				"Svetlane Raznatovic 9", "Beograd", "Srbija", "+381665555555", "0202000123202", false, c1);
		CenterAdmin ca2 = new CenterAdmin("centeradmin2@gmail.com", "centeradmin", "Stanojko", "Petrovic",
				"Mihajla Ulemeka Legije 5", "Kragujevac", "Srbija", "+381664444444", "0303000123303", true, c2);
		centerAdminRepo.save(ca1);
		centerAdminRepo.save(ca2);
		
		SystemAdmin sa1 = new SystemAdmin("systemadmin1@gmail.com", "systemadmin", "Katarina", "Zivkovic",
				"Paje Patka 23", "Jagodina", "Srbija", "+381661212222", "0404000123004", false);
		systemAdminRepo.save(sa1);
		
		DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
		String b1 = "18-Nov-2022,10:30:00 PM";
		String e1 = "18-Nov-2022,11:30:00 PM";
		String b2 = "18-Nov-2022,9:00:00 PM";
		String e2 = "18-Nov-2022,10:00:00 PM";
		
		Date beginning1 = formatter.parse(b1);
		Date ending1 = formatter.parse(e1);
		Date beginning2 = formatter.parse(b2);
		Date ending2 = formatter.parse(e2);
		
		Appointment c1a1 = new Appointment(beginning1, ending1, d1, c1);
		Appointment c1a2 = new Appointment(beginning2, ending2, d2, c1);
		
		Appointment c2a1 = new Appointment(beginning1, ending1, d3, c2);
		Appointment c2a2 = new Appointment(beginning2, ending2, d4, c2);
		appointmentRepo.save(c1a1);
		appointmentRepo.save(c1a2);
		appointmentRepo.save(c2a1);
		appointmentRepo.save(c2a2);
	}

}
