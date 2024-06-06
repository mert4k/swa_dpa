package mmd.assignment.dpa_backend.service;

import mmd.assignment.dpa_backend.dto.SubscriberDto;

import java.util.List;

public interface SubscriberService {
    SubscriberDto createSubscriber(SubscriberDto subscriberDto);

    SubscriberDto getSubscriberById(long subscriberId);

    List<SubscriberDto> getAllSubscribers();

    SubscriberDto updateSubscriber(Long subscriberId, SubscriberDto updatedSubscriber);

    void deleteSubscriber(Long subscriberId);
}
