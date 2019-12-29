package com.kachundena.perfumax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kachundena.perfumax.controllers.PerfumesController;
import com.kachundena.perfumax.modelos.Perfume;


public class AgregarPerfumeActivity extends AppCompatActivity {
    private Button btnAgregarPerfume, btnCancelarNuevoPerfume;
    private EditText etNombre, etMarca;
    private PerfumesController perfumesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_perfume);

        // Instanciar vistas
        etNombre = findViewById(R.id.etNombre);
        etMarca = findViewById(R.id.etMarca);
        btnAgregarPerfume = findViewById(R.id.btnAgregarPerfume);
        btnCancelarNuevoPerfume = findViewById(R.id.btnCancelarNuevoPerfume);
        // Crear el controlador
        perfumesController = new PerfumesController(AgregarPerfumeActivity.this);

        // Agregar listener del botón de guardar
        btnAgregarPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Resetear errores a ambos
                etNombre.setError(null);
                etMarca.setError(null);
                String nombre = etNombre.getText().toString(),
                        marca = etMarca.getText().toString();
                if ("".equals(nombre)) {
                    etNombre.setError("Escribe el nombre del perfume");
                    etNombre.requestFocus();
                    return;
                }
                if ("".equals(marca)) {
                    etMarca.setError("Escribe la marca del perfume");
                    etMarca.requestFocus();
                    return;
                }

                // Ya pasó la validación
                Perfume nuevoPerfume = new Perfume(nombre, marca);

                long id = perfumesController.nuevoPerfume(nuevoPerfume);
                if (id == -1) {
                    // De alguna manera ocurrió un error
                    Toast.makeText(AgregarPerfumeActivity.this, "Error al guardar. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                } else {
                    // Terminar
                    finish();
                }
            }
        });

        // El de cancelar simplemente cierra la actividad
        btnCancelarNuevoPerfume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
