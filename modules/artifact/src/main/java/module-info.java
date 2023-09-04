/*
 * Copyright 2023 Salesforce, Inc. All rights reserved.
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
/**
 * Mule Artifact Module.
 *
 * @moduleGraph
 * @since 4.6
 */
module org.mule.runtime.artifact {

  requires org.mule.runtime.api;
  requires org.mule.sdk.api;
  requires org.mule.runtime.artifact.declaration;
  requires org.mule.runtime.core;
  requires org.mule.runtime.jar.handling.utils;

  requires java.desktop;
  requires java.management;
  requires java.sql;

  exports org.mule.runtime.module.artifact.api;
  exports org.mule.runtime.module.artifact.api.classloader;
  exports org.mule.runtime.module.artifact.api.classloader.exception;
  exports org.mule.runtime.module.artifact.api.classloader.net;
  exports org.mule.runtime.module.artifact.api.descriptor;
  exports org.mule.runtime.module.artifact.api.plugin;
  exports org.mule.runtime.module.artifact.api.serializer;

  exports org.mule.runtime.module.artifact.internal.classloader to
      org.mule.runtime.artifact.activation,
      org.mule.runtime.extensions.support,
      org.mule.runtime.deployment.model,
      org.mule.test.runner;
  exports org.mule.runtime.module.artifact.internal.util to
      org.mule.runtime.container,
      org.mule.runtime.artifact.activation,
      org.mule.runtime.deployment.model,
      org.mule.test.runner;

}
