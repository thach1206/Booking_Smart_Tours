package dacn.com.tour.dto.response;

import dacn.com.tour.model.Account;
import dacn.com.tour.model.Tour;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class BookingResponse {
    Long idOrder;

    String PIN;
    String status;
    double totalPrice;

    String address;
    String phone;
    String email;
    String notes;
    String customerName;
    int adult;
    int children;
    String travelType;
    private String buyer;

    String statusAction;

    Timestamp dateAdded;
    Timestamp dateEdited;
    Timestamp dateDeleted;

    Account account;

    Tour tour;
}
