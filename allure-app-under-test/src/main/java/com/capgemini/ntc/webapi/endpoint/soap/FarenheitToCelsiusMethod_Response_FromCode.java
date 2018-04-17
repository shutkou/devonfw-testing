package com.capgemini.ntc.webapi.endpoint.soap;

import java.io.IOException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import com.capgemini.ntc.webapi.core.BasePageWebAPI;
import com.capgemini.ntc.webapi.endpoint.soap.FarenheitToCelsiusMethod_Response_FromCode;
import com.capgemini.ntc.webapi.soap.SoapMessageGenerator;
import com.jamesmurty.utils.XMLBuilder;

public class FarenheitToCelsiusMethod_Response_FromCode extends BasePageWebAPI {
	
	/*
	 * SOAP response built from Java code
	 */
	
	public FarenheitToCelsiusMethod_Response_FromCode() {
		setRoot("FahrenheitToCelsiusResponse");
	}
	
	/**
	 * @return Generate SOAP response in String format
	 */
	public String getMessage() {
		String message = "";
		try {
			SOAPMessage soapMessage = SoapMessageGenerator.createSOAPmessage(this.getRoot()
					.asString());
			message = SoapMessageGenerator.printSoapMessage(soapMessage);
		} catch (SOAPException | SAXException | IOException | ParserConfigurationException | TransformerException e) {
			new Exception(e);
		}
		return message;
	}
	
	/**
	 * @return Root XML structure
	 */
	public XMLBuilder getRoot() {
		return xmlBody;
	}
	
	// Set any nodes type under xml Root
	
	
	/**
	 * Set "FahrenheitToCelsiusResult" node under xml Root
	 * @param fahrenheit
	 * @return <FahrenheitToCelsius>
	 *         <FahrenheitToCelsiusResult>37.777</FahrenheitToCelsiusResult>
	 *         </FahrenheitToCelsius>
	 */
	public FarenheitToCelsiusMethod_Response_FromCode setFahrenheitToCelsiusResult(double value) {
		getRoot()
				.element("FahrenheitToCelsiusResult")
				.text(Double.toString(value));
		return this;
	}
	

	/**
	 * Set "Smth" node under xml Root
	 * @param fahrenheit
	 * @return <FahrenheitToCelsiusResponse>
	 *         <Smth>Hello</Smth>
	 *         </FahrenheitToCelsiusResponse>
	 */
	public FarenheitToCelsiusMethod_Response_FromCode setSmth(String Smth) {
		getRoot().element("Smth")
				.text(Smth);
		return this;
	}
	
	/*
	 * ----------------------------------
	 * Any handy actions after this point
	 * ----------------------------------
	 */
	private XMLBuilder xmlBody;
	
	private void setRoot(String nodeName) {
		try {
			this.xmlBody = XMLBuilder.create(nodeName);
		} catch (ParserConfigurationException | FactoryConfigurationError e) {
			new Exception(e);
		}
	}
}
