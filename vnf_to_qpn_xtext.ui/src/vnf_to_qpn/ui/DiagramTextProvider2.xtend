package vnf_to_qpn.ui

import net.sourceforge.plantuml.text.AbstractDiagramTextProvider
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IEditorInput
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.jface.viewers.ISelection
import java.util.Map
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
class DiagramTextProvider2 extends AbstractDiagramTextProvider {
     
    def DomainmodelDiagramTextProvider() {
        editorType = typeof(XtextEditor)
    }
								
	override protected getDiagramText(IEditorPart arg0, IEditorInput arg1, ISelection arg2, Map<String, Object> arg3) {
		val document = (arg0 as XtextEditor).getDocumentProvider().getDocument(arg1) as XtextDocument;
        val EList<EObject> contents = document.readOnly[
            return contents
        ]
        
        var service = contents.head as vnf_to_qpn.vnf.impl.ServiceImpl
        
        var vnfs = newArrayList
        var sources = newArrayList
        var vlinks = newArrayList
        var refs = newArrayList
        
        var String output = "allow_mixing\n"
        
        for (name : service.components) {
        	vnfs.add(name)
        }
        for (name : service.connectors) {
        	vlinks.add(name)
        }
        for (name : service.sources) {
        	sources.add(name)
        }
        
        for (vnf: vnfs) {
        	output= output+ '''object «vnf.vnfName» 
				«vnf.vnfName» : processingTime = «if (vnf.processingTime !== null) vnf.processingTime » 
				«vnf.vnfName» : resources = «if (vnf.resources !== null) vnf.resources»
				'''
			if(vnf.bwdPorts!==null){
       		for (p : vnf.bwdPorts.outPort) {
        		
        			output=output+'''component «p.name»
				'''
        		refs.add('''«vnf.vnfName» ..> «p.name» :bwd_OutPorts
        		''')
        			
        			
        			}
        	}
        	if(vnf.bwdPorts!==null){
        	for (p : vnf.bwdPorts.inPort) {
        		
        		output=output+'''component «p.name»
				'''
        		refs.add('''«vnf.vnfName» ..> «p.name» :bwd_InPorts
				''')
				
				
				
				}
        		}
        		if(vnf.fwdPorts!==null){
        	for (p : vnf.fwdPorts.outPort) {
        		
        		output=output+'''component «p.name»
				'''
        		refs.add('''«vnf.vnfName» ..> «p.name» :fwd_OutPorts
				''')
				
				
				}
				
          	}
          	if(vnf.fwdPorts!==null){
        	for (p : vnf.fwdPorts.inPort) {
        		
        		output=output+'''component «p.name»
				'''
        		refs.add('''«vnf.vnfName» ..> «p.name» :fwd_InPorts
				''')
			
				}
        	}
        	
        }
        for (source :sources) {
        	output= output+ '''object «source.sourceName» 
        	«source.sourceName» : generationPeroid = «if (source.generationPeriod !== null) source.generationPeriod»
			'''
        	        	
       		for (p : source.outPort) {
        		output=output+'''component «p.name»
				'''		
				refs.add('''«source.sourceName» ..> «p.name» :OutPorts
				''')
        	}
        	for (p : source.inPort) {
        		output=output+'''component «p.name»
				'''
				refs.add('''«source.sourceName» ..> «p.name» :InPorts
				''')
        		}	
        	
        }
        
        for (link: vlinks)
        {
        	output= output+'''«link.source.name» --> «link.target.name» : «link.VLinkName», «if (link.data_manipulation !== null) link.data_manipulation», «link.probability»
		'''
        }
        for(ref : refs)
        {
        	output = output+ref
        }
        
        
        // clean up this mess
        vlinks.clear()
        sources.clear()
        vnfs.clear()
        refs.clear()
        
        return output
        
    }
         
	
								
	override supportsSelection(ISelection arg0) {
		return false
	}
									
    			
}