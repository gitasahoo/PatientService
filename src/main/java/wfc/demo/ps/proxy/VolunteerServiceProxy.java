package wfc.demo.ps.proxy;

import java.util.Date;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



//@FeignClient(name="VolunteerService",  fallback = VolunteersReliable.class)
@FeignClient(name="VolunteerService/vs")
public interface VolunteerServiceProxy {
	
	@RequestMapping(value = "/volunteers/{servicename}", method = RequestMethod.GET )
    List<String> getVolunteers (@PathVariable("servicename") String servicename);


}
