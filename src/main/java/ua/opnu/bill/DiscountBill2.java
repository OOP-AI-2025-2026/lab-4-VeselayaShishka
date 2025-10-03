package ua.opnu.bill;

import java.util.ArrayList;

public class DiscountBill2 {

  GroceryBill bill;
  private boolean regularCustomer;

  public DiscountBill2(Employee clerk, boolean regularCustomer) {
    this.bill = new GroceryBill(clerk);
    this.regularCustomer = regularCustomer;
  }

  public int getDiscountCount() {
    int count = 0;
      if (!regularCustomer) {return count;}
    ArrayList<Item> items = bill.getItems();

    for (Item item : items) {
      if (item.getDiscount() > 0) {
        count++;
      }
    }
    return count;
  }

  public double getDiscountAmount() {
    double amount = 0;
    if (!regularCustomer) {return amount;}
    ArrayList<Item> items = bill.getItems();
    for (Item item : items) {
      amount += item.getDiscount();
    }
    return Math.round(amount*100)/100.0;
  }

  public double getTotal() {
    if (!regularCustomer) {
      return bill.getTotal();
    }
    return Math.round((bill.getTotal() - getDiscountAmount())*100)/100.0;
  }

  public double getDiscountPercent() {
    return Math.round((100 - ((getTotal() * 100) / bill.getTotal()))*1e13)/1e13;
  }

  public Employee getClerk() {
    return bill.getClerk();
  }

  public void add(Item i) {
    bill.add(i);
  }

  public ArrayList<Item> getItems() {
    return bill.getItems();
  }
}
