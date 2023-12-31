package testes;

import classes.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestesRequisitarVagas {
    
    @Test
    public void testRequisitar1() {
        Pessoa pessoa = new Pessoa("Paula", "12312312366", 10, 1, "Feminino");
        Vagas vaga = new Vagas(1, false);
        pessoa.requisitar_Vagas();
        assertFalse(vaga.isEstado());
    }

    @Test
    public void testRequisitar2() {
        Pessoa pessoa = new Pessoa("Patrício", "11122233344", 12, 1, "Masculino");
        Vagas vaga = new Vagas(16, true);
        pessoa.requisitar_Vagas();
        assertTrue(vaga.isEstado());
    }

    @Test
    public void testRequisitar3() {
        Pessoa pessoa = new Pessoa("Penelope", "55566677788", 71, 2, "Prefiro não dizer");
        Vagas vaga = new Vagas(8, false);
        pessoa.requisitar_Vagas();
        assertFalse(vaga.isEstado());
    }
}