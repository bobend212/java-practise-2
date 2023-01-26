package org.example.exercises;

import java.util.List;

/*
Mamy serwis A, który pobiera wszystkie mozliwe zgody marketingowe czyli zwraca on List<ConsentResponse>

ConsentResponse
    - id
    - required

Teraz nasz serwis B dostaje z frontu Liste zgód List<ConsentRequest>

ConsentRequest
    - consentId
    - accepted

Zadanie polega na walidacji zgód.
Walidacja polega na:
    - wszystkie zgody z frontu muszą sie zawierać w liscie, która pobieramy z serwisu A
    - jezeli zgoda jest required to z frontu musi przyjsc true w accepted
    - jezeli zgoda nie jest required moze tam byc null albo false

w tym przypadku request przyszedl ok poniewaz id z Y zawieraja sie w X oraz zgoda wymagana ma true i zgoda nie wymagana
false

np:
List<Consent> X = List.of(new Consent(1L, true), new Consent(2L, true));
List<ConsentRequest> Y = List.of(new ConsentRequest(1L, true), new ConsentRequest(2L, true));
powinno zwrocic true

List<Consent> X = List.of(new Consent(1L, false), new Consent(2L, true));
List<ConsentRequest> Y = List.of(new ConsentRequest(1L, true), new ConsentRequest(2L, true));
powinno zwrocic false

List<Consent> X = List.of(new Consent(1L, null), new Consent(2L, true));
List<ConsentRequest> Y = List.of(new ConsentRequest(1L, false), new ConsentRequest(2L, true));
powinno zwrocic true

List<Consent> X = List.of(new Consent(1L, false), new Consent(2L, true));
List<ConsentRequest> Y = List.of(new ConsentRequest(1L, false), new ConsentRequest(2L, true));
powinno zwrocic true
 */

public class Hard {

    public static class ConsentResponse {
        public Long id;
        public Boolean required;

        public ConsentResponse(final Long id, final Boolean required) {
            this.id = id;
            this.required = required;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Boolean getRequired() {
            return required;
        }

        public void setRequired(Boolean required) {
            this.required = required;
        }

        @Override
        public String toString() {
            return "ConsentResponse [id=" + id + ", required=" + required + "]";
        }

    }

    public static class ConsentRequest {
        public Long id;
        public Boolean accepted;

        public ConsentRequest(final Long id, final Boolean accepted) {
            this.id = id;
            this.accepted = accepted;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "ConsentRequest [id=" + id + ", accepted=" + accepted + "]";
        }

    }

    public Boolean areConsentsValid(List<ConsentRequest> consentsRequests, List<ConsentResponse> consentsResponse) {

        boolean isValid = false;
        var requestIds = consentsRequests.stream().map(ConsentRequest::getId).toList();
        var responseIds = consentsResponse.stream().map(ConsentResponse::getId).toList();

        // - wszystkie zgody z frontu muszą sie zawierać w liscie, która pobieramy z
        // serwisu A
        if (requestIds.containsAll(responseIds)) {
            isValid = true;
        } else {
            isValid = false;
        }

        var allRequiredRequests = consentsRequests.stream()
                .filter(requests -> consentsResponse.stream().anyMatch(one -> one.required.equals(requests.accepted)))
                .toList();

        // - jezeli zgoda jest required to z frontu musi przyjsc true w accepted
        if (allRequiredRequests.size() == consentsResponse.size()) {
            isValid = true;
        } else {
            isValid = false;
        }

        // - - jezeli zgoda nie jest required moze tam byc null albo false
        // nie czaje tego

        return isValid;
    }
}
