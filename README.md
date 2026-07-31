# Code Walkthrough

## 1. Browser Configuration

```java
ChromeOptions options = new ChromeOptions();
```

**Explanation:**
- Creates a `ChromeOptions` object.
- This object is used to customize how the Chrome browser is launched.

---

```java
options.addArguments("--guest");
```

**Explanation:**
- Launches Chrome in **Guest Mode**.
- Guest Mode starts a fresh browser session without using existing cookies, cache, browser history, or installed extensions.
- This helps ensure consistent and isolated test execution.

---

```java
WebDriver driver = new ChromeDriver(options);
```

**Explanation:**
- Creates a new Chrome browser instance.
- Passes the configured `ChromeOptions` to the browser.
- Initializes the Selenium WebDriver, which is used to automate browser actions.

---

## 2. Browser Initialization

```java
driver.manage().window().maximize();
```

**Explanation:**
- Maximizes the browser window.
- Ensures all UI elements are fully visible and reduces failures caused by different screen resolutions.

---

```java
driver.get("https://www.saucedemo.com");
```

**Explanation:**
- Opens the Swag Labs application.
- Waits for the webpage to load before continuing execution.

---

## 3. User Authentication

```java
driver.findElement(By.id("user-name")).sendKeys("standard_user");
```

**Explanation:**
- Locates the Username field using the **ID** locator.
- Enters the username `standard_user`.

---

```java
driver.findElement(By.id("password")).sendKeys("secret_sauce");
```

**Explanation:**
- Locates the Password field using the **ID** locator.
- Enters the password `secret_sauce`.

---

```java
driver.findElement(By.id("login-button")).click();
```

**Explanation:**
- Locates the Login button.
- Performs a click action to authenticate the user.

---

## 4. Product Selection

```java
driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
```

**Explanation:**
- Locates the "Add to Cart" button using an XPath locator.
- Adds the selected product to the shopping cart.

---

## 5. Shopping Cart Navigation

```java
driver.findElement(By.cssSelector(".shopping_cart_link")).click();
```

**Explanation:**
- Locates the shopping cart icon using a CSS Selector.
- Opens the shopping cart page.

---

```java
driver.findElement(By.className("checkout_button")).click();
```

**Explanation:**
- Locates the Checkout button using its class name.
- Navigates to the checkout page.

---

## 6. Explicit Wait

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
```

**Explanation:**
- Creates an Explicit Wait with a maximum timeout of 20 seconds.
- Selenium waits only when required, improving test stability.

---

```java
WebElement firstname = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
```

**Explanation:**
- Waits until the First Name field becomes visible.
- Returns the element once it is available.
- Prevents `NoSuchElementException` and synchronization issues.

---

```java
firstname.sendKeys("Test");
```

**Explanation:**
- Enters the customer's first name into the input field.

---

```java
driver.findElement(By.id("last-name")).sendKeys("Name");
```

**Explanation:**
- Locates the Last Name field.
- Enters the customer's last name.

---

```java
driver.findElement(By.id("postal-code")).sendKeys("487952");
```

**Explanation:**
- Locates the Postal Code field.
- Enters the delivery ZIP/Postal code.

---

## 7. Continue Checkout

```java
driver.findElement(By.name("continue")).click();
```

**Explanation:**
- Clicks the Continue button.
- Navigates to the order overview page.

---

## 8. Complete Purchase

```java
driver.findElement(By.className("cart_button")).click();
```

**Explanation:**
- Locates the Finish button.
- Completes the purchase process.

---

## 9. Order Confirmation

```java
WebElement message = wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//h2[normalize-space()='Thank you for your order!']")));
```

**Explanation:**
- Waits until the order confirmation message appears.
- Confirms that the purchase has been successfully completed.

---

```java
System.out.println(message.getText());
```

**Explanation:**
- Retrieves the confirmation message.
- Prints the message to the console for verification.

---

## 10. Generate Order PDF

```java
driver.findElement(By.id("generate-pdf-order")).click();
```

**Explanation:**
- Clicks the **Generate PDF** button.
- Downloads the order summary in PDF format (if supported by the application).

---

## 11. Logout

```java
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn"))).click();
```

**Explanation:**
- Waits until the navigation menu button is visible.
- Opens the application menu.

---

```java
driver.findElement(By.id("logout_sidebar_link")).click();
```

**Explanation:**
- Clicks the Logout option.
- Ends the current user session securely.

---
