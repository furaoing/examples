import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;


/**
 * Created by rao on 16-10-31.
 */
public class JenaMain {
    public static void main(String args[]){
        // some definitions
        String personURI    = "http://somewhere/JohnSmith";
        String fullName     = "John Smith";

// create an empty Model
        Model model = ModelFactory.createDefaultModel();

// create the resource
        Resource johnSmith = model.createResource(personURI);

// add the property
        johnSmith.addProperty(VCARD.FN, fullName);
    }
}
