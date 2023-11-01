package edit.EducacionIT_65089;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Clase2Test {
	String url = "http://www.automationpractice.pl/index.php";
	
	@Test
	public void registrarUsuario() {
		// 1) Definir qué navegador utilizar
		WebDriver driver = new EdgeDriver();
		
		// 2) Abrir la página a probar
		driver.get(url);
		
		// 3) Maximizar la página
		driver.manage().window().maximize();
		
		// 4) Hacer clic en Sign in
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		//String email = "correo" + Math.random() + "@gmail.com";
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		
		// 5) Escribir el correo electrónico
		WebElement txtEmail = driver.findElement(By.cssSelector("#email_create"));
		txtEmail.sendKeys(email);
		
		// 6) Hacer clic en el botón Create An Account
		WebElement btnCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
		btnCreate.click();
		
		// Espera
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender2")));
		
		// 7) Completar el formulario 
		WebElement radTitle = driver.findElement(By.id("id_gender2"));
		radTitle.click();
		
		WebElement txtFirstname = driver.findElement(By.cssSelector("#customer_firstname"));
		txtFirstname.sendKeys("Raul");
		
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Gonzalez");
				
		WebElement txtEmailFormulario = driver.findElement(By.id("email"));
		txtEmailFormulario.clear();
		txtEmailFormulario.sendKeys(email);
		
		WebElement txtPassword = driver.findElement(By.name("passwd"));
		txtPassword.sendKeys("1q2w3e4r5t");
		
		Select lstDays = new Select(driver.findElement(By.cssSelector("#days")));
		lstDays.selectByValue("18");
		
		Select lstMonths = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		lstMonths.selectByVisibleText("June ");
		
		Select lstYears = new Select(driver.findElement(By.id("years")));
		lstYears.selectByIndex(30);
		
		WebElement chkNewsletter = driver.findElement(By.name("newsletter"));
		chkNewsletter.click();
		
		// 8) Hacer clic en el botón Register
		WebElement btnRegister = driver.findElement(By.cssSelector("#submitAccount"));
		btnRegister.click();
	}
}
