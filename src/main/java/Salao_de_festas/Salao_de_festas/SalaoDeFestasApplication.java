package Salao_de_festas.Salao_de_festas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalaoDeFestasApplication {

	/**
	 * Fuction allow the server run
	 * @param args paramenter allow you to pass command line arguments to the application,
	 *  anebling runtime configurations, such as environment.
	 */
	public static void run(String[] args){
		SpringApplication.run(SalaoDeFestasApplication.class, args);
	}
	public static void main(String[] args) {
		run(args);
	}

}
