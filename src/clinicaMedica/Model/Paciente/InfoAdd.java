/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicaMedica.Model.Paciente;

import static clinicaMedica.Model.Medico.MenuMedico.FormataResposta;
import java.util.Scanner;

/**
 * Classe que representa informações adicionais de saúde de um paciente,
 * como hábitos, doenças, cirurgias e observações.
 */
public class InfoAdd {
	
    /** Indica se o paciente fuma */
    private boolean fuma;
    /** Indica se o paciente bebe */
    private boolean bebe;
    /** Indica se o paciente possui colesterol alto */
    private boolean colesterol;
    /** Indica se o paciente tem diabetes */
    private boolean diabetes;
    /** Indica se o paciente possui doenças cardíacas */
    private boolean doencaCardiaca;
    /** Descrição de cirurgias realizadas */
    private String cirurgias;
    /** Descrição de alergias do paciente */
    private String alergia;
    /** Observações adicionais sobre o paciente */
    private String obsAdicionais;
	
    /**
     * Construtor que inicializa todas as informações adicionais de saúde.
     * @param fuma indica se o paciente fuma
     * @param bebe indica se o paciente bebe
     * @param colesterol indica se possui colesterol alto
     * @param diabetes indica se possui diabetes
     * @param doencaCardiaca indica se possui doença cardíaca
     * @param cirurgias lista ou descrição de cirurgias realizadas
     * @param alergia lista ou descrição de alergias
     * @param obsAdicionais observações gerais
     */
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

    /**
     * Construtor padrão (vazio).
     */
    InfoAdd() { }

    /** @return true se o paciente fuma */
    public boolean getFuma() { return fuma; }

    /** @param fuma define se o paciente fuma */
    public void setFuma(boolean fuma) { this.fuma = fuma; }

    /** @return true se o paciente bebe */
    public boolean getBebe() { return bebe; }

    /** @param bebe define se o paciente bebe */
    public void setBebe(boolean bebe) { this.bebe = bebe; }

    /** @return true se possui colesterol alto */
    public boolean isColesterol() { return colesterol; }

    /** @param colesterol define se possui colesterol alto */
    public void setColesterol(boolean colesterol) { this.colesterol = colesterol; }

    /** @return true se o paciente tem diabetes */
    public boolean isDiabetes() { return diabetes; }

    /** @param diabetes define se o paciente tem diabetes */
    public void setDiabetes(boolean diabetes) { this.diabetes = diabetes; }

    /** @return true se o paciente possui doenças cardíacas */
    public boolean isDoencaCardiaca() { return doencaCardiaca; }

    /** @param doencaCardiaca define se possui doenças cardíacas */
    public void setDoencaCardiaca(boolean doencaCardiaca) { this.doencaCardiaca = doencaCardiaca; }

    /** @return descrição de cirurgias */
    public String getCirurgias() { return cirurgias; }

    /** @param cirurgias define as cirurgias realizadas */
    public void setCirurgias(String cirurgias) { this.cirurgias = cirurgias; }

    /** @return descrição de alergias */
    public String getAlergia() { return alergia; }

    /** @param alergia define as alergias do paciente */
    public void setAlergia(String alergia) { this.alergia = alergia; }

    /** @return observações adicionais */
    public String getObsAdicionais() { return obsAdicionais; }

    /** @param obsAdicionais define observações adicionais */
    public void setObsAdicionais(String obsAdicionais) { this.obsAdicionais = obsAdicionais; }

    /**
     * Retorna todas as informações adicionais formatadas em texto.
     * @return string com informações adicionais do paciente
     */
    public String toString() {
        return "\n ---------------------" +
                "\n--- Informações adicionais ---" +
                "\n---------------------" + 
                "\nFuma ? " + fuma + 
                "\nBebe ? " + bebe + 
                "\nColesterol Alto ? " + colesterol + 
                "\nDiabete? " + diabetes +
                "\nDoenças Cardíacas? " + doencaCardiaca + 
                "\nCirurgias ? Se sim, cite quais. \n" + cirurgias + 
                "\nAlergias ? Se sim, cite quais. \n" + alergia + 
                "\nAlguma observação adicional ? \n" + obsAdicionais + 
                "\n---------------------" + 
                "\n--- Fim das Informações adicionais ---" +
                "\n---------------------\n";
    }

    /**
     * Cadastra informações adicionais para um paciente existente.
     * @param entrada scanner para entrada de dados
     * @param repositorio repositório de pacientes
     */
    public static void cadastrar(Scanner entrada, PacienteRepository repositorio) {
        System.out.println("Digite o CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorio.buscarPorCpf(cpf);
        if (paciente == null) {
            System.out.println("Paciente não encontrado!");
            return;
        }

        System.out.println("Paciente fuma? [sim/nao]");
        boolean fuma = FormataResposta(entrada.nextLine());
        System.out.println("Paciente bebe? [sim/nao]");
        boolean bebe = FormataResposta(entrada.nextLine());
        System.out.println("Tem colesterol alto? [sim/nao]");
        boolean colesterol = FormataResposta(entrada.nextLine());
        System.out.println("Tem diabete? [sim/nao]");
        boolean diabetes = FormataResposta(entrada.nextLine());
        System.out.println("Doença cardíaca? [sim/nao]");
        boolean doencaCardiaca = FormataResposta(entrada.nextLine());
        System.out.println("Cirurgias (se houver): ");
        String cirurgias = entrada.nextLine();
        System.out.println("Alergias (se houver): ");
        String alergia = entrada.nextLine();
        System.out.println("Observações adicionais: ");
        String obs = entrada.nextLine();

        InfoAdd info = new InfoAdd(fuma, bebe, colesterol, diabetes, doencaCardiaca, cirurgias, alergia, obs);
        paciente.setInfoAdd(info);

        System.out.println("Informações adicionais cadastradas com sucesso!");
    }

    /**
     * Atualiza informações adicionais de um paciente existente.
     * @param entrada scanner para entrada de dados
     * @param repositorio repositório de pacientes
     */
    public static void atualizar(Scanner entrada, PacienteRepository repositorio) {
        System.out.println("Digite o CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorio.buscarPorCpf(cpf);
        if (paciente == null || paciente.getInfoAdd() == null) {
            System.out.println("Paciente não encontrado ou não possui informações adicionais!");
            return;
        }

        System.out.println("Atualizando informações...");
        cadastrar(entrada, repositorio);
    }

    /**
     * Remove as informações adicionais de um paciente.
     * @param entrada scanner para entrada de dados
     * @param repositorio repositório de pacientes
     */
    public static void remover(Scanner entrada, PacienteRepository repositorio) {
        System.out.println("Digite o CPF do paciente: ");
        String cpf = entrada.nextLine();

        Paciente paciente = repositorio.buscarPorCpf(cpf);
        if (paciente == null || paciente.getInfoAdd() == null) {
            System.out.println("Paciente não encontrado ou sem informações adicionais!");
            return;
        }

        paciente.setInfoAdd(null);
        System.out.println("Informações adicionais removidas!");
    }
}
