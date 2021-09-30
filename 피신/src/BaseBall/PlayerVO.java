package BaseBall;

public class PlayerVO {
	protected String id;
	protected String name;
	protected String team;
	protected int pa;
	protected int single;
	protected int doubl;
	protected int triple;
	protected int hr;
	protected int bb;
	protected int hbp;
	protected int so;
	protected int gt;
	protected int fly;
	protected int sb;
	protected int sbf;
	
	
	
	
	public PlayerVO(String id, String name, String team, int pa, int single, int doubl, int triple, int hr, int bb,
			int hbp, int so, int gt, int fly, int sb, int sbf) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
		this.pa = pa;
		this.single = single;
		this.doubl = doubl;
		this.triple = triple;
		this.hr = hr;
		this.bb = bb;
		this.hbp = hbp;
		this.so = so;
		this.gt = gt;
		this.fly = fly;
		this.sb = sb;
		this.sbf = sbf;
	}
	public PlayerVO() {};
	
	void print() {
		System.out.print("  急荐 捞抚: " + name);
		System.out.print("  1风鸥 己利: " + (double)(single*1000/pa)/1000);
		System.out.print("  2风鸥 己牞: " + (double)  (doubl*1000/pa)  /1000);
		System.out.print("  3风鸥 己利: " + (double)  (triple*1000/pa)  /1000);
		System.out.println();
		System.out.print("  权繁 己利: " + (double)  (hr*1000/pa)  /1000);
		System.out.print("  杭齿 己利: " + (double)  (bb*1000/pa) /1000);
		System.out.print("  荤备 己利: " + (double)  (hbp*1000/pa)  /1000);
		System.out.print("  伙柳 己利: " + (double)  (so*1000/pa) /1000);
		System.out.println();
		System.out.print("  捍混 己利: " + (double)(gt*1000 /pa) /1000);
		System.out.print("  敲扼捞酒眶 己利: " + (double)(fly*1000 /pa) /1000);
		System.out.print("  档风 己利: " + (double)(sb*1000/pa) /1000);
		System.out.print("  档角 己利: " + (double)(sbf*1000 /pa) /1000);
		System.out.println();
	}
	
	public int getPa() {
		return pa;
	}
	public void setPa(int pa) {
		this.pa = pa;
	}
	public int getSingle() {
		return single;
	}
	public void setSingle(int single) {
		this.single = single;
	}
	public int getDoubl() {
		return doubl;
	}
	public void setDoubl(int doubl) {
		this.doubl = doubl;
	}
	public int getTriple() {
		return triple;
	}
	public void setTriple(int triple) {
		this.triple = triple;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getBb() {
		return bb;
	}
	public void setBb(int bb) {
		this.bb = bb;
	}
	public int getHbp() {
		return hbp;
	}
	public void setHbp(int hbp) {
		this.hbp = hbp;
	}
	public int getSo() {
		return so;
	}
	public void setSo(int so) {
		this.so = so;
	}
	public int getGt() {
		return gt;
	}
	public void setGt(int gt) {
		this.gt = gt;
	}
	public int getFly() {
		return fly;
	}
	public void setFly(int fly) {
		this.fly = fly;
	}
	public int getSb() {
		return sb;
	}
	public void setSb(int sb) {
		this.sb = sb;
	}
	public int getSbf() {
		return sbf;
	}
	public void setSbf(int sbf) {
		this.sbf = sbf;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	
	
	

}
