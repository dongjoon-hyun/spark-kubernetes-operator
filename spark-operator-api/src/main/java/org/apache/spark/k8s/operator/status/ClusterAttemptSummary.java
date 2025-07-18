/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.spark.k8s.operator.status;

import java.util.SortedMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/** Summary of a Spark cluster attempt. */
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClusterAttemptSummary extends BaseAttemptSummary {
  protected final SortedMap<Long, ClusterState> stateTransitionHistory;

  public ClusterAttemptSummary(
      AttemptInfo attemptInfo, SortedMap<Long, ClusterState> stateTransitionHistory) {
    super(attemptInfo);
    this.stateTransitionHistory = stateTransitionHistory;
  }

  public ClusterAttemptSummary() {
    this(new AttemptInfo(), null);
  }

  public ClusterAttemptSummary(AttemptInfo attemptInfo) {
    this(attemptInfo, null);
  }
}
