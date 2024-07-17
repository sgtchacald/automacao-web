package Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Setups.TestRule;

public class seleniumUtils {
	public static WebDriver driver;
	protected static WebDriverWait wait;
	public static String nameCurrentScenario = TestRule.nomeCenario;

	public seleniumUtils() {
		driver = TestRule.getDriver();
	}

	public Boolean verificaExistenciaDeElementoNaTela(WebElement element, long time) {
		esperaElemento(element, time);
		boolean elementoOK = false;
		try {
			if (element.isDisplayed()) {
				elementoOK = true;
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.INFO, "Elemento '" + element + "' não encontrado. " + e.getMessage(), getScreenshotReport());
		}
		return elementoOK;
	}

	public Boolean verificaExistenciaDeElementosNaTela(List<WebElement> element) {
		boolean elementoOK = false;
		try {
			if (element.size() > 0) {
				elementoOK = true;
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.INFO, "Elemento '" + element + "' não encontrado. " + e.getMessage());
		}
		return elementoOK;
	}

	public static String loadFromPropertiesFile(String propertieFileName, String propertLoad) {
		Properties prop = new Properties();
		InputStream input = null;
		String path;
		if (usingJarFile()) {
			path = "";
		} else {
			path = "resources/";
		}
		String property = "";
		try {
			input = new FileInputStream(path + propertieFileName);
			prop.load(input);
			property = prop.getProperty(propertLoad);
		} catch (IOException ex) {
			ReportUtils.logMensagem(Status.FAIL, "Arquivo de properties não encontrado. " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					ReportUtils.logMensagem(Status.FAIL, "Arquivo de properties não encontrado. " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return property;
	}

	public static Boolean usingJarFile() {
		boolean isjar;
		String runningJarName = new seleniumUtils().getRunningJarName();
		if (runningJarName != null) {
			isjar = true;
		} else {
			isjar = false;
		}
		return isjar;
	}

	public String getRunningJarName() {
		String className = this.getClass().getName().replace('.', '/');
		String classJar = this.getClass().getResource("/" + className + ".class").toString();
		if (classJar.startsWith("jar:")) {
			String vals[] = classJar.split("/");
			for (String val : vals) {
				if (val.contains("!")) {
					return val.substring(0, val.length() - 1);
				}
			}
		}
		return null;
	}

	public static void setDropodownList(String value, WebElement element) {
		try {

			WebElement dropdownlistPesquisa = element;
			Select listboxelementsPesquisa = new Select(dropdownlistPesquisa);
			listboxelementsPesquisa.selectByVisibleText(value);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL,
					"Valor '" + value + "' não encontrado no elemento '" + element + "'. " + e.getMessage());
		}
	}

	public void setImputText(String value, WebElement element) {
		try {
			element.clear();
			element.sendKeys(value);
			element.sendKeys(Keys.RETURN);
			element.sendKeys(Keys.TAB);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "Não foi possível inserir o valor '" + value + "' no elemento '"
					+ element + "'. " + e.getMessage());
		}
	}

	public void setDropodownListReturn(String value, WebElement element) {
		try {
			element.sendKeys(value);
			sleep(100);
			element.submit();
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static void realizaScroll(WebElement element) {
		try {
			sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			// ReportUtils.logMensagem(Status.INFO, "Realizou scroll na pagina.");
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static void preencheDadosInput(final String info1, final String info2, final List<WebElement> campo) {
		try {
			for (int i = 0; i < campo.size(); i++) {
				if (i == 0) {
					campo.get(i).sendKeys(info1);
					sleep(1000);
				} else {
					campo.get(i).sendKeys(info2);
					sleep(1000);
				}
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static void preencheDadosDropdown(final String info1, final String info2, final List<WebElement> campo) {
		try {
			for (int i = 0; i < campo.size(); i++) {
				if (i == 0) {
					setDropodownList(info1, campo.get(i));
					sleep(300);
				} else {
					setDropodownList(info2, campo.get(i));
					sleep(300);
				}
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static int contaProdutos(final List<WebElement> idLista) {
		return (idLista.size());
	}
	
	public static void moverMouseEManterSobreOElemento(WebElement element) {
		try {
			Actions action = new Actions(TestRule.getDriver());
			action.moveToElement(element).build().perform();
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public void uploadArquivo(String caminho) throws AWTException {
		try {
			String caminho_completo = System.getProperty("user.dir") + caminho;
			Robot robot = new Robot();
			robot.setAutoDelay(2000);
			// StringSelection selection = new StringSelection((caminho+nome_arquivo));
			StringSelection selection = new StringSelection(caminho_completo);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public void uploadFile(List<WebElement> element, String caminho, int i) {
		try {
			String caminho_completo = System.getProperty("user.dir") + caminho;
			// WebElement uploadBtn =
			// driver.findElement(By.cssSelector("[id='modalDocumento_tipoDocumentoDigitalizacaoCodigo']"));
			element.get(i).sendKeys(caminho_completo);
			element.get(i).submit();
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public String somenteDigitos(String palavra) {
		String digitos = "";
		try {
			char[] letras = palavra.toCharArray();
			for (char letra : letras) {
				if (Character.isDigit(letra)) {
					digitos += letra;
				}
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
		return digitos;
	}

	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, e.getMessage());
		}
	}

	public static void sleeps(long segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, e.getMessage());
		}
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String pegNomeDoCenarioDoCSV() throws IOException {
		String nomeCenario = "";
		try {
			sleep(2000);
			String project = System.getProperty("user.dir");
			String path = null;
			project = project + "\\";
			// if (JarChecker.usingJarFile()) {
			// project = project + "\\libs\\";
			// path = loadFromPropertiesFile("portal.properties",
			// "CSV_JAR_NOME_CENARIO_FILE");
			// } else {
			// project = project + "\\";
			path = loadFromPropertiesFile("portal.properties", "CSV_NOME_CENARIO_FILE");
			// }
			// String numeroProposta = lePropostaCSV( project + path);
			nomeCenario = LeNomeCenario(project + path);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
		return nomeCenario;
	}

	public static String LeNomeCenario(String pathArquivoCSV) throws IOException {
		sleep(200);
		String valorPosicaoUm = null;
		String dados[] = new String[10];
		try {
			BufferedReader br = new BufferedReader(new FileReader(pathArquivoCSV));
			while (br.ready()) {
				for (int i = 0; i < dados.length; i++) {
					String linha = br.readLine();
					if (i != dados.length - 1) {
						if (linha != null) {
							linha = linha.replace(";", "");
						}
					}
					// ReportUtils.logMensagem(Status.INFO, i + " - " + linha);
					if (i == 0) {
						valorPosicaoUm = linha;
						dados[i] = linha;
					} else {
						if (linha != null) {
							dados[i] = linha;
						}
					}
				}
			}

			br.close();
		} catch (IOException ioe) {
			ReportUtils.logMensagem(Status.FAIL, "" + ioe.getMessage());
			ioe.printStackTrace();
		}
		// filtraPropostasUtilizadas(pathArquivoCSV, dados);
		// salvaPropostaUsada(pathArquivoCSV, dados);
		return valorPosicaoUm;
	}

	public static void tiraPrint() {
		String nomeCenario;
		try {
			nomeCenario = pegNomeDoCenarioDoCSV();
			getScreenshot(nomeCenario);
		} catch (IOException e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void criadiretorioprint(String nomeTest) throws IOException {
		try {
			String patch = loadFromPropertiesFile("gev_home.properties", "CAMINHO_RAIZ_PASTA");
			String caminho = System.getProperty("user.dir") + "\\" + patch + nomeTest + "\\";
			if (!existeDir(caminho)) {
				new File(caminho).mkdir();
				// ReportUtils.logMensagem(Status.INFO, "Criado diretorio dos prints do Teste -
				// " + nomeTest);
			} else {
				if (isDiretorioVazio(caminho)) {
					// ReportUtils.logMensagem(Status.INFO, "Diretório onde os Prints serão salvos
					// encontra-se vazio.");
				} else {
					esvaziaDiretorio(caminho);
				}
			}
			gravaNomeCenario(nomeTest);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static boolean existeDir(String caminho) {
		File diretorio;

		diretorio = new File(caminho);
		if (diretorio.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public static void esvaziaDiretorio(String caminho) {
		try {
			// ReportUtils.logMensagem(Status.INFO, "Deletando evidências existentes");
			File folder = new File(caminho);
			if (folder.isDirectory()) {
				File[] sun = folder.listFiles();
				for (File toDelete : sun) {
					toDelete.delete();
				}
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static boolean isDiretorioVazio(String diretorio) {
		boolean dirVazio = false;
		File dir = new File(diretorio);
		String[] children = dir.list();
		if (children == null) {
			// Diretorio nao existe ou nao eh um diretorio
			dirVazio = true;
		} else {
			if (children.length > 0) {
				dirVazio = false;
			}
		}
		return dirVazio;
	}

	public static String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String formataData(String data) throws ParseException {
		data = data.substring(0, 10);
		String dataArray[] = data.split(Pattern.quote("-"));

		return dataArray[2] + "/" + dataArray[1] + "/" + dataArray[0];
	}

	public String formataDataHora(String dataHora) {
		String data = dataHora.substring(0, 10);
		String dataArray[] = data.split(Pattern.quote("-"));
		data = dataArray[2] + "/" + dataArray[1] + "/" + dataArray[0];

		String hora = dataHora.substring(11, 16);

		String dataHoraFormatadas = data + " " + hora;

		return dataHoraFormatadas;
	}

	public static void getScreenshot(String nomeCenario) {
		String dir = System.getProperty("user.dir");
		driver.getCurrentUrl();

		String nomePrint = getDateTime();
		nomePrint = nomePrint.replace("/", "-");
		nomePrint = nomePrint.replace(" ", "_");
		nomePrint = nomePrint.replace(":", "_");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			copyFileUsingStream(scrFile, new File(dir + "\\screenshots\\" + nomeCenario + "\\" + nomePrint + ".jpg"));
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "Erro ao salvar o Screenshot - " + e);
		}
	}

	private static void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		} finally {
			is.close();
			os.close();
		}
	}

	public static void gravaNomeCenario(String cenario) {
		try {
			// if(JarChecker.usingJarFile()) {
			// escreverArquivoNovo((loadFromPropertiesFile("gev_home.properties",
			// "CAMINHO_JAR_ARQUIVO_NOME_CENARIO")), cenario);
			// }else {
			// escreverArquivoNovo((loadFromPropertiesFile("gev_home.properties",
			// "CAMINHO_ARQUIVO_NOME_CENARIO")), cenario);
			String File = (loadFromPropertiesFile("gev_home.properties", "CAMINHO_ARQUIVO_NOME_CENARIO"));
			escreverArquivoNovo(File, cenario);
			// }
		} catch (IOException e) {
			ReportUtils.logMensagem(Status.FAIL, "Erro ao gravar nome do cenario! " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void escreverArquivoNovo(String patch, String i) throws IOException {
		try {
			String file = System.getProperty("user.dir") + "\\" + patch;
			// ReportUtils.logMensagem(Status.INFO, "Caminho do arquivo com o nome do
			// cenario - " + file);
			FileWriter writer = new FileWriter(new File(file));
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(i);
			bufferedWriter.write(";");
			bufferedWriter.write("\n");
			bufferedWriter.flush();
			bufferedWriter.close();
			writer.close();
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	protected static Boolean esperaElemento(WebElement element, long segundos) {
		WebElement webElement = null;
		try {
			long milisegundos = TimeUnit.SECONDS.toMillis(Integer.parseInt(String.valueOf(segundos)));

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(segundos))
					.pollingEvery(Duration.ofSeconds(segundos))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(TimeoutException.class);
			try {
				webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
				// ReportUtils.logMensagem(Status.INFO, "Elemento encontrado com sucesso!");
			} catch (Exception e) {
				ReportUtils.logMensagem(Status.INFO, "Elemento não foi encontrado! " + e.getMessage());
				return false;
			}
		} catch (NoSuchElementException e) {
			ReportUtils.logMensagem(Status.INFO, "Elemento não foi encontrado! " + e.getMessage());
			return false;
		} catch (StaleElementReferenceException e) {
			ReportUtils.logMensagem(Status.FAIL, e.getMessage());
			return false;
		}
		return webElement != null;
	}

	protected static Boolean esperaElementoEnable(WebElement element, long segundos) {
		esperaElemento(element, segundos);
		boolean isEnable = false;
		if (element.isEnabled()) {
			isEnable = true;
		}
		return isEnable;
	}

	protected static Boolean esperaElementos(List<WebElement> element, long segundos) {
		List<WebElement> webElement = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(segundos))
					.pollingEvery(Duration.ofSeconds(segundos))
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class)
					.ignoring(TimeoutException.class);
			try {
				webElement = wait.until(ExpectedConditions.visibilityOfAllElements(element));
				// ReportUtils.logMensagem(Status.INFO, "Elementos encontrados com sucesso!");
			} catch (Exception e) {
				ReportUtils.logMensagem(Status.FAIL, e.getMessage());
				return false;
			}

		} catch (NoSuchElementException e) {
			ReportUtils.logMensagem(Status.FAIL, "Elementos não foram encontrados!" + e.getMessage());
			return false;
		} catch (StaleElementReferenceException e) {
			ReportUtils.logMensagem(Status.FAIL, e.getMessage());
			return false;
		}
		return webElement != null;
	}

	public static WebDriverWait getWait() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wait;
	}

	public static String getTextBy(By by) {
		return getWait().until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

	public static List<String> getList(String... data) {
		List<String> elementsId = new ArrayList<>();
		try {
			for (String dataElement : data) {
				elementsId.add(dataElement);
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
		return elementsId;
	}

	public void ClickElementHidden(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void alteraContextoParaNovaTab() {
		try {
			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			System.out.println(tabs.size());
			driver.switchTo().window((String) tabs.get(1));
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public void escreveEmElementosHidden(String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + id + "').setAttribute('value', '" + value + "')");
	}

	public void escreveViaJavaScript(WebElement searchbox, String value) {
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='" + value + "';", searchbox);
	}

	public void escreverViaActionClassNoElemento(WebElement element, String value) {
		Actions performAct = new Actions(driver);
		performAct.sendKeys(element, "" + value + "").build();
		performAct.build();
		performAct.perform();
	}

	public static String getScreenshotReport() {
		String dir = System.getProperty("user.dir");
		String imagem_dir = "";
		driver.getCurrentUrl();
		String nomePrint = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		nomePrint = nomePrint.replace(".", "_");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Thread.sleep(1000);
			criarDiretorio(ReportUtils.getDiretorioReport() + "/screenshots");
			dir = ReportUtils.getDiretorioReport() + "/screenshots/" + nomePrint + ".png";
			imagem_dir = "./screenshots/" + nomePrint + ".png";
			copyFileUsingStream(scrFile, new File(dir));
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "Erro ao salvar o Screenshot - " + e);
		}
		return imagem_dir;
	}

	public static void criarDiretorio(String diretorioASerCriado) {
		try {
			File diretorio = new File(diretorioASerCriado);
			if (!diretorio.exists()) {
				diretorio.mkdirs();
			}
		} catch (Exception e) {
			ReportUtils.logMensagem(Status.FAIL, "" + e.getMessage());
		}
	}

	public static void deletarArquivo(File arq) {
		if (arq.isDirectory()) {
			File[] arquivos = arq.listFiles();
			for (int i = 0; i < arquivos.length; i++) {
				deletarArquivo(arquivos[i]);
			}
		}
		arq.delete();
	}

	public String formataStringMoedaParaDecimal(String str) {
		// Dado que a string seja no formato de moeda "R$ 9.999,99"
		String strFormatoMoedaConvertidoDecimal = "";
		if (str != null) {
			strFormatoMoedaConvertidoDecimal = str.substring(3).replace(".", "");
			strFormatoMoedaConvertidoDecimal = strFormatoMoedaConvertidoDecimal.replace(",", ".");
			strFormatoMoedaConvertidoDecimal = strFormatoMoedaConvertidoDecimal.replace("00", "0").trim();
		}
		return strFormatoMoedaConvertidoDecimal;
	}

	public String formataStringDecimalParaMoeda(String valor) {
		valor = "R$  " + valor;
		if (valor.length() <= 10) {
			valor = valor.replace(".0", ",00");
		}
		StringBuilder stringBuilder = new StringBuilder(valor);
		stringBuilder.insert(valor.length() - 6, '.');

		return stringBuilder.toString();
	}

	public Boolean verificaTelaDeLogin(WebElement elemento) {
		try {
			sleeps(1);
			if (elemento.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean verificaExistenciaTextoNaListaElementos(String texto, List<WebElement> elements) {
		Boolean ok = false;
		for (int i = 0; i < elements.size(); i++) {
			if (texto.equals(elements.get(i).getText().toString())) {
				ok = true;
			}
		}
		return ok;
	}

	public Boolean verificaExistenciaTextoNaListaElementos(String texto, List<WebElement> elements, Integer linha) {
		Boolean ok = false;
		if (texto.equals(elements.get(linha).getText().toString().trim())) {
			ok = true;
		}
		return ok;
	}

	public void getLogConsoleBrowser() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			ReportUtils.logMensagem(Status.INFO,new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		}
	}
}