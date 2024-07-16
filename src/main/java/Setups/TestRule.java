package Setups;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

import Utils.ReportUtils;
import Utils.seleniumUtils;

public class TestRule {

	protected static WebDriver driver;
	public static String nomeCenario;
	
	seleniumUtils seleniumutils = new seleniumUtils();
	
	@Before
	public void beforeCenario(Scenario cenario){
		ReportUtils.criarReport(cenario);
		ReportUtils.logMensagem(Status.INFO, "Iniciando Teste.");
		try {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			nomeCenario = cenario.getName();
			ReportUtils.logMensagem(Status.INFO, "Executando Cenário: " + nomeCenario);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "Erro ao iniciar o ChromeDriver: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getNomeCenario() {
		return nomeCenario;
	}

	@After
	public void afterCenario(Scenario cenario) {
		ReportUtils.logMensagem(Status.INFO, "Finalizando Instâncias", seleniumUtils.getScreenshotReport());
		ReportUtils.atualizaReport(cenario);
		seleniumUtils.sleep(1000);
		driver.quit();
	}
}
