package com.johfloresm.homeflix.AnalizadorTitulos;

public class TestImplementaciones{

    public static void main(String[] args) {

        AnalizadorTitulosImpl1 palabras = new AnalizadorTitulosImpl1();
        AnalizadorTitulosImpl2 vocales = new AnalizadorTitulosImpl2();

        //test
        System.out.println("----- Resultados con metodo 'cantidad de palabras' -----");
        System.out.println(palabras.analizar("El Hoyo")); //result 0
        System.out.println(palabras.analizar("Casa de Papel")); //result 1
        System.out.println(palabras.analizar("Hallowen")); //result -1
        System.out.println(palabras.analizar("")); //result -1

        System.out.println("----- Resultados con mtodo 'cantidad de palabras' -----");
        System.out.println(vocales.analizar("El Hoyo")); //result -1
        System.out.println(vocales.analizar("Casa de Papel")); //result -1
        System.out.println(vocales.analizar("Hallowen")); //result -1
        System.out.println(vocales.analizar("")); //result -1
    }




}
