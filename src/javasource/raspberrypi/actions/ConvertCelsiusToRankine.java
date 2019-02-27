// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package raspberrypi.actions;

import java.math.BigDecimal;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.pi4j.temperature.TemperatureConversion;
import com.pi4j.temperature.TemperatureScale;

public class ConvertCelsiusToRankine extends CustomJavaAction<java.math.BigDecimal>
{
	private java.math.BigDecimal Input;

	public ConvertCelsiusToRankine(IContext context, java.math.BigDecimal Input)
	{
		super(context);
		this.Input = Input;
	}

	@Override
	public java.math.BigDecimal executeAction() throws Exception
	{
		// BEGIN USER CODE
		final double output = TemperatureConversion.convertFromCelsius(TemperatureScale.RANKINE, this.Input.doubleValue());
		return new BigDecimal(output);
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "ConvertCelsiusToRankine";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
