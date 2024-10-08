package br.ulbra.appsport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity {
    private TextView txtHistorico;
    private Button btnLimparHistorico, btnVoltar;
    private ArrayList<String> historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        initializeViews();
        carregarHistorico();
    }

    private void initializeViews() {
        txtHistorico = findViewById(R.id.txtHistorico);
        btnLimparHistorico = findViewById(R.id.btnLimparHistorico);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnLimparHistorico.setOnClickListener(v -> limparHistorico());
        btnVoltar.setOnClickListener(v -> finish());
    }

    private void carregarHistorico() {
        historico = getIntent().getStringArrayListExtra("historico");
        atualizarHistoricoDisplay();
    }

    private void atualizarHistoricoDisplay() {
        if (historico != null && !historico.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String registro : historico) {
                sb.append(registro).append("\n");
            }
            txtHistorico.setText(sb.toString());
        } else {
            txtHistorico.setText("Nenhum histórico encontrado.");
        }
    }

    private void limparHistorico() {
        if (historico != null) {
            historico.clear();
            txtHistorico.setText("Nenhum histórico encontrado.");
        }
    }
}
