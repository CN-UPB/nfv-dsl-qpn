/*
 * generated by Xtext 2.15.0
 */
package vnf_to_qpn.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import vnf_to_qpn.VnfRuntimeModule
import vnf_to_qpn.VnfStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class VnfIdeSetup extends VnfStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new VnfRuntimeModule, new VnfIdeModule))
	}
	
}