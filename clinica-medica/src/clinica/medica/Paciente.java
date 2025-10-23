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

    //INFO PACIENTES
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private String numeroCelular;
    private String convenio;
    private InfoAdd informacoesAdicionais;
    

    //TIPOS CONVENIO
    public enum tiposConvenios { PARTICULARES, PLANO_DE_SAUDE; }

    public Paciente(String nome, String cpf, String dataNascimento, String endereco, String numeroCelular, String convenio, InfoAdd informacoesAdicionais ) {
        this.nome = nome;
        setCpf(cpf);
        setDataNascimento(dataNascimento);
        this.endereco = endereco;
        setNumeroCelular(numeroCelular);
        this.convenio = convenio;
        setInfoAdd(informacoesAdicionais);
    }
    
    public Paciente() {
    	
    }
    
    public String getCpf() {
    	return cpf;
    }
    
    public void setCpf(String cpf) {
    	String cpfFormatado = converterCpf(cpf);
    	if (cpfFormatado != null) {
    		this.cpf = cpfFormatado; 		
    	}else {
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
        }else {
        	this.dataNascimento = null;
        	System.out.println("Nascimento invalido, impossivel atribuir! ");
        	
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        String numeroFormatado = converterTelefone(numeroCelular);
        if (numeroFormatado != null) {
        	this.numeroCelular = numeroFormatado;
        }else {
        	this.numeroCelular = null;
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
    
    
    public InfoAdd getInfoAdd() {
    	return informacoesAdicionais;
    }
    
    
    public String converterTelefone(String telefone) {
    	if(telefone.length() < 11 || telefone.length() > 11) {
    		return null;
    	}
    	return "(" + telefone.substring(0, 2) + ")" +
    		" " + telefone.substring(2, 7) + "-" + 
    		telefone.substring(7, 11);
    	
    }
    
    public String converterNascimento(String nascimento) {
    	if(nascimento.length() < 8 || nascimento.length() > 8) {
    		return null;
    	}
    	return nascimento.substring(0, 2) + "/" + 
    	 		nascimento.substring(2, 4) + "/" + 
    	 		nascimento.substring(4, 8); 
    		
    	
    }
    
    public String converterCpf(String cpfInicial) {
    	if (cpfInicial.length() < 11 || cpfInicial.length() > 11) {
    		
    		
    		return null;
    	}
    	return cpfInicial.substring(0, 3) + "." +
        		cpfInicial.substring(3, 6) + "." +
        		cpfInicial.substring(6, 9) + "-" +
        		cpfInicial.substring(9, 11);
    }
    
    @Override
    public String toString() {
    	if (informacoesAdicionais != null) {
    		return "\n------- Pacientes -------\n" +
                    "\nNome = " + nome +
                    "\nCpf = "+ cpf +  
                    "\ndataNascimento = " + dataNascimento +
                    "\nendereco = " + endereco +
                    "\nnumeroCelular = " + numeroCelular +
                    "\nconvenio = " + convenio + 
                    "\nInformações adicioanais nao encontrada! " + 
                    "\n------- Fim -------\n" +
    				getInfoAdd().toString();
    		
    	}else {
        return "\n------- Pacientes -------\n" +
                "\nNome = " + nome +
                "\nCpf = "+ cpf +  
                "\ndataNascimento = " + dataNascimento +
                "\nendereco = " + endereco +
                "\nnumeroCelular = " + numeroCelular +
                "\nconvenio = " + convenio + 
                "\nInformações adicioanais nao encontrada! " + 
                "\n------- Fim -------\n";
        }
    }

	
}