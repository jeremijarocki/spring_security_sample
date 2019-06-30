package pl.jeremijarocki.spring_security_sample;

import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationApi {

    private List<Quotation> quotations;

    public QuotationApi() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("Ten tylko wart nazwy człowieka, który ma pewne przekonania i potrafi je bez względu na skutki wyznawać czynem.", "Józef Piłsudski"));
        quotations.add(new Quotation("Kobiety są w ogóle najgorliwszymi propagatorkami mego imienia i wpływu i jestem im niezmiernie wdzięczny za to, że tyle dobrego zrobiły przez swój bardzo ładny instynkt narodowy, który wykazały.", "Józef Piłsudski"));
        quotations.add(new Quotation("Panowie, ja widzę rzeczywistość taką, jaka ona jest. Wśród was kogoś takiego nie ma. Jeśli taki ktoś nie znajdzie się, Polski za 10 lat może nie być.", "Józef Piłsudski"));
        quotations.add(new Quotation("To, że milczę, nie znaczy, że nie mam nic do powiedzenia.", "Jonathan Carroll"));
        quotations.add(new Quotation("Książki są lustrem: widzisz w nich tylko to co, już masz w sobie.", "Carlos Ruiz Zafón"));
        quotations.add(new Quotation("Kocha się za nic. Nie istnieje żaden powód do miłości.", "Paulo Coelho"));
        quotations.add(new Quotation("Nie wiadomo, dlaczego wszyscy mówią do kotów „ty”, choć jako żywo żaden kot nigdy z nikim nie pił bruderszaftu.",  "Michail Bulhakov"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotation() {
        return quotations;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);
    }

    @DeleteMapping("/api")
    public void deleteQuotation (@RequestParam int index) {
        quotations.remove(index);
    }
}
