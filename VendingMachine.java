//Vending Machine
//This program makes vending machines. You can set location and serial number.
//It sells Water Coffee Chips Chocolate. You can see the details of the Vending Machine
//It will show you the menu. You can then Buy items then you can return them
//It will then ask you to pay for what you bought. Then it will show the receipt,
//Finally it will Show all items left and bought with the total amount spent at that machine.
//Colton Korhummel. September 22, 2023
import java.util.Scanner;
public class VendingMachine {
    private int Number;
    private String Location;
    private final String[] Items = {"Water", "Coffee", "Chips", "Chocolate"};
    private int[] Amount = new int[4];
    private final double[] Prices = {1.50, 2.0, 1.0, 2.50};
    private int[] Bought = new int[4];
    double total;

//This prints out the contents of the Vending Machine.
    @Override
    public String toString() {
        return "Serial Number: "+Number+"\nLocation: "+Location+"\nContents:\n  Water: "+Amount[0]+"\n  Coffee: "
                +Amount[1] +"\n  Chips: "+Amount[2]+"\n  Chocolate: "+Amount[3];
    }

//This sets it Serial Number and Location is Unknown
    public VendingMachine(int Num){
        Number = Num;
        Location = "UNKNOWN";
    }

//This sets it Serial Number and Location from parameters
    public VendingMachine(int Num, String Name){
        Number = Num;
        Location = Name;
    }

//Sets the serial number
    public void setName(int NewName){
        Number = NewName;
    }

//Sets the Location
    public void setLocation(String location) {
        Location = location;
    }

//Checks if the amounts of items in the vending machine are all the same
    public boolean equals(VendingMachine machine2){
        for (int i = 0; i < 4; i++) {
            if(Amount[i] != machine2.Amount[i]){
                return false;
            }
        }
        return true;
    }


//Resets all the items in the machine to the number
    public void reset(int Wat, int Cof, int CHP, int Choc) {
        Amount[0] = Wat;
        Amount[1] = Cof;
        Amount[2] = CHP;
        Amount[3] = Choc;
    }

//This adds the amounts from parameters to current amount in machine
    public void addItems(int Wat, int Cof, int CHP, int Choc) {
        Amount[0] += Wat;
        Amount[1] += Cof;
        Amount[2] += CHP;
        Amount[3] += Choc;
    }

//This displays the Menu of the vending machine
    public void displayMenu() {
        System.out.println("1. Water............$1.50");
        System.out.println("2. Coffee...........$2.00");
        System.out.println("3. Chips............$1.00");
        System.out.println("4. Chocolate........$2.50");
    }

//This will ask user to input which item and how many they would like to buy
//if there is more you want than thre is it will return false because there isnt enough
    public boolean buyItem() {
        Scanner kb = new Scanner(System.in);
        int Buy = 0;
        int amount;
        while(Buy>4 || Buy<1){
            System.out.print("Select an item number: ");
            Buy = kb.nextInt();
        }
        System.out.print("How many do you want to buy? ");
        amount = kb.nextInt();
        if(amount > Amount[Buy-1]){
            System.out.printf("Selection failed. We do not have enough %s.\n", Items[Buy-1]);
            return false;
        } else {
            System.out.printf("You selected %s. Quantity: %d\n",Items[Buy-1],amount);
            Amount[Buy-1] -= amount;
            Bought[Buy-1] = amount;
            return true;
        }
    }

//This is like the previous function but the item they want and how much is in the parameters
    public boolean buyItem(int Buy, int amount){
        System.out.printf("Select an item number: %d\n", Buy);
        System.out.printf("How many do you want to buy? %d\n", amount);
        if(amount > Amount[Buy-1]){
            System.out.printf("Selection failed. We do not have enough %s.\n", Items[Buy-1]);
            return false;
        } else {
            System.out.printf("You selected %s. Quantity: %d\n",Items[Buy-1],amount);
            Amount[Buy-1] -= amount;
            Bought[Buy-1] = amount;
            return true;
        }
    }

//    This function returns what you put in the parameters which adds it back to the amount and subtracts the bought array
    public void returned(int Return, int amount) {
        System.out.printf("You selected: %s Quantity: %d\n", Items[Return-1], amount);
        Amount[Return-1] += amount;
        Bought[Return-1] -= amount;
    }


//    This function calculates the total price of the vending machine objects you puurchased then the user inputs
//    what he wants to pay if it is less than total price it returns false if it is equal to or greater
//    than returns true
    public boolean payment() {
        Scanner kb = new Scanner(System.in);
        double CurrentTotal = 0;
        double cash;
        double tax;
        for(int i = 0; i < 4; i++) {
            CurrentTotal += Prices[i] * Bought[i];
        }
        tax=CurrentTotal/10;
        CurrentTotal += tax;
        total = CurrentTotal;
        System.out.print("Enter money amount: $");
        cash = kb.nextDouble();
        if(total > cash){
            System.out.printf("Insufficient money. $%.2f returned\n", cash);
            return false;
        } else {
            System.out.printf("Sufficient money. $%.2f returned\n", cash-total);
            return true;
        }
    }

//This displays the receipt of what the user has bought and uses the total to print it as well
    public void displayReceipt() {
        double[] cash = new double[4];
        for (int i = 0; i < 4; i++) {
            if(Bought[i] == 0){
                continue;
            } else {
                cash[i] = Prices[i]*Bought[i];
                System.out.printf("%s: $%.2f X %d = %.2f\n", Items[i], Prices[i], Bought[i], cash[i]);
            }
        }
        double tax = total/10;
        System.out.printf("Tax (10.0%%): $%.2f\n", tax);
        System.out.printf("Total: %.2f\n",total);
    }


//    This prints the amount in the vending machine, the amount you have bought, and how much money you spent
//    As well as the Serial Number and Location
    public void status() {
        System.out.printf("Serial Number: %d\n", Number);
        System.out.printf("Location: %s\n", Location);
        System.out.println("Sold Items:");
        for(int i = 0; i < 4; i++) {
            System.out.printf("  %s: %d\n", Items[i], Bought[i]);
        }
        System.out.println("Current Contents:");
        for (int i = 0; i < 4; i++) {
            System.out.printf("  %s: %d\n", Items[i], Amount[i]);
        }
        System.out.printf("Total: $%.2f\n", total);
    }
}
