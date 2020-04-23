package carrepair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class AcceptProcessingController {

     @Autowired AcceptProcessingRepository acceptProcessingRepository;

/** @RequestMapping(value = "/",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8")

public void accept(HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        System.out.println("##### /acceptProcessing/accept  called #####");
        }

**/


     @RequestMapping(value = "/cancel",
             //method = RequestMethod.PATCH,
             method = RequestMethod.PATCH,
             produces = "application/json;charset=UTF-8")

     public void cancel(@RequestBody AcceptCanceled acceptCanceled) {
         AcceptProcessing acceptProcessing = new AcceptProcessing();

         //System.out.println("log2 : "+acceptCanceled.getId());
         acceptProcessing.setId(acceptCanceled.getId());
         acceptProcessing.setStatus(acceptCanceled.getStatus());



         acceptProcessingRepository.save(acceptProcessing);
         System.out.println("##### /acceptProcessing/cancel  called #####");
     }

     }
