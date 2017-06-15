/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.aws.ec2.domain;

import java.util.Date;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;


/**
 * Amazon EC2 ProvisionedBandwidth object.
 *
 * @see <a href="http://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_ProvisionedBandwidth.html" >AWS docs</a>
 */
@AutoValue
public abstract class ProvisionedBandwidth {

   @Nullable
   public abstract String  provisioned();

   @Nullable
   public abstract Date provisionTime();

   @Nullable
   public abstract String requested();

   @Nullable
   public abstract Date requestTime();

   @Nullable
   public abstract String status();

   @SerializedNames({"provisioned", "provisionTime", "requested", "requestTime", "status"})
   public static ProvisionedBandwidth create(String provisioned, Date provisionTime, String requested,
      Date requestTime, String status) {

      return builder()
         .provisioned(provisioned)
         .provisionTime(provisionTime)
         .requested(requested)
         .requestTime(requestTime)
         .status(status)
         .build();
   }

   ProvisionedBandwidth() {}

   public static Builder builder() {
      return new AutoValue_ProvisionedBandwidth.Builder();
   }



   @AutoValue.Builder
   public abstract static class Builder {

      public abstract Builder provisioned(String provisioned);
      public abstract Builder provisionTime(Date provisionTime);
      public abstract Builder requested(String requested);
      public abstract Builder requestTime(Date requestTime);
      public abstract Builder status(String status);

      public abstract ProvisionedBandwidth build();

   }


}
