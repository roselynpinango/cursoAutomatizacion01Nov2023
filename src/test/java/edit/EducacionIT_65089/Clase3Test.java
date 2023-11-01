package edit.EducacionIT_65089;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;

public class Clase3Test {
	String url = "http://www.automationpractice.pl";
	String directorioEvidencias = "..\\EducacionIT-65089\\Evidencias\\";
	String nombreDocumento = "Documento de Evidencias AutomationPractice.docx";
	WebDriver driver;
	File pantalla;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="CP01 - Ir a Contactanos",priority=100)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreDocumento,
				"Documento de Evidencias - Curso Automatizacion",
				20);
		
		// Capturar pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 1 - Pantalla Principal AutomationPractice");
				
		// Hacer clic en Contact Us
		driver.findElement(By.linkText("Contact us")).click();
		
		// Capturar pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 2 - Luego de hacer clic en Contact us");
		
		// Completar el formulario
		Select lstSubject = new Select(driver.findElement(By.id("id_contact")));
		lstSubject.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.cssSelector("#email"));
		txtEmail.sendKeys("correo01@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.name("id_order"));
		txtOrder.sendKeys("ORD-456");
		
		WebElement filAdjunto = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		filAdjunto.sendKeys("C:\\imagen.png");
		//filAdjunto.sendKeys("..\\EducacionIT-65089\\adjuntos\\image.png");
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Mensaje de Contacto del Cliente");
		
		// Capturar pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 3 - Luego de completar el formulario");
		
		// Hacer clic en el botón Send
		WebElement btnSend = driver.findElement(By.id("submitMessage"));
		btnSend.click();
		
		// Capturar pantalla
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver,
				directorioEvidencias + "img.jpg",
				directorioEvidencias + nombreDocumento,
				"Paso 4 - Luego de enviar el formulario de contacto");
		
		// Validaciones para comprobar que la prueba salió bien
		String tituloEsperado = "Contact us - My Shop";
		String tituloActual = driver.getTitle();
		
		/*SoftAssert soft = new SoftAssert();
		soft.assertEquals(tituloActual, tituloEsperado);*/
		
		Assert.assertEquals(tituloActual, tituloEsperado);
	}
	
	@Test(description="CP02 - Buscar Palabra",priority=200)
	public void buscarPalabra() throws IOException {
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "01_PantallaPrincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "02_PalabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Pantalla
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "03_ResultadoBusqueda.jpg"));
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
