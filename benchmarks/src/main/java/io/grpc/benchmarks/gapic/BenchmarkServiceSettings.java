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
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.ApiExceptions;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.StreamingCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.grpc.benchmarks.proto.Messages.SimpleRequest;
import io.grpc.benchmarks.proto.Messages.SimpleResponse;
import io.grpc.benchmarks.proto.BenchmarkServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

import static io.grpc.MethodDescriptor.generateFullMethodName;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link BenchmarkServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (testing.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of unaryCall to 30 seconds:
 *
 * <pre>
 * <code>
 * BenchmarkServiceSettings.Builder benchmarkServiceSettingsBuilder =
 *     BenchmarkServiceSettings.defaultBuilder();
 * benchmarkServiceSettingsBuilder.unaryCallSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * BenchmarkServiceSettings benchmarkServiceSettings = benchmarkServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
public class BenchmarkServiceSettings extends ClientSettings {
  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES = ImmutableList.<String>builder()
      .add("https://www.googleapis.com/auth/cloud-platform")
      .add("https://www.googleapis.com/auth/pubsub")
      .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "//project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private static final io.grpc.MethodDescriptor<SimpleRequest, SimpleResponse> METHOD_UNARY_CALL =
        io.grpc.MethodDescriptor.create(
            io.grpc.MethodDescriptor.MethodType.UNARY,
            "grpc.testing.BenchmarkService/UnaryCall",
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleRequest.getDefaultInstance()),
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<SimpleRequest, SimpleResponse> METHOD_STREAMING_CALL =
      io.grpc.MethodDescriptor.<SimpleRequest, SimpleResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
          .setFullMethodName(generateFullMethodName(
              "grpc.testing.BenchmarkService", "StreamingCall"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.benchmarks.proto.Messages.SimpleRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.benchmarks.proto.Messages.SimpleResponse.getDefaultInstance()))
          .build();
  private static final io.grpc.MethodDescriptor<SimpleRequest, SimpleResponse> METHOD_STREAMING_FROM_CLIENT =
        io.grpc.MethodDescriptor.create(
            io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
            "grpc.testing.BenchmarkService/StreamingFromClient",
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleRequest.getDefaultInstance()),
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<SimpleRequest, SimpleResponse> METHOD_STREAMING_FROM_SERVER =
        io.grpc.MethodDescriptor.create(
            io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
            "grpc.testing.BenchmarkService/StreamingFromServer",
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleRequest.getDefaultInstance()),
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleResponse.getDefaultInstance()));
  private static final io.grpc.MethodDescriptor<SimpleRequest, SimpleResponse> METHOD_STREAMING_BOTH_WAYS =
        io.grpc.MethodDescriptor.create(
            io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
            "grpc.testing.BenchmarkService/StreamingBothWays",
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleRequest.getDefaultInstance()),
            io.grpc.protobuf.ProtoUtils.marshaller(SimpleResponse.getDefaultInstance()));

  private final SimpleCallSettings<SimpleRequest, SimpleResponse> unaryCallSettings;
  private final StreamingCallSettings<SimpleRequest, SimpleResponse> streamingCallSettings;
  private final StreamingCallSettings<SimpleRequest, SimpleResponse> streamingFromClientSettings;
  private final StreamingCallSettings<SimpleRequest, SimpleResponse> streamingFromServerSettings;
  private final StreamingCallSettings<SimpleRequest, SimpleResponse> streamingBothWaysSettings;

  /**
   * Returns the object with the settings used for calls to unaryCall.
   */
  public SimpleCallSettings<SimpleRequest, SimpleResponse> unaryCallSettings() {
    return unaryCallSettings;
  }

  /**
   * Returns the object with the settings used for calls to streamingCall.
   */
  public StreamingCallSettings<SimpleRequest, SimpleResponse> streamingCallSettings() {
    return streamingCallSettings;
  }

  /**
   * Returns the object with the settings used for calls to streamingFromClient.
   */
  public StreamingCallSettings<SimpleRequest, SimpleResponse> streamingFromClientSettings() {
    return streamingFromClientSettings;
  }

  /**
   * Returns the object with the settings used for calls to streamingFromServer.
   */
  public StreamingCallSettings<SimpleRequest, SimpleResponse> streamingFromServerSettings() {
    return streamingFromServerSettings;
  }

  /**
   * Returns the object with the settings used for calls to streamingBothWays.
   */
  public StreamingCallSettings<SimpleRequest, SimpleResponse> streamingBothWaysSettings() {
    return streamingBothWaysSettings;
  }


  /**
   * Returns a builder for the default ExecutorProvider for this service.
   */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /**
   * Returns the default service endpoint.
   */
  public static String getDefaultEndpoint() {
    return "testing.googleapis.com:443";
  }


  /**
   * Returns the default service scopes.
   */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }


  /**
   * Returns a builder for the default credentials for this service.
   */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        ;
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setEndpoint(getDefaultEndpoint())
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion = PropertiesProvider.loadProperty(
          BenchmarkServiceSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /**
   * Returns a builder for this class with recommended defaults.
   */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns a builder containing all the values of this settings class.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private BenchmarkServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(),
          settingsBuilder.getChannelProvider(),
          settingsBuilder.getCredentialsProvider());

    unaryCallSettings = settingsBuilder.unaryCallSettings().build();
    streamingCallSettings = settingsBuilder.streamingCallSettings().build();
    streamingFromClientSettings = settingsBuilder.streamingFromClientSettings().build();
    streamingFromServerSettings = settingsBuilder.streamingFromServerSettings().build();
    streamingBothWaysSettings = settingsBuilder.streamingBothWaysSettings().build();
  }




  /**
   * Builder for BenchmarkServiceSettings.
   */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final SimpleCallSettings.Builder<SimpleRequest, SimpleResponse> unaryCallSettings;
    private final StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingCallSettings;
    private final StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingFromClientSettings;
    private final StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingFromServerSettings;
    private final StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingBothWaysSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put(
          "non_idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
      definitions.put(
          "pull",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.CANCELLED, Status.Code.DEADLINE_EXCEEDED, Status.Code.RESOURCE_EXHAUSTED, Status.Code.INTERNAL, Status.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder = RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(100L))
          .setRetryDelayMultiplier(1.3)
          .setMaxRetryDelay(Duration.ofMillis(60000L))
          .setInitialRpcTimeout(Duration.ofMillis(60000L))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeout(Duration.ofMillis(60000L))
          .setTotalTimeout(Duration.ofMillis(600000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());
      setCredentialsProvider(defaultCredentialsProviderBuilder().build());

      unaryCallSettings = SimpleCallSettings.newBuilder(METHOD_UNARY_CALL);

      streamingCallSettings = StreamingCallSettings.newBuilder(METHOD_STREAMING_CALL);

      streamingFromClientSettings = StreamingCallSettings.newBuilder(METHOD_STREAMING_FROM_CLIENT);

      streamingFromServerSettings = StreamingCallSettings.newBuilder(METHOD_STREAMING_FROM_SERVER);

      streamingBothWaysSettings = StreamingCallSettings.newBuilder(METHOD_STREAMING_BOTH_WAYS);

      unaryMethodSettingsBuilders = ImmutableList.<UnaryCallSettings.Builder>of(
          unaryCallSettings
      );
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder.unaryCallSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(BenchmarkServiceSettings settings) {
      super(settings);

      unaryCallSettings = settings.unaryCallSettings.toBuilder();
      streamingCallSettings = settings.streamingCallSettings.toBuilder();
      streamingFromClientSettings = settings.streamingFromClientSettings.toBuilder();
      streamingFromServerSettings = settings.streamingFromServerSettings.toBuilder();
      streamingBothWaysSettings = settings.streamingBothWaysSettings.toBuilder();

      unaryMethodSettingsBuilders = ImmutableList.<UnaryCallSettings.Builder>of(
          unaryCallSettings
      );
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    @Override
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      super.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only
     * values that are non-null will be applied, so this method is not capable
     * of un-setting any values.
     *
     * Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to unaryCall.
     */
    public SimpleCallSettings.Builder<SimpleRequest, SimpleResponse> unaryCallSettings() {
      return unaryCallSettings;
    }

    /**
     * Returns the builder for the settings used for calls to streamingCall.
     */
    public StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingCallSettings() {
      return streamingCallSettings;
    }

    /**
     * Returns the builder for the settings used for calls to streamingFromClient.
     */
    public StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingFromClientSettings() {
      return streamingFromClientSettings;
    }

    /**
     * Returns the builder for the settings used for calls to streamingFromServer.
     */
    public StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingFromServerSettings() {
      return streamingFromServerSettings;
    }

    /**
     * Returns the builder for the settings used for calls to streamingBothWays.
     */
    public StreamingCallSettings.Builder<SimpleRequest, SimpleResponse> streamingBothWaysSettings() {
      return streamingBothWaysSettings;
    }

    @Override
    public BenchmarkServiceSettings build() throws IOException {
      return new BenchmarkServiceSettings(this);
    }
  }
}