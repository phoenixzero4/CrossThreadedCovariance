/**
 *
 */
package february;

/** @author Phoenix 
 * lesson taken from Intoduction to Java Programming 
 * 10th edition Daniel Liang **/

public class BST<T extends Comparable<T>> extends AbstractTree<T> {

	protected TreeNode<T> root;
	protected int size = 0;

	public BST() {

	}

	public BST(T[] objects) {
		for (T object : objects) {
			insert(object);
		}
	}

	@Override
	public boolean search(T t) {
		TreeNode<T> current = root;

		while (current != null) {
			if (t.compareTo(current.element) > 0) {
				current = current.left;
			} else if (t.compareTo(current.element) < 0) {
				current = current.right;
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insert(T t) {
		if (root == null) {
			root = createNewNode(t);
		} else {
			TreeNode<T> parent = null;
			TreeNode<T> current = root;

			while (current != null) {
				if (t.compareTo(current.element) < 0) {
					parent = current;
					current = current.left;
				} else if (t.compareTo(current.element) > 0) {
					parent = current;
					current = current.right;
				} else
					return false;

			}
			// node is null so we insert here
			if (t.compareTo(parent.element) < 0) {
				parent.left = createNewNode(t);
			} else {
				parent.right = createNewNode(t);
			}
		}
		size++;
		return true;

	}

	protected TreeNode<T> createNewNode(T t) {
		return new TreeNode<>(t);
	}

	@Override
	public void inorder() {
		inorder(root);
	}

	protected void inorder(TreeNode<T> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.element + "\n");
		inorder(root.right);
	}

	@Override
	public void preorder() {
		preorder(root);
	}

	protected void preorder(TreeNode<T> root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	@Override
	public void postorder() {
		postorder(root);
	}

	protected void postorder(TreeNode<T> root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	public static class TreeNode<T extends Comparable<T>> {
		protected T element;
		protected TreeNode<T> left;
		protected TreeNode<T> right;

		public TreeNode(T t) {
			element = t;
		}
	}

	@Override
	public int getSize() {
		return size;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public java.util.ArrayList<TreeNode<T>> path(T t) {

		java.util.ArrayList<TreeNode<T>> list = new java.util.ArrayList<>();
		TreeNode<T> current = root;

		while (current != null) {
			list.add(current);
			if (t.compareTo(current.element) < 0) {
				current = current.left;
			} else if (t.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}
		return list;
	}

	@Override
	public boolean delete(T t) {
		TreeNode<T> parent = null;
		TreeNode<T> current = root;

		while (current != null) {
			if (t.compareTo(current.element) < 0) {
				parent = current;
				current = current.left;
			} else if (t.compareTo(current.element) > 0) {
				parent = current;
				current = current.right;
			} else
				break;
		}

		if (current == null) {
			return false;
		}

		if (current.left == null) {
			if (parent == null) {
				root = current.right;
			} else {
				if (t.compareTo(parent.element) < 0) {
					parent.left = current.right;
				} else {
					// have to convince myself of this
					parent.right = current.right;
				}
			}
		} else {
			TreeNode<T> parentOfRightMost = current;
			TreeNode<T> rightMost = current.left;

			while (rightMost.right != null) {
				parentOfRightMost = rightMost;
				rightMost = rightMost.right;
			}
			current.element = rightMost.element;

			if (parentOfRightMost.right == rightMost) {
				parentOfRightMost.right = rightMost.left;
			} else {
				// when parent of rightMost == current
				parentOfRightMost.left = rightMost.left;
			}
		}

		size--;
		return true;
	}

//TODO finish printTree method
	public void printTree() {
		java.util.ArrayList<T> list = new java.util.ArrayList<>();
		TreeNode<T> current = root;

		while (current != null) {
			list.add(current.element);
			current = current.left;
			current = current.right;
		}
		

	}

	@Override
	public java.util.Iterator<T> iterator() {
		return new InorderIterator();
	}

	private class InorderIterator implements java.util.Iterator<T> {
		private java.util.ArrayList<T> list = new java.util.ArrayList<>();

		private int current = 0;

		public InorderIterator() {
			inorder();
		}

		private void inorder() {
			inorder(root);
		}

		private void inorder(TreeNode<T> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		@Override
		public boolean hasNext() {
			if (current < list.size())
				return true;
			return false;
		}

		@Override
		public T next() {
			return list.get(current++);
		}

		@Override
		public void remove() {
			delete(list.get(current));
			list.clear();
			inorder();
		}
	}

	public void clear() {
		root = null;
		size = 0;
	}
}
