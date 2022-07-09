package com.emmanuelaguero.universidadbackend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class UniversidadBackendApplicationTests {


    Calculador calculador = new Calculador();

    class Calculador{
        int suma(int a ,int b){
            return a+b;
        }
    }



    @Test
    @DisplayName("Suma valor A y valor B")
    void sumaDeValores() {
        //given
        int _a =2;
        int _b =3;
        //when
        int expectativa = calculador.suma(_a,_b);
        //then
        int resultadoEsperado = 5;
        assertThat(expectativa).isEqualTo(resultadoEsperado);
    }

    @Test
    @Disabled("Test deprecado")
    @DisplayName("Test deprecado")
    void testDesactivado(){
    }

}
