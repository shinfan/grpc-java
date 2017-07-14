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

import com.google.api.core.BetaApi;
import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.ClientContext;
import com.google.api.gax.grpc.StreamingCallable;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.auth.Credentials;
import io.grpc.benchmarks.proto.Messages.SimpleRequest;
import io.grpc.benchmarks.proto.Messages.SimpleResponse;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description:
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
 *   SimpleRequest request = SimpleRequest.newBuilder().build();
 *   SimpleResponse response = benchmarkServiceClient.unaryCall(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the benchmarkServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * API callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of BenchmarkServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * BenchmarkServiceSettings benchmarkServiceSettings =
 *     BenchmarkServiceSettings.defaultBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BenchmarkServiceClient benchmarkServiceClient =
 *     BenchmarkServiceClient.create(benchmarkServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
public class BenchmarkServiceClient implements AutoCloseable {
  private final BenchmarkServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<SimpleRequest, SimpleResponse> unaryCallCallable;
  private final StreamingCallable<SimpleRequest, SimpleResponse> streamingCallCallable;
  private final StreamingCallable<SimpleRequest, SimpleResponse> streamingFromClientCallable;
  private final StreamingCallable<SimpleRequest, SimpleResponse> streamingFromServerCallable;
  private final StreamingCallable<SimpleRequest, SimpleResponse> streamingBothWaysCallable;



  /**
   * Constructs an instance of BenchmarkServiceClient with default settings.
   */
  public static final BenchmarkServiceClient create() throws IOException {
    return create(BenchmarkServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of BenchmarkServiceClient, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final BenchmarkServiceClient create(BenchmarkServiceSettings settings) throws IOException {
    return new BenchmarkServiceClient(settings);
  }

  /**
   * Constructs an instance of BenchmarkServiceClient, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected BenchmarkServiceClient(BenchmarkServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();
    Credentials credentials = settings.getCredentialsProvider().getCredentials();

    ClientContext clientContext =
        ClientContext.newBuilder()
            .setExecutor(this.executor)
            .setChannel(this.channel)
            .setCredentials(credentials)
            .build();


    this.unaryCallCallable = UnaryCallable.create(settings.unaryCallSettings(), clientContext);
    this.streamingCallCallable = StreamingCallable.create(settings.streamingCallSettings(), clientContext);
    this.streamingFromClientCallable = StreamingCallable.create(settings.streamingFromClientSettings(), clientContext);
    this.streamingFromServerCallable = StreamingCallable.create(settings.streamingFromServerSettings(), clientContext);
    this.streamingBothWaysCallable = StreamingCallable.create(settings.streamingBothWaysSettings(), clientContext);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
        new Closeable() {
          @Override
          public void close() throws IOException {
            channel.shutdown();
          }
        });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
        new Closeable() {
          @Override
          public void close() throws IOException {
            executor.shutdown();
          }
        });
    }
  }

  public final BenchmarkServiceSettings getSettings() {
    return settings;
  }


  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * One request followed by one response.
   * The server returns the client payload as-is.
   *
   * Sample code:
   * <pre><code>
   * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
   *   SimpleRequest request = SimpleRequest.newBuilder().build();
   *   SimpleResponse response = benchmarkServiceClient.unaryCall(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final SimpleResponse unaryCall(SimpleRequest request) {
    return unaryCallCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * One request followed by one response.
   * The server returns the client payload as-is.
   *
   * Sample code:
   * <pre><code>
   * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
   *   SimpleRequest request = SimpleRequest.newBuilder().build();
   *   ApiFuture&lt;SimpleResponse&gt; future = benchmarkServiceClient.unaryCallCallable().futureCall(request);
   *   // Do something
   *   SimpleResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<SimpleRequest, SimpleResponse> unaryCallCallable() {
    return unaryCallCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Repeated sequence of one request followed by one response.
   * Should be called streaming ping-pong
   * The server returns the client payload as-is on each response
   *
   * Sample code:
   * <pre><code>
   * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
   *   ApiStreamObserver&lt;SimpleResponse&gt; responseObserver =
   *       new ApiStreamObserver&lt;SimpleResponse&gt;() {
   *         {@literal @}Override
   *         public void onNext(SimpleResponse response) {
   *           // Do something when receive a response
   *         }
   *
   *         {@literal @}Override
   *         public void onError(Throwable t) {
   *           // Add error-handling
   *         }
   *
   *         {@literal @}Override
   *         public void onCompleted() {
   *           // Do something when complete.
   *         }
   *       };
   *   ApiStreamObserver&lt;StreamingRecognizeRequest&gt; requestObserver =
   *       benchmarkServiceClient.streamingCallCallable().bidiStreamingCall(responseObserver));
   *
   *   SimpleRequest request = SimpleRequest.newBuilder().build();
   *   requestObserver.onNext(request);
   * }
   * </code></pre>
   */
  public final StreamingCallable<SimpleRequest, SimpleResponse> streamingCallCallable() {
    return streamingCallCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Single-sided unbounded streaming from client to server
   * The server returns the client payload as-is once the client does WritesDone
   *
   * Sample code:
   * <pre><code>
   * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
   *   ApiStreamObserver&lt;SimpleResponse&gt; responseObserver =
   *       new ApiStreamObserver&lt;SimpleResponse&gt;() {
   *         {@literal @}Override
   *         public void onNext(SimpleResponse response) {
   *           // Do something when receive a response
   *         }
   *
   *         {@literal @}Override
   *         public void onError(Throwable t) {
   *           // Add error-handling
   *         }
   *
   *         {@literal @}Override
   *         public void onCompleted() {
   *           // Do something when complete.
   *         }
   *       };
   *   ApiStreamObserver&lt;StreamingRecognizeRequest&gt; requestObserver =
   *       benchmarkServiceClient.streamingFromClientCallable().clientStreamingCall(responseObserver));
   *
   *   SimpleRequest request = SimpleRequest.newBuilder().build();
   *   requestObserver.onNext(request);
   * }
   * </code></pre>
   */
  public final StreamingCallable<SimpleRequest, SimpleResponse> streamingFromClientCallable() {
    return streamingFromClientCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Single-sided unbounded streaming from server to client
   * The server repeatedly returns the client payload as-is
   *
   * Sample code:
   * <pre><code>
   * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
   *   ApiStreamObserver&lt;SimpleResponse&gt; responseObserver =
   *       new ApiStreamObserver&lt;SimpleResponse&gt;() {
   *         {@literal @}Override
   *         public void onNext(SimpleResponse response) {
   *           // Do something when receive a response
   *         }
   *
   *         {@literal @}Override
   *         public void onError(Throwable t) {
   *           // Add error-handling
   *         }
   *
   *         {@literal @}Override
   *         public void onCompleted() {
   *           // Do something when complete.
   *         }
   *       };
   *
   *   SimpleRequest request = SimpleRequest.newBuilder().build();
   *
   *   benchmarkServiceClient.streamingFromServerCallable().serverStreamingCall(request, responseObserver));
   * }
   * </code></pre>
   */
  public final StreamingCallable<SimpleRequest, SimpleResponse> streamingFromServerCallable() {
    return streamingFromServerCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Two-sided unbounded streaming between server to client
   * Both sides send the content of their own choice to the other
   *
   * Sample code:
   * <pre><code>
   * try (BenchmarkServiceClient benchmarkServiceClient = BenchmarkServiceClient.create()) {
   *   ApiStreamObserver&lt;SimpleResponse&gt; responseObserver =
   *       new ApiStreamObserver&lt;SimpleResponse&gt;() {
   *         {@literal @}Override
   *         public void onNext(SimpleResponse response) {
   *           // Do something when receive a response
   *         }
   *
   *         {@literal @}Override
   *         public void onError(Throwable t) {
   *           // Add error-handling
   *         }
   *
   *         {@literal @}Override
   *         public void onCompleted() {
   *           // Do something when complete.
   *         }
   *       };
   *   ApiStreamObserver&lt;StreamingRecognizeRequest&gt; requestObserver =
   *       benchmarkServiceClient.streamingBothWaysCallable().bidiStreamingCall(responseObserver));
   *
   *   SimpleRequest request = SimpleRequest.newBuilder().build();
   *   requestObserver.onNext(request);
   * }
   * </code></pre>
   */
  public final StreamingCallable<SimpleRequest, SimpleResponse> streamingBothWaysCallable() {
    return streamingBothWaysCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }

}