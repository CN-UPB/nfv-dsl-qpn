package vnf_to_qpn.ui;

import net.sourceforge.plantuml.text.AbstractDiagramTextProvider;

import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.Model;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import VNF.Service;
import VNF.VNF_component;
import VNF.impl.VNFPackageImpl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class DiagramTextProvider1 extends AbstractDiagramTextProvider implements net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider   {

	public DiagramTextProvider1() {
		super(XtextEditor.class);
		System.out.println("DiagramTextProvider1");
		
	}

	@Override
	public String getDiagramText(IEditorPart editorInput, ISelection arg1) {
		System.out.println("getDiagramText All");
		if (editorInput instanceof XtextEditor) {
			XtextDocument document = (XtextDocument) ((XtextEditor)editorInput).getDocumentProvider().getDocument(editorInput);
			System.out.println(document);
			Model model = (Model) document.readOnly(x -> x.getContents().get(0));
			
			System.out.println(model.getState().toString());
			
			
			System.out.println("test2");
			
			
		}
		return null;
	}

	protected String getDiagramText(Resource res) {
		System.out.println("getDiagramText");
		StringBuilder buffer = new StringBuilder();
		Service root = (Service) EcoreUtil.getObjectByType(res.getContents(), VNFPackageImpl.eINSTANCE.getService());
		if(root != null)
		{
			EList<VNF_component> comp = root.getComponents();
			
			for(VNF_component vnf : comp) {
				appendVNF(vnf, buffer);
			}			
		}
		System.out.println(buffer.toString());
		return buffer.toString();
	}
	
	void appendVNF(VNF_component vnf, StringBuilder buffer) {
		buffer.append("object ");
		buffer.append(vnf.getName());
		buffer.append("\n");
	}
	
	
	
	
	@Override
	public boolean supportsEditor(IEditorPart editorPart) {
		return true;
	}

	@Override
	public boolean supportsSelection(ISelection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getDiagramText(IEditorPart arg0, IEditorInput arg1, ISelection arg2, Map<String, Object> arg3) {
		// TODO Auto-generated method stub
		return null;
	}

}
