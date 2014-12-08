/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2014 the original author or authors.
 */
package org.assertj.core.api.doublearray;

import static org.assertj.core.test.DoubleArrays.arrayOf;

import org.assertj.core.api.DoubleArrayAssert;
import org.assertj.core.api.DoubleArrayAssertBaseTest;

import static org.mockito.Mockito.verify;

/**
 * Tests for <code>{@link DoubleArrayAssert#containsOnlyOnce(double...)}</code>.
 * 
 * @author William Delanoue
 */
public class DoubleArrayAssert_containsOnlyOnce_Test extends DoubleArrayAssertBaseTest {

  @Override
  protected DoubleArrayAssert invoke_api_method() {
    return assertions.containsOnlyOnce(6d, 8d);
  }

  @Override
  protected void verify_internal_effects() {
    verify(arrays).assertContainsOnlyOnce(getInfo(assertions), getActual(assertions), arrayOf(6d, 8d));
  }
}
