package ua.opnu.bill;

import java.util.ArrayList;

public class DiscountBill extends GroceryBill {

    public static void  main(String[] args){
        boolean preferred = true;
        DiscountBill bill = new DiscountBill(new Employee("clerk-1"), preferred);
        bill.add(new Item("vinegar", 4.18, 0.0));
        bill.add(new Item("soup", 2.50, 0.15));
        bill.add(new Item("rice", 3.0, 0.75));
        bill.add(new Item("coffee", 4.25, 0.25));
        bill.add(new Item("flour", 6.50, 2.25));

        double expected = 16.6421928536466;
        System.out.println(bill.getDiscountPercent());
    }

  private boolean regularCustomer;
  private ArrayList<Item> items = getItems();

  public DiscountBill(Employee clerk, boolean regularCustomer) {
    super(clerk);
    this.regularCustomer = regularCustomer;
  }

  public double getTotal() {
    if (!regularCustomer) return super.getTotal();
    else {
        return Math.round((super.getTotal() - getDiscountAmount())*100)/100.0 ;
    }
  }

  public int getDiscountCount() {

    int count = 0;

    for (Item item : items) {
      if (regularCustomer &&item.getDiscount() > 0) {
        count++;
      }
    }
    return count;
  }

  public double getDiscountAmount() {
    double amount = 0;
    if (!regularCustomer) {return 0;}
    for (Item item : items) {

      amount += item.getDiscount();
    }
      return Math.round(amount*100)/100.0;
  }

  public double getDiscountPercent() {
    return Math.round((100 - ((getTotal() * 100) / super.getTotal()))*1e13)/1e13;
  }
}
