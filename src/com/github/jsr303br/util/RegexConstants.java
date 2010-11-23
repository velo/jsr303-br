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
package com.github.jsr303br.util;

/**
 * Expressões regulares para a validação de formato dos campos.
 * 
 * @author Otávio Scherer Garcia
 */
public interface RegexConstants {

	/**
	 * Regex indicando CEP formatado.
	 */
    String CEP_FORMATED = "(\\d{5})-(\\d{3})";

	/**
	 * Regex indicando CEP sem formatação.
	 */
    String CEP_UNFORMATED = "(\\d{8})";

	/**
	 * Regex indicando CNPJ formatado.
	 */
    String CNPJ_FORMATED = "(\\d{2})\\.(\\d{3})\\.(\\d{3})/(\\d{4})-(\\d{2})";

	/**
	 * Regex indicando CNPJ sem formatação.
	 */
    String CNPJ_UNFORMATED = "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})";

	/**
	 * Regex indicando CPF formatado.
	 */
    String CPF_FORMATED = "(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})";

	/**
	 * Regex indicando CPF sem formatação.
	 */
    String CPF_UNFORMATED = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";

	/**
	 * Regex indicando telefone formatado.
	 */
    String TELEFONE_FORMATED = "(\\d{2}).(\\d{4}).(\\d{4})";

	/**
	 * Regex indicando telefone sem formatação.
	 */
    String TELEFONE_UNFORMATED = "(\\d{10})";

}
