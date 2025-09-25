package es.upm.aled.lab2.gui;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing one node in the GUI that paints the exoskeleton bones on
 * the screen. Each node is identified by its absolute coordinates (remember
 * that in screen space, positive Y points down). Every Node has a List of their
 * children Nodes; those it's connected to.
 * 
 * @author rgarciacarmona
 */
public class Node {
	private double x, y;
	private List<Node> children;

	/**
	 * Builds a new Node from its absolute position.
	 * 
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 */
	public Node(double x, double y) {
		this.x = x;
		this.y = y;
		this.children = new ArrayList<>();
	}

	/**
	 * Returns the X coordinate.
	 * 
	 * @return The X coordinate.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the X coordinate.
	 * 
	 * @return The X coordinate.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Returns the Nodes this one is connected to. The children Nodes don't have a
	 * reference to the parent Node, so the connection is one-way.
	 * 
	 * @return A List of all the children Nodes.
	 */
	public List<Node> getChildren() {
		return children;
	}

	/**
	 * Adds a new Node to the List of Nodes this one is connected to. Each Node can
	 * only appear as a child once.
	 * 
	 * @param measurement The Node to be added.
	 */
	public void addChild(Node child) {
		if (!children.contains(child))
			children.add(child);
	}

}
