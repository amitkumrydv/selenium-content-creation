package com.jforce.selenium.constants;


public final class EndPointConstants {

	private EndPointConstants() {
		throw new IllegalStateException("EndPointConstants Class");
	}

	public static final String UIELEMENT_ERROR_TEXT = "No element with locator [%s] containing text [%s] found";

//	URLs
	public static final String ELEMENTS_PAGE = "elements";
	public static final String TEXTBOX_PAGE = "text-box";
	public static final String CHECKBOX_PAGE = "checkbox";
	public static final String RADIOBUTTON_PAGE = "radio-button";
	public static final String WEBTABLES_PAGE = "webtables";
	public static final String ENDPOINT_LTI = "/admin-lti";
	public static final String COURSES = "/courses";
	

}
