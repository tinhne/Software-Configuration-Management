package controller;

import java.awt.event.ActionEvent;

import java.beans.PropertyChangeListener;
import javax.swing.Action;
import view.QLSVView;

public class QLSVController implements Action{
	public QLSVView view;
//	luyen tap commit
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
		}else if(cm.equals("Lưu")) {
			try {
				this.view.thucHienThemThiSinh();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(cm.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
		}else if(cm.equals("Xóa")) {
			this.view.thucHienXoa();
		}else if(cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		}else if(cm.equals("Tìm")) {
			this.view.thucHienTim();
		}else if(cm.equals("Hủy tìm")) {
			this.view.thucHienTaiLaiDuLieu();
		}else if(cm.equals("About Me")) {
			this.view.hienThiAbout();
		}else if(cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if(cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if(cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}