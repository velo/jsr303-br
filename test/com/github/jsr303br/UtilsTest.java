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

import static com.github.jsr303br.util.Utils.allDigitsAreEquals;
import static com.github.jsr303br.util.Utils.isNullOrEmpty;
import static com.github.jsr303br.util.Utils.onlyDigits;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void isNullOrEmptyTest() {
        Assert.assertTrue(isNullOrEmpty(null));
        Assert.assertTrue(isNullOrEmpty(""));
        Assert.assertFalse(isNullOrEmpty(" "));
        Assert.assertFalse(isNullOrEmpty("x"));
    }

    @Test
    public void onlyDigitsTest() {
        Assert.assertEquals(onlyDigits("123"), "123");
        Assert.assertEquals(onlyDigits("123x"), "123");
    }

    @Test
    public void allDigitsAreEqualsTest() {
        Assert.assertTrue(allDigitsAreEquals("999999"));
        Assert.assertFalse(allDigitsAreEquals("123456"));
    }
}
