/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhopoo;

/**
 *
 * @author User
 */
public class Paciente {


    private String nome;
    private String cpf;
    private String dataNascimento;
    private Endereco endereco;
    private Contato contato;
    private String convenio;
    private InfoAdd informacoesAdicionais;
    
    
    

    //TIPOS CONVENIO
    public enum tiposConvenios { PARTICULARES, PLANO_DE_SAUDE; }
    
    //Contrutor da classe paciente
    public Paciente(String nome, String cpf, String dataNascimento, Endereco endereco, Contato contato, String convenio, InfoAdd informacoesAdicionais ) {
        this.nome = nome;
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        this.endereco = endereco;
        this.contato = contato;
        this.convenio = convenio;
        setInfoAdd(informacoesAdicionais);
    }
    
    
    public Paciente() {
    	
    }
    
    /*
     * Sets e Gets
     * para todos parametros
     * da classe Paciente
     */
    
    
    public String getCpf() {
    	return cpf;
    }
    
    public void setCpf(String cpf) {
	    	String cpfFormatado = converterCpf(cpf);
	    	if (cpfFormatado != null) { this.cpf = cpfFormatado; } 
	    	else {
	    		this.cpf = null;
	    		System.out.println("Cpf invalido!, impossivel atribuir.");
	    	}   	
    }
    
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        String nascimentoFormatado = converterNascimento(dataNascimento);
        if(nascimentoFormatado != null) { 
        		this.dataNascimento = nascimentoFormatado; 
        	}
        else {
        		this.dataNascimento = null;
        		System.out.println("Nascimento invalido, impossivel atribuir! ");
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setNumeroCelular(String numeroCelular) {
        String numeroFormatado = converterTelefone(numeroCelular);
        if (numeroFormatado != null) {
        		this.contato.setCelular(numeroFormatado);
        }
        else {
        		this.contato.setCelular(null);
        		System.out.println("Telefone invalido, impossivel atribuir.");
        }
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }
    
    public void setInfoAdd(InfoAdd informacoesAdicionais) {
    		this.informacoesAdicionais = informacoesAdicionais;
    }
    
    public Contato getContato() {
    	return contato;
    }
    
    
    public void setContato(Contato contato) {
    	this.contato = contato;
    }
    
    public InfoAdd getInfoAdd() {
    		return informacoesAdicionais;
    }
    
    /*
     * Retorna o numero de telefone formatado
     * no padrao = [ '(xx) xxxxx-xxxx' ]
     */
    public String converterTelefone(String telefone) {
	    	if(telefone.length() < 11 || telefone.length() > 11) {
	    		return null;
	    	}
	    	return "(" + telefone.substring(0, 2) + ")" +
	    		" " + telefone.substring(2, 7) + "-" + 
	    		telefone.substring(7, 11);
    	
    }
    
    /*
     * Retorna a data de nascimento formatado
     * no padrao = [ 'dd/mm/yyyy' ]
     */
    public String converterNascimento(String nascimento) {
	    	if(nascimento.length() < 8 || nascimento.length() > 8) {
	    		return null;
	    	}
	    	return nascimento.substring(0, 2) + "/" + 
	    	 		nascimento.substring(2, 4) + "/" + 
	    	 		nascimento.substring(4, 8); 
    		
    	
    }
    
    /*
     * Retorna o cpf formatado
     * no padrao = [ 'xxx.xxx.xxx-xx' ]
     */
    public String converterCpf(String cpfInicial) {
	    	if (cpfInicial.length() < 11 || cpfInicial.length() > 11) {
	    		return null;
	    	}
	    	return cpfInicial.substring(0, 3) + "." +
	        		cpfInicial.substring(3, 6) + "." +
	        		cpfInicial.substring(6, 9) + "-" +
	        		cpfInicial.substring(9, 11);
    }
    
    /*
     * Metodo que retorna no formato String
     * os obejetos e tributos da classe Paciente
     */
    @Override
    public String toString() {
    	if (informacoesAdicionais != null) {
    		return "\n------- Pacientes -------\n" +
                    "\nNome = " + nome +
                    "\nCpf = "+ cpf +  
                    "\ndataNascimento = " + dataNascimento +
                    "\nendereco = " + endereco +
                    "\nnumeroCelular = " + contato.getCelular() +
                    "\nconvenio = " + convenio + 
                    "\nInformações adicioanais encontrada! " + 
                    "\n------- Fim -------\n" +
    				getInfoAdd().toString();
    		
    	}else {
        return "\n------- Pacientes -------\n" +
                "\nNome = " + nome +
                "\nCpf = "+ cpf +  
                "\ndataNascimento = " + dataNascimento +
                "\nendereco = " + endereco +
                "\nnumeroCelular = " + contato.getCelular() +
                "\nconvenio = " + convenio + 
                "\nInformações adicioanais nao encontrada! " + 
                "\n------- Fim -------\n";
        }
    }
}