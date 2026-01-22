package com.swiftie.taylor_frontend.model;

import lombok.Data;

@Data
public class Album {
    private Long id;
    private String nombre;
    private String fechaLanzamiento;
    private String genero;
    private String imagenUrl;

}
