package Tree;

public interface BinaryTree<E> extends tree<E> {
	Position<E> left(Position<E>p) throws IllegalArgumentException;
	Position<E> right(Position<E>p) throws IllegalArgumentException;
	Position<E> sibling(Position<E>p) throws IllegalArgumentException;
	
}
