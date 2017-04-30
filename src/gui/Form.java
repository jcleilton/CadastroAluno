package gui;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dados.AlunoCadastro;

public class Form{

	private static boolean fezCursoUtd;
	private static String nomeAluno;
	private static String cpfAluno;
	private static String sexoAluno;
	private static String dataNasc;
	private static String estadoCivil;
	private static String endereco;
	private static String bairro;
	private static String cidade;
	private static String telefone;

	private static String curso;
	private static String turma;
	private static int quantosCursos;
	private static String quaisCursos;
	private static String quandoFez;

	public static void main(String[] args) {
		fezCursoUtd = true;


		//********************************************************
		//*******      Construção do formulário         **********

		JFrame frame = new JFrame("CADASTRO DE ALUNOS");
		frame.setSize(700,475);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.setResizable(false);

		JPanel panel = new JPanel(new GridBagLayout());

		JLabel labelDP = new JLabel("Dados Pessoais");
		labelDP.setFont(new Font("Arial", Font.BOLD,30));

		JLabel labelNome = new JLabel("Nome:");

		JTextField textFieldNome = new JTextField(27);

		JLabel labelCpf = new JLabel("CPF:");

		JTextField textFieldCpf = new JTextField(9);

		JLabel labelSexo = new JLabel("Sexo:");

		JComboBox<String> combSexo = new JComboBox<String>();
		combSexo.addItem("Masculino");
		combSexo.addItem("Feminino");
		combSexo.setEditable(false);
		combSexo.setSelectedIndex(0);

		JLabel labelDt = new JLabel("Data de Nascimento:");

		JTextField textFieldDt = new JTextField(9);

		JLabel labelEst = new JLabel("Estado civil:");

		JComboBox<String> combEst = new JComboBox<String>();
		combEst.addItem("Solteiro");
		combEst.addItem("Casado");
		combEst.addItem("Divorciado");
		combEst.setEditable(false);
		combEst.setSelectedIndex(0);


		JLabel labelEndereco = new JLabel("Endereço:");

		JTextField textFieldEndereco = new JTextField(27);

		JLabel labelBairro = new JLabel("Bairro:");

		JTextField textFieldBairro = new JTextField(9);

		JLabel labelCidade = new JLabel("Cidade:");

		JTextField textFieldCidade = new JTextField(9);

		JLabel labelTelefone = new JLabel("Telefone: ");

		JTextField textFieldTelefone = new JTextField(9);		

		JLabel labelDC = new JLabel("Dados do Curso");
		labelDC.setFont(new Font("Arial", Font.BOLD,30));

		JLabel labelCurso = new JLabel("Curso:");

		JTextField textFieldCurso = new JTextField(9);

		JLabel labelTurma = new JLabel("Turma:");

		JComboBox<String> combTurma = new JComboBox<String>();
		combTurma.addItem("Manhã");
		combTurma.addItem("Tarde");
		combTurma.setEditable(false);
		combTurma.setSelectedIndex(0);


		JLabel labelFezCurso = new JLabel("Se fez curso na UTD?: ");

		JTextField textFieldQuantos = new JTextField(3);

		JLabel labelQuantos = new JLabel("Quantos?: ");

		JTextField textFieldQual = new JTextField(9);

		JLabel labelQual = new JLabel("Qual?/Quais?: ");

		JTextField textFieldQuando = new JTextField(9);

		JLabel labelQuando = new JLabel("Quando?: ");


		JComboBox<String> combFezCurso = new JComboBox<String>();
		combFezCurso.addItem("Sim");
		combFezCurso.addItem("Não");
		combFezCurso.setEditable(false);
		combFezCurso.setSelectedIndex(0);
		combFezCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (combFezCurso.getSelectedItem()=="Não"){
					labelQuantos.setVisible(false);
					textFieldQuantos.setVisible(false);
					labelQual.setVisible(false);
					textFieldQual.setVisible(false);
					labelQuando.setVisible(false);
					textFieldQuando.setVisible(false);
					fezCursoUtd = false;
				} else {
					labelQuantos.setVisible(true);
					textFieldQuantos.setVisible(true);
					labelQual.setVisible(true);
					textFieldQual.setVisible(true);
					labelQuando.setVisible(true);
					textFieldQuando.setVisible(true);
					fezCursoUtd = true;
				}
			}
		});

		JButton button1 = new JButton("Cadastrar");
		button1.setBounds(100, 100, 400, 300);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeAluno = textFieldNome.getText();
				cpfAluno = textFieldCpf.getText();
				sexoAluno = combSexo.getSelectedItem().toString();
				dataNasc = textFieldDt.getText();
				estadoCivil = combEst.getSelectedItem().toString();
				endereco = textFieldEndereco.getText();
				bairro = textFieldBairro.getText();
				cidade = textFieldCidade.getText();
				telefone = textFieldTelefone.getText();
				curso = textFieldCurso.getText();
				turma = combTurma.getSelectedItem().toString();
				if (fezCursoUtd){
					try{
						quantosCursos = Integer.parseInt(textFieldQuantos.getText());
					}catch (Exception except){
						System.out.println(except);
						quantosCursos = -1;
					}
					quaisCursos = textFieldQual.getText();
					quandoFez = textFieldQuando.getText();
				}
				cadastrarAluno();
				frame.dispose();
				Form.main(args);
			}
		});

		JButton button2 = new JButton("Cancelar");
		button2.setBounds(200, 100, 400, 300);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário!", "Cancelar", 0);
				frame.dispose();
			}
		});

		JButton button3 = new JButton("Consultar");
		button3.setBounds(200, 100, 400, 300);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consultarAluno();
			}
		});

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2,2,2,2);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 3;
		c.gridy = 1;
		panel.add(labelDP,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 2;
		panel.add(labelNome,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 2;
		c.gridy = 2;
		panel.add(textFieldNome,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 3;
		panel.add(labelCpf,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 3;
		panel.add(textFieldCpf,c);

		c.gridx = 2;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 3;
		panel.add(labelSexo,c);

		c.gridx = 3;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 3;
		panel.add(combSexo,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 4;
		panel.add(labelDt,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;

		c.gridy = 4;
		panel.add(textFieldDt,c);

		c.gridx = 2;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 4;
		panel.add(labelEst,c);

		c.gridx = 3;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 4;
		panel.add(combEst,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 6;
		panel.add(labelEndereco,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 2;
		c.gridy = 6;
		panel.add(textFieldEndereco,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 7;
		panel.add(labelBairro,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 7;
		panel.add(textFieldBairro,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 8;
		panel.add(labelCidade,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 8;
		panel.add(textFieldCidade,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 9;
		panel.add(labelTelefone,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 9;
		panel.add(textFieldTelefone,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 3;
		c.gridy = 11;
		panel.add(labelDC,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 12;
		panel.add(labelCurso,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 12;
		panel.add(textFieldCurso,c);

		c.gridx = 2;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 12;
		panel.add(labelTurma,c);

		c.gridx = 3;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 12;
		panel.add(combTurma,c);

		c.gridx = 0;
		c.weightx = 0;
		c.gridwidth = 1;
		c.gridy = 13;
		panel.add(labelFezCurso,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 13;
		panel.add(combFezCurso,c);

		c.gridx = 2;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 13;
		panel.add(labelQuantos,c);

		c.gridx = 3;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 13;
		panel.add(textFieldQuantos,c);

		c.gridx = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 14;
		panel.add(labelQual,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 14;
		panel.add(textFieldQual,c);

		c.gridx = 2;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 14;
		panel.add(labelQuando,c);

		c.gridx = 3;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 14;
		panel.add(textFieldQuando,c);

		c.gridx = 1;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 15;
		panel.add(button1,c);

		c.gridx = 2;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 15;
		panel.add(button2,c);

		c.gridx = 3;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridy = 15;
		panel.add(button3,c);

		frame.setContentPane(panel);
		frame.setVisible(true);

		//********************************************************
		//*******      Fim da construção do formulário     *******
	}

	//***************************************************************************
	//*******      Métodos que implementam ações do botão 'Cadastrar'     *******

	public static void cadastrarAluno(){
		if (fezCursoUtd){
			if (quantosCursos <= 0){
				if (nomeAluno.equals("") || cpfAluno.equals("") || dataNasc.equals("") || endereco.equals("") || bairro.equals("") || cidade.equals("") || telefone.equals("") || curso.equals("")  || turma.equals("")){
					JOptionPane.showMessageDialog(null,"Erro na entrada dos dados, verifique se há algum campo em branco!","Erro:",1);

				} else {
					try{
						quantosCursos = Integer.parseInt(JOptionPane.showInputDialog("Erro na entrada de dados: Digite um número válido."));
					}catch (Exception e){
						System.out.println(e);
					}
					@SuppressWarnings("unused")
					dados.AlunoCadastro aluno = new dados.AlunoCadastro(fezCursoUtd, nomeAluno, cpfAluno, sexoAluno, dataNasc, estadoCivil, endereco, bairro, cidade, telefone, curso, turma, quantosCursos, quaisCursos, quandoFez);
					JOptionPane.showMessageDialog(null, "Aluno: "+ nomeAluno + ",\nCPF: "+cpfAluno+", \nSexo: "+sexoAluno+",\nData de Nascimento: "+dataNasc+",\nEstado Civil: "+estadoCivil+",\nEndereço: "+endereco+",\nBairro: "+bairro+",\nCidade: "+cidade+",\nTelefone: "+telefone+",\nCurso: "+curso+",\nTurma: "+turma+",\nCursos já realizados aqui: "+quaisCursos, "Cadastro realizado com sucesso.", 1);
				}
				
			}		
		} else if (quantosCursos <= 0){
			if (nomeAluno.equals("") || cpfAluno.equals("") || dataNasc.equals("") || endereco.equals("") || bairro.equals("") || cidade.equals("") || telefone.equals("") || curso.equals("")  || turma.equals("")){
				JOptionPane.showMessageDialog(null,"Erro na entrada dos dados, verifique se há algum campo em branco!","Erro:",1);

			} else {
				@SuppressWarnings("unused")
				dados.AlunoCadastro aluno = new dados.AlunoCadastro(fezCursoUtd, nomeAluno, cpfAluno, sexoAluno, dataNasc, estadoCivil, endereco, bairro, cidade, telefone, curso, turma, 0, "", "");
				JOptionPane.showMessageDialog(null, "Aluno: "+ nomeAluno + ",\nCPF: "+cpfAluno+", \nSexo: "+sexoAluno+",\nData de Nascimento: "+dataNasc+",\nEstado Civil: "+estadoCivil+",\nEndereço: "+endereco+",\nBairro: "+bairro+",\nCidade: "+cidade+",\nTelefone: "+telefone+",\nCurso: "+curso+",\nTurma: "+turma, "Cadastro realizado com sucesso.", 1);
			}
		}
	}

	public static void consultarAluno(){
		String cpfConsulta = JOptionPane.showInputDialog("Digite o cpf do aluno:");
		AlunoCadastro alunoConsulta = new AlunoCadastro().recuperaAluno(cpfConsulta);
		if (alunoConsulta == null){
			JOptionPane.showMessageDialog(null,"Aluno não cadastrado!","Erro:",1);
		} else {
			JOptionPane.showMessageDialog(null, "Aluno: "+ alunoConsulta.getNomeAluno() + ",\nCPF: "+alunoConsulta.getCpfAluno()+", \nSexo: "+alunoConsulta.getSexoAluno()+",\nData de Nascimento: "+alunoConsulta.getDataNasc()+",\nEstado Civil: "+alunoConsulta.getEstadoCivil()+",\nEndereço: "+alunoConsulta.getEndereco()+",\nBairro: "+alunoConsulta.getBairro()+",\nCidade: "+alunoConsulta.getCidade()+",\nTelefone: "+alunoConsulta.getTelefone()+",\nCurso: "+alunoConsulta.getCurso()+",\nTurno: "+alunoConsulta.getTurma()+",\nCursos já realizados aqui: "+alunoConsulta.getQuaisCursos(), "Aluno encontrado!", 1);
		}
	}

}