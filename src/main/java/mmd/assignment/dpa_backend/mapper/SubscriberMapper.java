package mmd.assignment.dpa_backend.mapper;

import mmd.assignment.dpa_backend.dto.SubscriberDto;
import mmd.assignment.dpa_backend.entity.Subscriber;

public class SubscriberMapper {
    public static SubscriberDto mapToSubscriberDto(Subscriber subscriber) {
        return new SubscriberDto(
                subscriber.getId(),
                subscriber.getName(),
                subscriber.getMsisdn(),
                subscriber.getStatus()
        );
    }

    public static Subscriber mapToSubscriber(SubscriberDto subscriberDto) {
        return new Subscriber(
                subscriberDto.getId(),
                subscriberDto.getName(),
                subscriberDto.getMsisdn(),
                subscriberDto.getStatus()
        );
    }
}
