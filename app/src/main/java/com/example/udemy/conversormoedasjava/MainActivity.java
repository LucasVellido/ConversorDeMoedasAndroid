package com.example.udemy.conversormoedasjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        /*1º maneira para evento de click*/
        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

        /*2º maneira para evento de click. Esse metodo fica escutando o click do botão*/
//        this.mViewHolder.buttonCalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    /*1º maneira para evento de click*/
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button_calculate) {

            String value = this.mViewHolder.editValue.getText().toString();

            if (value.isEmpty()) {

                //Mostrar uma mensagem para o usuário
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(value);

                this.mViewHolder.textDolar.setText(String.format("%.2f",real / 4));
                this.mViewHolder.textEuro.setText(String.format("%.2f",real / 5));
            }

        }

    }

    /*3º maneira para evento de click. tem que colocar um android:onClick="teste" para chamar esse carinha */
//    public void teste(View view) {
//    }


    /*Esse metodo serve para não ficar chamando os componentes mais de uma vez*/
    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
