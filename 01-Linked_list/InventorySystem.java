class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    // Constructor to initialize item details
    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head;

    // Add an item at the beginning
    void addItemAtBeginning(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    void addItemAtEnd(int itemId, String itemName, int quantity, double price) {
        Item newItem = new Item(itemId, itemName, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Remove an item by Item ID
    void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update item quantity by Item ID
    void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    // Search for an item by Item ID
    void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " (Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate and display total value of inventory
    void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Display all items
    void displayItems() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemId + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        
        // Adding items
        inventory.addItemAtBeginning(1, "Laptop", 5, 800.0);
        inventory.addItemAtEnd(2, "Mouse", 10, 20.0);
        inventory.addItemAtEnd(3, "Keyboard", 7, 50.0);
        
        // Display items
        System.out.println("Inventory List:");
        inventory.displayItems();
        
        // Updating quantity
        System.out.println("\nUpdating Quantity of Item ID 2");
        inventory.updateQuantity(2, 15);
        inventory.displayItems();
        
        // Searching for an item
        System.out.println("\nSearching for Item ID 3:");
        inventory.searchItemById(3);
        
        // Calculating total inventory value
        System.out.println("\nCalculating Total Inventory Value:");
        inventory.calculateTotalValue();
        
        // Removing an item
        System.out.println("\nRemoving Item ID 1");
        inventory.removeItem(1);
        inventory.displayItems();
    }
}
