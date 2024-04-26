package com.cursoalura.conversor.principal;

import com.cursoalura.conversor.calculos.Conversor;
import com.cursoalura.conversor.modelos.Intercambio;
import com.cursoalura.conversor.modelos.Menu;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        Conversor conversor = new Conversor();
        Scanner inputOption = new Scanner(System.in);
        String direccionBase= "https://v6.exchangerate-api.com/v6/b3c38fbd8ec289f5faa71630/pair/";
        String consulta = "";
        double cantidadConvertir;
        double valorConvertido;
        int opcion = 0;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        while (opcion != 7){
            System.out.print(menu.getMenu());
            opcion = inputOption.nextInt();
            menu.setConsulta(opcion);
            if (opcion == 7){
                System.out.println(menu.getConsulta());
            } else if (opcion > 0 && opcion < 7){
                String direccion = direccionBase + menu.getConsulta();
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                Intercambio moneda = gson.fromJson(json, Intercambio.class);

                System.out.println("Inserta la cantidad a convertir: ");
                cantidadConvertir = inputOption.nextDouble();

                valorConvertido = conversor.convertirCantidad(cantidadConvertir, moneda.conversion_rate());
                System.out.println(cantidadConvertir + moneda.base_code() + " = "+ valorConvertido + moneda.target_code());
            } else {
                System.out.println("Escribe una opcion válida :C");
            }
        }

    }
}
