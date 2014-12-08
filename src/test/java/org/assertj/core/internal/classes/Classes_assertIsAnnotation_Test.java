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
package org.assertj.core.internal.classes;

import static org.assertj.core.error.ShouldBeAnnotation.shouldBeAnnotation;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.ClassesBaseTest;
import org.junit.Test;

/**
 * Tests for
 * <code>{@link org.assertj.core.internal.Classes#assertIsAnnotation(org.assertj.core.api.AssertionInfo, Class)}</code>
 * .
 * 
 * @author William Delanoue
 */
public class Classes_assertIsAnnotation_Test extends ClassesBaseTest {

  @Test
  public void should_fail_if_actual_is_null() {
    actual = null;
    thrown.expectAssertionError(actualIsNull());
    classes.assertIsAnnotation(someInfo(), actual);
  }

  @Test
  public void should_pass_if_actual_is_an_annotation() {
    actual = Override.class;
    classes.assertIsAnnotation(someInfo(), actual);
  }

  @Test()
  public void should_fail_if_actual_is_not_an_annotation() {
    AssertionInfo info = someInfo();
    actual = Classes_assertIsAnnotation_Test.class;
    try {
      classes.assertIsAnnotation(someInfo(), actual);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeAnnotation(actual));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
}
