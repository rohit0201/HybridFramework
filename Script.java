package DriverScript;



import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import GenericLib.generic_lib;

public class Script {
	public static String vBrowserType;
	public static String vProjectName;
	public static String vProjectUrl;
	public static WebDriver driver;
	public static Robot robot;
	public static String vModuleName;
	public static String vTCName;
	public static String ResFilePath;
	public static String vTCDesc;
	public static String vActPerform,vTestData,vModDriver;
	public static int noofTC=0;
	public static int passtc=0;
	public static int failtctemp=0;
	public static int failtc=0;
	public static int passval=0;
	public static int failval=0;
	public static int TC_StatusCount;
	public static int StepsExcelRowNum,totfailval,totfail;
	public static String startexe,stopexe,vDescription,TC_Status;
	public static String txtEmpID=null;
	public static void main(String[] args) throws Throwable {
		
		Robot robot= new Robot();
		
		String vRun,vRunMod,vRunTC,vTestScenario,vDescription;
		 Date startdatetime = new Date();
	        Date enddatetime = null;
		Xls_Reader xr =new Xls_Reader(System.getProperty("user.dir")+"\\src\\DriverFiles\\ProjectDriver.xlsx");
		for(int i=2;i<=xr.getRowCount("Projects");i++)
		{
			vRun=xr.getCellData("Projects", "Run", i);
			if(vRun.equalsIgnoreCase("ON"))
			{
								
				vProjectName=xr.getCellData("Projects", "ProjectName", i);
				vProjectUrl=xr.getCellData("Projects", "ProjectUrl", i);
				vModDriver=xr.getCellData("Projects", "ModulesFile", i);
				vTestData=xr.getCellData("Projects", "ScenarioFile", i);
				vBrowserType=xr.getCellData("Projects", "Browser", i);

				if (vBrowserType.equals("Firefox"))
				{
					driver=new FirefoxDriver();
				}
				else if(vBrowserType.equals("IE"))
				{
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\Browser_Driver\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();
				}
				else if(vBrowserType.equals("Chrome"))
				{
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\Browser_Driver\\chromedriver.exe");
					driver=new ChromeDriver();
				}
				
				driver.get(vProjectUrl);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
				
				
				html_result hr=new html_result();
				ResFilePath=hr.CreateResultFileAndPath(vProjectName); // changes
				hr.fg_OpenResultsFile(ResFilePath, vProjectName);
				
				Xls_Reader xlres =new Xls_Reader(System.getProperty("user.dir")+"\\src\\Results\\Detailed_Results.xlsx");

				for(int j=2;j<=xr.getRowCount(vProjectName);j++)
				{
			 		vRunMod=xr.getCellData(vProjectName, "Run", j);
					if(vRunMod.equalsIgnoreCase("ON"))
					{
						vModuleName=xr.getCellData(vProjectName, "Modules", j);
						System.out.println(vModuleName);
						Xls_Reader xmd =new Xls_Reader(System.getProperty("user.dir")+"\\src\\DriverFiles\\"+vModDriver);
						Xls_Reader xtd =new Xls_Reader(System.getProperty("user.dir")+"\\src\\Scenario\\"+vTestData);
						for(int k=2;k<=xmd.getRowCount(vModuleName);k++)
						{
							vRunTC=xmd.getCellData(vModuleName, "Run", k);
							if(vRunTC.equalsIgnoreCase("ON"))
							{
								vTCName=xmd.getCellData(vModuleName, "TCName", k);
								
								hr.fgInsertStep(ResFilePath, vTCName);
								
								TC_Status="PASS";
								TC_StatusCount=0;
								failtctemp=0;
								noofTC=noofTC+1;
								System.out.println(vTCName);
								int usedrow=0;
								for(int m=2;m<=xtd.getRowCount(vModuleName);m++)
								{
									String usedmethod;
									vTestScenario=xtd.getCellData(vModuleName, "TestScenario", m);
									if(vTCName.equals(vTestScenario))
									{
										
										vDescription=xtd.getCellData(vModuleName, "TestScenario", m-1);
										vTCDesc=vDescription.replace("##", "");
										System.out.println(vTCDesc);
										usedrow=m;
									}										
									if ((m>usedrow) && (usedrow>0))
									{
										if(vTestScenario.contains("##"))
										{
											break;												
										}
										else
										{
											StepsExcelRowNum=m;
											vActPerform=xtd.getCellData(vModuleName, "ActionPerforming", m);
											usedmethod=vTestScenario;
											System.out.println(usedmethod);
											generic_lib GF=new generic_lib();
											GF.driverFunctions(usedmethod,xtd,vModuleName,m,hr);
											if(TC_StatusCount>0)
											{
												TC_Status="FAIL";
												failtctemp=1;
											}
											else
											{
												TC_Status="PASS";
											}
										
										}
									}
									
								}
								
								if(failtctemp>0)
								{
									
									failtc=failtc+1;
									DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
									Date date = new Date();	
									String Time=dateFormat.format(date);
									int xlrowcnt=xlres.getRowCount("Result");
									xlres.setCellData("Result", "ModuleName", xlrowcnt+1, vModuleName);
									xlres.setCellData("Result", "TCName", xlrowcnt+1, vTCName);
									xlres.setCellData("Result", "Description", xlrowcnt+1, vTCDesc);
									xlres.setCellData("Result", "Status", xlrowcnt+1, "FAIL");
									xlres.setCellData("Result", "DateTime", xlrowcnt+1, Time);

								}
								else
								{
									DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
									Date date = new Date();	
									String Time=dateFormat.format(date);
									int xlrowcnt=xlres.getRowCount("Result");
									xlres.setCellData("Result", "ModuleName", xlrowcnt+1, vModuleName);
									xlres.setCellData("Result", "TCName", xlrowcnt+1, vTCName);
									xlres.setCellData("Result", "Description", xlrowcnt+1, vTCDesc);
									xlres.setCellData("Result", "Status", xlrowcnt+1, "PASS");
									xlres.setCellData("Result", "DateTime", xlrowcnt+1, Time);

								  }
								
								hr.fgInsertTcResult(TC_Status);
                           }
							
                       }
                   }
               }

               enddatetime = new Date();
               passtc=noofTC-failtc;

               hr.fgCreateSummary(ResFilePath)    ;
               hr.fgInsertSummary(ResFilePath, noofTC,passval,failval,passtc,failtc, startdatetime,enddatetime );

           }
			
       }
		
		System.out.println("Your Execution has been completed. Thank You!!!");
		Thread.sleep(5000);
		driver.quit();
		

	}

}
