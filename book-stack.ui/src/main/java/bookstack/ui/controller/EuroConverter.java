package bookstack.ui.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@ManagedBean(name="euroConverter")
@FacesConverter("euroConverter")
public class EuroConverter implements Converter {

	private double suma;
	private double novaSuma;
	
	//@Enumerated(EnumType.STRING)
	private Currency mena;
	
	public void spracuj() {
		switch(mena) {
			case DOLAR:
				novaSuma = suma * 1.127;
				break;
			case CZK:
				novaSuma = suma * 25.618;
				break;
			case LIBRA:
				novaSuma = suma * 0.863;
				break;
		}
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return Double.parseDouble(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString();
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public double getNovaSuma() {
		return novaSuma;
	}

	public void setNovaSuma(double novaSuma) {
		this.novaSuma = novaSuma;
	}

	public Currency getMena() {
		return mena;
	}

	public void setMena(Currency mena) {
		this.mena = mena;
	}
	
}
