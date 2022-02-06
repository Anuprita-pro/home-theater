import java.util.*;
package headfirst.facade.hometheater;

  public class HomeTheaterFacade
{
  Amplifier amp;
  Tuner tuner;
  DvdPlayer dvd;
  CdPlayer cd;
  Projector projector;
  TheaterLights lights;
  Screen screen;
  PopcornPopper popper;

  public HomeTheaterFacade(Amplifier amp,
                           Tuner tuner,
			   DvdPlayer dvd,
  			   CdPlayer cd,
 		           Projector projector,
  			   TheaterLights lights,
 			   Screen screen,
  			   PopcornPopper popper)
          {
 		this.amp=amp;
                this.tuner=tuner;
		this.dvd=dvd;
		this.cd=cd;
		this.projector=projector;
		this.screen=screen;
		this.lights=lights;
		this.popper=popper;
	}
    
     public void watchMovie(String movie)
 {
    System.out.println("Get ready to watch a movie.....");
        popper.on();
	popper.pop();
	lights.dim(10);
	screen.down();
	projector.on();
	projector.wideScreenMode();
	amp.on();
	amp.setDvd(dvd);
	amp.setSurroundSound();
	amp.setVolume(5);
	dvd.on();
	dvd.play(movie);
 }

      public void endMovie()
 { 
     System.out.println("Shutting movie theater down.....");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
	dvd.off();
 }
    
    public void listenToCd(String cdTitle)
 {
    System.out.println("Get ready for an audiopile experience.....");
        lights.on();
        amp.on();
        amp.setVolume(5);
        amp.setCd(cd);
        amp.setSteroSound();
        cd.on();
        cd.play(cdTitle);
 }
  
   public void endCd()
{
   System.out.println("Shutting down CD.....");
        amp.off();
        amp.setCd(cd);
        cd.eject();
        cd.off();
 }

   public void listenToRadio(double frequency)
{
   System.out.println("Tuning in the airwaves.....");
        tuner.on();
        tuner.setFrequency(frequency);
        amp.on();
        amp.setVolumne(5);
        amp.setTuner(tuner);
}

     public void endRadio()
  {
     System.out.println("Shutting down the tuner.....");
         tuner.off();
         amp.off();
  }
}

   public class HomeTheaterTestDrive
{
     public static void main(String[] args)
 {
    Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner",amp);
    DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player",amp);
    CdPlayer cd = new CdPlayer("Top-O-Line Cd Player",amp);
    Projector projector = new Projector("Top-O-Line Projctor Player",dvd);
    TheaterLights lights = new TheaterLights("Top-O-Line TheaterLights Player",lights);
    Screen screen = new Screen("Theater Screen ");
    PopcornPopper popper = new PopcornPopper("Popcorn Popper");
    HomeTheaterFacade hometheater = new HomeTheaterFacade(amp,tuner,dvd,projector,screen,lights,popper);
    homeTheater.watchMovie("Raiders of the Lost Ark");
    homeTheater.endMovie();
  }
}




   
  
   
