package org.example.exercises;

import java.util.List;

public class Hard {
    /*
    Mamy serwis A, który pobiera wszystkie mozliwe zgody marketingowe
    czyli zwraca on List<ConsentResponse>

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

    class Consent {
        public Long id;
        public Boolean required;

        public Consent(final Long id, final Boolean required) {
            this.id = id;
            this.required = required;
        }
    }

    class ConsentRequest {
        public Long id;
        public Boolean accepted;

        public ConsentRequest(final Long id, final Boolean accepted) {
            this.id = id;
            this.accepted = accepted;
        }
    }

    Boolean areConsentsValid(List<ConsentRequest> consentRequests, List<Consent> consents) {


        return null;
    }
}
