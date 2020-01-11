package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    private CheckBox whippedCream;
    private CheckBox chocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        whippedCream = findViewById(R.id.whippedCream);
        chocolate = findViewById(R.id.chocolate);
    }

    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMassage = createOrderSummary(price);
        displayMassage(priceMassage);
    }

    private String createOrderSummary(int price) {
        String priceMassage =
                "Name: Marta";
        priceMassage = priceMassage + "\nToppings: ";
        if (whippedCream.isChecked()) {
            priceMassage = priceMassage + "\n\tAdd whipped cream";
        } else {
            priceMassage = priceMassage + "\n\tWithout whipped cream";
        }
        if(chocolate.isChecked()){
            priceMassage = priceMassage + "\n\tWith chocolate";
        } else {
            priceMassage = priceMassage + "\n\tWithout chocolate";
        }
        priceMassage = priceMassage + "\nQuantitty: " + quantity;
        priceMassage = priceMassage + "\nTotal price: " + "$" + price;
        priceMassage = priceMassage + "\nThank you!";

        return priceMassage;
    }

    private int calculatePrice() {
        return quantity * 5;
    }

    private void displayQuantity(int number) {
        TextView quantityView = findViewById(R.id.quantity_text_view);
        quantityView.setText("" + number);
    }

    private void displayMassage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.ORDER_SUMMARY_TEXT_VIEW);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
