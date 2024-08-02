import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/header/ladom'), 'tagName', 'IMG', 10)

// Simulateur Test
simul_obj = findTestObject('Object Repository/header/Mon espace')
WebUI.verifyElementAttributeValue(simul_obj, 'tagName', 'A', 10)
WebUI.verifyMatch(WebUI.getAttribute(simul_obj, 'href'), 'https?://beneficiaire.ladom.fr/login', true)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/header/icofinance par union europeene'), 'tagName', 'IMG', 10)

// Images Social
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/header/instagram'), 'tagName', 'IMG', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/header/facebook'), 'tagName', 'IMG', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/header/linkedIn'), 'tagName', 'IMG', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/header/twitter'), 'tagName', 'IMG', 10)