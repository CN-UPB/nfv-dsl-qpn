/**
 */
package VNF_to_QPN.tests;

import VNF_to_QPN.VNF;
import VNF_to_QPN.VNF_to_QPNFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>VNF</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class VNFTest extends TestCase {

	/**
	 * The fixture for this VNF test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VNF fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(VNFTest.class);
	}

	/**
	 * Constructs a new VNF test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VNFTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this VNF test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(VNF fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this VNF test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VNF getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(VNF_to_QPNFactory.eINSTANCE.createVNF());
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

} //VNFTest
