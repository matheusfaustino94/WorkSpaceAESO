package br.aeso.ex01Maurício.exercício.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FornecedorTelaPrincipal {

	private JFrame frmFornecedor;
	private JMenu mnCliente;
	private JMenuItem mntmAdiciona;
	private JMenuItem mntmProcurar;
	private JMenuItem mntmRemover;
	private JMenuItem mntmAtualizar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorTelaPrincipal window = new FornecedorTelaPrincipal();
					window.frmFornecedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FornecedorTelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFornecedor = new JFrame();
		frmFornecedor.setTitle("Projeto - Fornecedor");
		frmFornecedor.setBounds(100, 100, 619, 452);
		frmFornecedor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmFornecedor.setJMenuBar(menuBar);

		mnCliente = new JMenu("Fornecedor");
		menuBar.add(mnCliente);

		mntmAdiciona = new JMenuItem("Cadastrar");
		mntmAdiciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AdicionarFornecedorPanel adicionarFornecedorPanel = new AdicionarFornecedorPanel();

				frmFornecedor.setContentPane(adicionarFornecedorPanel);
				frmFornecedor.getContentPane().revalidate();

			}
		});
		mnCliente.add(mntmAdiciona);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ListarFornecedoresPanel listarFornecedoresPanel = new ListarFornecedoresPanel();

				frmFornecedor.setContentPane(listarFornecedoresPanel);
				frmFornecedor.getContentPane().revalidate();
			}
		});

		mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtualizarFornecedorPanel atualizarFornecedoresPanel = new AtualizarFornecedorPanel();

				frmFornecedor.setContentPane(atualizarFornecedoresPanel);
				frmFornecedor.getContentPane().revalidate();
			}
		});
		mnCliente.add(mntmAtualizar);

		mntmRemover = new JMenuItem("Remover");
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoverFornecedorPanel removerFornecedoresPanel = new RemoverFornecedorPanel();

				frmFornecedor.setContentPane(removerFornecedoresPanel);
				frmFornecedor.getContentPane().revalidate();
			}
		});
		mnCliente.add(mntmRemover);

		mntmProcurar = new JMenuItem("Procurar");
		mntmProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ProcurarFornecedorPanel procurarFornecedoresPanel = new ProcurarFornecedorPanel();

				frmFornecedor.setContentPane(procurarFornecedoresPanel);
				frmFornecedor.getContentPane().revalidate();

			}
		});
		mnCliente.add(mntmProcurar);
		mnCliente.add(mntmListar);
	}

}