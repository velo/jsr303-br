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

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CEPTest {

    private final Validator validator;
    private final Logger logger = LoggerFactory.getLogger(CEPTest.class);

    public CEPTest() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void testEmptyBean() {
        Set<ConstraintViolation<Cliente>> violations = validator.validate(new Cliente());
        Assert.assertTrue(violations.isEmpty());
    }

    @Test
    public void testCEP() {
        Set<ConstraintViolation<Cliente>> violations = null;

        // valores nulos são considerados válidos
        violations = validator.validate(new Cliente().setCep0(null));
        logger.debug(violations.toString());
        Assert.assertTrue(violations.size() == 0);

        // cep não formatado
        violations = validator.validate(new Cliente().setCep0("92115000"));
        logger.debug(violations.toString());
        Assert.assertTrue(violations.size() == 0);

        violations = validator.validate(new Cliente().setCep0("92115-000"));
        logger.debug(violations.toString());
        Assert.assertTrue(violations.size() == 1);

        violations = validator.validate(new Cliente().setCep1("92115000"));
        logger.debug(violations.toString());
        Assert.assertTrue(violations.size() == 1);

        violations = validator.validate(new Cliente().setCep1("92115-000"));
        logger.debug(violations.toString());
        Assert.assertTrue(violations.size() == 0);
    }

}
