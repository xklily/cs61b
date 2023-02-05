
public class NBody {

    private static String back="images/starfield.jpg";
 
	public static double readRadius(String filename)
	{
		In in=new In(filename);
		int num=in.readInt();
		return in.readDouble();
	}

    public static Planet[] readPlanets(String filename)
    {
    	int num;
    	In in=new In(filename);
    	num=in.readInt();
    	Planet[] p= new Planet[num];
    	in.readDouble();
    	for(int i=0;i<p.length;i++)
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
    	double radius=readRadius(filename);
    	Planet[] planets=readPlanets(filename);
    	StdDraw.setXscale(-radius, radius);
    	StdDraw.setYscale(-radius, radius);
    	double t;
    	for(t=0.0;t<T;t+=dt)
    	{
    		StdDraw.enableDoubleBuffering();
    		StdDraw.clear();
    	    StdDraw.picture(0, 0, back);
    		double[] xForces=new double[planets.length];
    		double[] yForces=new double[planets.length];
    		for(i=0;i<planets.length;i++)
    		{
    			xForces[i]=planets[i].calcNetForceExertedByX(planets);
    			yForces[i]=planets[i].calcNetForceExertedByY(planets);
    		}
    		for(i=0;i<planets.length;i++)
    		{
    			planets[i].update(dt,xForces[i],yForces[i]);
    			planets[i].draw();
    		}
    		StdDraw.show();
			StdDraw.pause(10);
    	}
    	StdDraw.clear();
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (i = 0; i < planets.length; i++)
         {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName); 
         }

    }
}