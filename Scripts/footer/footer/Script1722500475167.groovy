import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
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

// Open the browser and navigate to the URL
WebUI.openBrowser('https://beneficiaire.ladom.fr/')

// Verify and validate footer links and their attributes
def verifyFooterLink(String objectPath, String expectedText, String expectedHref) {
    TestObject link = findTestObject(objectPath)
    WebUI.verifyElementPresent(link, 10)
    WebUI.verifyMatch(WebUI.getText(link), expectedText, false)
    WebUI.verifyElementAttributeValue(link, 'href', expectedHref, 10)
}

// Footer links data: [Object Path, Expected Text, Expected Href]
def footerLinks = [
    ['Object Repository/footer/footer/a_Contact', 'Contact', 'https://ladom.fr/contact/'],
    ['Object Repository/footer/footer/a_Mentions lgales', 'Mentions légales', 'https://ladom.fr/mentions-legales/'],
    ['Object Repository/footer/footer/a_Charte de Protection des donnes des bnficiaires', 'Charte de Protection des données des bénéficiaires', 'https://ladom.fr/mentions-legales/protection-des-donnees/'],
    ['Object Repository/footer/footer/a_Espace Presse', 'Espace Presse', 'https://ladom.fr/reportage-interview/'],
    ['Object Repository/footer/footer/a_LUnion Europenne', "L'Union Européenne", 'https://ladom.fr/lunion-europeenne/'],
    ['Object Repository/footer/footer/a_Marchs publics', 'Marchés publics', 'https://ladom.fr/marches-publics/'],
    ['Object Repository/footer/footer/a_Registre des actes administratifs', 'Registre des actes administratifs', 'https://ladom.fr/registre-administratif/'],
    ['Object Repository/footer/footer/a_Plan du site', 'Plan du site', 'https://ladom.fr/plan-du-site/']
]

// Verify each footer link
footerLinks.each { linkData ->
    verifyFooterLink(linkData[0], linkData[1], linkData[2])
}

// Verify logos with their hrefs
def verifyLogo(String objectPath, String expectedHref) {
    TestObject logo = findTestObject(objectPath)
    WebUI.verifyElementPresent(logo, 10)
    WebUI.verifyElementAttributeValue(logo, 'href', expectedHref, 10)
}

// Logo links data: [Object Path, Expected Href]
def logoLinks = [
    ['Object Repository/footer/footer/a_Plan du site_ml-8', 'https://ladom.fr/lunion-europeenne'],
    ['Object Repository/footer/footer/a_Plan du site_ml-8_1', 'https://www.outre-mer.gouv.fr/']
]

// Verify each logo link
logoLinks.each { logoData ->
    verifyLogo(logoData[0], logoData[1])
}

// Function to find parent with a certain number of levels up
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
    ['Object Repository/footer/footer/img', "https://instagram.com/ladom_officiel?igshid=YmMyMTA2M2Y="],
    ['Object Repository/footer/footer/img_1', "https://www.facebook.com/profile.php?id=100089421491048"],
    ['Object Repository/footer/footer/img_1_2', "https://x.com/LadomOfficiel?t=5Nzs9PySJ0SSyUlEkHFysw&s=09"],
    ['Object Repository/footer/footer/img_1_2_3', "https://www.linkedin.com/company/ladom/"]
]

// Verify each image link's href value
imgObjects.each { imgData ->
    TestObject imgObj = findTestObject(imgData[0])
    TestObject parentLink = findParentWithTag(imgObj, 1)
    String actualHref = WebUI.getAttribute(parentLink, 'href')
    WebUI.verifyMatch(actualHref, imgData[1], false, FailureHandling.CONTINUE_ON_FAILURE)
}

// Verify the presence of the footer's final element
WebUI.verifyElementPresent(findTestObject('Object Repository/footer/footer/div_v1.3.3 -  LADOM 2024'), 10)

// Close the browser
WebUI.closeBrowser()