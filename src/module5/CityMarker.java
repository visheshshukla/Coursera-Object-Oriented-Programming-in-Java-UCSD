package module5;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PConstants;
import processing.core.PGraphics;

/** Implements a visual marker for cities on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Vishesh Shukla
 *
 */
// TODO: Change SimplePointMarker to CommonMarker as the very first thing you do 
// in module 5 (i.e. CityMarker extends CommonMarker).  It will cause an error.
// That's what's expected.
public class CityMarker extends CommonMarker {
	
	public static int TRI_SIZE = 5;  // The size of the triangle marker
	
	public CityMarker(Location location) {
		super(location);
	}
	
	
	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		// Cities have properties: "name" (city name), "country" (country name)
		// and "population" (population, in millions)
	}

	
	
	/* Local getters for some city properties.  
	 */
	public String getCity()
	{
		return getStringProperty("name");
	}
	
	public String getCountry()
	{
		return getStringProperty("country");
	}
	
	public float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		// Save previous drawing style
				pg.pushStyle();

				// IMPLEMENT: drawing triangle for each city
				pg.fill(150, 30, 30);
				pg.triangle(x, y-TRI_SIZE, x-TRI_SIZE, y+TRI_SIZE, x+TRI_SIZE, y+TRI_SIZE);

				// Restore previous drawing style
				pg.popStyle();
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		String cityText  = getCity()+", " + getCountry()+ "\nPop: "+getPopulation()+"Million";
		pg.fill(0);
		pg.text(cityText, x, y);	
	}

	@Override
	public void dontShowConnectingLines(PGraphics pg, float x, float y) {
		// TODO Auto-generated method stub

	}


	@Override
	public void showConnectingLines(PGraphics pg, float x, float y) {
		// TODO Auto-generated method stub

	}


	@Override
	public void showConnectingLinesFromCity(PGraphics pg, float x, float y, float x2, float y2) {
		pg.fill(0);
//		System.out.println("want to draw a line2");
		pg.line(x, y,x2,y2);

	}
	
}
