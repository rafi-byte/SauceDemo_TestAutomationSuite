# Sauce Demo Test Automation Suite

## Overview
This project contains automated test scripts for https://www.saucedemo.com/, implementing various test scenarios including login, shopping cart, checkout process, and more. The automation framework uses Selenium WebDriver with Java and TestNG.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation Guide](#installation-guide)
- [Project Structure](#project-structure)
- [Test Cases](#test-cases)
- [Running Tests](#running-tests)
- [Troubleshooting](#troubleshooting)

## Prerequisites

### Required Software
1. **Java Development Kit (JDK)**
   - Download JDK 11 or higher from [Oracle Website](https://www.oracle.com/java/technologies/downloads/)
   - Install JDK
   - Set JAVA_HOME environment variable:
     - Windows: Search "Environment Variables" → Add JAVA_HOME pointing to JDK installation folder
     - Mac/Linux: Add `export JAVA_HOME=/path/to/jdk` to ~/.bash_profile

2. **Maven**
   - Download from [Maven Website](https://maven.apache.org/download.cgi)
   - Install Maven
   - Add to PATH environment variable
   - Verify installation: `mvn -version`

3. **IntelliJ IDEA**
   - Download Community Edition from [IntelliJ Website](https://www.jetbrains.com/idea/download/)
   - Install with default settings

4. **Chrome Browser**
   - Latest version required

## Installation Guide

### Step 1: Clone Repository
```
git clone https://github.com/rafi-byte/SauceDemo_TestAutomationSuite.git
cd SauceDemo_TestAutomationSuite
```

### Step 2: Open Project
1. Open IntelliJ IDEA
2. Click "File" → "Open"
3. Navigate to cloned repository
4. Select the folder and click "OK"
5. Wait for IntelliJ to import and index the project

### Step 3: Install Dependencies
1. Right-click on `pom.xml`
2. Select "Maven" → "Reload project"
3. Wait for dependencies to download

## Project Structure
```
src/
├── main/java/com/saucedemo/
│   └── utils/
│       └── TestBase.java          # Base configuration and setup
└── test/java/com/saucedemo/tests/
    ├── LoginTest.java            # Login functionality tests
    ├── AddToCartTest.java        # Shopping cart tests
    ├── CheckoutTest.java         # Checkout process tests
    ├── SortingTest.java          # Product sorting tests
    ├── LogoutTest.java           # Logout functionality tests
    ├── LockedUserTest.java       # Locked user validation
    └── CartBadgeTest.java        # Cart badge update tests
```

## Test Cases

### 1. Login Functionality (LoginTest.java)
- Valid login with standard user
- Invalid credentials validation
- Error message verification

### 2. Shopping Cart (AddToCartTest.java)
- Add multiple products
- Remove products
- Cart content verification

### 3. Checkout Process (CheckoutTest.java)
- Complete checkout flow
- Form validation
- Order confirmation

### 4. Product Sorting (SortingTest.java)
- Price low to high
- Price high to low
- Name A to Z
- Name Z to A

### 5. User Management
- Logout functionality
- Session handling
- Locked user validation

## Running Tests

### Method 1: Using IntelliJ
1. Open Project in IntelliJ
2. Wait for indexing to complete
3. Right-click on `testng.xml`
4. Select "Run 'testng.xml'"

### Method 2: Using Maven
1. Open terminal/command prompt
2. Navigate to project directory
3. Run command:
```
mvn clean test
```

### Method 3: Running Individual Tests
1. Navigate to test file in IntelliJ
2. Right-click on the test class
3. Select "Run 'TestClassName'"

## Test Data

### User Credentials
- Standard User:
  - Username: standard_user
  - Password: secret_sauce
- Locked Out User:
  - Username: locked_out_user
  - Password: secret_sauce

### Test Information
- Checkout Details:
  - First Name: John
  - Last Name: Doe
  - Postal Code: 12345

## Troubleshooting

### Common Issues and Solutions

1. **Maven Dependencies Not Loading**
   - Solution: Right-click pom.xml → Maven → Reload project

2. **Test Execution Failed**
   - Verify Chrome browser is installed
   - Check if ChromeDriver is compatible with your Chrome version
   - Clear browser cache and cookies

3. **Element Not Found Errors**
   - Increase wait time in TestBase.java
   - Check if element locators have changed

4. **Build Errors**
   - Clean project: `mvn clean`
   - Delete target folder and rebuild
   - Invalidate IntelliJ caches: File → Invalidate Caches

### Still Having Issues?
1. Check the error message in the test report
2. Verify all prerequisites are installed correctly
3. Try running with a clean Maven install:
```
mvn clean install -U
```

## Reporting Issues
If you encounter any bugs or issues:
1. Check existing issues in the GitHub repository
2. Create a new issue with:
   - Detailed description
   - Steps to reproduce
   - Expected vs actual results
   - Screenshots if applicable

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Author
[Abdullah Al Rafi]

## License
This project is licensed under the MIT License - see the LICENSE.md file for details
