package com.yy.learn.Lab08;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SelectForm implements Serializable {

	private static final long serialVersionUID = 8977440317488630347L;

	final String KILOMETRE = "kilometres";
	final String MILES = "miles";
	
	private String UOM;
	private String inputValue;
	private String convertedValue;
	private String outputUOM;

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public String getConvertedValue() {
		if (isNullInput()) {
			return "Empty input or input Zero! Please input value.";
		}
		try {
			BigDecimal decimalInputValue = new BigDecimal(this.inputValue);
			if (this.UOM.equalsIgnoreCase(KILOMETRE)) {
				this.outputUOM = MILES;
				return kilometresToMiles(decimalInputValue).toString();
			}
			if (this.UOM.equalsIgnoreCase(MILES)) {
				this.outputUOM = KILOMETRE;
				return milesToKilometres(decimalInputValue).toString();
			}
		} catch (Exception e) {
			return "Convert Met Exception";
		}
		return "";
	}

	public void setConvertedValue(String convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	private boolean isNullInput() {
		if (this.inputValue == null || this.inputValue.equals("") || this.inputValue.equals("0")) {
			return true;
		}
		return false;
	}

	private BigDecimal milesToKilometres(BigDecimal miles) {
		BigDecimal m2k = new BigDecimal(1.609344);
		return miles.multiply(m2k);
	}

	private BigDecimal kilometresToMiles(BigDecimal kilometres) {
		BigDecimal k2m = new BigDecimal(0.62137);
		return kilometres.multiply(k2m);
	}

	public String getOutputUOM() {
		return outputUOM;
	}

	public void setOutputUOM(String outputUOM) {
		this.outputUOM = outputUOM;
	}
}
