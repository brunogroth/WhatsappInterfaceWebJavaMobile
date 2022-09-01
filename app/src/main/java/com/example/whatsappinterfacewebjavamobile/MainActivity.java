package com.example.whatsappinterfacewebjavamobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Console;
import java.util.EventListener;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonSend;
    private EditText editTextNumber;
    private TextInputEditText TextInputMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instance
        buttonSend = findViewById(R.id.buttonSend);
        editTextNumber = findViewById(R.id.editTextNumber);
        TextInputMessage = findViewById(R.id.TextInputMessage);

        //Listener do botão, estrutura de callback para ocorrer algo quando tiver ação no botão
        buttonSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String text = TextInputMessage.getText().toString();
                        String number = editTextNumber.getText().toString();

                        String url = LinkWhatsapp(text, number);

                        openWebPage(url);

                    }
                }
        );
    }

    public String LinkWhatsapp(String text, String number) {
        text = text.replace(" ", "%20");

        if(number.length() <= 11) {
            number = number.replace(number, "55" + number);
        }
            String result = "https://wa.me/"+number+"?text="+text;
        return result;

    }
    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
    }
}