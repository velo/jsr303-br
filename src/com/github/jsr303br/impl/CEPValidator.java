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

import static com.github.jsr303br.util.RegexConstants.CEP_FORMATED;
import static com.github.jsr303br.util.RegexConstants.CEP_UNFORMATED;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jsr303br.CEP;
import com.github.jsr303br.util.Utils;

/**
 * Implementa a validação para {@link CEP}.
 * 
 * @author Otávio Scherer Garcia
 */
public class CEPValidator
    implements ConstraintValidator<CEP, String> {

    private static final Logger logger = LoggerFactory.getLogger(CEPValidator.class);
    private CEP constraint;

    @Override
    public void initialize(CEP constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        logger.debug("validando CEP {}", value);

        // nulo ou vazio é considerado válido
        if (Utils.isNullOrEmpty(value)) {
            logger.debug("CEP nulo ou vazio");
            return true;
        }

        final boolean result = value.matches(constraint.formatted() ? CEP_FORMATED : CEP_UNFORMATED);
        logger.debug("resultados para {}: {}", value, result);

        return result;
    }
}
