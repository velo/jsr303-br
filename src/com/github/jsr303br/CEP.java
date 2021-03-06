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

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import com.github.jsr303br.impl.CEPValidator;

/**
 * Verifica se o campo é um CEP válido. A validação é feita apenas quanto ao seu formato, e não se o CEP realmente
 * existe na base dos Correios.
 * 
 * @author Otávio Scherer Garcia
 */
@Documented
@Constraint(validatedBy = { CEPValidator.class })
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface CEP {

    /**
     * Mensagem retornada quando a validação falhar.
     */
    String message() default "{cep.error}";

    /**
     * Indica se o valor do campo é formatado ou não.
     */
    boolean formatted() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
