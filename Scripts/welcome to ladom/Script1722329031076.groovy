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

// Ouvrir le navigateur et naviguer vers l'URL
WebUI.openBrowser('')
WebUI.navigateToUrl('https://beneficiaire.ladom.fr/')


// Cliquer sur un élément pour naviguer dans la page
WebUI.click(findTestObject('Object Repository/LADOM_Portail/div_Je souhaite dcouvrir les dispositifs'))

def elementsToVerify = [
	[findTestObject('Object Repository/LADOM_Portail/div_Bienvenue'), 'Bienvenue sur le portail LADOM'],
	[findTestObject('Object Repository/LADOM_Portail/div_Demande de passeport'), 'Demande de Passeport pour la Mobilité de la Formation Professionnelle'],
	[findTestObject('Object Repository/LADOM_Portail/div_Demande Obsques'), 'Demande d’Aide aux Obsèques'],
	[findTestObject('Object Repository/LADOM_Portail/div_Transport'), 'Demande d’Aide au Transport de Corps'],
	[findTestObject('Object Repository/LADOM_Portail/div_Validation'), "Demande de Validation des Acquis de l'Expérience"],
	[findTestObject('Object Repository/LADOM_Portail/div_dOral de Concours'), 'Demande d’Oral de Concours'],
	[findTestObject('Object Repository/LADOM_Portail/div_prise de poste'), 'Demande de prise de poste'],
	
	[findTestObject('Object Repository/LADOM_Portail/h1_Bienvenue sur le portail LADOM'), 'Bienvenue sur le portail LADOM'],	
	[findTestObject('Object Repository/LADOM_Portail/h1_Toutes les aides'), 'Toutes les aides'],
	[findTestObject('Object Repository/LADOM_Portail/h5_Demande de Passeport Professionnelle'), 'Demande de Passeport pour la Mobilité de la Formation Professionnelle'],
	[findTestObject('Object Repository/LADOM_Portail/h5_Demande Obsques'), 'Demande d’Aide aux Obsèques'],
	[findTestObject('Object Repository/LADOM_Portail/h5_dOral de Concours'), 'Demande d’Oral de Concours'],
	[findTestObject('Object Repository/LADOM_Portail/h5_prise de poste'), 'Demande de prise de poste'],
	[findTestObject('Object Repository/LADOM_Portail/h5_Transport'), 'Demande d’Aide au Transport de Corps'],
	[findTestObject('Object Repository/LADOM_Portail/h5_Validation'), "Demande de Validation des Acquis de l'Expérience"]
	
]

// Utiliser une boucle pour vérifier chaque élément et son texte
for (element in elementsToVerify) {
	TestObject testObject = element[0]
	String expectedText = element[1]
	WebUI.verifyElementPresent(testObject, 10)
	WebUI.verifyMatch(WebUI.getText(testObject), expectedText, false)
}

// Vérification des attributs pour les éléments d'image et SVG
def elementsWithAttributes = [
	[findTestObject('Object Repository/LADOM_Portail/img'), ['tagName': 'IMG', 'src': 'https://beneficiaire.ladom.fr/beneficiaire/categories/pmfp.jpg']],
	[findTestObject('Object Repository/LADOM_Portail/img_Demande aux Obseques'), ['tagName': 'IMG', 'src': 'https://beneficiaire.ladom.fr/beneficiaire/categories/fao.jpg']],
	[findTestObject('Object Repository/LADOM_Portail/img_Demande Concours'), ['tagName': 'IMG', 'src': 'https://beneficiaire.ladom.fr/beneficiaire/categories/oco.jpg']],
	[findTestObject('Object Repository/LADOM_Portail/img_Demande dAide au Transport'), ['tagName': 'IMG', 'src': 'https://beneficiaire.ladom.fr/beneficiaire/categories/ftc.jpg']],
	[findTestObject('Object Repository/LADOM_Portail/img_Demande de prise de poste'), ['tagName': 'IMG', 'src': 'https://beneficiaire.ladom.fr/beneficiaire/categories/pdp.jpg']],
	[findTestObject('Object Repository/LADOM_Portail/img_Demande de Validations'), ['tagName': 'IMG', 'src': 'https://beneficiaire.ladom.fr/beneficiaire/categories/vae.jpg']],
	
	[findTestObject('Object Repository/LADOM_Portail/svg_Demande de Passeport'), ['tagName': 'svg']],
	[findTestObject('Object Repository/LADOM_Portail/svg_Demande Obsques'), ['tagName': 'svg']],
	[findTestObject('Object Repository/LADOM_Portail/svg_dOral de Concours'), ['tagName': 'svg']],
	[findTestObject('Object Repository/LADOM_Portail/svg_prise de poste'), ['tagName': 'svg']],
	[findTestObject('Object Repository/LADOM_Portail/svg_Transport'), ['tagName': 'svg']],
	[findTestObject('Object Repository/LADOM_Portail/svg_Validation'), ['tagName': 'svg']]
]

for (element in elementsWithAttributes) {
	TestObject testObject = element[0]
	Map<String, String> attributes = element[1]
	WebUI.verifyElementPresent(testObject, 10)
	attributes.each { attrName, expectedValue ->
		WebUI.verifyElementAttributeValue(testObject, attrName, expectedValue, 10)
	}
}

