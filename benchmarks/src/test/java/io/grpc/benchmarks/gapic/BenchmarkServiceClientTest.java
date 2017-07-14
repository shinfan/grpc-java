/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.grpc.benchmarks.gapic;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.ApiException;
import com.google.api.gax.grpc.ApiStreamObserver;
import com.google.api.gax.grpc.StreamingCallable;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protos.grpc.testing.Messages.SimpleRequest;
import com.google.protos.grpc.testing.Messages.SimpleResponse;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class BenchmarkServiceClientTest {
  private static MockBenchmarkService mockBenchmarkService;
  private static MockServiceHelper serviceHelper;
  private BenchmarkServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBenchmarkService = new MockBenchmarkService();
    serviceHelper = new MockServiceHelper("in-process-1", Arrays.<MockGrpcService>asList(mockBenchmarkService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    BenchmarkServiceSettings settings = BenchmarkServiceSettings.defaultBuilder()
        .setChannelProvider(serviceHelper.createChannelProvider())
        .setCredentialsProvider(new NoCredentialsProvider())
        .build();
    client = BenchmarkServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void streamingCallTest() throws Exception {
    String username = "username-265713450";
    String oauthScope = "oauthScope443818668";
    SimpleResponse expectedResponse = SimpleResponse.newBuilder()
      .setUsername(username)
      .setOauthScope(oauthScope)
      .build();
    mockBenchmarkService.addResponse(expectedResponse);
    SimpleRequest request = SimpleRequest.newBuilder().build();

    MockStreamObserver<SimpleResponse> responseObserver = new MockStreamObserver<>();

    StreamingCallable<SimpleRequest, SimpleResponse> callable =
        client.streamingCallCallable();
    ApiStreamObserver<SimpleRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<SimpleResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  @SuppressWarnings("all")
  public void streamingCallExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockBenchmarkService.addException(exception);
    SimpleRequest request = SimpleRequest.newBuilder().build();

    MockStreamObserver<SimpleResponse> responseObserver = new MockStreamObserver<>();

    StreamingCallable<SimpleRequest, SimpleResponse> callable =
        client.streamingCallCallable();
    ApiStreamObserver<SimpleRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<SimpleResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof StatusRuntimeException);
      StatusRuntimeException statusException = (StatusRuntimeException) e.getCause();
      Assert.assertEquals(Status.INVALID_ARGUMENT, statusException.getStatus());
    }
  }

}