package design.pattern.Facade;

import design.pattern.Facade.facadeservice.HomeTheaterFacade;
import design.pattern.Facade.media.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacadeApplication {

    public static void main(String[] args) {

        SpringApplication.run(FacadeApplication.class, args);
        Amplifier amp = new Amplifier("Amplifier");
        Tuner tuner = new Tuner("Tuner", amp);
        DvdPlayer dvd = new DvdPlayer(" DVD Player", amp);
        CdPlayer cd = new CdPlayer("CD Player", amp);
        Projector projector = new Projector(" Projector", dvd);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        HomeTheaterFacade homeTheater =
                new HomeTheaterFacade(amp, tuner, dvd, cd,
                        projector, screen, lights, popper);

        homeTheater.watchMovie("OnePiece:Stampede");
        homeTheater.endMovie();
        System.out.println("---------------------------------------------");
        homeTheater.listenToCd("Gao Ranger");
        homeTheater.endCd();
    }

}
