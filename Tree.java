/**
 *
 */
package february;

/*  @author Phoenix  */

public interface Tree<T> extends Iterable {

	public boolean search(T t);

	public boolean insert(T t);

	public boolean delete(T t);

	public void inorder();

	public void postorder();

	public void preorder();

	public int getSize();

	public boolean isEmpty();

}
