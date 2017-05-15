package com.synacy.moviehouse.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by michael on 5/15/17.
 */
@RestController
@RequestMapping(value = "/api/v1/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Schedule> fetchAllSchedules(Pageable pageable,
                                            @RequestParam(value = "date", required = false) String date) {

        return scheduleService.fetchAllSchedules(pageable, date);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule createSchedule(@RequestBody Schedule scheduleRequest) {

        return scheduleService.createSchedule(scheduleRequest.getStartDateTime(),
                scheduleRequest.getEndDateTime(),
                scheduleRequest.getMovie(),
                scheduleRequest.getCinema());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{scheduleId}")
    public Schedule fetchScheduleById(@PathVariable(value = "scheduleId") Long scheduleId) {
        return scheduleService.fetchScheduleById(scheduleId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{scheduleId}")
    public Schedule updateSchedule(@PathVariable(value = "scheduleId")Long scheduleId,
                                   @RequestBody Schedule scheduleRequest) {
        return scheduleService.updateSchedule(scheduleId, scheduleRequest.getStartDateTime(),
                scheduleRequest.getEndDateTime(), scheduleRequest.getMovie(), scheduleRequest.getCinema());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{scheduleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScheduleById(@PathVariable(value = "scheduleId") Long scheduleId) {
        scheduleService.deleteScheduleById(scheduleId);
    }
}