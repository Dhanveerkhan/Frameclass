package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;
	Actions actions;
	String string;
	Alert alert;
	Object object;
	Robot robot;
	JavascriptExecutor executor;
	Select select;
	File file;
	FileInputStream inputStream;
	Workbook workbook;

	public void launchChrome() throws AWTException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void passUrl(String Url) {
		driver.get(Url);
	}

	public String currentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String title() {
		String title = driver.getTitle();
		return title;
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		driver.quit();
	}

	public WebElement id(String Value) {
		WebElement element = driver.findElement(By.id(Value));
		return element;
	}

	public WebElement name(String Value) {
		WebElement element = driver.findElement(By.name(Value));
		return element;
	}

	public WebElement className(String value) {
		WebElement element = driver.findElement(By.className(value));
		return element;
	}

	public WebElement xpath(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		return element;
	}

	public void sendkeys(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}

	public void click(WebElement element) {
		element.click();
	}

	public String text(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String value(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public void maxi() {
		driver.manage().window().maximize();
	}

	public void action(WebElement element) {

		actions.moveToElement(element).perform();
	}

	public void dragandDrop(WebElement source, WebElement Dest) {
		actions.dragAndDrop(source, Dest).perform();
	}

	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	public void doubleClick(WebElement target) {
		actions.doubleClick(target).perform();
	}

	public void alert() {
		alert = driver.switchTo().alert();

		alert.accept();
	}

	public void alertd() {
		alert = driver.switchTo().alert();

		alert.dismiss();
	}

	public void alertsend(String value) {
		alert = driver.switchTo().alert();

		alert.sendKeys("yes");
		alert.accept();
	}

	public String alerttext() {
		String text = alert.getText();
		return text;
	}

	public Object executor(WebElement element, String text) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')", element);
		return executeScript;
	}

	public void exclick(WebElement element) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public void scrollDown(WebElement ScrollDown) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", ScrollDown);
	}

	public void scrollUp(WebElement ScrollUp) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", ScrollUp);
	}

	public void back() {
		driver.navigate().back();
	}

	public void forward() {
		driver.navigate().forward();
	}

	public void reload() {
		driver.navigate().refresh();
	}

	public void navigate(String value) {
		driver.navigate().to("url");
	}

	public List<WebElement> tablehead(WebElement table, String value) {
		List<WebElement> elements = table.findElements(By.tagName(""));
		return elements;
	}

	public void index(int index) {
		select.selectByIndex(index);
	}

	public int allOptions(WebElement element) {
		List<WebElement> options = select.getOptions();
		int size = options.size();
		return size;
	}

	public String optiontext(WebElement element, int index) {
		List<WebElement> options = select.getOptions();
		WebElement ele = options.get(index);
		String text = ele.getText();
		return text;
	}

	public String optiontexts(WebElement element, int index) {
		List<WebElement> options = select.getOptions();
		WebElement ele = options.get(index);
		String text = ele.getAttribute("value");
		return text;
	}

	public void visible(String element) {
		select.selectByVisibleText(element);
	}

	public void value(String value) {
		select.selectByValue(value);
	}

	public WebElement firstOption() {
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		return firstSelectedOption;
	}

	public WebElement allOptions(int index) {
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		WebElement element = allSelectedOptions.get(index);
		return element;
	}

	public boolean booleanform() {
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public void indexvaluetext(int index, String value, String text) {
		select.deselectByIndex(index);
		select.deselectByValue(value);
		select.deselectByVisibleText(text);
	}

	public void deselect() {
		select.deselectAll();
	}

	public void parentframe() {
		driver.switchTo().parentFrame();
	}

	public void frameid(int index) {
		driver.switchTo().frame(index);
	}

	public void frameele(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void idorname(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void comeoutonefeame() {
		driver.switchTo().defaultContent();
	}

	public Set<String> handles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}

	public String windowhandle() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public void window(String nameOrHandle) {
		driver.switchTo().window(nameOrHandle);
	}

	public FluentWait<WebDriver> wait(Duration timeout, Duration interval, Class exceptionType) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeout).pollingEvery(interval)
				.ignoring(exceptionType);
		return wait;
	}

	public void time(Duration duration) {
		driver.manage().timeouts().implicitlyWait(duration);
	}

	public void keydown(CharSequence key) {
		actions.keyDown(key);
	}

	public void keyup(CharSequence key) {
		actions.keyUp(key);
	}

	public void press(int keycode) throws AWTException {
		robot = new Robot();
		robot.keyPress(keycode);
	}

	public void release(int keycode) throws AWTException {
		robot = new Robot();
		robot.keyRelease(keycode);
	}

	public void mini() {
		driver.manage().window().minimize();
	}

	public String getdata(String Sheetname, int rowno, int cellno) throws IOException {
		String Data = null;
		file = new File("C:\\Users\\dhanv\\eclipse-workspace\\FrameClass\\Excel\\Book3.xlsx");
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet("sheet1");
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		CellType type = cell.getCellType();

		switch (type) {
		case STRING:
			Data = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				java.util.Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yy");
				Data = dateFormat.format(date);
			} else {
				double value = cell.getNumericCellValue();
				BigDecimal bd = new BigDecimal(value);
				Data = bd.toString();
			}
			break;
		default:
			break;
		}
		return Data;
	}

	public void updatedata(String Sheetname, int rowno, int cellno, String olddata, String Newdata) throws IOException {
		file = new File("C:\\Users\\dhanv\\eclipse-workspace\\FrameClass\\Excel\\Book3.xlsx");
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
			cell.setCellValue(Newdata);
		}
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}

	public void createcell(String Sheetname, int rowno, int cellno, String data) throws IOException {
		file = new File("C:\\Users\\dhanv\\eclipse-workspace\\FrameClass\\Excel\\Book3.xlsx");
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
	}

	public void createRow(String Sheetname, int rowno, int cellno, String data) throws IOException {
		file = new File("C:\\Users\\dhanv\\eclipse-workspace\\FrameClass\\Excel\\Book3.xlsx");
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(Sheetname);
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);

	}

	public void createall(String Sheetname, int rowno, int cellno, String data) throws IOException {
		file = new File("C:\\Users\\dhanv\\eclipse-workspace\\FrameClass\\Excel\\Book3.xlsx");
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.createSheet(Sheetname);
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);

	}

}