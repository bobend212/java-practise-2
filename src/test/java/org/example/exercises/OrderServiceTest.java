//package org.example.exercises;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.UUID;
//
//class OrderServiceTest {
//
//    @Test
//    void shouldSaveConsents() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Hard.ConsentResponse> consentsRequest = List.of(Hard.ConsentResponse.builder()
//                .consentId(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .accepted(true)
//                .build(),
//                Hard.ConsentResponse.builder()
//                .consentId(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .accepted(true)
//                .build()
//        );
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(true)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//        Mockito.when(orderRepository.createConsents(cartId, consentsRequest)).thenReturn(Mono.just(cartId));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectAccessibleContext()
//            .then()
//            .expectNext(cartId)
//            .verifyComplete();
//    }
//
//    @Test
//    void shouldThrowExceptionWhenRequiredButAcceptedIsFalse() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Consent> consentsRequest = List.of(Consent.builder()
//                .consentId(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .accepted(true)
//                .build(),
//            Consent.builder()
//                .consentId(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .accepted(false)
//                .build()
//        );
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(true)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                throwable.getMessage().equals("Invalid consents"))
//            .verify();
//    }
//
//    @Test
//    void shouldSaveWhenNotRequiredConsentsAndAcceptedFalse() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Consent> consentsRequest = List.of(Consent.builder()
//                .consentId(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .accepted(true)
//                .build(),
//            Consent.builder()
//                .consentId(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .accepted(false)
//                .build()
//        );
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(false)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//        Mockito.when(orderRepository.createConsents(cartId, consentsRequest)).thenReturn(Mono.just(cartId));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectAccessibleContext()
//            .then()
//            .expectNext(cartId)
//            .verifyComplete();
//    }
//
//    @Test
//    void shouldSaveWhenNotRequiredConsentsAndAcceptedIsNull() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Consent> consentsRequest = List.of(Consent.builder()
//                .consentId(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .accepted(true)
//                .build(),
//            Consent.builder()
//                .consentId(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .accepted(null)
//                .build()
//        );
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(false)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//        Mockito.when(orderRepository.createConsents(cartId, consentsRequest)).thenReturn(Mono.just(cartId));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectAccessibleContext()
//            .then()
//            .expectNext(cartId)
//            .verifyComplete();
//    }
//
//    @Test
//    void shouldThrowExceptionWhenNoConsents() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Consent> consentsRequest = List.of();
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(true)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                throwable.getMessage().equals("Invalid consents"))
//            .verify();
//    }
//
//    @Test
//    void shouldThrowExceptionWhenReceiveConsentsWhichNotExist() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Consent> consentsRequest = List.of(Consent.builder()
//                .consentId(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .accepted(true)
//                .build(),
//            Consent.builder()
//                .consentId(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .accepted(true)
//                .build(),
//            Consent.builder()
//                .consentId(UUID.fromString("f9f132b7-a22d-47bb-a446-2f97dc706c99"))
//                .accepted(true)
//                .build()
//        );
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(true)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectErrorMatches(throwable -> throwable instanceof RuntimeException &&
//                throwable.getMessage().equals("Invalid consents"))
//            .verify();
//    }
//
//    @Test
//    void shouldSaveConsentsWhenReceiveMoreConsentsThenFromRequest() {
//        //given
//        final UUID cartId = UUID.randomUUID();
//        final List<Consent> consentsRequest = List.of(Consent.builder()
//                .consentId(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .accepted(true)
//                .build(),
//            Consent.builder()
//                .consentId(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .accepted(true)
//                .build()
//        );
//
//        final List<ConsentResponse> consentResponse = List.of(
//            new ConsentResponse()
//                .id(UUID.fromString("d7de42de-9d78-4856-af33-3a34558e404a"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("ca657b33-e5e3-4267-9e9f-dddf4c00e558"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("f9f132b7-a22d-47bb-a446-2f97dc706c99"))
//                .required(true),
//            new ConsentResponse()
//                .id(UUID.fromString("151a85b5-4390-48f8-89b8-e0e3caa84f3c"))
//                .required(true)
//        );
//
//        //when
//        Mockito.when(consentService.getConsents()).thenReturn(Flux.fromIterable(consentResponse));
//        Mockito.when(orderRepository.createConsents(cartId, consentsRequest)).thenReturn(Mono.just(cartId));
//
//        //then
//        StepVerifier.create(orderService.createConsents(cartId, consentsRequest))
//            .expectAccessibleContext()
//            .then()
//            .expectNext(cartId)
//            .verifyComplete();
//    }
//}