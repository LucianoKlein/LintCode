package util.treehelper;

import org.junit.Test;
import org.StructureGraphic.v1.DSutils;
import org.StructureGraphic.v1.TreePrinter;
public class TestClass {
	private final int recWidth = 50;
	private final int recHeight = 50;
	@Test
	public void test() {
		Tree tree = new Tree("{3,9,20,#,#,15,7}");
		DSutils.show(tree.head, recWidth, recHeight);
		while(true);
	}
}
