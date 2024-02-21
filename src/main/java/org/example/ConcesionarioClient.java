package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ConcesionarioClient {
    public static void main(String[] args) {
        try {

            URL url = new URL("https://guellcom.com/paginas-web-de-concesionarios");


            InetAddress address = InetAddress.getByName(url.getHost());
            System.out.println("Dirección IP del servidor: " + address.getHostAddress());


            URLConnection connection = url.openConnection();


            connection.setConnectTimeout(5000); // 5 segundos de tiempo de espera


            connection.setRequestProperty("User-Agent", "Mozilla/5.0");


            System.out.println("Tipo de contenido: " + connection.getContentType());
            System.out.println("Longitud del contenido: " + connection.getContentLength());


            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            System.out.println("Contenido de la página:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}