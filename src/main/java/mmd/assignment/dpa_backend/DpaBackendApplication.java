package mmd.assignment.dpa_backend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

@EnableCaching
@SpringBootApplication
public class DpaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpaBackendApplication.class, args);
	}

}
