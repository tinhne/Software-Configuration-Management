package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.Color;

public class QLSVView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioiTinh;
	public JComboBox<String> comboBox_queQuan;
	public JRadioButton radioButton_nam;
	public JRadioButton radioButton_nu;
	public JComboBox<String> comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 751);

		Action action = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(44, 144, -28, -35);
		contentPane.add(verticalBox_1);

		JLabel label_QueQuan = new JLabel("Qu\u00EA qu\u00E1n");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan.setBounds(31, 11, 92, 54);
		contentPane.add(label_QueQuan);

		JLabel label_maThiSinh = new JLabel("M\u00E3 th\u00ED sinh");
		label_maThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_maThiSinh.setBounds(285, 11, 155, 54);
		contentPane.add(label_maThiSinh);

		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaThiSinh_TimKiem.setColumns(10);
		textField_MaThiSinh_TimKiem.setBounds(393, 12, 123, 54);
		contentPane.add(textField_MaThiSinh_TimKiem);

		JButton btnTim = new JButton("T\u00ECm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTim.setBounds(526, 12, 89, 54);
		contentPane.add(btnTim);

		comboBox_queQuan_timKiem = new JComboBox<String>();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
		}
		comboBox_queQuan_timKiem.setBounds(120, 11, 155, 54);
		contentPane.add(comboBox_queQuan_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 92, 738, 2);
		contentPane.add(separator_1);

		JLabel label_QueQuan_2 = new JLabel("Danh s\u00E1ch th\u00ED sinh");
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan_2.setBounds(10, 97, 251, 54);
		contentPane.add(label_QueQuan_2);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));

		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 738, 214);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 369, 738, 2);
		contentPane.add(separator_1_1);

		JLabel label_QueQuan_1 = new JLabel("Th\u00F4ng tin th\u00ED sinh");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_QueQuan_1.setBounds(10, 369, 233, 54);
		contentPane.add(label_QueQuan_1);

		JLabel label_ID = new JLabel("M\u00E3 th\u00ED sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID.setBounds(10, 412, 102, 54);
		contentPane.add(label_ID);

		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(127, 425, 166, 29);
		contentPane.add(textField_ID);

		JLabel label_HoVaTen = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HoVaTen.setBounds(10, 457, 102, 54);
		contentPane.add(label_HoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(127, 470, 166, 29);
		contentPane.add(textField_HoVaTen);

		JLabel label_HoVaTen_1 = new JLabel("Qu\u00EA qu\u00E1n");
		label_HoVaTen_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HoVaTen_1.setBounds(10, 510, 102, 54);
		contentPane.add(label_HoVaTen_1);

		comboBox_queQuan = new JComboBox<String>();
		comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}

		comboBox_queQuan.setBounds(127, 522, 166, 35);
		contentPane.add(comboBox_queQuan);

		JLabel label_NgaySinh = new JLabel("Ng\u00E0y sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_NgaySinh.setBounds(10, 563, 155, 54);
		contentPane.add(label_NgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(127, 576, 166, 29);
		contentPane.add(textField_NgaySinh);

		JLabel label_ID_1 = new JLabel("Gi\u1EDBi t\u00EDnh");
		label_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID_1.setBounds(324, 412, 102, 54);
		contentPane.add(label_ID_1);

		radioButton_nam = new JRadioButton("Nam");
		radioButton_nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nam.setBounds(405, 429, 61, 23);
		contentPane.add(radioButton_nam);

		radioButton_nu = new JRadioButton("Nữ");
		radioButton_nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_nu.setBounds(489, 429, 61, 23);
		contentPane.add(radioButton_nu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_nam);
		btn_gioiTinh.add(radioButton_nu);

		JLabel label_HoVaTen_2 = new JLabel("M\u00F4n 1");
		label_HoVaTen_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HoVaTen_2.setBounds(324, 473, 52, 23);
		contentPane.add(label_HoVaTen_2);

		textField_Mon1 = new JTextField();
		textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(405, 470, 166, 29);
		contentPane.add(textField_Mon1);

		JLabel label_HoVaTen_2_1 = new JLabel("M\u00F4n 2");
		label_HoVaTen_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HoVaTen_2_1.setBounds(324, 513, 52, 23);
		contentPane.add(label_HoVaTen_2_1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(405, 510, 166, 29);
		contentPane.add(textField_Mon2);

		JLabel label_Mon3 = new JLabel("M\u00F4n 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Mon3.setBounds(324, 557, 52, 23);
		contentPane.add(label_Mon3);

		textField_Mon3 = new JTextField();
		textField_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(405, 554, 166, 29);
		contentPane.add(textField_Mon3);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(31, 628, 89, 42);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(151, 628, 89, 42);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(264, 628, 135, 42);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(421, 628, 135, 42);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("H\u1EE7y b\u1ECF");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(585, 628, 135, 42);
		contentPane.add(btnHuyBo);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(15, 628, 733, -22);
		contentPane.add(separator_2);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 616, 738, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTim.setBounds(631, 11, 117, 54);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	@SuppressWarnings("deprecation")
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "", });
	}

	@SuppressWarnings("deprecation")
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt(ts.isGioiTinh() ? "Nam" : "Nữ", i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		@SuppressWarnings("deprecation")
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();

		this.textField_ID.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText(ts.getTenThiSinh() + "");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		@SuppressWarnings("deprecation")
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			radioButton_nam.setSelected(true);
		} else {
			radioButton_nu.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1() + "");
		this.textField_Mon2.setText(ts.getDiemMon2() + "");
		this.textField_Mon3.setText(ts.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void thucHienThemThiSinh() {
		// Get du lieu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		@SuppressWarnings("deprecation")
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;
		if (this.radioButton_nam.isSelected()) {
			gioiTinh = true;
		} else if (this.radioButton_nu.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		
		// Thuc hien tim kiem
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoải khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
}
