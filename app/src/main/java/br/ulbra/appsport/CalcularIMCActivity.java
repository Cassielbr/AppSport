package br.ulbra.appsport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcularIMCActivity extends Activity {
    private EditText edtPeso, edtAltura;
    private Button btnCalcularIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcularIMC = findViewById(R.id.btnCalcularIMC);

        btnCalcularIMC.setOnClickListener(v -> calcularIMC());
    }

    private void calcularIMC() {
        String pesoText = edtPeso.getText().toString();
        String alturaText = edtAltura.getText().toString();

        if (pesoText.isEmpty() || alturaText.isEmpty()) {
            setResult(RESULT_CANCELED);
            finish();
            return;
        }

        double peso = Double.parseDouble(pesoText);
        double altura = Double.parseDouble(alturaText);
        double imc = peso / (altura * altura);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("resultadoIMC", imc);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
