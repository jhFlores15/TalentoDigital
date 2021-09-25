package com.johfloresm.homeflix.AnalizadorTitulos;

public class AnalizadorTitulosImpl2 implements AnalizadorTitulos {
    @Override
    public int analizar(String title){
       int cantidadVocales = contadorVocales(title);

       if(cantidadVocales <= 8){
           return -1;
       }
       else if(cantidadVocales >= 9 && cantidadVocales <=12){
           return 0;
       }
       else {
           return 1;
       }
    }

    private int contadorVocales(String title){
        Character [] vocales = {'a','e','i','o','u'};
        int cont = 0;
        for(int i=0; i<title.length();i++){
            for(int x=0; x < vocales.length; x++){
                if(title.charAt(i) == vocales[x]){
                    cont++;
                    break;
                }
            }
        }

        return cont;
    }
}
