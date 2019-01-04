package vnf_to_qpn.generator;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;

public interface IASToQPNTransformation {
	public abstract void generateQPNFromAS(Resource as) throws IOException;
	public abstract Resource getAS();
	public abstract Resource getQPN();
}
