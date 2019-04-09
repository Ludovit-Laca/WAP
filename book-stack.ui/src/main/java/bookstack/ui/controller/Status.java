package bookstack.ui.controller;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Status {

    DOLAR("Dolár"),
    LIBRA("Libra");
	
	@Enumerated(EnumType.STRING)
    private String label;

    private Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}