package com.example.projetointent_implicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String
            VALUE01 = "com.example.projetointent_implicita.VALUE01",
            VALUE02 ="com.example.projetointent_implicita.VALUE02",
            VALUE03 = "com.example.projetointent_implicita.VALUE03";

    EditText edtValorTextual;
    CheckBox chkValorBinario;
    RadioGroup rdgGrupoOpcao;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtValorTextual = (EditText) findViewById(R.id.edtValorTextual);
        chkValorBinario = (CheckBox) findViewById(R.id.chkValorBinario);
        rdgGrupoOpcao = (RadioGroup) findViewById(R.id.rdgGrupoOpcao);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOnClick(view);
            }
        });

    }

    public void btnOnClick(View view)
    {
        boolean invalid = false;
        String value01 = null;
        if(!edtValorTextual.getText().toString().isEmpty())
        {
            value01 = edtValorTextual.getText().toString();
        }else
        {
            invalid = true;
        };
        boolean value02 = chkValorBinario.isChecked();
        int value03 = 0;
        switch (rdgGrupoOpcao.getCheckedRadioButtonId())
        {
            case R.id.rdbValorOpcao01: value03 = 1; break;
            case R.id.rdbValorOpcao02: value03 = 2; break;
            default: invalid = true;
        }

        if(!invalid)
        {
            Intent mIntent = new Intent(this, SecondActivity.class);
            mIntent.putExtra(VALUE01, value01);//string
            mIntent.putExtra(VALUE02, value02);//bool
            mIntent.putExtra(VALUE03, value03);//int
            startActivity(mIntent);
        }
        else
        {
            Toast.makeText(this,"Preencha de  forma válida!!", Toast.LENGTH_LONG).show();
        }
    }


}