package pluralsight.airportmanagement;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.airportmanagement.domain.FlightInformation;
import pluralsight.airportmanagement.domain.FlightPrinter;
import pluralsight.airportmanagement.queries.FlightInformationQueries;

/*
In Spring Boot, a class that implements CommandLineRunner
is executed after the application is bootstrapped
 */

@Component
public class ApplicationRunner implements CommandLineRunner {

    private FlightInformationQueries flightInformationQueries;

    public ApplicationRunner(FlightInformationQueries flightInformationQueries) {
        this.flightInformationQueries = flightInformationQueries;
    }

    @Override
    public void run(String... args) {
    	System.out.print("-----\nQuery: All flights ordered by departure");
    	List<FlightInformation> allFlightsOrdered = this.flightInformationQueries
    			.findAll("departure", 0, 10);
    	FlightPrinter.print(allFlightsOrdered);
    	
    	System.out.print("-----\nQuery: Free text search: Rome");
    	List<FlightInformation> flightsByFreeText = this.flightInformationQueries
    			.findByFreeText("Rome");
    	FlightPrinter.print(flightsByFreeText);     
    }
}

