package com.example.appfumas.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.appfumas.Classes.Registros;
import com.example.appfumas.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class FragmentRegistros extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AutoCompleteTextView actv1, actv2;
    RadioButton rFeliz, rTriste;
    int qtdFumo, reaisGastos;
    String sentimento = "padrão";
    Button bRegistrar;

    // TODO: Rename and change types of parameters

    public FragmentRegistros() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registros, container, false);
        bRegistrar = view.findViewById(R.id.bRegistrar);
        rFeliz = view.findViewById(R.id.rFeliz);
        rTriste = view.findViewById(R.id.rTriste);
        actv1 = view.findViewById(R.id.actvQtd);
        actv2 = view.findViewById(R.id.actvGastos);

        //adapters
        String[] qtd = getResources().getStringArray(R.array.qtd);
        String[] reais = getResources().getStringArray(R.array.reais);
        ArrayAdapter adapterQ = new ArrayAdapter(getActivity(), R.layout.dropdown_menu, qtd);
        ArrayAdapter adapterR = new ArrayAdapter(getActivity(), R.layout.dropdown_menu, reais);
        actv1.setAdapter(adapterQ);
        actv2.setAdapter(adapterR);
        actv1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                qtdFumo = Integer.parseInt(String.valueOf(parent.getItemAtPosition(position)));
            }
        });

        actv2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                reaisGastos = Integer.parseInt(String.valueOf(parent.getItemAtPosition(position)));
            }
        });
        bRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rFeliz.isChecked()) {
                    sentimento = "feliz";
                } else if (rTriste.isChecked()) {
                    sentimento = "triste";
                }

                if (reaisGastos == 0 || qtdFumo == 0) {
                    Toast.makeText(getActivity(), "Preencha todos os campos corretamente para realizar o registro", Toast.LENGTH_SHORT).show();
                } else {
                    if(qtdFumo > 10){
                        AlertDialog.Builder alerta = new AlertDialog.Builder(getActivity());
                        alerta.setMessage("Nosso sistema detectou que você atingiu um número superior ao número considerado como uso excessivo em nosso aplicativo.\n\nFique atento com o seu consumo de tabaco diário!");
                        alerta.setTitle("AVISO");
                        alerta.setNeutralButton("OK", null);
                        alerta.show();
                    }
                    Registros r = new Registros(qtdFumo, reaisGastos, sentimento);
                    r.realizarRegistro();
                    Toast.makeText(getActivity(), "Registro realizado com sucesso", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

}