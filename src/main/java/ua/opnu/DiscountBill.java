package ua.opnu;

import java.util.ArrayList;

public class DiscountBill extends GroceryBill {

  private boolean regularCustomer;
  private ArrayList<Item> items = getItems();

  public DiscountBill(Employee clerk, boolean regularCustomer) {
    super(clerk);
    this.regularCustomer = regularCustomer;
  }

  public double getTotal() {
    if (!regularCustomer) return super.getTotal();
    else {
      return super.getTotal() - getDiscountAmmount();
    }
  }

  public int getDiscountCount() {

    int count = 0;

    for (Item item : items) {
      if (item.getDiscount() > 0) {
        count++;
      }
    }
    return count;
  }

  public double getDiscountAmmount() {
    double ammount = 0;
    for (Item item : items) {
      ammount += item.getDiscount();
    }
    return ammount;
  }

  public double getDiscountPercent() {
    return 100 - ((getTotal() * 100) / super.getTotal());
  }
}
