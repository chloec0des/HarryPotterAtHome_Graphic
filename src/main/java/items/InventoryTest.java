package items;

import java.util.ArrayList;

public class InventoryTest {
    public static void main(String[] args) {
        testAddItem();
        testRemoveItem();
        testGetItemByType();
    }

    public static void testAddItem() {
        Inventory inventory = new Inventory();
        Sword sword = new Sword("Sword", 50);
        inventory.addItem(sword);
        ArrayList<Item> items = inventory.getItems();
        if (items.size() != 1 || !items.contains(sword)) {
            System.out.println("testAddItem() failed");
        }else {
            System.out.println("Add item: It works!");
        }
    }

    public static void testRemoveItem() {
        Inventory inventory = new Inventory();
        Sword sword = new Sword("Sword", 50);
        inventory.addItem(sword);
        inventory.removeItem(sword);
        ArrayList<Item> items = inventory.getItems();
        if (items.size() != 0 || items.contains(sword)) {
            System.out.println("testRemoveItem() failed");
        }else {
            System.out.println("Remove item: It works!");
        }
    }

    public static void testGetItemByType() {
        Inventory inventory = new Inventory();
        Sword sword = new Sword("Sword", 50);
        Patronus patronus = new Patronus("Expecto Patronum", 50);
        inventory.addItem(sword);
        inventory.addItem(patronus);
        Sword retrievedSword = inventory.getItemByType(Sword.class);
        Patronus retrievedPatronus = inventory.getItemByType(Patronus.class);
        if (retrievedSword == null || retrievedSword != sword) {
            System.out.println("testGetItemByType() failed for Sword");
        }else {
            System.out.println("Retrieve sword item: It works!");
        }
        if (retrievedPatronus == null || retrievedPatronus != patronus) {
            System.out.println("testGetItemByType() failed for Patronus");
        }else {
            System.out.println("Retrieve Patronus: It works!");
        }
    }
}
