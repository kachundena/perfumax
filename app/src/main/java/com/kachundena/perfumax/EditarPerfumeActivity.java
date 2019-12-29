package com.kachundena.perfumax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kachundena.perfumax.controllers.PerfumesController;
import com.kachundena.perfumax.modelos.Perfume;

public class EditarPerfumeActivity extends AppCompatActivity {
    private EditText etEditarNombre, etEditarMarca;
    private Button btnGuardarCambios, btnCancelarEdicion;
    private Perfume perfume;
    private PerfumesController perfumesController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfume);

        // Recuperar datos que enviaron
        Bundle extras = getIntent().getExtras();
        // Si no hay datos (cosa rara) salimos
        if (extras == null) {
            finish();
            return;
        }
        // Instanciar el controlador de los perfumes
        perfumesController = new PerfumesController(EditarPerfumeActivity.this);

        // Rearmar el perfume
        // Nota: igualmente solamente podríamos mandar el id y recuperar el perfume de la BD
        int idPerfume = extras.getInt("idPerfume");
        String denoPerfume = extras.getString("nombrePerfume");
        String detallePerfume = extras.getString("detallePerfume");
        perfume = new Perfume(idPerfume, denoPerfume, detallePerfume);


        // Ahora declaramos las vistas
        etEditarNombre = findViewById(R.id.etEditarNombre);
        etEditarMarca = findViewById(R.id.etEditarMarca);
        btnCancelarEdicion = findViewById(R.id.btnCancelarEdicionPerfume);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambiosPerfume);


        // Rellenar los EditText con los datos de la tarea
        etEditarNombre.setText(String.valueOf(perfume.getNombre()));
        etEditarMarca.setText(perfume.getMarca());

        // Listener del click del botón para salir, simplemente cierra la actividad
        btnCancelarEdicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Listener del click del botón que guarda cambios
        btnGuardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remover previos errores si existen
                etEditarNombre.setError(null);
                etEditarMarca.setError(null);
                // Crear la task con los nuevos cambios pero ponerle
                // el id de la anterior
                String nuevoNombre = etEditarNombre.getText().toString();
                String nuevoMarca = etEditarMarca.getText().toString();
                if (nuevoNombre.isEmpty()) {
                    etEditarNombre.setError("Escribe el nombre");
                    etEditarNombre.requestFocus();
                    return;
                }
                if (nuevoMarca.isEmpty()) {
                    etEditarMarca.setError("Escribe la marca");
                    etEditarMarca.requestFocus();
                    return;
                }
                // Si llegamos hasta aquí es porque los datos ya están validados
                Perfume perfumeConNuevosCambios = new Perfume(perfume.getPerfume_id(), nuevoNombre, nuevoMarca);
                int filasModificadas = perfumesController.guardarCambios(perfumeConNuevosCambios);
                if (filasModificadas != 1) {
                    // De alguna forma ocurrió un error porque se debió modificar únicamente una fila
                    Toast.makeText(EditarPerfumeActivity.this, "Error guardando cambios. Intente de nuevo.", Toast.LENGTH_SHORT).show();
                } else {
                    // Si las cosas van bien, volvemos a la principal
                    // cerrando esta actividad
                    finish();
                }
            }
        });
    }
}
