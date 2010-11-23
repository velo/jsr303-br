package com.github.jsr303br;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Classe para executar todos os testes via JUnit.
 * 
 * @author Otávio Scherer Garcia
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { CEPTest.class, CNPJTest.class, CPFTest.class, TelefoneTest.class })
public class AllTests {
}