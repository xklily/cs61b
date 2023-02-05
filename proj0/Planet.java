
public class Planet {
	
	  public double xxPos;
		public double yyPos;
		public double xxVel;
		public double yyVel;
		public double mass;
		public String imgFileName;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img)
	{
	    xxPos = xP;
		yyPos = yP;
		mass = m;
		yyVel = yV;
		xxVel = xV;
		imgFileName = img;
	}

	public Planet(Planet p)
	{
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p)
	{
		double dis2;
		dis2 = (xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos);
		return Math.sqrt(dis2);

	}

	public double calcForceExertedBy(Planet p)
	{
		double dis = calcDistance(p);
		double GMm = 6.67*0.00000000001*mass*p.mass;
		return GMm/(dis*dis);
	}

	public double calcForceExertedByX(Planet p)
	{
		double fx = calcForceExertedBy(p)*(xxPos-p.xxPos)/calcDistance(p);
		if(this.equals(p))
 		{
 			return 0;
 		}
		else
		{
			return fx;
		}

	}

 	public double calcForceExertedByY(Planet p)
 	{
 		double fy = calcForceExertedBy(p)*(yyPos-p.yyPos)/calcDistance(p);
 		if(this.equals(p))
 		{
 			return 0;
 		}
 		else
 		{
 			return -fy;
 		}

 	}

    public double calcNetForceExertedByX(Planet[] p)
    {
    	double fx=0;
    	for(int i=0;i<p.length;i++)
    	{
    		fx+=calcForceExertedByX(p[i]);
    	}
    	return fx;
    }

    public double calcNetForceExertedByY(Planet[] p)
    {
    	double fy=0;
    	for(int i=0;i<p.length;i++)
    	{
    		fy+=calcForceExertedByY(p[i]);
    	}
    	return fy;
    }

    public void update(double dt,double fx,double fy)
    {
    	double ax,ay;
    	ax=fx/mass;
    	ay=fy/mass;
    	xxVel=xxVel+dt*ax;
    	yyVel=yyVel+dt*ay;
        xxPos=xxPos+xxVel*dt;
        yyPos=yyPos+yyVel*dt;
    }
    
    public void draw()
    {
    	StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}