package com.kachundena.perfumax;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kachundena.perfumax.controllers.PerfumesController;
import com.kachundena.perfumax.modelos.Perfume;

import java.util.HashMap;

public class EditarPerfumeActivity extends AppCompatActivity {
    private EditText etNombre, etMarca, etAcordes, etNotaPredominante;
    private EditText etNotasSalida, etNotasCorazon, etNotasFondo;
    private EditText etClon, etID;
    private Spinner spArea, spOpiniones, spListaDeseos, spFamilia;
    private Spinner spEstela, spDuracion, spValoracion, spPrioridad;
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

        // Opiniones
        spOpiniones = (Spinner)findViewById(R.id.spOpiniones);
        HashMap<Integer, String> hmOpiniones = new HashMap();
        String[] arszOpiniones = res.getStringArray(R.array.array_opiniones);
        for (int i = 0; i < arszOpiniones.length; i++) {
            hmOpiniones.put(i,arszOpiniones[i]);
        }
        ArrayAdapter<String> adapterOpiniones = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszOpiniones);
        adapterOpiniones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOpiniones.setAdapter(adapterOpiniones);

        // Lista Deseos
        spListaDeseos = (Spinner)findViewById(R.id.spListaDeseos);
        HashMap<Integer, String> hmListaDeseos = new HashMap();
        String[] arszListaDeseos = res.getStringArray(R.array.array_lista_deseos);
        for (int i = 0; i < arszListaDeseos.length; i++) {
            hmListaDeseos.put(i,arszListaDeseos[i]);
        }
        ArrayAdapter<String> adapterListaDeseos = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszListaDeseos);
        adapterListaDeseos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spListaDeseos.setAdapter(adapterListaDeseos);

        // Familia
        spFamilia = (Spinner)findViewById(R.id.spFamilia);
        HashMap<Integer, String> hmFamilia = new HashMap();
        String[] arszFamilia = res.getStringArray(R.array.array_familia);
        for (int i = 0; i < arszFamilia.length; i++) {
            hmFamilia.put(i,arszFamilia[i]);
        }
        ArrayAdapter<String> adapterFamilia = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszFamilia);
        adapterFamilia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFamilia.setAdapter(adapterFamilia);

        // Estela
        spEstela = (Spinner)findViewById(R.id.spEstela);
        HashMap<Integer, String> hmEstela = new HashMap();
        String[] arszEstela = res.getStringArray(R.array.array_estela);
        for (int i = 0; i < arszEstela.length; i++) {
            hmEstela.put(i,arszEstela[i]);
        }
        ArrayAdapter<String> adapterEstela = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszEstela);
        adapterEstela.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstela.setAdapter(adapterEstela);

        // Valoracion
        spValoracion = (Spinner)findViewById(R.id.spValoracion);
        HashMap<Integer, String> hmValoracion = new HashMap();
        String[] arszValoracion = res.getStringArray(R.array.array_valoracion);
        for (int i = 0; i < arszValoracion.length; i++) {
            hmValoracion.put(i,arszValoracion[i]);
        }
        ArrayAdapter<String> adapterValoracion = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszValoracion);
        adapterValoracion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spValoracion.setAdapter(adapterValoracion);

        // Duracion
        spDuracion = (Spinner)findViewById(R.id.spDuracion);
        HashMap<Integer, String> hmDuracion = new HashMap();
        String[] arszDuracion = res.getStringArray(R.array.array_duracion);
        for (int i = 0; i < arszDuracion.length; i++) {
            hmDuracion.put(i,arszDuracion[i]);
        }
        ArrayAdapter<String> adapterDuracion = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszDuracion);
        adapterDuracion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDuracion.setAdapter(adapterDuracion);

        // Prioridad
        spPrioridad = (Spinner)findViewById(R.id.spPrioridad);
        HashMap<Integer, String> hmPrioridad = new HashMap();
        String[] arszPrioridad = res.getStringArray(R.array.array_prioridad);
        for (int i = 0; i < arszPrioridad.length; i++) {
            hmPrioridad.put(i,arszPrioridad[i]);
        }
        ArrayAdapter<String> adapterPrioridad = new ArrayAdapter<String>(EditarPerfumeActivity.this, android.R.layout.simple_spinner_item, arszPrioridad);
        adapterPrioridad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPrioridad.setAdapter(adapterPrioridad);



        // Rearmar el perfume
        // Nota: igualmente solamente podríamos mandar el id y recuperar el perfume de la BD
        int perfumeid = extras.getInt("perfumeid");
        String nombre = extras.getString("nombre");
        String marca = extras.getString("marca");
        // buscar perfume a partir del perfumeid
        perfume = perfumesController.obtenerPerfume(perfumeid);


        // Ahora declaramos las vistas
        etNombre = findViewById(R.id.etNombre);
        etMarca = findViewById(R.id.etMarca);
        etAcordes = findViewById(R.id.etAcordes);
        etNotaPredominante = findViewById(R.id.etNotaPredominante);
        etNotasSalida = findViewById(R.id.etNotasSalida);
        etNotasCorazon = findViewById(R.id.etNotasCorazon);
        etNotasFondo = findViewById(R.id.etNotasFondo);
        etClon = findViewById(R.id.etClon);
        etID = findViewById(R.id.tvPerfumeId);
        btnCancelarEdicion = findViewById(R.id.btnCancelarEdicionPerfume);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambiosPerfume);


        // Rellenar los EditText con los datos del perfume
        if (perfume.getNombre() != null)
            etNombre.setText(String.valueOf(perfume.getNombre()));
        if (perfume.getMarca() != null)
            etMarca.setText(perfume.getMarca());
        if (perfume.getAcordes() != null)
            etAcordes.setText(perfume.getAcordes());
        if (perfume.getNota_predominante() != null)
            etNotaPredominante.setText(perfume.getNota_predominante());
        if (perfume.getNotas_salida() != null)
            etNotasSalida.setText(perfume.getNotas_salida());
        if (perfume.getNotas_corazon() != null)
            etNotasCorazon.setText(perfume.getNotas_corazon());
        if (perfume.getNotas_fondo() != null)
            etNotasFondo.setText(perfume.getNotas_fondo());
        if (perfume.getClon() != null)
            etClon.setText(perfume.getClon());
        etID.setText(Integer.toString(perfume.getPerfume_id()));

        spArea.setSelection(perfume.getArea());
        spOpiniones.setSelection(perfume.getOpiniones());
        spListaDeseos.setSelection(perfume.getLista_deseos());
        spPrioridad.setSelection(perfume.getPrioridad() + 1);
        spEstela.setSelection(perfume.getEstela());
        spDuracion.setSelection(perfume.getDuracion());
        spValoracion.setSelection(perfume.getValoracion());
        spFamilia.setSelection(perfume.getFamilia());

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
                etNombre.setError(null);
                etMarca.setError(null);
                // Crear la task con los nuevos cambios pero ponerle
                // el id de la anterior
                String nuevoNombre = etNombre.getText().toString();
                String nuevoMarca = etMarca.getText().toString();
                if (nuevoNombre.isEmpty()) {
                    etNombre.setError("Escribe el nombre");
                    etNombre.requestFocus();
                    return;
                }
                if (nuevoMarca.isEmpty()) {
                    etMarca.setError("Escribe la marca");
                    etMarca.requestFocus();
                    return;
                }
                // Si llegamos hasta aquí es porque los datos ya están validados
                Perfume perfumeConNuevosCambios = new Perfume();
                perfumeConNuevosCambios.setPerfume_id(Integer.parseInt(etID.getText().toString()));
                perfumeConNuevosCambios.setNombre(nuevoNombre);
                perfumeConNuevosCambios.setMarca(nuevoMarca);
                perfumeConNuevosCambios.setOpiniones(spOpiniones.getSelectedItemPosition());
                perfumeConNuevosCambios.setLista_deseos(spListaDeseos.getSelectedItemPosition());
                perfumeConNuevosCambios.setPrioridad(spPrioridad.getSelectedItemPosition() - 1);
                perfumeConNuevosCambios.setFamilia(spFamilia.getSelectedItemPosition());
                perfumeConNuevosCambios.setAcordes(etAcordes.getText().toString());
                perfumeConNuevosCambios.setNota_predominante(etNotaPredominante.getText().toString());
                perfumeConNuevosCambios.setNotas_salida(etNotasSalida.getText().toString());
                perfumeConNuevosCambios.setNotas_corazon(etNotasCorazon.getText().toString());
                perfumeConNuevosCambios.setNotas_fondo(etNotasFondo.getText().toString());
                perfumeConNuevosCambios.setClon(etClon.getText().toString());
                perfumeConNuevosCambios.setEstela(spEstela.getSelectedItemPosition());
                perfumeConNuevosCambios.setDuracion(spDuracion.getSelectedItemPosition());
                perfumeConNuevosCambios.setValoracion(spValoracion.getSelectedItemPosition());
                perfumeConNuevosCambios.setArea(spArea.getSelectedItemPosition());

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
