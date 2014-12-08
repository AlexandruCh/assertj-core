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
package org.assertj.core.internal.dates;

import static org.assertj.core.error.ShouldBeWithin.shouldBeWithin;
import static org.assertj.core.test.TestData.someInfo;
import static org.assertj.core.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;
import static org.assertj.core.util.FailureMessages.actualIsNull;


import static org.mockito.Mockito.verify;

import java.util.Date;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.internal.Dates;
import org.assertj.core.internal.DatesBaseTest;
import org.junit.Test;


/**
 * Tests for <code>{@link Dates#assertIsWithinDayOfMonth(AssertionInfo, Date, int)}</code>.
 * 
 * @author Joel Costigliola
 */
public class Dates_assertIsWithinDayOfMonth_Test extends DatesBaseTest {

  @Test
  public void should_fail_if_actual_is_not_within_given_day_of_month() {
    AssertionInfo info = someInfo();
    int day_of_month = 5;
    try {
      dates.assertIsWithinDayOfMonth(info, actual, day_of_month);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeWithin(actual, "day of month", day_of_month));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    dates.assertIsWithinDayOfMonth(someInfo(), null, 1);
  }

  @Test
  public void should_pass_if_actual_is_within_given_day_of_month() {
    dates.assertIsWithinDayOfMonth(someInfo(), actual, 1);
  }

  @Test
  public void should_fail_if_actual_is_not_within_given_day_of_month_whatever_custom_comparison_strategy_is() {
    AssertionInfo info = someInfo();
    int day_of_month = 5;
    try {
      datesWithCustomComparisonStrategy.assertIsWithinDayOfMonth(info, actual, day_of_month);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeWithin(actual, "day of month", day_of_month));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }

  @Test
  public void should_fail_if_actual_is_null_whatever_custom_comparison_strategy_is() {
    thrown.expectAssertionError(actualIsNull());
    datesWithCustomComparisonStrategy.assertIsWithinDayOfMonth(someInfo(), null, 1);
  }

  @Test
  public void should_pass_if_actual_is_within_given_day_of_month_whatever_custom_comparison_strategy_is() {
    datesWithCustomComparisonStrategy.assertIsWithinDayOfMonth(someInfo(), actual, 1);
  }

}
