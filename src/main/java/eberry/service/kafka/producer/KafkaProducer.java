package eberry.service.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eberry.service.kafka.constant.ApplicationConstant;
import eberry.service.kafka.model.Student;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@PostMapping("/message")
	public String sendMessage(@RequestBody Student message) {

		try {
			kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json message sent succuessfully";
	}

}
