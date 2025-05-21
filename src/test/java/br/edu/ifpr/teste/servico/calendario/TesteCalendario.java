package br.edu.ifpr.teste.servico.calendario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import paranavai.calendario.Calendario;

public class TesteCalendario {

    private String lerArquivoEsperado(String nomeArquivo) throws IOException {
        Path path = Paths.get("src/test/resources/calendario", nomeArquivo);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    private String normalize(String texto) {
        return texto
                .replace("\r\n", "\n")
                .replace("\uFEFF", "")
                .replaceAll("[ \t]+(?=\n)", "")
                .trim();
    }

    @Test
    public void testJaneiro2025() throws IOException {
        String esperado = lerArquivoEsperado("janeiro2025.txt");
        Calendario calendario = new Calendario();
        String resultado = calendario.getCalendario("1", "2025");
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAnoCompleto2025() throws IOException {
        String esperado = normalize(lerArquivoEsperado("ano2025.txt"));
        Calendario calendario = new Calendario();
        String resultado = normalize(calendario.getCalendario("2025"));
        assertEquals(esperado, resultado);
    }

    @Test
    public void testAnoCompleto0001() throws IOException {
        String esperado = normalize(lerArquivoEsperado("ano0001.txt"));
        Calendario calendario = new Calendario();
        String resultado = normalize(calendario.getCalendario("1"));
        assertEquals(esperado, resultado);
    }

    @Test
    public void testMesAtual() throws IOException {
        String esperado = normalize(lerArquivoEsperado("mesAtual.txt"));
        Calendario calendario = new Calendario();
        String resultado = normalize(calendario.getCalendario());
        assertEquals(esperado, resultado);
    }

    @Test
    public void testReformaGregorianaSetembro1752() throws IOException {
        String esperado = normalize(lerArquivoEsperado("reformaGregoriana1752.txt"));
        Calendario calendario = new Calendario();
        String resultado = normalize(calendario.getCalendario("9", "1752"));
        assertEquals(esperado, resultado);
    }
}
