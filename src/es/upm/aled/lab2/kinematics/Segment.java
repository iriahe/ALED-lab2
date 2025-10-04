package es.upm.aled.lab2.kinematics;

import java.util.ArrayList;
import java.util.List;

// TODO: Implemente la clase
public class Segment {
	
	private double length;
	private double angle;
	private List<Segment> children;
	
	public Segment(double length, double angle) {
		this.length = length;
		this.angle = angle;
		this.children = new ArrayList<>();
	}
	
	/**
	 * Returns the length of the segment.
	 * 
	 * @return The length.
	 */
	public double getLength() {
		return this.length;
	}
	
	/**
	 * Returns the angle of the segment.
	 * 
	 * @return The angle.
	 */
	public double getAngle() {
		return this.angle;
	}
	/**
	 * Sets the value of the angle.
	 * 
	 * @param new angle value.
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	/**
	 * Returns the children.
	 * 
	 * @return A List of all the children.
	 */
	public List<Segment> getChildren(){
		return this.children;
	}
	
	/**
	 * Adds a new child to the List of children. Each child can
	 * only appear as once.
	 * 
	 * @param child to be added.
	 */
	public void addChild(Segment child) {
		if(!children.contains(child)) {
			this.children.add(child);
		}
		
	}
	
	
	
	
	
	
}
