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
		assert.strictEqual(elementText.includes("Super Mario"), true, "Super Mario Exists");
	} catch (err) {
		handleFailure(err, driver);
	} finally {
		await driver.quit();
	}
})();

function handleFailure(err, driver) {
	console.error('Something went wrong!\n', err.stack, '\n');
	driver.quit();
	process.exit(1);
}