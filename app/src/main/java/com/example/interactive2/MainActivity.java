package com.example.interactive2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    //int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        int price = calculatePrice();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_CheckBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if (hasWhippedCream == true) {  //If checkbox is checked
            price += 2;                 //Price rises + 2
        }


        String priceMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);
        //calculatePrice(quantity, price2);


    }

    public void increment(View view) {

        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        if (quantity <= 0) {
            displayQuantity(0);
            quantity = 0;
        } else {
            displayQuantity(quantity);
        }
        /**display(quantity);*/
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }


    /**
     * Create summary of the order.
     *
     * @param price of order
     * @return text summary
     */


    private String createOrderSummary(int price, boolean hasWhippedCream) {
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream; // Added State of Boolean
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $ " + price;
        priceMessage += "\nThank you!!";
        return priceMessage;

    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


}
