/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.tracer.customization.impl.provider;

import static org.mule.runtime.tracer.api.span.info.InitialExportInfo.DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO;
import static org.mule.runtime.tracer.api.span.info.InitialExportInfo.NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.ASYNC_INNER_CHAIN_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.CACHE_CHAIN_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.CONNECTION_CREATION_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.EXECUTE_NEXT_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.EXECUTION_TIME_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.MESSAGE_PROCESSORS_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.PARAMETER_RESOLUTION_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.POLICY_CHAIN_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.POLICY_NEXT_ACTION_SPAN_NAME;
import static org.mule.runtime.tracer.customization.api.InternalSpanNames.TRY_SCOPE_INNER_CHAIN_SPAN_NAME;
import static org.mule.runtime.tracer.customization.impl.info.SpanInitialInfoUtils.UNKNOWN;


import org.mule.runtime.tracer.api.span.info.InitialExportInfo;
import org.mule.runtime.tracer.customization.impl.export.AbstractInitialExportInfoProvider;
import org.mule.runtime.tracer.customization.impl.export.InitialExportInfoProvider;
import org.mule.runtime.tracer.customization.impl.export.NoExportTillSpanWithNameInitialExportInfo;
import org.mule.runtime.tracing.level.api.config.TracingLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * An {@link InitialExportInfoProvider} corresponding to the {@link TracingLevel#MONITORING}
 *
 * @since 4.6.0
 */
public class MonitoringInitialExportInfoProvider extends AbstractInitialExportInfoProvider {

  private final Map<String, InitialExportInfo> initialExportInfoMapByName = new HashMap<String, InitialExportInfo>() {

    {
      put(POLICY_CHAIN_SPAN_NAME,
          new NoExportTillSpanWithNameInitialExportInfo(EXECUTE_NEXT_SPAN_NAME, true));
      put(POLICY_NEXT_ACTION_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(UNKNOWN, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(ASYNC_INNER_CHAIN_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(TRY_SCOPE_INNER_CHAIN_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(CACHE_CHAIN_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(MESSAGE_PROCESSORS_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      // TODO: This will eventually change after implementing the debug spans (W-12658145)
      put(CONNECTION_CREATION_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(PARAMETER_RESOLUTION_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
      put(EXECUTION_TIME_SPAN_NAME, NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO);
    }
  };

  @Override
  protected InitialExportInfo doGetInitialExportInfoForDebugLevel() {
    return NO_EXPORTABLE_DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO;
  }

  @Override
  protected InitialExportInfo getDefaultInitialExportInfo() {
    return DEFAULT_EXPORT_SPAN_CUSTOMIZATION_INFO;
  }

  @Override
  protected Map<String, InitialExportInfo> getInitialExportInfoMapByName() {
    return initialExportInfoMapByName;
  }

}