/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * Definitions for setting configuration for tracing levels and overrides.
 * 
 * @moduleGraph
 * @since 4.6
 */
module org.mule.runtime.tracer.customization.api {

  requires org.mule.runtime.api;
  requires org.mule.runtime.tracer.api;

  exports org.mule.runtime.tracer.customization.api;
  
}