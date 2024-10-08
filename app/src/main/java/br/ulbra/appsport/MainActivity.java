package br.ulbra.appsport;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_IMC = 1;
    private RadioGroup radioGroupTamanhoPasso;
    private Button buttonCalcular, buttonCalcularIMC, buttonVerHistorico;
    private EditText edtPassos;
    private TextView txtR1, txtR2, txtHistorico;
    private CheckBox checkBoxCorrer;
    private double tamanhoPasso;
    private ArrayList<String> historico;
    private boolean imcCalculado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        historico = new ArrayList<>();
        setupListeners();
    }

    private void initializeViews() {
        radioGroupTamanhoPasso = findViewById(R.id.grupo);
        buttonCalcular = findViewById(R.id.btnCalcular);
        buttonCalcularIMC = findViewById(R.id.btnCalcularIMC);
        buttonVerHistorico = findViewById(R.id.btnVerHistorico);
        edtPassos = findViewById(R.id.edtPassos);
        txtR1 = findViewById(R.id.txtResultadoIMC);
        txtR2 = findViewById(R.id.txtR2);
        txtHistorico = findViewById(R.id.txtHistorico);
        checkBoxCorrer = findViewById(R.id.correr);
    }

    private void setupListeners() {
        buttonCalcularIMC.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalcularIMCActivity.class);
            startActivityForResult(intent, REQUEST_CODE_IMC);
        });

        buttonCalcular.setOnClickListener(v -> {
            if (!imcCalculado) {
                Snackbar.make(findViewById(R.id.root_layout), "Por favor, calcule o IMC primeiro.", Snackbar.LENGTH_SHORT).show();
                return;
            }
            calcularTamanhoPasso();
            calcularDistancia();
        });

        buttonVerHistorico.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoricoActivity.class);
            intent.putStringArrayListExtra("historico", historico);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMC && resultCode == RESULT_OK && data != null) {
            double imc = data.getDoubleExtra("resultadoIMC", 0);
            txtR1.setText(String.format("IMC recebido: %.2f", imc));
            imcCalculado = true;
            buttonCalcular.setEnabled(true);
            Snackbar.make(findViewById(R.id.root_layout), "IMC calculado com sucesso!", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void calcularTamanhoPasso() {
        int selectedId = radioGroupTamanhoPasso.getCheckedRadioButtonId();
        if (selectedId == R.id.curto) {
            tamanhoPasso = 0.5; // em metros
        } else if (selectedId == R.id.medio) {
            tamanhoPasso = 0.7; // em metros
        } else if (selectedId == R.id.longo) {
            tamanhoPasso = 1.0; // em metros
        } else {
            tamanhoPasso = 0.0; // Nenhum selecionado
        }
    }

    private void calcularDistancia() {
        String passosText = edtPassos.getText().toString();
        if (validarEntradas(passosText)) return;

        try {
            int quantidadePassos = Integer.parseInt(passosText);
            double distanciaMetros = quantidadePassos * tamanhoPasso;
            double distanciaKm = distanciaMetros / 1000.0;

            // Obter o IMC do TextView
            String imcTexto = txtR1.getText().toString();
            double imc = 0.0;

            // Tentar extrair o valor do IMC da String
            if (imcTexto.startsWith("IMC recebido:")) {
                String[] partes = imcTexto.split(": ");
                imc = Double.parseDouble(partes[1]);
            }

            String resultado = String.format("Distância total: %.2f metros (%.2f km).", distanciaMetros, distanciaKm);
            String historicoResultado = String.format("Passos: %d, Distância: %.2f metros", quantidadePassos, distanciaMetros);
            adicionarAoHistorico(historicoResultado);

            txtR1.setText(resultado);
            txtR2.setText(checkBoxCorrer.isChecked() ? "Você estava correndo!" : "Você não estava correndo.");

            Snackbar.make(findViewById(R.id.root_layout), "Cálculo realizado com sucesso!", Snackbar.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            txtR1.setText("Por favor, insira um número válido de passos.");
            txtR2.setText("");
        }
    }

    private boolean validarEntradas(String passosText) {
        if (passosText.isEmpty()) {
            txtR1.setText("Por favor, insira a quantidade de passos.");
            txtR2.setText("");
            return true;
        }
        return false;
    }

    private void adicionarAoHistorico(String resultado) {
        historico.add(resultado);
        atualizarHistorico();
    }

    private void atualizarHistorico() {
        if (!historico.isEmpty()) {
            txtHistorico.setText(historico.get(historico.size() - 1)); // Exibe apenas o último resultado
        }
        txtHistorico.setVisibility(View.VISIBLE);
    }
}
