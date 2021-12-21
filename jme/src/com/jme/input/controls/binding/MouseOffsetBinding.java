package com.jme.input.controls.binding;

import java.util.logging.Logger;

import com.jme.input.MouseInput;
import com.jme.input.controls.Binding;
import com.jme.input.controls.binding.MouseAxisBinding;
import com.jme.system.DisplaySystem;

/**
 * The offset mouse binding returns the offset of the mouse cursor from the
 * center of the screen on the given axis. The values returned are in percent: 0
 * means the MouseCursor is in the Center of the screen, 1 means 100% the
 * MouseCursor touches the screens edge.
 * 
 * @author Christoph Luder
 */
public class MouseOffsetBinding implements Binding {
	private static final long serialVersionUID = 1L;
	
	private Logger log = Logger.getLogger(MouseOffsetBinding.class.getName());
	private int width;
	private int heigth;
	private int axis;
	private boolean reverse;

	/**
	 * @param axis
	 *            MouseAxisBinding.AXIS_X or AXIS_Y
	 * @param reverse
	 *            true means only track the right/lower part of the screen
	 */
	public MouseOffsetBinding(int axis, boolean reverse) {
		this.axis = axis;
		this.reverse = reverse;
		width = DisplaySystem.getDisplaySystem().getWidth();
		heigth = DisplaySystem.getDisplaySystem().getHeight();
	}

	/**
	 * Returns the offset in percent from the center of the screen on a given
	 * Axis.
	 * 
	 * @return offset of the mouse pointer in % on the given axis. 0 means the
	 *         cursor is in the middle. 1 means 100% the mouse cursor is
	 *         touching the screens edge.
	 */
	public float getValue() {
		float current = 0;
		switch (axis) {
			case MouseAxisBinding.AXIS_X:
				current = MouseInput.get().getXAbsolute() - width / 2;
				return convert((100.0f / (width / 2)) * current);
			case MouseAxisBinding.AXIS_Y:
				current = MouseInput.get().getYAbsolute() - heigth / 2;
				return convert((100.0f / (heigth / 2)) * current);
			default:
				log.severe("unknown Axis");
				break;
		}

		return 0;
	}

	private float convert(float value) {
		if ((value < 0) && (!reverse)) {
			return 0.0f;
		} else if ((value > 0) && (reverse)) {
			return 0.0f;
		}
		return Math.abs((float) value * 0.01f);
	}

	public String getName() {
		return "OffsetMousebinding " + (axis == MouseAxisBinding.AXIS_X ? "X" : "Y");
	}

	public String toString() {
		return getName();
	}
}