package com.example.zcqtest2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Date;


@SpringBootApplication
@RestController
public class Zcqtest2Application {

	public static void main(String[] args)  {

		SpringApplication.run(Zcqtest2Application.class, args);

	}

	@Autowired
	RestTemplate restTemplate;


	@GetMapping("/zcqtest2")
	public String zcqtest2(@RequestParam(value = "name", defaultValue = "World") String name) throws IOException {

		String url = "http://zcqtest/getdate";
		return String.format(restTemplate.getForObject(url,String.class) + ", Hello zcqtest2 v1 %s! \n", name);

	}


	@GetMapping("/getdate2")
	public String getdate2(){

		Date date = new Date() ;

		return String.format(" --> NSF: zcqtest2 v1: " + date.toString() + " <-- \n");

	}

}
