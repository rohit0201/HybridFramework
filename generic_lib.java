package GenericLib;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import DriverScript.Script;
import DriverScript.Xls_Reader;
import DriverScript.html_result;

public class generic_lib {
	String vActual,vactualResult,vExpected,vUrl,vObj,vValue;
	public WebElement ObjName =null;
	public boolean isEnbl;
	public boolean isempty, isSel, isDspl, Textvalue;
	public String currentDate, vActPerform;
	public String vIndex;
	public int IndVal;
	public List<WebElement> ObjExist;
	public Select drpdwn;
	public String def_Value;
	
	
	
	public void driverFunctions(String usedmethod,Xls_Reader xtd,String vModuleName,int m,html_result hr) throws Throwable
	{

		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\ObjectRepository\\objects.properties");
		prop.load(fis);
		switch(usedmethod)
		{
		case "fn_VerifyLaunchAppURL":
		{
			Thread.sleep(2000L);
			vExpected=xtd.getCellData(vModuleName, "Expected", m); 
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_VerifyLaunchAppURL(Script.vProjectUrl,hr,vExpected,vactualResult,vActPerform);
			Thread.sleep(3000L);
			break;
		}	

		case "fn_verifyTitle":
		{			   
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_verifyTitle(hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		case "fn_verifyElement":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_verifyElement(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		} 
		case "fn_verifyText":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_verifyText(vObj,vExpected,hr,vactualResult,vActPerform);			  
			break;
		}  
		case "fn_verifyErrorMsg":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_verifyErrorMsg(vObj,vExpected,hr,vactualResult,vActPerform);			  
			break;
		}  
		
		case "fn_SetValue":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vValue=xtd.getCellData(vModuleName, "Value", m);
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_SetValue(vObj,vValue,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		
		case "fn_uploadFile":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vValue=xtd.getCellData(vModuleName, "Value", m);
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_uploadFile(vObj,vValue,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}

		case "fn_Click":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			//vIndex = xtd.getCellData(vModuleName, "IndexValue", m);
			fn_Click(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		
		case "fn_JSClick":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			//vIndex = xtd.getCellData(vModuleName, "IndexValue", m);
			fn_JSClick(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		
		case "fn_DisplayText":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_DisplayText(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		
		case "fn_ClickMulElmnt":
		{			   
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vValue=xtd.getCellData(vModuleName, "Value", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vIndex = xtd.getCellData(vModuleName, "IndexValue", m);
			fn_ClickMulElmnt(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}

		case "fn_verEmpSave":
		{
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_verEmpSave(hr,vExpected,vactualResult,vActPerform);
			break;
		}
		
		case "fn_GetAlertText":
		{
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_GetAlertText(vExpected,hr,vactualResult,vActPerform);
			break;
		}
		
		case "fn_SwitchToWindow":
		{
			Thread.sleep(4000L);
			vExpected=xtd.getCellData(vModuleName, "Expected", m); 
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_SwitchToWindow(vExpected,hr,vactualResult,vActPerform);
			break;
		}

		case "fn_Wait":
		{
			Double d=Double.parseDouble(xtd.getCellData(vModuleName, "Object_Name", m));
			int timereq=d.intValue();
			Thread.sleep(timereq);
			break;
		}
		
		case "fn_Test":
		{
			WebDriverWait wait= new WebDriverWait(Script.driver, 200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='http://stage.apf.activatemedia.com/themes/classic/images/select2-spinner.gif']")));
		
			String PostTime=Script.driver.findElement(By.xpath("//small[contains(text(),'Posted')]")).getText();
			String ErrorMsg=Script.driver.findElement(By.xpath("//div[@id='message']")).getText(); 
		
			System.out.println("Last Uploading Time: "+PostTime);
			System.out.println("Uploading Error Message: "+ErrorMsg);
			    
			if(ErrorMsg.equalsIgnoreCase("An Internal error occurred. Please retry"))
				{
					System.out.println("Post has not been successfully uploaded");
				}
			else if(ErrorMsg.equalsIgnoreCase("We are sorry, an error occurred. We will fix it shortly."))
				{
					System.out.println("Post has not been successfully uploaded");
				}
			else
				{
					System.out.println("Successfully Uploaded");
				}
			break;
		}
		
		case "fn_RobotKeyEnter":
		{
			Robot r= new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			break;
		}
		case "fn_RobotKeyDown":
		{
			Script.robot.keyPress(KeyEvent.VK_DOWN);
			Script.robot.keyRelease(KeyEvent.VK_DOWN);
			Script.robot.keyPress(KeyEvent.VK_DOWN);
			Script.robot.keyRelease(KeyEvent.VK_DOWN);
			Script.robot.keyPress(KeyEvent.VK_DOWN);
			Script.robot.keyRelease(KeyEvent.VK_DOWN);
			break;
		}
		
		case "fn_FluentWait":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_FluentWait(vObj,hr);			  
			break;
		}
		
		case "fn_WebdriverWait":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_WebdriverWait(vObj,hr);			  
			break;
		}
		
		case "fn_WebdriverWaitPresenceAllElmnt":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_WebdriverWaitPresenceAllElmnt(vObj,hr);			  
			break;
		}
		
		case "fn_WebdriverWait_InvisibilityOfElmnt":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_WebdriverWait_InvisibilityOfElmnt(vObj,hr);			  
			break;
		}
		
		
		
		case "fn_iFrameSwitch":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_iFrameSwitch(vObj,  hr);
			break;
		}
		case "fn_NavigateURL":
		{
			String AdminURL= xtd.getCellData(vModuleName, "Object_Name", m);
			Script.driver.navigate().to(AdminURL);
			break;
		}
		case "fn_CheckBoxExist":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_CheckBoxExist(vObj, hr,vExpected,vactualResult,vActPerform);
			break;				
		}
		case "fn_getattribute":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_getattribute(vObj, hr);
			break;
		}
		case "fn_AllCheckboxClick":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);  
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			fn_CheckBoxExist(vObj, hr, vExpected,vactualResult,vActPerform);
			break;				
		}
		case "fn_MouseOver":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			fn_FluentWait(vObj,hr);			  
			break;
		}
		case "fn_GetVerCode":
		{
			fn_GetVerCode( );			  
			break;
		}

		case "fn_MouseMove2ndchild":
		{
			fn_MouseMove2ndchild( );			  
			break;
		}

		case "fn_DisableEmpty":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_DisableEmpty(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}

		case "fn_Disable":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_Disable(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}


		case "fn_Currentdate":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_Currentdate(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;


		}

		case "fn_PayrollMouseMove2ndchild":
		{
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_PayrollMouseMove2ndchild( hr,vExpected, vactualResult, vActPerform);			  
			break;
		}

		case "fn_MovePayrollToHR":
		{
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_MovePayrollToHR( hr,vExpected, vactualResult, vActPerform);			  
			break;
		}
		
		case "fn_selectedValueFrom_dropdown":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			def_Value=xtd.getCellData(vModuleName, "Value", m);
			fn_selectedValueFrom_dropdown(vObj,hr,vExpected,vactualResult,def_Value,vActPerform);			  
			break;
		}

		case "fn_IsnullDisable":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_IsnullDisable(vObj,hr,vExpected,vactualResult,vActPerform);
			break;

		}
		
		case "fn_DisableSelected":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_DisableSelected(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		
		case "fn_IsDisplayed":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_IsDisplayed(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}

		case "fn_PopUpRedirection":
		{
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_PopUpRedirection(hr, vExpected, vactualResult, vActPerform );			  
			break;
		}
		
		/*case "fn_GetEmpPayroll":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_GetEmpPayroll(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}*/
		
		case "fn_GetFinalEmpID":
		{
			fn_GetFinalEmpID( );			  
			break;
		}
		
		
		case "fn_VerifySyncHR":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_VerifySyncHR(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		
		case "fn_ClickonArrow":
		{
			vObj=prop.getProperty(xtd.getCellData(vModuleName, "Object_Name", m));
			vExpected=xtd.getCellData(vModuleName, "Expected", m);
			vactualResult=xtd.getCellData(vModuleName, "Actual", m);
			vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
			fn_ClickonArrow(vObj,hr,vExpected,vactualResult,vActPerform);			  
			break;
		}
		

		}
	}
	
	public void fn_ClickonArrow(String vObj, html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		
		WebDriverWait wait = new WebDriverWait(Script.driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='select2-arrow']")));
		Script.driver.findElements(By.xpath("//span[@class='select2-arrow']")).get(3).click();
		      
		

	}
	
	public void fn_VerifySyncHR(String vObj, html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		
		Script.driver.switchTo().frame(Script.driver.findElement(By.id("frame_9E72BE3C-3B5F-E611-9507-00188B35784DTLMH")));
		Script.driver.findElement(By.id("txtempid")).sendKeys(Script.txtEmpID);
		Thread.sleep(8000);
		Script.driver.findElement(By.linkText(Script.txtEmpID)).click();
		Thread.sleep(3000);
		
		String Syncmsg=	Script.driver.findElement(By.xpath("//span[@id='lblSyncWithPayroll']")).getText();
		
		System.out.println(Syncmsg);
		
		if(Syncmsg.equalsIgnoreCase("Employee and Hours Sync"))
		{
			System.out.println("PASS");
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_VerifySyncHR", vExpected, vactualResult, "PASS");
		}
		else
		{
			System.out.println("FAIL");
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_VerifySyncHR", vExpected, "Employee Not Synced", "FAIL");
			hr.fgCloseFile(Script.ResFilePath);
			Script.TC_StatusCount=Script.TC_StatusCount+1;
		}
		
		      
		

	}
	public void fn_GetFinalEmpID() throws Throwable
	{
		Script.txtEmpID = Script.driver.findElement(By.id("txtEmployeeID")).getAttribute("value");
		System.out.println(Script.txtEmpID);
		
	}
	
	/*public void fn_GetEmpPayroll(String vObj, html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		
		System.out.println(Script.txtEmpID);
		
		boolean isvalid=true;

		int pageCount = Script.driver.findElements(By.xpath("//ul//li//a[@class='k-link']")).size();
		
		for(int i=0;i<=pageCount;i++)
		{

			int row, column;
			WebElement mytable = Script.driver.findElement(By.tagName("tbody"));
			List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
			int rows_count = rows_table.size();

			for (row = 0; row < rows_count; row++) {
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				int columns_count = Columns_row.size();


				for (column = 0; column < columns_count; column++) {
					String celtext = Columns_row.get(column).getText();

					if(celtext.equalsIgnoreCase(Script.txtEmpID))
					{
						int a= column+3;
						int b= row+1;
						Script.driver.findElement(By.xpath("//tbody/tr["+b+"]/td["+a+"]")).click();
						
						Thread.sleep(2000L);
						
						 Robot robot = new Robot();
						 robot.keyPress(KeyEvent.VK_DOWN);
						    robot.keyRelease(KeyEvent.VK_DOWN);
						    robot.keyPress(KeyEvent.VK_DOWN);
						    robot.keyRelease(KeyEvent.VK_DOWN);
						    robot.keyPress(KeyEvent.VK_ENTER);
						    robot.keyRelease(KeyEvent.VK_ENTER);
						    robot.delay(200);

						isvalid=false;
						break;                  
					}           
				}

				if(isvalid == false)
					break;
			}

			if(isvalid == true)
				Script.driver.findElement(By.xpath("//a[@title='Go to the next page']")).click();        
		}
		hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_GetEmpPayroll", vExpected, vactualResult, "PASS");
	}*/
	
	

	public void fn_PopUpRedirection( html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{

		Set<String> wind=Script.driver.getWindowHandles();
		Iterator<String> iter=wind.iterator();
		String firstwindow=iter.next();
		String secondwind=iter.next();				
		Script.driver.switchTo().window(secondwind);
		System.out.println("End");
		
		Thread.sleep(4000L);
		if(Script.driver.getTitle().trim().equalsIgnoreCase("PrimePay - Online Payroll and HR Services"))
		{
			System.out.println("Switched to 2nd window");
		}
		else{
			System.out.println("Not Switched to 2nd window");
			
		}
		Script.driver.close();
		Thread.sleep(4000L);
		Script.driver.switchTo().window(firstwindow);
		Thread.sleep(2000L);
		Script.driver.switchTo().frame(Script.driver.findElement(By.id("frame_E320BA15-9538-E611-8CF5-0050569C72A7TLM")));
		
		hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_PopUpRedirection", vExpected, vactualResult, "PASS");

	}
	public void fn_IsDisplayed(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				isDspl=Script.driver.findElement(By.xpath(vObj[1])).isDisplayed();
				break;
			case "name":
				isDspl=Script.driver.findElement(By.name(vObj[1])).isDisplayed();
				break;
			case "id":
				isDspl=Script.driver.findElement(By.id(vObj[1])).isDisplayed();
				break;
			case "cssSelector":
				isDspl=Script.driver.findElement(By.cssSelector(vObj[1])).isDisplayed();
				break;
			case "linkText":
				isDspl=Script.driver.findElement(By.linkText(vObj[1])).isDisplayed();
				break;
			}


			if(isDspl == false)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Disable", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Disable", vExpected, "Field is not disabled ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyElement", "Element should be Prsent", "Element is not displaying successfuly ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	
	public void fn_DisableSelected(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				isEnbl=Script.driver.findElement(By.xpath(vObj[1])).isEnabled();
				isSel=Script.driver.findElement(By.xpath(vObj[1])).isSelected();
				break;
			case "name":
				isEnbl=Script.driver.findElement(By.name(vObj[1])).isEnabled();
				isSel=Script.driver.findElement(By.name(vObj[1])).isSelected();
				break;
			case "id":
				isEnbl=Script.driver.findElement(By.id(vObj[1])).isEnabled();
				isSel=Script.driver.findElement(By.id(vObj[1])).isSelected();
				break;
			case "cssSelector":
				isEnbl=Script.driver.findElement(By.cssSelector(vObj[1])).isEnabled();
				isSel=Script.driver.findElement(By.cssSelector(vObj[1])).isSelected();
				break;
			case "linkText":
				isEnbl=Script.driver.findElement(By.linkText(vObj[1])).isEnabled();
				isSel=Script.driver.findElement(By.linkText(vObj[1])).isSelected();
				break;
			}


			if(isEnbl == false && isSel == true)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableSelected", vExpected, vactualResult, "PASS");
			}
			else if (isEnbl == false && isSel == false)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableSelected", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableSelected", vExpected, "Field is not disabled ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableSelected", vExpected, "Element is not displaying successfuly ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}

	
	
	
	public void fn_IsnullDisable(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {

			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				isEnbl=Script.driver.findElement(By.xpath(vObj[1])).isEnabled();
				Textvalue=Script.driver.findElement(By.xpath(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "name":
				isEnbl=Script.driver.findElement(By.name(vObj[1])).isEnabled();
				Textvalue=Script.driver.findElement(By.name(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "id":
				isEnbl=Script.driver.findElement(By.id(vObj[1])).isEnabled();
				Textvalue=Script.driver.findElement(By.id(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "cssSelector":
				isEnbl=Script.driver.findElement(By.cssSelector(vObj[1])).isEnabled();
				Textvalue=Script.driver.findElement(By.cssSelector(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "linkText":
				isEnbl=Script.driver.findElement(By.linkText(vObj[1])).isEnabled();
				Textvalue=Script.driver.findElement(By.linkText(vObj[1])).getAttribute("value").isEmpty();
				break;
			}



			if(Textvalue== true && isEnbl == false)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_IsnullDisable", vExpected,vactualResult , "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_IsnullDisable", vExpected,  vactualResult, "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_IsnullDisable", vExpected, def_Value+ "is not selected ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}


	public void fn_selectedValueFrom_dropdown(String vObjString,html_result hr,String vExpected, String vactualResult,String def_Value,String vActPerform) throws Throwable
	{
		try {

			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				drpdwn=new Select(Script.driver.findElement(By.xpath(vObj[1])));
				break;
			case "name":
				drpdwn=new Select(Script.driver.findElement(By.name(vObj[1])));
				break;
			case "id":
				drpdwn=new Select(Script.driver.findElement(By.id(vObj[1])));
				break;
			case "cssSelector":
				drpdwn=new Select(Script.driver.findElement(By.cssSelector(vObj[1])));
				break;
			case "linkText":
				drpdwn=new Select(Script.driver.findElement(By.linkText(vObj[1])));
				break;
			}

			WebElement option = drpdwn.getFirstSelectedOption();
			String drpdwntvalue=option.getText();

			if(drpdwntvalue.equalsIgnoreCase(def_Value))
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_selectedValueFrom_dropdown", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_selectedValueFrom_dropdown", vExpected, def_Value+ "is not selected ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_selectedValueFrom_dropdown", vExpected, def_Value+ "is not selected ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}

	public void fn_MovePayrollToHR( html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		
		Script.driver.switchTo().defaultContent();
		Actions action = new Actions(Script.driver);


		WebElement we = Script.driver.findElement(By.xpath("//li[contains(text(), 'Active Menu Services')]"));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000L);

		WebElement we1 = Script.driver.findElement(By.xpath("//img[@src='web/jqwidgets/styles/images/close.png']"));
		action.moveToElement(we1).click().build().perform();
		Thread.sleep(10000L);
		
		WebElement we2 = Script.driver.findElement(By.xpath("//li[contains(text(), 'HR & ACA')]"));
		action.moveToElement(we2).build().perform();
		Thread.sleep(2000L);

		WebElement we3 = Script.driver.findElement(By.xpath("//li[contains(text(), 'HR & Benefits')]"));
		action.moveToElement(we3).build().perform();
		Thread.sleep(2000L);

		WebElement we4 = Script.driver.findElement(By.xpath("//a[@id='9E72BE3C-3B5F-E611-9507-00188B35784DTLMH']"));
		action.moveToElement(we4).click().build().perform();
		
		hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_MovePayrollToHR", vExpected, vactualResult, "PASS");

	
	}
	
	public void fn_PayrollMouseMove2ndchild( html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		
		Script.driver.switchTo().defaultContent();
		Actions action = new Actions(Script.driver);


		WebElement we = Script.driver.findElement(By.xpath("//li[contains(text(), 'Active Menu Services')]"));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000L);

		WebElement we1 = Script.driver.findElement(By.xpath("//img[@src='web/jqwidgets/styles/images/close.png']"));
		action.moveToElement(we1).click().build().perform();
		Thread.sleep(10000L);
		
		WebElement we2 = Script.driver.findElement(By.xpath("//li[contains(text(), 'Payroll')]"));
		action.moveToElement(we2).build().perform();
		Thread.sleep(2000L);

		WebElement we3 = Script.driver.findElement(By.xpath("//li[contains(text(), 'Administer Payroll')]"));
		action.moveToElement(we3).build().perform();
		Thread.sleep(2000L);

		WebElement we4 = Script.driver.findElement(By.xpath("//a[@id='7D2306C3-A96A-44DC-AA4F-1A3AD3C9FB40P2PClient']"));
		action.moveToElement(we4).click().build().perform();
		
		hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_PayrollMouseMove2ndchild", vExpected, vactualResult, "PASS");

	
	}

	public void fn_Currentdate(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				currentDate=Script.driver.findElement(By.xpath(vObj[1])).getAttribute("value");
				break;
			case "name":
				currentDate=Script.driver.findElement(By.name(vObj[1])).getAttribute("value");
				break;
			case "id":
				currentDate=Script.driver.findElement(By.id(vObj[1])).getAttribute("value");
				break;
			case "cssSelector":
				currentDate=Script.driver.findElement(By.cssSelector(vObj[1])).getAttribute("value");
				break;
			case "linkText":
				currentDate=Script.driver.findElement(By.linkText(vObj[1])).getAttribute("value");
				break;
			}

			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date curdate = new Date();	
			String Time=dateFormat.format(curdate);


			if(currentDate.equalsIgnoreCase(Time))
			{
				System.out.println("PASS");
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Currentdate", vExpected, vactualResult, "PASS");
			}
			else
			{
				System.out.println("FAIL");
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Currentdate", vExpected, "Date is not a current date ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Currentdate", vExpected, "Date is not a current date ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}


	public void fn_Disable(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				isEnbl=Script.driver.findElement(By.xpath(vObj[1])).isEnabled();
				break;
			case "name":
				isEnbl=Script.driver.findElement(By.name(vObj[1])).isEnabled();
				break;
			case "id":
				isEnbl=Script.driver.findElement(By.id(vObj[1])).isEnabled();
				break;
			case "cssSelector":
				isEnbl=Script.driver.findElement(By.cssSelector(vObj[1])).isEnabled();
				break;
			case "linkText":
				isEnbl=Script.driver.findElement(By.linkText(vObj[1])).isEnabled();
				break;
			}


			if(isEnbl == false)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Disable", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Disable", vExpected, "Field is not disabled ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyElement", "Element should be Prsent", "Element is not displaying successfuly ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}

	public void fn_DisableEmpty(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				isEnbl=Script.driver.findElement(By.xpath(vObj[1])).isEnabled();
				isempty=Script.driver.findElement(By.xpath(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "name":
				isEnbl=Script.driver.findElement(By.name(vObj[1])).isEnabled();
				isempty=Script.driver.findElement(By.name(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "id":
				isEnbl=Script.driver.findElement(By.id(vObj[1])).isEnabled();
				isempty=Script.driver.findElement(By.id(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "cssSelector":
				isEnbl=Script.driver.findElement(By.cssSelector(vObj[1])).isEnabled();
				isempty=Script.driver.findElement(By.cssSelector(vObj[1])).getAttribute("value").isEmpty();
				break;
			case "linkText":
				isEnbl=Script.driver.findElement(By.linkText(vObj[1])).isEnabled();
				isempty=Script.driver.findElement(By.linkText(vObj[1])).getAttribute("value").isEmpty();
				break;
			}


			if(isEnbl == false && isempty == true)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableEmpty", vExpected, vactualResult, "PASS");
			}
			else if (isEnbl == false && isempty == false)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableEmpty", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisableEmpty", vExpected, "Field is not disabled and have some value ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyElement", "Element should be Prsent", "Element is not displaying successfuly ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}



	public void fn_MouseMove2ndchild( ) throws Throwable
	{

		Actions action = new Actions(Script.driver);

		WebElement we = Script.driver.findElement(By.xpath("//li[contains(text(), 'HR & ACA')]"));
		action.moveToElement(we).build().perform();
		Thread.sleep(2000L);

		WebElement we1 = Script.driver.findElement(By.xpath("//li[contains(text(), 'HR & Benefits')]"));
		action.moveToElement(we1).build().perform();
		Thread.sleep(2000L);

		WebElement we2 = Script.driver.findElement(By.xpath("//a[@id='9E72BE3C-3B5F-E611-9507-00188B35784DTLMH']"));
		action.moveToElement(we2).click().build().perform();
	}


	public void fn_GetVerCode( ) throws Throwable
	{
		WebDriver driver1=new FirefoxDriver();
		driver1.get("https://mail.primepay.com");
		driver1.manage().window().maximize();
		driver1.findElement(By.name("username")).sendKeys("IT\\sahil.verma");
		driver1.findElement(By.name("password")).sendKeys("r00lingtr@in#");
		driver1.findElement(By.xpath("//input[@class='btn']")).click();

		WebDriverWait wait=new WebDriverWait(driver1,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("txtS")));
		
		driver1.findElement(By.id("txtS")).sendKeys("userenrollment@primepay.com");
		driver1.findElement(By.id("imgS")).click();
		
		Thread.sleep(4000L);

		new FluentWait<WebDriver>(driver1).withTimeout(60,TimeUnit.SECONDS).
		pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//*[@id='divBdy']/div/div")));
		
		Thread.sleep(6000L);

		String WE = driver1.findElement(By.xpath("//*[@id='divBdy']/div/div")).getText().trim();
		String Code=WE.substring(197,203);
		driver1.quit();

		System.out.println(WE.substring(197,203));

		new FluentWait<WebDriver>(Script.driver).withTimeout(60,TimeUnit.SECONDS).
		pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.
				visibilityOfElementLocated(By.id("browserregistration_text_validationKey")));
		
		Thread.sleep(5000);
		
		Script.driver.findElement(By.id("browserregistration_text_validationKey")).sendKeys(Code);
	}

	public void fn_VerifyLaunchAppURL(String vUrl,html_result hr, String vExpected, String vactualResult, String vActPerform) throws Throwable
	{
		try {
			String CurrentURL= Script.driver.getCurrentUrl();
			if(CurrentURL.equalsIgnoreCase(vExpected))
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_VerifyLaunchAppURL", vExpected, "URL has been Veriified successfully", "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_VerifyLaunchAppURL", vExpected, "URL has not been Verified ", "FAIL");
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
			
			
			
		}catch(Throwable t){
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_VerifyLaunchAppURL", vExpected, "URL has not been Verified ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;

		}

	}

	public void fn_verifyTitle(html_result hr, String vExpected, String vactualResult, String vActPerform) throws Throwable
	{
		try {
			vActual=Script.driver.getTitle();
			if(vActual.equals(vExpected))
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "Fn_verifyTitle", "verify Title as "+vExpected, "Expected Title has been matched successfully ", "PASS");
			}		
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "Fn_verifyTitle", "verify Title as "+vExpected, "Expected Title has not been matched ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);	
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "Fn_verifyTitle", "verify Title as "+vExpected, "Expected Title has not been matched ", "FAIL");
			hr.fgCloseFile(Script.ResFilePath);	
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}

	public void fn_verifyElement(String vObjString,html_result hr,String vExpected, String vactualResult ,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}


			if((ObjExist.size())==1)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyElement", vExpected, vactualResult, "PASS");
			}
			
			else if((ObjExist.size())>1)
			{
				ObjExist.get(0);
			}
			
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyElement", vExpected, "Element is not displaying successfuly ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyElement", "Element should be Prsent", "Element is not displaying successfuly ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}

	public void fn_verifyErrorMsg(String vObjString,String vExpected,html_result hr, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

			
			if(ObjName.getText().equalsIgnoreCase("An Internal error occurred. Please retry"))
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyErrorMsg", vExpected, "Error: An Internal error occurred. Please retry ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
			
			else if(ObjName.getText().equalsIgnoreCase("We are sorry, an error occurred. We will fix it shortly."))
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyErrorMsg", vExpected, "Error: We are sorry, an error occurred. We will fix it shortly.", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyErrorMsg", vExpected, "No Error Message found.", "PASS");
			}
			
			System.out.println("Uploading Error Message: "+ObjName.getText());

		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyErrorMsg", vExpected, "Error:Exception found ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
		}
	}
	
	public void fn_verifyText(String vObjString,String vExpected,html_result hr, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

			if(ObjName.getText().equals(vExpected))
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyText", vExpected, "Verified Text", "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyText", vExpected, "Text is not verified", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verifyText", vExpected, "Text is not verified ", "FAIL");
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
		}
	}

	public void fn_uploadFile(String vObjString,String vValue,html_result hr, String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}
			
			HighlightElement(Script.driver,ObjName);
			ObjName.sendKeys(vValue);
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_uploadFile", vExpected, "File Uploaded Successfully", "PASS");

		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_uploadFile", vExpected, "File has not been Uploaded Successfully ", "FAIL");

			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	
	public void fn_SetValue(String vObjString,String vValue,html_result hr, String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

			if((ObjExist.size())==1)
			{
				HighlightElement(Script.driver,ObjName);
				if(ObjName.getTagName().equalsIgnoreCase("input"))
				{
					ObjName.clear();
				}
				ObjName.sendKeys(vValue);
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_SetValue", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_SetValue", vExpected, "Element is not entered  ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_SetValue", vExpected, "Element is not entered  ", "FAIL");

			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}

	public void fn_ClickMulElmnt(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
		
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
			
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

		
			
			 if((ObjExist.size())>1)
			{
				Double d=Double.parseDouble(vIndex);
				IndVal=d.intValue();
				HighlightElement(Script.driver,ObjExist.get(IndVal));
				ObjExist.get(IndVal).click();
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_ClickMulElmnt", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_ClickMulElmnt", vExpected, "Element is not clicked successfully ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_ClickMulElmnt", vExpected, "Element is not clicked successfully ", "FAIL");		
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	
	public void fn_DisplayText(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}
			Thread.sleep(3000);
			String PostTime=ObjExist.get(0).getText();
			HighlightElement(Script.driver,ObjExist.get(0));
			System.out.println("Last Uploading Time: "+PostTime);
			if((PostTime.length())==17)
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisplayText", vExpected, vactualResult+PostTime, "PASS");
			}
			else
			{
			
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisplayText", vExpected, vactualResult+PostTime+" Post has not been updated", "FAIL");
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
			
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_DisplayText", vExpected, "Post has not been updated ", "FAIL");		
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	
	public void fn_Click(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

			if((ObjExist.size())==1)
			{
				HighlightElement(Script.driver,ObjName);
				ObjName.click();
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Click", vExpected, vactualResult, "PASS");
			}
			
			/*else if((ObjExist.size())>1)
			{
				HighlightElement(Script.driver,ObjExist.get(IndVal));
				Double db1 = null;
				 double dbl = Double.parseDouble(vIndex);
			//	System.out.println(db1);
				IndVal=db1.intValue();
			//	System.out.println(IndVal);
				ObjExist.get(3).click();
				System.out.println("click done");
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Click", vExpected, vactualResult, "PASS");
			}*/
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Click", vExpected, "Element is not clicked successfully ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Click", vExpected, "Element is not clicked successfully ", "FAIL");		
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	
	public void fn_JSClick(String vObjString,html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

			if((ObjExist.size())==1)
			{
				HighlightElement(Script.driver,ObjName);
				JavascriptExecutor executor = (JavascriptExecutor)Script.driver;
				executor.executeScript("arguments[0].click();", ObjName);
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_JSClick", vExpected, vactualResult, "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_JSClick", vExpected, "Element is not clicked successfully ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_JSClick", vExpected, "Element is not clicked successfully ", "FAIL");		
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	
	public void fn_verEmpSave(html_result hr,String vExpected, String vactualResult,String vActPerform) throws Throwable
	{
		try {
			String emp1= Script.driver.findElement(By.xpath("//span[@id='cphMain_HREmpSearch_lblEmpName']")).getText();
			System.out.println(emp1);
			String Empname=emp1.replace(" ", "");
			System.out.println(Empname);
			String lastname=Script.driver.findElement(By.id("txtLastName")).getAttribute("value");
			String firstname=Script.driver.findElement(By.id("txtFirstName")).getAttribute("value");
			
			String fullname=lastname +","+ firstname ;
			 if(Empname.equalsIgnoreCase(fullname))
			 {
				 System.out.println("PASS");
				hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verEmpSave", vExpected, vactualResult, "FAIL");	
			 }
			 else
			 {
				 System.out.println("FAIL");
				 hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_verEmpSave", vExpected, "Element is not verified ", "FAIL");
				 Script.TC_StatusCount=Script.TC_StatusCount+1;
			 }
		}catch(Throwable t){
			System.out.println(t.getMessage());
			hr.fgInsertResult(Script.ResFilePath,vActPerform, "fn_Click", vExpected, "Element is not verified ", "FAIL");		
			Script.TC_StatusCount=Script.TC_StatusCount+1;
			ObjName=null;
		}
	}
	

	public void fn_GetAlertText(String exp,html_result hr, String vactualResult,String vActPerform) throws Throwable
	{			
		try {
			Alert alert=Script.driver.switchTo().alert();
			String msg=alert.getText();

			if(msg.trim().equals(exp))	
			{
				alert.accept();
				hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, exp, exp, "PASS");			
			}
			else
			{
				alert.accept();
				hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, exp, "Element is displaying successfuly ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
				Script.TC_StatusCount=Script.TC_StatusCount+1;
			}

		}catch(Throwable t){
			System.out.println(t.getMessage());
			ObjName=null;
		}

	}

	public void fn_SwitchToWindow(String exp,html_result hr, String vactualResult,String vActPerform) throws Throwable
	{	
		try {
			System.out.println("start");
			Set<String> wind=Script.driver.getWindowHandles();
			Iterator<String> iter=wind.iterator();
			String firstwindow=iter.next();
			String secondwind=iter.next();				
			///this script is used for window handler
			Script.driver.switchTo().window(secondwind);
			System.out.println("End");
			Thread.sleep(4000L);
			if(Script.driver.getTitle().trim().equalsIgnoreCase(exp))	
			{			
				hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "PASS");		
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");			
				hr.fgCloseFile(Script.ResFilePath);
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			ObjName=null;
		}

	} 

	public void fn_FluentWait(String vObjString,html_result hr) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":			       
				new FluentWait<WebDriver>(Script.driver).withTimeout(40,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(vObj[1])));
				break;
			case "name":
				new FluentWait<WebDriver>(Script.driver).withTimeout(40,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.visibilityOfElementLocated(By.name(vObj[1])));
				break;
			case "id":
				new FluentWait<WebDriver>(Script.driver).withTimeout(40,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.visibilityOfElementLocated(By.id(vObj[1])));
				break;
			case "cssSelector":
				new FluentWait<WebDriver>(Script.driver).withTimeout(40,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(vObj[1])));
				break;
			case "linkText":
				new FluentWait<WebDriver>(Script.driver).withTimeout(40,TimeUnit.SECONDS).pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchMethodException.class).until(ExpectedConditions.visibilityOfElementLocated(By.linkText(vObj[1])));
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());

		}
	}
	
	public void fn_WebdriverWait(String vObjString,html_result hr) throws Throwable
	{
		
		WebDriverWait wait = new WebDriverWait(Script.driver, 30);
		
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":	
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(vObj[1])));
				break;
			case "name":
				wait.until(ExpectedConditions.elementToBeClickable(By.name(vObj[1])));
				break;
			case "id":
				wait.until(ExpectedConditions.elementToBeClickable(By.id(vObj[1])));
				break;
			case "cssSelector":
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(vObj[1])));
				break;
			case "linkText":
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(vObj[1])));
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());

		}
	}
	
	public void fn_WebdriverWait_InvisibilityOfElmnt(String vObjString,html_result hr) throws Throwable
	{
		
		WebDriverWait wait = new WebDriverWait(Script.driver, 200);
		
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":	
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(vObj[1])));
				break;
			case "name":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(vObj[1])));
				break;
			case "id":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(vObj[1])));
				break;
			case "cssSelector":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(vObj[1])));
				break;
			case "linkText":
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(vObj[1])));
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());

		}
	}
	
	public void fn_WebdriverWaitPresenceAllElmnt(String vObjString,html_result hr) throws Throwable
	{
		
		WebDriverWait wait = new WebDriverWait(Script.driver, 30);
		
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":	
				
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(vObj[1])));
				break;
			case "name":
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(vObj[1])));
				break;
			case "id":
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(vObj[1])));
				break;
			case "cssSelector":
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(vObj[1])));
				break;
			case "linkText":
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(vObj[1])));
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());

		}
	}


	public void HighlightElement(WebDriver driver, WebElement ObjName) throws InterruptedException{
		{

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", ObjName);

			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", ObjName);

		}
	}


	public void fn_iFrameSwitch(String SBObjString, html_result hr) throws Throwable
	{
		try{
			String[] SBObj=SBObjString.split("@@@");
			switch(SBObj[0])
			{
			case "xpath":
				Script.driver.switchTo().frame(Script.driver.findElement(By.xpath(SBObj[1])));
				break;
			case "name":
				Script.driver.switchTo().frame(Script.driver.findElement(By.name(SBObj[1])));
				break;
			case "id":
				Script.driver.switchTo().frame(Script.driver.findElement(By.id(SBObj[1])));
				break;
			case "cssSelector":
				Script.driver.switchTo().frame(Script.driver.findElement(By.cssSelector(SBObj[1])));
				break;
			case "linkText":
				Script.driver.switchTo().frame(Script.driver.findElement(By.linkText(SBObj[1])));
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//			hr.fg_WriteException(Script.ResFilePath, t.getMessage());
		}

	}

	public void fn_CheckBoxExist(String SBObjString, html_result hr, String vExpected, String vactualResult,String vActPerform) throws Throwable
	{	
		try{
			String[] SBObj=SBObjString.split("@@@");
			switch(SBObj[0])
			{

			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(SBObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(SBObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.xpath(SBObj[1])).click();
					Script.driver.findElement(By.xpath(SBObj[2])).click();
					String abc = SBObj[0] + "@@@" + SBObj[3];
					fn_verifyElement(abc, hr, vExpected, vactualResult ,vActPerform);
					Script.driver.findElement(By.xpath(SBObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, vExpected, "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);

				}
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(SBObj[1]));
				ObjExist=Script.driver.findElements(By.name(SBObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.name(SBObj[1])).click();
					Script.driver.findElement(By.name(SBObj[2])).click();
					String abc = SBObj[0] + "@@@" + SBObj[3];
					fn_verifyElement(abc, hr, vExpected, vactualResult,vActPerform);
					Script.driver.findElement(By.name(SBObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, vExpected, "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(SBObj[1]));
				ObjExist=Script.driver.findElements(By.id(SBObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.id(SBObj[1])).click();
					Script.driver.findElement(By.id(SBObj[2])).click();
					String abc = SBObj[0] + "@@@" + SBObj[3];
					fn_verifyElement(abc, hr, vExpected, vactualResult,vActPerform);
					Script.driver.findElement(By.id(SBObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, vExpected, "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(SBObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(SBObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.cssSelector(SBObj[1])).click();
					Script.driver.findElement(By.cssSelector(SBObj[2])).click();
					String abc = SBObj[0] + "@@@" + SBObj[3];
					fn_verifyElement(abc, hr, vExpected, vactualResult,vActPerform);
					Script.driver.findElement(By.cssSelector(SBObj[1])).click();

				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, vExpected, "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(SBObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(SBObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.linkText(SBObj[1])).click();
					Script.driver.findElement(By.linkText(SBObj[2])).click();
					String abc = SBObj[0] + "@@@" + SBObj[3];
					fn_verifyElement(abc, hr, vExpected, vactualResult,vActPerform);
					Script.driver.findElement(By.linkText(SBObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, vExpected, "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
		}

	}
	public void fn_getattribute(String vObjString,html_result hr) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				break;
			}

			if((ObjExist.size())==1)
			{
				ObjName.getAttribute("value");
				hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "PASS");
			}
			else
			{
				hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");
				hr.fgCloseFile(Script.ResFilePath);
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());
			//		hr.fg_WriteException(Script.ResFilePath, t.getMessage());
			ObjName=null;
		}
	}
	public void fn_AllCheckboxClick(String vObjString, html_result hr) throws Throwable
	{	
		try{
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":
				ObjName=Script.driver.findElement(By.xpath(vObj[1]));
				ObjExist=Script.driver.findElements(By.xpath(vObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.xpath(vObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			case "name":
				ObjName=Script.driver.findElement(By.name(vObj[1]));
				ObjExist=Script.driver.findElements(By.name(vObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.name(vObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			case "id":
				ObjName=Script.driver.findElement(By.id(vObj[1]));
				ObjExist=Script.driver.findElements(By.id(vObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.id(vObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			case "cssSelector":
				ObjName=Script.driver.findElement(By.cssSelector(vObj[1]));
				ObjExist=Script.driver.findElements(By.cssSelector(vObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.cssSelector(vObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath,vActPerform, Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			case "linkText":
				ObjName=Script.driver.findElement(By.linkText(vObj[1]));
				ObjExist=Script.driver.findElements(By.linkText(vObj[1]));
				if((ObjExist.size())==1)
				{
					Script.driver.findElement(By.linkText(vObj[1])).click();
				}
				else
				{
					hr.fgInsertResult(Script.ResFilePath, vActPerform,Script.vTCDesc, "Element should be Prsent", "Element is displaying successfuly ", "FAIL");
					hr.fgCloseFile(Script.ResFilePath);
				}
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());

		}

	}
	public void fn_MouseOver(String vObjString,html_result hr) throws Throwable
	{
		try {
			String[] vObj=vObjString.split("@@@");
			switch(vObj[0])
			{
			case "xpath":			       
				Actions action = new Actions(Script.driver);
				WebElement WE = Script.driver.findElement(By.xpath(vObj[1]));
				action.moveToElement(WE).moveToElement(Script.driver.findElement(By.xpath(vObj[2]))).click().build().perform();
				break;
			case "name":
				Actions action1 = new Actions(Script.driver);
				WebElement WE1 = Script.driver.findElement(By.xpath(vObj[1]));
				action1.moveToElement(WE1).moveToElement(Script.driver.findElement(By.xpath(vObj[2]))).click().build().perform();
				break;
			case "id":
				Actions action2 = new Actions(Script.driver);
				WebElement WE2 = Script.driver.findElement(By.xpath(vObj[1]));
				action2.moveToElement(WE2).moveToElement(Script.driver.findElement(By.xpath(vObj[2]))).click().build().perform();
				break;
			case "cssSelector":
				Actions action3 = new Actions(Script.driver);
				WebElement WE3 = Script.driver.findElement(By.xpath(vObj[1]));
				action3.moveToElement(WE3).moveToElement(Script.driver.findElement(By.xpath(vObj[2]))).click().build().perform();
				break;
			case "linkText":
				Actions action4 = new Actions(Script.driver);
				WebElement WE4 = Script.driver.findElement(By.xpath(vObj[1]));
				action4.moveToElement(WE4).moveToElement(Script.driver.findElement(By.xpath(vObj[2]))).click().build().perform();
				break;
			case "className":
				Actions action5 = new Actions(Script.driver);
				WebElement WE5 = Script.driver.findElement(By.xpath(vObj[1]));
				action5.moveToElement(WE5).moveToElement(Script.driver.findElement(By.xpath(vObj[2]))).click().build().perform();
				break;
			}
		}catch(Throwable t){
			System.out.println(t.getMessage());

		}


	}


}

