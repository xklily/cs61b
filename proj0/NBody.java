
public class NBody {

    public static String back="images/starfield.jpg";
 
	public static double readRadius(String filename)
	{
		In in=new In(filename);
		int num=in.readInt();
		return in.readDouble();
	}

    public static Planet[] readPlanets(String filename)
    {
    	In in=new In(filename);
    	Planet[] p= new Planet[5];
    	in.readInt();
    	in.readDouble();
    	for(int i=0;!in.isEmpty();i++)
    	{
    		p[i]=new Planet(0,0,0,0,0,"a");
    		p[i].xxPos=in.readDouble();
    		p[i].yyPos=in.readDouble();
    		p[i].xxVel=in.readDouble();
    		p[i].yyVel=in.readDouble();
    		p[i].mass=in.readDouble();
    		p[i].imgFileName=in.readString();
    	}
    	return p;
    }

    public static void main(String[] args) 
    {
    	int i;
    	double T=Double.parseDouble(args[0]);
    	double dt=Double.parseDouble(args[1]);
    	String filename=args[2];
    	double r=readRadius(filename);
    	Planet[] p=readPlanets(filename);
    	StdDraw.setXscale(-r, r);
    	StdDraw.setYscale(-r, r);
    	double t;
    	for(t=0.0;t<T;t+=dt)
    	{
    		StdDraw.enableDoubleBuffering();
    		StdDraw.clear();
    	    StdDraw.picture(0, 0, back);
    		double[] xForces=new double[]{0,0,0,0,0};
    		double[] yForces=new double[]{0,0,0,0,0};
    		for(i=0;i<5;i++)
    		{
    			xForces[i]=p[i].calcNetForceExertedByX(p);
    			yForces[i]=p[i].calcNetForceExertedByY(p);
    		}
    		for(i=0;i<5;i++)
    		{
    			p[i].update(dt,xForces[i],yForces[i]);
    			p[i].draw();
    		}
    		StdDraw.show();
			StdDraw.pause(10);
    	}


    }
}