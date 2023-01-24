package ru.kovalev.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.kovalev.springcourse.models.Item;
import ru.kovalev.springcourse.models.Person;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer>{
	List<Item> findByItemName(String itemName);

	
	List<Item> findByOwner(Person owner);
}
