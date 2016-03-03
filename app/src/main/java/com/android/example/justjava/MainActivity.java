package com.android.example.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */


public class MainActivity extends ActionBarActivity {

    int numberOfCoffees = 0;
    private String name;
    private boolean withMilk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String name = getName();
        int price = calculatePrice(numberOfCoffees);
        boolean withMilk = isWithMilk();
        displayOrderSummary(name, price, withMilk);
    }

    public String getName() {
        EditText editTextName = (EditText) findViewById(R.id.edit_text_name);
        return editTextName.getText().toString();
    }

    private int calculatePrice(int number) {
        return 5 * number;
    }

    public boolean isWithMilk() {
        CheckBox checkBoxWithMilk = (CheckBox) findViewById(R.id.checkbox_with_milk);
        return checkBoxWithMilk.isChecked();
    }

    private void displayOrderSummary(String name, int price, boolean withMilk) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);

        String orderSummary = "Name: " + name;
        if (withMilk) {
            orderSummary += "\nYour " + numberOfCoffees + " coffees with milk is ready!";
        } else {
            orderSummary += "\nYour " + numberOfCoffees + " coffees without milk is ready";
        }
        orderSummary += "\nPrice: $" + price;
        orderSummary += "\nThank you!";

        orderSummaryTextView.setText(orderSummary);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view) {
        numberOfCoffees++;
        displayQuantity(numberOfCoffees);
    }

    public void decrement(View view) {
        numberOfCoffees--;
        displayQuantity(numberOfCoffees);
    }
}
