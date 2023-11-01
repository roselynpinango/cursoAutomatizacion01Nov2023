package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import paginas.PaginaAlerta;

public class Clase6Test {
	String url = "https://demoqa.com/alerts";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); // Configura el modo incognito
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertaNotificacion() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnNotificacion();
		
		Alert alerta = pagina.obtenerAlerta();
		System.out.println(alerta.getText()); // Escribir algo en la consola
		alerta.accept();
		
	}
	
	@Test 
	public void alertaEspera() {
		PaginaAlerta pagina = new PaginaAlerta(driver);
		pagina.hacerClicEnEspera();
		
		pagina.esperarAlerta();
		pagina.hacerClicEnAceptar(pagina.obtenerAlerta());
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
