package com.evaluaciontecnica.carritocompra.utilitarios;

public class Utilitarios {

    public static Object isNull(Object objeto1, Object objeto2 ){

        try {
            Object resultado = (String.valueOf(objeto2).equals("null") || objeto2 == null) ? objeto1 : objeto2;

            return resultado;
        }catch(NullPointerException e){
            return objeto1;
        }
    }

}
