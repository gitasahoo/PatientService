package wfc.demo.ps.controller;

import java.util.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import wfc.demo.ps.proxy.VolunteerServiceProxy;

@RestController
public class PatientController {

	@Autowired
	protected RestTemplate restTemplate;
	
	@Value("${services.volunteer.url}")
	protected String serviceurl;// = "http://VOLUNTEERSERVICE/vs";

	protected VolunteerServiceProxy proxy;

	@Autowired
	public PatientController(VolunteerServiceProxy proxy) {
		super();
		this.proxy = proxy;
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World from Patient service";
	}

	@RequestMapping(value = "/volunteers/{aidname}", method = RequestMethod.GET)
	public List<String> listVolunteers(@PathVariable("aidname") String aidname) {

		System.out.println("listVolunteers via RestTemplate");

		String[] volnames = restTemplate.getForObject(serviceurl + "/volunteers/{servicename}", String[].class,
				aidname);

		List<String> volunteers = Arrays.asList(volnames);
		return volunteers;

		// return new ArrayList<String>();
	}

	@RequestMapping(value = "/volunteernames/{aidname}", method = RequestMethod.GET)
	public List<String> listVolunteernames(@PathVariable("aidname") String aidname) {

		System.out.println("listVolunteers via Feign");

		List<String> volunteers = proxy.getVolunteers(aidname);

		System.out.println("volunteer size" + volunteers.size());
		// List<String> volunteers = Arrays.asList(volnames);
		return volunteers;

		// return new ArrayList<String>();
	}
}
