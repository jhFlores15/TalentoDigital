package com.johfloresm.homeflix.AnalizadorTitulos;

public class AnalizadorTitulosImpl1 implements AnalizadorTitulos{

    @Override
    public int analizar(String title){
        String [] words = title.split(" ");
        int result = 0;
        switch(words.length){
            case 1:
                result = -1;
                break;
            case 2:
                result = 0;
                break;
            default:
                result = 1;
                break;
        }

        return result;
    }
}
