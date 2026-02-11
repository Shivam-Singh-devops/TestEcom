package com.shivam.Ecom.repo;

import com.shivam.Ecom.model.itemModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EcomRepo {

    // to load the product data
    List<itemModel> items=new ArrayList<>(Arrays.asList(
            new itemModel(
                    1,
                    "Wireless Mouse",
                    "Ergonomic wireless mouse with adjustable DPI",
                    4,
                    120,
                    true,
                    "LogiTech",
                    "Electronics"
            ),

            new itemModel(
                    2,
                    "Mechanical Keyboard",
                    "RGB backlit mechanical keyboard with blue switches",
                    5,
                    60,
                    true,
                    "KeyChron",
                    "Electronics"
            ),

            new itemModel(
                    3,
                    "Bluetooth Headphones",
                    "Noise-cancelling over-ear headphones",
                    5,
                    25,
                    true,
                    "Sony",
                    "Electronics"
            ),

            new itemModel(
                    4,
                    "Running Shoes",
                    "Lightweight running shoes for daily training",
                    4,
                    30,
                    true,
                    "Nike",
                    "Footwear"
            ),

            new itemModel(
                    5,
                    "Coffee Mug",
                    "Ceramic coffee mug, 350ml",
                    3,
                    0,
                    false,
                    "HomeBasics",
                    "Kitchen"
            ),

            new itemModel(
                    6,
                    "Smart Watch",
                    "Fitness tracking smartwatch with heart-rate monitor",
                    4,
                    15,
                    true,
                    "Samsung",
                    "Wearables"
            ),

            new itemModel(
                    7,
                    "Notebook",
                    "A5 ruled notebook with 200 pages",
                    4,
                    200,
                    true,
                    "Classmate",
                    "Stationery"
            ),

            new itemModel(
                    8,
                    "Backpack",
                    "Water-resistant laptop backpack (15-inch)",
                    4,
                    10,
                    true,
                    "Wildcraft",
                    "Accessories"
            ),

            new itemModel(
                    9,
                    "Water Bottle",
                    "Stainless steel insulated water bottle",
                    5,
                    80,
                    true,
                    "Milton",
                    "Kitchen"
            ),

            new itemModel(
                    10,
                    "Desk Lamp",
                    "LED desk lamp with brightness control",
                    4,
                    5,
                    true,
                    "Philips",
                    "Home Decor"
            )

    ));

    public List<itemModel> getAll() {
        return items;
    }

    public itemModel addItem(itemModel item) {

        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (item.getRating() < 1 || item.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        if (item.getQuantity() < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        item.setInStock(item.getQuantity() > 0);
        items.add(item);
        return item;
    }


    public void deleteItem(int id) {
        for (int i=0;i<items.size();i++){
            if (items.get(i).getId()==id){
                items.remove(i);
            }
        }
    }

    public itemModel getByID(int id) {
        for (int i=0;i<items.size();i++){
            if (items.get(i).getId()==id){
                return items.get(i);
            }
        }
        return null;
    }

    public itemModel updateItem(int id, itemModel updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                updatedItem.setId(id);
                items.set(i, updatedItem);
                return updatedItem;
            }
        }
        return null;
    }
}
