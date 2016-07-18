/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.context;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;

public final class TaskContextTest {
    
    @Test
    public void assertNew() {
        TaskContext actual = new TaskContext("test_job", 0, ExecutionType.READY);
        assertThat(actual.getJobName(), is("test_job"));
        assertThat(actual.getShardingItem(), is(0));
        assertThat(actual.getId(), startsWith("test_job@-@0@-@READY@-@"));
    }
    
    @Test
    public void assertFrom() {
        TaskContext actual = TaskContext.from("test_job@-@0@-@READY@-@01234567890");
        assertThat(actual.getId(), is("test_job@-@0@-@READY@-@01234567890"));
        assertThat(actual.getJobName(), is("test_job"));
        assertThat(actual.getShardingItem(), is(0));
    }
}