/*
 * Copyright (C) 2010 Otávio Scherer Garcia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jsr303br;


public class Cliente {

    @Telefone(formatted = false)
    public String telefone0;

    @Telefone(formatted = true)
    public String telefone1;

    @CPF(formatted = false)
    public String cpf0;

    @CPF(formatted = true)
    public String cpf1;

    @CNPJ(formatted = false)
    public String cnpj0;

    @CNPJ(formatted = true)
    public String cnpj1;

    @CEP(formatted = false)
    public String cep0;

    @CEP(formatted = true)
    public String cep1;

    public Cliente setTelefone0(String telefone0) {
        this.telefone0 = telefone0;
        return this;
    }

    public Cliente setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
        return this;
    }

    public Cliente setCpf0(String cpf0) {
        this.cpf0 = cpf0;
        return this;
    }

    public Cliente setCpf1(String cpf1) {
        this.cpf1 = cpf1;
        return this;
    }

    public Cliente setCnpj0(String cnpj0) {
        this.cnpj0 = cnpj0;
        return this;
    }

    public Cliente setCnpj1(String cnpj1) {
        this.cnpj1 = cnpj1;
        return this;
    }

    public Cliente setCep0(String cep0) {
        this.cep0 = cep0;
        return this;
    }

    public Cliente setCep1(String cep1) {
        this.cep1 = cep1;
        return this;
    }
}
