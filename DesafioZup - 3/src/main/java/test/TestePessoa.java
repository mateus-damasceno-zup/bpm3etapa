package test;

import org.example.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePessoa {

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa();
    }

    @Test
    public void testaSetGetId() {
        pessoa.setId(1);
        assertEquals(1, pessoa.getId());
    }

    @Test
    public void testaSetGetNome(){

        pessoa.setNome("Mary Jane");
        assertEquals("Mary Jane",pessoa.getNome());
    }

    @Test
    public void testeValidoOk(){
        pessoa.setId(1);
        pessoa.setNome("caramelo");
        assertTrue(pessoa.valido());
    }
    @Test
    public void testaValidoIdInvalido(){
        pessoa.setId(0);
        pessoa.setNome("joao");
        assertFalse(pessoa.valido());
    }

    @Test
    public void testaValidoNomeInvalido(){
        pessoa.setId(1);
        pessoa.setNome("");
        assertFalse(pessoa.valido());
    }
    @Test
    public void testaValidoIdENomeInvalido(){
        pessoa.setId(0);
        pessoa.setNome("");
        assertFalse(pessoa.valido());
    }

}
