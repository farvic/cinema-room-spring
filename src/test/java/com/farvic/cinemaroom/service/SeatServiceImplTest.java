package com.farvic.cinemaroom.service;

import com.farvic.cinemaroom.domain.Order;
import com.farvic.cinemaroom.domain.Seat;
import com.farvic.cinemaroom.domain.Token;
import com.farvic.cinemaroom.errors.OrderException;
import com.farvic.cinemaroom.repositories.CinemaRepository;
import com.farvic.cinemaroom.repositories.OrderRepository;
import com.farvic.cinemaroom.repositories.SeatRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeatServiceImplTest {

    @Mock
    private CinemaRepository mockCinemaRepository;
    @Mock
    private SeatRepository mockSeatRepository;

    @Mock
    private OrderRepository mockOrderRepository;

    @InjectMocks
    private SeatServiceImpl seatServiceImplUnderTest;

    @Test
    void testGetAllSeats() {
        // Setup
        Seat seat = new Seat(0, 0, 0, true);
        when(mockCinemaRepository.existsById(1)).thenReturn(true);
        when(mockSeatRepository.findByCinemaId(1)).thenReturn(List.of(seat));

        // Run the test
        final List<Seat> result = seatServiceImplUnderTest.getAllSeats();

        // Verify the results
        assertThat(result).isEqualTo(List.of(seat));
    }

    @Test
    void testPurchaseSeat() {
        // Setup
        final Seat seat = new Seat(0, 0, 0, 0, true);
        when(mockSeatRepository.findByRowAndColumn(0, 0)).thenReturn(Optional.of(new Seat(0, 0, 0, 0, true)));
        when(mockSeatRepository.save(any(Seat.class))).thenReturn(new Seat(0, 0, 0, 0, true));

        // Run the test
        final Order result = seatServiceImplUnderTest.purchaseSeat(seat);

        // Verify the results
        verify(mockSeatRepository).save(any(Seat.class));
        assertFalse(result.getToken().isEmpty());
        assertFalse(result.getTicket().isAvailable());

    }

    @Test
    void testPurchaseSeat_SeatRepositoryFindByRowAndColumnReturnsAbsent() {
        // Setup
        final Seat seat = new Seat(0, 0, 0, 0, false);
        when(mockSeatRepository.findByRowAndColumn(0, 0)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> seatServiceImplUnderTest.purchaseSeat(seat)).isInstanceOf(OrderException.class);
    }

    @Test
    void testRefundTicket() {
        // Setup
        final Token token = new Token("token");
        final Seat seat = new Seat(0, 0, 0, 0, false);
        final Order order = new Order("token", seat, true);

        when(mockOrderRepository.findByToken("token")).thenReturn(order);

        // Run the test
        final Order result = seatServiceImplUnderTest.refundTicket(token);

        // Verify the results
        verify(mockSeatRepository).save(any(Seat.class));
        assertTrue(result.getTicket().isAvailable());
    }

    @Test
    void testGetAllSeatsReturnsException() throws ResourceNotFoundException {
        // Setup
        when(mockCinemaRepository.existsById(1)).thenReturn(false);

        // Run the test and verify through the .instanceOf() and .hasMessage() methods
        assertThatThrownBy(() -> seatServiceImplUnderTest.getAllSeats())
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("The cinema is closed");
    }

    @Test
    void testGetSeatByRowAndColumn() {
        // Setup
        final Seat seat = new Seat(0, 0, 0, false);
        when(mockSeatRepository.findByRowAndColumn(0, 0)).thenReturn(Optional.of(new Seat(0, 0, 0, false)));

        // Run the test
        final Seat result = seatServiceImplUnderTest.getSeatByRowAndColumn(seat);

        // Verify the results
    }

    @Test
    void testGetSeatByRowAndColumn_SeatRepositoryReturnsAbsent() {
        // Setup
        final Seat seat = new Seat(0, 0, 0, false);
        when(mockSeatRepository.findByRowAndColumn(0, 0)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> seatServiceImplUnderTest.getSeatByRowAndColumn(seat))
                .isInstanceOf(OrderException.class);
    }
}
