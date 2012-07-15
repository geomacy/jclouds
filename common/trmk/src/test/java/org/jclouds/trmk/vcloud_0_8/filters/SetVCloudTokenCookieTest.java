/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
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
package org.jclouds.trmk.vcloud_0_8.filters;

import static org.testng.Assert.assertEquals;

import javax.inject.Provider;
import javax.ws.rs.core.HttpHeaders;

import org.jclouds.http.HttpRequest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author Adrian Cole
 */
@Test
public class SetVCloudTokenCookieTest {

   private SetVCloudTokenCookie filter;

   @BeforeTest
   void setUp() {
      filter = new SetVCloudTokenCookie(new Provider<String>() {
         public String get() {
            return "token";
         }
      });
   }

   @Test
   public void testApply() {
      HttpRequest request = HttpRequest.builder().method("GET").endpoint("http://localhost").build();
      request = filter.filter(request);
      assertEquals(request.getHeaders().size(), 1);
      assertEquals(request.getFirstHeaderOrNull(HttpHeaders.COOKIE), "vcloud-token=token");

   }

}
