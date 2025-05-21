package br.edu.ifpr.teste.servico.irpf;

import org.junit.jupiter.api.Test;
import imposto.renda.SimuladorImpostoRenda;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteSimuladorImpostoRenda {
    @Test
    public void deveRetornarZeroParaSalarioIsento() {
        double salario = 1800.00;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(0.0, imposto, 0.01);
    }

    @Test
    public void deveCalcularAliquota075() {
        double salario = 2500.00;
        double esperado = salario * 0.075 - 142.80;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    public void deveCalcularAliquota15() {
        double salario = 3000.00;
        double esperado = salario * 0.15 - 354.80;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    public void deveCalcularAliquota225() {
        double salario = 4000.00;
        double esperado = salario * 0.225 - 636.13;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(esperado, imposto, 0.01);
    }

    @Test
    public void deveCalcularAliquota275() {
        double salario = 7000.00;
        double esperado = salario * 0.275 - 869.36;
        double imposto = SimuladorImpostoRenda.calcularImposto(salario);
        assertEquals(esperado, imposto, 0.01);
    }
}
