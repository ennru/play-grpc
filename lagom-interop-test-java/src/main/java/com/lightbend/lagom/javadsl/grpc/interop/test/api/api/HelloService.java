/*
 * Copyright (C) Lightbend Inc. <https://www.lightbend.com>
 */
package com.lightbend.lagom.javadsl.grpc.interop.test.api.api;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

/**
 * The Hello service interface.
 *
 * <p>This describes everything that Lagom needs to know about how to serve and consume the
 * HelloService.
 */
public interface HelloService extends Service {

  /** Example: curl http://localhost:9000/api/hello/Alice */
  ServiceCall<NotUsed, String> hello(String id);

  default Descriptor descriptor() {
    return named("hello").withCalls(pathCall("/api/hello/:id", this::hello)).withAutoAcl(true);
  }
}
