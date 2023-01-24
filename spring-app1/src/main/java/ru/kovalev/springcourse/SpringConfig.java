package ru.kovalev.springcourse;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("ru.kovalev.springcourse")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

	@Bean
	ClassicalMusic classicalMusic() {
		return ClassicalMusic.getClassicalMusic();}
	
	@Bean
	RapMusic rapMusic() {
		return new RapMusic();
	}
	
	@Bean
	RockMusic rockMusic() {
		return new RockMusic();
	}
	
	@Bean
	List<Music> musicList(){
		return Arrays.asList(classicalMusic(), rapMusic(), rockMusic());
	}
	
	@Bean
	MusicPlayer musicPlayer() {
		return new MusicPlayer(musicList());
	}
	
}
