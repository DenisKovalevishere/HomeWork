package ru.kovalev.springcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RapMusic implements Music{
	
	private List<String> songs = new ArrayList<>();
	
	{
        songs.add("Stan");
        songs.add("Candy Shop");
        songs.add("Gorgorod");
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
