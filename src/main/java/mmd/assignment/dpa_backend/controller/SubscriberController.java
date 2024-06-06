package mmd.assignment.dpa_backend.controller;

import lombok.AllArgsConstructor;
import mmd.assignment.dpa_backend.dto.SubscriberDto;
import mmd.assignment.dpa_backend.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("subscriber")
public class SubscriberController {

    private SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity<SubscriberDto> createSubscriber(@RequestBody SubscriberDto subscriberDto) {
        SubscriberDto savedSubscriber = subscriberService.createSubscriber(subscriberDto);
        return new ResponseEntity<>(savedSubscriber, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<SubscriberDto> updateSubscriber(@PathVariable("id") Long subscriberId, @RequestBody SubscriberDto updatedSubscriber) {
        SubscriberDto updatedSubscriberObj = subscriberService.updateSubscriber(subscriberId, updatedSubscriber);
        return ResponseEntity.ok(updatedSubscriberObj);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> updateSubscriber(@PathVariable("id") Long subscriberId) {
        subscriberService.deleteSubscriber(subscriberId);
        return ResponseEntity.ok("Subscriber deleted successfully.");
    }

    @GetMapping("{id}")
    public ResponseEntity<SubscriberDto> getSubscriber(@PathVariable("id") Long subscriberId) {
        SubscriberDto subscriberDto = subscriberService.getSubscriberById(subscriberId);
        return new ResponseEntity<>(subscriberDto, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<List<SubscriberDto>> getAllSubscribers() {
        List<SubscriberDto> subscriberDtoList = subscriberService.getAllSubscribers();
        return new ResponseEntity<>(subscriberDtoList, HttpStatus.FOUND);
    }

}
