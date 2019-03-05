//package com.cg.payroll.services.test;
//import com.cg.payroll.services.PayrollServices;


//public class PayrollServicesTest {
	//private static PayrollServices services;
	/*@BeforeClass
	public static void setUpTestEnv() {
		services=new PayrollServicesImpl();
	}
	@Before
	public void setUpTestData() {
		Associate associate1=new Associate(101, 78000, "Javed", "Syed"," IT", "ANALYST", "3214afasf", "jazz10syed@gmail.com", 
				new Salary(35000, 1800, 1800), new BankDetails(456456, "CITI", "CITI00000015"));
		Associate associate2=new Associate(102, 78500, "Apoorva", "Tiwari"," IT", "ANALYST", "879asdsa", "apoorv.tiwari@gmail.com", 
				new Salary(35000, 1800, 1800), new BankDetails(456456, "CITI", "CITI00000015"));PayrollDBUTIL.associates.put(associate1.getAssociateId(),associate1);
		PayrollDBUTIL.associates.put(associate2.getAssociateId(),associate2);
		
		PayrollDBUTIL.ASSOCIATE_ID_COUNTER=102;
	}
	@Test(expected=AssociateDetailNotfoundException.class)
	public void testGetAssociateDetailForInvalidAssociateId() throws AssociateDetailNotfoundException {
		services.getAssociateDetails(12343);
	}
	@Test
	public void testGetAssociateDetailsForValidAssociateId() throws AssociateDetailNotfoundException{
		Associate expectedAssociate=new Associate(101, 78000, "Javed", "Syed"," IT", "ANALYST", "3214afasf", "jazz10syed@gmail.com", 
				new Salary(35000, 1800, 1800), new BankDetails(456456, "CITI", "CITI00000015"));
		Associate actualAssociate= services.getAssociateDetails(101);
		Assert.assertEquals(expectedAssociate, actualAssociate);
		
	}
	@Test
	public void testAcceptAssociateDetailsForValidData() {
		int expectedId=103;
		int actualId=services.acceptAssociateDetails("xyz", "abc", "asfsaf@fda", "IT", 1500, "analyst", "dsgsgs", 15000, 500, 150, 150, 456321, "dsaga", "agae");
	}
	@Test(expected=AssociateDetailNotfoundException.class)
	public void testCalculateNetSalaryForInvalidAssociateId() throws AssociateDetailNotfoundException{
		services.calculateNetSalary(1434);
	}
	@Test
	public void testCalculateNetSalaryForValidAssociateId() throws AssociateDetailNotfoundException{
		int expectedNetSalary=819770;
		int actualNetSalary=services.calculateNetSalary(102);
		Assert.assertEquals(expectedNetSalary, actualNetSalary);
	}
	@Test
	public void testGetAllAssociateDetails() {
		Associate associate1=new Associate(101, 78000, "Javed", "Syed"," IT", "ANALYST", "3214afasf", "jazz10syed@gmail.com", 
				new Salary(35000, 1800, 1800), new BankDetails(456456, "CITI", "CITI00000015"));
		Associate associate2=new Associate(102, 78500, "Apoorva", "Tiwari"," IT", "ANALYST", "879asdsa", "apoorv.tiwari@gmail.com", 
				new Salary(35000, 1800, 1800), new BankDetails(456456, "CITI", "CITI00000015"));
		ArrayList<Associate> expectedAssociateList=new ArrayList<>();
		expectedAssociateList.add(associate1);
		expectedAssociateList.add(associate2);
		ArrayList<Associate>actualAssociateList=(ArrayList<Associate>)services.getAllAssociateDetails();
		Collections.sort(expectedAssociateList);
		Collections.sort(actualAssociateList);
		Assert.assertEquals(expectedAssociateList, actualAssociateList);
		
		
	}
	@After
	public void tearDownTestData() {
		PayrollDBUTIL.associates.clear();
		PayrollDBUTIL.ASSOCIATE_ID_COUNTER=100;
	}
	@AfterClass
	public static void TearDownTestEnv() {
		services=null;
	}

}*/
