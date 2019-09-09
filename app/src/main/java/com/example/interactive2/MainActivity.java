package com.example.interactive2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 1;
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


        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_CheckBox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox hasChocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = hasChocolateCheckBox.isChecked();

        //Storing the Name of Customer
        EditText nameField = findViewById(R.id.name_EditText);
        String name = nameField.getText().toString(); // Storing it in a Editable variable

        int price = calculatePrice(hasChocolate, hasWhippedCream);

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
        //calculatePrice(quantity, price2);


    }

    public void increment(View view) {

        quantity++;
        if (quantity >= 100)
        {
            displayQuantity(100);
            quantity = 100;
        }
        else
        {
            displayQuantity(quantity);
        }
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        if (quantity <= 1) {
            displayQuantity(1);
            quantity = 1;
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
    private int calculatePrice(boolean hasChocolate, boolean hasWhippedCream) {

        int basePrice = 5;

        if(hasChocolate == true)
        {
            basePrice += 2;
        }
        if (hasWhippedCream == true)
        {
            basePrice += 1;
        }
        int price = quantity * basePrice;
        return price;
    }


    /**
     * Create summary of the order.
     *
     * @param name is a varaiable which contains the name of customer
     * @param hasWhippedCream is whether or not the user wants whipped cream topping
     * @param hasChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */


    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream; // Added State of Boolean
        priceMessage += "\nAdd chocolate? " + hasChocolate;        // Added Choclate State
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
