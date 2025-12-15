# Instalação e Execução do Sistema - Clínica Médica

## Requisitos

- **Java JDK 17** ou superior
- **NetBeans IDE** (ou qualquer IDE que suporte projetos Ant)
- **Apache Derby 10.14.2.0** (ou superior)

## Passos para Executar no Computador do Professor

### 1. Clonar o Repositório

```bash
git clone <URL_DO_REPOSITORIO>
cd POO-clinica-medica
```

### 2. Configurar o Banco de Dados Derby

**Opção A: Usar Derby Network Server (Recomendado)**

1. Baixe o Apache Derby: https://db.apache.org/derby/derby_downloads.html
2. Extraia o Derby em um diretório (ex: `~/derby`)
3. Inicie o servidor:

```bash
export JAVA_HOME=$(/usr/libexec/java_home)  # macOS/Linux
cd ~/derby/bin
./startNetworkServer &
```

**Opção B: Usar Derby Embedded (Mais Simples)**

O Derby Embedded já está incluído nas bibliotecas do projeto. Basta executar o projeto.

### 3. Verificar Bibliotecas

As bibliotecas necessárias já estão incluídas em `lib/`:
- Hibernate 5.5.9
- JPA 2.2
- Derby Client
- Outras dependências

### 4. Abrir o Projeto no NetBeans

1. Abra o NetBeans
2. File → Open Project
3. Selecione a pasta `POO-clinica-medica`
4. Clique em "Open Project"

### 5. Executar o Projeto

**Via NetBeans:**
- Clique com botão direito no projeto
- Selecione "Run" (ou pressione F6)

**Via Terminal:**
```bash
ant run
```

## Estrutura do Banco de Dados

O sistema criará automaticamente as seguintes tabelas:
- `tb_paciente`
- `tb_consulta`
- `tb_prontuario`
- `tb_endereco`
- `tb_contato`
- `tb_info_add`
- `tb_doutor`

## Troubleshooting

### Erro: "Connection refused"
- Certifique-se de que o Derby Server está rodando
- Verifique o `persistence.xml` - a URL deve ser `jdbc:derby://localhost:1527/clinica_medica`

### Erro: "Class not found"
- Verifique se todas as bibliotecas em `lib/` estão no classpath
- No NetBeans: Project Properties → Libraries → Add JAR/Folder

### Erro: "Entity not mapped"
- Execute "Clean and Build" no NetBeans
- Verifique se `persistence.xml` lista todas as entidades

## Funcionalidades Implementadas

- ✅ Cadastro, atualização e remoção de pacientes
- ✅ Gerenciamento de consultas (normal e retorno)
- ✅ Cadastro e atualização de prontuários
- ✅ Envio de lembretes de consulta (email/SMS simulado)
- ✅ Relatórios de consultas
- ✅ Persistência com JPA/Hibernate
- ✅ Interface gráfica Swing

## Contato

Em caso de dúvidas, consulte a documentação JavaDoc em `docs/index.html` (gerar com `javadoc`).
