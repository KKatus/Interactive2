package com.example.interactive2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

        String priceMessage = "Total: $ " + price;
        priceMessage = priceMessage + "\nThank you!";
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
        return 700;
    }


    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        /**priceTextView.setText("CHF "+number);**/
    }

}
