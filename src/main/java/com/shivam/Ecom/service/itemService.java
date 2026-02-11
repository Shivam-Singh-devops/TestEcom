package com.shivam.Ecom.service;

import com.shivam.Ecom.model.itemModel;
import com.shivam.Ecom.repo.EcomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemService {

    @Autowired
    private EcomRepo repo;

    public List<itemModel> getAll() {
        return repo.getAll();
    }

    public itemModel addItem(itemModel i) {
        return repo.addItem(i);
    }

    public void deleteItem(int id) {
        repo.deleteItem(id);
    }

    public itemModel getByID(int id) {
        return repo.getByID(id);
    }

    public itemModel updateItem(int id, itemModel updatedItem) {
        return repo.updateItem(id, updatedItem);
    }
}
