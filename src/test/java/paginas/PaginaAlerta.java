package paginas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginaAlerta {
	@FindBy(id="alertButton")
	WebElement btnNotificacion;
	
	@FindBy(xpath="//button[@id='timerAlertButton']")
	WebElement btnEspera;
	
	@FindBy(css="#confirmButton")
	WebElement btnConfirmar;
	
	@FindBy(id="promtButton")
	WebElement btnEscribir;
	
	WebDriver navegador;
	
	public PaginaAlerta(WebDriver driver) {
		PageFactory.initElements(driver, this);
		navegador = driver;
	}
	
	public void hacerClicEnNotificacion() {
		btnNotificacion.click();
	}
	
	public void hacerClicEnEspera() {
		btnEspera.click();
	}
	
	public void hacerClicEnConfirmar() {
		btnConfirmar.click();
	}
	
	public void hacerClicEnEscribir() {
		btnEscribir.click();
	}
	
	public Alert obtenerAlerta() {
		return navegador.switchTo().alert();
	}
	
	public void hacerClicEnAceptar(Alert alerta) {
		alerta.accept();
	}
	
	public void hacerClicEnCancelar(Alert alerta) {
		alerta.dismiss();
	}
	
	public void escribirEnAlerta(Alert alerta, String palabra) {
		alerta.sendKeys(palabra);
	}
	
	public String obtenerTexto(Alert alerta) {
		return alerta.getText();
	}
	
	public void esperarAlerta() {
		// Espera para la alerta que aparecera 5 seg despues
		WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());	
	}
}
