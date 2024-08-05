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

// logo LADOM
WebUI.callTestCase(findTestCase('Test Cases/add-ons/check_img_link'), [
	obj:findTestObject('Object Repository/common/header/img_logo'),
	src:'https://beneficiaire.ladom.fr/beneficiaire/LADOM.png',
	urls:['https://www.ladom.fr/', 'https://www.ladom.fr',],])

// Simulateur Test
WebUI.callTestCase(findTestCase('Test Cases/add-ons/check_txt_link'), [
	obj:findTestObject('Object Repository/common/header/a_monespace'),
	txt:'Mon espace',
	urls:['https://beneficiaire.ladom.fr/login'],])

// cofinance UE
WebUI.callTestCase(findTestCase('Test Cases/add-ons/check_img_link'), [
	obj:findTestObject('Object Repository/common/header/img_cofinUE'),
	src:'https://beneficiaire.ladom.fr/beneficiaire/UE_POS.png',
	urls:[
		'https://ladom.fr/lunion-europeenne/',
		'https://ladom.fr/lunion-europeenne',],])

// Images Social
socials = [
	Tuple.tuple(
		findTestObject('Object Repository/common/header/img_soc_insta'),
		'https://beneficiaire.ladom.fr/social/instagram_header.svg',
		['https://instagram.com/ladom_officiel?igshid=YmMyMTA2M2Y='],),
	Tuple.tuple(
		findTestObject('Object Repository/common/header/img_soc_fb'),
		'https://beneficiaire.ladom.fr/social/facebook_header.svg',
		['https://www.facebook.com/profile.php?id=100089421491048'],),
	Tuple.tuple(
		findTestObject('Object Repository/common/header/img_soc_x'),
		'https://beneficiaire.ladom.fr/social/x_header.svg',
		['https://x.com/LadomOfficiel?t=5Nzs9PySJ0SSyUlEkHFysw&s=09'],),
	Tuple.tuple(
		findTestObject('Object Repository/common/header/img_soc_in'),
		'https://beneficiaire.ladom.fr/social/linkedin_header.svg',
		[
			'https://www.linkedin.com/company/ladom/',
			'https://www.linkedin.com/company/ladom',],),]

for(soc in socials) {
	WebUI.callTestCase(findTestCase('Test Cases/add-ons/check_img_link'), [obj:soc[0], src:soc[1], urls:soc[2]])
}
