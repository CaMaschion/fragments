package com.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

import com.fragments.R;
import com.fragments.fragment.ContatosFragment;
import com.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContato = findViewById(R.id.buttonContato);
        buttonConversa = findViewById(R.id.buttonConversas);

        //remover sobre da actionbar
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();
        //configurar objeto para fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // primeiro paramentro = onde quero exibir
        //segundo paramentro = o que quero exibir
        transaction.replace(R.id.frameConteudo, conversasFragment);
        transaction.commit(); //encerrar transação

        //configurar click do botao para carregar o fragment
        buttonContato.setOnClickListener(v -> {

            contatosFragment = new ContatosFragment();

            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.frameConteudo, contatosFragment);
            transaction1.commit();
        });

        buttonConversa.setOnClickListener(v -> {

            conversasFragment = new ConversasFragment();

            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            transaction1.replace(R.id.frameConteudo, conversasFragment);
            transaction1.commit();
        });

    }
}