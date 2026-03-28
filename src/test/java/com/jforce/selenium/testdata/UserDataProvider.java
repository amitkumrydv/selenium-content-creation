package com.jforce.selenium.testdata;

import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

import com.github.javafaker.Faker;


@Component
public class UserDataProvider {

	@DataProvider(name = "User Data", parallel = true)
	public Object[][] userDataProvider() {
		Object[][] userDataSet = { { generateUserData() }, { generateUserData() } };

		return userDataSet;

	}

	public UserModal generateUserData() {
		Faker faker = new Faker();
		return UserModal.builder().firstName(faker.name().firstName())
				.email(faker.internet().emailAddress())
				.build();
	}

}
