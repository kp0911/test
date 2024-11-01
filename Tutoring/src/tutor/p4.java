package tutor;

class TimeOverException extends Exception{}

class Movie{
	String place;
	Movie(String p){
		this.place = p;
	}
	synchronized void screen(String maker, String name, int time)throws TimeOverException {
		if(time <= 120)
			System.out.println(place+"에서 "+maker+"제작사의 "+name+"이(가) 상영 중 입니다. 런타임: "+time+"분");
		else
			throw new TimeOverException();
	}
}

class Movie_m extends Thread{
	Movie movie;
	String maker, name;
	int time;
	Movie_m(Movie m, String maker, String name, int time){
		this.maker = maker;
		this.name = name;
		this.time = time;
		movie = m;
	}
	
	public void run()  {
		 try {
	            movie.screen(maker, name, time);
	        } catch (TimeOverException e) {
	            System.out.println(maker+"제작사의 "+name+"의 상영시간이 2시간을 넘어 상영 불가합니다.");
	        }
	}
}

public class p4 {

	public static void main(String[] args) {
		Movie m = new Movie("명지");
		Movie_m m1 = new Movie_m(m,"A","컨저링",112);
		Movie_m m2 = new Movie_m(m,"B","아바타",192);
		Movie_m m3 = new Movie_m(m,"C","어바웃 타임",120);
		System.out.print("asd");
		
		m1.start();
		m2.start();
		m3.start();
	}

}
