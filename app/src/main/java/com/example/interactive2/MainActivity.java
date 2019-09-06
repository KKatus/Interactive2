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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**

     This method is called when the order button is clicked.
     */
    public void submitOrder(View view){
        display(quantity);
        displayPrice(quantity * 5);

    }
    public void increment(View view){

        quantity ++;
        display(quantity);
    }
    public void decrement(View view){
        quantity --;
        if (quantity <=0)
        {
            display(0);
            quantity = 0;
        }
        else
        {
            display(quantity);
        }
        /**display(quantity);*/
    }


    /**

     This method displays the given quantity value on the screen.
     */
    private void display(int nummber){
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+nummber);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
