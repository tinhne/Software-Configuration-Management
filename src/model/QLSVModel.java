package model;

import java.util.ArrayList;

public class QLSVModel {
	private ArrayList<ThiSinh> dsThiSinh;
	private String tenFile;

	public QLSVModel() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
		this.tenFile="";
	}

	public QLSVModel(ArrayList<ThiSinh> dsThiSinh) { this.dsThiSinh = dsThiSinh; }

	public ArrayList<ThiSinh> getDsThiSinh() { return dsThiSinh; }

	public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) { this.dsThiSinh = dsThiSinh; }
	
	public void insert(ThiSinh thiSinh) { this.dsThiSinh.add(thiSinh); }
	
	public void delete(ThiSinh thiSinh) { this.dsThiSinh.remove(thiSinh); }
	
	public void update(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}

	public String getTenFile() { return tenFile; }

	public void setTenFile(String tenFile) { this.tenFile = tenFile; }

	public boolean kiemTraTonTai(ThiSinh ts) {
		for(ThiSinh thiSinh: dsThiSinh) {
			if(thiSinh.getMaThiSinh() == ts.getMaThiSinh())
				return true;
		}
		return false;
	}
}