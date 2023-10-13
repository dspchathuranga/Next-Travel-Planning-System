package lk.ijse.nexttravel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class NextTravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextTravelApplication.class, args);
	}

}
