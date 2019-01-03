/**
 */
package VNF_to_QPN.tests;

import VNF_to_QPN.VNF_to_QPNFactory;
import VNF_to_QPN.outPort;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>out Port</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class outPortTest extends PortTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(outPortTest.class);
	}

	/**
	 * Constructs a new out Port test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public outPortTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this out Port test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected outPort getFixture() {
		return (outPort) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VNF_to_QPNFactory.eINSTANCE.createoutPort());
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

} //outPortTest
