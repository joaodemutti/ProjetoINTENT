package com.example.projetointent_implicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SecondActivity extends AppCompatActivity {

    EditText edtValorTextual;
    CheckBox chkValorBinario;
    RadioGroup rdgGrupoOpcao;
    RadioButton rBtn1,rBtn2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValorTextual = (EditText) findViewById(R.id.edtValorTextual);
        chkValorBinario = (CheckBox) findViewById(R.id.chkValorBinario);
        rdgGrupoOpcao = (RadioGroup) findViewById(R.id.rdgGrupoOpcao);
        rBtn1 = (RadioButton) rdgGrupoOpcao.getChildAt(0);
        rBtn2 = (RadioButton) rdgGrupoOpcao.getChildAt(1);
        btn = (Button) findViewById(R.id.button);

        Intent mIntent = getIntent();
        Bundle extras = mIntent.getExtras();

        String value01 = extras.getString(MainActivity.VALUE01);//string
        boolean value02 = extras.getBoolean(MainActivity.VALUE02);//bool
        int value03 = extras.getInt(MainActivity.VALUE03);//int

        edtValorTextual.setEnabled(false);
        chkValorBinario.setEnabled(false);
        rBtn1.setEnabled(false);
        rBtn2.setEnabled(false);

        edtValorTextual.setText(value01);
        chkValorBinario.setChecked(value02);
        if(value03==1)
        {
            rBtn1.setChecked(true);
        }else
        {
            rBtn2.setChecked(true);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnOnClick(view);
            }
        });
    }

    public void btnOnClick(View view) {
        Intent mIntent = new Intent(this, MainActivity.class);
        startActivity(mIntent);
    }

}
