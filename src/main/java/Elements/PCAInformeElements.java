package Elements;

import Utils.seleniumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

	@FindBy(xpath = "//*[contains(text(),'Criar Informe')]")
	public WebElement TXT_LABEL_CAD_INFORME;

	@FindBy(xpath = "//*[contains(text(),'Título')]")
	public WebElement TXT_LABEL_CAD_TITULO;

	@FindBy(xpath = "//*[contains(text(),'Data de Expiração')]")
	public WebElement TXT_LABEL_CAD_DT_EXPIRACAO;

	@FindBy(xpath = "//*[contains(text(),'Publicar')]")
	public WebElement TXT_LABEL_CAD_PUBLICAR;

	@FindBy(xpath = "//*[contains(text(),'Descrição')]")
	public WebElement TXT_LABEL_CAD_DESCRICAO;

	@FindBy(xpath = "//*[contains(text(),'Gravar')]")
	public WebElement TXT_LABEL_CAD_GRAVAR;

	@FindBy(xpath = "//*[contains(text(),'Voltar')]")
	public WebElement TXT_LABEL_CAD_CRIAR;

	@FindBy(id = "titulo")
	public WebElement CAMPO_TITULO;

	@FindBy(id = "dataExpiracao")
	public WebElement CAMPO_DT_EXPIRACAO;

	@FindBy(id = "descricao")
	public WebElement CAMPO_DESCRICAO;

	@FindBy(id = "botao-voltar")
	public WebElement BTN_VOLTAR;

	@FindBy(id = "btn-gravar-informes")
	public WebElement BTN_GRAVAR;

	@FindBy(css = "#menuPrincipal > ul > li:nth-child(1) > a")
	public WebElement ICONE_HOME;

	@FindBy(css = ".btn.btn-blue")
	public WebElement MODAL_BTN_SIM;

	@FindBy(css = "#slide-informes")
	public WebElement MENSAGEM_INFORME_PAGINA_PRINCIPAL;
	@FindBy(css = "#slide-informes li")
	public List<WebElement> MENSAGENS_INFORME_PAGINA_PRINCIPAL;

}
