package org.emoflon.ibex.tgg.run.transform_vnf_qpn.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import vnf_to_qpn.generator.IASToQPNTransformation;
// import VNF_to_QPN_Rules.ServiceValidator;
 
public class TransformTransformation implements IASToQPNTransformation {
 
    private TransformApp app;
    private Collection<EObject> as;
    private Collection<EObject> qpn;
 
    public TransformTransformation() throws IOException {
        app = new TransformApp();
    }
 
 
 
	@Override
	public void generateQPNFromAS(Resource asResource) throws IOException {
		// Invoke TGG to get abstract syntax
        app.getSourceResource().getContents().addAll(EcoreUtil.copyAll(asResource.getContents()));
 
        try {
            app.forward();
        } catch (Exception e) {
            e.printStackTrace();
        }
        app.terminate();
         
        // Set models
        as = new ArrayList<>();
        for (EObject csm : app.getSourceResource().getContents()) {
            as.add(csm);
        }
         
        qpn = new ArrayList<>();
        for (EObject asm : app.getTargetResource().getContents()) {
            qpn.add(asm);
        }
		
	}
	
	@Override
    public Resource getAS() {
        ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.createResource(URI.createURI("as"));
        r.getContents().addAll(as);
        return r;
    }

	@Override
	public Resource getQPN() {
		ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.createResource(URI.createURI("qpn"));
        r.getContents().addAll(qpn);
        return r;
	}
}