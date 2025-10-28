/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica;

/**
 *
 * @author User
 */
public class InfoAdd {

	private boolean fuma;
	private boolean bebe;
	private boolean colesterol;
	private boolean diabetes;
	private boolean doencaCardiaca;
	private String cirurgias;
	private String alergia;
	private String obsAdicionais;
	
	
	
	
	
	public InfoAdd(boolean fuma, boolean bebe, boolean colesterol, boolean diabetes, boolean doencaCardiaca, String cirurgias, String alergia, String obsAdicionais) {
		
		this.fuma = fuma;
		this.bebe = bebe;
		this.colesterol = colesterol;
		this.diabetes = diabetes;
		this.doencaCardiaca = doencaCardiaca;
		this.cirurgias = cirurgias;
		this.alergia = alergia;
		this.obsAdicionais = obsAdicionais;
	
		
	}
	
	InfoAdd() {
		
		
	}
	
	public boolean getFuma() {
		return fuma;
	}
	
	
	public void setFuma(boolean fuma) {
		this.fuma = fuma;
	}
	
	public boolean getBebe() {
		return bebe;
	}
	
	public void setBebe(boolean bebe) {
		this.bebe = bebe;
	}

	public boolean isColesterol() {
		return colesterol;
	}

	public void setColesterol(boolean colesterol) {
		this.colesterol = colesterol;
	}

	public boolean isDiabetes() {
		return diabetes;
	}

	public void setDiabetes(boolean diabetes) {
		this.diabetes = diabetes;
	}

	public boolean isDoencaCardiaca() {
		return doencaCardiaca;
	}

	public void setDoencaCardiaca(boolean doencaCardiaca) {
		this.doencaCardiaca = doencaCardiaca;
	}

	public String getCirurgias() {
		return cirurgias;
	}

	public void setCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getObsAdicionais() {
		return obsAdicionais;
	}

	public void setObsAdicionais(String obsAdicionais) {
		this.obsAdicionais = obsAdicionais;
	}
	
	public String toString() {
		
		return "\n ---------------------" +
				"\n--- Informações adicionais ---" +
				"\n---------------------" + 
				"\nFuma ? " + fuma + 
				"\nBebe ? " + bebe + 
				"\nColesterol Alto ? " + colesterol + 
				"\nDabete? " + diabetes+
				"\nDoenças Cardiacas? " + doencaCardiaca + 
				"\nCirugias ? Se sim cite quais. \n" + cirurgias + 
				"\nAlergia ? Se sim cite quais. \n" + alergia + 
				"\nAlguma observação adicional ? \n" + obsAdicionais + 
				"\n---------------------" + 
				"\n--- Fim das Informações adicionais ---" +
				"\n---------------------\n";
	}
	


}