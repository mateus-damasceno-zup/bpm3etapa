package test;

import org.example.Pessoa;
import org.example.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TesteTurma {

    private Turma turma;

    @BeforeEach
    public void setUp() {
        turma = new Turma();
    }

    @Test
    public void testaGetPessoas() throws Exception {
        Pessoa pessoa = new Pessoa(1,"Camila");
        List<Pessoa> novaPessoa = new ArrayList<>();
        novaPessoa.add(pessoa);
        turma.adicionarPessoa(pessoa);
        assertEquals(novaPessoa,turma.getPessoas());
    }

    @Test
    public void testaAdiconaPessoaValida() throws Exception {
        Pessoa pessoa = new Pessoa(1,"Geovana");
        turma.adicionarPessoa(pessoa);
        assertTrue(turma.getPessoas().contains(pessoa));
    }

    @Test
    public void testaAdiconaPessoaInvalida() {
        Pessoa pessoa = new Pessoa();

        assertThrows(Exception.class, ()->turma.adicionarPessoa(pessoa));
    }

    @Test
    public void testAdicionarPessoaRepetida() throws Exception {
        Pessoa pessoa = new Pessoa(1, "Elen");
        turma.adicionarPessoa(pessoa);

        assertThrows(Exception.class, () -> turma.adicionarPessoa(pessoa));
    }
    @Test
    public void testRemoverTodasPessoas() throws Exception {
        Pessoa pessoa1 = new Pessoa(1, "Pamela");
        Pessoa pessoa2 = new Pessoa(2, "Cecilia");

        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        turma.removerTodasPessoas();

        assertEquals(0, turma.getPessoas().size());
    }
}
