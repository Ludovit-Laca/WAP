package bookstack.ui.controller;

public enum Currency {
	DOLAR(1.127F),
	CZK(25.618F),
	LIBRA(0.863F);
	
	private Currency(float exchange) {
		this.exchange = exchange;
	}

	private float exchange;

	public float getExchange() {
		return exchange;
	}

	public void setExchange(float exchange) {
		this.exchange = exchange;
	}
}
