package com.shepherdmoney.interviewproject.controller;

import com.shepherdmoney.interviewproject.vo.request.AddCreditCardToUserPayload;
import com.shepherdmoney.interviewproject.vo.response.CreditCardView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/credit-card")
    public ResponseEntity<Integer> addCreditCardToUser(@RequestBody AddCreditCardToUserPayload payload) {
        CreditCard creditCard = new CreditCard(payload.getNumber(), payload.getExpiration(), payload.getCvv());
        Optional<User> user = userRepository.findById(payload.getUserId());
        if (user.isPresent()) {
            creditCard.setUser(user.get());
            creditCardRepository.save(creditCard);
            return ResponseEntity.ok(creditCard.getId());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/credit-card:all")
    public ResponseEntity<List<CreditCardView>> getAllCardOfUser(@RequestParam int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<CreditCardView> creditCardViews = user.get().getCreditCards().stream()
                    .map(CreditCardView::fromCreditCard)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(creditCardViews);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }

    }

    @GetMapping("/credit-card:user-id")
    public ResponseEntity<Integer> getUserIdForCreditCard(@RequestParam String creditCardNumber) {
        Optional<CreditCard> creditCard = creditCardRepository.findByNumber(creditCardNumber);
        if (creditCard.isPresent()) {
            return ResponseEntity.ok(creditCard.get().getUser().getId());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
