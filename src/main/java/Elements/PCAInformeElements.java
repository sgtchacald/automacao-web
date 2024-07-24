package Elements;

import Utils.seleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PCAInformeElements extends seleniumUtils{

	@FindBy(xpath = "//*[contains(text(),'Informes')]")
	public WebElement TXT_LABEL_INFORMES;

	@FindBy(xpath = "//*[contains(text(),'Resultado')]")
	public WebElement TXT_LABEL_RESULTADO;

	@FindBy(xpath = "//*[contains(text(),'Título')]")
	public WebElement TXT_LABEL_TITULO;

	@FindBy(xpath = "//*[contains(text(),'Situação')]")
	public WebElement TXT_LABEL_SITUACAO;

	@FindBy(xpath = "//*[contains(text(),'Data de Publicação')]")
	public WebElement TXT_LABEL_DATA_PUBLICACAO;

	@FindBy(xpath = "//*[contains(text(),'Data de Expiração')]")
	public WebElement TXT_LABEL_DATA_EXPIRACAO;

	@FindBy(xpath = "//*[contains(text(),'Conteúdo do Informe')]")
	public WebElement TXT_LABEL_CONTEUDO_DO_INFORME;

	@FindBy(xpath = "//*[contains(text(),'Criar')]")
	public WebElement TXT_LABEL_BTN_CRIAR;

	@FindBy(className = "fa-plus")
	public WebElement BTN_CRIAR;

	@FindBy(xpath = "//*[contains(text(),'Informes')]")
	public WebElement BTN_INFORMES;

	@FindBy(css = "#menuPrincipal > ul > li:nth-child(5) > a")
	public WebElement ITEM_MENU_GESTAO;

	@FindBy(css = "#menuPrincipal > ul > li:nth-child(5) > ul")
	public WebElement ITEM_MENU_CADASTRAR;

}
