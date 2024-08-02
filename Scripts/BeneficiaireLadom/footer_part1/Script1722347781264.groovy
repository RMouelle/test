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

WebUI.openBrowser('')



WebUI.navigateToUrl('http://beneficiaire.ladom.fr/')

def tests = [
	[object: 'Object Repository/footer-part1/a_Contact', tagName: 'A', href: 'https://ladom.fr/contact/', text: 'Contact'],
	[object: 'Object Repository/footer-part1/a_Mentions_legales', tagName: 'A', href: 'https://ladom.fr/mentions-legales/', text: 'Mentions légales'],
	[object: 'Object Repository/footer-part1/a_LUnion_Europenne', tagName: 'A', href: 'https://ladom.fr/lunion-europeenne/', text: "L'Union Européenne"],
	[object: 'Object Repository/footer-part1/a_Marches_Publics', tagName: 'A', href: 'https://ladom.fr/marches-publics/', text: 'Marchés publics'],
	[object: 'Object Repository/footer-part1/a_Charte_de_Protection_des_donnees_des_beneficiaires', tagName: 'A', href: 'https://ladom.fr/mentions-legales/protection-des-donnees/', text: 'Charte de Protection des données des bénéficiaires'],
	[object: 'Object Repository/footer-part1/a_Espace_Presse', tagName: 'A', href: 'https://ladom.fr/reportage-interview/', text: 'Espace Presse'],
	[object: 'Object Repository/footer-part1/a_Registre_des_actes_administratifs', tagName: 'A', href: 'https://ladom.fr/registre-administratif/', text: 'Registre des actes administratifs'],
	[object: 'Object Repository/footer-part1/a_Plan_du_site', tagName: 'A', href: 'https://ladom.fr/plan-du-site/', text: 'Plan du site']
]

tests.each { element ->
	def sim_object = findTestObject(element.object)
	WebUI.verifyElementAttributeValue(sim_object, 'tagName', element.tagName, 0)
	WebUI.verifyElementAttributeValue(sim_object, 'href', element.href, 20)
	WebUI.verifyMatch(WebUI.getText(sim_object), element.text, false)
}






