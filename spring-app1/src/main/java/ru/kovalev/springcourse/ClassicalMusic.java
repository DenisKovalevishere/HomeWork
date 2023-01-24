package ru.kovalev.springcourse;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component

public class ClassicalMusic implements Music {
	
	private ClassicalMusic(){}
	
	private List<String> songs = new ArrayList<>();
	
	{
        songs.add("Hungarian Rhapsody");
        songs.add("Symphony no. 5 in C Minor, op. 67");
        songs.add("Night on Bald Mountain");
    }
	
	public static ClassicalMusic getClassicalMusic() {
		return new ClassicalMusic();
	}
	
	@PostConstruct
	public void doMyInit() {
		System.out.println("Doing my initialization");
	}
	@PreDestroy
	public void doMyDestroy() {
		System.out.println("Doing my destruction");
	}
	

	@Override
	public String getSong() {
		// TODO Auto-generated method stub
		String song=null;
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		song = songs.get(randomNumber);
		return song;
	}

}
