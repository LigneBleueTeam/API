package com.ligne.bleue.uphf.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ligne.bleue.uphf.models.Role;
import com.ligne.bleue.uphf.models.User;
import com.ligne.bleue.uphf.repositories.RoleRepository;
import com.ligne.bleue.uphf.services.UserService;

@SpringBootApplication
@EnableJpaRepositories("com.ligne.bleue.uphf.*")
@ComponentScan(basePackages = { "com.ligne.bleue.uphf.*" })
@EntityScan("com.ligne.bleue.uphf.*")

public class StartApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleRepository roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		User user1 = new User("Samad", "BD","Adult",190, 90, "0755060213", "samad@gfx.bd", "password_2019");
		User user2 = new User("Messi", "RF","Kid",180, 80, "0755060213", "messi@tiznit.ma", "password_2019");
		User user3 = new User("Josèphe", "De Nazareth", "Adult",200, 100, "0755060213","josephe@legion.mk", "password_2019");

		Role role1 = new Role("USER");
		Role role2 = new Role("ADMIN");
		
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);
		user2.getRoles().add(role1);
		user3.getRoles().add(role1);
		
		roleRepo.save(role1);
		roleRepo.save(role2);
		
		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);			
	}

}
