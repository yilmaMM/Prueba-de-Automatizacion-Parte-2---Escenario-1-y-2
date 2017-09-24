package IESearchContact;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.*;


public class SearchContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("");
		System.out.println("Inicio:");
		System.out.println("Navegador Internet Explorer:");
		String textToSelect = "Astrid C. Bompart G";
		  
		// Especificamos donde se encuentra el WebDriver para IE
	    String service ="C:\\Program Files\\Java\\IEDriverServer.exe";
	    System.setProperty("webdriver.ie.driver", service);
		  
		// Abrimos el IE
		InternetExplorerDriver driver = new InternetExplorerDriver();
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open Linkedin
		driver.navigate().to("http://www.linkedin.com");
		System.out.println("Abrió a pagina de Linkedin");	
		// Mostramos id y titulo de pagina del login
		
		String windowId1 = driver.getWindowHandle();
		WebDriver webdriver1 = driver.switchTo().window(windowId1);
		String title1 = webdriver1.getTitle();
		System.out.println("El Id de la pagina >> " +title1+ " << (Page) es: " +windowId1);
		
		// Envio cuenta de correo personal
		WebElement element = driver.findElement(By.id("login-email"));
		element.sendKeys("yilma44@gmail.com");
		
		//espero 5 segundos para enviar la contraseña
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Envio contraseña
		WebElement element1 = driver.findElement(By.id("login-password"));
		element1.sendKeys("pruebatest123@");

		//Envio de credenciales
		element.submit();
		System.out.println("Se envio credencial");
		System.out.println("Validando Login de Linkedin...");
		
		// Mostramos id y titulo de  la siguiente pagina de Linkedin
		String windowId2 = driver.getWindowHandle();
		WebDriver webdriver2 = driver.switchTo().window(windowId2);
		String title2 = webdriver2.getTitle();
		
		System.out.println("El Id de la pagina >> " +title2+ " << (Page) es: " +windowId2);
		WebElement elementSearchContact = driver.findElement(By.className("ember-text-field"));
		
		elementSearchContact.sendKeys(textToSelect);
		elementSearchContact.sendKeys(Keys.ENTER);
		
		//Selecciono el perfil de mi usuario en mi Red y se despliega
		driver.findElement(By.className("search-result__image-wrapper")).click();
	}

}
