package ru.kovalev.springcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RockMusic implements Music{

private List<String> songs = new ArrayList<>();
	
	{
        songs.add("Wind cries Mary");
        songs.add("Paint it black");
        songs.add("Can't seem to make you mine");
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
