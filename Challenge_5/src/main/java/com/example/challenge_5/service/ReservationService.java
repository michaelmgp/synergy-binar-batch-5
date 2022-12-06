package com.example.challenge_5.service;
import com.example.challenge_5.model.*;
import com.example.challenge_5.model.dto.ReservationDTO;
import com.example.challenge_5.model.security.User;
import com.example.challenge_5.repositories.*;
import com.example.challenge_5.service.interfaces.BaseService;
import com.example.challenge_5.utils.Config;
import com.example.challenge_5.utils.MessageResponse;
import com.example.challenge_5.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService extends Response<String, String, Object > implements BaseService<Reservation> {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatReservedRepository seatReservedRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ScreeningReposiotry screeningReposiotry;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ReservationTypeRepository reservationTypeRepository;


    public Map saveReservation(ReservationDTO reservationDTO) {
        try {
            if(reservationDTO.getReservationType()==null){
                return sukses(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(reservationDTO.getUser()==null){
                return sukses(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            if(reservationDTO.getScreeningSet()==null){
                return sukses(Config.ERROR_400, new MessageResponse().getCannotNull(), null);
            }
            Reservation reservationSave = new Reservation();
            Set<Screening> screeningSet = new HashSet<>();
            Set<SeatReserved> seatReservedset = new HashSet<>();
            double totalReservationPrice = 0;
            for(Screening screeningRequest : reservationDTO.getScreeningSet()){
                Screening screening = screeningReposiotry.findById(screeningRequest.getId()).get();
//                        screeningRequest.getMovie().getId(),
//                        screeningRequest.getTheater().getId());

                screeningSet.add(screening);
                double moviePrice = screening.getMovie().getPrice();
                int numberSeatBooked = 0;
                for (Seat seatRequest : screeningRequest.getTheater().getSeats()){
                    Seat seat = seatRepository.findById(seatRequest.getId()).get();

                    seat.setActive(true);
                    numberSeatBooked+=1;

                    SeatReserved seatReserved = new SeatReserved();
                    seatReserved.setSeat(seat);
                    seatReservedset.add(seatReserved);
                }


                double totalMoviePrice = moviePrice*numberSeatBooked;
                totalReservationPrice+=totalMoviePrice;
            }
            reservationSave.setActive(true);
            reservationSave.setTotalPrice(totalReservationPrice);
            reservationSave.setScreenings(screeningSet);
            User customer = customerRepository.findById(reservationDTO.getUser().getId()).get();
            reservationSave.setUser(customer);
            ReservationType reservationType = reservationTypeRepository.findById(reservationDTO.getReservationType().getId()).get();
            reservationSave.setReservationType(reservationType);

            Reservation newReservation = reservationRepository.save(reservationSave);

            for(SeatReserved seatReserved : seatReservedset){
                seatReserved.setReservation(newReservation);
                seatReservedRepository.save(seatReserved);
            }
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesSave(), newReservation );
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);

        }
    }

    @Override
    public Map save(Reservation reservation) {
        return null;
    }

//    public Map getReservationDetail

    @Override
    public Map update(Reservation reservation) {
        try{
            if(!reservationRepository.existsById(reservation.getId())){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(reservation.getId()), null);
            }
            Reservation reservationUpdate = reservationRepository.findById(reservation.getId()).get();
            if(reservation.getReservationType()!=null){
                reservationUpdate.setReservationType(reservation.getReservationType());
            }
            if(reservation.getUser()!=null){
                reservationUpdate.setUser(reservation.getUser());
            }
            if(reservation.getScreenings()!=null){
                reservationUpdate.setScreenings(reservation.getScreenings());
            }
            reservationUpdate.setTotalPrice(reservation.getTotalPrice());
            reservationUpdate.setActive(reservation.isActive());
            reservationRepository.save(reservationUpdate);
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesUpdate(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map delete(long id) {
        try {
            if(!reservationRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            reservationRepository.deleteById(id);
            List<SeatReserved> seatReserveds = seatReservedRepository.findAllByReservationId(id);
            for(SeatReserved seatReserved : seatReserveds){
                seatReservedRepository.delete(seatReserved);
            }
            return sukses(Config.SUCCESS_200, new MessageResponse().getSuccesDelete(), null);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getAll() {
        try {
            return sukses(Config.SUCCESS_200, new MessageResponse("All Data Found").getMessage(), reservationRepository.findAll());
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }

    @Override
    public Map getOne(long id) {
        try {
            if(!reservationRepository.existsById(id)){
                return error(Config.ERROR_404, new MessageResponse().getErrorNotFound(id), null);
            }
            Reservation reservation = reservationRepository.findById(id).get();
//            List<SeatReserved> seatReserveds = seatReservedRepository.findAllByReservationId(id);
//            Set<Seat> seats = new HashSet<>();
//            for(SeatReserved seatReserved : seatReserveds){
//                seats.add(seatReserved.getSeat());
//            }
//
//            Set<Screening> screeningSet = reservation.getScreenings();
//            for (Screening screening : screeningSet){
//                Theater theater = theaterRepository.findById(screening.getId()).get();
//                theater.setSeats(seats);
//            }

            return sukses(Config.SUCCESS_200, new MessageResponse("Data Found").getMessage(), reservation);
        }catch (Exception e){
            return error(Config.ERROR_500, e.getMessage(), null);
        }
    }
}
