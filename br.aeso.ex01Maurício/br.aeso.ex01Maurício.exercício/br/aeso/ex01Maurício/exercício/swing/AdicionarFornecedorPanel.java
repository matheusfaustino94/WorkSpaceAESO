package br.aeso.ex01Maurício.exercício.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;

import br.aeso.ex01Maurício.exercício.exceptions.projetoException;
import br.aeso.ex01Maurício.exercício.fachada.Fachada;
import br.aeso.ex01Maurício.exercício.modelo.Endereço;
import br.aeso.ex01Maurício.exercício.modelo.Fornecedor;

@SuppressWarnings("serial")
public class AdicionarFornecedorPanel extends JPanel {
	private JButton btnAdicionar;
	private JButton btnLimpar;
	private JFormattedTextField cpfFornecedor;
	private JFormattedTextField bancoFornecedor;
	private JFormattedTextField nomeFornecedor;
	private JFormattedTextField ruaFornecedor;
	private JFormattedTextField complementoFornecedor;
	private JFormattedTextField cidadeFornecedor;
	private JFormattedTextField bairroFornecedor;
	private JFormattedTextField numeroFornecedor;
	private JFormattedTextField cepFornecedor;

	/**
	 * Create the panel.
	 * 
	 * @param btnLimpar
	 * @param btnAdicionar
	 * @param cpfCliente
	 */
	public AdicionarFornecedorPanel() {
		setLayout(null);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(250, 59, 46, 23);
		add(lblCPF);

		cpfFornecedor = new JFormattedTextField();
		cpfFornecedor.setBounds(296, 59, 150, 23);
		MaskFormatter mf;
		try {
			mf = new MaskFormatter("###.###.###-##");
			mf.install(cpfFornecedor);
			add(cpfFornecedor);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(26, 25, 46, 23);
		add(lblNome);

		nomeFornecedor = new JFormattedTextField();
		nomeFornecedor.setBounds(72, 25, 374, 23);
		add(nomeFornecedor);

		JLabel lblBanco = new JLabel("Banco:");
		lblBanco.setBounds(36, 59, 46, 23);
		add(lblBanco);

		bancoFornecedor = new JFormattedTextField();
		bancoFornecedor.setBounds(82, 59, 144, 23);
		add(bancoFornecedor);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(269, 117, 61, 14);
		add(lblEndereo);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(26, 157, 61, 14);
		add(lblRua);

		ruaFornecedor = new JFormattedTextField();
		ruaFornecedor.setBounds(113, 153, 150, 23);
		add(ruaFornecedor);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(26, 215, 89, 14);
		add(lblComplemento);

		complementoFornecedor = new JFormattedTextField();
		complementoFornecedor.setBounds(113, 211, 150, 23);
		add(complementoFornecedor);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(282, 186, 61, 14);
		add(lblBairro);

		bairroFornecedor = new JFormattedTextField();
		bairroFornecedor.setBounds(369, 182, 150, 23);
		add(bairroFornecedor);

		JLabel labelNumero = new JLabel("Numero:");
		labelNumero.setBounds(26, 186, 61, 14);
		add(labelNumero);

		numeroFornecedor = new JFormattedTextField();
		numeroFornecedor.setBounds(113, 182, 150, 23);
		add(numeroFornecedor);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(282, 157, 61, 14);
		add(lblCidade);

		cidadeFornecedor = new JFormattedTextField();
		cidadeFornecedor.setBounds(369, 153, 150, 23);
		add(cidadeFornecedor);

		JLabel labelCep = new JLabel("CEP:");
		labelCep.setBounds(282, 215, 61, 14);
		add(labelCep);

		cepFornecedor = new JFormattedTextField();
		cepFornecedor.setBounds(369, 211, 150, 23);
		add(cepFornecedor);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cpf = cpfFornecedor.getText();
				cpf = cpf.replaceAll(" ", "");
				String nome = nomeFornecedor.getText();
				String banco = bancoFornecedor.getText();
				String rua = ruaFornecedor.getText();
				String numero = numeroFornecedor.getText();
				String complemento = complementoFornecedor.getText();
				String bairro = bairroFornecedor.getText();
				String cidade = cidadeFornecedor.getText();
				String cep = cepFornecedor.getText();

				Endereço endereco = new Endereço();
				endereco.setRua(rua);
				endereco.setNumero(numero);
				endereco.setComplemento(complemento);
				endereco.setBairro(bairro);
				endereco.setCidade(cidade);
				endereco.setCep(cep);

				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setCpf(cpf);
				fornecedor.setNome(nome);
				fornecedor.setBanco(banco);
				fornecedor.setEndereço(endereco);

				endereco.setFornecedor(fornecedor);

				Fachada fachada = Fachada.getInstance();
				try {
					fachada.cadastrarFornecedor(fornecedor);
					limparCampos();
					JOptionPane.showMessageDialog(null,
							"Fornecedor adicionado com sucesso!",
							"Adicionar Fornecedor",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (projetoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),
							"Adicionar Fornecedor", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdicionar.setBounds(140, 338, 89, 23);
		add(btnAdicionar);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		btnLimpar.setBounds(369, 338, 89, 23);
		add(btnLimpar);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				nomeFornecedor.requestFocus();
			}
		});
	}

	public void limparCampos() {
		cpfFornecedor.setText("");
		bancoFornecedor.setText("");
		nomeFornecedor.setText("");
		complementoFornecedor.setText("");
		ruaFornecedor.setText("");
		cidadeFornecedor.setText("");
		numeroFornecedor.setText("");
		bairroFornecedor.setText("");
		complementoFornecedor.setText("");
		cepFornecedor.setText("");

	}
}
