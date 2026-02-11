package com.shivam.Ecom.controller;

import com.shivam.Ecom.model.itemModel;
import com.shivam.Ecom.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app")
public class Ecom {

    @Autowired
    private itemService service;
    // crud operations

    // read operation
    @GetMapping("getAll")
    public List<itemModel> getAll(){
        return service.getAll();
    }

    // get single element
    @GetMapping("get/{id}")
    public itemModel getByID(@PathVariable("id") int id){
        return service.getByID(id);
    }

    // create operation
    @PostMapping("addItem")
    public itemModel addItem(@RequestBody itemModel i){
         return service.addItem(i);
    }

    // delete operation
    @DeleteMapping("delete/{id}")
    public void deleteItem(@PathVariable("id") int id){
        service.deleteItem(id);
    }

    @PutMapping("update/{id}")
    public itemModel updateItem(
            @PathVariable int id,
            @RequestBody itemModel updatedItem
    ) {
        return service.updateItem(id, updatedItem);
    }


}
