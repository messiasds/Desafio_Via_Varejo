package com.desafio.Seguradora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import com.desafio.Seguradora.dto.ApoliceConsultaDTO;
import com.desafio.Seguradora.model.Apolice;
import com.desafio.Seguradora.repository.ApoliceRepository;
import com.desafio.Seguradora.service.ApoliceConsultaImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ApoliceConsultaServiceTests {

    @TestConfiguration
    static class ApoliceServiceTestConfiguration {

        @Bean
        public ApoliceConsultaImp apoliceConsultaService() {
            return new ApoliceConsultaImp();
        }
    }

    @Autowired
    ApoliceConsultaImp service;

    @MockBean
    ApoliceRepository repository;

    @BeforeEach
    public void setup() {

        Apolice apolice1 = new Apolice();
        apolice1.setNumero(1111);
        apolice1.setPlacaVeiculo("111");
        apolice1.setValor(111);
        apolice1.setVigenciaInicio(LocalDate.parse("2021-01-01"));
        apolice1.setVigenciaFim(LocalDate.parse("2023-01-20"));

        Apolice apolice2 = new Apolice();
        apolice2.setNumero(222);
        apolice2.setPlacaVeiculo("222");
        apolice2.setValor(222);
        apolice2.setVigenciaInicio(LocalDate.parse("2019-01-01"));
        apolice2.setVigenciaFim(LocalDate.parse("2021-01-01"));

        Mockito.when(repository.findById("1")).thenReturn(Optional.of(apolice1));
        Mockito.when(repository.findById("2")).thenReturn(Optional.of(apolice2));

    }

    @Test
    public void TestaApoliceNaoVencida() {
        
         /**
         * testa o Retorno do DTO com apolice vencida 
         * fim da apolice 01/01/2023
         **/

        String id = "1";
        boolean estaVencidoEsperado = false;
        ApoliceConsultaDTO apoliceDTO;

        apoliceDTO = service.buscarApoliceComDiasVencimentoCalculado(id);

        assertEquals(estaVencidoEsperado, apoliceDTO.isVencida());

    }

    @Test
    public void TestaApoliceVencida() {
        /**
         * testa o Retorno do DTO com apolice vencida 
         * fim da apolice 01/01/2021
         **/

        String id = "2";
        boolean estaVencidoEsperado = true;

        ApoliceConsultaDTO apoliceDTO;

        apoliceDTO = service.buscarApoliceComDiasVencimentoCalculado(id);

        assertEquals(estaVencidoEsperado, apoliceDTO.isVencida());

    }

}
