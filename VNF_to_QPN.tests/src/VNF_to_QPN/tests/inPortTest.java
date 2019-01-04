/**
 */
package VNF_to_QPN.tests;

import VNF_to_QPN.VNF_to_QPNFactory;
import VNF_to_QPN.inPort;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>in Port</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class inPortTest extends PortTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(inPortTest.class);
	}

	/**
	 * Constructs a new in Port test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public inPortTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this in Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected inPort getFixture() {
		return (inPort) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VNF_to_QPNFactory.eINSTANCE.createinPort());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //inPortTest
