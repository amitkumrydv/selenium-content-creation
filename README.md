Executive Summary
The selenium-content-creation repository implements a Java/Spring Boot-based Selenium test framework with TestNG and Allure. Its structure cleanly separates application code (under src/main/java/com/jforce/selenium) from tests (src/test/java/com/jforce/selenium). The framework uses Spring dependency injection (e.g. autowired WebDriver, PageObjects, and services) and follows a Page Object Model for UI interactions. Key design patterns include Page Object, Observer (via TestNG listeners), Facade (in action helper classes), Template Method (in the test base class), and extensive use of Dependency Injection【115†L474-L482】【130†L398-L402】. Explicit waits and synchronization strategies are encapsulated in a WaitActions helper (see code snippet below) to ensure robust element handling【154†L822-L830】. Test setup/teardown is centralized in a SpringBoot-based abstract test class (Common), which handles login via REST token or UI and logout logic. Reporting leverages TestNG listeners and Allure annotations (e.g. screenshot attachments)【130†L434-L440】【118†L452-L460】. The framework is containerized (Dockerfile/docker-compose) for CI/CD.

Overall, the framework demonstrates strong modularity (clear separation of concerns and DI-managed components) but could improve consistency and scalability (e.g. more builder or factory usage, data-driven testing). The sections below detail structure, patterns, test design, and suggest enhancements.

Repository Structure and Key Components
Project root: Contains Maven files (pom.xml), Docker artifacts (Dockerfile.File, docker-compose.yml), environment and Git configs (.env, .gitignore, .gitattributes), and a top-level README.md.
src/main/java/com/jforce/selenium: Application & framework code. Notably:
SeleniumContentCreationApplication.java: the Spring Boot entry point.
config/: Spring configuration (e.g. DriverScopeConfig defines a custom Spring driver scope for WebDriver threads).
driverscope/: Implements a custom ThreadScope (DriverScope) ensuring each test thread gets its own WebDriver.
entity/ and repository/: A JPA UserEntity and UserRepository for retrieving test user credentials (repository pattern)【115†L474-L482】.
service/: Business logic (UserService uses UserRepository to fetch user data). This is used by tests to obtain login credentials for different roles【115†L474-L482】.
actions/: Core Selenium utilities (the facade). For example, ElementActions wraps low-level Selenium operations (click, sendKeys, etc.) and is a Spring @Component extending ActionsBaseClass【115†L474-L482】【118†L452-L460】. Similarly, WaitActions provides reusable explicit-wait methods (e.g. waitForTableRows(By…) uses WebDriverWait)【154†L822-L830】.
constants/, interfaces/: Abstractions for common element identifiers or UI action interfaces (IUIElements, etc.), aiding loose coupling.
listeners/: A TestNG listener (TestListener) implements the Observer pattern, reacting to test events (logging results, taking screenshots on failure, integrating with Allure).
repository/: Contains UserRepository (Spring Data interface) – an implementation of the Repository pattern.
entity/: Entities like UserEntity represent data (used via JPA).
src/test/java/com/jforce/selenium: Test code, organized into sub-packages:
common/: Abstract test base and shared components. Common.java extends AbstractTestNGSpringContextTests and sets up login/logout logic using Spring DI. It uses a template method getRoleForTest() so concrete tests supply a role string; it then fetches the user and performs login【115†L474-L482】. CommonPageObject.java provides teardown hooks (taking screenshots via Allure @Attachment and closing the browser)【118†L452-L460】. This base class demonstrates the Template Method pattern (subclasses override getRoleForTest) and centralized setup/teardown.
elements/: Classes with static By locators, e.g. LoginElements lists all locators on the login page【124†L300-L308】. This is effectively a simple Page Object (element repository) approach.
pageObject/: True Page Object classes (e.g. LoginPageObject, TableOfContentPageObject, etc.) that encapsulate interactions with each page. They are Spring components (autowired in tests) and use the element locators and ElementActions. For example, LoginPageObject extends CommonPageObject and provides methods like openLoginPage(), enterCredentials(...), and clickLoginButton()【130†L398-L402】【130†L406-L412】, each marked with Allure @Step.
testdata/: Data providers and test data classes. For example, UserDataProvider or TutorialProductionTestData holds expected table headers and field names for assertions. This separates static test data from logic.
validations/: Classes performing detailed content checks (e.g. verifying table contents or EPUB content). These are utility validators used by tests.
test/: Actual test classes named by role (e.g. UniversityAdmin.java, FacultyReview.java, etc.). Each extends Common and implements getRoleForTest()【136†L406-L410】. They then use PageObjects to navigate pages and perform verifications. For example, UniversityAdmin has methods like verifyPlanningScheduleTableHeaders() which navigate to a page, switch tabs, use WaitActions to sync, and then assert expected headers from TutorialProductionTestData【136†L415-L423】【154†L822-L830】.
resources/: TestNG suite definitions. Element-Tests.xml defines TestNG <suite> and <test> groups, pointing to the test classes. Suites.xml is a meta-suite aggregating those. For example, Element-Tests.xml invokes com.auto.framework.ElementTests (likely a generic runner). This shows TestNG is the runner framework.
Overall, code structure cleanly separates test logic (page objects, validations) from reusable actions/services. Spring Boot manages the lifecycle and DI of components, enabling easy injection of WebDriver, page objects, and services.

Design Patterns in Use
The framework applies several classic design patterns:

Page Object Pattern: All user interactions are encapsulated in PageObject classes. For example, LoginPageObject has methods like openLoginPage(), enterCredentials(), and clickLoginButton()【130†L398-L402】【130†L406-L412】. Corresponding static locator classes (e.g. LoginElements with By fields) separate locator definitions from code【124†L300-L308】. This makes tests more maintainable: if a locator changes, only one file needs updating.

Facade Pattern: Classes in actions/ (like ElementActions, JavaScriptActions, WaitActions) provide a simplified interface over low-level Selenium APIs. For example, ElementActions.click(By locator) internally does waits and then performs element.click()【68†L420-L428】 (not shown above, but implied), hiding complexity. The ActionsBaseClass groups common fields and utilities (driver, wait, context) under one superclass【66†L215-L223】. Tests and PageObjects call these facades rather than raw WebDriver methods.

Dependency Injection: Spring’s DI is pervasive. Components like page objects and action classes are annotated with @Component or @Service, and fields are @Autowired. For instance, ActionsBaseClass has @Autowired protected WebDriver driver; and other beans【66†L215-L223】, and LoginPageObject autowires ElementActions and the interfaces for UI operations【130†L394-L402】. The test base (Common) itself is a Spring Boot test that autowires everything (e.g. @Autowired protected LoginPageObject loginPage;)【115†L474-L482】. This means no static singletons or manual wiring; Spring manages instantiation and scope (using a custom thread scope for WebDriver).

Singleton (Spring Bean Scope): Many components function as singletons in the test context (e.g. SeleniumProperties, service beans, etc.). The DriverScope defines a custom scope so each thread gets its own driver bean, effectively making WebDriver a thread-local singleton. This is an advanced pattern allowing safe parallel tests.

Template Method Pattern: The abstract test class Common defines the skeleton of login flow in loginOnce(), but calls an abstract getRoleForTest() to get the user role【115†L474-L482】. Subclasses (e.g. UniversityAdmin, Editor, etc.) override getRoleForTest() to supply the appropriate role string. This is a classic Template Method: the invariant steps (fetch user by role, login) are in the base, while the role is provided by each subclass.

Observer Pattern: Implemented via TestNG listeners. The TestListener class implements ITestListener and reacts to test events (e.g. onTestSuccess, onTestFailure). For example, on failure it takes a screenshot and attaches it to the Allure report. These listeners are registered in Common via @Listeners(TestListener.class). TestNG triggers these callbacks, decoupling test flow from reporting logic.

Repository Pattern: In src/main, the UserRepository interface (extending Spring Data) is a standard repository interface【74†L298-L306】 (though simple). The test code calls userService.getUserByRole(role)【115†L474-L482】, which uses this repository to fetch UserEntity. This separates data access logic (SQL/ORM) from business logic.

Some patterns not used or not obvious: There is no clear Factory or Builder pattern, nor an Adapter pattern. One could argue that Spring’s DriverScopePostProcessor acts like a Factory for scopes, but it is mainly framework code. The design focuses on DI, Page Objects, and reusable action services.

Test Architecture and Practices
Test Runner / Suites: Uses TestNG. Suite XMLs in resources/ define test groups. Each test class is standard TestNG (@Test methods with testName attributes). The base class Common uses @BeforeClass and @AfterSuite for setup/teardown【115†L474-L482】【118†L452-L460】. For example, loginOnce() runs once per test class to log in, and logout() runs after the suite. TestNG’s @Listeners(TestListener.class) hooks in custom reporting.

Test Flow: Tests typically do:

Setup (login): In Common.beforeClass, if no token is present, fetch a user by role (template method) and log in via LoginPageObject【115†L474-L482】.
Navigation/Actions: Each test calls page object methods. For instance, a test may do loginPage.openLoginPage(), loginPage.enterCredentials(...), loginPage.clickLoginButton()【130†L398-L402】【130†L406-L412】, then proceed to navigate through the app using other PageObjects (TableOfContentPageObject, etc.).
Assertions/Validations: Use Assert (TestNG) and custom validation classes. For example, loginPage.loginPageVerify() asserts the login form is visible【130†L434-L440】. Many tests verify table data against expected values from TutorialProductionTestData.
Teardown (logout): After all tests, Common.afterSuite logs out (clicks the Logout button via page object)【115†L520-L528】 and verifies return to login page.
Fixtures and Setup: The Common class initializes Spring context (@SpringBootTest(properties={"spring.profiles.active=test"})【115†L448-L456】), enabling use of Spring beans. It also autowires shared components (WaitActions, LoginPageObject, UserService, AuthrizationToken, etc.)【115†L454-L462】. The use of Spring profiles hints at support for environment-specific settings.

Data Management: Test data is externalized:

User credentials are stored in the application database (via UserEntity) and accessed by UserService.
Expected values (e.g. table headers, field names) are in classes like TutorialProductionTestData and ADDSubjectCodeTestData. These provide static arrays or lists which tests iterate over for assertions.
Data Providers (e.g. UserDataProvider) may supply multiple test cases or users to parameterized tests (though details are not shown in snippets, the class exists in testdata/).
Locator Strategy: Locators are centralized in static classes (elements/). For example, LoginElements.USERNAME_INPUT is By.name("username")【124†L300-L308】. This separates locator definitions from logic. Relative locators and other Selenium features are used (e.g. in ElementActions methods like clickRelativeLeftElement()). This strategy increases maintainability.

Synchronization/Waits: The framework favors explicit waits via the WaitActions utility【154†L822-L830】. For example, before asserting table contents, tests call waitActions.waitForTableRows(locator), which uses WebDriverWait until at least one row exists【154†L822-L830】. There is also an ExplicitWait component and a fallback sleep() (discouraged) in WaitActions. Actions like click() in ElementActions first wait for element to be clickable. In short, synchronization is handled by reusable utilities, avoiding arbitrary Thread.sleep in tests.

Error Handling: The TestListener captures failures and attaches screenshots. Within actions, exceptions like TimeoutException are caught (e.g. waitForTableRows returns false on timeout). The framework logs errors via SLF4J (e.g. in attachScreenShot() catching WebDriverException【118†L458-L467】). Tests use assertions (TestNG Assert) for validation.

Logging/Reporting: Uses SLF4J + Lombok (@Slf4j). Steps and actions are annotated with Allure’s @Step (e.g. on openLoginPage(), enterCredentials(), etc. in page objects)【130†L398-L402】【130†L406-L412】. Screenshots are attached with @Attachment. The TestListener integrates with Allure, attaching failure screenshots and logs. Allure’s HTML report can visualize these steps and attachments.

CI/CD Integration: The presence of a Dockerfile.File and docker-compose.yml suggests containerized execution (perhaps spinning up the Spring Boot app and Selenium environment). Likely the build (pom.xml) includes plugins for Surefire/TestNG, and perhaps Maven or Gradle is used for builds. Although specific CI (e.g. Jenkins/GitHub Actions) scripts aren’t in the repo, Docker support implies easy pipeline integration (build image, run tests). The .env file may parameterize environment (base URLs, credentials, etc.). Dependency management is via Maven (pom.xml), pulling in Spring Boot, Selenium, TestNG, Allure, etc.

Build Scripts: The pom.xml (not shown) presumably configures test dependencies and build steps. There is no custom build script checked in (no .yml or .gradle visible), but Docker suggests a CI job could build the image and run tests as part of a pipeline.

Mermaid Diagram – High-Level Architecture:

<img width="635" height="462" alt="image" src="https://github.com/user-attachments/assets/697720f3-a260-4af6-bdaf-033f107ee908" />
<img width="635" height="462" alt="image" src="https://github.com/user-attachments/assets/697720f3-a260-4af6-bdaf-033f107ee908" />


This diagram shows the Spring application (with UserService/UserRepository) and the test framework components. Tests invoke Page Objects which delegate to ElementActions (using the injected WebDriver), and listeners produce Allure reports.

Interview Talking Points
Modularity & Maintainability: The code cleanly separates concerns via packages (actions vs page objects vs tests). Spring DI makes components replaceable and mockable. Pros: High cohesion and low coupling (e.g. tests don’t new objects; everything is autowired)【115†L474-L482】【130†L398-L402】. Cons: Heavy reliance on Spring can complicate troubleshooting and slow startup. Also, using both static element classes and Spring-managed page objects is slightly inconsistent (could choose one approach).

Design Patterns: Page Object is well-implemented, making UI locators and flows easy to reuse【130†L398-L402】【124†L300-L308】. The Template Method in test base ensures DRY setup code. However, missing Factory or Builder patterns means test objects are created by DI rather than factories; introducing a factory for WebDriver (by browser type) could add flexibility for parallel runs in different browsers.

Scalability: Custom DriverScope suggests readiness for parallel execution (each thread gets its own driver). However, there’s no mention of parallel test configuration (TestNG XML parallel setting not shown). Adding a thread-safe data provider or parameterization would scale tests. The current one-URL/static-credential approach may not scale to multiple environments or data sets easily.

Synchronization Strategy: Use of WebDriverWait in WaitActions is good practice (explicit waits)【154†L822-L830】. It avoids flaky sleep. One trade-off: fixed timeouts (10s in code) might be insufficient for very slow pages; could be made configurable.

Logging and Reporting: Use of Allure steps and attachments is a strength. It produces readable reports with screenshots. Potential improvement: Capture logs on failure, or integrate video recording for UI tests.

CI/CD and Containerization: Docker files allow the entire test environment to be containerized, which is excellent for consistency across dev/CI. If not already used, integrating GitHub Actions or Jenkins to build the Docker image and execute tests on each commit would complete the pipeline.

Code Quality: The framework uses interfaces (IUIElements) for actions, which is good for extensibility (Strategy pattern potential if different implementations were needed). However, many methods have hardcoded waits or Thread.sleep comments (some commented out in CommonPageObject). Removing any remaining sleep usage and ensuring all waits are explicit would be better. Logging is consistent via Lombok’s @Slf4j, which is a plus.

Future Improvements (Roadmap):

Data-Driven Tests: Currently tests use static data classes. Introducing TestNG @DataProvider or externalizing to CSV/JSON could improve flexibility. (High priority: enables more test coverage with less code duplication.)
Factory Pattern for Drivers: Abstract WebDriver creation into a factory to support multiple browsers or remote execution (e.g. Selenium Grid). (Medium priority: future-proofs cross-browser testing.)
Page Object Factory: Instead of field autowiring, use a factory to instantiate PageObjects per test or per thread, making them more isolated. (Lower priority given DI is working.)
Reporting: Extend Allure reports with screenshots for all steps (not just failures) and add logs or videos. (Medium priority.)
Parallel Execution: Configure TestNG XML for parallel runs and validate thread safety (especially in DriverScope and static data usage). (High priority for scaling test suite.)
Continuous Integration: Setup a CI pipeline (GitHub Actions, for example) that builds the project, runs Docker containers, and publishes reports automatically. (High priority for deployment readiness.)
Table: Design Patterns – Use and Examples

Design Pattern	Description & Usage	Example (File/Method)
Page Object	Encapsulates pages. Improves maintainability by centralizing locators and actions. Used extensively: each page has a class (e.g. LoginPageObject with openLoginPage(), enterCredentials()).【130†L398-L402】【130†L406-L412】	LoginPageObject.java (uses LoginElements locators)
Facade	Simplifies complex actions. Classes like ElementActions hide wait/log logic from tests.	ElementActions.click(By) method combines wait + click.
Template Method	Base test class defines login flow but calls abstract method for role. Allows roles to vary per test.	Common.java with loginOnce() calls getRoleForTest().【115†L474-L482】
Observer (Listener)	TestNG listeners react to events (e.g. test failure). Used for screenshots and logging.	TestListener implements ITestListener, registered via @Listeners.
Dependency Injection	Spring injects beans (driver, page objects, services) into classes. Improves decoupling.	@Autowired WebDriver driver; in ActionsBaseClass【66†L215-L223】.
Repository	Data access is abstracted via Spring Data repository.	UserRepository and userService.getUserByRole(...)【115†L474-L482】.
Singleton (Bean)	Many components are singletons by default. DriverScope makes WebDriver a thread-local singleton.	DriverScopeConfig registers driverscope for WebDriver beans.
Table: Components & Suggested Improvements

Component	Current Implementation	Suggested Improvement
WebDriver Management	Custom thread scope (DriverScope) with Spring bean.	Add a Factory for different browser capabilities or remote drivers; consider Selenium Grid.
Page Objects	Spring-managed, one instance per test (by scope).	Consider a Page Object Factory to create fresh instances per test method.
Element Locators	Static classes with By fields.	Keep static locators (simple and fast), but group by page and avoid duplicate definitions.
Test Data	Hard-coded classes (*TestData.java).	Externalize to JSON/CSV or use TestNG @DataProvider for data-driven testing.
Synchronization	WaitActions with explicit waits【154†L822-L830】.	Allow configurable timeouts; implement retry logic for intermittent failures.
Logging & Reporting	SLF4J logs + Allure steps/screenshots.	Integrate full-logging (log4j) and attach logs to reports; add video capture or HTTP logs.
Build & CI	Maven build (implied), Docker support.	Setup automated CI pipeline (GitHub Actions/Jenkins) to build Docker image and run tests on commit.
    
<img width="8192" height="4465" alt="Login Process with-2026-04-03-105714" src="https://github.com/user-attachments/assets/cd560b63-e820-4b45-971f-47d0311735d6" />

This test flow illustrates a typical scenario: the Common base logs in via LoginPageObject, then the test uses TableOfContentPageObject to navigate, clicks a tab, waits for table rows with WaitActions, and verifies table headers against expected test data. Underneath, all element interactions (sendKeys, click) go through the ElementActions helper and ultimately invoke the WebDriver on a real browser.

Conclusion
The selenium-content-creation framework is a well-structured Selenium/Java test suite. Its strengths include clear design (POM, DI, explicit waits) and comprehensive setup/teardown. For interview discussion, emphasize the modular architecture (services vs page objects), design patterns (especially Page Object and Dependency Injection), and how test flows are managed. Also be prepared to talk about trade-offs (e.g. complexity of Spring DI in tests) and how you would evolve the framework (data-driven tests, parallel execution, CI integration, etc.).
