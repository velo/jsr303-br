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
package com.github.jsr303br.impl;

import static com.github.jsr303br.util.RegexConstants.TELEFONE_UNFORMATED;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jsr303br.Telefone;
import com.github.jsr303br.util.Utils;

/**
 * Implementa a validação para {@link Telefone}.
 * 
 * @author Otávio Scherer Garcia
 * @version $Revision$
 */
public class TelefoneValidator
    implements ConstraintValidator<Telefone, String> {

    private static final Logger logger = LoggerFactory.getLogger(TelefoneValidator.class);
    private Telefone constraint;

    @Override
    public void initialize(Telefone constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        logger.debug("validando Telefone {}", value);

        // nulo ou vazio é considerado válido
        if (Utils.isNullOrEmpty(value)) {
            logger.debug("Telefone nulo ou vazio");
            return true;
        }

        final boolean result = value.matches(constraint.formatted() ? constraint.format() : TELEFONE_UNFORMATED);
        logger.debug("resultados para {}: {}", value, result);

        return result;
    }
}
