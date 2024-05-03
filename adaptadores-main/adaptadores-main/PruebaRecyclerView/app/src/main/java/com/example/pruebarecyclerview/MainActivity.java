package com.example.pruebarecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pruebarecyclerview.adaptadores.UsuarioAdaptador;
import com.example.pruebarecyclerview.clases.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UsuarioAdaptador.OnItemClickListener {

    RecyclerView rcv_usuarios;
    List<Usuario> usuarioList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        Usuario usu1 = new Usuario("https://eskipaper.com/images/michael-jordan-3.jpg", "MICHAEL", "JUGADOR");
        Usuario usu2 = new Usuario("https://static.standard.co.uk/s3fs-public/thumbnails/image/2020/09/09/06/cristianoronaldo0909.jpg", "CRISTIANO", "FUTBOL");
        Usuario usu3 = new Usuario("https://sports.inquirer.net/files/2022/06/2022-06-11T040218Z_1_LYNXMPEI5A01A_RTROPTP_4_BASKETBALL-NBA-BOS-GSW-scaled.jpg", "stephen", "ASISTENCIAS");

        usuarioList.add(usu1);
        usuarioList.add(usu2);
        usuarioList.add(usu3);

        rcv_usuarios.setLayoutManager(new LinearLayoutManager(this));
        rcv_usuarios.setAdapter(new UsuarioAdaptador(usuarioList));

        UsuarioAdaptador adaptador = new UsuarioAdaptador(usuarioList);
        rcv_usuarios.setAdapter(adaptador);
        adaptador.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(Usuario usuario) {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }
}