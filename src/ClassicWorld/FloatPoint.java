package ClassicWorld;

public class FloatPoint {
	float x;
	float y;
	
	public FloatPoint(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void change(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void changeX(float x) {
		change(x,this.y);
	}
	
	public void changeY(float y) {
		change(this.x,y);
	}
	
}
