package com.kachundena.perfumax;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kachundena.perfumax.controllers.PerfumesController;
import com.kachundena.perfumax.modelos.Perfume;

import java.util.HashMap;

public class EditarPerfumeActivity extends AppCompatActivity {
    private EditText etEditarNombre, etEditarMarca;
    private Spinner spArea;
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

        // Poner valores a los desplegables
        // Area
        spArea = (Spinner)findViewById(R.id.spArea);
        HashMap<Integer, String> hmArea = new HashMap();
        Resources res = getResources();
        String[] arszArea = res.getStringArray(R.array.array_area);
        for (int i = 0; i < arszArea.length; i++) {
            hmArea.put(i,arszArea[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszArea);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spArea.setAdapter(adapter);



        // Rearmar el perfume
        // Nota: igualmente solamente podríamos mandar el id y recuperar el perfume de la BD
        int perfumeid = extras.getInt("perfumeid");
        String nombre = extras.getString("nombre");
        String marca = extras.getString("marca");
        // buscar perfume a partir del perfumeid
        perfume = perfumesController.obtenerPerfume(perfumeid);


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
