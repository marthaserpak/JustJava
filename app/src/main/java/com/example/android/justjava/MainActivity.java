package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        /*display(quantity);
        displayPrice(quantity * 10);*/
        String priceMassage = "Total price: " + "$" + quantity*8
              +  "\nThank you!";
        displayMassage(priceMassage);
    }

    private void display(int number) {
        TextView quantityView = findViewById(R.id.quantity_text_view);
        quantityView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance()
                .format(number));
    }

    private void displayMassage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if(quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }
}
