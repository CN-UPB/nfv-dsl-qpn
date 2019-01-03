package org.emoflon.ibex.tgg.run.transform_xtext_vnf;

import VNF.impl.VNFPackageImpl;
import vnf_to_qpn.vnf.VnfPackage;
import vnf_to_qpn.vnf.impl.VnfPackageImpl;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.emoflon.ibex.tgg.operational.csp.constraints.factories.transform_xtext_vnf.UserDefinedRuntimeTGGAttrConstraintFactory;
import org.emoflon.ibex.tgg.operational.defaults.IbexOptions;
import org.emoflon.ibex.tgg.operational.strategies.OperationalStrategy;


public class _RegistrationHelper {

	/** Load and register source and target metamodels */
	public static void registerMetamodels(ResourceSet rs, OperationalStrategy strategy) throws IOException {
		// Replace to register generated code or handle other URI-related requirements
		VNFPackageImpl.init();
		VnfPackageImpl.init();
		rs.getPackageRegistry().put("platform:/resource/vnf_to_qpn_xtext/model/generated/Vnf.ecore", VnfPackage.eINSTANCE);
	}

	/** Create default options **/
	public static IbexOptions createIbexOptions() {
		IbexOptions options = new IbexOptions();
		options.projectName("Transform_Xtext_VNF");
		options.projectPath("Transform_Xtext_VNF");
		options.debug(false);
		options.userDefinedConstraints(new UserDefinedRuntimeTGGAttrConstraintFactory());
		return options;
	}
}
