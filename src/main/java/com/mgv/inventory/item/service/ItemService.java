package com.mgv.inventory.item.service;

import com.mgv.inventory.item.entity.Item;
import com.mgv.inventory.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public Item getItemById(String id){
        Item item = itemRepository.findById(id).orElse(null);

        if(item != null){
            itemRepository.findById(id);
        }
        return item;
    }

    public List<Item> createItem(List<Item> items){
        return itemRepository.saveAll(items);
    }

    public Item updateItem(Item updateItem, String id){
        Item item = itemRepository.findById(id).orElse(null);

        if(item != null){
            item.setName(updateItem.getName());
            item.setDescription(updateItem.getDescription());
            item.setIsStolen(updateItem.getIsStolen());

            itemRepository.save(item);
        }
        return item;
    }

    public Item deleteItem(String id){
        Item item = itemRepository.findById(id).orElse(null);

        if(item != null){
            itemRepository.deleteById(id);
        }
        return item;
    }
}
