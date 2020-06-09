const {Builder, By, Key, until} = require('selenium-webdriver');
const assert = require('assert');

(async function example() {
	let driver = await new Builder()
			.forBrowser('chrome')
			.usingServer('http://192.168.1.207:4444/wd/hub')
			.build();
	
	try {
		await driver.get('http://192.168.1.205:3000/');
		await driver.getTitle().then(function(title) {
			console.log("The title is: " + title)
		});
		
		const element = await driver.wait(until.elementLocated(By.className("panel")), 10000);
		const elementText = await element.getText();
		assert.strictEqual(elementText.includes("Super Mario"), false, "Super Mario Exists");
	} finally {
		await driver.quit();
	}
})();