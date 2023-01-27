package org.example.exercises;

import java.util.List;

import org.example.exercises.Hard.ConsentRequest;
import org.example.exercises.Hard.ConsentResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HardTest {

    @Test
    void shouldReturnTrueWhenConsentsAreValid() {
        // given
        Hard hard = new Hard();
        List<ConsentResponse> response = List.of(
                new ConsentResponse(1L, true),
                new ConsentResponse(2L, true));

        List<ConsentRequest> request = List.of(
                new ConsentRequest(1L, true),
                new ConsentRequest(2L, true));

        Assertions.assertTrue(hard.areConsentsValid(request, response));
    }

    @Test
    void shouldReturnFalseWhenConsentsAreNotValid() {
        // given
        Hard hard = new Hard();
        List<ConsentResponse> response = List.of(
                new ConsentResponse(1L, true),
                new ConsentResponse(2L, true));

        List<ConsentRequest> request = List.of(
                new ConsentRequest(1L, false),
                new ConsentRequest(2L, true));

        Assertions.assertFalse(hard.areConsentsValid(request, response));
    }

    @Test
    void shouldReturnFalseWhenRequestListIsEmpty() {
        // given
        Hard hard = new Hard();
        List<ConsentResponse> response = List.of(
                new ConsentResponse(1L, true),
                new ConsentResponse(2L, true));

        List<ConsentRequest> request = List.of();

        Assertions.assertFalse(hard.areConsentsValid(request, response));
    }

}
