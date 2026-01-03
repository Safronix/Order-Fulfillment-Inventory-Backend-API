package com.example.inventory_api;

import com.example.inventory_api.controller.ItemController;
import com.example.inventory_api.model.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    @Test
    void testAddAndGetItem() {
        ItemController controller = new ItemController();

        Item item = new Item("1", "Widget", 10);
        controller.addItem(item);

        assertEquals(1, controller.getAllItems().size());
        assertEquals("Widget", controller.getAllItems().get(0).getName());
    }
}
