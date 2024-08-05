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

menu_vie_etudiant = findTestObject('Object Repository/menu_1 vie etudiante/a_Vie tudiante')
WebUI.verifyMatch(WebUI.getText(menu_vie_etudiant), 'VIE ÉTUDIANTE', false)
 
WebUI.mouseOver(menu_vie_etudiant)
WebUI.verifyMatch(WebUI.getText(
	findTestObject('Object Repository/menu_1 vie etudiante/div_Vie tudiante')), 'Vie étudiante', false)

links = [
	Tuple.tuple(findTestObject('Object Repository/menu_1 vie etudiante/a_Cadres davenir'), "Cadres d'avenir", 'https://ladom.fr/vie-etudiante/cadres-d-avenir/'),
	Tuple.tuple(findTestObject('Object Repository/menu_1 vie etudiante/a_Oraux de concours'), 'Oraux de concours', 'https://ladom.fr/vie-etudiante/oraux-de-concours/'),
	Tuple.tuple(findTestObject('Object Repository/menu_1 vie etudiante/a_Passeport Mobilit Stage Professionnel'), 'Passeport Mobilité Stage Professionnel', 'https://ladom.fr/vie-etudiante/pmsp/'),
	Tuple.tuple(findTestObject('Object Repository/menu_1 vie etudiante/a_Passeport Mobilit tudes'), 'Passeport Mobilité Études', 'https://ladom.fr/vie-etudiante/pme/' ),
	]
	
for(link in links){
	WebUI.verifyMatch(WebUI.getText(link[0]), link[1], false)
	WebUI.verifyMatch(WebUI.getAttribute(link[0], 'href'), link[2], true)
}