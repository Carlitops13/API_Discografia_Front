package com.swiftie.taylor_frontend.service;

import com.swiftie.taylor_frontend.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import org.springframework.http.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Base64;

@Service
public class AlbumService {

    @Autowired
    private RestTemplate restTemplate;
    
    private final String API_URL = "https://api-discografia.onrender.com/api/albums";

    public List<Album> obtenerTodos() {
        try {
            System.out.println("[AlbumService] Intentando conectar a: " + API_URL);
            
            String authStr = "user:password";
            String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Basic " + base64Creds);
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<>(headers);

            ResponseEntity<Album[]> response = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                request,
                Album[].class
            );

            if (response.getBody() != null) {
                System.out.println("[AlbumService] Álbumes obtenidos correctamente: " + response.getBody().length);
                return Arrays.asList(response.getBody());
            } else {
                System.out.println("[AlbumService] La respuesta del backend está vacía");
                return Collections.emptyList();
            }
        } catch (RestClientException e) {
            System.err.println("[AlbumService] Error al conectar con el backend: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        } catch (Exception e) {
            System.err.println("[AlbumService] Error inesperado: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}