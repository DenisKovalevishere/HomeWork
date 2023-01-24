package ru.kovalev.springcourse;

import java.util.ArrayList;
import java.util.List;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;

//@Component
public class MusicPlayer {
	
	
	private List <Music> musicList = new ArrayList<>();

	
	@Value("${musicPlayer.name}")
	private String name;
	
	@Value("${musicPlayer.volume}")
	private int volume;
	
	

	public String getName() {
		return name;
	}


	public int getVolume() {
		return volume;
	}


//	@Autowired
	public MusicPlayer(List <Music> musicList) {
		super();
		this.musicList = musicList;
	}


	public void playMusic(MusicEnum musicEnum) {
		if(musicEnum == MusicEnum.CLASSICAL) {
			System.out.println(musicList.get(0).getSong());
		} 
		if(musicEnum == MusicEnum.RAP) {
			System.out.println(musicList.get(1).getSong());
		}
		if (musicEnum == MusicEnum.ROCK) {
			System.out.println(musicList.get(2).getSong());
		} else {
			System.out.println("Error");
		}
	
}
}
