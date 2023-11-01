package edit.EducacionIT_65089;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase1Test {
	// Variables de uso común
	String url = "http://www.automationpractice.pl";
	
	/*
	 * Método de 
	 * Prueba
	 * */
	@Test
	public void buscarPalabraEnFirefox() {
		// 1) Definir qué navegador vamos a utilizar
		WebDriver navegador = new FirefoxDriver();
		
		// 2) Abrir el navegador en la página a probar
		navegador.get(url);
		
		// 3) Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Hacer la búsqueda (simulando la tecla ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 5) Cerrar el navegador
		navegador.close();
	}
	
	@Test
	public void buscarPalabraEnEdge() {
		// 1) Definir qué navegador vamos a utilizar
		WebDriver navegador = new EdgeDriver();
		
		// 2) Abrir el navegador en la página a probar
		//navegador.get(url);
		navegador.navigate().to(url);
		
		navegador.manage().window().maximize(); // Maxima la ventana
		navegador.manage().deleteAllCookies(); // Borra las cookies
		
		// 3) Escribir la palabra a buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// 4) Hacer la búsqueda (simulando la tecla ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		// 5) Cerrar el navegador
		//navegador.close();
		navegador.quit();
	}
}
