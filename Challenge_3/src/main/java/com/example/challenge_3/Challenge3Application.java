package com.example.challenge_3;

import com.example.challenge_3.view.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge3Application {

	public static void main(String[] args) {

		Menu menu = new Menu();
		boolean state=true;
		while(state==true){
			state = menu.menuUtama();
		}
		SpringApplication.run(Challenge3Application.class, args);
	}

}
