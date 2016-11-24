package designpatterns;

public abstract class Character {
	private WeaponBehavior weapon;
	
	public void setWeapon(WeaponBehavior weapon){
		this.weapon = weapon;
	}
	
	public void fight(){
		weapon.useWeapon();
	}
	
	public abstract void display();
}
