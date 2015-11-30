package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.CustomPlayer;
import home.negocio.beans.Musica;

import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;

public class TelaPlayer extends JFrame {
	private TelaPlayer() {
	}

	private static TelaPlayer instance;
	private JPanel contentPane;
	private Musica mus = null;
	private CustomPlayer p = new CustomPlayer();
	private boolean funk = false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public static synchronized TelaPlayer getInstance() {
		if (instance == null) {
			instance = new TelaPlayer();
		}
		return instance;
	}

	public void setMus(Musica mus) {
		this.mus = mus;
	}

	public boolean getFunk() {
		return funk;
	}

	public void setFunk(boolean funk) {
		this.funk = funk;
	}

	public void rodar() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setResizable(false);
		setTitle("Player");
		setUndecorated(true);
		setBounds(100, 100, 301, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Player",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(67, 78, 84)));
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(new Color(0, 0, 255));
		setContentPane(contentPane);

		if (mus != null) {
			p.setPath(mus.getEndereco());
			p.play(-1);
		}
		JToggleButton tglbtnPlay = new JToggleButton("Play/Pause");
		tglbtnPlay.setSelectedIcon(new ImageIcon("Imagens\\PlayOF PauseOF.png"));
		tglbtnPlay.setIcon(new ImageIcon("Imagens\\PlayOF PauseOF.png"));
		tglbtnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlay.isSelected()) {
					p.pause();
				} else {
					p.resume();
				}
			}
		});
		tglbtnPlay.setBounds(108, 74, 89, 102);
		contentPane.add(tglbtnPlay);

		JButton btnPrevious = new JButton(" ");
		btnPrevious.setBounds(6, 74, 89, 102);
		btnPrevious.setIcon(new ImageIcon("Imagens\\PreviousOF.png"));
		contentPane.add(btnPrevious);

		JButton btnNext = new JButton(" ");
		btnNext.setBounds(204, 74, 90, 102);
		btnNext.setIcon(new ImageIcon("Imagens\\NextOF.png"));
		contentPane.add(btnNext);

		JButton btnFechar = new JButton("");
		btnFechar.setBounds(6, 18, 288, 44);
		btnFechar.setBackground(new Color(139, 0, 0));
		btnFechar.setIcon(new ImageIcon("Imagens\\Close1.png"));
		btnFechar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				p.getPlayer().close();
				funk = false;
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnFechar);
	}

	public void fechar() {
		dispose();
		p.getPlayer().close();
	}

}
