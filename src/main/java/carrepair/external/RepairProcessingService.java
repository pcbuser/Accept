
package carrepair.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */

//@FeignClient(name="Repair", url="http://localhost:8082")
  @FeignClient(name="Repair", url="http://repairprocessings:8080")
public interface RepairProcessingService {

    //@RequestMapping(method= RequestMethod.PATCH, path="/repairProcessings")
    @RequestMapping(method= RequestMethod.PATCH, path="/cancel")
    public void repairCancel(@RequestBody RepairProcessing repairProcessing);

}