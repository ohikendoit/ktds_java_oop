package gas;

import java.util.ArrayList;
import java.util.List;

public class GasStation {

	private List<Fuel> fuelList;
	private int money;
		
	//생성자 생성 및 초기화
	public GasStation() {
		fuelList = new ArrayList<>();
		fuelList.add(new Fuel(FuelType.GASOLIN, 5_000));
		fuelList.add(new Fuel(FuelType.DIESEL, 3_000));
		fuelList.add(new Fuel(FuelType.LPG, 1_000));
		
		setMoney(1000000);
	}
	
	public List<Fuel> getFuelList() {
		return fuelList;
	}
	public void setFuelList(List<Fuel> fuelList) {
		this.fuelList = fuelList;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * 판매
	 * @param type 연료 종류 (gasoline, diesel, lpg)
	 * @param stock 판매량
	 */
	public boolean sell(FuelType type, int stock) {
		boolean result = false;
		
		// 1. type 연료가 stock 만큼 존재하는지 확인하다.
		if (checkStock(type, stock)) {
			result = true;
			
			// 1-2. 연료가 충분하다면 type 연료의 잔량을 stock 만큼 줄인다.
			// 1-2-1. type의 값이 gasoline이라면 gasoline 변수에서 stock을 줄인다.
			/*
			 * if (type.equals("gasoline")) { if (gasoline.getType().equals("gasoline")) {
			 * int fuelStock = gasoline.getStock(); fuelStock = fuelStock - stock;
			 * gasoline.setStock(fuelStock); } else if (diesel.getType().equals("gasoline"))
			 * { int fuelStock = diesel.getStock(); fuelStock = fuelStock - stock;
			 * diesel.setStock(fuelStock); } else if (lpg.getType().equals("gasoline")) {
			 * int fuelStock = lpg.getStock(); fuelStock = fuelStock - stock;
			 * lpg.setStock(fuelStock); } } else if (type.equals("diesel")) {
			 * 
			 * } else {
			 * 
			 * }
			 * 
			 */			// 1-2-2. type의 값이 diesel 이라면 diesel 변수에서 stock을 줄인다
			// 1-2-3. type의 값이 lpg 이라면 lpg 변수에서 stock을 줄인다
			for (Fuel fuel: fuelList) { //반복문을 통해 연료 체크
				if (fuel.getType() == type) {
					int fuelStock = fuel.getStock();
					fuelStock = fuelStock - stock;
					fuel.setStock(fuelStock);
				}
			}
			
		}
		
		// 1-1. 연료가 부족하다면 "연료가 부족합니다"를 출력하고 메소드를 종료한다.
		else {
			result = false;
			System.out.println("연료가 부족합니다");
		}
		
		return result;
	}
	
	/**
	 * 수입
	 * @param money 구매가격
	 */
	public void addMoney(int amount) {
		// 1. money 파라미터의 값을 인스턴스변수 money에 더한다
		this.money = this.money + money;
		// this.money += money;
		this.money += money;
	}
	
	/**
	 * type 연료가 stock 만큼 주유가능한지 확인
	 * @param type 연료종류
	 * @param stock 주유량
	 * @return 연료의 양이 stock 이상이면 true, 아니면 false
	 */
	private boolean checkStock(FuelType type, int stock) {
//		boolean result = false;
		
		for (Fuel fuel: fuelList) {
			if (fuel.getType() == type) {
				//result = fuel.getStock() >= stock;
				//break;
				return fuel.getStock() >= stock;
				
			}
		}
		
		return false;
	}
}
