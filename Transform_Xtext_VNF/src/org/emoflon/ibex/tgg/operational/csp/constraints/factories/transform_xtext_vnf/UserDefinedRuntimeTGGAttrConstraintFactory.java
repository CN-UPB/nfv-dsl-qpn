package org.emoflon.ibex.tgg.operational.csp.constraints.factories.transform_xtext_vnf;

import java.util.HashMap;
import java.util.HashSet;			

import org.emoflon.ibex.tgg.operational.csp.constraints.factories.RuntimeTGGAttrConstraintFactory;			

import org.emoflon.ibex.tgg.operational.csp.constraints.custom.transform_xtext_vnf.UserDefined_increase;

public class UserDefinedRuntimeTGGAttrConstraintFactory extends RuntimeTGGAttrConstraintFactory {

	public UserDefinedRuntimeTGGAttrConstraintFactory() {
		super();
	}
	
	@Override
	protected void initialize() {
		creators = new HashMap<>();
		creators.put("increase", () -> new UserDefined_increase());

		constraints = new HashSet<String>();
		constraints.addAll(creators.keySet());
	}
}
