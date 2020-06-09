const {Builder, By, Key, until} = require('selenium-webdriver');
const assert = require('assert');

(async function example() {
	let driver = await new Builder()
			.forBrowser('chrome')
			.usingServer(process.env.SELENIUM_URL)
			.build();
	
	try {
		await driver.get(process.env.STAGING_URL);
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