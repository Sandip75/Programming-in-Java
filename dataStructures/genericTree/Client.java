package dataStructures.genericTree;

public class Client {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 130,
				-1, -1, -1 };

		GenericTreeH gt = new GenericTreeH(arr);

		int[] arr2 = { 1000, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, 130,
				-1, -1, -1 };

		GenericTreeH gt2 = new GenericTreeH(arr2);
		gt.display();
		// System.out.println(gt.size2());
		// System.out.println(gt.max());
		// System.out.println(gt.height());
		// System.out.println(gt.find(1000));
		// System.out.println(gt.nodeToRootPath(120));
		// gt.display();
		System.out.println("-------------");
		// gt.removeAllLeaf();
		// gt.mirrorImage();
		// gt.Linearize();
		// gt.Linearize2();
		// gt.display();
		// System.out.println(gt.areSimilarShaped(gt, gt2));
		// System.out.println(gt.areMirrorImage(gt, gt2));

		// System.out.println(gt.isSymmetric());
		// gt.multiSolver();
		gt.display();
		gt.multiSolve2(110);
		// gt.multiSolve3(70);
		gt.multiSolve4(110);
		gt.levelOrder();
		gt.levelOrderLineWise();
		System.out.println("<<<<----------->>>>");
		// gt.levelOrderLineWise2();
		gt.levelOrderZigZag();
	}

}
