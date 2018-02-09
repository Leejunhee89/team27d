package service;

import java.util.ArrayList;

public class RapperDao {

	public static void main(String[] args) {
		
	}
	
	public ArrayList<String> selectRapperList() {
		ArrayList<String> list = new ArrayList<String>();
		Rapper rap = new Rapper();
		rap.getRapperId();
		rap.getRapperName();
		rap.getRapperAge();
		return list;
	}
}
