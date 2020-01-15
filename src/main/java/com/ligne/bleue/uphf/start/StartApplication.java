package com.ligne.bleue.uphf.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ligne.bleue.uphf.models.Activity;
import com.ligne.bleue.uphf.models.Program;
import com.ligne.bleue.uphf.models.Role;
import com.ligne.bleue.uphf.models.User;
import com.ligne.bleue.uphf.repositories.RoleRepository;
import com.ligne.bleue.uphf.services.ActivityService;
import com.ligne.bleue.uphf.services.ProgramService;
import com.ligne.bleue.uphf.services.UserService;

@SpringBootApplication
@EnableJpaRepositories("com.ligne.bleue.uphf.*")
@ComponentScan(basePackages = { "com.ligne.bleue.uphf.*" })
@EntityScan("com.ligne.bleue.uphf.*")

public class StartApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProgramService programService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		User user1 = new User("Samad", "BD","Adult",190, 90, "0755060213", "samad@gfx.bd", "password_2019","Homme");
		User user2 = new User("Messi", "RF","Kid",180, 80, "0755060213", "messi@tiznit.ma", "password_2019","Homme");
		User user3 = new User("Josèphe", "De Nazareth", "Adult",200, 100, "0755060213","josephe@legion.mk", "password_2019","Homme");
		User user4 = new User("Msika", "Manfalouti", "Adult",200, 100, "0755060213","msika@manf.ma", "password_2019","Femme");
		User user5 = new User("Moutcho", "Deprio", "Adult",200, 100, "0755060213","moutcho@uphf.fr", "password_2019","Homme");

		
		Role role1 = new Role("USER");
		Role role2 = new Role("ADMIN");
		
		Activity a1 = new Activity(1, "ISTV 1", "Abdos", "20 mins", "Type 1");
		Activity a2 = new Activity(2, "ISTV 2", "Push up", "40 mins", "Type 2");
		Activity a3 = new Activity(1, "ISTV 3", "Marathon", "2 heures", "Type 3");
		
		Program p1 = new Program(1, "Perte de poids",1, 160, 175, 60, 75);
		Program p2 = new Program(2, "Gagner du poids",3, 180, 195, 80, 95);
		Program p3 = new Program(3, "Les abdos",2, 160, 188, 60, 88);
		
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role1);
		user3.getRoles().add(role1);
		user4.getRoles().add(role1);
		user5.getRoles().add(role1);
		
		roleRepo.save(role1);
		roleRepo.save(role2);
		
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(user4);
		userService.saveUser(user5);
		
		programService.saveProgram(p1);
		programService.saveProgram(p2);
		programService.saveProgram(p3);
		
		activityService.saveActivity(a1);
		activityService.saveActivity(a2);
		activityService.saveActivity(a3);
	}

}
