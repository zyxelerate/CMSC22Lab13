package designpatterns;

public class CharacterTest {

	public static void main(String[] args) {
		Character k = new King();
		Character q = new Queen();
		Character kn = new Knight();
		Character t = new Troll();
		Character qt = new Queen(); //Queen with Axe

		k.setWeapon(new KnifeBehavior());
		q.setWeapon(new BowAndArrowBehavior());
		kn.setWeapon(new SwordBehavior());
		t.setWeapon(new AxeBehavior());
		qt.setWeapon(new AxeBehavior());
		
		k.fight();
		q.fight();
		kn.fight();
		t.fight();
		qt.fight();
	}

}
