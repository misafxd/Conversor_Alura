package com.cursoalura.conversor.modelos;

import java.io.IOException;

public class Menu {
    private String consulta;

    public Menu() throws IOException, InterruptedException {
    }

    public String getMenu() {
        return """
                ***********************************************************
                Sea bienvenido/a al Conversor de Moneda :)
                                   \s
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ************************************************************
               \s""";
    }

    public void setConsulta(int opcion){
        switch (opcion) {
            case 1:
                this.consulta = "USD/ARS";
                break;
            case 2:
                this.consulta = "ARS/USD";
                break;
            case 3:
                this.consulta = "USD/BRL";
                break;
            case 4:
                this.consulta = "BRL/USD";
                break;
            case 5:
                this.consulta = "USD/COP";
                break;
            case 6:
                this.consulta = "COP/USD";
                break;
            case 7:
                this.consulta="Gracias por usar el conversor de monedas!";
                break;
            default:
                break;
        }
    }

    public String getConsulta() {
        return consulta;
    }
}
