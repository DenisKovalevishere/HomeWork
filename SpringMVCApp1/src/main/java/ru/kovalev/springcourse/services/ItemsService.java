package ru.kovalev.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.kovalev.springcourse.models.Item;
import ru.kovalev.springcourse.models.Person;
import ru.kovalev.springcourse.repositories.ItemsRepository;

@Service
@Transactional(readOnly = true)
public class ItemsService {
	
	private final ItemsRepository itemsRepository;

	@Autowired
	public ItemsService(ItemsRepository itemsRepository) {
		this.itemsRepository = itemsRepository;
	}
	
	public List<Item> findByItemName(String itemName) {
		return itemsRepository.findByItemName(itemName);
	}
	
	public List<Item> findByOwner(Person owner){
		return itemsRepository.findByOwner(owner);
	}
	
	
}
