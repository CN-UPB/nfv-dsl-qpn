package org.emoflon.ibex.tgg.run.transform_vnf_qpn;

import java.io.IOException;

import org.emoflon.ibex.tgg.operational.strategies.OperationalStrategy;

/**
 * Generated by eMoflon::IBeX.
 * 
 * Do not edit this class. It is automatically generated and is kept in sync
 * with the imports in your Schema.tgg file.
 */
public class _SchemaBasedAutoRegistration {
	
	public static void register(OperationalStrategy strategy) throws IOException {
		strategy.loadAndRegisterMetamodel("platform:/resource/VNF/model/VNF.ecore");
		strategy.loadAndRegisterMetamodel("platform:/resource/QPN/model/QPN.ecore");
	}
	
}
