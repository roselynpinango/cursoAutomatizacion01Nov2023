package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase5Test {
	String url = "http://www.automationpractice.pl";
	String directorioDatos = "..\\EducacionIT-65089\\Datos\\";
	String nombreArchivoDatos = "Datos_Login25Oct2023.xlsx";
	String nombreHoja = "Hoja1";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="C1 - Login", priority=1, dataProvider="Datos Login Excel")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
		
		// Si el login es exitoso, necesitamos hacer Sign Out
		// para volver a la posición inicial de la prueba
	}
	
	@DataProvider(name="Datos Login Excel")
	public Object[][] obtenerDatosLoginExcel() throws Exception{
		// Obtener los datos del archivo excel y devolverlos en forma arreglo
		return DatosExcel.leerExcel(
				directorioDatos + nombreArchivoDatos, 
				nombreHoja);
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() {
		// Construir el arreglo bidimensional con los datos para probar el login
		Object[][] datos = new Object[3][2];
		
		datos[0][0] = "abc@gmail.com"; // correo
		datos[0][1] = "1q2w3r4r"; // contraseña
		
		datos[1][0] = "def@gmail.com"; // correo
		datos[1][1] = "6y7u8i89o"; // contraseña
		
		datos[2][0] = "ghi@gmail.com"; // correo
		datos[2][1] = "r43r3r432e"; // contraseña
		
		return datos;
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		//driver.close();
	}
}
