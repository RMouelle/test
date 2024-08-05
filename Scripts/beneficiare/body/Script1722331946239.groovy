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

class LADOMTest {
    static void openLADOM() {
        WebUI.openBrowser('https://beneficiaire.ladom.fr/')
    }

    static void verifyElement(String testObjectPath, String tagName, String text = null, String href = null) {
        WebUI.verifyElementPresent(findTestObject(testObjectPath), 10)
        WebUI.verifyElementAttributeValue(findTestObject(testObjectPath), 'tagName', tagName, 10)
        if (text != null) {
            WebUI.verifyTextPresent(text, false)
        }
        if (href != null) {
            WebUI.verifyElementAttributeValue(findTestObject(testObjectPath), 'href', href, 10)
        }
    }

    static void verifyCard(String cardPath, String titlePath, String iconPath, String arrowPath, String titleText, String href) {
        WebUI.mouseOver(findTestObject(cardPath))
        verifyElement(cardPath, 'DIV')
        verifyElement(titlePath, 'H3', titleText)
        verifyElement(iconPath, 'IMG')
        verifyElement(arrowPath, 'svg')
        verifyElement(cardPath.replace('div_', 'a_'), 'A', null, href)
    }

    static void closeLADOM() {
        WebUI.closeBrowser()
    }
}

LADOMTest.openLADOM()

// Verify main description presence and text
LADOMTest.verifyElement('Object Repository/body benef/body/div_Pour bnficier des dispositifs de mobili_ea4f2e', 'DIV', 'Pour bénéficier des dispositifs de mobilité de LADOM, il est nécessaire de déposer une demande en ligne sur votre espace personnel. Au préalable, assurez-vous de bien avoir pris connaissance des différents dispositifs (modalités, conditions, éligibilité, etc.).')

// Verify "Je souhaite découvrir les dispositifs" card
LADOMTest.verifyCard('Object Repository/body benef/body/div_Je souhaite dcouvrir les dispositifs', 'Object Repository/body benef/body/h3_Je souhaite dcouvrir les dispositifs', 'Object Repository/body benef/body/img_Contact_h-20 w-20 object-scale-down ove_9780fd', 'Object Repository/body benef/body/svg_Je souhaite dcouvrir les dispositifs_w-_d45247', 'Je souhaite découvrir les dispositifs', 'https://beneficiaire.ladom.fr/dispositifs')

// Verify "Je m'enregistre" card
LADOMTest.verifyCard('Object Repository/body benef/body/div_Je menregistre', 'Object Repository/body benef/body/h3_Je menregistre', 'Object Repository/body benef/body/img_Je souhaite dcouvrir les dispositifs_h-_b428f4', 'Object Repository/body benef/body/svg_Je souhaite dcouvrir les dispositifs_w-_d45247', "Je m'enregistre", 'https://beneficiaire.ladom.fr/signup')

// Verify "Je me connecte" card
LADOMTest.verifyCard('Object Repository/body benef/body/div_Je me connecte', 'Object Repository/body benef/body/h3_Je me connecte', 'Object Repository/body benef/body/img_concat(Je m, , enregistre)_h-20 w-20 ob_42a570', 'Object Repository/body benef/body/svg_Je souhaite dcouvrir les dispositifs_w-_d45247', 'Je me connecte', 'https://beneficiaire.ladom.fr/login')

LADOMTest.closeLADOM()
