/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.runtime.core.api.config;

import org.mule.runtime.api.meta.MuleVersion;

import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Decoupled {@link org.mule.runtime.core.api.MuleContext} metadata, used to evaluate {@link org.mule.runtime.api.config.Feature}
 * flags.
 *
 * @since 4.4.0
 */
public class FeatureContext {

  private final String artifactName;
  private final MuleVersion artifactMinMuleVersion;

  public FeatureContext(MuleVersion artifactMinMuleVersion, String artifactName) {
    this.artifactName = artifactName;
    this.artifactMinMuleVersion = artifactMinMuleVersion;
  }

  public Optional<MuleVersion> getArtifactMinMuleVersion() {
    return ofNullable(artifactMinMuleVersion);
  }

  public String getArtifactName() {
    return ofNullable(artifactName).orElse("");
  }
}
