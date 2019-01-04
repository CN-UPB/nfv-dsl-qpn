package vnf_to_qpn.generator;

import java.io.IOException;
import java.util.Collection;


import org.eclipse.emf.ecore.resource.Resource;

public interface ICSToASTransformation {
	public abstract Collection<String> generateASFromCS(Resource cs) throws IOException;
	public abstract Resource getAS();
	public abstract Resource getCS();
}
