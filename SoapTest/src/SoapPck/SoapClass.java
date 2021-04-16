package SoapPck;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.support.SoapUIException;

public class SoapClass {
	@Test
	public void Test() throws XmlException, IOException, SoapUIException
	{
		WsdlProject project=new WsdlProject("D:\\SOAPProjects\\GettingDataFromProperties-soapui-project.xml");
		//WsdlTestSuite testsuite=project.getTestSuiteByName("Employee");
		int totalsuites=project.getTestSuiteCount();
		System.out.println("________________________________Total Suites__________"+totalsuites);
		for(int j=0;j<project.getTestSuiteCount();j++)
		{
		WsdlTestSuite testsuite=project.getTestSuiteAt(j);
		System.out.println("TestSuite running::::::::"+project.getTestSuiteAt(j).getName());
		for(int i=0;i<testsuite.getTestCaseCount();i++)
		{
		System.out.println("*****************");
		WsdlTestCase testcase=testsuite.getTestCaseAt(i);
		TestRunner runner=testcase.run(new PropertiesMap(), false);
		}
		}
	}
}
