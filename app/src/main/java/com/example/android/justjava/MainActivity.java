package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity;
    private CheckBox boxWhippedCream;
    private CheckBox boxChocolate;
    EditText nameField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxWhippedCream = findViewById(R.id.whippedCream);
        boxChocolate = findViewById(R.id.chocolate);
        nameField = findViewById(R.id.name);
    }

    public void submitOrder(View view) {
        String name = nameField.getText().toString();
        boolean hasWhippedCream = boxWhippedCream.isChecked();
        boolean hasChocolate = boxChocolate.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMassage = createOrderSummary(name, price);
        displayMassage(priceMassage);
    }

    private String createOrderSummary(String name, int price) {
        String priceMassage =
                "\nName:  " + name;
        priceMassage = priceMassage + "\nToppings: ";

        if (boxWhippedCream.isChecked()) {
            priceMassage = priceMassage + "\n\tWith whipped cream";
        } else {
            priceMassage = priceMassage + "\n\tWithout whipped cream";
        }

        if (boxChocolate.isChecked()) {
            priceMassage = priceMassage + "\n\tWith chocolate";
        } else {
            priceMassage = priceMassage + "\n\tWithout chocolate";
        }

        priceMassage = priceMassage + "\nQuantity: " + quantity;
        priceMassage = priceMassage + "\nTotal price: " + "$" + price;
        priceMassage = priceMassage + "\nThank you!";

        return priceMassage;
    }

    private int calculatePrice(boolean whippedCream, boolean chocolate) {
        int basePrice = 5;

        if (whippedCream) {
            basePrice = basePrice + 1;
        }

        if (chocolate) {
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }

    private void displayQuantity(int number) {
        TextView quantityView = findViewById(R.id.quantity_text_view);
        quantityView.setText(" " + number);
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
        if (quantity == 1) {
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
}
