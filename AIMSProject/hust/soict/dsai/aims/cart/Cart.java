package hust.soict.dsai.aims.aims.cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import hust.soict.dsai.aims.aims.media.*;
public class Cart {
    public List<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {
    }

    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    public void  removeMedia(Media media) {
        int indexOfMedia = itemsOrdered.indexOf(media);
        if (indexOfMedia == -1) {
            System.out.println("Media does not exist!");
            return;
        }
        itemsOrdered.remove(indexOfMedia);
        System.out.println("Media removed!");
    }

    // Tinh gia cua tat ca cac item trong gio hang

    public double totalCost() {
        double totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // In giỏ hàng
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        // float totalCost = 0;
        // for (int i = 0; i < qtyOrdered; i++) {
        // 	System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        // 	totalCost += itemsOrdered[i].getCost();
        // }
        for (Media media : itemsOrdered) {
            media.print();
        }
        double totalC = Math.round(totalCost() * 100.0) / 100.0;
        System.out.println("Total cost: " + totalC + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                found = true;
                media.print();
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                found = true;
                media.print();
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("Cart is empty!");
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
