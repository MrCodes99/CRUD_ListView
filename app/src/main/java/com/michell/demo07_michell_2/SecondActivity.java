package com.michell.demo07_michell_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by MICHELL on 27/05/2017.
 */

public class SecondActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etDNI, etEdad;
    private Button btActualizar, btEliminar;

    private final View.OnClickListener btRegistrarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.putExtra("nombre", etNombre.getText().toString());
            intent.putExtra("apellido", etApellido.getText().toString());
            intent.putExtra("dni", etDNI.getText().toString());
            intent.putExtra("edad", String.valueOf(etEdad.getText()));

            setResult(RESULT_OK, intent);
            finish();
        }
    };

    private final View.OnClickListener btActualizarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();

            intent.putExtra("nombre",etNombre.getText().toString());
            intent.putExtra("apellido",etApellido.getText().toString());
            intent.putExtra("dni",etDNI.getText().toString());
            intent.putExtra("edad",etEdad.getText().toString());

            setResult(RESULT_OK,intent);
            finish();
        }
    };

    private final View.OnClickListener btEliminarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
      Toast.makeText(SecondActivity.this, "DELETE", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        etNombre = (EditText) findViewById(R.id.etSecondNombre);
        etApellido = (EditText) findViewById(R.id.etSecondApellido);
        etDNI = (EditText) findViewById(R.id.etSecondDocument);
        etEdad = (EditText) findViewById(R.id.etSecondEdad);

        btActualizar = (Button) findViewById(R.id.btSecondActualizar);
        btEliminar = (Button) findViewById(R.id.btSecondEliminar);

        Intent intent= getIntent();

        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        String dni = intent.getStringExtra("dni");
        String edad = intent.getStringExtra("edad");

        etNombre.setText(nombre);
        etApellido.setText(apellido);
        etDNI.setText(dni);
        etEdad.setText(edad);

        if(nombre == null || nombre.equals("")) {
            btActualizar.setText("REGISTRAR");
        }

        btActualizar.setOnClickListener(btActualizarOnClickListener);
        btEliminar.setOnClickListener(btEliminarOnClickListener);


    }
}
