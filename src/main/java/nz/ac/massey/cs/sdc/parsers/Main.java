package nz.ac.massey.cs.sdc.parsers;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

/*
Main Class 
*/
public class Main {
    /*
    Main entry point of program. This main method prints out list of all the 
    titles, links, and descriptions 
    */
    public static void main(String[] args) {
        try { 
		    JAXBContext jaxb_ctx = JAXBContext.newInstance("nz.ac.massey.cs.sdc.parsers");

            // Loading the nz_herald_file.xml file and unmarshalling it (can 
            // deserialise the xml stream and parse it as java objects) 
            Unmarshaller parser = jaxb_ctx.createUnmarshaller(); 
            File xml_file = new File("nz_herald_file.xml"); 

            // Get the Rss object 
            Rss rss = (Rss) parser.unmarshal(xml_file);

            // Get the RssChannel object of the Rss object 
            RssChannel rssChannel = (RssChannel) rss.getChannel(); 

            // Get the list of RssItems from the RssChannel 
            List<RssItem> rssItems = (List<RssItem>) rssChannel.getItem();


            // Iterate through the list of RssItems 
            for(RssItem rssItem : rssItems) {
                // Getting and printing out the title for the given RssItem 
                @SuppressWarnings("unchecked")
                JAXBElement<String> title = (JAXBElement<String>) rssItem.getTitleOrDescriptionOrLink().get(0);
                System.out.println("Title: " + title.getValue()); 

                // Getting and printing out the link for the given RssItem 
                @SuppressWarnings("unchecked")
                JAXBElement<String> link = (JAXBElement<String>) rssItem.getTitleOrDescriptionOrLink().get(1);
                System.out.println("Link: " + link.getValue()); 

                // Getting and printing out the description for the given RssItem 
                @SuppressWarnings("unchecked")
                JAXBElement<String> description = (JAXBElement<String>) rssItem.getTitleOrDescriptionOrLink().get(2);
                System.out.println("Description: " + description.getValue() + "\n"); 
            }
        }
        // Catching potential JAXBException error thrown by newInstance, 
        // createUnmarshaller, and unmarshall methods  
        catch(JAXBException jaxb_ex){ System.err.println(jaxb_ex.getMessage()); }
        // Catching any other exceptions 
        catch(Exception ex) { System.err.println(ex.getMessage()); }
    }
}
