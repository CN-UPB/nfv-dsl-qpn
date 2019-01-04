package org.emoflon.ibex.tgg.run.transform_xtext_vnf.xtext.integration;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
 
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
 
import VNF_to_QPN_Rules.ServiceValidator;
import vnf_to_qpn.generator.ICSToASTransformation;
 
public class TransformTransformation implements ICSToASTransformation {
 
    private TransformApp app;
    private Collection<EObject> as;
    private Collection<EObject> cs;
 
    public TransformTransformation() throws IOException {
        app = new TransformApp();
    }
 
    @Override
    public Collection<String> generateASFromCS(Resource csResource) throws IOException {
 
        // Invoke TGG to get abstract syntax
        app.getSourceResource().getContents().addAll(EcoreUtil.copyAll(csResource.getContents()));
 
        try {
            app.forward();
        } catch (Exception e) {
            e.printStackTrace();
        }
        app.terminate();
         
        // Set models
        cs = new ArrayList<>();
        for (EObject csm : app.getSourceResource().getContents()) {
            cs.add(csm);
        }
         
        as = new ArrayList<>();
        for (EObject asm : app.getTargetResource().getContents()) {
            as.add(asm);
        }
                 
        // Check constraints
        ServiceValidator validator = new ServiceValidator();
         
        return validator.validateService(app.getTargetResource());
    }
 
    @Override
    public Resource getAS() {
        ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.createResource(URI.createURI("as"));
        r.getContents().addAll(as);
        return r;
    }
 
    @Override
    public Resource getCS() {
        ResourceSet rs = new ResourceSetImpl();
        Resource r = rs.createResource(URI.createURI("cs"));
        r.getContents().addAll(cs);
        return r;
    }
}