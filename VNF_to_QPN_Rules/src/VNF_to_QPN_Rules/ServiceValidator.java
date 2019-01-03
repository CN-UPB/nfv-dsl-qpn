package VNF_to_QPN_Rules;


import VNF_to_QPN_Rules.api.VNF_to_QPN_RulesDemoclesApp;
import VNF_to_QPN_Rules.api.VNF_to_QPN_RulesAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.framework.Bundle;

public class ServiceValidator extends VNF_to_QPN_RulesDemoclesApp {
	public Collection<String> validateService(Resource resource) throws IOException {
		Bundle bundle = Platform.getBundle("VNF_to_QPN_Rules");
		String path = FileLocator.resolve(bundle.getEntry("/")).getPath();
		VNF_to_QPN_RulesAPI.patternPath = "src-gen/VNF_to_QPN_Rules/api/ibex-patterns.xmi";
		
		VNF_to_QPN_RulesDemoclesApp app = new VNF_to_QPN_RulesDemoclesApp(path);
		app.getModel().getResources().add(resource);
		VNF_to_QPN_RulesAPI api = app.initAPI();

		//check all the rules and create message if not followed
		ArrayList<String> results = new ArrayList<>();
		
		if (!api.oneVNF().hasMatches()) 
			results.add("\n You need at least one VNF");
		
		if (!api.oneVNF().findMatches().stream().allMatch(m_p -> api.twoPortsAtVnfConclusion().bind(m_p).hasMatches()))
			results.add("\n Every VNF need at least one in and one out port");
		
		if (api.selfLinkPattern().hasMatches())
			results.add("\n A VNF can't have a vlink to itself");
		
		if (api.synchronizedPattern().hasMatches())
			results.add("\n If an inport has more than two ingoing vlinks it has to be synchronized");

		api.terminate();
		
		return results;
	}
	
}
