package dacn.com.tour.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTour;

    String titleTour;
    double price;
    double sale;

    Timestamp departureDate;// ngay khoi hanh
    String description;
    String address;
    String duration;// for instance: 1 ngay mot dem

    String type;

    Long tagId;
    Long serviceId;

    int views;
    int votes;
    int purchaseCount;

    String statusAction;

    @CreationTimestamp
    Timestamp dateAdded;

    @UpdateTimestamp
    @Column(updatable = false)
    Timestamp dateEdited;
    Timestamp dateDeleted;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Booking> bookings = new HashSet<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setTour(this);
    }
}
