import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://beneficiaire.ladom.fr/')


WebUI.verifyElementAttributeValue(findTestObject('Object Repository/footer-part2/img_unionEuropeene'), 'tagName', 'IMG', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/footer-part2/a_unionEuropeene'), 'tagName', 'A', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/footer-part2/a_unionEuropeene'), 'href', 'https://ladom.fr/lunion-europeenne', 10)


WebUI.verifyElementAttributeValue(findTestObject('Object Repository/footer-part2/img_ministerDeInterieur'), 'tagName', 'IMG', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/footer-part2/a_ministerDeInterieur'), 'tagName', 'A', 10)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/footer-part2/a_ministerDeInterieur'), 'href', 'https://www.outre-mer.gouv.fr/', 10)


// tester les images reseau sociaux
TestObject findParentWithTag(TestObject obj, int lvl) {
	String path = obj.findXpathValue('xpath:position')
	if (path == null) {
		throw new StepFailedException("Unable to get path from object.")
	}
	for (int i = 0; i < lvl; ++i) {
		path = "$path/.."
	}
	TestObject parent = new TestObject('parent')
	parent.addProperty('xpath', ConditionType.EQUALS, path)
	return parent
}
 
// Define the image test objects and expected href values
def imgObjects = [
	['Object Repository/footer-part2/img_istagram', "https://instagram.com/ladom_officiel?igshid=YmMyMTA2M2Y="],
	['Object Repository/footer-part2/img_facebook', "https://www.facebook.com/profile.php?id=100089421491048"],
	['Object Repository/footer-part2/img_twitter', "https://x.com/LadomOfficiel?t=5Nzs9PySJ0SSyUlEkHFysw&s=09"],
	['Object Repository/footer-part2/img_linked', "https://www.linkedin.com/company/ladom/"]
]
 
// Verify each image link's href value
imgObjects.each { imgData ->
	TestObject imgObj = findTestObject(imgData[0])
	TestObject parentLink = findParentWithTag(imgObj, 1)
	String actualHref = WebUI.getAttribute(parentLink, 'href')
	WebUI.verifyMatch(actualHref, imgData[1], false, FailureHandling.CONTINUE_ON_FAILURE)
}

//test si l'objet 'v1.3.3 - © LADOM 2024'est present dans cette partie de la page web
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/footer-part2/txt_v1.2.3-LADOM_2024')), 'v1.3.3 - © LADOM 2024', false)


