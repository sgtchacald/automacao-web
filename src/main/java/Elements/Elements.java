package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.seleniumUtils;

public class Elements extends seleniumUtils{

	@FindBy(css = "#header > div > div > div.col-xs-2.text-right > div > a")
	public WebElement MENU_PRINCIPAL;
	
	@FindBy(css = "#navigation > div > div > div > div > div > ul > li:nth-child(2) > a > i")
	public WebElement ITEM_MENU_CONTATO;
	
	@FindBy(id = "nome")
	public WebElement CAMPO_TXT_NOME;
	
	@FindBy(name = "email")
	public WebElement CAMPO_TXT_EMAIL;
	
	@FindBy(name = "comment")
	public WebElement CAMPO_TXT_MENSAGEM;
	
	@FindBy(css = "#contactform > p:nth-child(5) > input[type=submit]")
	public WebElement BOTAO_ENVIAR;
	
	@FindBy(css = "body > section > div > div > div.alert.alert-success.desaparecer")
	public WebElement LABEL_MENSAGEM_SUCESSO;
	
}
