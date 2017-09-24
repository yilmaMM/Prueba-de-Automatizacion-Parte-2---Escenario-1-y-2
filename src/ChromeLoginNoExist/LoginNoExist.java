package ChromeLoginNoExist;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginNoExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("");
		System.out.println("Flujo del script:");
		System.out.println("Con Chrome:");
		
		//initialize Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Open Linkedin
		driver.get("http://www.linkedin.com");
		
		// Mostramos id y titulo de pagina del login
		String windowId1 = driver.getWindowHandle();
		WebDriver webdriver1 = driver.switchTo().window(windowId1);
		String title1 = webdriver1.getTitle();
		System.out.println("El Id de la pagina >> " +title1+ " << (Page) es: " +windowId1);

		// Envio cuenta de correo personal
		WebElement element = driver.findElement(By.id("login-email"));
		element.sendKeys("yilma45@gmail.com");

		//espero 5 segundos para enviar la contraseña
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Envio contraseña
		WebElement element1 = driver.findElement(By.id("login-password"));
		element1.sendKeys("pruebatest123@");

		//Envio de credenciales
		element.submit();
		System.out.println("Se envio credencial");
		System.out.println("Validando que Login de Linkedin no existe...");
	}

}
