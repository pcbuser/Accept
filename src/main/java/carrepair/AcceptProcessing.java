package carrepair;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="AcceptProcessing_table")
public class AcceptProcessing {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String carno;
    private String carname;
    private String ownername;
    private String reqcontents;
    private String status;

    @PostPersist
    public void onPostPersist(){
        AcceptPlaced acceptPlaced = new AcceptPlaced();
        BeanUtils.copyProperties(this, acceptPlaced);
        acceptPlaced.publish();

    }
    @PostUpdate
    public void onPostUpdate(){
        AcceptCanceled acceptCanceled = new AcceptCanceled();
        BeanUtils.copyProperties(this, acceptCanceled);
        acceptCanceled.publish();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.



        carrepair.external.RepairProcessing repairProcessing = new carrepair.external.RepairProcessing();
        // mappings goes here

        //repairProcessing.setAcceptid(this.getId());
        repairProcessing.setAcceptid(repairProcessing.getId());
        repairProcessing.setStatus("99");



        Application.applicationContext.getBean(carrepair.external.RepairProcessingService.class)
                .repairCancel(repairProcessing);


    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }
    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }
    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }
    public String getReqcontents() {
        return reqcontents;
    }

    public void setReqcontents(String reqcontents) {
        this.reqcontents = reqcontents;
    }




}
