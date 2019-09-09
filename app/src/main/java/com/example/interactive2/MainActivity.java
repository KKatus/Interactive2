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

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_CheckBox);
        boolean addWhippedCream = whippedCreamCheckBox.isChecked();
        if (addWhippedCream == true) {  //If checkbox is checked
            price += 2;                 //Price rises + 2
        }

        // Figure out if the user wants chocolate topping
        CheckBox hasChocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean addChocolate = hasChocolateCheckBox.isChecked();
        if (addChocolate == true){      //If checkbox is checked
            price += 2;                 //Price rises + 2
        }

        //Storing the Name of Customer
        EditText nameField = findViewById(R.id.name_EditText);
        String name = nameField.getText().toString(); // Storing it in a Editable variable

        String priceMessage = createOrderSummary(price, addWhippedCream, addChocolate, name);
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
     * @param name is a varaiable which contains the name of customer
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */


    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream? " + addWhippedCream; // Added State of Boolean
        priceMessage += "\nAdd chocolate? " + addChocolate;        // Added Choclate State
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
