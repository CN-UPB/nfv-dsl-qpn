package org.emoflon.ibex.tgg.run.transform_xtext_vnf.xtext.integration;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emoflon.ibex.tgg.compiler.patterns.PatternSuffixes;
import org.emoflon.ibex.tgg.operational.defaults.IbexOptions;
import org.emoflon.ibex.tgg.operational.strategies.sync.SYNC;
import org.emoflon.ibex.tgg.run.transform_xtext_vnf._RegistrationHelper;
import org.emoflon.ibex.tgg.runtime.engine.DemoclesTGGEngine;

public class TransformApp extends SYNC {

	public TransformApp() throws IOException {
		super(createIbexOptions());
		registerBlackInterpreter(new DemoclesTGGEngine());
	}
	
	@Override
	public boolean isPatternRelevantForCompiler(String patternName) {
		return patternName.endsWith(PatternSuffixes.FWD);
	}

	@Override
	public void loadModels() throws IOException {
		rs.getResources().clear();
		
		// Create all resources as the input resource will be provided by the editor
		s = createResource(options.projectPath() + "/instances/src.xmi");
		t = createResource(options.projectPath() + "/instances/trg.xmi");
		c = createResource(options.projectPath() + "/instances/corr.xmi");
		p = createResource(options.projectPath() + "/instances/protocol.xmi");

		EcoreUtil.resolveAll(rs);
	}
	
	@Override
	public void saveModels() throws IOException {
		// Do nothing
	}

	private static IbexOptions createIbexOptions() {
		// Adjust project path to plugin context
		return _RegistrationHelper.createIbexOptions().projectPath("platform:/plugin/Transform_Xtext_VNF");
	}

	@Override
	protected void registerUserMetamodels() throws IOException {
		_RegistrationHelper.registerMetamodels(rs, this);
			
		// Register correspondence metamodel last
		EPackage pack = loadAndRegisterCorrMetamodel(options.projectPath() + "/model/" + options.projectName() + ".ecore");
		
		// Make sure platform:/resource can be resolved properly
		Resource r = rs.getResource(URI.createURI(pack.getNsURI()), false);
		r.getContents().add(pack);
	}
}
