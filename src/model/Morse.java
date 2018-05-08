package model;

public class Morse {

	int id;
	String nimimerkki;
	String teksti;
	String morsekoodi;

	public Morse(int id, String nimimerkki, String teksti, String morsekoodi) {

		super();
		this.id = id;
		this.nimimerkki = nimimerkki;
		this.teksti = teksti;
		this.morsekoodi = morsekoodi;
	}

	public Morse() {

		super();
		id = 0;
		nimimerkki = "";
		teksti = "";
		morsekoodi = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimimerkki() {
		return nimimerkki;
	}

	public void setNimimerkki(String nimimerkki) {
		this.nimimerkki = nimimerkki;
	}

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	public String getMorsekoodi() {
		return morsekoodi;
	}

	public void setMorsekoodi(String morsekoodi) {
		this.morsekoodi = morsekoodi;
	}

	@Override
	public String toString() {
		return "Morse [id=" + id + ", nimimerkki=" + nimimerkki + ", teksti=" + teksti + ", morsekoodi=" + morsekoodi + "]";
	}

}
