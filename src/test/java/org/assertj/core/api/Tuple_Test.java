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
package org.assertj.core.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Arrays.array;

import org.assertj.core.groups.Tuple;
import org.junit.Test;

public class Tuple_Test {

  @Test
  public void should_create_tuple() {
    Tuple tuple = new Tuple("Yoda", 800, "Jedi");
    assertThat(tuple).isEqualTo(new Tuple("Yoda", 800, "Jedi"));
  }

  @Test
  public void should_create_empty_tuple() {
	Tuple tuple = new Tuple();
	assertThat(tuple).isEqualTo(new Tuple());
  }
  
  @Test
  public void add_an_element_to_a_tuple() {
	Tuple tuple = new Tuple("Yoda", 800);
	tuple.addData("Jedi");
	assertThat(tuple).isEqualTo(new Tuple("Yoda", 800, "Jedi"));
  }
  
  @Test
  public void convert_tuple_to_an_array() {
	Tuple tuple = new Tuple("Yoda", 800, "Jedi");
	assertThat(tuple.toArray()).isEqualTo(array("Yoda", 800, "Jedi"));
  }
  
  @Test
  public void tuple_representation() {
	Tuple tuple = new Tuple("Yoda", 800, "Jedi");
	assertThat(tuple.toString()).isEqualTo("(\"Yoda\", 800, \"Jedi\")");
  }
  
}
