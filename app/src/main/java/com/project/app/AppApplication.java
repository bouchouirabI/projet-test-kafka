package com.project.app;

//import com.github.javafaker.Faker;
//import com.project.app.entity.Client;
//import com.project.app.provider.ClientProvider;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.annotation.PostConstruct;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.ArrayList;
//import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class AppApplication {
//
//	private final ClientProvider clientProvider;
//
//	@Value("${init.numberOfClients}")
//	private Integer numberOfInitClients;
//
//	@PostConstruct
//	private void setUpClients(){
//		Faker faker = new Faker();
//		List<Client> clients = new ArrayList<>();
//
//		for (int i = 0; i < numberOfInitClients; i++) {
//			clients.add(Client.builder()
//					.firstName(faker.name().firstName())
//					.lastName(faker.name().lastName())
//					.middleName(faker.name().lastName())
//					.dateOfBirth(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
//					.placeOfBirth(faker.address().cityName())
//					.email(faker.internet().safeEmailAddress())
//					.enrollmentDate(LocalDate.now())
//					.build());
//		}
//		clientProvider.addAll(clients);
//	}

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
