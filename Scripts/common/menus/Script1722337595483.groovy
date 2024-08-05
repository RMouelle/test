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

List Menu(
	Tuple2<TestObject, String> entrypoint,
	Tuple2<TestObject, String> title,
	List<Tuple3<TestObject, String, String>> links,
	List<Tuple2<TestObject, String>> extras = []) {
	return [entrypoint, title, links, extras]
}


menus = [
	Menu(
		Tuple.tuple(
			findTestObject ('Object Repository/common/menu1_vie_etudiante/a_entrypoint'),
			'VIE ÉTUDIANTE'),
		Tuple.tuple(
			findTestObject('Object Repository/common/menu1_vie_etudiante/div_titre'),
			'Vie étudiante'),
		[
			Tuple.tuple(
				findTestObject('Object Repository/common/menu1_vie_etudiante/a_PasseportMobilitEtudes'),
				'Passeport Mobilité Études',
				[
					'https://ladom.fr/vie-etudiante/pme/',
					'https://ladom.fr/vie-etudiante/pme',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu1_vie_etudiante/a_PasseportMobiliteStageProfessionnel'),
				'Passeport Mobilité Stage Professionnel',
				[
					'https://ladom.fr/vie-etudiante/pmsp/',
					'https://ladom.fr/vie-etudiante/pmsp',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu1_vie_etudiante/a_OrauxConcours'),
				'Oraux de concours',
				[
					'https://ladom.fr/vie-etudiante/oraux-de-concours/',
					'https://ladom.fr/vie-etudiante/oraux-de-concours',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu1_vie_etudiante/a_CadresAvenir'),
				'Cadres d\'avenir',
				[
					'https://ladom.fr/vie-etudiante/cadres-d-avenir/',
					'https://ladom.fr/vie-etudiante/cadres-d-avenir',],),],),
	Menu(
		Tuple.tuple(
			findTestObject('Object Repository/common/menu2_vie_active/a_Entrypoint'),
			'VIE ACTIVE'),
		Tuple.tuple(
			findTestObject('Object Repository/common/menu2_vie_active/div_Titre'),
			'Vie active'),
		[
			Tuple.tuple(
				findTestObject('Object Repository/common/menu2_vie_active/a_PasseportMobiliteFormationProfessionnelle'),
				'Passeport Mobilité Formation Professionnelle',
				[
					'https://ladom.fr/vie-active/formation-professionnelle/',
					'https://ladom.fr/vie-active/formation-professionnelle',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu2_vie_active/a_OrauxConcours'),
				'Oraux de concours',
				[
					'https://ladom.fr/vie-active/loraux-de-concours/',
					'https://ladom.fr/vie-active/loraux-de-concours',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu2_vie_active/a_PrisePoste'),
				'Prise de poste',
				[
					'https://ladom.fr/vie-active/prise-de-poste/',
					'https://ladom.fr/vie-active/prise-de-poste',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu2_vie_active/a_CertificationVAE'),
				'Certification VAE',
				[
					'https://ladom.fr/vie-active/certification-vae/',
					'https://ladom.fr/vie-active/certification-vae',],),],),
	Menu(
		Tuple.tuple(
			findTestObject('Object Repository/common/menu3_vie_quotidienne/a_Entrypoint'),
			'VIE QUOTIDIENNE'),
		Tuple.tuple(
			findTestObject('Object Repository/common/menu3_vie_quotidienne/div_Titre'),
			'Vie quotidienne'),
		[
			Tuple.tuple(
				findTestObject('Object Repository/common/menu3_vie_quotidienne/a_AideVoyageGrandPublic'),
				'Aide au voyage Grand Public',
				[
					'https://ladom.fr/vie-quotidienne/bon-voyage/',
					'https://ladom.fr/vie-quotidienne/bon-voyage',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu3_vie_quotidienne/a_AideVoyageTalents'),
				'Aide au voyage Talents',
				[
					'https://ladom.fr/vie-quotidienne/mobilite-talents/',
					'https://ladom.fr/vie-quotidienne/mobilite-talents',],),],),
	Menu(
		Tuple.tuple(
			findTestObject('Object Repository/common/menu4_urgences_vie/a_Entrypoint'),
			'URGENCES DE LA VIE'),
		Tuple.tuple(
			findTestObject('Object Repository/common/menu4_urgences_vie/div_Titre'),
			'Urgences de la vie'),
		[
			Tuple.tuple(
				findTestObject('Object Repository/common/menu4_urgences_vie/a_Funeraire'),
				'Funéraire',
				[
					'https://ladom.fr/urgences-de-la-vie/funeraire/',
					'https://ladom.fr/urgences-de-la-vie/funeraire',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu4_urgences_vie/a_EnfantsEvacuesSanitaires'),
				'Enfants évacués sanitaires',
				[
					'https://ladom.fr/urgences-de-la-vie/accompagnants-evacues-sanitaires/',
					'https://ladom.fr/urgences-de-la-vie/accompagnants-evacues-sanitaires',],),],),
	Menu(
		Tuple.tuple(
			findTestObject('Object Repository/common/menu5_ladom/a_Entrypoint'),
			'LADOM'),
		Tuple.tuple(
			findTestObject('Object Repository/common/menu5_ladom/div_Titre'),
			'LADOM'),
		[
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/a_Mission'),
				'Mission',
				[
					'https://ladom.fr/nous-connaitre/notre-mission/',
					'https://ladom.fr/nous-connaitre/notre-mission',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/a_Organisation'),
				'Organisation',
				[
					'https://ladom.fr/nous-connaitre/notre-organisation/',
					'https://ladom.fr/nous-connaitre/notre-organisation',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/a_Publications'),
				'Publications',
				[
					'https://ladom.fr/nos-publications/',
					'https://ladom.fr/nos-publications',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/a_Partenaires'),
				'Partenaires',
				[
					'https://ladom.fr/partenaire/',
					'https://ladom.fr/partenaire',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/a_Implantations'),
				'Implantations',
				[
					'https://ladom.fr/implantation/',
					'https://ladom.fr/implantation',],),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/a_PolitiqueRH'),
				'Politique RH',
				[
					'https://ladom.fr/nous-rejoindre/politique-rh/',
					'https://ladom.fr/nous-rejoindre/politique-rh',]),],
		[
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/div_bloc1_Titre'),
				'NOUS CONNAÎTRE'),
			Tuple.tuple(
				findTestObject('Object Repository/common/menu5_ladom/div_bloc2_Titre'),
				'NOUS REJOINDRE'),],),
]


for(menu in menus) {
	entrypoint = menu[0]
	menuTitle = menu[1]
	menuLinks = menu[2]
	menuExtras = menu[3]
	
	WebUI.verifyMatch(WebUI.getText(entrypoint[0]), entrypoint[1], false)
	
	WebUI.mouseOver(entrypoint[0]) // pour ouvrir le menu
	WebUI.verifyMatch(WebUI.getText(menuTitle[0]), menuTitle[1], false)
	
	for (link in menuLinks) {
		WebUI.mouseOver(entrypoint[0]) // pour être sur que le menu reste ouvert
		WebUI.callTestCase(
			findTestCase('Test Cases/add-ons/check_txt_link'),
			[obj:link[0], txt:link[1], urls:link[2]])
	}
	
	for (extra in menuExtras) {
		WebUI.mouseOver(entrypoint[0]) // pour être sur que le menu reste ouvert
		WebUI.verifyMatch(WebUI.getText(extra[0]), extra[1], false)
	}
}


WebUI.callTestCase(
	findTestCase('Test Cases/add-ons/check_txt_link'),
	[
		obj:findTestObject('Object Repository/common/menu6_a_Contact'),
		txt:'CONTACT',
		urls:['https://ladom.fr/contact/', 'https://ladom.fr/contact',],]) // sur ladom: http://98.66.208.236/contact/

