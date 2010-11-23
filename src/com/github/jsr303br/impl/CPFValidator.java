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

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jsr303br.CPF;
import com.github.jsr303br.util.RegexConstants;
import com.github.jsr303br.util.Utils;

/**
 * Implementa a validação para {@link CPF}.
 * 
 * @author Otávio Scherer Garcia
 */
public class CPFValidator
    implements ConstraintValidator<CPF, String> {

    private static final Logger logger = LoggerFactory.getLogger(CPFValidator.class);
    private CPF constraint;

    @Override
    public void initialize(CPF constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        logger.debug("validando CPF {}, formatted: {}", value, constraint.formatted());

        // nulo ou vazio é considerado válido
        if (Utils.isNullOrEmpty(value)) {
            logger.debug("CPF nulo ou vazio");
            return true;
        }

        if (constraint.formatted()) {
            if (!value.matches(RegexConstants.CPF_FORMATED)) {
                logger.debug("{} não casa com CPF_FORMATED pattern", value);
                return false;
            }
            value = Utils.onlyDigits(value);

        } else if (!value.matches(RegexConstants.CPF_UNFORMATED)) {
            logger.debug("{} não casa com CPF_UNFORMATED", value);
            return false;
        }

        final boolean result = value.length() == 11 && Utils.isValidCpfCnpj(value);
        logger.debug("resultados para {}: {}", value, result);

        return result;
    }
}
