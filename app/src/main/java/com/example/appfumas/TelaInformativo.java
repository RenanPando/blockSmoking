package com.example.appfumas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class TelaInformativo extends AppCompatActivity {
    TextView txtInfo, txtTitulo, txtTitulo2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_BlockSmokingSecondary);
        setContentView(R.layout.activity_tela_informativo);
        txtInfo = findViewById(R.id.txtInfo);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtTitulo2 = findViewById(R.id.txtTitulo2);
        b = findViewById(R.id.botaoAvançar);
        txtTitulo2.setVisibility(View.GONE);
    }

    public void mudarTexto(View v) {
        txtTitulo.setVisibility(View.GONE);
        txtTitulo2.setVisibility(View.VISIBLE);
        txtInfo.setText(HtmlCompat.fromHtml("<strong>Após 20 minutos,</strong> a pressão sanguínea e a pulsação voltam ao normal.<br><br><strong>Após 2 horas,</strong> não há mais nicotina circulando no sangue.<br><br><strong>Após 8 horas,</strong> o nível de oxigênio no sangue se normaliza.<br><br><strong>Após 12 a 24 horas,</strong> os pulmões já funcionam melhor.<br><br><strong>Após 2 dias,</strong> o olfato já percebe melhor os cheiros, e o paladar já degusta melhor a comida.<br><br><strong>Após 3 semanas,</strong> a respiração se torna mais fácil, e a circulação melhora.<br><br><strong>Após 1 ano,</strong> o risco de morte por infarto do miocárdio é reduzido à metade.<br><br><strong>Após 10 anos,</strong> o risco de sofrer infarto será igual ao das pessoas que nunca fumaram", Html.FROM_HTML_MODE_LEGACY));
        txtInfo.setTextSize(16);
        txtInfo.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        b.setOnClickListener(this::mudarTela);
    }

    public void mudarTela(View v) {
        startActivity(new Intent(this, Termos.class));
    }
}