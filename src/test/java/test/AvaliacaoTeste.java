package test;

import model.Avaliacao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AvaliacaoTeste {

private Avaliacao avaliacao = new Avaliacao();

@Test
public void deveValidarNotaDentroDoLimite() {
    assertTrue(avaliacao.validarNota(7));
    assertTrue(avaliacao.validarNota(0));
    assertTrue(avaliacao.validarNota(10));
}

@Test
public void deveRejeitarNotaForaDoLimite() {
    assertFalse(avaliacao.validarNota(-1));
    assertFalse(avaliacao.validarNota(11));
}

@Test
public void deveValidarFrequenciaDentroDoLimite() {
    assertTrue(avaliacao.validarFrequencia(75));
    assertTrue(avaliacao.validarFrequencia(0));
    assertTrue(avaliacao.validarFrequencia(100));
}

@Test
public void deveRejeitarFrequenciaForaDoLimite() {
    assertFalse(avaliacao.validarFrequencia(-1));
    assertFalse(avaliacao.validarFrequencia(101));
}

@Test
public void deveCalcularMediaCorretamente() {
    double media = avaliacao.calcularMedia(8, 6);

    assertEquals(7, media);
}

@Test
public void deveIdentificarFrequenciaMinima() {
    assertTrue(avaliacao.possuiFrequenciaMinima(75));
    assertTrue(avaliacao.possuiFrequenciaMinima(80));
}

@Test
public void deveReprovarPorFrequencia() {
    String situacao = avaliacao.verificarSituacao(9, 74);

    assertEquals("REPROVADO POR FREQUÊNCIA", situacao);
}

@Test
public void deveAprovarAluno() {
    String situacao = avaliacao.verificarSituacao(7, 75);

    assertEquals("APROVADO", situacao);
}

@Test
public void deveColocarAlunoEmRecuperacao() {
    String situacao = avaliacao.verificarSituacao(6, 80);

    assertEquals("RECUPERAÇÃO", situacao);
}

@Test
public void deveReprovarAlunoPorNota() {
    String situacao = avaliacao.verificarSituacao(4, 80);

    assertEquals("REPROVADO", situacao);
}

}