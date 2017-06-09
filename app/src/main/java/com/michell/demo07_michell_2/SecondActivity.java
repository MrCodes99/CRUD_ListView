package com.michell.demo07_michell_2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
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

    private final View.OnClickListener btActualizarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent();

            String name = etNombre.getText().toString();
            String ape = etApellido.getText().toString();
            String dni = etDNI.getText().toString();
            String edad = etEdad.getText().toString();

            if (TextUtils.isEmpty(name)) {
                Toast.makeText(SecondActivity.this, "El nombre esta vacio", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                intent.putExtra("nombre", etNombre.getText().toString());
            }

            if (TextUtils.isEmpty(ape)) {
                Toast.makeText(SecondActivity.this, "El apellido esta vacio", Toast.LENGTH_LONG).show();
                return;
            }

            else {
                intent.putExtra("apellido", etApellido.getText().toString());
            }


            if (TextUtils.isEmpty(dni)) {
                Toast.makeText(SecondActivity.this, "El DNI esta vacio", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                intent.putExtra("dni", etDNI.getText().toString());
            }

            if (TextUtils.isEmpty(edad)) {
                Toast.makeText(SecondActivity.this, "La edad esta vacio", Toast.LENGTH_LONG).show();
                return;
            }
            else {
                intent.putExtra("edad", etEdad.getText().toString());
            }

            /*
            intent.putExtra("nombre",etNombre.getText().toString());
            intent.putExtra("apellido",etApellido.getText().toString());
            intent.putExtra("dni",etDNI.getText().toString());
            intent.putExtra("edad",etEdad.getText().toString());
            */

            setResult(RESULT_OK,intent);
            finish();
        }
    };

    private final View.OnClickListener btEliminarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
            builder.setTitle("Mensaje");
            builder.setMessage("¿Desea eliminar?");

            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int witch) {

                    Intent intent = new Intent();

                    intent.putExtra("nombre",etNombre.getText().toString());
                    intent.putExtra("apellido",etApellido.getText().toString());
                    intent.putExtra("dni",etDNI.getText().toString());
                    intent.putExtra("edad",etEdad.getText().toString());

                    setResult(10,intent);
                    finish();

                    Toast.makeText(SecondActivity.this, "REGISTRO ELIMINADO", Toast.LENGTH_SHORT).show();


                }
            });

            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int witch) {
                    Toast.makeText(SecondActivity.this, "Canceló operación", Toast.LENGTH_SHORT).show();
                }
            });

            builder.show();

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
            btEliminar.setEnabled(false);
        }

        btActualizar.setOnClickListener(btActualizarOnClickListener);
        btEliminar.setOnClickListener(btEliminarOnClickListener);


    }
}